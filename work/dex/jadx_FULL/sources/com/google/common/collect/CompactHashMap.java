package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {

    @VisibleForTesting
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = new Object();

    @VisibleForTesting
    @CheckForNull
    transient int[] entries;

    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySetView;

    @CheckForNull
    private transient Set<K> keySetView;

    @VisibleForTesting
    @CheckForNull
    transient Object[] keys;
    private transient int metadata;
    private transient int size;

    @CheckForNull
    private transient Object table;

    @VisibleForTesting
    @CheckForNull
    transient Object[] values;

    @CheckForNull
    private transient Collection<V> valuesView;

    public class a extends CompactHashMap<K, V>.Itr<K> {
        public a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.Itr
        @ParametricNullness
        public K b(int i) {
            return (K) CompactHashMap.this.key(i);
        }
    }

    public class b extends CompactHashMap<K, V>.Itr<Map.Entry<K, V>> {
        public b() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.Itr
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i) {
            return new f(i);
        }
    }

    public class c extends CompactHashMap<K, V>.Itr<V> {
        public c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.Itr
        @ParametricNullness
        public V b(int i) {
            return (V) CompactHashMap.this.value(i);
        }
    }

    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iIndexOf = CompactHashMap.this.indexOf(entry.getKey());
            return iIndexOf != -1 && com.google.common.base.g.a(CompactHashMap.this.value(iIndexOf), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int iHashTableMask = CompactHashMap.this.hashTableMask();
            int iF = com.google.common.collect.c.f(entry.getKey(), entry.getValue(), iHashTableMask, CompactHashMap.this.requireTable(), CompactHashMap.this.requireEntries(), CompactHashMap.this.requireKeys(), CompactHashMap.this.requireValues());
            if (iF == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(iF, iHashTableMask);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public class e extends AbstractSet<K> {
        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.keySet().remove(obj);
            }
            return CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public final class f extends AbstractMapEntry<K, V> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @ParametricNullness
        public final K f6050a;

        public f(int i) {
            this.f6050a = (K) CompactHashMap.this.key(i);
            this.K = i;
        }

        public final void a() {
            int i = this.K;
            if (i == -1 || i >= CompactHashMap.this.size() || !com.google.common.base.g.a(this.f6050a, CompactHashMap.this.key(this.K))) {
                this.K = CompactHashMap.this.indexOf(this.f6050a);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.f6050a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return (V) q.a(mapDelegateOrNull.get(this.f6050a));
            }
            a();
            int i = this.K;
            return i == -1 ? (V) q.b() : (V) CompactHashMap.this.value(i);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return (V) q.a(mapDelegateOrNull.put(this.f6050a, v));
            }
            a();
            int i = this.K;
            if (i == -1) {
                CompactHashMap.this.put(this.f6050a, v);
                return (V) q.b();
            }
            V v2 = (V) CompactHashMap.this.value(i);
            CompactHashMap.this.setValue(this.K, v);
            return v2;
        }
    }

    public class g extends AbstractCollection<V> {
        public g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i = compactHashMap.size;
        compactHashMap.size = i - 1;
        return i;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    private int entry(int i) {
        return requireEntries()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int iD = m.d(obj);
        int iHashTableMask = hashTableMask();
        int iH = com.google.common.collect.c.h(requireTable(), iD & iHashTableMask);
        if (iH == 0) {
            return -1;
        }
        int iB = com.google.common.collect.c.b(iD, iHashTableMask);
        do {
            int i = iH - 1;
            int iEntry = entry(i);
            if (com.google.common.collect.c.b(iEntry, iHashTableMask) == iB && com.google.common.base.g.a(obj, key(i))) {
                return i;
            }
            iH = com.google.common.collect.c.c(iEntry, iHashTableMask);
        } while (iH != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K key(int i) {
        return (K) requireKeys()[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid size: ");
            sb.append(i);
            throw new InvalidObjectException(sb.toString());
        }
        init(i);
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object removeHelper(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int iHashTableMask = hashTableMask();
        int iF = com.google.common.collect.c.f(obj, null, iHashTableMask, requireTable(), requireEntries(), requireKeys(), null);
        if (iF == -1) {
            return NOT_FOUND;
        }
        V vValue = value(iF);
        moveLastEntry(iF, iHashTableMask);
        this.size--;
        incrementModCount();
        return vValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireKeys() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object requireTable() {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireValues() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void resizeMeMaybe(int i) {
        int iMin;
        int length = requireEntries().length;
        if (i <= length || (iMin = Math.min(com.google.common.collect.c.d, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(iMin);
    }

    @CanIgnoreReturnValue
    private int resizeTable(int i, int i2, int i3, int i4) {
        Object objA = com.google.common.collect.c.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            com.google.common.collect.c.i(objA, i3 & i5, i4 + 1);
        }
        Object objRequireTable = requireTable();
        int[] iArrRequireEntries = requireEntries();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = com.google.common.collect.c.h(objRequireTable, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrRequireEntries[i7];
                int iB = com.google.common.collect.c.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = com.google.common.collect.c.h(objA, i9);
                com.google.common.collect.c.i(objA, i9, iH);
                iArrRequireEntries[i7] = com.google.common.collect.c.d(iB, iH2, i5);
                iH = com.google.common.collect.c.c(i8, i);
            }
        }
        this.table = objA;
        setHashTableMask(i5);
        return i5;
    }

    private void setEntry(int i, int i2) {
        requireEntries()[i] = i2;
    }

    private void setHashTableMask(int i) {
        this.metadata = com.google.common.collect.c.d(this.metadata, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    private void setKey(int i, K k) {
        requireKeys()[i] = k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, V v) {
        requireValues()[i] = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V value(int i) {
        return (V) requireValues()[i];
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> itEntrySetIterator = entrySetIterator();
        while (itEntrySetIterator.hasNext()) {
            Map.Entry<K, V> next = itEntrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public void accessEntry(int i) {
    }

    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    @CanIgnoreReturnValue
    public int allocArrays() {
        com.google.common.base.i.h0(needsAllocArrays(), "Arrays already allocated");
        int i = this.metadata;
        int iJ = com.google.common.collect.c.j(i);
        this.table = com.google.common.collect.c.a(iJ);
        setHashTableMask(iJ - 1);
        this.entries = new int[i];
        this.keys = new Object[i];
        this.values = new Object[i];
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            this.metadata = Ints.g(size(), 3, com.google.common.collect.c.d);
            mapDelegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireKeys(), 0, this.size, (Object) null);
        Arrays.fill(requireValues(), 0, this.size, (Object) null);
        com.google.common.collect.c.g(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsKey(obj);
        }
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsValue(obj);
        }
        for (int i = 0; i < this.size; i++) {
            if (com.google.common.base.g.a(obj, value(i))) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            mapCreateHashFloodingResistantDelegate.put(key(iFirstEntryIndex), value(iFirstEntryIndex));
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.table = mapCreateHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return mapCreateHashFloodingResistantDelegate;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    public Map<K, V> createHashFloodingResistantDelegate(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    public Set<K> createKeySet() {
        return new e();
    }

    public Collection<V> createValues() {
        return new g();
    }

    @VisibleForTesting
    @CheckForNull
    public Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setCreateEntrySet = createEntrySet();
        this.entrySetView = setCreateEntrySet;
        return setCreateEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.entrySet().iterator() : new b();
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.get(obj);
        }
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        accessEntry(iIndexOf);
        return value(iIndexOf);
    }

    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    public void incrementModCount() {
        this.metadata += 32;
    }

    public void init(int i) {
        com.google.common.base.i.e(i >= 0, "Expected size must be >= 0");
        this.metadata = Ints.g(i, 1, com.google.common.collect.c.d);
    }

    public void insertEntry(int i, @ParametricNullness K k, @ParametricNullness V v, int i2, int i3) {
        setEntry(i, com.google.common.collect.c.d(i2, 0, i3));
        setKey(i, k);
        setValue(i, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.keySetView = setCreateKeySet;
        return setCreateKeySet;
    }

    public Iterator<K> keySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.keySet().iterator() : new a();
    }

    public void moveLastEntry(int i, int i2) {
        Object objRequireTable = requireTable();
        int[] iArrRequireEntries = requireEntries();
        Object[] objArrRequireKeys = requireKeys();
        Object[] objArrRequireValues = requireValues();
        int size = size() - 1;
        if (i >= size) {
            objArrRequireKeys[i] = null;
            objArrRequireValues[i] = null;
            iArrRequireEntries[i] = 0;
            return;
        }
        Object obj = objArrRequireKeys[size];
        objArrRequireKeys[i] = obj;
        objArrRequireValues[i] = objArrRequireValues[size];
        objArrRequireKeys[size] = null;
        objArrRequireValues[size] = null;
        iArrRequireEntries[i] = iArrRequireEntries[size];
        iArrRequireEntries[size] = 0;
        int iD = m.d(obj) & i2;
        int iH = com.google.common.collect.c.h(objRequireTable, iD);
        int i3 = size + 1;
        if (iH == i3) {
            com.google.common.collect.c.i(objRequireTable, iD, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrRequireEntries[i4];
            int iC = com.google.common.collect.c.c(i5, i2);
            if (iC == i3) {
                iArrRequireEntries[i4] = com.google.common.collect.c.d(i5, i + 1, i2);
                return;
            }
            iH = iC;
        }
    }

    @VisibleForTesting
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k, @ParametricNullness V v) {
        int iResizeTable;
        int i;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.put(k, v);
        }
        int[] iArrRequireEntries = requireEntries();
        Object[] objArrRequireKeys = requireKeys();
        Object[] objArrRequireValues = requireValues();
        int i2 = this.size;
        int i3 = i2 + 1;
        int iD = m.d(k);
        int iHashTableMask = hashTableMask();
        int i4 = iD & iHashTableMask;
        int iH = com.google.common.collect.c.h(requireTable(), i4);
        if (iH != 0) {
            int iB = com.google.common.collect.c.b(iD, iHashTableMask);
            int i5 = 0;
            while (true) {
                int i6 = iH - 1;
                int i7 = iArrRequireEntries[i6];
                if (com.google.common.collect.c.b(i7, iHashTableMask) == iB && com.google.common.base.g.a(k, objArrRequireKeys[i6])) {
                    V v2 = (V) objArrRequireValues[i6];
                    objArrRequireValues[i6] = v;
                    accessEntry(i6);
                    return v2;
                }
                int iC = com.google.common.collect.c.c(i7, iHashTableMask);
                i5++;
                if (iC != 0) {
                    iH = iC;
                } else {
                    if (i5 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k, v);
                    }
                    if (i3 > iHashTableMask) {
                        iResizeTable = resizeTable(iHashTableMask, com.google.common.collect.c.e(iHashTableMask), iD, i2);
                        i = iResizeTable;
                    } else {
                        iArrRequireEntries[i6] = com.google.common.collect.c.d(i7, i3, iHashTableMask);
                        i = iHashTableMask;
                    }
                }
            }
        } else if (i3 > iHashTableMask) {
            iResizeTable = resizeTable(iHashTableMask, com.google.common.collect.c.e(iHashTableMask), iD, i2);
            i = iResizeTable;
        } else {
            com.google.common.collect.c.i(requireTable(), i4, i3);
            i = iHashTableMask;
        }
        resizeMeMaybe(i3);
        insertEntry(i2, k, v, iD, i);
        this.size = i3;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.remove(obj);
        }
        V v = (V) removeHelper(obj);
        if (v == NOT_FOUND) {
            return null;
        }
        return v;
    }

    public void resizeEntries(int i) {
        this.entries = Arrays.copyOf(requireEntries(), i);
        this.keys = Arrays.copyOf(requireKeys(), i);
        this.values = Arrays.copyOf(requireValues(), i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.size() : this.size;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            mapCreateHashFloodingResistantDelegate.putAll(mapDelegateOrNull);
            this.table = mapCreateHashFloodingResistantDelegate;
            return;
        }
        int i = this.size;
        if (i < requireEntries().length) {
            resizeEntries(i);
        }
        int iJ = com.google.common.collect.c.j(i);
        int iHashTableMask = hashTableMask();
        if (iJ < iHashTableMask) {
            resizeTable(iHashTableMask, iJ, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.valuesView = collectionCreateValues;
        return collectionCreateValues;
    }

    public Iterator<V> valuesIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.values().iterator() : new c();
    }

    public CompactHashMap(int i) {
        init(i);
    }

    public abstract class Itr<T> implements Iterator<T> {
        public int K;
        public int L;
        public int M;

        public Itr() {
            this.K = CompactHashMap.this.metadata;
            this.L = CompactHashMap.this.firstEntryIndex();
            this.M = -1;
        }

        public final void a() {
            if (CompactHashMap.this.metadata != this.K) {
                throw new ConcurrentModificationException();
            }
        }

        @ParametricNullness
        public abstract T b(int i);

        public void c() {
            this.K += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.L >= 0;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.L;
            this.M = i;
            T tB = b(i);
            this.L = CompactHashMap.this.getSuccessor(this.L);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.collect.a.e(this.M >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.key(this.M));
            this.L = CompactHashMap.this.adjustAfterRemove(this.L, this.M);
            this.M = -1;
        }

        public /* synthetic */ Itr(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }
}
