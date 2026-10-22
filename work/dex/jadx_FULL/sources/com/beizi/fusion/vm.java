package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class vm implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27874a;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) {
            xb xbVarA = xb.a.a(iBinder);
            if (xbVarA != null) {
                return xbVarA.getOAID();
            }
            throw new tj("IDeviceIdService is null");
        }
    }

    public vm(Context context) {
        this.f27874a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f27874a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27874a == null || kcVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        bk.a(this.f27874a, intent, kcVar, new a());
    }
}
