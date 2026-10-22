package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i8 implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27403a;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) {
            jf jfVarA = jf.a.a(iBinder);
            if (jfVarA != null) {
                return jfVarA.getOAID();
            }
            throw new tj("IdsSupplier is null");
        }
    }

    public i8(Context context) {
        this.f27403a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f27403a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27403a == null || kcVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        bk.a(this.f27403a, intent, kcVar, new a());
    }
}
