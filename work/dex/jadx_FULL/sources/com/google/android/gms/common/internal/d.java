package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Result;
import com.zj.adlib.ig7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements PendingResultUtil.ResultConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ig7 f31298a;

    public d(ig7 ig7Var) {
        this.f31298a = ig7Var;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* bridge */ /* synthetic */ Object a(Result result) {
        this.f31298a.setResult(result);
        return this.f31298a;
    }
}
