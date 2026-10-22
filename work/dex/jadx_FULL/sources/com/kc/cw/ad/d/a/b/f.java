package com.kc.cw.ad.d.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.common.PackageConstants;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38790a;
    private String b;

    public f(Context context) {
        this.f38790a = context;
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        Context context = this.f38790a;
        if (context == null || cVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                com.kc.cw.ad.d.a.f.a("Get oaid from global settings: " + string);
                cVar.a(string);
                return;
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            cVar.a(new com.kc.cw.ad.d.a.e("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        l.a(this.f38790a, intent, cVar, new l.a(this) { // from class: com.kc.cw.ad.d.a.b.f.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final f f38791a;

            {
                this.f38791a = this;
            }

            @Override // com.kc.cw.ad.d.a.b.l.a
            public String a(IBinder iBinder) throws com.kc.cw.ad.d.a.e, RemoteException {
                com.kc.cw.ad.d.a.a.a.g.a.a.a aVarA = com.kc.cw.ad.d.a.a.a.g.a.a.a.AbstractBinderC0995a.a(iBinder);
                if (aVarA.b()) {
                    throw new com.kc.cw.ad.d.a.e("User has disabled advertising identifier");
                }
                return aVarA.a();
            }
        });
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        Context context = this.f38790a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
            } else {
                this.b = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
                if (packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
