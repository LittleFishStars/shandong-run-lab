package com.kc.cw.ad.c.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.kc.cw.ad.c.c;
import com.kc.cw.ad.d.b.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f38726a;
    private CountDownLatch b;
    private Context c;
    private String d = "";
    private final ServiceConnection e = new ServiceConnection(this) { // from class: com.kc.cw.ad.c.a.a.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f38727a;

        {
            this.f38727a = this;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                try {
                    b bVarA = b.a.a(iBinder);
                    b unused = a.f38726a = bVarA;
                    this.f38727a.d = bVarA.b(this.f38727a.c.getPackageName());
                    f.a("Coolpad", "onServiceConnected: oaid = " + a.f38726a.b(this.f38727a.c.getPackageName()));
                } finally {
                    this.f38727a.b.countDown();
                }
            } catch (RemoteException | NullPointerException e) {
                f.c("Coolpad", "onServiceConnected failed e=" + e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b unused = a.f38726a = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            if (context.bindService(intent, this.e, 1)) {
                return;
            }
            f.c("Coolpad", "bindService return false");
        } catch (Throwable th) {
            f.c("Coolpad", "bindService failed. e=" + th.getMessage());
            this.b.countDown();
        }
    }

    private void c(Context context) {
        try {
            f.a("Coolpad", "call unbindService.");
            context.unbindService(this.e);
        } catch (Throwable th) {
            f.c("Coolpad", "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.kc.cw.ad.c.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.c = context.getApplicationContext();
        this.b = new CountDownLatch(1);
        try {
            b(context);
            if (!this.b.await(500L, TimeUnit.MILLISECONDS)) {
                f.c("Coolpad", "getOAID time-out");
            }
            return this.d;
        } catch (InterruptedException e) {
            f.c("Coolpad", "getOAID interrupted. e=" + e.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
