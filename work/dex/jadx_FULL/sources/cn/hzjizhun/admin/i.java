package cn.hzjizhun.admin;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.cn_oaid.repeackage.com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22740a;

    public class a implements dadkdadds.kdsksdda {
        public a() {
        }

        @Override // cn.hzjizhun.admin.dadkdadds.kdsksdda
        public String a(IBinder iBinder) {
            IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (iDeviceidInterfaceAsInterface == null) {
                throw new OAIDException("IDeviceidInterface is null");
            }
            if (iDeviceidInterfaceAsInterface.isSupport()) {
                return iDeviceidInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public i(Context context) {
        this.f22740a = context;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        Context context = this.f22740a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f22740a == null || ddakdVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        dadkdadds.a(this.f22740a, intent, ddakdVar, new a());
    }
}
