package cn.hzjizhun.admin;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.hzjizhun.admin.cn_oaid.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22675a;

    /* JADX INFO: renamed from: cn.hzjizhun.admin.a$a, reason: collision with other inner class name */
    public class C0086a implements dadkdadds.kdsksdda {
        public C0086a() {
        }

        @Override // cn.hzjizhun.admin.dadkdadds.kdsksdda
        public String a(IBinder iBinder) {
            IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
            if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                dddssad.a("User has disabled advertising identifier");
            }
            return iAdvertisingIdServiceAsInterface.getId();
        }
    }

    public a(Context context) {
        this.f22675a = context;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        Context context = this.f22675a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f22675a == null || ddakdVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        dadkdadds.a(this.f22675a, intent, ddakdVar, new C0086a());
    }
}
