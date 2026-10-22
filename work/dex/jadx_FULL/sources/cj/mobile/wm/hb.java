package cj.mobile.wm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class hb implements va {
    public String dexa;

    public class dexa implements ServiceConnection {
        public final /* synthetic */ CountDownLatch dexa;

        public dexa(CountDownLatch countDownLatch) {
            this.dexa = countDownLatch;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CountDownLatch countDownLatch;
            try {
                hb.this.dexa = db.dexa.dexa(iBinder).a();
                f1.dexa("LenovoDeviceIdSupplier", "Service onServiceConnected  oaid", hb.this.dexa);
            } catch (Exception e) {
                f1.dexa("LenovoDeviceIdSupplier", e);
            } finally {
                this.dexa.countDown();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            f1.dexc("LenovoDeviceIdSupplier", "Service onServiceDisconnected");
            this.dexa.countDown();
        }
    }

    @Override // cj.mobile.wm.va
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        dexa dexaVar = new dexa(countDownLatch);
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        f1.dexa("LenovoDeviceIdSupplier", "bindService begin");
        f1.dexa("LenovoDeviceIdSupplier", context.bindService(intent, dexaVar, 1) ? "bindService Successful!" : "bindService Failed!");
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
        f1.dexa("LenovoDeviceIdSupplier", "getOAID oaid", this.dexa);
        return this.dexa;
    }
}
