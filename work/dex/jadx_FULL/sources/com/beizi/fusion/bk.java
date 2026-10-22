package com.beizi.fusion;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class bk implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27110a;
    private final kc b;
    private final a c;

    public interface a {
        String a(IBinder iBinder);
    }

    private bk(Context context, kc kcVar, a aVar) {
        if (context instanceof Application) {
            this.f27110a = context;
        } else {
            this.f27110a = context.getApplicationContext();
        }
        this.b = kcVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, kc kcVar, a aVar) {
        new bk(context, kcVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        yj.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String strA = this.c.a(iBinder);
                if (strA == null || strA.length() == 0) {
                    throw new tj("OAID acquire failed");
                }
                yj.a("OAID acquire success: " + strA);
                this.b.a(strA);
                try {
                    this.f27110a.unbindService(this);
                    yj.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    yj.a(e);
                }
            } catch (Exception e2) {
                yj.a(e2);
                this.b.a(e2);
                try {
                    this.f27110a.unbindService(this);
                    yj.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e3) {
                    yj.a(e3);
                }
            }
        } catch (Throwable th) {
            try {
                this.f27110a.unbindService(this);
                yj.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e4) {
                yj.a(e4);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        yj.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f27110a.bindService(intent, this, 1)) {
                throw new tj("Service binding failed");
            }
            yj.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }
}
