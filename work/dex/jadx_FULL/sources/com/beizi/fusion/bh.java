package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class bh implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27104a;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) {
            zb zbVarA = zb.a.a(iBinder);
            if (zbVarA == null) {
                throw new tj("IDeviceidInterface is null");
            }
            if (zbVarA.isSupport()) {
                return zbVarA.getOAID();
            }
            throw new tj("IDeviceidInterface#isSupport return false");
        }
    }

    public bh(Context context) {
        this.f27104a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f27104a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27104a == null || kcVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        bk.a(this.f27104a, intent, kcVar, new a());
    }
}
