package com.bwt.top.cn_oaid.assa;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import com.bwt.top.cn_oaid.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.huawei.hms.common.PackageConstants;
import com.zj.adlib.ija;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1479a;

    public class a implements ddddk.kdsksdda {
        public a(f fVar) {
        }

        @Override // com.bwt.top.cn_oaid.assa.ddddk.kdsksdda
        public String a(IBinder iBinder) {
            OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                throw new OAIDException("User has disabled advertising identifier");
            }
            return openDeviceIdentifierServiceAsInterface.getOaid();
        }
    }

    public f(Context context) {
        this.f28255a = context;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        Context context = this.f28255a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f1479a = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f1479a = "com.huawei.hwid.tv";
            } else {
                this.f1479a = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
                if (packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        Context context = this.f28255a;
        if (context == null || ddksaVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                ija.a("Get oaid from global settings: " + string);
                ddksaVar.a(string);
                return;
            }
        } catch (Exception e) {
            ija.a(e);
        }
        if (TextUtils.isEmpty(this.f1479a) && !a()) {
            ddksaVar.b(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f1479a);
        ddddk.a(this.f28255a, intent, ddksaVar, new a(this));
    }
}
