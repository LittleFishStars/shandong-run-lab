package com.beizi.fusion;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.igexin.assist.control.xiaomi.XmSystemUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f27241a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ek f27242a = new ek();
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
        private final String f27243a;
        private final String b;

        b(String str, String str2) {
            this.f27243a = str;
            this.b = str2;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27244a;
        private final String b;
        private final String c;

        private c(String str, String str2, String str3) {
            this.f27244a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    private ek() {
        if (a.f27242a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static ek a() {
        return a.f27242a;
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
            if (Integer.valueOf(qo.a(XmSystemUtils.KEY_VERSION_CODE, "0")).intValue() >= 816) {
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

    public void c() {
        b bVarValueOf;
        if (this.f27241a != null) {
            return;
        }
        String strE = e(Build.BRAND);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            bVarValueOf = b.valueOf(strE);
        } catch (Throwable unused) {
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
        if (TextUtils.isEmpty(bVar.f27243a)) {
            return;
        }
        this.f27241a = new c(str, bVar.f27243a.contains(Consts.DOT) ? a(bVar.f27243a) : bVar.f27243a, a(bVar.b));
    }

    private boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Exception unused) {
            return false;
        }
    }

    private String a(String str) {
        return qo.a(str, "");
    }

    public String b() {
        c cVar = this.f27241a;
        return cVar != null ? cVar.c : "";
    }

    private void c(String str) {
        if (d()) {
            a(str, b.HARMONY);
        } else {
            a(str, b.EMUI);
        }
    }
}
