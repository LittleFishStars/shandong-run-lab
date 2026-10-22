package com.kwad.components.core.pfmonitor.model;

import android.content.Context;
import android.os.Environment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private String aix;
    private String aiy;
    private String aiz;

    private e(String str, String str2, String str3) {
        this.aix = str;
        this.aiy = str2;
        this.aiz = str3;
    }

    private static String aH(Context context) {
        try {
            return context.getExternalFilesDir(null).getParent();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static String aI(Context context) {
        try {
            return context.getExternalFilesDir(null).getAbsolutePath();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static String aJ(Context context) {
        try {
            return context.getExternalFilesDir(null).getAbsolutePath();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static String aK(Context context) {
        return context.getDataDir().getAbsolutePath();
    }

    public static e j(Context context, String str) {
        if (str.startsWith("/appInner/")) {
            return new e("/appInner/", str, aK(context) + str.substring(9));
        }
        if (str.startsWith("/appInnerFiles/")) {
            try {
                return new e("/appInnerFiles/", str, context.getFilesDir().getAbsolutePath() + str.substring(14));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                return null;
            }
        }
        if (str.startsWith("/appInnerCache/")) {
            try {
                return new e("/appInnerCache/", str, context.getCacheDir().getAbsolutePath() + str.substring(14));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                return null;
            }
        }
        if (str.startsWith("/appExternal/")) {
            String strSubstring = str.substring(12);
            String strAH = aH(context);
            if (strAH == null) {
                return null;
            }
            return new e("/appExternal/", str, strAH + strSubstring);
        }
        if (str.startsWith("/appExternalFiles/")) {
            String strSubstring2 = str.substring(17);
            return new e("/appExternalFiles/", str, aI(context) + strSubstring2);
        }
        if (str.startsWith("/appExternalCache/")) {
            String strSubstring3 = str.substring(17);
            return new e("/appExternalCache/", str, aJ(context) + strSubstring3);
        }
        if (!str.startsWith("/sdcard/")) {
            return null;
        }
        return new e("/sdcard/", str, Environment.getExternalStorageDirectory().getAbsolutePath() + str.substring(7));
    }

    public final String vv() {
        return this.aiz;
    }

    public final String vw() {
        return this.aiy;
    }
}
