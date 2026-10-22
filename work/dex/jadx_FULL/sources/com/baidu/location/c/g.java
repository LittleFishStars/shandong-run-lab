package com.baidu.location.c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g {
    private static boolean d = false;
    private static e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26438a = true;
    private boolean b = true;
    private boolean c = false;

    /* JADX INFO: renamed from: com.baidu.location.c.g$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26439a;

        static {
            int[] iArr = new int[a.values().length];
            f26439a = iArr;
            try {
                iArr[a.ONLY_CELL_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26439a[a.ONLY_WIFI_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26439a[a.GET_ALL_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum a {
        ONLY_CELL_MODE,
        ONLY_WIFI_MODE,
        GET_ALL_DATA
    }

    public static boolean a() {
        return d;
    }

    public static e h() {
        return e;
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        return com.baidu.location.c.a.a.a().b(aVar, telephonyManager);
    }

    public String a(int i, boolean z, k kVar, int i2) {
        return com.baidu.location.c.a.b.a().a(i, z, kVar, i2);
    }

    public String a(WifiInfo wifiInfo, String str) {
        return com.baidu.location.c.a.b.a().a(wifiInfo, str);
    }

    public String a(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().a(aVar);
    }

    public String a(k kVar, int i, String str, boolean z, int i2) {
        return com.baidu.location.c.a.b.a().a(kVar, i, str, z, i2);
    }

    public void a(int i) {
        if (i >= 0) {
            com.baidu.location.c.a.a.a().a(i);
        }
    }

    public void a(Context context, List<String> list) {
        if (this.f26438a) {
            com.baidu.location.c.a.a.a().a(context);
        }
        if (this.b) {
            com.baidu.location.c.a.b.a().a(context, list);
        }
        this.c = true;
    }

    public void a(e eVar) {
        e = eVar;
    }

    public void a(a aVar) {
        int i = AnonymousClass1.f26439a[aVar.ordinal()];
        if (i == 1) {
            this.f26438a = true;
            this.b = false;
            return;
        }
        if (i == 2) {
            this.f26438a = false;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException("Illegal this mode : " + aVar);
            }
            this.f26438a = true;
        }
        this.b = true;
    }

    public void a(boolean z) {
        com.baidu.location.c.a.a.a().a(z);
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        return com.baidu.location.c.a.a.a().a(aVar, aVar2);
    }

    public HashSet<String> b(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().c(aVar);
    }

    public void b() {
        if (this.f26438a) {
            com.baidu.location.c.a.a.a().b();
        }
        if (this.b) {
            com.baidu.location.c.a.b.a().b();
        }
        this.c = false;
    }

    public void b(int i) {
        if (i >= 0) {
            com.baidu.location.c.a.b.a().a(i);
        }
    }

    public void b(boolean z) {
        com.baidu.location.c.a.a.a().b(z);
    }

    public long c() {
        return com.baidu.location.c.a.b.a().c();
    }

    public String c(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().b(aVar);
    }

    public void c(int i) {
        com.baidu.location.c.a.a.a().b(Math.max(i, 29));
    }

    public com.baidu.location.c.a d(int i) {
        if (this.c && this.f26438a) {
            return com.baidu.location.c.a.a.a().c(i);
        }
        return null;
    }

    public boolean d() {
        return com.baidu.location.c.a.a.a().c();
    }

    public k e(int i) {
        if (this.c && this.b) {
            return com.baidu.location.c.a.b.a().a(i);
        }
        return null;
    }

    public String e() {
        return com.baidu.location.c.a.b.a().e();
    }

    public WifiInfo f() {
        return com.baidu.location.c.a.b.a().f();
    }

    public k g() {
        return com.baidu.location.c.a.b.a().d();
    }
}
