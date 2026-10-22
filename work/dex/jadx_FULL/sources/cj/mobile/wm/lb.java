package cj.mobile.wm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class lb implements va {

    public static final class dexb implements ServiceConnection {
        public boolean dexa;
        public final LinkedBlockingQueue<IBinder> dexb;

        public dexb() {
            this.dexa = false;
            this.dexb = new LinkedBlockingQueue<>();
        }

        public IBinder dexa() {
            if (this.dexa) {
                throw new IllegalStateException();
            }
            this.dexa = true;
            return this.dexb.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.dexb.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Override // cj.mobile.wm.va
    public String a(Context context) {
        dexb dexbVar = new dexb();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, dexbVar, 1)) {
            try {
                return ya.dexa.dexa(dexbVar.dexa()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(dexbVar);
            }
        }
        return null;
    }
}
