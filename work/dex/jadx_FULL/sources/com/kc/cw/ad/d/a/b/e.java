package com.kc.cw.ad.d.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38788a;

    public e(Context context) {
        this.f38788a = context;
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38788a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        l.a(this.f38788a, intent, cVar, new l.a(this) { // from class: com.kc.cw.ad.d.a.b.e.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38789a;

            {
                this.f38789a = this;
            }

            @Override // com.kc.cw.ad.d.a.b.l.a
            public String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException {
                com.kc.cw.ad.d.a.a.a.a.a.a aVarA = com.kc.cw.ad.d.a.a.a.a.a.a.AbstractBinderC0983a.a(iBinder);
                if (aVarA != null) {
                    return aVarA.b();
                }
                throw new com.kc.cw.ad.d.a.e("IdsSupplier is null");
            }
        });
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        Context context = this.f38788a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
