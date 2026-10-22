package com.bwt.top.cn_oaid.assa;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import com.bwt.top.cn_oaid.repeackage.com.android.creator.IdsSupplier;
import com.zj.adlib.ija;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28257a;

    public class a implements ddddk.kdsksdda {
        public a(h hVar) {
        }

        @Override // com.bwt.top.cn_oaid.assa.ddddk.kdsksdda
        public String a(IBinder iBinder) {
            IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (idsSupplierAsInterface != null) {
                return idsSupplierAsInterface.getOAID();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public h(Context context) {
        this.f28257a = context;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        Context context = this.f28257a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f28257a == null || ddksaVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        ddddk.a(this.f28257a, intent, ddksaVar, new a(this));
    }
}
