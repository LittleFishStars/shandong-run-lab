package cn.hzjizhun.admin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.cn_oaid.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.huawei.hms.common.PackageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f288a;

    public class a implements dadkdadds.kdsksdda {
        public a() {
        }

        @Override // cn.hzjizhun.admin.dadkdadds.kdsksdda
        public String a(IBinder iBinder) {
            OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                throw new OAIDException("User has disabled advertising identifier");
            }
            return openDeviceIdentifierServiceAsInterface.getOaid();
        }
    }

    public c(Context context) {
        this.f22707a = context;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        Context context = this.f22707a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f288a = "com.huawei.hwid";
                return true;
            }
            if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f288a = "com.huawei.hwid.tv";
                return true;
            }
            this.f288a = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
            return packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) != null;
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        Context context = this.f22707a;
        if (context == null || ddakdVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                dddssad.a("Get oaid from global settings: " + string);
                ddakdVar.a(string);
                return;
            }
        } catch (Throwable th) {
            dddssad.a(th);
        }
        if (TextUtils.isEmpty(this.f288a) && !a()) {
            ddakdVar.b(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f288a);
        dadkdadds.a(this.f22707a, intent, ddakdVar, new a());
    }
}
