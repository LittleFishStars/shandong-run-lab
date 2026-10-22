package com.google.common.graph;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class c<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f32094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<?, E> f6284a;

    public c(Map<?, E> map, Object obj) {
        this.f6284a = (Map) com.google.common.base.i.E(map);
        this.f32094a = com.google.common.base.i.E(obj);
    }

    @CheckForNull
    public final E b() {
        return this.f6284a.get(this.f32094a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator<E> iterator() {
        E eB = b();
        return eB == null ? ImmutableSet.of().iterator() : Iterators.Y(eB);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        E eB = b();
        return eB != null && eB.equals(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return b() == null ? 0 : 1;
    }
}
