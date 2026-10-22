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
public class o implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39293a;

    @Keep
    public class a implements m.a {
        public a(o oVar) {
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a c1041a;
            int i = com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a.AbstractBinderC1040a.f39308a;
            if (iBinder == null) {
                c1041a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                c1041a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a)) ? new com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a.AbstractBinderC1040a.C1041a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a) iInterfaceQueryLocalInterface;
            }
            if (c1041a != null) {
                return c1041a.a();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public o(Context context) {
        this.f39293a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39293a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        m.a(this.f39293a, intent, aVar, new a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39293a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
