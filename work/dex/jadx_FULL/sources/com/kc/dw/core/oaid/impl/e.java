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
public class e implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39282a;

    @Keep
    public class a implements m.a {
        public a(e eVar) {
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.kc.dw.core.oaid.repeackage.com.android.creator.a c1029a;
            int i = com.kc.dw.core.oaid.repeackage.com.android.creator.a.AbstractBinderC1028a.f39296a;
            if (iBinder == null) {
                c1029a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                c1029a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.android.creator.a)) ? new com.kc.dw.core.oaid.repeackage.com.android.creator.a.AbstractBinderC1028a.C1029a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.android.creator.a) iInterfaceQueryLocalInterface;
            }
            if (c1029a != null) {
                return c1029a.a();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public e(Context context) {
        this.f39282a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39282a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.f39282a, intent, aVar, new a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39282a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
