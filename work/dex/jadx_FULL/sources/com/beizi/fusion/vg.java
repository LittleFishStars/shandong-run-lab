package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27867a;
    yg b;
    ServiceConnection c = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            vg.this.b = new wg(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public vg(Context context) {
        this.f27867a = context;
    }

    public void a(b7.b bVar) {
        yg ygVar;
        this.f27867a.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.f27867a.bindService(intent, this.c, 1) || (ygVar = this.b) == null) {
            return;
        }
        String strA = ygVar.a();
        if (bVar != null) {
            bVar.a(strA);
        }
    }
}
