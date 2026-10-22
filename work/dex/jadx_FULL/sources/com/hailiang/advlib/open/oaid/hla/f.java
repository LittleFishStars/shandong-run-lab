package com.hailiang.advlib.open.oaid.hla;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class f implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32593a;
    private final com.hailiang.advlib.open.oaid.a b;
    private final a c;

    @Keep
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    private f(Context context, com.hailiang.advlib.open.oaid.a aVar, a aVar2) {
        this.f32593a = context instanceof Application ? context : context.getApplicationContext();
        this.b = aVar;
        this.c = aVar2;
    }

    public static void a(Context context, Intent intent, com.hailiang.advlib.open.oaid.a aVar, a aVar2) {
        new f(context, aVar, aVar2).a(intent);
    }

    private void a(Intent intent) {
        try {
            if (this.f32593a.bindService(intent, this, 1)) {
            } else {
                throw new OAIDException("Service binding failed");
            }
        } catch (Exception e) {
            this.b.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            try {
                String strA = this.c.a(iBinder);
                if (strA == null || strA.length() == 0) {
                    throw new OAIDException("OAID/AAID acquire failed");
                }
                this.b.a(strA);
                try {
                    this.f32593a.unbindService(this);
                } catch (Exception unused) {
                }
            } catch (Exception e) {
                this.b.a(e);
            }
        } catch (Throwable th) {
            try {
                this.f32593a.unbindService(this);
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
