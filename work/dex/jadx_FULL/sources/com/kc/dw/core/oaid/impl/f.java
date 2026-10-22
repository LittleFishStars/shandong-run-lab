package com.kc.dw.core.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39283a;

    @Keep
    public class a implements m.a {
        public a(f fVar) {
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a c1037a;
            int i = com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a.AbstractBinderC1036a.f39304a;
            if (iBinder == null) {
                c1037a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                c1037a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a)) ? new com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a.AbstractBinderC1036a.C1037a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a) iInterfaceQueryLocalInterface;
            }
            c1037a.a(true);
            return c1037a.c();
        }
    }

    public f(Context context) {
        this.f39283a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39283a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        m.a(this.f39283a, intent, aVar, new a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39283a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
