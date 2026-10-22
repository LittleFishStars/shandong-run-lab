package cn.hzjizhun.admin;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.cn_oaid.repeackage.com.samsung.android.deviceidservice.IDeviceIdService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22693a;

    public class a implements dadkdadds.kdsksdda {
        public a() {
        }

        @Override // cn.hzjizhun.admin.dadkdadds.kdsksdda
        public String a(IBinder iBinder) {
            IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (iDeviceIdServiceAsInterface != null) {
                return iDeviceIdServiceAsInterface.getOAID();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public b(Context context) {
        this.f22693a = context;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        Context context = this.f22693a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f22693a == null || ddakdVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        dadkdadds.a(this.f22693a, intent, ddakdVar, new a());
    }
}
