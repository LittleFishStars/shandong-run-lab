package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27888a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    ServiceConnection c = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                w0.this.b.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public w0(Context context) {
        this.f27888a = context;
    }

    public void a(b7.b bVar) {
        try {
            this.f27888a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.f27888a.bindService(intent, this.c, 1)) {
            try {
                String strB = new x0((IBinder) this.b.take()).b();
                if (bVar != null) {
                    bVar.a(strB);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
