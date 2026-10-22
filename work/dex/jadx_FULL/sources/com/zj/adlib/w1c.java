package com.zj.adlib;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w1c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f45507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ x1c f20359a;

    public w1c(x1c x1cVar, ConnectionResult connectionResult) {
        this.f20359a = x1cVar;
        this.f45507a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x1c x1cVar = this.f20359a;
        t tVar = (t) x1cVar.f20592a.f5527a.get(x1cVar.f20594a);
        if (tVar == null) {
            return;
        }
        if (!this.f45507a.isSuccess()) {
            tVar.F(this.f45507a, null);
            return;
        }
        this.f20359a.f20596a = true;
        if (this.f20359a.f45731a.q()) {
            this.f20359a.h();
            return;
        }
        try {
            x1c x1cVar2 = this.f20359a;
            x1cVar2.f45731a.e(null, x1cVar2.f45731a.f());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.f20359a.f45731a.d("Failed to get service from broker.");
            tVar.F(new ConnectionResult(10), null);
        }
    }
}
