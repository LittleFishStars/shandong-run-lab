package com.zj.adlib;

import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.shandong_school.ShandongApplication;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final /* synthetic */ class f88 implements PermissionResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f41621a;

    @Override // com.huachenjie.common.util.permission.PermissionResultListener
    public final void onResult(boolean z) {
        ShandongApplication.d.c(this.f41621a, z);
    }
}
