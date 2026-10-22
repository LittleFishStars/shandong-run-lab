package com.kc.cw.ad.d.a.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38799a;
    private final com.kc.cw.ad.d.a.c b;
    private final a c;

    @Keep
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException;
    }

    private l(Context context, com.kc.cw.ad.d.a.c cVar, a aVar) {
        this.f38799a = context instanceof Application ? context : context.getApplicationContext();
        this.b = cVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, com.kc.cw.ad.d.a.c cVar, a aVar) {
        new l(context, cVar, aVar).a(intent);
    }

    private void a(Intent intent) {
        try {
            if (!this.f38799a.bindService(intent, this, 1)) {
                throw new com.kc.cw.ad.d.a.e("Service binding failed");
            }
            com.kc.cw.ad.d.a.f.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str;
        com.kc.cw.ad.d.a.f.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new com.kc.cw.ad.d.a.e("OAID/GAID acquire failed");
                    }
                    com.kc.cw.ad.d.a.f.a("OAID/GAID acquire success: " + strA);
                    this.b.a(strA);
                    this.f38799a.unbindService(this);
                    str = "Service has been unbound: " + componentName.getClassName();
                    com.kc.cw.ad.d.a.f.a(str);
                } catch (Throwable th) {
                    try {
                        this.f38799a.unbindService(this);
                        com.kc.cw.ad.d.a.f.a("Service has been unbound: " + componentName.getClassName());
                    } catch (Exception e) {
                        com.kc.cw.ad.d.a.f.a(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                com.kc.cw.ad.d.a.f.a(e2);
                this.b.a(e2);
                this.f38799a.unbindService(this);
                str = "Service has been unbound: " + componentName.getClassName();
            }
        } catch (Exception e3) {
            com.kc.cw.ad.d.a.f.a(e3);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.kc.cw.ad.d.a.f.a("Service has been disconnected: " + componentName.getClassName());
    }
}
