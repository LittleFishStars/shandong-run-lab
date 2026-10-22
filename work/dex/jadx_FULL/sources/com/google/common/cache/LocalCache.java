package com.google.common.cache;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Ticker;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public static final int N = 1073741824;
    public static final int O = 65536;
    public static final int P = 3;
    public static final int Q = 63;
    public static final int R = 16;
    public final int K;
    public final int L;
    public final int M;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f5995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Equivalence<Object> f5996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Ticker f5997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AbstractCache.StatsCounter f5998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NullableDecl
    public final CacheLoader<? super K, V> f5999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EntryFactory f6000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Strength f6001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RemovalListener<K, V> f6002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Weigher<K, V> f6003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @RetainedWith
    @NullableDecl
    public Collection<V> f6004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Queue<RemovalNotification<K, V>> f6005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @RetainedWith
    @NullableDecl
    public Set<K> f6006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Segment<K, V>[] f6007a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f6008b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Equivalence<Object> f6009b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Strength f6010b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @RetainedWith
    @NullableDecl
    public Set<Map.Entry<K, V>> f6011b;
    public final long c;
    public final long d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f5994a = Logger.getLogger(LocalCache.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ValueReference<Object, Object> f31618a = new a();
    public static final Queue<?> b = new b();

    public abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        public AbstractCacheSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.Q(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.Q(this).toArray(eArr);
        }
    }

    public static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.common.cache.LocalCache$EntryFactory, still in use, count: 1, list:
      (r0v0 com.google.common.cache.LocalCache$EntryFactory) from 0x0058: FILLED_NEW_ARRAY 
      (r0v0 com.google.common.cache.LocalCache$EntryFactory)
      (r1v1 com.google.common.cache.LocalCache$EntryFactory)
      (r3v1 com.google.common.cache.LocalCache$EntryFactory)
      (r5v1 com.google.common.cache.LocalCache$EntryFactory)
      (r7v1 com.google.common.cache.LocalCache$EntryFactory)
      (r9v1 com.google.common.cache.LocalCache$EntryFactory)
      (r11v1 com.google.common.cache.LocalCache$EntryFactory)
      (r13v1 com.google.common.cache.LocalCache$EntryFactory)
     A[WRAPPED] elemType: com.google.common.cache.LocalCache$EntryFactory
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static abstract class EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new l(k, i, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new j(k, i, referenceEntry);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new n(k, i, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new k(k, i, referenceEntry);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new s(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new q(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new u(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new r(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        };

        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new l(k, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new j(k, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new n(k, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new k(k, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new s(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new q(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new u(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new r(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }};

        static {
        }

        private EntryFactory(String str, int i) {
            super(str, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[((strength == Strength.WEAK ? (char) 4 : (char) 0) | (z ? 1 : 0) ? 1 : 0) | (z2 ? 2 : 0)];
        }

        public static EntryFactory valueOf(String str) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, str);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        public <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.d(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.d(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.E(referenceEntry);
        }

        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        public <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.e(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.e(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.F(referenceEntry);
        }

        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry);

        public /* synthetic */ EntryFactory(String str, int i, a aVar) {
            this(str, i);
        }
    }

    public abstract class HashIterator<T> implements Iterator<T> {
        public int K;
        public int L = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NullableDecl
        public Segment<K, V> f31620a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public LocalCache<K, V>.z f6012a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public ReferenceEntry<K, V> f6014a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public AtomicReferenceArray<ReferenceEntry<K, V>> f6015a;

        @NullableDecl
        public LocalCache<K, V>.z b;

        public HashIterator() {
            this.K = LocalCache.this.f6007a.length - 1;
            a();
        }

        public final void a() {
            this.f6012a = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.K;
                if (i < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.f6007a;
                this.K = i - 1;
                Segment<K, V> segment = segmentArr[i];
                this.f31620a = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f31620a.table;
                    this.f6015a = atomicReferenceArray;
                    this.L = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(ReferenceEntry<K, V> referenceEntry) {
            Segment<K, V> segment;
            try {
                long jA = LocalCache.this.f5997a.a();
                K key = referenceEntry.getKey();
                Object objS = LocalCache.this.s(referenceEntry, jA);
                if (objS == null) {
                    return false;
                }
                this.f6012a = new z(key, objS);
                return true;
            } finally {
                this.f31620a.postReadCleanup();
            }
        }

        public LocalCache<K, V>.z c() {
            LocalCache<K, V>.z zVar = this.f6012a;
            if (zVar == null) {
                throw new NoSuchElementException();
            }
            this.b = zVar;
            a();
            return this.b;
        }

        public boolean d() {
            ReferenceEntry<K, V> referenceEntry = this.f6014a;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.f6014a = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.f6014a;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.f6014a;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.L;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f6015a;
                this.L = i - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.f6014a = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6012a != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.i.g0(this.b != null);
            LocalCache.this.remove(this.b.getKey());
            this.b = null;
        }
    }

    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        @NullableDecl
        transient LoadingCache<K, V> autoDelegate;

        public LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (LoadingCache<K, V>) recreateCacheBuilder().b(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }
    }

    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) com.google.common.base.i.E(cacheLoader)), null);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.localCache.t(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.o(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.localCache.M(k);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        public class a extends CacheLoader<Object, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callable f31621a;

            public a(LocalManualCache localManualCache, Callable callable) {
                this.f31621a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.f31621a.call();
            }
        }

        public /* synthetic */ LocalManualCache(LocalCache localCache, a aVar) {
            this(localCache);
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.c();
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            com.google.common.base.i.E(callable);
            return this.localCache.n(k, new a(this, callable));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.p(iterable);
        }

        @Override // com.google.common.cache.Cache
        @NullableDecl
        public V getIfPresent(Object obj) {
            return this.localCache.r(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            com.google.common.base.i.E(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.v(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.z();
        }

        @Override // com.google.common.cache.Cache
        public com.google.common.cache.a stats() {
            AbstractCache.a aVar = new AbstractCache.a();
            aVar.g(this.localCache.f5998a);
            for (Segment<K, V> segment : this.localCache.f6007a) {
                aVar.g(segment.statsCounter);
            }
            return aVar.a();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    public static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @NullableDecl
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;

        @NullableDecl
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        public ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.f6001a, localCache.f6010b, localCache.f5996a, localCache.f6009b, localCache.c, localCache.f6008b, localCache.f5995a, localCache.f6003a, localCache.M, localCache.f6002a, localCache.f5997a, localCache.f5999a);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.D().H(this.keyStrength).I(this.valueStrength).z(this.keyEquivalence).L(this.valueEquivalence).e(this.concurrencyLevel).G(this.removalListener);
            cacheBuilder.f5970a = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilder.g(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilder.f(j2, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.weigher;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.O(weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilder.C(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilder.B(j4);
                }
            }
            Ticker ticker = this.ticker;
            if (ticker != null) {
                cacheBuilder.K(ticker);
            }
            return cacheBuilder;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher, int i, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher;
            this.concurrencyLevel = i;
            this.removalListener = removalListener;
            this.ticker = (ticker == Ticker.b() || ticker == CacheBuilder.f5960b) ? null : ticker;
            this.loader = cacheLoader;
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    public enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
        }
    }

    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new m(v) : new w(v, i);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new i(segment.valueReferenceQueue, v, referenceEntry) : new v(segment.valueReferenceQueue, v, referenceEntry, i);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new t(segment.valueReferenceQueue, v, referenceEntry) : new x(segment.valueReferenceQueue, v, referenceEntry, i);
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    public interface ValueReference<K, V> {
        int a();

        ValueReference<K, V> b(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry);

        void c(@NullableDecl V v);

        @NullableDecl
        ReferenceEntry<K, V> d();

        V e() throws ExecutionException;

        @NullableDecl
        V get();

        boolean isActive();

        boolean isLoading();
    }

    public class a implements ValueReference<Object, Object> {
        @Override // com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<Object, Object> b(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void c(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<Object, Object> d() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object e() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    public class b extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    public static final class c<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceEntry<K, V> f31623a = new a(this);

        public class a extends AbstractReferenceEntry<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Weak
            public ReferenceEntry<K, V> f31624a = this;

            @Weak
            public ReferenceEntry<K, V> b = this;

            public a(c cVar) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.f31624a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f31624a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.b = referenceEntry;
            }
        }

        public class b extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
            public b(ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                if (nextInAccessQueue == c.this.f31623a) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.d(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.d(this.f31623a.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.d(referenceEntry, this.f31623a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.f31623a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f31623a) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.f31623a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f31623a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.f31623a.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.f31623a;
                if (nextInAccessQueue == referenceEntry) {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.f31623a;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.E(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f31623a.getNextInAccessQueue() == this.f31623a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.d(previousInAccessQueue, nextInAccessQueue);
            LocalCache.E(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.f31623a.getNextInAccessQueue(); nextInAccessQueue != this.f31623a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    public final class d extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        public d(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class e extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f6009b.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    public final class f extends LocalCache<K, V>.HashIterator<K> {
        public f(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    public final class g extends LocalCache<K, V>.AbstractCacheSet<K> {
        public g() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new f(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    public static class h<K, V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.common.base.k f31626a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile ValueReference<K, V> f6019a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.common.util.concurrent.o<V> f6020a;

        public class a implements Function<V, V> {
            public a() {
            }

            @Override // com.google.common.base.Function
            public V apply(V v) {
                h.this.j(v);
                return v;
            }
        }

        public h() {
            this(LocalCache.R());
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return this.f6019a.a();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void c(@NullableDecl V v) {
            if (v != null) {
                j(v);
            } else {
                this.f6019a = LocalCache.R();
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> d() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V e() throws ExecutionException {
            return (V) com.google.common.util.concurrent.s.f(this.f6020a);
        }

        public long f() {
            return this.f31626a.g(TimeUnit.NANOSECONDS);
        }

        public final ListenableFuture<V> g(Throwable th) {
            return com.google.common.util.concurrent.f.l(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.f6019a.get();
        }

        public ValueReference<K, V> h() {
            return this.f6019a;
        }

        public ListenableFuture<V> i(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f31626a.k();
                V v = this.f6019a.get();
                if (v == null) {
                    V vLoad = cacheLoader.load(k);
                    return j(vLoad) ? this.f6020a : com.google.common.util.concurrent.f.m(vLoad);
                }
                ListenableFuture<V> listenableFutureReload = cacheLoader.reload(k, v);
                return listenableFutureReload == null ? com.google.common.util.concurrent.f.m(null) : com.google.common.util.concurrent.f.x(listenableFutureReload, new a(), com.google.common.util.concurrent.j.c());
            } catch (Throwable th) {
                ListenableFuture<V> listenableFutureG = k(th) ? this.f6020a : g(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return listenableFutureG;
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.f6019a.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public boolean j(@NullableDecl V v) {
            return this.f6020a.set(v);
        }

        public boolean k(Throwable th) {
            return this.f6020a.setException(th);
        }

        public h(ValueReference<K, V> valueReference) {
            this.f6020a = com.google.common.util.concurrent.o.A();
            this.f31626a = com.google.common.base.k.e();
            this.f6019a = valueReference;
        }
    }

    public static class i<K, V> extends SoftReference<V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceEntry<K, V> f31628a;

        public i(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.f31628a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new i(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void c(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> d() {
            return this.f31628a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    public static final class j<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f31629a;

        @Weak
        public ReferenceEntry<K, V> b;

        @Weak
        public ReferenceEntry<K, V> c;

        public j(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.f31629a = Long.MAX_VALUE;
            this.b = LocalCache.D();
            this.c = LocalCache.D();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.f31629a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.f31629a = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.b = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.c = referenceEntry;
        }
    }

    public static final class k<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f31630a;
        public volatile long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Weak
        public ReferenceEntry<K, V> f6021b;

        @Weak
        public ReferenceEntry<K, V> c;

        @Weak
        public ReferenceEntry<K, V> d;

        @Weak
        public ReferenceEntry<K, V> e;

        public k(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.f31630a = Long.MAX_VALUE;
            this.f6021b = LocalCache.D();
            this.c = LocalCache.D();
            this.b = Long.MAX_VALUE;
            this.d = LocalCache.D();
            this.e = LocalCache.D();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.f31630a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f6021b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.f31630a = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f6021b = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.d = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.b = j;
        }
    }

    public static class l<K, V> extends AbstractReferenceEntry<K, V> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile ValueReference<K, V> f31631a = LocalCache.R();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public final ReferenceEntry<K, V> f6022a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final K f6023a;

        public l(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            this.f6023a = k;
            this.K = i;
            this.f6022a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.K;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.f6023a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.f6022a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.f31631a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.f31631a = valueReference;
        }
    }

    public static class m<K, V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f31632a;

        public m(V v) {
            this.f31632a = v;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void c(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> d() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.f31632a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    public static final class n<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f31633a;

        @Weak
        public ReferenceEntry<K, V> b;

        @Weak
        public ReferenceEntry<K, V> c;

        public n(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.f31633a = Long.MAX_VALUE;
            this.b = LocalCache.D();
            this.c = LocalCache.D();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.f31633a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.b = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.f31633a = j;
        }
    }

    public final class o extends LocalCache<K, V>.HashIterator<V> {
        public o(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    public final class p extends AbstractCollection<V> {
        public p() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new o(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.Q(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.Q(this).toArray(eArr);
        }
    }

    public static final class q<K, V> extends s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f31635a;

        @Weak
        public ReferenceEntry<K, V> b;

        @Weak
        public ReferenceEntry<K, V> c;

        public q(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.f31635a = Long.MAX_VALUE;
            this.b = LocalCache.D();
            this.c = LocalCache.D();
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.f31635a;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.f31635a = j;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.b = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.c = referenceEntry;
        }
    }

    public static final class r<K, V> extends s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f31636a;
        public volatile long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Weak
        public ReferenceEntry<K, V> f6024b;

        @Weak
        public ReferenceEntry<K, V> c;

        @Weak
        public ReferenceEntry<K, V> d;

        @Weak
        public ReferenceEntry<K, V> e;

        public r(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.f31636a = Long.MAX_VALUE;
            this.f6024b = LocalCache.D();
            this.c = LocalCache.D();
            this.b = Long.MAX_VALUE;
            this.d = LocalCache.D();
            this.e = LocalCache.D();
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.f31636a;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f6024b;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.f31636a = j;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f6024b = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.d = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.b = j;
        }
    }

    public static class s<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile ValueReference<K, V> f31637a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NullableDecl
        public final ReferenceEntry<K, V> f6025a;

        public s(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.f31637a = LocalCache.R();
            this.K = i;
            this.f6025a = referenceEntry;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.K;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.f6025a;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.f31637a;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.f31637a = valueReference;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    public static class t<K, V> extends WeakReference<V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceEntry<K, V> f31638a;

        public t(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.f31638a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new t(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void c(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> d() {
            return this.f31638a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    public static final class u<K, V> extends s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f31639a;

        @Weak
        public ReferenceEntry<K, V> b;

        @Weak
        public ReferenceEntry<K, V> c;

        public u(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.f31639a = Long.MAX_VALUE;
            this.b = LocalCache.D();
            this.c = LocalCache.D();
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.f31639a;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.b = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.s, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.f31639a = j;
        }
    }

    public static final class v<K, V> extends i<K, V> {
        public final int K;

        public v(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.K = i;
        }

        @Override // com.google.common.cache.LocalCache.i, com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return this.K;
        }

        @Override // com.google.common.cache.LocalCache.i, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new v(referenceQueue, v, referenceEntry, this.K);
        }
    }

    public static final class w<K, V> extends m<K, V> {
        public final int K;

        public w(V v, int i) {
            super(v);
            this.K = i;
        }

        @Override // com.google.common.cache.LocalCache.m, com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return this.K;
        }
    }

    public static final class x<K, V> extends t<K, V> {
        public final int K;

        public x(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.K = i;
        }

        @Override // com.google.common.cache.LocalCache.t, com.google.common.cache.LocalCache.ValueReference
        public int a() {
            return this.K;
        }

        @Override // com.google.common.cache.LocalCache.t, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> b(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new x(referenceQueue, v, referenceEntry, this.K);
        }
    }

    public static final class y<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceEntry<K, V> f31640a = new a(this);

        public class a extends AbstractReferenceEntry<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Weak
            public ReferenceEntry<K, V> f31641a = this;

            @Weak
            public ReferenceEntry<K, V> b = this;

            public a(y yVar) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.f31641a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f31641a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setWriteTime(long j) {
            }
        }

        public class b extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
            public b(ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                if (nextInWriteQueue == y.this.f31640a) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.e(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.e(this.f31640a.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.e(referenceEntry, this.f31640a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.f31640a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f31640a) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.f31640a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f31640a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.f31640a.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.f31640a;
                if (nextInWriteQueue == referenceEntry) {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.f31640a;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.F(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f31640a.getNextInWriteQueue() == this.f31640a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.e(previousInWriteQueue, nextInWriteQueue);
            LocalCache.F(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.f31640a.getNextInWriteQueue(); nextInWriteQueue != this.f31640a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    public final class z implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final K f6026a;
        public V b;

        public z(K k, V v) {
            this.f6026a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f6026a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f6026a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f6026a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.f6026a, v);
            this.b = v;
            return v2;
        }

        public String toString() {
            String strValueOf = String.valueOf(getKey());
            String strValueOf2 = String.valueOf(getValue());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb.append(strValueOf);
            sb.append("=");
            sb.append(strValueOf2);
            return sb.toString();
        }
    }

    public LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @NullableDecl CacheLoader<? super K, V> cacheLoader) {
        this.M = Math.min(cacheBuilder.j(), 65536);
        Strength strengthO = cacheBuilder.o();
        this.f6001a = strengthO;
        this.f6010b = cacheBuilder.v();
        this.f5996a = cacheBuilder.n();
        this.f6009b = cacheBuilder.u();
        long jP = cacheBuilder.p();
        this.f5995a = jP;
        this.f6003a = (Weigher<K, V>) cacheBuilder.w();
        this.f6008b = cacheBuilder.k();
        this.c = cacheBuilder.l();
        this.d = cacheBuilder.q();
        CacheBuilder.NullListener nullListener = (RemovalListener<K, V>) cacheBuilder.r();
        this.f6002a = nullListener;
        this.f6005a = nullListener == CacheBuilder.NullListener.INSTANCE ? i() : new ConcurrentLinkedQueue<>();
        this.f5997a = cacheBuilder.t(K());
        this.f6000a = EntryFactory.getFactory(strengthO, S(), W());
        this.f5998a = cacheBuilder.s().get();
        this.f5999a = cacheLoader;
        int iMin = Math.min(cacheBuilder.m(), 1073741824);
        if (j() && !h()) {
            iMin = (int) Math.min(iMin, jP);
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        int i5 = 1;
        while (i5 < this.M && (!j() || i5 * 20 <= this.f5995a)) {
            i4++;
            i5 <<= 1;
        }
        this.L = 32 - i4;
        this.K = i5 - 1;
        this.f6007a = B(i5);
        int i6 = iMin / i5;
        while (i3 < (i6 * i5 < iMin ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        if (j()) {
            long j2 = this.f5995a;
            long j3 = i5;
            long j4 = (j2 / j3) + 1;
            long j5 = j2 % j3;
            while (true) {
                Segment<K, V>[] segmentArr = this.f6007a;
                if (i2 >= segmentArr.length) {
                    return;
                }
                if (i2 == j5) {
                    j4--;
                }
                segmentArr[i2] = g(i3, j4, cacheBuilder.s().get());
                i2++;
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.f6007a;
                if (i2 >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i2] = g(i3, -1L, cacheBuilder.s().get());
                i2++;
            }
        }
    }

    public static <K, V> ReferenceEntry<K, V> D() {
        return NullEntry.INSTANCE;
    }

    public static <K, V> void E(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> referenceEntryD = D();
        referenceEntry.setNextInAccessQueue(referenceEntryD);
        referenceEntry.setPreviousInAccessQueue(referenceEntryD);
    }

    public static <K, V> void F(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> referenceEntryD = D();
        referenceEntry.setNextInWriteQueue(referenceEntryD);
        referenceEntry.setPreviousInWriteQueue(referenceEntryD);
    }

    public static int O(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    public static <E> ArrayList<E> Q(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> ValueReference<K, V> R() {
        return (ValueReference<K, V>) f31618a;
    }

    public static <K, V> void d(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    public static <K, V> void e(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    public static <E> Queue<E> i() {
        return (Queue<E>) b;
    }

    @VisibleForTesting
    public ReferenceEntry<K, V> A(K k2, int i2, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
        Segment<K, V> segmentP = P(i2);
        segmentP.lock();
        try {
            return segmentP.newEntry(k2, i2, referenceEntry);
        } finally {
            segmentP.unlock();
        }
    }

    public final Segment<K, V>[] B(int i2) {
        return new Segment[i2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @VisibleForTesting
    public ValueReference<K, V> C(ReferenceEntry<K, V> referenceEntry, V v2, int i2) {
        return this.f6010b.referenceValue(P(referenceEntry.getHash()), referenceEntry, com.google.common.base.i.E(v2), i2);
    }

    public void G() {
        while (true) {
            RemovalNotification<K, V> removalNotificationPoll = this.f6005a.poll();
            if (removalNotificationPoll == null) {
                return;
            }
            try {
                this.f6002a.onRemoval(removalNotificationPoll);
            } catch (Throwable th) {
                f5994a.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    public void H(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        P(hash).reclaimKey(referenceEntry, hash);
    }

    public void I(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> referenceEntryD = valueReference.d();
        int hash = referenceEntryD.getHash();
        P(hash).reclaimValue(referenceEntryD.getKey(), hash, valueReference);
    }

    public boolean J() {
        return l();
    }

    public boolean K() {
        return L() || J();
    }

    public boolean L() {
        return m() || N();
    }

    public void M(K k2) {
        int iU = u(com.google.common.base.i.E(k2));
        P(iU).refresh(k2, iU, this.f5999a, false);
    }

    public boolean N() {
        return this.d > 0;
    }

    public Segment<K, V> P(int i2) {
        return this.f6007a[(i2 >>> this.L) & this.K];
    }

    public boolean S() {
        return T() || J();
    }

    public boolean T() {
        return l() || j();
    }

    public boolean U() {
        return this.f6001a != Strength.STRONG;
    }

    public boolean V() {
        return this.f6010b != Strength.STRONG;
    }

    public boolean W() {
        return X() || L();
    }

    public boolean X() {
        return m();
    }

    public void c() {
        for (Segment<K, V> segment : this.f6007a) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f6007a) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int iU = u(obj);
        return P(iU).containsKey(obj, iU);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        long jA = this.f5997a.a();
        Segment<K, V>[] segmentArr = this.f6007a;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            int length = segmentArr.length;
            long j3 = 0;
            for (?? r12 = z2; r12 < length; r12++) {
                Segment<K, V> segment = segmentArr[r12];
                int i3 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (?? r15 = z2; r15 < atomicReferenceArray.length(); r15++) {
                    ReferenceEntry<K, V> next = atomicReferenceArray.get(r15);
                    while (next != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(next, jA);
                        long j4 = jA;
                        if (liveValue != null && this.f6009b.equivalent(obj, liveValue)) {
                            return true;
                        }
                        next = next.getNext();
                        segmentArr = segmentArr2;
                        jA = j4;
                    }
                }
                j3 += (long) segment.modCount;
                jA = jA;
                z2 = false;
            }
            long j5 = jA;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            segmentArr = segmentArr3;
            jA = j5;
            z2 = false;
        }
        return z2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f6011b;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.f6011b = eVar;
        return eVar;
    }

    @VisibleForTesting
    public ReferenceEntry<K, V> f(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return P(referenceEntry.getHash()).copyEntry(referenceEntry, referenceEntry2);
    }

    public Segment<K, V> g(int i2, long j2, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, i2, j2, statsCounter);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iU = u(obj);
        return P(iU).get(obj, iU);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    public boolean h() {
        return this.f6003a != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f6007a;
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

    public boolean j() {
        return this.f5995a >= 0;
    }

    public boolean k() {
        return m() || l();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f6006a;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.f6006a = gVar;
        return gVar;
    }

    public boolean l() {
        return this.f6008b > 0;
    }

    public boolean m() {
        return this.c > 0;
    }

    public V n(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int iU = u(com.google.common.base.i.E(k2));
        return P(iU).get(k2, iU, cacheLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> o(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap linkedHashMapC0 = Maps.c0();
        LinkedHashSet linkedHashSetA = Sets.A();
        int i2 = 0;
        int i3 = 0;
        for (K k2 : iterable) {
            Object obj = get(k2);
            if (!linkedHashMapC0.containsKey(k2)) {
                linkedHashMapC0.put(k2, obj);
                if (obj == null) {
                    i3++;
                    linkedHashSetA.add(k2);
                } else {
                    i2++;
                }
            }
        }
        try {
            if (!linkedHashSetA.isEmpty()) {
                try {
                    Map mapY = y(linkedHashSetA, this.f5999a);
                    for (Object obj2 : linkedHashSetA) {
                        Object obj3 = mapY.get(obj2);
                        if (obj3 == null) {
                            String strValueOf = String.valueOf(obj2);
                            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
                            sb.append("loadAll failed to return a value for ");
                            sb.append(strValueOf);
                            throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                        }
                        linkedHashMapC0.put(obj2, obj3);
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : linkedHashSetA) {
                        i3--;
                        linkedHashMapC0.put(obj4, n(obj4, this.f5999a));
                    }
                }
            }
            ImmutableMap<K, V> immutableMapCopyOf = ImmutableMap.copyOf((Map) linkedHashMapC0);
            this.f5998a.f(i2);
            this.f5998a.e(i3);
            return immutableMapCopyOf;
        } catch (Throwable th) {
            this.f5998a.f(i2);
            this.f5998a.e(i3);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> p(Iterable<?> iterable) {
        LinkedHashMap linkedHashMapC0 = Maps.c0();
        int i2 = 0;
        int i3 = 0;
        for (Object obj : iterable) {
            V v2 = get(obj);
            if (v2 == null) {
                i3++;
            } else {
                linkedHashMapC0.put(obj, v2);
                i2++;
            }
        }
        this.f5998a.f(i2);
        this.f5998a.e(i3);
        return ImmutableMap.copyOf((Map) linkedHashMapC0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v2);
        int iU = u(k2);
        return P(iU).put(k2, iU, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v2);
        int iU = u(k2);
        return P(iU).put(k2, iU, v2, true);
    }

    public ReferenceEntry<K, V> q(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iU = u(obj);
        return P(iU).getEntry(obj, iU);
    }

    @NullableDecl
    public V r(Object obj) {
        int iU = u(com.google.common.base.i.E(obj));
        V v2 = P(iU).get(obj, iU);
        if (v2 == null) {
            this.f5998a.e(1);
        } else {
            this.f5998a.f(1);
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iU = u(obj);
        return P(iU).remove(obj, iU);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v3);
        if (v2 == null) {
            return false;
        }
        int iU = u(k2);
        return P(iU).replace(k2, iU, v2, v3);
    }

    @NullableDecl
    public V s(ReferenceEntry<K, V> referenceEntry, long j2) {
        V v2;
        if (referenceEntry.getKey() == null || (v2 = referenceEntry.getValueReference().get()) == null || w(referenceEntry, j2)) {
            return null;
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.x(z());
    }

    public V t(K k2) throws ExecutionException {
        return n(k2, this.f5999a);
    }

    public int u(@NullableDecl Object obj) {
        return O(this.f5996a.hash(obj));
    }

    public void v(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f6004a;
        if (collection != null) {
            return collection;
        }
        p pVar = new p();
        this.f6004a = pVar;
        return pVar;
    }

    public boolean w(ReferenceEntry<K, V> referenceEntry, long j2) {
        com.google.common.base.i.E(referenceEntry);
        if (!l() || j2 - referenceEntry.getAccessTime() < this.f6008b) {
            return m() && j2 - referenceEntry.getWriteTime() >= this.c;
        }
        return true;
    }

    @VisibleForTesting
    public boolean x(ReferenceEntry<K, V> referenceEntry, long j2) {
        return P(referenceEntry.getHash()).getLiveValue(referenceEntry, j2) != null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00cd  */
    @NullableDecl
    public Map<K, V> y(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws Throwable {
        com.google.common.base.i.E(cacheLoader);
        com.google.common.base.i.E(set);
        com.google.common.base.k kVarC = com.google.common.base.k.c();
        boolean z2 = true;
        boolean z3 = false;
        try {
            try {
                try {
                    try {
                        try {
                            Map<? super K, V> mapLoadAll = cacheLoader.loadAll(set);
                            if (mapLoadAll == null) {
                                this.f5998a.c(kVarC.g(TimeUnit.NANOSECONDS));
                                String strValueOf = String.valueOf(cacheLoader);
                                StringBuilder sb = new StringBuilder(strValueOf.length() + 31);
                                sb.append(strValueOf);
                                sb.append(" returned null map from loadAll");
                                throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                            }
                            kVarC.l();
                            for (Map.Entry<K, V> entry : mapLoadAll.entrySet()) {
                                K key = entry.getKey();
                                V value = entry.getValue();
                                if (key == null || value == null) {
                                    z3 = true;
                                } else {
                                    put(key, value);
                                }
                            }
                            if (!z3) {
                                this.f5998a.d(kVarC.g(TimeUnit.NANOSECONDS));
                                return mapLoadAll;
                            }
                            this.f5998a.c(kVarC.g(TimeUnit.NANOSECONDS));
                            String strValueOf2 = String.valueOf(cacheLoader);
                            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 42);
                            sb2.append(strValueOf2);
                            sb2.append(" returned null keys or values from loadAll");
                            throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
                        } catch (RuntimeException e2) {
                            throw new UncheckedExecutionException(e2);
                        }
                    } catch (InterruptedException e3) {
                        Thread.currentThread().interrupt();
                        throw new ExecutionException(e3);
                    }
                } catch (Error e4) {
                    throw new ExecutionError(e4);
                }
            } catch (CacheLoader.UnsupportedLoadingOperationException e5) {
                try {
                    throw e5;
                } catch (Throwable th) {
                    th = th;
                    if (!z2) {
                        this.f5998a.c(kVarC.g(TimeUnit.NANOSECONDS));
                    }
                    throw th;
                }
            } catch (Exception e6) {
                throw new ExecutionException(e6);
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
            if (!z2) {
                this.f5998a.c(kVarC.g(TimeUnit.NANOSECONDS));
            }
            throw th;
        }
    }

    public long z() {
        long jMax = 0;
        for (Segment<K, V> segment : this.f6007a) {
            jMax += (long) Math.max(0, segment.count);
        }
        return jMax;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iU = u(obj);
        return P(iU).remove(obj, iU, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        com.google.common.base.i.E(k2);
        com.google.common.base.i.E(v2);
        int iU = u(k2);
        return P(iU).replace(k2, iU, v2);
    }

    public static class Segment<K, V> extends ReentrantLock {

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;

        @NullableDecl
        final ReferenceQueue<K> keyReferenceQueue;

        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;

        @NullableDecl
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;

        @GuardedBy("this")
        long totalWeight;

        @NullableDecl
        final ReferenceQueue<V> valueReferenceQueue;

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        public class a implements Runnable {
            public final /* synthetic */ int K;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ h f6016a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ListenableFuture f6017a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Object f6018a;

            public a(Object obj, int i, h hVar, ListenableFuture listenableFuture) {
                this.f6018a = obj;
                this.K = i;
                this.f6016a = hVar;
                this.f6017a = listenableFuture;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Segment.this.getAndRecordStats(this.f6018a, this.K, this.f6016a, this.f6017a);
                } catch (Throwable th) {
                    LocalCache.f5994a.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.f6016a.k(th);
                }
            }
        }

        public Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache.StatsCounter statsCounter) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache.StatsCounter) com.google.common.base.i.E(statsCounter);
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.U() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.V() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.T() ? new ConcurrentLinkedQueue<>() : LocalCache.i();
            this.writeQueue = localCache.X() ? new y<>() : LocalCache.i();
            this.accessQueue = localCache.T() ? new c<>() : LocalCache.i();
        }

        public void cleanUp() {
            runLockedCleanup(this.map.f5997a.a());
            runUnlockedCleanup();
        }

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.f5997a.a());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry<K, V> next = atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                            if (next.getValueReference().isActive()) {
                                K key = next.getKey();
                                V v = next.getValueReference().get();
                                enqueueNotification(key, next.getHash(), v, next.getValueReference().a(), (key == null || v == null) ? RemovalCause.COLLECTED : RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        public void clearReferenceQueues() {
            if (this.map.U()) {
                clearKeyReferenceQueue();
            }
            if (this.map.V()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        public boolean containsKey(Object obj, int i) {
            try {
                if (this.count == 0) {
                    return false;
                }
                ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, this.map.f5997a.a());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        @VisibleForTesting
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long jA = this.map.f5997a.a();
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (ReferenceEntry<K, V> next = atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                            V liveValue = getLiveValue(next, jA);
                            if (liveValue != null && this.map.f6009b.equivalent(obj, liveValue)) {
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

        @GuardedBy("this")
        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> referenceEntryCopyEntry = this.map.f6000a.copyEntry(this, referenceEntry, referenceEntry2);
            referenceEntryCopyEntry.setValueReference(valueReference.b(this.valueReferenceQueue, v, referenceEntryCopyEntry));
            return referenceEntryCopyEntry;
        }

        @GuardedBy("this")
        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> referencePoll = this.keyReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.H((ReferenceEntry) referencePoll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        public void drainRecencyQueue() {
            while (true) {
                ReferenceEntry<K, V> referenceEntryPoll = this.recencyQueue.poll();
                if (referenceEntryPoll == null) {
                    return;
                }
                if (this.accessQueue.contains(referenceEntryPoll)) {
                    this.accessQueue.add(referenceEntryPoll);
                }
            }
        }

        @GuardedBy("this")
        public void drainReferenceQueues() {
            if (this.map.U()) {
                drainKeyReferenceQueue();
            }
            if (this.map.V()) {
                drainValueReferenceQueue();
            }
        }

        @GuardedBy("this")
        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> referencePoll = this.valueReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.I((ValueReference) referencePoll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        public void enqueueNotification(@NullableDecl K k, int i, @NullableDecl V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= (long) i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.b();
            }
            if (this.map.f6005a != LocalCache.b) {
                this.map.f6005a.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        @GuardedBy("this")
        public void evictEntries(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.j()) {
                drainRecencyQueue();
                if (referenceEntry.getValueReference().a() > this.maxSegmentWeight && !removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    ReferenceEntry<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                ReferenceEntry<K, V> next = atomicReferenceArray.get(i2);
                if (next != null) {
                    ReferenceEntry<K, V> next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        ReferenceEntry<K, V> referenceEntry = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                referenceEntry = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, referenceEntry);
                        while (next != referenceEntry) {
                            int hash3 = next.getHash() & length2;
                            ReferenceEntry<K, V> referenceEntryCopyEntry = copyEntry(next, atomicReferenceArrayNewEntryArray.get(hash3));
                            if (referenceEntryCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, referenceEntryCopyEntry);
                            } else {
                                removeCollectedEntry(next);
                                i--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArrayNewEntryArray;
            this.count = i;
        }

        @GuardedBy("this")
        public void expireEntries(long j) {
            ReferenceEntry<K, V> referenceEntryPeek;
            ReferenceEntry<K, V> referenceEntryPeek2;
            drainRecencyQueue();
            do {
                referenceEntryPeek = this.writeQueue.peek();
                if (referenceEntryPeek == null || !this.map.w(referenceEntryPeek, j)) {
                    do {
                        referenceEntryPeek2 = this.accessQueue.peek();
                        if (referenceEntryPeek2 == null || !this.map.w(referenceEntryPeek2, j)) {
                            return;
                        }
                    } while (removeEntry(referenceEntryPeek2, referenceEntryPeek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(referenceEntryPeek, referenceEntryPeek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            ReferenceEntry<K, V> entry;
            com.google.common.base.i.E(k);
            com.google.common.base.i.E(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k, i)) != null) {
                        long jA = this.map.f5997a.a();
                        V liveValue = getLiveValue(entry, jA);
                        if (liveValue != null) {
                            recordRead(entry, jA);
                            this.statsCounter.f(1);
                            V vScheduleRefresh = scheduleRefresh(entry, k, i, liveValue, jA, cacheLoader);
                            postReadCleanup();
                            return vScheduleRefresh;
                        }
                        ValueReference<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            V vWaitForLoadingValue = waitForLoadingValue(entry, k, valueReference);
                            postReadCleanup();
                            return vWaitForLoadingValue;
                        }
                    }
                    V vLockedGetOrLoad = lockedGetOrLoad(k, i, cacheLoader);
                    postReadCleanup();
                    return vLockedGetOrLoad;
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e;
                }
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        public V getAndRecordStats(K k, int i, h<K, V> hVar, ListenableFuture<V> listenableFuture) throws Throwable {
            V v;
            try {
                v = (V) com.google.common.util.concurrent.s.f(listenableFuture);
                try {
                    if (v != null) {
                        this.statsCounter.d(hVar.f());
                        storeLoadedValue(k, i, hVar, v);
                        return v;
                    }
                    String strValueOf = String.valueOf(k);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                    sb.append("CacheLoader returned null for key ");
                    sb.append(strValueOf);
                    sb.append(Consts.DOT);
                    throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                } catch (Throwable th) {
                    th = th;
                    if (v == null) {
                        this.statsCounter.c(hVar.f());
                        removeLoadingValue(k, i, hVar);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v = null;
            }
        }

        @NullableDecl
        public ReferenceEntry<K, V> getEntry(Object obj, int i) {
            for (ReferenceEntry<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f5996a.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public ReferenceEntry<K, V> getFirst(int i) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        @NullableDecl
        public ReferenceEntry<K, V> getLiveEntry(Object obj, int i, long j) {
            ReferenceEntry<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.w(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        public V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.w(referenceEntry, j)) {
                return v;
            }
            tryExpireEntries(j);
            return null;
        }

        @GuardedBy("this")
        public ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().a() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.h()) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        @NullableDecl
        public h<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long jA = this.map.f5997a.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.f5996a.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        if (!valueReference.isLoading() && (!z || jA - next.getWriteTime() >= this.map.d)) {
                            this.modCount++;
                            h<K, V> hVar = new h<>(valueReference);
                            next.setValueReference(hVar);
                            return hVar;
                        }
                        return null;
                    }
                }
                this.modCount++;
                h<K, V> hVar2 = new h<>();
                ReferenceEntry<K, V> referenceEntryNewEntry = newEntry(k, i, referenceEntry);
                referenceEntryNewEntry.setValueReference(hVar2);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                return hVar2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public ListenableFuture<V> loadAsync(K k, int i, h<K, V> hVar, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> listenableFutureI = hVar.i(k, cacheLoader);
            listenableFutureI.addListener(new a(k, i, hVar, listenableFutureI), com.google.common.util.concurrent.j.c());
            return listenableFutureI;
        }

        public V loadSync(K k, int i, h<K, V> hVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, hVar, hVar.i(k, cacheLoader));
        }

        public V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            h<K, V> hVar;
            boolean z;
            ValueReference<K, V> valueReference;
            V vLoadSync;
            lock();
            try {
                long jA = this.map.f5997a.a();
                preWriteCleanup(jA);
                int i2 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntryNewEntry = referenceEntry;
                while (true) {
                    hVar = null;
                    if (referenceEntryNewEntry == null) {
                        z = true;
                        valueReference = null;
                        break;
                    }
                    K key = referenceEntryNewEntry.getKey();
                    if (referenceEntryNewEntry.getHash() == i && key != null && this.map.f5996a.equivalent(k, key)) {
                        ValueReference<K, V> valueReference2 = referenceEntryNewEntry.getValueReference();
                        if (valueReference2.isLoading()) {
                            z = false;
                        } else {
                            V v = valueReference2.get();
                            if (v == null) {
                                enqueueNotification(key, i, v, valueReference2.a(), RemovalCause.COLLECTED);
                            } else {
                                if (!this.map.w(referenceEntryNewEntry, jA)) {
                                    recordLockedRead(referenceEntryNewEntry, jA);
                                    this.statsCounter.f(1);
                                    unlock();
                                    postWriteCleanup();
                                    return v;
                                }
                                enqueueNotification(key, i, v, valueReference2.a(), RemovalCause.EXPIRED);
                            }
                            this.writeQueue.remove(referenceEntryNewEntry);
                            this.accessQueue.remove(referenceEntryNewEntry);
                            this.count = i2;
                            z = true;
                        }
                        valueReference = valueReference2;
                        break;
                    }
                    referenceEntryNewEntry = referenceEntryNewEntry.getNext();
                }
                if (z) {
                    hVar = new h<>();
                    if (referenceEntryNewEntry == null) {
                        referenceEntryNewEntry = newEntry(k, i, referenceEntry);
                        referenceEntryNewEntry.setValueReference(hVar);
                        atomicReferenceArray.set(length, referenceEntryNewEntry);
                    } else {
                        referenceEntryNewEntry.setValueReference(hVar);
                    }
                }
                unlock();
                postWriteCleanup();
                if (!z) {
                    return waitForLoadingValue(referenceEntryNewEntry, k, valueReference);
                }
                try {
                    synchronized (referenceEntryNewEntry) {
                        vLoadSync = loadSync(k, i, hVar, cacheLoader);
                    }
                    this.statsCounter.e(1);
                    return vLoadSync;
                } catch (Throwable th) {
                    this.statsCounter.e(1);
                    throw th;
                }
            } catch (Throwable th2) {
                unlock();
                postWriteCleanup();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @GuardedBy("this")
        public ReferenceEntry<K, V> newEntry(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            return this.map.f6000a.newEntry(this, com.google.common.base.i.E(k), i, referenceEntry);
        }

        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @GuardedBy("this")
        public void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        @NullableDecl
        public V put(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long jA = this.map.f5997a.a();
                preWriteCleanup(jA);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.f5996a.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            if (z) {
                                recordLockedRead(next, jA);
                            } else {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.a(), RemovalCause.REPLACED);
                                setValue(next, k, v, jA);
                                evictEntries(next);
                            }
                            return v2;
                        }
                        this.modCount++;
                        if (valueReference.isActive()) {
                            enqueueNotification(k, i, v2, valueReference.a(), RemovalCause.COLLECTED);
                            setValue(next, k, v, jA);
                            i2 = this.count;
                        } else {
                            setValue(next, k, v, jA);
                            i2 = this.count + 1;
                        }
                        this.count = i2;
                        evictEntries(next);
                        return null;
                    }
                }
                this.modCount++;
                ReferenceEntry<K, V> referenceEntryNewEntry = newEntry(k, i, referenceEntry);
                setValue(referenceEntryNewEntry, k, v, jA);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                this.count++;
                evictEntries(referenceEntryNewEntry);
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry2; next != null; next = next.getNext()) {
                    if (next == referenceEntry) {
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry2, next, next.getKey(), i, next.getValueReference().get(), next.getValueReference(), RemovalCause.COLLECTED);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimValue(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.f5996a.equivalent(k, key)) {
                        if (next.getValueReference() != valueReference) {
                            return false;
                        }
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, valueReference.get(), valueReference, RemovalCause.COLLECTED);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        @GuardedBy("this")
        public void recordLockedRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.J()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        public void recordRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.J()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @GuardedBy("this")
        public void recordWrite(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += (long) i;
            if (this.map.J()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.L()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        @NullableDecl
        public V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            h<K, V> hVarInsertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (hVarInsertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> listenableFutureLoadAsync = loadAsync(k, i, hVarInsertLoadingValueReference, cacheLoader);
            if (listenableFutureLoadAsync.isDone()) {
                try {
                    return (V) com.google.common.util.concurrent.s.f(listenableFutureLoadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        @NullableDecl
        public V remove(Object obj, int i) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.f5997a.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.f5996a.equivalent(obj, key)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v = valueReference.get();
                        if (v == null) {
                            if (!valueReference.isActive()) {
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            removalCause = RemovalCause.EXPLICIT;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, v, valueReference, removalCause2);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @GuardedBy("this")
        public void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().a(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        @VisibleForTesting
        @GuardedBy("this")
        public boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> next = referenceEntry2; next != null; next = next.getNext()) {
                if (next == referenceEntry) {
                    this.modCount++;
                    ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry2, next, next.getKey(), i, next.getValueReference().get(), next.getValueReference(), removalCause);
                    int i2 = this.count - 1;
                    atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                    this.count = i2;
                    return true;
                }
            }
            return false;
        }

        @NullableDecl
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = copyEntry(referenceEntry, next);
                if (referenceEntryCopyEntry != null) {
                    next = referenceEntryCopyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        public boolean removeLoadingValue(K k, int i, h<K, V> hVar) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.f5996a.equivalent(k, key)) {
                        if (next.getValueReference() != hVar) {
                            break;
                        }
                        if (hVar.isActive()) {
                            next.setValueReference(hVar.h());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, next));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @NullableDecl
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @NullableDecl K k, int i, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            enqueueNotification(k, i, v, valueReference.a(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return removeEntryFromChain(referenceEntry, referenceEntry2);
            }
            valueReference.c(null);
            return referenceEntry;
        }

        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                long jA = this.map.f5997a.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null) {
                        if (this.map.f5996a.equivalent(k, key)) {
                            ValueReference<K, V> valueReference = next.getValueReference();
                            V v3 = valueReference.get();
                            if (v3 != null) {
                                if (!this.map.f6009b.equivalent(v, v3)) {
                                    recordLockedRead(next, jA);
                                    break;
                                }
                                this.modCount++;
                                enqueueNotification(k, i, v3, valueReference.a(), RemovalCause.REPLACED);
                                setValue(next, k, v2, jA);
                                evictEntries(next);
                                return true;
                            }
                            if (!valueReference.isActive()) {
                                break;
                            }
                            this.modCount++;
                            ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, v3, valueReference, RemovalCause.COLLECTED);
                            int i2 = this.count - 1;
                            atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                            this.count = i2;
                            break;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.G();
        }

        public V scheduleRefresh(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V vRefresh;
            return (!this.map.N() || j - referenceEntry.getWriteTime() <= this.map.d || referenceEntry.getValueReference().isLoading() || (vRefresh = refresh(k, i, cacheLoader, true)) == null) ? v : vRefresh;
        }

        @GuardedBy("this")
        public void setValue(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int iWeigh = this.map.f6003a.weigh(k, v);
            com.google.common.base.i.h0(iWeigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.f6010b.referenceValue(this, referenceEntry, v, iWeigh));
            recordWrite(referenceEntry, iWeigh, j);
            valueReference.c(v);
        }

        public boolean storeLoadedValue(K k, int i, h<K, V> hVar, V v) {
            lock();
            try {
                long jA = this.map.f5997a.a();
                preWriteCleanup(jA);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.f5996a.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v2 = valueReference.get();
                        if (hVar != valueReference && (v2 != null || valueReference == LocalCache.f31618a)) {
                            enqueueNotification(k, i, v, 0, RemovalCause.REPLACED);
                            return false;
                        }
                        this.modCount++;
                        if (hVar.isActive()) {
                            enqueueNotification(k, i, v2, hVar.a(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i3--;
                        }
                        setValue(next, k, v, jA);
                        this.count = i3;
                        evictEntries(next);
                        return true;
                    }
                }
                this.modCount++;
                ReferenceEntry<K, V> referenceEntryNewEntry = newEntry(k, i, referenceEntry);
                setValue(referenceEntryNewEntry, k, v, jA);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                this.count = i3;
                evictEntries(referenceEntryNewEntry);
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) throws ExecutionException {
            if (!valueReference.isLoading()) {
                throw new AssertionError();
            }
            com.google.common.base.i.x0(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k);
            try {
                V vE = valueReference.e();
                if (vE != null) {
                    recordRead(referenceEntry, this.map.f5997a.a());
                    this.statsCounter.e(1);
                    return vE;
                }
                String strValueOf = String.valueOf(k);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                sb.append("CacheLoader returned null for key ");
                sb.append(strValueOf);
                sb.append(Consts.DOT);
                throw new CacheLoader.InvalidCacheLoadException(sb.toString());
            } catch (Throwable th) {
                this.statsCounter.e(1);
                throw th;
            }
        }

        @NullableDecl
        public V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long jA = this.map.f5997a.a();
                    ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, jA);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, jA);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i, v, jA, this.map.f5999a);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        public boolean remove(Object obj, int i, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.f5997a.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.f5996a.equivalent(obj, key)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v = valueReference.get();
                        if (this.map.f6009b.equivalent(obj2, v)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (v != null || !valueReference.isActive()) {
                                break;
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, v, valueReference, removalCause);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return removalCause == RemovalCause.EXPLICIT;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @NullableDecl
        public V replace(K k, int i, V v) {
            lock();
            try {
                long jA = this.map.f5997a.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null) {
                        if (this.map.f5996a.equivalent(k, key)) {
                            ValueReference<K, V> valueReference = next.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 == null) {
                                if (!valueReference.isActive()) {
                                    break;
                                }
                                this.modCount++;
                                ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, v2, valueReference, RemovalCause.COLLECTED);
                                int i2 = this.count - 1;
                                atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                                this.count = i2;
                                break;
                            }
                            this.modCount++;
                            enqueueNotification(k, i, v2, valueReference.a(), RemovalCause.REPLACED);
                            setValue(next, k, v, jA);
                            evictEntries(next);
                            return v2;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }
    }
}
