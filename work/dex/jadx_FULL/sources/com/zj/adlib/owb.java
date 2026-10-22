package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.hzjizhun.admin.base.ad.ErrorCallback;
import cn.hzjizhun.admin.base.ad.RcSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class owb extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rzb f43848a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public owb(rzb rzbVar, Looper looper) {
        super(looper);
        this.f43848a = rzbVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        try {
            if (i == 1) {
                if (rzb.d(this.f43848a)) {
                    this.f43848a.f19455a.sendEmptyMessageDelayed(1, 3000L);
                    rzb rzbVar = this.f43848a;
                    rzbVar.getClass();
                    ErrorCallback errorCallback = rzbVar.f19454a;
                    if (errorCallback != null) {
                        errorCallback.errorReport("init 时，任务未结束");
                        return;
                    }
                    return;
                }
                this.f43848a.f19455a.removeMessages(2);
                rzb rzbVar2 = this.f43848a;
                rzbVar2.b = 0;
                synchronized (rzbVar2) {
                    qxb qxbVar = new qxb(rzbVar2);
                    zmb zmbVarA = zmb.a();
                    a6b a6bVar = new a6b(qxbVar);
                    zmbVarA.getClass();
                    mib mibVarA = mib.a();
                    ylb ylbVar = new ylb(zmbVarA, a6bVar);
                    mibVarA.getClass();
                    mib.f18226a.submit(ylbVar);
                }
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    this.f43848a.g();
                    return;
                }
                if (i != 4) {
                    return;
                }
                rzb rzbVar3 = this.f43848a;
                if (RcSdk.k()) {
                    rzbVar3.f19455a.sendEmptyMessage(1);
                    return;
                } else {
                    rzbVar3.f19455a.sendEmptyMessageDelayed(4, 60000L);
                    return;
                }
            }
            if (rzb.d(this.f43848a)) {
                this.f43848a.f19455a.sendEmptyMessageDelayed(2, 3000L);
                rzb rzbVar4 = this.f43848a;
                rzbVar4.getClass();
                ErrorCallback errorCallback2 = rzbVar4.f19454a;
                if (errorCallback2 != null) {
                    errorCallback2.errorReport("start 时，任务未结束");
                    return;
                }
                return;
            }
            rzb rzbVar5 = this.f43848a;
            hyb hybVar = new hyb(rzbVar5, rzbVar5.f19453a);
            zmb zmbVarA2 = zmb.a();
            c8b c8bVar = new c8b(hybVar);
            zmbVarA2.getClass();
            mib mibVarA2 = mib.a();
            ylb ylbVar2 = new ylb(zmbVarA2, c8bVar);
            mibVarA2.getClass();
            mib.f18226a.submit(ylbVar2);
        } catch (Throwable unused) {
        }
    }
}
