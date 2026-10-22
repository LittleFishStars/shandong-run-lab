package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.d entrySet;
    final f<K, V> header;
    private LinkedHashTreeMap<K, V>.e keySet;
    int modCount;
    int size;
    f<K, V>[] table;
    int threshold;

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f<K, V> f23396a;
        public f<K, V> b = null;

        public LinkedTreeMapIterator() {
            this.f23396a = LinkedHashTreeMap.this.header.d;
            this.K = LinkedHashTreeMap.this.modCount;
        }

        public final f<K, V> a() {
            f<K, V> fVar = this.f23396a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (fVar == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedHashTreeMap.modCount != this.K) {
                throw new ConcurrentModificationException();
            }
            this.f23396a = fVar.d;
            this.b = fVar;
            return fVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f23396a != LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            f<K, V> fVar = this.b;
            if (fVar == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(fVar, true);
            this.b = null;
            this.K = LinkedHashTreeMap.this.modCount;
        }
    }

    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public static final class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23397a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public f<K, V> f592a;
        public int b;
        public int c;

        public void a(f<K, V> fVar) {
            fVar.c = null;
            fVar.f23403a = null;
            fVar.b = null;
            fVar.L = 1;
            int i = this.f23397a;
            if (i > 0) {
                int i2 = this.c;
                if ((i2 & 1) == 0) {
                    this.c = i2 + 1;
                    this.f23397a = i - 1;
                    this.b++;
                }
            }
            fVar.f23403a = this.f592a;
            this.f592a = fVar;
            int i3 = this.c + 1;
            this.c = i3;
            int i4 = this.f23397a;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.c = i3 + 1;
                this.f23397a = i4 - 1;
                this.b++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.c & i6) != i6) {
                    return;
                }
                int i7 = this.b;
                if (i7 == 0) {
                    f<K, V> fVar2 = this.f592a;
                    f<K, V> fVar3 = fVar2.f23403a;
                    f<K, V> fVar4 = fVar3.f23403a;
                    fVar3.f23403a = fVar4.f23403a;
                    this.f592a = fVar3;
                    fVar3.b = fVar4;
                    fVar3.c = fVar2;
                    fVar3.L = fVar2.L + 1;
                    fVar4.f23403a = fVar3;
                    fVar2.f23403a = fVar3;
                } else if (i7 == 1) {
                    f<K, V> fVar5 = this.f592a;
                    f<K, V> fVar6 = fVar5.f23403a;
                    this.f592a = fVar6;
                    fVar6.c = fVar5;
                    fVar6.L = fVar5.L + 1;
                    fVar5.f23403a = fVar6;
                    this.b = 0;
                } else if (i7 == 2) {
                    this.b = 0;
                }
                i5 *= 2;
            }
        }

        public void b(int i) {
            this.f23397a = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.c = 0;
            this.b = 0;
            this.f592a = null;
        }

        public f<K, V> c() {
            f<K, V> fVar = this.f592a;
            if (fVar.f23403a == null) {
                return fVar;
            }
            throw new IllegalStateException();
        }
    }

    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f<K, V> f23398a;

        public f<K, V> a() {
            f<K, V> fVar = this.f23398a;
            if (fVar == null) {
                return null;
            }
            f<K, V> fVar2 = fVar.f23403a;
            fVar.f23403a = null;
            f<K, V> fVar3 = fVar.c;
            while (true) {
                f<K, V> fVar4 = fVar2;
                fVar2 = fVar3;
                if (fVar2 == null) {
                    this.f23398a = fVar4;
                    return fVar;
                }
                fVar2.f23403a = fVar4;
                fVar3 = fVar2.b;
            }
        }

        public void b(f<K, V> fVar) {
            f<K, V> fVar2 = null;
            while (fVar != null) {
                fVar.f23403a = fVar2;
                fVar2 = fVar;
                fVar = fVar.b;
            }
            this.f23398a = fVar2;
        }
    }

    public final class d extends AbstractSet<Map.Entry<K, V>> {

        public class a extends LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            f<K, V> fVarFindByEntry;
            if (!(obj instanceof Map.Entry) || (fVarFindByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(fVarFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public final class e extends AbstractSet<K> {

        public class a extends LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f593a;
            }
        }

        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public LinkedHashTreeMap() {
        this(null);
    }

    private void doubleCapacity() {
        f<K, V>[] fVarArrDoubleCapacity = doubleCapacity(this.table);
        this.table = fVarArrDoubleCapacity;
        this.threshold = (fVarArrDoubleCapacity.length / 2) + (fVarArrDoubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(f<K, V> fVar, boolean z) {
        while (fVar != null) {
            f<K, V> fVar2 = fVar.b;
            f<K, V> fVar3 = fVar.c;
            int i = fVar2 != null ? fVar2.L : 0;
            int i2 = fVar3 != null ? fVar3.L : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                f<K, V> fVar4 = fVar3.b;
                f<K, V> fVar5 = fVar3.c;
                int i4 = (fVar4 != null ? fVar4.L : 0) - (fVar5 != null ? fVar5.L : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(fVar);
                } else {
                    rotateRight(fVar3);
                    rotateLeft(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                f<K, V> fVar6 = fVar2.b;
                f<K, V> fVar7 = fVar2.c;
                int i5 = (fVar6 != null ? fVar6.L : 0) - (fVar7 != null ? fVar7.L : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(fVar);
                } else {
                    rotateLeft(fVar2);
                    rotateRight(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                fVar.L = i + 1;
                if (z) {
                    return;
                }
            } else {
                fVar.L = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            fVar = fVar.f23403a;
        }
    }

    private void replaceInParent(f<K, V> fVar, f<K, V> fVar2) {
        f<K, V> fVar3 = fVar.f23403a;
        fVar.f23403a = null;
        if (fVar2 != null) {
            fVar2.f23403a = fVar3;
        }
        if (fVar3 == null) {
            int i = fVar.K;
            f<K, V>[] fVarArr = this.table;
            fVarArr[i & (fVarArr.length - 1)] = fVar2;
        } else if (fVar3.b == fVar) {
            fVar3.b = fVar2;
        } else {
            fVar3.c = fVar2;
        }
    }

    private void rotateLeft(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.b;
        f<K, V> fVar3 = fVar.c;
        f<K, V> fVar4 = fVar3.b;
        f<K, V> fVar5 = fVar3.c;
        fVar.c = fVar4;
        if (fVar4 != null) {
            fVar4.f23403a = fVar;
        }
        replaceInParent(fVar, fVar3);
        fVar3.b = fVar;
        fVar.f23403a = fVar3;
        int iMax = Math.max(fVar2 != null ? fVar2.L : 0, fVar4 != null ? fVar4.L : 0) + 1;
        fVar.L = iMax;
        fVar3.L = Math.max(iMax, fVar5 != null ? fVar5.L : 0) + 1;
    }

    private void rotateRight(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.b;
        f<K, V> fVar3 = fVar.c;
        f<K, V> fVar4 = fVar2.b;
        f<K, V> fVar5 = fVar2.c;
        fVar.b = fVar5;
        if (fVar5 != null) {
            fVar5.f23403a = fVar;
        }
        replaceInParent(fVar, fVar2);
        fVar2.c = fVar;
        fVar.f23403a = fVar2;
        int iMax = Math.max(fVar3 != null ? fVar3.L : 0, fVar5 != null ? fVar5.L : 0) + 1;
        fVar.L = iMax;
        fVar2.L = Math.max(iMax, fVar4 != null ? fVar4.L : 0) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        f<K, V> fVar = this.header;
        f<K, V> fVar2 = fVar.d;
        while (fVar2 != fVar) {
            f<K, V> fVar3 = fVar2.d;
            fVar2.e = null;
            fVar2.d = null;
            fVar2 = fVar3;
        }
        fVar.e = fVar;
        fVar.d = fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    public f<K, V> find(K k, boolean z) {
        int iCompareTo;
        f<K, V> fVar;
        Comparator<? super K> comparator = this.comparator;
        f<K, V>[] fVarArr = this.table;
        int iSecondaryHash = secondaryHash(k.hashCode());
        int length = (fVarArr.length - 1) & iSecondaryHash;
        f<K, V> fVar2 = fVarArr[length];
        if (fVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(fVar2.f593a) : comparator.compare(k, fVar2.f593a);
                if (iCompareTo == 0) {
                    return fVar2;
                }
                f<K, V> fVar3 = iCompareTo < 0 ? fVar2.b : fVar2.c;
                if (fVar3 == null) {
                    break;
                }
                fVar2 = fVar3;
            }
        } else {
            iCompareTo = 0;
        }
        f<K, V> fVar4 = fVar2;
        int i = iCompareTo;
        if (!z) {
            return null;
        }
        f<K, V> fVar5 = this.header;
        if (fVar4 != null) {
            fVar = new f<>(fVar4, k, iSecondaryHash, fVar5, fVar5.e);
            if (i < 0) {
                fVar4.b = fVar;
            } else {
                fVar4.c = fVar;
            }
            rebalance(fVar4, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            fVar = new f<>(fVar4, k, iSecondaryHash, fVar5, fVar5.e);
            fVarArr[length] = fVar;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return fVar;
    }

    public f<K, V> findByEntry(Map.Entry<?, ?> entry) {
        f<K, V> fVarFindByObject = findByObject(entry.getKey());
        if (fVarFindByObject != null && equal(fVarFindByObject.f594b, entry.getValue())) {
            return fVarFindByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        f<K, V> fVarFindByObject = findByObject(obj);
        if (fVarFindByObject != null) {
            return fVarFindByObject.f594b;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        f<K, V> fVarFind = find(k, true);
        V v2 = fVarFind.f594b;
        fVarFind.f594b = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f<K, V> fVarRemoveInternalByKey = removeInternalByKey(obj);
        if (fVarRemoveInternalByKey != null) {
            return fVarRemoveInternalByKey.f594b;
        }
        return null;
    }

    public void removeInternal(f<K, V> fVar, boolean z) {
        int i;
        if (z) {
            f<K, V> fVar2 = fVar.e;
            fVar2.d = fVar.d;
            fVar.d.e = fVar2;
            fVar.e = null;
            fVar.d = null;
        }
        f<K, V> fVar3 = fVar.b;
        f<K, V> fVar4 = fVar.c;
        f<K, V> fVar5 = fVar.f23403a;
        int i2 = 0;
        if (fVar3 == null || fVar4 == null) {
            if (fVar3 != null) {
                replaceInParent(fVar, fVar3);
                fVar.b = null;
            } else if (fVar4 != null) {
                replaceInParent(fVar, fVar4);
                fVar.c = null;
            } else {
                replaceInParent(fVar, null);
            }
            rebalance(fVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        f<K, V> fVarB = fVar3.L > fVar4.L ? fVar3.b() : fVar4.a();
        removeInternal(fVarB, false);
        f<K, V> fVar6 = fVar.b;
        if (fVar6 != null) {
            i = fVar6.L;
            fVarB.b = fVar6;
            fVar6.f23403a = fVarB;
            fVar.b = null;
        } else {
            i = 0;
        }
        f<K, V> fVar7 = fVar.c;
        if (fVar7 != null) {
            i2 = fVar7.L;
            fVarB.c = fVar7;
            fVar7.f23403a = fVarB;
            fVar.c = null;
        }
        fVarB.L = Math.max(i, i2) + 1;
        replaceInParent(fVar, fVarB);
    }

    public f<K, V> removeInternalByKey(Object obj) {
        f<K, V> fVarFindByObject = findByObject(obj);
        if (fVarFindByObject != null) {
            removeInternal(fVarFindByObject, true);
        }
        return fVarFindByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new f<>();
        f<K, V>[] fVarArr = new f[16];
        this.table = fVarArr;
        this.threshold = (fVarArr.length / 2) + (fVarArr.length / 4);
    }

    public static <K, V> f<K, V>[] doubleCapacity(f<K, V>[] fVarArr) {
        int length = fVarArr.length;
        f<K, V>[] fVarArr2 = new f[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i = 0; i < length; i++) {
            f<K, V> fVar = fVarArr[i];
            if (fVar != null) {
                cVar.b(fVar);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    f<K, V> fVarA = cVar.a();
                    if (fVarA == null) {
                        break;
                    }
                    if ((fVarA.K & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                bVar.b(i2);
                bVar2.b(i3);
                cVar.b(fVar);
                while (true) {
                    f<K, V> fVarA2 = cVar.a();
                    if (fVarA2 == null) {
                        break;
                    }
                    if ((fVarA2.K & length) == 0) {
                        bVar.a(fVarA2);
                    } else {
                        bVar2.a(fVarA2);
                    }
                }
                fVarArr2[i] = i2 > 0 ? bVar.c() : null;
                fVarArr2[i + length] = i3 > 0 ? bVar2.c() : null;
            }
        }
        return fVarArr2;
    }

    public static final class f<K, V> implements Map.Entry<K, V> {
        public final int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f<K, V> f23403a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final K f593a;
        public f<K, V> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public V f594b;
        public f<K, V> c;
        public f<K, V> d;
        public f<K, V> e;

        public f() {
            this.f593a = null;
            this.K = -1;
            this.e = this;
            this.d = this;
        }

        public f<K, V> a() {
            f<K, V> fVar = this;
            for (f<K, V> fVar2 = this.b; fVar2 != null; fVar2 = fVar2.b) {
                fVar = fVar2;
            }
            return fVar;
        }

        public f<K, V> b() {
            f<K, V> fVar = this;
            for (f<K, V> fVar2 = this.c; fVar2 != null; fVar2 = fVar2.c) {
                fVar = fVar2;
            }
            return fVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f593a;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f594b;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f593a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f594b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f593a;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.f594b;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f594b;
            this.f594b = v;
            return v2;
        }

        public String toString() {
            return this.f593a + "=" + this.f594b;
        }

        public f(f<K, V> fVar, K k, int i, f<K, V> fVar2, f<K, V> fVar3) {
            this.f23403a = fVar;
            this.f593a = k;
            this.K = i;
            this.L = 1;
            this.d = fVar2;
            this.e = fVar3;
            fVar3.d = this;
            fVar2.e = this;
        }
    }
}
