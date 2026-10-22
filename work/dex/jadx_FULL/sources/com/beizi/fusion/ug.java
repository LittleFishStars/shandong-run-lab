package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ug {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27831a;
    zg b;
    ServiceConnection c = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ug.this.b = new xg(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public ug(Context context) {
        this.f27831a = context;
    }

    public void a(c7.a aVar) {
        zg zgVar;
        this.f27831a.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.f27831a.bindService(intent, this.c, 1) || (zgVar = this.b) == null) {
            return;
        }
        String strA = zgVar.a();
        if (aVar != null) {
            aVar.a(strA);
        }
    }
}
