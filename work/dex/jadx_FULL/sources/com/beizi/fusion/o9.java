package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.common.PackageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class o9 implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27600a;
    private String b;

    public class a implements bk.a {
        public a() {
        }

        @Override // com.beizi.fusion.bk.a
        public String a(IBinder iBinder) {
            nk nkVarA = nk.a.a(iBinder);
            if (nkVarA.isOaidTrackLimited()) {
                throw new tj("User has disabled advertising identifier");
            }
            return nkVarA.getOaid();
        }
    }

    public o9(Context context) {
        this.f27600a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f27600a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
                return true;
            }
            if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
                return true;
            }
            this.b = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
            return packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        Context context = this.f27600a;
        if (context == null || kcVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                yj.a("Get oaid from global settings: " + string);
                kcVar.a(string);
                return;
            }
        } catch (Exception e) {
            yj.a(e);
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            kcVar.a(new tj("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        bk.a(this.f27600a, intent, kcVar, new a());
    }
}
