package com.zj.adlib;

import com.google.android.gms.common.api.internal.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r5c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f44380a;

    public r5c(d dVar) {
        this.f44380a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44380a.f5550a.lock();
        try {
            d.C(this.f44380a);
        } finally {
            this.f44380a.f5550a.unlock();
        }
    }
}
