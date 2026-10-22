package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public List<b<V>> f32361a;

    public static final class a<V> extends CollectionFuture<V, List<V>> {
        public a(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z);
            Q();
        }

        @Override // com.google.common.util.concurrent.CollectionFuture
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public List<V> U(List<b<V>> list) {
            ArrayList arrayListU = Lists.u(list.size());
            Iterator<b<V>> it = list.iterator();
            while (it.hasNext()) {
                b<V> next = it.next();
                arrayListU.add(next != null ? next.f32362a : null);
            }
            return Collections.unmodifiableList(arrayListU);
        }
    }

    public static final class b<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public V f32362a;

        public b(V v) {
            this.f32362a = v;
        }
    }

    public CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
        super(immutableCollection, z, true);
        List<b<V>> listEmptyList = immutableCollection.isEmpty() ? Collections.emptyList() : Lists.u(immutableCollection.size());
        for (int i = 0; i < immutableCollection.size(); i++) {
            listEmptyList.add(null);
        }
        this.f32361a = listEmptyList;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void L(int i, @ParametricNullness V v) {
        List<b<V>> list = this.f32361a;
        if (list != null) {
            list.set(i, new b<>(v));
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void O() {
        List<b<V>> list = this.f32361a;
        if (list != null) {
            set(U(list));
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void T(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.T(releaseResourcesReason);
        this.f32361a = null;
    }

    public abstract C U(List<b<V>> list);
}
