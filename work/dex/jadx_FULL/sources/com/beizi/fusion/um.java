package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.beizi.fusion.sm.repeackage.com.samsung.android.deviceidservice.IDeviceIdService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class um implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27838a;

    public class a implements ck.a {
        public a() {
        }

        @Override // com.beizi.fusion.ck.a
        public String a(IBinder iBinder) {
            IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (iDeviceIdServiceAsInterface != null) {
                return iDeviceIdServiceAsInterface.getOAID();
            }
            throw new sj("IDeviceIdService is null");
        }
    }

    public um(Context context) {
        this.f27838a = context;
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        Context context = this.f27838a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e) {
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27838a == null || jcVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        ck.a(this.f27838a, intent, jcVar, new a());
    }
}
