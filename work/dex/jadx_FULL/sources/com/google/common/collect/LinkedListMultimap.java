package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @CheckForNull
    private transient g<K, V> head;
    private transient Map<K, f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;

    @CheckForNull
    private transient g<K, V> tail;

    public class a extends AbstractSequentialList<V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6090a;

        public a(Object obj) {
            this.f6090a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            return new i(this.f6090a, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f6090a);
            if (fVar == null) {
                return 0;
            }
            return fVar.f31769a;
        }
    }

    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i) {
            return new h(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    public class c extends Sets.ImprovedAbstractSet<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    public class d extends AbstractSequentialList<V> {

        public class a extends TransformedListIterator<Map.Entry<K, V>, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f31767a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f31767a = hVar;
            }

            @Override // com.google.common.collect.TransformedIterator
            @ParametricNullness
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.TransformedListIterator, java.util.ListIterator
            public void set(@ParametricNullness V v) {
                this.f31767a.f(v);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            h hVar = new h(i);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    public static class f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31769a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public g<K, V> f6093a;
        public g<K, V> b;

        public f(g<K, V> gVar) {
            this.f6093a = gVar;
            this.b = gVar;
            gVar.d = null;
            gVar.c = null;
            this.f31769a = 1;
        }
    }

    public static final class g<K, V> extends AbstractMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public g<K, V> f31770a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @ParametricNullness
        public final K f6094a;

        @CheckForNull
        public g<K, V> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @ParametricNullness
        public V f6095b;

        @CheckForNull
        public g<K, V> c;

        @CheckForNull
        public g<K, V> d;

        public g(@ParametricNullness K k, @ParametricNullness V v) {
            this.f6094a = k;
            this.f6095b = v;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.f6094a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            return this.f6095b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            V v2 = this.f6095b;
            this.f6095b = v;
            return v2;
        }
    }

    public class h implements ListIterator<Map.Entry<K, V>> {
        public int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public g<K, V> f31771a;

        @CheckForNull
        public g<K, V> b;

        @CheckForNull
        public g<K, V> c;

        public h(int i) {
            this.L = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            com.google.common.base.i.d0(i, size);
            if (i < size / 2) {
                this.f31771a = LinkedListMultimap.this.head;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i2;
                }
            } else {
                this.c = LinkedListMultimap.this.tail;
                this.K = size;
                while (true) {
                    int i3 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            }
            this.b = null;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public final void b() {
            if (LinkedListMultimap.this.modCount != this.L) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g<K, V> next() {
            b();
            g<K, V> gVar = this.f31771a;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.b = gVar;
            this.c = gVar;
            this.f31771a = gVar.f31770a;
            this.K++;
            return gVar;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g<K, V> previous() {
            b();
            g<K, V> gVar = this.c;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.b = gVar;
            this.f31771a = gVar;
            this.c = gVar.b;
            this.K--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void f(@ParametricNullness V v) {
            com.google.common.base.i.g0(this.b != null);
            this.b.f6095b = v;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f31771a != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.c != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.K;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.K - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            com.google.common.base.i.h0(this.b != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.b;
            if (gVar != this.f31771a) {
                this.c = gVar.b;
                this.K--;
            } else {
                this.f31771a = gVar.f31770a;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.b = null;
            this.L = LinkedListMultimap.this.modCount;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public g<K, V> addNode(@ParametricNullness K k, @ParametricNullness V v, @CheckForNull g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k, v);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k, new f<>(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.tail;
            Objects.requireNonNull(gVar3);
            gVar3.f31770a = gVar2;
            gVar2.b = this.tail;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k);
            if (fVar == null) {
                this.keyToKeyList.put(k, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f31769a++;
                g<K, V> gVar4 = fVar.b;
                gVar4.c = gVar2;
                gVar2.d = gVar4;
                fVar.b = gVar2;
            }
        } else {
            f<K, V> fVar2 = this.keyToKeyList.get(k);
            Objects.requireNonNull(fVar2);
            fVar2.f31769a++;
            gVar2.b = gVar.b;
            gVar2.d = gVar.d;
            gVar2.f31770a = gVar;
            gVar2.c = gVar;
            g<K, V> gVar5 = gVar.d;
            if (gVar5 == null) {
                fVar2.f6093a = gVar2;
            } else {
                gVar5.c = gVar2;
            }
            g<K, V> gVar6 = gVar.b;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f31770a = gVar2;
            }
            gVar.b = gVar2;
            gVar.d = gVar2;
        }
        this.size++;
        return gVar2;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(@ParametricNullness K k) {
        return Collections.unmodifiableList(Lists.s(new i(k)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int i2 = objectInputStream.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(@ParametricNullness K k) {
        Iterators.h(new i(k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.b;
        if (gVar2 != null) {
            gVar2.f31770a = gVar.f31770a;
        } else {
            this.head = gVar.f31770a;
        }
        g<K, V> gVar3 = gVar.f31770a;
        if (gVar3 != null) {
            gVar3.b = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.d == null && gVar.c == null) {
            f<K, V> fVarRemove = this.keyToKeyList.remove(gVar.f6094a);
            Objects.requireNonNull(fVarRemove);
            fVarRemove.f31769a = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f6094a);
            Objects.requireNonNull(fVar);
            fVar.f31769a--;
            g<K, V> gVar4 = gVar.d;
            if (gVar4 == null) {
                g<K, V> gVar5 = gVar.c;
                Objects.requireNonNull(gVar5);
                fVar.f6093a = gVar5;
            } else {
                gVar4.c = gVar.c;
            }
            g<K, V> gVar6 = gVar.c;
            if (gVar6 == null) {
                g<K, V> gVar7 = gVar.d;
                Objects.requireNonNull(gVar7);
                fVar.b = gVar7;
            } else {
                gVar6.d = gVar.d;
            }
        }
        this.size--;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return new Multimaps.b(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k, @ParametricNullness V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i2) {
        this.keyToKeyList = u.d(i2);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i2) {
        return new LinkedListMultimap<>(i2);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List<V> get(@ParametricNullness K k) {
        return new a(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        i iVar = new i(k);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    public class e implements Iterator<K> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public g<K, V> f31768a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Set<K> f6092a;

        @CheckForNull
        public g<K, V> b;

        public e() {
            this.f6092a = Sets.y(LinkedListMultimap.this.keySet().size());
            this.f31768a = LinkedListMultimap.this.head;
            this.K = LinkedListMultimap.this.modCount;
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.K) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f31768a != null;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public K next() {
            g<K, V> gVar;
            a();
            g<K, V> gVar2 = this.f31768a;
            if (gVar2 == null) {
                throw new NoSuchElementException();
            }
            this.b = gVar2;
            this.f6092a.add(gVar2.f6094a);
            do {
                gVar = this.f31768a.f31770a;
                this.f31768a = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f6092a.add(gVar.f6094a));
            return this.b.f6094a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.base.i.h0(this.b != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.b.f6094a);
            this.b = null;
            this.K = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    public class i implements ListIterator<V> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public g<K, V> f31772a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @ParametricNullness
        public final K f6098a;

        @CheckForNull
        public g<K, V> b;

        @CheckForNull
        public g<K, V> c;

        public i(K k) {
            this.f6098a = k;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k);
            this.f31772a = fVar == null ? null : fVar.f6093a;
        }

        @Override // java.util.ListIterator
        public void add(@ParametricNullness V v) {
            this.c = LinkedListMultimap.this.addNode(this.f6098a, v, this.f31772a);
            this.K++;
            this.b = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f31772a != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.c != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @ParametricNullness
        @CanIgnoreReturnValue
        public V next() {
            g<K, V> gVar = this.f31772a;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.b = gVar;
            this.c = gVar;
            this.f31772a = gVar.c;
            this.K++;
            return gVar.f6095b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.K;
        }

        @Override // java.util.ListIterator
        @ParametricNullness
        @CanIgnoreReturnValue
        public V previous() {
            g<K, V> gVar = this.c;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.b = gVar;
            this.f31772a = gVar;
            this.c = gVar.d;
            this.K--;
            return gVar.f6095b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.K - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            com.google.common.base.i.h0(this.b != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.b;
            if (gVar != this.f31772a) {
                this.c = gVar.d;
                this.K--;
            } else {
                this.f31772a = gVar.c;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.b = null;
        }

        @Override // java.util.ListIterator
        public void set(@ParametricNullness V v) {
            com.google.common.base.i.g0(this.b != null);
            this.b.f6095b = v;
        }

        public i(K k, int i) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k);
            int i2 = fVar == null ? 0 : fVar.f31769a;
            com.google.common.base.i.d0(i, i2);
            if (i >= i2 / 2) {
                this.c = fVar == null ? null : fVar.b;
                this.K = i2;
                while (true) {
                    int i3 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            } else {
                this.f31772a = fVar == null ? null : fVar.f6093a;
                while (true) {
                    int i4 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i4;
                }
            }
            this.f6098a = k;
            this.b = null;
        }
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }
}
