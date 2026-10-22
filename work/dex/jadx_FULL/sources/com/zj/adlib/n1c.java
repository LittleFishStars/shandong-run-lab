package com.zj.adlib;

import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.zabw;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n1c extends zabw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f43427a;

    public n1c(p pVar) {
        this.f43427a = new WeakReference(pVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void a() {
        p pVar = (p) this.f43427a.get();
        if (pVar == null) {
            return;
        }
        p.M(pVar);
    }
}
