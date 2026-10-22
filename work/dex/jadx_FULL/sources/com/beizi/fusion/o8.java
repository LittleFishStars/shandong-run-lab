package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class o8 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27598a;

    public class a implements ck.a {
        public a() {
        }

        @Override // com.beizi.fusion.ck.a
        public String a(IBinder iBinder) {
            IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
            if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                xj.a("User has disabled advertising identifier");
            }
            return iAdvertisingIdServiceAsInterface.getId();
        }
    }

    public o8(Context context) {
        this.f27598a = context;
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        Context context = this.f27598a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e) {
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27598a == null || jcVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        ck.a(this.f27598a, intent, jcVar, new a());
    }
}
