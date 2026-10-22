package com.beizi.fusion;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c6 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27132a;

    public class a implements ck.a {
        public a() {
        }

        @Override // com.beizi.fusion.ck.a
        public String a(IBinder iBinder) {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                return iDeviceIdManagerAsInterface.getOAID(c6.this.f27132a.getPackageName());
            }
            throw new sj("IDeviceIdManager is null");
        }
    }

    public c6(Context context) {
        if (context instanceof Application) {
            this.f27132a = context;
        } else {
            this.f27132a = context.getApplicationContext();
        }
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        Context context = this.f27132a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27132a == null || jcVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        ck.a(this.f27132a, intent, jcVar, new a());
    }
}
