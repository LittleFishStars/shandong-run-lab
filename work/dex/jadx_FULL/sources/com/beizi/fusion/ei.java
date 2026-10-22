package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class ei implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27239a;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) {
            ci ciVarA = ci.a.a(iBinder);
            if (ciVarA == null) {
                throw new tj("MsaIdInterface is null");
            }
            if (ciVarA.isSupported()) {
                return ciVarA.getOAID();
            }
            throw new tj("MsaIdInterface#isSupported return false");
        }
    }

    public ei(Context context) {
        this.f27239a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f27239a.getPackageName());
            this.f27239a.startForegroundService(intent);
        } catch (Exception e) {
            yj.a(e);
        }
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f27239a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27239a == null || kcVar == null) {
            return;
        }
        b();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f27239a.getPackageName());
        bk.a(this.f27239a, intent, kcVar, new a());
    }
}
