package com.alipay.android.phone.mobilesdk.socketcraft.f.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f25302a;

    public static final b a() {
        b bVar = f25302a;
        if (bVar != null) {
            return bVar;
        }
        synchronized (c.class) {
            b bVar2 = f25302a;
            if (bVar2 != null) {
                return bVar2;
            }
            if (com.alipay.android.phone.mobilesdk.socketcraft.f.a.b()) {
                f25302a = com.alipay.android.phone.mobilesdk.socketcraft.f.a.f();
            } else {
                f25302a = new a();
            }
            return f25302a;
        }
    }

    public static void a(b bVar) {
        f25302a = bVar;
    }
}
