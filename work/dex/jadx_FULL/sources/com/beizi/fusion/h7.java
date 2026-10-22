package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h7 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h7 f27357a = new h7();
    }

    private h7() {
    }

    private int b() {
        String strA = a("ro.product.board");
        if (strA == null) {
            return 0;
        }
        String lowerCase = strA.toLowerCase();
        return (lowerCase.contains("android") || lowerCase.contains("goldfish")) ? 1 : 2;
    }

    private int c() {
        String strA = a("ro.build.flavor");
        if (strA == null) {
            return 0;
        }
        String lowerCase = strA.toLowerCase();
        return (lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2;
    }

    private int d() {
        String strA = a("ro.hardware");
        if (strA == null) {
            return 0;
        }
        String lowerCase = strA.toLowerCase();
        lowerCase.getClass();
        switch (lowerCase) {
            case "cancro":
            case "vbox86":
            case "nox":
            case "ttvm":
            case "vbox":
            case "intel":
            case "android_x86":
                return 1;
            default:
                return 2;
        }
    }

    private int e() {
        String strA = a("ro.product.manufacturer");
        if (strA == null) {
            return 0;
        }
        String lowerCase = strA.toLowerCase();
        return (lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2;
    }

    private int f() {
        String strA = a("ro.product.model");
        if (strA == null) {
            return 0;
        }
        String lowerCase = strA.toLowerCase();
        return (lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2;
    }

    private int g() {
        String strA = a("ro.board.platform");
        if (strA == null) {
            return 0;
        }
        return strA.toLowerCase().contains("android") ? 1 : 2;
    }

    public static final h7 h() {
        return a.f27357a;
    }

    public boolean a(Context context) {
        int i;
        if (context == null) {
            return true;
        }
        int iD = d();
        if (iD == 0) {
            i = 1;
        } else {
            if (iD == 1) {
                return true;
            }
            i = 0;
        }
        int iC = c();
        if (iC == 0) {
            i++;
        } else if (iC == 1) {
            return true;
        }
        int iF = f();
        if (iF == 0) {
            i++;
        } else if (iF == 1) {
            return true;
        }
        int iE = e();
        if (iE == 0) {
            i++;
        } else if (iE == 1) {
            return true;
        }
        int iB = b();
        if (iB == 0) {
            i++;
        } else if (iB == 1) {
            return true;
        }
        int iG = g();
        if (iG == 0) {
            i++;
        } else if (iG == 1) {
            return true;
        }
        int iA = a();
        if (iA == 0) {
            i += 2;
        } else if (iA == 1) {
            return true;
        }
        if (!d(context)) {
            i++;
        }
        if (!c(context)) {
            i++;
        }
        if (!b(context)) {
            i++;
        }
        return i > 3;
    }

    private boolean d(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean b(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean c(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.camera");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String a(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod(com.acse.ottn.p3.f, String.class).invoke(null, str);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private int a() {
        String strA = a("gsm.version.baseband");
        if (strA == null) {
            return 0;
        }
        return strA.contains(g3.a("MS4wLjAuMA==")) ? 1 : 2;
    }
}
