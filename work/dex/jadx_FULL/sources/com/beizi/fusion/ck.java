package com.beizi.fusion;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class ck implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27144a;
    private final jc b;
    private final a c;

    public interface a {
        String a(IBinder iBinder);
    }

    private ck(Context context, jc jcVar, a aVar) {
        if (context instanceof Application) {
            this.f27144a = context;
        } else {
            this.f27144a = context.getApplicationContext();
        }
        this.b = jcVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, jc jcVar, a aVar) {
        new ck(context, jcVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        xj.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String strA = this.c.a(iBinder);
                if (strA == null || strA.length() == 0) {
                    throw new sj("OAID acquire failed");
                }
                xj.a("OAID acquire success: " + strA);
                this.b.a(strA);
                try {
                    this.f27144a.unbindService(this);
                    xj.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    xj.a(e);
                }
            } catch (Exception e2) {
                xj.a(e2);
                this.b.a(e2);
                try {
                    this.f27144a.unbindService(this);
                    xj.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e3) {
                    xj.a(e3);
                }
            }
        } catch (Throwable th) {
            try {
                this.f27144a.unbindService(this);
                xj.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e4) {
                xj.a(e4);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        xj.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f27144a.bindService(intent, this, 1)) {
                throw new sj("Service binding failed");
            }
            xj.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }
}
