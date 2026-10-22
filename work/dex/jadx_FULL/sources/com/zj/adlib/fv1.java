package com.zj.adlib;

import com.aliyun.sls.android.producer.utils.ContextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final /* synthetic */ class fv1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f41762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Method f16626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object[] f16627a;

    public /* synthetic */ fv1(Object[] objArr, Method method, Object obj) {
        this.f16627a = objArr;
        this.f16626a = method;
        this.f41762a = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContextUtils.lambda$getActivityThread$0(this.f16627a, this.f16626a, this.f41762a);
    }
}
