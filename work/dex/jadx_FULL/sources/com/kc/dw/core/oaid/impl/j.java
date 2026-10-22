package com.kc.dw.core.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bun.miitmdid.content.StringValues;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39287a;

    @Keep
    public class a implements m.a {
        public a(j jVar) {
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.kc.dw.core.oaid.repeackage.com.bun.lib.a c1033a;
            int i = com.kc.dw.core.oaid.repeackage.com.bun.lib.a.AbstractBinderC1032a.f39300a;
            if (iBinder == null) {
                c1033a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                c1033a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.bun.lib.a)) ? new com.kc.dw.core.oaid.repeackage.com.bun.lib.a.AbstractBinderC1032a.C1033a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.bun.lib.a) iInterfaceQueryLocalInterface;
            }
            if (c1033a == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (c1033a.d()) {
                return c1033a.a();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.f39287a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39287a == null || aVar == null) {
            return;
        }
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f39287a.getPackageName());
            this.f39287a.startForegroundService(intent);
        } catch (Exception unused) {
        }
        Intent intent2 = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f39287a.getPackageName());
        m.a(this.f39287a, intent2, aVar, new a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39287a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
