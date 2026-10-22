package com.alipay.android.phone.mobilesdk.socketcraft.f;

import com.alipay.android.phone.mobilesdk.socketcraft.d.a.b;
import com.alipay.android.phone.mobilesdk.socketcraft.f.a.c;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a {
    private static final String b = "com.alipay.android.phone.mobilesdk.socketcraft.integrated.logcat.";
    private static final String c = "com.alipay.android.phone.mobilesdk.socketcraft.f.a.a";
    private static final String d = "com.alipay.android.phone.mobilesdk.socketcraft.d.a.a";
    private static final String e = "com.alipay.android.phone.mobilesdk.socketcraft.d.a.b";
    private static final String f = "com.alipay.android.phone.mobilesdk.socketcraft.d.b.a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f25299a = Logger.getLogger(a.class.getName());
    private static Class g = null;
    private static Class h = null;

    static {
        Logger.getLogger("com.alipay.android.phone.mobilesdk.socketcraft").setLevel(Level.ALL);
    }

    public static final boolean a() {
        if (g != null) {
            return true;
        }
        f25299a.info("enter isAndroidPlatform");
        try {
            Class<?> cls = Class.forName("android.os.Build$VERSION");
            return ((Integer) cls.getField("SDK_INT").get(cls)).intValue() > 0;
        } catch (Throwable th) {
            f25299a.log(Level.INFO, String.format("isAndroidPlatform err: %s", th.getMessage()));
        }
    }

    public static final boolean b() {
        if (!a()) {
            return false;
        }
        if (h != null) {
            return true;
        }
        f25299a.info("enter isAndroidMPaaSPlatform");
        try {
            h = Class.forName("com.alipay.mobile.common.transport.utils.LogCatUtil");
            return true;
        } catch (Throwable th) {
            f25299a.log(Level.SEVERE, "isAndroidMPaaSPlatform err", th);
            return false;
        }
    }

    public static final c c() {
        try {
            f25299a.info("enter createJavaLogImpl");
            return (c) com.alipay.android.phone.mobilesdk.socketcraft.f.a.a.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static final c d() {
        try {
            f25299a.info("enter SCLogCatInterface");
            return (c) com.alipay.android.phone.mobilesdk.socketcraft.d.a.a.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static final c e() {
        try {
            f25299a.info("enter createAndroidMPaaSLogImpl");
            return (c) b.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static final com.alipay.android.phone.mobilesdk.socketcraft.f.b.b f() {
        try {
            f25299a.info("enter createMPaaSMonitorPrinter");
            return (com.alipay.android.phone.mobilesdk.socketcraft.f.b.b) com.alipay.android.phone.mobilesdk.socketcraft.d.b.a.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
