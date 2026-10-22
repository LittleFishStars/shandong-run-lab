package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27729a;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b7.b f27730a;

        private a(b7.b bVar) {
            this.f27730a = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String strB = new sm(iBinder).b();
            b7.b bVar = this.f27730a;
            if (bVar != null) {
                bVar.a(strB);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public rm(Context context) {
        this.f27729a = context;
    }

    public void a(b7.b bVar) {
        try {
            this.f27729a.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            this.f27729a.bindService(intent, new a(bVar), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
