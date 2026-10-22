package com.kc.cw.ad.d.a.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38785a;

    public b(Context context) {
        this.f38785a = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38785a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        l.a(this.f38785a, intent, cVar, new l.a(this) { // from class: com.kc.cw.ad.d.a.b.b.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f38786a;

            {
                this.f38786a = this;
            }

            @Override // com.kc.cw.ad.d.a.b.l.a
            public String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException {
                com.kc.cw.ad.d.a.a.a.d.a.a aVarA = com.kc.cw.ad.d.a.a.a.d.a.a.AbstractBinderC0989a.a(iBinder);
                if (aVarA != null) {
                    return aVarA.b(this.f38786a.f38785a.getPackageName());
                }
                throw new com.kc.cw.ad.d.a.e("IDeviceIdManager is null");
            }
        });
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        Context context = this.f38785a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
