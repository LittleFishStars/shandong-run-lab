package cn.hzjizhun.admin;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.hzjizhun.admin.cn_oaid.OAIDException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dadkdadds implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kdsksdda f289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ddakd f290a;

    public interface kdsksdda {
        String a(IBinder iBinder);
    }

    public dadkdadds(Context context, ddakd ddakdVar, kdsksdda kdsksddaVar) {
        if (context instanceof Application) {
            this.f22711a = context;
        } else {
            this.f22711a = context.getApplicationContext();
        }
        this.f290a = ddakdVar;
        this.f289a = kdsksddaVar;
    }

    public static void a(Context context, Intent intent, ddakd ddakdVar, kdsksdda kdsksddaVar) {
        new dadkdadds(context, ddakdVar, kdsksddaVar).b(intent);
    }

    public final void b(Intent intent) {
        try {
            if (!this.f22711a.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            dddssad.a("Service has been bound: " + intent);
        } catch (Throwable th) {
            this.f290a.b(th);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        dddssad.a("Service has been connected: " + componentName.getClassName());
        try {
            String strA = this.f289a.a(iBinder);
            if (strA == null || strA.length() == 0) {
                throw new OAIDException("OAID/AAID acquire failed");
            }
            dddssad.a("OAID/AAID acquire success: " + strA);
            this.f290a.a(strA);
            try {
                this.f22711a.unbindService(this);
                dddssad.a("Service has been unbound: " + componentName.getClassName());
            } catch (Throwable th) {
                dddssad.a(th);
            }
        } catch (Throwable th2) {
            try {
                dddssad.a(th2);
                this.f290a.b(th2);
            } finally {
                try {
                    this.f22711a.unbindService(this);
                    dddssad.a("Service has been unbound: " + componentName.getClassName());
                } catch (Throwable th3) {
                    dddssad.a(th3);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        dddssad.a("Service has been disconnected: " + componentName.getClassName());
    }
}
