package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f28060a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    ServiceConnection c = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                y8.this.b.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public y8(Context context) {
        this.f28060a = context;
    }

    public void a(b7.b bVar) {
        try {
            this.f28060a.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (this.f28060a.bindService(intent, this.c, 1)) {
                try {
                    z8 z8Var = new z8((IBinder) this.b.take());
                    String strC = z8Var.c();
                    z8Var.b();
                    if (bVar != null) {
                        bVar.a(strC);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            this.f28060a.unbindService(this.c);
        }
    }
}
