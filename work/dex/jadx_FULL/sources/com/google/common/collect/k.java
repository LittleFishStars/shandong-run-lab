package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class k<K, V> extends AbstractCollection<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Weak
    public final FilteredMultimap<K, V> f31986a;

    public k(FilteredMultimap<K, V> filteredMultimap) {
        this.f31986a = (FilteredMultimap) com.google.common.base.i.E(filteredMultimap);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f31986a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@CheckForNull Object obj) {
        return this.f31986a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return Maps.O0(this.f31986a.entries().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(@CheckForNull Object obj) {
        Predicate<? super Map.Entry<K, V>> predicateI = this.f31986a.i();
        Iterator<Map.Entry<K, V>> it = this.f31986a.f().entries().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (predicateI.apply(next) && com.google.common.base.g.a(next.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return o.J(this.f31986a.f().entries(), Predicates.d(this.f31986a.i(), Maps.Q0(Predicates.n(collection))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return o.J(this.f31986a.f().entries(), Predicates.d(this.f31986a.i(), Maps.Q0(Predicates.q(Predicates.n(collection)))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f31986a.size();
    }
}
