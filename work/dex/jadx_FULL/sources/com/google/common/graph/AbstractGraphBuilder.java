package com.google.common.graph;

import com.google.common.base.Optional;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractGraphBuilder<N> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6259a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f6260b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ElementOrder<N> f6258a = ElementOrder.d();
    public ElementOrder<N> b = ElementOrder.i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Optional<Integer> f32045a = Optional.absent();

    public AbstractGraphBuilder(boolean z) {
        this.f6259a = z;
    }
}
