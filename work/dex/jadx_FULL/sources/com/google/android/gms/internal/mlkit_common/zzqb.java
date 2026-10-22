package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;
import com.zj.adlib.pmd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzqb {
    public static zzqa h() {
        pmd pmdVar = new pmd();
        pmdVar.h("NA");
        pmdVar.f(false);
        pmdVar.e(false);
        pmdVar.d(ModelType.UNKNOWN);
        pmdVar.b(zzlm.NO_ERROR);
        pmdVar.a(zzls.UNKNOWN_STATUS);
        pmdVar.c(0);
        return pmdVar;
    }

    public abstract int a();

    public abstract ModelType b();

    public abstract zzlm c();

    public abstract zzls d();

    public abstract String e();

    public abstract boolean f();

    public abstract boolean g();
}
