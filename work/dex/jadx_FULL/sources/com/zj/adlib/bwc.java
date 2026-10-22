package com.zj.adlib;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.vision.barcode.internal.a;
import com.google.mlkit.vision.barcode.internal.b;
import com.google.mlkit.vision.barcode.internal.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class bwc extends LazyInstanceMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hq5 f40854a;

    public bwc(hq5 hq5Var) {
        this.f40854a = hq5Var;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        am0 am0Var = (am0) obj;
        Context contextB = this.f40854a.b();
        lsd lsdVarB = etd.b(ebc.d());
        return new a(this.f40854a, am0Var, (b.b(contextB) || qv3.i().b(contextB) >= 204500000) ? new b(contextB, am0Var, lsdVarB) : new c(contextB, am0Var, lsdVarB), lsdVarB);
    }
}
