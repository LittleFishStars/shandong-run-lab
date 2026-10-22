package com.kc.cw.ad.d.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38792a;

    public g(Context context) {
        this.f38792a = context;
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38792a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        l.a(this.f38792a, intent, cVar, new l.a(this) { // from class: com.kc.cw.ad.d.a.b.g.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final g f38793a;

            {
                this.f38793a = this;
            }

            @Override // com.kc.cw.ad.d.a.b.l.a
            public String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException {
                com.kc.cw.ad.d.a.a.a.h.a.a aVarA = com.kc.cw.ad.d.a.a.a.h.a.a.AbstractBinderC0997a.a(iBinder);
                if (aVarA == null) {
                    throw new com.kc.cw.ad.d.a.e("IDeviceidInterface is null");
                }
                if (aVarA.c()) {
                    return aVarA.a();
                }
                throw new com.kc.cw.ad.d.a.e("IDeviceidInterface#isSupport return false");
            }
        });
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        Context context = this.f38792a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
