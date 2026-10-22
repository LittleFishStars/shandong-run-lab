package cn.hzjizhun.admin;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.cn_oaid.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22717a;

    public class a implements dadkdadds.kdsksdda {
        public a() {
        }

        @Override // cn.hzjizhun.admin.dadkdadds.kdsksdda
        public String a(IBinder iBinder) {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                return iDeviceIdManagerAsInterface.getOAID(e.this.f22717a.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public e(Context context) {
        if (context instanceof Application) {
            this.f22717a = context;
        } else {
            this.f22717a = context.getApplicationContext();
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        Context context = this.f22717a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f22717a == null || ddakdVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        dadkdadds.a(this.f22717a, intent, ddakdVar, new a());
    }
}
