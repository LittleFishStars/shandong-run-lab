package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.beizi.fusion.sm.repeackage.com.android.creator.IdsSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h8 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27358a;

    public class a implements ck.a {
        public a() {
        }

        @Override // com.beizi.fusion.ck.a
        public String a(IBinder iBinder) {
            IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (idsSupplierAsInterface != null) {
                return idsSupplierAsInterface.getOAID();
            }
            throw new sj("IdsSupplier is null");
        }
    }

    public h8(Context context) {
        this.f27358a = context;
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        Context context = this.f27358a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27358a == null || jcVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        ck.a(this.f27358a, intent, jcVar, new a());
    }
}
