package com.zj.adlib;

import com.google.android.gms.common.api.internal.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s1c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1c f44588a;

    public s1c(t1c t1cVar) {
        this.f44588a = t1cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar = this.f44588a.f44829a;
        tVar.f5604a.d(tVar.f5604a.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
