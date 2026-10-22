package com.beizi.fusion;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.igexin.assist.control.xiaomi.XmSystemUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27192a;
    private c b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static dk f27193a = new dk();
    }

    public enum b {
        REALME("ColorOS", "ro.build.version.oplusrom"),
        OPPO("ColorOS", "ro.build.version.oplusrom"),
        MIUI("MIUI", XmSystemUtils.KEY_VERSION_MIUI),
        HYPER("HyperOS", "ro.mi.os.version.incremental"),
        REDMI("MIUI", XmSystemUtils.KEY_VERSION_MIUI),
        HARMONY("HarmonyOS", com.alipay.sdk.m.d.a.b),
        MAGICUI("MagicUI", "ro.build.version.magic"),
        EMUI("EMUI", "ro.build.version.emui"),
        MEIZU("Flyme", "ro.build.display.id"),
        ONEPLUS("HydrogenOS", com.blankj.utilcode.util.e.h),
        VIVO("Funtouch", "ro.vivo.os.version"),
        NUBIA("ro.build.nubia.rom.name", "ro.build.nubia.rom.code");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27194a;
        private final String b;

        b(String str, String str2) {
            this.f27194a = str;
            this.b = str2;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27195a;
        private final String b;
        private final String c;

        private c(String str, String str2, String str3) {
            this.f27195a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    private dk() {
        if (a.f27193a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static dk a() {
        return a.f27193a;
    }

    private void b(String str) {
        if (d()) {
            a(str, b.HARMONY);
            return;
        }
        b bVar = b.MAGICUI;
        if (TextUtils.isEmpty(a(bVar.b))) {
            a(str, b.EMUI);
        } else {
            a(str, bVar);
        }
    }

    private void d(String str) {
        try {
            if (Integer.parseInt(ro.a(XmSystemUtils.KEY_VERSION_CODE, "0")) >= 816) {
                a(str, b.HYPER);
                return;
            }
        } catch (NumberFormatException unused) {
        }
        a(str, b.MIUI);
    }

    private String e(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(" ", "").toUpperCase() : "";
    }

    private boolean f() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO");
    }

    private boolean g() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public void c() {
        b bVarValueOf;
        if (this.b != null) {
            return;
        }
        String strE = e(Build.BRAND);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            bVarValueOf = b.valueOf(strE);
        } catch (IllegalArgumentException unused) {
            bVarValueOf = null;
        }
        if (bVarValueOf != null) {
            a(strE, bVarValueOf);
            return;
        }
        strE.getClass();
        switch (strE) {
            case "XIAOMI":
                d(strE);
                break;
            case "HONOR":
                b(strE);
                break;
            case "HUAWEI":
                c(strE);
                break;
        }
    }

    private void a(String str, b bVar) {
        if (TextUtils.isEmpty(bVar.f27194a)) {
            return;
        }
        this.b = new c(str, bVar.f27194a.contains(Consts.DOT) ? a(bVar.f27194a) : bVar.f27194a, a(bVar.b));
    }

    private boolean e() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME");
    }

    private boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Exception e) {
            om.a(e);
            return false;
        }
    }

    private String a(String str) {
        return ro.a(str, "");
    }

    public String b() {
        c cVar = this.b;
        return cVar != null ? cVar.c : "";
    }

    public String a(Context context) {
        return xk.a(context, "com.huawei.hwid");
    }

    public String b(Context context) {
        if (TextUtils.isEmpty(this.f27192a)) {
            if (f()) {
                this.f27192a = xk.b(context.getApplicationContext(), "com.bbk.appstore");
            } else if (e()) {
                this.f27192a = xk.b(context.getApplicationContext(), "com.heytap.market");
            } else if (g()) {
                this.f27192a = xk.b(context.getApplicationContext(), "com.xiaomi.market");
            } else {
                this.f27192a = xk.a(context.getApplicationContext(), "com.huawei.appmarket");
            }
        }
        return this.f27192a;
    }

    private void c(String str) {
        if (d()) {
            a(str, b.HARMONY);
        } else {
            a(str, b.EMUI);
        }
    }
}
