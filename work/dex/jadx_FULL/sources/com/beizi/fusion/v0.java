package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class v0 {
    private Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27845a = "ASUSDeviceIDHelper";
    public final LinkedBlockingQueue c = new LinkedBlockingQueue(1);
    ServiceConnection d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                v0.this.c.put(iBinder);
            } catch (Exception e) {
                om.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public v0(Context context) {
        this.b = context;
    }

    public void a(c7.a aVar) {
        try {
            this.b.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e) {
            om.a(e);
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.b.bindService(intent, this.d, 1)) {
            try {
                String strB = new y0((IBinder) this.c.take()).b();
                if (aVar != null) {
                    aVar.a(strB);
                }
            } catch (Exception e2) {
                om.a(e2);
            }
        }
    }
}
