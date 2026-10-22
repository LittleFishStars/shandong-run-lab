package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f28026a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    ServiceConnection c = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                x8.this.b.put(iBinder);
            } catch (Exception e) {
                om.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public x8(Context context) {
        this.f28026a = context;
    }

    public void a(c7.a aVar) {
        try {
            this.f28026a.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e) {
            om.a(e);
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (this.f28026a.bindService(intent, this.c, 1)) {
                try {
                    a9 a9Var = new a9((IBinder) this.b.take());
                    String strC = a9Var.c();
                    a9Var.b();
                    if (aVar != null) {
                        aVar.a(strC);
                    }
                } catch (Exception e2) {
                    om.a(e2);
                }
            }
        } finally {
            this.f28026a.unbindService(this.c);
        }
    }
}
