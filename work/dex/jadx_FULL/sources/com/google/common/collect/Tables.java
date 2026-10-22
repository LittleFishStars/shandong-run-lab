package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Tables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> f31921a = new a();

    public static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
        @Override // com.google.common.collect.Table.Cell
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            return com.google.common.base.g.a(getRowKey(), cell.getRowKey()) && com.google.common.base.g.a(getColumnKey(), cell.getColumnKey()) && com.google.common.base.g.a(getValue(), cell.getValue());
        }

        @Override // com.google.common.collect.Table.Cell
        public int hashCode() {
            return com.google.common.base.g.b(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            String strValueOf = String.valueOf(getRowKey());
            String strValueOf2 = String.valueOf(getColumnKey());
            String strValueOf3 = String.valueOf(getValue());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 4 + strValueOf2.length() + strValueOf3.length());
            sb.append("(");
            sb.append(strValueOf);
            sb.append(",");
            sb.append(strValueOf2);
            sb.append(")=");
            sb.append(strValueOf3);
            return sb.toString();
        }
    }

    public static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        private final C columnKey;

        @ParametricNullness
        private final R rowKey;

        @ParametricNullness
        private final V value;

        public ImmutableCell(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        @Override // com.google.common.collect.Table.Cell
        @ParametricNullness
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.Table.Cell
        @ParametricNullness
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.Table.Cell
        @ParametricNullness
        public V getValue() {
            return this.value;
        }
    }

    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
            super(rowSortedTable);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(Maps.D0(delegate().rowMap(), Tables.j()));
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public RowSortedTable<R, C, V> delegate() {
            return (RowSortedTable) super.delegate();
        }
    }

    public static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Table<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
            this.delegate = (Table) com.google.common.base.i.E(table);
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<R, V> column(@ParametricNullness C c) {
            return Collections.unmodifiableMap(super.column(c));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.B0(super.columnMap(), Tables.j()));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        @CheckForNull
        public V put(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, V> row(@ParametricNullness R r) {
            return Collections.unmodifiableMap(super.row(r));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(Maps.B0(super.rowMap(), Tables.j()));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public Table<R, C, V> delegate() {
            return this.delegate;
        }
    }

    public class a implements Function<Map<Object, Object>, Map<Object, Object>> {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    public static class b<R, C, V1, V2> extends AbstractTable<R, C, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super V1, V2> f31922a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Table<R, C, V1> f6157a;

        public class a implements Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> {
            public a() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> cell) {
                return Tables.c(cell.getRowKey(), cell.getColumnKey(), b.this.f31922a.apply(cell.getValue()));
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.Tables$b$b, reason: collision with other inner class name */
        public class C0732b implements Function<Map<C, V1>, Map<C, V2>> {
            public C0732b() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<C, V2> apply(Map<C, V1> map) {
                return Maps.B0(map, b.this.f31922a);
            }
        }

        public class c implements Function<Map<R, V1>, Map<R, V2>> {
            public c() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<R, V2> apply(Map<R, V1> map) {
                return Maps.B0(map, b.this.f31922a);
            }
        }

        public b(Table<R, C, V1> table, Function<? super V1, V2> function) {
            this.f6157a = (Table) com.google.common.base.i.E(table);
            this.f31922a = (Function) com.google.common.base.i.E(function);
        }

        public Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> a() {
            return new a();
        }

        @Override // com.google.common.collect.AbstractTable
        public Iterator<Table.Cell<R, C, V2>> cellIterator() {
            return Iterators.c0(this.f6157a.cellSet().iterator(), a());
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.f6157a.clear();
        }

        @Override // com.google.common.collect.Table
        public Map<R, V2> column(@ParametricNullness C c2) {
            return Maps.B0(this.f6157a.column(c2), this.f31922a);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return this.f6157a.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V2>> columnMap() {
            return Maps.B0(this.f6157a.columnMap(), new c());
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f6157a.contains(obj, obj2);
        }

        @Override // com.google.common.collect.AbstractTable
        public Collection<V2> createValues() {
            return com.google.common.collect.b.m(this.f6157a.values(), this.f31922a);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V2 get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (contains(obj, obj2)) {
                return this.f31922a.apply((Object) q.a(this.f6157a.get(obj, obj2)));
            }
            return null;
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V2 put(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V2 v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V2> table) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V2 remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (contains(obj, obj2)) {
                return this.f31922a.apply((Object) q.a(this.f6157a.remove(obj, obj2)));
            }
            return null;
        }

        @Override // com.google.common.collect.Table
        public Map<C, V2> row(@ParametricNullness R r) {
            return Maps.B0(this.f6157a.row(r), this.f31922a);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<R> rowKeySet() {
            return this.f6157a.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V2>> rowMap() {
            return Maps.B0(this.f6157a.rowMap(), new C0732b());
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.f6157a.size();
        }
    }

    public static class c<C, R, V> extends AbstractTable<C, R, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> f31926a = new a();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Table<R, C, V> f6158a;

        public class a implements Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> {
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> cell) {
                return Tables.c(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
            }
        }

        public c(Table<R, C, V> table) {
            this.f6158a = (Table) com.google.common.base.i.E(table);
        }

        @Override // com.google.common.collect.AbstractTable
        public Iterator<Table.Cell<C, R, V>> cellIterator() {
            return Iterators.c0(this.f6158a.cellSet().iterator(), f31926a);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.f6158a.clear();
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> column(@ParametricNullness R r) {
            return this.f6158a.row(r);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<R> columnKeySet() {
            return this.f6158a.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> columnMap() {
            return this.f6158a.rowMap();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f6158a.contains(obj2, obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsColumn(@CheckForNull Object obj) {
            return this.f6158a.containsRow(obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsRow(@CheckForNull Object obj) {
            return this.f6158a.containsColumn(obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsValue(@CheckForNull Object obj) {
            return this.f6158a.containsValue(obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f6158a.get(obj2, obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V put(@ParametricNullness C c, @ParametricNullness R r, @ParametricNullness V v) {
            return this.f6158a.put(r, c, v);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(Table<? extends C, ? extends R, ? extends V> table) {
            this.f6158a.putAll(Tables.g(table));
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.f6158a.remove(obj2, obj);
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> row(@ParametricNullness C c) {
            return this.f6158a.column(c);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<C> rowKeySet() {
            return this.f6158a.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> rowMap() {
            return this.f6158a.columnMap();
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.f6158a.size();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Collection<V> values() {
            return this.f6158a.values();
        }
    }

    public static boolean b(Table<?, ?, ?> table, @CheckForNull Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof Table) {
            return table.cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> Table.Cell<R, C, V> c(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v) {
        return new ImmutableCell(r, c2, v);
    }

    @Beta
    public static <R, C, V> Table<R, C, V> d(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        com.google.common.base.i.d(map.isEmpty());
        com.google.common.base.i.E(supplier);
        return new StandardTable(map, supplier);
    }

    public static <R, C, V> Table<R, C, V> e(Table<R, C, V> table) {
        return Synchronized.z(table, null);
    }

    @Beta
    public static <R, C, V1, V2> Table<R, C, V2> f(Table<R, C, V1> table, Function<? super V1, V2> function) {
        return new b(table, function);
    }

    public static <R, C, V> Table<C, R, V> g(Table<R, C, V> table) {
        return table instanceof c ? ((c) table).f6158a : new c(table);
    }

    @Beta
    public static <R, C, V> RowSortedTable<R, C, V> h(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return new UnmodifiableRowSortedMap(rowSortedTable);
    }

    public static <R, C, V> Table<R, C, V> i(Table<? extends R, ? extends C, ? extends V> table) {
        return new UnmodifiableTable(table);
    }

    public static <K, V> Function<Map<K, V>, Map<K, V>> j() {
        return (Function<Map<K, V>, Map<K, V>>) f31921a;
    }
}
