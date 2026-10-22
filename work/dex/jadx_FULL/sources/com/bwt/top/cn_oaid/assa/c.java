package com.bwt.top.cn_oaid.assa;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import com.bwt.top.cn_oaid.repeackage.com.bun.lib.MsaIdInterface;
import com.zj.adlib.ija;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28250a;

    public class a implements ddddk.kdsksdda {
        public a(c cVar) {
        }

        @Override // com.bwt.top.cn_oaid.assa.ddddk.kdsksdda
        public String a(IBinder iBinder) {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public c(Context context) {
        this.f28250a = context;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        Context context = this.f28250a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f28250a == null || ddksaVar == null) {
            return;
        }
        c();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f28250a.getPackageName());
        ddddk.a(this.f28250a, intent, ddksaVar, new a(this));
    }

    public final void c() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f28250a.getPackageName());
            this.f28250a.startForegroundService(intent);
        } catch (Exception e) {
            ija.a(e);
        }
    }
}
