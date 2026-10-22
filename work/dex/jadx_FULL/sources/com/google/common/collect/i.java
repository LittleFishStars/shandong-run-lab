package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public class i<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Predicate<? super K> f31982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Multimap<K, V> f6206a;

    public static class a<K, V> extends ForwardingList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f31983a;

        public a(@ParametricNullness K k) {
            this.f31983a = k;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness V v) {
            add(0, v);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i, @ParametricNullness V v) {
            com.google.common.base.i.d0(i, 0);
            String strValueOf = String.valueOf(this.f31983a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        @CanIgnoreReturnValue
        public boolean addAll(int i, Collection<? extends V> collection) {
            com.google.common.base.i.E(collection);
            com.google.common.base.i.d0(i, 0);
            String strValueOf = String.valueOf(this.f31983a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public List<V> delegate() {
            return Collections.emptyList();
        }
    }

    public class c extends ForwardingCollection<Map.Entry<K, V>> {
        public c() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (i.this.f6206a.containsKey(entry.getKey()) && i.this.f31982a.apply((Object) entry.getKey())) {
                return i.this.f6206a.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return com.google.common.collect.b.d(i.this.f6206a.entries(), i.this.i());
        }
    }

    public i(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.f6206a = (Multimap) com.google.common.base.i.E(multimap);
        this.f31982a = (Predicate) com.google.common.base.i.E(predicate);
    }

    public Collection<V> a() {
        return this.f6206a instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        if (this.f6206a.containsKey(obj)) {
            return this.f31982a.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return Maps.G(this.f6206a.asMap(), this.f31982a);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<Map.Entry<K, V>> createEntries() {
        return new c();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return Sets.i(this.f6206a.keySet(), this.f31982a);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return Multisets.j(this.f6206a.keys(), this.f31982a);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Collection<V> createValues() {
        return new k(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    public Multimap<K, V> f() {
        return this.f6206a;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K k) {
        if (this.f31982a.apply(k)) {
            return this.f6206a.get(k);
        }
        return this.f6206a instanceof SetMultimap ? new b(k) : new a(k);
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> i() {
        return Maps.U(this.f31982a);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object obj) {
        return containsKey(obj) ? this.f6206a.removeAll(obj) : a();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        Iterator<Collection<V>> it = asMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public static class b<K, V> extends ForwardingSet<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f31984a;

        public b(@ParametricNullness K k) {
            this.f31984a = k;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness V v) {
            String strValueOf = String.valueOf(this.f31984a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            com.google.common.base.i.E(collection);
            String strValueOf = String.valueOf(this.f31984a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }
}
