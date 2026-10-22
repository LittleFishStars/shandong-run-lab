package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.PriorityTaskManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public final class i implements DataSource.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f5229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PriorityTaskManager f5230a;

    public i(DataSource.Factory factory, PriorityTaskManager priorityTaskManager, int i) {
        this.f5229a = factory;
        this.f5230a = priorityTaskManager;
        this.f31151a = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public h a() {
        return new h(this.f5229a.a(), this.f5230a, this.f31151a);
    }
}
