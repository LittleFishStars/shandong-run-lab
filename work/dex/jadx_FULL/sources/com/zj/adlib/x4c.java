package com.zj.adlib;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.zabw;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x4c extends zabw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f45744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ b5c f20603a;

    public x4c(b5c b5cVar, Dialog dialog) {
        this.f20603a = b5cVar;
        this.f45744a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void a() {
        this.f20603a.f40681a.l();
        if (this.f45744a.isShowing()) {
            this.f45744a.dismiss();
        }
    }
}
