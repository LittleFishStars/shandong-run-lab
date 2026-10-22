package com.zj.adlib;

import android.app.Dialog;
import android.app.PendingIntent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b5c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zap f40681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t4c f15448a;

    public b5c(zap zapVar, t4c t4cVar) {
        this.f40681a = zapVar;
        this.f15448a = t4cVar;
    }

    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (this.f40681a.f5617a) {
            ConnectionResult connectionResultB = this.f15448a.b();
            if (connectionResultB.hasResolution()) {
                zap zapVar = this.f40681a;
                ((LifecycleCallback) zapVar).f31226a.startActivityForResult(GoogleApiActivity.a(zapVar.getActivity(), (PendingIntent) yw6.l(connectionResultB.getResolution()), this.f15448a.a(), false), 1);
                return;
            }
            zap zapVar2 = this.f40681a;
            if (zapVar2.f5615a.e(zapVar2.getActivity(), connectionResultB.getErrorCode(), null) != null) {
                zap zapVar3 = this.f40681a;
                zapVar3.f5615a.K(zapVar3.getActivity(), ((LifecycleCallback) this.f40681a).f31226a, connectionResultB.getErrorCode(), 2, this.f40681a);
            } else {
                if (connectionResultB.getErrorCode() != 18) {
                    this.f40681a.k(connectionResultB, this.f15448a.a());
                    return;
                }
                zap zapVar4 = this.f40681a;
                Dialog dialogF = zapVar4.f5615a.F(zapVar4.getActivity(), this.f40681a);
                zap zapVar5 = this.f40681a;
                zapVar5.f5615a.G(zapVar5.getActivity().getApplicationContext(), new x4c(this, dialogF));
            }
        }
    }
}
