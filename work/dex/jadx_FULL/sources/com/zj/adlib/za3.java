package com.zj.adlib;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class za3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f46223a;

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return Boolean.valueOf(this.f46223a.get());
    }
}
