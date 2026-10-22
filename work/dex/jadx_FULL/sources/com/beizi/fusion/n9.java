package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.beizi.fusion.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.huawei.hms.common.PackageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class n9 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27556a;
    private String b;

    public class a implements ck.a {
        public a() {
        }

        @Override // com.beizi.fusion.ck.a
        public String a(IBinder iBinder) {
            OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                throw new sj("User has disabled advertising identifier");
            }
            return openDeviceIdentifierServiceAsInterface.getOaid();
        }
    }

    public n9(Context context) {
        this.f27556a = context;
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        Context context = this.f27556a;
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
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        Context context = this.f27556a;
        if (context == null || jcVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                xj.a("Get oaid from global settings: " + string);
                jcVar.a(string);
                return;
            }
        } catch (Exception e) {
            xj.a(e);
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            jcVar.a(new sj("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        ck.a(this.f27556a, intent, jcVar, new a());
    }
}
