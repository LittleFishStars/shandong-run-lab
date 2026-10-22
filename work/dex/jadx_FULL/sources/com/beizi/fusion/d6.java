package com.beizi.fusion;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d6 implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27169a;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) {
            wb wbVarA = wb.a.a(iBinder);
            if (wbVarA != null) {
                return wbVarA.getOAID(d6.this.f27169a.getPackageName());
            }
            throw new tj("IDeviceIdManager is null");
        }
    }

    public d6(Context context) {
        if (context instanceof Application) {
            this.f27169a = context;
        } else {
            this.f27169a = context.getApplicationContext();
        }
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f27169a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27169a == null || kcVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        bk.a(this.f27169a, intent, kcVar, new a());
    }
}
