package com.byazt.ymw;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.omf.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 462, 46})
public class n extends m.c {
    public com.byazt.tn.c c;
    public Handler tt = new Handler(Looper.getMainLooper());

    public n(com.byazt.tn.c cVar) {
        this.c = cVar;
    }

    private Handler i() {
        Handler handler = this.tt;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.tt = handler2;
        return handler2;
    }

    private void x() {
        this.c = null;
        this.tt = null;
    }

    @Override // com.byazt.omf.m
    public void a() throws RemoteException {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.6
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    cVar.n();
                }
            }
        });
    }

    @Override // com.byazt.omf.m
    public void n() throws RemoteException {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    cVar.uj();
                }
            }
        });
    }

    @Override // com.byazt.omf.m
    public void tt() throws RemoteException {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    cVar.c();
                }
            }
        });
    }

    @Override // com.byazt.omf.m
    public void uj() throws RemoteException {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    cVar.ve();
                }
            }
        });
    }

    @Override // com.byazt.omf.m
    public void ve() throws RemoteException {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    cVar.tt();
                }
            }
        });
    }

    @Override // com.byazt.omf.m
    public void c() throws RemoteException {
        x();
    }

    @Override // com.byazt.omf.m
    public void c(final Bundle bundle) throws RemoteException {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    cVar.c(bundle);
                }
            }
        });
    }

    @Override // com.byazt.omf.m
    public void c(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.7
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    cVar.c(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.byazt.omf.m
    public void c(final boolean z, final int i, final Bundle bundle) {
        i().post(new Runnable() { // from class: com.byazt.ymw.n.8
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tn.c cVar = n.this.c;
                if (cVar != null) {
                    try {
                        cVar.c(z, i, bundle);
                    } catch (AbstractMethodError unused) {
                        com.byazt.nr.m.uj("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                    }
                }
            }
        });
    }
}
