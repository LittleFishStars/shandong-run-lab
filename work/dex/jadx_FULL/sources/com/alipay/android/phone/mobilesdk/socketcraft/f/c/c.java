package com.alipay.android.phone.mobilesdk.socketcraft.f.c;

import com.alipay.android.phone.mobilesdk.socketcraft.f.a.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25303a = "SSLExtensionsFactory";
    private static final String b = "com.alipay.android.phone.mobilesdk.socketcraft.d.c.a";
    private static b c;

    /* JADX WARN: Code duplicated, block: B:16:0x0042 A[Catch: all -> 0x004d, TryCatch #1 {, blocks: (B:7:0x0008, B:13:0x002d, B:14:0x003e, B:16:0x0042, B:17:0x0049, B:10:0x0010), top: B:25:0x0008, inners: #0 }] */
    public static final b a() {
        b bVar = c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (b.class) {
            if (com.alipay.android.phone.mobilesdk.socketcraft.f.a.b()) {
                try {
                    c = (b) com.alipay.android.phone.mobilesdk.socketcraft.d.c.a.class.newInstance();
                    d.a(f25303a, String.format("New instance ok, class: %s", b));
                } catch (Throwable th) {
                    d.a(f25303a, String.format("New instance error, class: %s", b), th);
                }
                if (c == null) {
                    c = new a();
                }
            } else if (c == null) {
                c = new a();
            }
            throw th;
        }
        return c;
    }
}
