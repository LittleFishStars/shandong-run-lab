package com.kc.dw.core.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39278a;

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.impl.a$a, reason: collision with other inner class name */
    @Keep
    public class C1027a implements m.a {
        public C1027a(a aVar) {
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a c1031a;
            int i = com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a.AbstractBinderC1030a.f39298a;
            if (iBinder == null) {
                c1031a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                c1031a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a)) ? new com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a.AbstractBinderC1030a.C1031a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a) iInterfaceQueryLocalInterface;
            }
            if (c1031a == null) {
                throw new OAIDException("IDidAidlInterface is null");
            }
            if (c1031a.b()) {
                return c1031a.a();
            }
            throw new OAIDException("IDidAidlInterface#isSupport return false");
        }
    }

    public a(Context context) {
        this.f39278a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39278a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.f39278a, intent, aVar, new C1027a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39278a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
