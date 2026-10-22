package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class qm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27697a;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c7.a f27698a;

        private a(c7.a aVar) {
            this.f27698a = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String strB = new tm(iBinder).b();
            c7.a aVar = this.f27698a;
            if (aVar != null) {
                aVar.a(strB);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public qm(Context context) {
        this.f27697a = context;
    }

    public void a(c7.a aVar) {
        try {
            this.f27697a.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Exception e) {
            om.a(e);
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        this.f27697a.bindService(intent, new a(aVar), 1);
    }
}
