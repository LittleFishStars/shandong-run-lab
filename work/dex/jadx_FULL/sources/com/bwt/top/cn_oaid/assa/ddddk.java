package com.bwt.top.cn_oaid.assa;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.zj.adlib.ija;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ddddk implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kdsksdda f1477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ddksa f1478a;

    @FunctionalInterface
    public interface kdsksdda {
        String a(IBinder iBinder);
    }

    public ddddk(Context context, ddksa ddksaVar, kdsksdda kdsksddaVar) {
        this.f28253a = context instanceof Application ? context : context.getApplicationContext();
        this.f1478a = ddksaVar;
        this.f1477a = kdsksddaVar;
    }

    public static void a(Context context, Intent intent, ddksa ddksaVar, kdsksdda kdsksddaVar) {
        new ddddk(context, ddksaVar, kdsksddaVar).b(intent);
    }

    public final void b(Intent intent) {
        try {
            if (!this.f28253a.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            ija.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.f1478a.b(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ija.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.f1477a.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new OAIDException("OAID/AAID acquire failed");
                    }
                    ija.a("OAID/AAID acquire success: " + strA);
                    this.f1478a.a(strA);
                    this.f28253a.unbindService(this);
                    ija.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    ija.a(e);
                }
            } catch (Exception e2) {
                ija.a(e2);
                this.f1478a.b(e2);
                this.f28253a.unbindService(this);
                ija.a("Service has been unbound: " + componentName.getClassName());
            }
        } catch (Throwable th) {
            try {
                this.f28253a.unbindService(this);
                ija.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                ija.a(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ija.a("Service has been disconnected: " + componentName.getClassName());
    }
}
