package com.kc.dw.core.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39279a;

    @Keep
    public class a implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39280a;

        public a(b bVar) {
            this.f39280a = bVar;
        }

        @Override // com.kc.dw.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a c1035a;
            int i = com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a.AbstractBinderC1034a.f39302a;
            if (iBinder == null) {
                c1035a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                c1035a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a)) ? new com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a.AbstractBinderC1034a.C1035a(iBinder) : (com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a) iInterfaceQueryLocalInterface;
            }
            if (c1035a != null) {
                return c1035a.a(this.f39280a.f39279a.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public b(Context context) {
        this.f39279a = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39279a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.f39279a, intent, aVar, new a(this));
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39279a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
