package com.bwt.top.cn_oaid.assa;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import com.bwt.top.cn_oaid.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import com.zj.adlib.ija;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28249a;

    public class a implements ddddk.kdsksdda {
        public a(b bVar) {
        }

        @Override // com.bwt.top.cn_oaid.assa.ddddk.kdsksdda
        public String a(IBinder iBinder) {
            IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
            if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                ija.a("User has disabled advertising identifier");
            }
            return iAdvertisingIdServiceAsInterface.getId();
        }
    }

    public b(Context context) {
        this.f28249a = context;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        Context context = this.f28249a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f28249a == null || ddksaVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        ddddk.a(this.f28249a, intent, ddksaVar, new a(this));
    }
}
