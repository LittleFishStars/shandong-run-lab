package com.kc.cw.ad.d.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.bun.miitmdid.content.StringValues;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38795a;

    public i(Context context) {
        this.f38795a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f38795a.getPackageName());
            this.f38795a.startForegroundService(intent);
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
        }
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38795a == null || cVar == null) {
            return;
        }
        b();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f38795a.getPackageName());
        l.a(this.f38795a, intent, cVar, new l.a(this) { // from class: com.kc.cw.ad.d.a.b.i.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final i f38796a;

            {
                this.f38796a = this;
            }

            @Override // com.kc.cw.ad.d.a.b.l.a
            public String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException {
                com.kc.cw.ad.d.a.a.a.c.a.a aVarA = com.kc.cw.ad.d.a.a.a.c.a.a.AbstractBinderC0987a.a(iBinder);
                if (aVarA == null) {
                    throw new com.kc.cw.ad.d.a.e("MsaIdInterface is null");
                }
                if (aVarA.a()) {
                    return aVarA.c();
                }
                throw new com.kc.cw.ad.d.a.e("MsaIdInterface#isSupported return false");
            }
        });
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        Context context = this.f38795a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
