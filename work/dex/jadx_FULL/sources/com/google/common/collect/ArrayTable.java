package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;

    @CheckForNull
    private transient ArrayTable<R, C, V>.e columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    @CheckForNull
    private transient ArrayTable<R, C, V>.g rowMap;

    public static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<K, Integer> f31676a;

        public class a extends AbstractMapEntry<K, V> {
            public final /* synthetic */ int K;

            public a(int i) {
                this.K = i;
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public K getKey() {
                return (K) ArrayMap.this.d(this.K);
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            @ParametricNullness
            public V getValue() {
                return (V) ArrayMap.this.f(this.K);
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            @ParametricNullness
            public V setValue(@ParametricNullness V v) {
                return (V) ArrayMap.this.g(this.K, v);
            }
        }

        public class b extends AbstractIndexedListIterator<Map.Entry<K, V>> {
            public b(int i) {
                super(i);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            public Map.Entry<K, V> get(int i) {
                return ArrayMap.this.c(i);
            }
        }

        public /* synthetic */ ArrayMap(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> b() {
            return new b(size());
        }

        public Map.Entry<K, V> c(int i) {
            com.google.common.base.i.C(i, size());
            return new a(i);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f31676a.containsKey(obj);
        }

        public K d(int i) {
            return this.f31676a.keySet().asList().get(i);
        }

        public abstract String e();

        @ParametricNullness
        public abstract V f(int i);

        @ParametricNullness
        public abstract V g(int i, @ParametricNullness V v);

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Integer num = this.f31676a.get(obj);
            if (num == null) {
                return null;
            }
            return f(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f31676a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f31676a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(K k, @ParametricNullness V v) {
            Integer num = this.f31676a.get(k);
            if (num != null) {
                return g(num.intValue(), v);
            }
            String strE = e();
            String strValueOf = String.valueOf(k);
            String strValueOf2 = String.valueOf(this.f31676a.keySet());
            StringBuilder sb = new StringBuilder(String.valueOf(strE).length() + 9 + strValueOf.length() + strValueOf2.length());
            sb.append(strE);
            sb.append(" ");
            sb.append(strValueOf);
            sb.append(" not in ");
            sb.append(strValueOf2);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f31676a.size();
        }

        public ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.f31676a = immutableMap;
        }
    }

    public class a extends AbstractIndexedListIterator<Table.Cell<R, C, V>> {
        public a(int i) {
            super(i);
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public Table.Cell<R, C, V> get(int i) {
            return ArrayTable.this.getCell(i);
        }
    }

    public class b extends Tables.AbstractCell<R, C, V> {
        public final int K;
        public final int L;
        public final /* synthetic */ int M;

        public b(int i) {
            this.M = i;
            this.K = i / ArrayTable.this.columnList.size();
            this.L = i % ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.L);
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.K);
        }

        @Override // com.google.common.collect.Table.Cell
        @CheckForNull
        public V getValue() {
            return (V) ArrayTable.this.at(this.K, this.L);
        }
    }

    public class c extends AbstractIndexedListIterator<V> {
        public c(int i) {
            super(i);
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        @CheckForNull
        public V get(int i) {
            return (V) ArrayTable.this.getValue(i);
        }
    }

    public class d extends ArrayMap<R, V> {
        public final int K;

        public d(int i) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.K = i;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        public V f(int i) {
            return (V) ArrayTable.this.at(i, this.K);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        public V g(int i, @CheckForNull V v) {
            return (V) ArrayTable.this.set(i, this.K, v);
        }
    }

    public class e extends ArrayMap<C, Map<R, V>> {
        public /* synthetic */ e(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<R, V> f(int i) {
            return new d(i);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map<R, V> g(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public e() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    public class f extends ArrayMap<C, V> {
        public final int K;

        public f(int i) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.K = i;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        public V f(int i) {
            return (V) ArrayTable.this.at(this.K, i);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        public V g(int i, @CheckForNull V v) {
            return (V) ArrayTable.this.set(this.K, i, v);
        }
    }

    public class g extends ArrayMap<R, Map<C, V>> {
        public /* synthetic */ g(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<C, V> f(int i) {
            return new f(i);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map<C, V> g(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public g() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> immutableListCopyOf = ImmutableList.copyOf(iterable);
        this.rowList = immutableListCopyOf;
        ImmutableList<C> immutableListCopyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = immutableListCopyOf2;
        com.google.common.base.i.d(immutableListCopyOf.isEmpty() == immutableListCopyOf2.isEmpty());
        this.rowKeyToIndex = Maps.Q(immutableListCopyOf);
        this.columnKeyToIndex = Maps.Q(immutableListCopyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableListCopyOf.size(), immutableListCopyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Table.Cell<R, C, V> getCell(int i) {
        return new b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    @CheckForNull
    public V at(int i, int i2) {
        com.google.common.base.i.C(i, this.rowList.size());
        com.google.common.base.i.C(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        com.google.common.base.i.E(c2);
        Integer num = this.columnKeyToIndex.get(c2);
        return num == null ? Collections.emptyMap() : new d(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.e eVar = this.columnMap;
        if (eVar != null) {
            return eVar;
        }
        ArrayTable<R, C, V>.e eVar2 = new e(this, null);
        this.columnMap = eVar2;
        return eVar2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object obj) {
        for (V[] vArr : this.array) {
            for (V v : vArr) {
                if (com.google.common.base.g.a(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V erase(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(R r, C c2, @CheckForNull V v) {
        com.google.common.base.i.E(r);
        com.google.common.base.i.E(c2);
        Integer num = this.rowKeyToIndex.get(r);
        com.google.common.base.i.y(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c2);
        com.google.common.base.i.y(num2 != null, "Column %s not in %s", c2, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        com.google.common.base.i.E(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? Collections.emptyMap() : new f(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.g gVar = this.rowMap;
        if (gVar != null) {
            return gVar;
        }
        ArrayTable<R, C, V>.g gVar2 = new g(this, null);
        this.rowMap = gVar2;
        return gVar2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V set(int i, int i2, @CheckForNull V v) {
        com.google.common.base.i.C(i, this.rowList.size());
        com.google.common.base.i.C(i2, this.columnList.size());
        V[] vArr = this.array[i];
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = this.array[i];
            System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, ? extends V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, ? extends V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = arrayTable.array[i];
            System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
    }
}
