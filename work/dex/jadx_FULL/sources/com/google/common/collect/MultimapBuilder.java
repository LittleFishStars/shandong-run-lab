package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class MultimapBuilder<K0, V0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31836a = 8;

    public static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int i) {
            this.expectedValuesPerKey = com.google.common.collect.a.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    public static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        private final Class<V> clazz;

        public EnumSetSupplier(Class<V> cls) {
            this.clazz = (Class) com.google.common.base.i.E(cls);
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public HashSetSupplier(int i) {
            this.expectedValuesPerKey = com.google.common.collect.a.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return u.e(this.expectedValuesPerKey);
        }
    }

    public static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int i) {
            this.expectedValuesPerKey = com.google.common.collect.a.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return u.g(this.expectedValuesPerKey);
        }
    }

    public enum LinkedListSupplier implements Supplier<List<?>> {
        INSTANCE;

        public static <V> Supplier<List<V>> instance() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Supplier
        public List<?> get() {
            return new LinkedList();
        }
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public ListMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> a();

        @Override // com.google.common.collect.MultimapBuilder
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> ListMultimap<K, V> b(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) super.b(multimap);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f31837a = 2;

        public class a extends ListMultimapBuilder<K0, Object> {
            public final /* synthetic */ int b;

            public a(int i) {
                this.b = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> ListMultimap<K, V> a() {
                return Multimaps.u(MultimapBuilderWithKeys.this.c(), new ArrayListSupplier(this.b));
            }
        }

        public class b extends ListMultimapBuilder<K0, Object> {
            public b() {
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> ListMultimap<K, V> a() {
                return Multimaps.u(MultimapBuilderWithKeys.this.c(), LinkedListSupplier.instance());
            }
        }

        public class c extends SetMultimapBuilder<K0, Object> {
            public final /* synthetic */ int b;

            public c(int i) {
                this.b = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public <K extends K0, V> SetMultimap<K, V> a() {
                return Multimaps.w(MultimapBuilderWithKeys.this.c(), new HashSetSupplier(this.b));
            }
        }

        public class d extends SetMultimapBuilder<K0, Object> {
            public final /* synthetic */ int b;

            public d(int i) {
                this.b = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> SetMultimap<K, V> a() {
                return Multimaps.w(MultimapBuilderWithKeys.this.c(), new LinkedHashSetSupplier(this.b));
            }
        }

        public class e extends SortedSetMultimapBuilder<K0, V0> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Comparator f6122a;

            public e(Comparator comparator) {
                this.f6122a = comparator;
            }

            @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public <K extends K0, V extends V0> SortedSetMultimap<K, V> a() {
                return Multimaps.x(MultimapBuilderWithKeys.this.c(), new TreeSetSupplier(this.f6122a));
            }
        }

        public class f extends SetMultimapBuilder<K0, V0> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Class f6123a;

            public f(Class cls) {
                this.f6123a = cls;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* JADX INFO: renamed from: j */
            public <K extends K0, V extends V0> SetMultimap<K, V> a() {
                return Multimaps.w(MultimapBuilderWithKeys.this.c(), new EnumSetSupplier(this.f6123a));
            }
        }

        public ListMultimapBuilder<K0, Object> a() {
            return b(2);
        }

        public ListMultimapBuilder<K0, Object> b(int i) {
            com.google.common.collect.a.b(i, "expectedValuesPerKey");
            return new a(i);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> c();

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> d(Class<V0> cls) {
            com.google.common.base.i.F(cls, "valueClass");
            return new f(cls);
        }

        public SetMultimapBuilder<K0, Object> e() {
            return f(2);
        }

        public SetMultimapBuilder<K0, Object> f(int i) {
            com.google.common.collect.a.b(i, "expectedValuesPerKey");
            return new c(i);
        }

        public SetMultimapBuilder<K0, Object> g() {
            return h(2);
        }

        public SetMultimapBuilder<K0, Object> h(int i) {
            com.google.common.collect.a.b(i, "expectedValuesPerKey");
            return new d(i);
        }

        public ListMultimapBuilder<K0, Object> i() {
            return new b();
        }

        public SortedSetMultimapBuilder<K0, Comparable> j() {
            return k(Ordering.natural());
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> k(Comparator<V0> comparator) {
            com.google.common.base.i.F(comparator, "comparator");
            return new e(comparator);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public SetMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        /* JADX INFO: renamed from: j */
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> a();

        @Override // com.google.common.collect.MultimapBuilder
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> SetMultimap<K, V> b(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) super.b(multimap);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder
        /* JADX INFO: renamed from: l */
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> a();

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> b(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.b(multimap);
        }
    }

    public static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        public TreeSetSupplier(Comparator<? super V> comparator) {
            this.comparator = (Comparator) com.google.common.base.i.E(comparator);
        }

        @Override // com.google.common.base.Supplier
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    public class a extends MultimapBuilderWithKeys<Object> {
        public final /* synthetic */ int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K, V> Map<K, Collection<V>> c() {
            return u.d(this.b);
        }
    }

    public class b extends MultimapBuilderWithKeys<Object> {
        public final /* synthetic */ int b;

        public b(int i) {
            this.b = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K, V> Map<K, Collection<V>> c() {
            return u.f(this.b);
        }
    }

    public class c extends MultimapBuilderWithKeys<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f31844a;

        public c(Comparator comparator) {
            this.f31844a = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f31844a);
        }
    }

    public class d extends MultimapBuilderWithKeys<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f31845a;

        public d(Class cls) {
            this.f31845a = cls;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new EnumMap(this.f31845a);
        }
    }

    public /* synthetic */ MultimapBuilder(a aVar) {
        this();
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> c(Class<K0> cls) {
        com.google.common.base.i.E(cls);
        return new d(cls);
    }

    public static MultimapBuilderWithKeys<Object> d() {
        return e(8);
    }

    public static MultimapBuilderWithKeys<Object> e(int i) {
        com.google.common.collect.a.b(i, "expectedKeys");
        return new a(i);
    }

    public static MultimapBuilderWithKeys<Object> f() {
        return g(8);
    }

    public static MultimapBuilderWithKeys<Object> g(int i) {
        com.google.common.collect.a.b(i, "expectedKeys");
        return new b(i);
    }

    public static MultimapBuilderWithKeys<Comparable> h() {
        return i(Ordering.natural());
    }

    public static <K0> MultimapBuilderWithKeys<K0> i(Comparator<K0> comparator) {
        com.google.common.base.i.E(comparator);
        return new c(comparator);
    }

    public abstract <K extends K0, V extends V0> Multimap<K, V> a();

    public <K extends K0, V extends V0> Multimap<K, V> b(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> multimapA = a();
        multimapA.putAll(multimap);
        return multimapA;
    }

    public MultimapBuilder() {
    }
}
