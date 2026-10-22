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
public class h implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39285a;

    @Keep
    public class a implements m.a {
        public a(h hVar) {
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a c1043a;
            int i = com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a.AbstractBinderC1042a.f39310a;
            if (iBinder == null) {
                c1043a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                c1043a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a)) ? new com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a.AbstractBinderC1042a.C1043a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a) iInterfaceQueryLocalInterface;
            }
            if (c1043a == null) {
                throw new OAIDException("IDeviceidInterface is null");
            }
            if (c1043a.b()) {
                return c1043a.a();
            }
            throw new OAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public h(Context context) {
        this.f39285a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39285a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        m.a(this.f39285a, intent, aVar, new a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39285a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
