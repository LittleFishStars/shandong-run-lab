package com.alipay.android.phone.mobilesdk.socketcraft.f.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25305a = "com.alipay.android.phone.mobilesdk.socketcraft.d.d.a";
    private static b b;

    public static final b a() {
        b bVar = b;
        if (bVar != null) {
            return bVar;
        }
        synchronized (c.class) {
            b bVar2 = b;
            if (bVar2 != null) {
                return bVar2;
            }
            if (com.alipay.android.phone.mobilesdk.socketcraft.f.a.b()) {
                try {
                    b bVar3 = (b) com.alipay.android.phone.mobilesdk.socketcraft.d.d.a.class.newInstance();
                    b = bVar3;
                    return bVar3;
                } catch (Throwable th) {
                    com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b("SCNetworkAsyncTaskExecutorFactory", String.format("Instance class: %s error", f25305a), th);
                }
            }
            if (b == null) {
                b = new a();
            }
            return b;
        }
    }
}
