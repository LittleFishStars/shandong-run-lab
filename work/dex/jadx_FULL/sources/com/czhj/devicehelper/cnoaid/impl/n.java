package com.czhj.devicehelper.cnoaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class n implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f29357a;
    private final com.czhj.devicehelper.cnoaid.c b;
    private final a c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws com.czhj.devicehelper.cnoaid.f, RemoteException;
    }

    private n(Context context, com.czhj.devicehelper.cnoaid.c cVar, a aVar) {
        this.f29357a = context instanceof Application ? context : context.getApplicationContext();
        this.b = cVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, com.czhj.devicehelper.cnoaid.c cVar, a aVar) {
        new n(context, cVar, aVar).a(intent);
    }

    private void a(Intent intent) {
        try {
            if (!this.f29357a.bindService(intent, this, 1)) {
                throw new com.czhj.devicehelper.cnoaid.f("Service binding failed");
            }
            com.czhj.devicehelper.cnoaid.g.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.czhj.devicehelper.cnoaid.g.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new com.czhj.devicehelper.cnoaid.f("OAID/AAID acquire failed");
                    }
                    com.czhj.devicehelper.cnoaid.g.a("OAID/AAID acquire success: " + strA);
                    this.b.a(strA);
                    this.f29357a.unbindService(this);
                    com.czhj.devicehelper.cnoaid.g.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    com.czhj.devicehelper.cnoaid.g.a(e);
                }
            } catch (Exception e2) {
                com.czhj.devicehelper.cnoaid.g.a(e2);
                this.b.a(e2);
                this.f29357a.unbindService(this);
                com.czhj.devicehelper.cnoaid.g.a("Service has been unbound: " + componentName.getClassName());
            }
        } catch (Throwable th) {
            try {
                this.f29357a.unbindService(this);
                com.czhj.devicehelper.cnoaid.g.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                com.czhj.devicehelper.cnoaid.g.a(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.czhj.devicehelper.cnoaid.g.a("Service has been disconnected: " + componentName.getClassName());
    }
}
