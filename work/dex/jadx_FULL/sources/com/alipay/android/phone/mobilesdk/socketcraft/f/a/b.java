package com.alipay.android.phone.mobilesdk.socketcraft.f.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f25300a;

    public static void a(c cVar) {
        f25300a = cVar;
    }

    public static c a() {
        c cVar = f25300a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (b.class) {
            c cVar2 = f25300a;
            if (cVar2 != null) {
                return cVar2;
            }
            if (!com.alipay.android.phone.mobilesdk.socketcraft.f.a.a()) {
                f25300a = com.alipay.android.phone.mobilesdk.socketcraft.f.a.c();
            } else if (com.alipay.android.phone.mobilesdk.socketcraft.f.a.b()) {
                f25300a = com.alipay.android.phone.mobilesdk.socketcraft.f.a.e();
            } else {
                f25300a = com.alipay.android.phone.mobilesdk.socketcraft.f.a.d();
            }
            return f25300a;
        }
    }
}
