package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.huawei.hms.common.PackageConstants;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class b implements com.hailiang.advlib.open.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32587a;
    private String b;

    @Keep
    public class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f32588a;

        public a(b bVar) {
            this.f32588a = bVar;
        }

        @Override // com.hailiang.advlib.open.oaid.hla.f.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a aVarA = com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a.b.a(iBinder);
            if (aVarA.b()) {
                throw new OAIDException("User has disabled advertising identifier");
            }
            return aVarA.getOaid();
        }
    }

    public b(Context context) {
        this.f32587a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        Context context = this.f32587a;
        if (context == null || aVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                aVar.a(string);
                return;
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            aVar.a(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        f.a(this.f32587a, intent, aVar, new a(this));
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f32587a;
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
        } catch (Exception unused) {
            return false;
        }
    }
}
