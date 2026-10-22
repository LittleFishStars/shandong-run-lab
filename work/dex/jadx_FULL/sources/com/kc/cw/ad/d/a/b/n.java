package com.kc.cw.ad.d.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class n implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38802a;

    public n(Context context) {
        this.f38802a = context;
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38802a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        l.a(this.f38802a, intent, cVar, new l.a(this) { // from class: com.kc.cw.ad.d.a.b.n.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final n f38803a;

            {
                this.f38803a = this;
            }

            @Override // com.kc.cw.ad.d.a.b.l.a
            public String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException {
                com.kc.cw.ad.d.a.a.a.f.a.a.a aVarA = com.kc.cw.ad.d.a.a.a.f.a.a.a.AbstractBinderC0993a.a(iBinder);
                if (aVarA != null) {
                    return aVarA.a();
                }
                throw new com.kc.cw.ad.d.a.e("IDeviceIdService is null");
            }
        });
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        Context context = this.f38802a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
