package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final WeakValueReference<Object, Object, c> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient InternalEntryHelper<K, V, E, S> entryHelper;

    @NullableDecl
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;

    @NullableDecl
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;

    @NullableDecl
    transient Collection<V> values;

    public static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NullableDecl
        public final E f31783a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final K f6105a;

        public AbstractStrongKeyEntry(K k, int i, @NullableDecl E e) {
            this.f6105a = k;
            this.K = i;
            this.f31783a = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E a() {
            return this.f31783a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.K;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return this.f6105a;
        }
    }

    public static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NullableDecl
        public final E f31784a;

        public AbstractWeakKeyEntry(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl E e) {
            super(k, referenceQueue);
            this.K = i;
            this.f31784a = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E a() {
            return this.f31784a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.K;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return get();
        }
    }

    public abstract class HashIterator<T> implements Iterator<T> {
        public int K;
        public int L = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NullableDecl
        public E f31785a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public Segment<K, V, E, S> f6106a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public MapMakerInternalMap<K, V, E, S>.q f6107a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public AtomicReferenceArray<E> f6109a;

        @NullableDecl
        public MapMakerInternalMap<K, V, E, S>.q b;

        public HashIterator() {
            this.K = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        public final void a() {
            this.f6107a = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.K;
                if (i < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.K = i - 1;
                Segment<K, V, E, S> segment = segmentArr[i];
                this.f6106a = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f6106a.table;
                    this.f6109a = atomicReferenceArray;
                    this.L = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e) {
            Segment<K, V, E, S> segment;
            try {
                Object key = e.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e);
                if (liveValue == null) {
                    return false;
                }
                this.f6107a = new q(key, liveValue);
                return true;
            } finally {
                this.f6106a.postReadCleanup();
            }
        }

        public MapMakerInternalMap<K, V, E, S>.q c() {
            MapMakerInternalMap<K, V, E, S>.q qVar = this.f6107a;
            if (qVar == null) {
                throw new NoSuchElementException();
            }
            this.b = qVar;
            a();
            return this.b;
        }

        public boolean d() {
            E e = this.f31785a;
            if (e == null) {
                return false;
            }
            while (true) {
                this.f31785a = (E) e.a();
                E e2 = this.f31785a;
                if (e2 == null) {
                    return false;
                }
                if (b(e2)) {
                    return true;
                }
                e = this.f31785a;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.L;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f6109a;
                this.L = i - 1;
                E e = atomicReferenceArray.get(i);
                this.f31785a = e;
                if (e != null && (b(e) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6107a != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.a.e(this.b != null);
            MapMakerInternalMap.this.remove(this.b.getKey());
            this.b = null;
        }
    }

    public interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        E a();

        int getHash();

        K getKey();

        V getValue();
    }

    public interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        Strength a();

        S b(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        E c(S s, K k, int i, @NullableDecl E e);

        Strength d();

        E e(S s, E e, @NullableDecl E e2);

        void f(S s, E e, V v);
    }

    public static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        public SafeToArraySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        public /* synthetic */ SafeToArraySet(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, h<K>, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, h<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public h<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (h) internalEntry;
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, i<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, i<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public i<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (i) internalEntry;
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, j<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, j<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, j<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).c();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, j<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            return new p(this.queueForValues, v, castForTesting((InternalEntry) internalEntry));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            j<K, V> jVarCastForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = jVarCastForTesting.f31791a;
            jVarCastForTesting.f31791a = weakValueReference;
            weakValueReference2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public j<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (j) internalEntry;
        }
    }

    public interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, m<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (m) internalEntry;
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, n<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, n<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (n) internalEntry;
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, o<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, o<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, o<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).c();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, o<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            return new p(this.queueForValues, v, castForTesting((InternalEntry) internalEntry));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            o<K, V> oVarCastForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = oVarCastForTesting.f31797a;
            oVarCastForTesting.f31797a = weakValueReference;
            weakValueReference2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public o<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (o) internalEntry;
        }
    }

    public interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        void b();

        WeakValueReference<K, V, E> c();
    }

    public interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        E a();

        WeakValueReference<K, V, E> b(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        @NullableDecl
        V get();
    }

    public class a implements WeakValueReference<Object, Object, c> {
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public WeakValueReference<Object, Object, c> b(ReferenceQueue<Object> referenceQueue, c cVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public c a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public Object get() {
            return null;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> f31786a;

        public b(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.f31786a = new WeakReference<>(mapMakerInternalMap);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.f31786a.get();
            if (mapMakerInternalMap == null) {
                throw new CancellationException();
            }
            for (Segment<?, ?, E, S> segment : mapMakerInternalMap.segments) {
                segment.runCleanup();
            }
        }
    }

    public static final class c implements InternalEntry<Object, Object, c> {
        public c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public c a() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }
    }

    public final class d extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        public d(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class e extends SafeToArraySet<Map.Entry<K, V>> {
        public e() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public final class f extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        public f(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    public final class g extends SafeToArraySet<K> {
        public g() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new f(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public static final class h<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, h<K>> implements StrongValueEntry<K, MapMaker.Dummy, h<K>> {

        public static final class a<K> implements InternalEntryHelper<K, MapMaker.Dummy, h<K>, StrongKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f31789a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f31789a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public h<K> e(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, h<K> hVar, @NullableDecl h<K> hVar2) {
                return hVar.d(hVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public h<K> c(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k, int i, @NullableDecl h<K> hVar) {
                return new h<>(k, i, hVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, h<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void f(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, h<K> hVar, MapMaker.Dummy dummy) {
            }
        }

        public h(K k, int i, @NullableDecl h<K> hVar) {
            super(k, i, hVar);
        }

        public h<K> d(h<K> hVar) {
            return new h<>(((AbstractStrongKeyEntry) this).f6105a, this.K, hVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        public void f(MapMaker.Dummy dummy) {
        }
    }

    public static final class i<K, V> extends AbstractStrongKeyEntry<K, V, i<K, V>> implements StrongValueEntry<K, V, i<K, V>> {

        @NullableDecl
        public volatile V b;

        public static final class a<K, V> implements InternalEntryHelper<K, V, i<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f31790a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31790a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public i<K, V> e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, i<K, V> iVar, @NullableDecl i<K, V> iVar2) {
                return iVar.d(iVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public i<K, V> c(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i, @NullableDecl i<K, V> iVar) {
                return new i<>(k, i, iVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, i<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void f(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, i<K, V> iVar, V v) {
                iVar.e(v);
            }
        }

        public i(K k, int i, @NullableDecl i<K, V> iVar) {
            super(k, i, iVar);
            this.b = null;
        }

        public i<K, V> d(i<K, V> iVar) {
            i<K, V> iVar2 = new i<>(((AbstractStrongKeyEntry) this).f6105a, this.K, iVar);
            iVar2.b = this.b;
            return iVar2;
        }

        public void e(V v) {
            this.b = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.b;
        }
    }

    public static final class j<K, V> extends AbstractStrongKeyEntry<K, V, j<K, V>> implements WeakValueEntry<K, V, j<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile WeakValueReference<K, V, j<K, V>> f31791a;

        public static final class a<K, V> implements InternalEntryHelper<K, V, j<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f31792a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31792a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public j<K, V> e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, j<K, V> jVar, @NullableDecl j<K, V> jVar2) {
                if (Segment.isCollected(jVar)) {
                    return null;
                }
                return jVar.f(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, jVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public j<K, V> c(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i, @NullableDecl j<K, V> jVar) {
                return new j<>(k, i, jVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, j<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void f(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, j<K, V> jVar, V v) {
                jVar.g(v, ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }
        }

        public j(K k, int i, @NullableDecl j<K, V> jVar) {
            super(k, i, jVar);
            this.f31791a = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void b() {
            this.f31791a.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, j<K, V>> c() {
            return this.f31791a;
        }

        public j<K, V> f(ReferenceQueue<V> referenceQueue, j<K, V> jVar) {
            j<K, V> jVar2 = new j<>(((AbstractStrongKeyEntry) this).f6105a, this.K, jVar);
            jVar2.f31791a = this.f31791a.b(referenceQueue, jVar2);
            return jVar2;
        }

        public void g(V v, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, j<K, V>> weakValueReference = this.f31791a;
            this.f31791a = new p(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.f31791a.get();
        }
    }

    public final class k extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        public k(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    public final class l extends AbstractCollection<V> {
        public l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new k(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    public static final class m<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, m<K>> implements StrongValueEntry<K, MapMaker.Dummy, m<K>> {

        public static final class a<K> implements InternalEntryHelper<K, MapMaker.Dummy, m<K>, WeakKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f31794a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f31794a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength d() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public m<K> e(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, m<K> mVar, @NullableDecl m<K> mVar2) {
                if (mVar.getKey() == null) {
                    return null;
                }
                return mVar.d(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, mVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public m<K> c(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k, int i, @NullableDecl m<K> mVar) {
                return new m<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k, i, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void f(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, m<K> mVar, MapMaker.Dummy dummy) {
            }
        }

        public m(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl m<K> mVar) {
            super(referenceQueue, k, i, mVar);
        }

        public m<K> d(ReferenceQueue<K> referenceQueue, m<K> mVar) {
            return new m<>(referenceQueue, getKey(), this.K, mVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        public void f(MapMaker.Dummy dummy) {
        }
    }

    public static final class n<K, V> extends AbstractWeakKeyEntry<K, V, n<K, V>> implements StrongValueEntry<K, V, n<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NullableDecl
        public volatile V f31795a;

        public static final class a<K, V> implements InternalEntryHelper<K, V, n<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f31796a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31796a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength d() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public n<K, V> e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, n<K, V> nVar, @NullableDecl n<K, V> nVar2) {
                if (nVar.getKey() == null) {
                    return null;
                }
                return nVar.d(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, nVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public n<K, V> c(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i, @NullableDecl n<K, V> nVar) {
                return new n<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k, i, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, n<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void f(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, n<K, V> nVar, V v) {
                nVar.e(v);
            }
        }

        public n(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl n<K, V> nVar) {
            super(referenceQueue, k, i, nVar);
            this.f31795a = null;
        }

        public n<K, V> d(ReferenceQueue<K> referenceQueue, n<K, V> nVar) {
            n<K, V> nVar2 = new n<>(referenceQueue, getKey(), this.K, nVar);
            nVar2.e(this.f31795a);
            return nVar2;
        }

        public void e(V v) {
            this.f31795a = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.f31795a;
        }
    }

    public static final class o<K, V> extends AbstractWeakKeyEntry<K, V, o<K, V>> implements WeakValueEntry<K, V, o<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile WeakValueReference<K, V, o<K, V>> f31797a;

        public static final class a<K, V> implements InternalEntryHelper<K, V, o<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f31798a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31798a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength d() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public o<K, V> e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, o<K, V> oVar, @NullableDecl o<K, V> oVar2) {
                if (oVar.getKey() == null || Segment.isCollected(oVar)) {
                    return null;
                }
                return oVar.f(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, oVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public o<K, V> c(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i, @NullableDecl o<K, V> oVar) {
                return new o<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k, i, oVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, o<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void f(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, o<K, V> oVar, V v) {
                oVar.g(v, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }
        }

        public o(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl o<K, V> oVar) {
            super(referenceQueue, k, i, oVar);
            this.f31797a = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void b() {
            this.f31797a.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, o<K, V>> c() {
            return this.f31797a;
        }

        public o<K, V> f(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, o<K, V> oVar) {
            o<K, V> oVar2 = new o<>(referenceQueue, getKey(), this.K, oVar);
            oVar2.f31797a = this.f31797a.b(referenceQueue2, oVar2);
            return oVar2;
        }

        public void g(V v, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, o<K, V>> weakValueReference = this.f31797a;
            this.f31797a = new p(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.f31797a.get();
        }
    }

    public static final class p<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final E f31799a;

        public p(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.f31799a = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E a() {
            return this.f31799a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<K, V, E> b(ReferenceQueue<V> referenceQueue, E e) {
            return new p(referenceQueue, get(), e);
        }
    }

    public final class q extends AbstractMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final K f6110a;
        public V b;

        public q(K k, V v) {
            this.f6110a = k;
            this.b = v;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f6110a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.f6110a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            return this.f6110a.hashCode() ^ this.b.hashCode();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.f6110a, v);
            this.b = v;
            return v2;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = internalEntryHelper;
        int iMin = Math.min(mapMaker.c(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        int i5 = 1;
        while (i5 < this.concurrencyLevel) {
            i4++;
            i5 <<= 1;
        }
        this.segmentShift = 32 - i4;
        this.segmentMask = i5 - 1;
        this.segments = newSegmentArray(i5);
        int i6 = iMin / i5;
        while (i3 < (i5 * i6 < iMin ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                return;
            }
            segmentArr[i2] = createSegment(i3, -1);
            i2++;
        }
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength strengthE = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (strengthE == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, i.a.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, j.a.h());
        }
        Strength strengthE2 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (strengthE2 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, n.a.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, o.a.h());
        }
        throw new AssertionError();
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength strengthE = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (strengthE == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, h.a.h());
        }
        Strength strengthE2 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (strengthE2 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, m.a.h());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    public static int rehash(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference() {
        return (WeakValueReference<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).containsKey(obj, iHash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            int length = segmentArr.length;
            long j3 = 0;
            for (?? r10 = z; r10 < length; r10++) {
                Segment<K, V, E, S> segment = segmentArr[r10];
                int i3 = segment.count;
                AtomicReferenceArray<E> atomicReferenceArray = segment.table;
                for (?? r13 = z; r13 < atomicReferenceArray.length(); r13++) {
                    for (E eA = atomicReferenceArray.get(r13); eA != null; eA = eA.a()) {
                        V liveValue = segment.getLiveValue(eA);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j3 += (long) segment.modCount;
                z = false;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            z = false;
        }
        return z;
    }

    @VisibleForTesting
    public E copyEntry(E e2, E e3) {
        return (E) segmentFor(e2.getHash()).copyEntry(e2, e3);
    }

    public Segment<K, V, E, S> createSegment(int i2, int i3) {
        return this.entryHelper.b(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.entrySet = eVar;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).get(obj, iHash);
    }

    public E getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return (E) segmentFor(iHash).getEntry(obj, iHash);
    }

    public V getLiveValue(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return (V) e2.getValue();
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j2 += (long) segmentArr[i2].modCount;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].count != 0) {
                return false;
            }
            j2 -= (long) segmentArr[i3].modCount;
        }
        return j2 == 0;
    }

    @VisibleForTesting
    public boolean isLiveForTesting(InternalEntry<K, V, ?> internalEntry) {
        return segmentFor(internalEntry.getHash()).getLiveValueForTesting(internalEntry) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.keySet = gVar;
        return gVar;
    }

    @VisibleForTesting
    public Strength keyStrength() {
        return this.entryHelper.d();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v);
        int iHash = hash(k2);
        return segmentFor(iHash).put(k2, iHash, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v);
        int iHash = hash(k2);
        return segmentFor(iHash).put(k2, iHash, v, true);
    }

    public void reclaimKey(E e2) {
        int hash = e2.getHash();
        segmentFor(hash).reclaimKey(e2, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(WeakValueReference<K, V, E> weakValueReference) {
        InternalEntry internalEntryA = weakValueReference.a();
        int hash = internalEntryA.getHash();
        segmentFor(hash).reclaimValue(internalEntryA.getKey(), hash, weakValueReference);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, @NullableDecl V v, V v2) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v2);
        if (v == null) {
            return false;
        }
        int iHash = hash(k2);
        return segmentFor(iHash).replace(k2, iHash, v, v2);
    }

    public Segment<K, V, E, S> segmentFor(int i2) {
        return this.segments[(i2 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (Segment<K, V, E, S> segment : this.segments) {
            j2 += (long) segment.count;
        }
        return Ints.x(j2);
    }

    @VisibleForTesting
    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.a().defaultEquivalence();
    }

    @VisibleForTesting
    public Strength valueStrength() {
        return this.entryHelper.a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        l lVar = new l();
        this.values = lVar;
        return lVar;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.d(), this.entryHelper.a(), this.keyEquivalence, this.entryHelper.a().defaultEquivalence(), this.concurrencyLevel, this);
    }

    public static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.delegate = concurrentMap;
        }

        public void readEntries(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                }
                this.delegate.put((K) object, (V) objectInputStream.readObject());
            }
        }

        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v);
        int iHash = hash(k2);
        return segmentFor(iHash).replace(k2, iHash, v);
    }

    public static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();

        @NullableDecl
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
        }

        public static <K, V, E extends InternalEntry<K, V, E>> boolean isCollected(E e) {
            return e.getValue() == null;
        }

        public abstract E castForTesting(InternalEntry<K, V, ?> internalEntry);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        @CanIgnoreReturnValue
        public boolean clearValueForTesting(K k, int i, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntryA = e; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                    Object key = internalEntryA.getKey();
                    if (internalEntryA.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((WeakValueEntry) internalEntryA).c() != weakValueReference) {
                            return false;
                        }
                        atomicReferenceArray.set(length, (E) removeFromChain(e, internalEntryA));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count == 0) {
                    return false;
                }
                InternalEntry liveEntry = getLiveEntry(obj, i);
                if (liveEntry != null && liveEntry.getValue() != null) {
                    z = true;
                }
                return z;
            } finally {
                postReadCleanup();
            }
        }

        @VisibleForTesting
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (E eA = atomicReferenceArray.get(i); eA != null; eA = eA.a()) {
                            V liveValue = getLiveValue(eA);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public E copyEntry(E e, E e2) {
            return (E) this.map.entryHelper.e(self(), e, e2);
        }

        public E copyForTesting(InternalEntry<K, V, ?> internalEntry, @NullableDecl InternalEntry<K, V, ?> internalEntry2) {
            return (E) this.map.entryHelper.e(self(), castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        @GuardedBy("this")
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimKey((InternalEntry) referencePoll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimValue((WeakValueReference) referencePoll);
                i++;
            } while (i != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<E> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E eA = atomicReferenceArray.get(i2);
                if (eA != null) {
                    InternalEntry internalEntryA = eA.a();
                    int hash = eA.getHash() & length2;
                    if (internalEntryA == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, eA);
                    } else {
                        InternalEntry internalEntry = eA;
                        while (internalEntryA != null) {
                            int hash2 = internalEntryA.getHash() & length2;
                            if (hash2 != hash) {
                                internalEntry = internalEntryA;
                                hash = hash2;
                            }
                            internalEntryA = internalEntryA.a();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, internalEntry);
                        while (eA != internalEntry) {
                            int hash3 = eA.getHash() & length2;
                            InternalEntry internalEntryCopyEntry = copyEntry(eA, (InternalEntry) atomicReferenceArrayNewEntryArray.get(hash3));
                            if (internalEntryCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, internalEntryCopyEntry);
                            } else {
                                i--;
                            }
                            eA = eA.a();
                        }
                    }
                }
            }
            this.table = atomicReferenceArrayNewEntryArray;
            this.count = i;
        }

        public V get(Object obj, int i) {
            try {
                InternalEntry liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V v = (V) liveEntry.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(Object obj, int i) {
            if (this.count == 0) {
                return null;
            }
            for (E e = (E) getFirst(i); e != null; e = (E) e.a()) {
                if (e.getHash() == i) {
                    Object key = e.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return e;
                    }
                }
            }
            return null;
        }

        public E getFirst(int i) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object obj, int i) {
            return (E) getEntry(obj, i);
        }

        @NullableDecl
        public V getLiveValue(E e) {
            if (e.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = (V) e.getValue();
            if (v != null) {
                return v;
            }
            tryDrainReferenceQueues();
            return null;
        }

        @NullableDecl
        public V getLiveValueForTesting(InternalEntry<K, V, ?> internalEntry) {
            return getLiveValue(castForTesting(internalEntry));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public WeakValueReference<K, V, E> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        public E newEntryForTesting(K k, int i, @NullableDecl InternalEntry<K, V, ?> internalEntry) {
            return (E) this.map.entryHelper.c(self(), k, i, castForTesting(internalEntry));
        }

        public WeakValueReference<K, V, E> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @GuardedBy("this")
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        public V put(K k, int i, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntryA = e; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                    Object key = internalEntryA.getKey();
                    if (internalEntryA.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntryA.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            setValue(internalEntryA, v);
                            this.count = this.count;
                            return null;
                        }
                        if (z) {
                            return v2;
                        }
                        this.modCount++;
                        setValue(internalEntryA, v);
                        return v2;
                    }
                }
                this.modCount++;
                InternalEntry internalEntryC = this.map.entryHelper.c(self(), k, i, e);
                setValue(internalEntryC, v);
                atomicReferenceArray.set(length, (E) internalEntryC);
                this.count = i2;
                return null;
            } finally {
                unlock();
            }
        }

        @CanIgnoreReturnValue
        public boolean reclaimKey(E e, int i) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                E e2 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntryA = e2; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                    if (internalEntryA == e) {
                        this.modCount++;
                        InternalEntry internalEntryRemoveFromChain = removeFromChain(e2, internalEntryA);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, (E) internalEntryRemoveFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        @CanIgnoreReturnValue
        public boolean reclaimValue(K k, int i, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntryA = e; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                    Object key = internalEntryA.getKey();
                    if (internalEntryA.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((WeakValueEntry) internalEntryA).c() != weakValueReference) {
                            return false;
                        }
                        this.modCount++;
                        InternalEntry internalEntryRemoveFromChain = removeFromChain(e, internalEntryA);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, (E) internalEntryRemoveFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        @CanIgnoreReturnValue
        public V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntryA = e; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                    Object key = internalEntryA.getKey();
                    if (internalEntryA.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v = (V) internalEntryA.getValue();
                        if (v == null && !isCollected(internalEntryA)) {
                            return null;
                        }
                        this.modCount++;
                        InternalEntry internalEntryRemoveFromChain = removeFromChain(e, internalEntryA);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, (E) internalEntryRemoveFromChain);
                        this.count = i2;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        @GuardedBy("this")
        public boolean removeEntryForTesting(E e) {
            int hash = e.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            E e2 = atomicReferenceArray.get(length);
            for (InternalEntry internalEntryA = e2; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                if (internalEntryA == e) {
                    this.modCount++;
                    InternalEntry internalEntryRemoveFromChain = removeFromChain(e2, internalEntryA);
                    int i = this.count - 1;
                    atomicReferenceArray.set(length, (E) internalEntryRemoveFromChain);
                    this.count = i;
                    return true;
                }
            }
            return false;
        }

        @GuardedBy("this")
        public E removeFromChain(E e, E e2) {
            int i = this.count;
            E e3 = (E) e2.a();
            while (e != e2) {
                InternalEntry internalEntryCopyEntry = copyEntry(e, e3);
                if (internalEntryCopyEntry != null) {
                    e3 = (E) internalEntryCopyEntry;
                } else {
                    i--;
                }
                e = (E) e.a();
            }
            this.count = i;
            return e3;
        }

        public E removeFromChainForTesting(InternalEntry<K, V, ?> internalEntry, InternalEntry<K, V, ?> internalEntry2) {
            return (E) removeFromChain(castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        @CanIgnoreReturnValue
        public boolean removeTableEntryForTesting(InternalEntry<K, V, ?> internalEntry) {
            return removeEntryForTesting(castForTesting(internalEntry));
        }

        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntryA = e; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                    Object key = internalEntryA.getKey();
                    if (internalEntryA.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        Object value = internalEntryA.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(internalEntryA, v2);
                            return true;
                        }
                        if (isCollected(internalEntryA)) {
                            this.modCount++;
                            InternalEntry internalEntryRemoveFromChain = removeFromChain(e, internalEntryA);
                            int i2 = this.count - 1;
                            atomicReferenceArray.set(length, (E) internalEntryRemoveFromChain);
                            this.count = i2;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i, InternalEntry<K, V, ?> internalEntry) {
            this.table.set(i, (E) castForTesting(internalEntry));
        }

        public void setValue(E e, V v) {
            this.map.entryHelper.f(self(), e, v);
        }

        public void setValueForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            this.map.entryHelper.f(self(), castForTesting(internalEntry), v);
        }

        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public boolean remove(Object obj, int i, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                InternalEntry internalEntryA = e;
                while (true) {
                    boolean z = false;
                    if (internalEntryA == null) {
                        return false;
                    }
                    Object key = internalEntryA.getKey();
                    if (internalEntryA.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (this.map.valueEquivalence().equivalent(obj2, internalEntryA.getValue())) {
                            z = true;
                        } else if (!isCollected(internalEntryA)) {
                            return false;
                        }
                        this.modCount++;
                        InternalEntry internalEntryRemoveFromChain = removeFromChain(e, internalEntryA);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, (E) internalEntryRemoveFromChain);
                        this.count = i2;
                        return z;
                    }
                    internalEntryA = internalEntryA.a();
                }
            } finally {
                unlock();
            }
        }

        public V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntryA = e; internalEntryA != null; internalEntryA = internalEntryA.a()) {
                    Object key = internalEntryA.getKey();
                    if (internalEntryA.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntryA.getValue();
                        if (v2 == null) {
                            if (isCollected(internalEntryA)) {
                                this.modCount++;
                                InternalEntry internalEntryRemoveFromChain = removeFromChain(e, internalEntryA);
                                int i2 = this.count - 1;
                                atomicReferenceArray.set(length, (E) internalEntryRemoveFromChain);
                                this.count = i2;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(internalEntryA, v);
                        return v2;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
