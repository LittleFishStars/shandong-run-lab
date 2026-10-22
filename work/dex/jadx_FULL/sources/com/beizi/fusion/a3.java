package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class a3 implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f26992a;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) {
            ac acVarA = ac.a.a(iBinder);
            if (acVarA == null) {
                throw new tj("IDidAidlInterface is null");
            }
            if (acVarA.isSupport()) {
                return acVarA.getOAID();
            }
            throw new tj("IDidAidlInterface#isSupport return false");
        }
    }

    public a3(Context context) {
        this.f26992a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f26992a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f26992a == null || kcVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        bk.a(this.f26992a, intent, kcVar, new a());
    }
}
