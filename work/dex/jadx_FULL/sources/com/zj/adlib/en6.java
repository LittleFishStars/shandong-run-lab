package com.zj.adlib;

import android.os.Environment;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class en6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f41474a = File.separatorChar;

    public en6() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String B() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
    }

    public static String C() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
    }

    public static String D() {
        return !i.z0() ? "" : a(Environment.getExternalStorageDirectory());
    }

    public static String E() {
        String strM = m();
        return TextUtils.isEmpty(strM) ? K() : strM;
    }

    public static String F() {
        return a(Utils.a().getCacheDir());
    }

    public static String G() {
        return a(Utils.a().getCodeCacheDir());
    }

    public static String H() {
        return a(Utils.a().getDataDir());
    }

    public static String I(String str) {
        return a(Utils.a().getDatabasePath(str));
    }

    public static String J() {
        return Utils.a().getApplicationInfo().dataDir + "/databases";
    }

    public static String K() {
        return a(Utils.a().getFilesDir());
    }

    public static String L() {
        return a(Utils.a().getNoBackupFilesDir());
    }

    public static String M() {
        return Utils.a().getApplicationInfo().dataDir + "/shared_prefs";
    }

    public static String N(String str) {
        char[] charArray = str.toCharArray();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (charArray[i3] != f41474a) {
                if (i == -1) {
                    i = i3;
                }
                i2 = i3;
            }
        }
        if (i >= 0 && i2 >= i) {
            return str.substring(i, i2 + 1);
        }
        throw new IllegalArgumentException("segment of <" + str + "> is illegal");
    }

    public static String O() {
        return a(Environment.getRootDirectory());
    }

    public static String P() {
        String strD = D();
        return TextUtils.isEmpty(strD) ? O() : strD;
    }

    public static String Q(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str == null) {
            str = "";
        }
        int length = str.length();
        String strN = N(str2);
        if (length == 0) {
            return f41474a + strN;
        }
        char cCharAt = str.charAt(length - 1);
        char c = f41474a;
        if (cCharAt == c) {
            return str + strN;
        }
        return str + c + strN;
    }

    public static String a(File file) {
        return file == null ? "" : file.getAbsolutePath();
    }

    public static String b() {
        String strI = i();
        return TextUtils.isEmpty(strI) ? H() : strI;
    }

    public static String c() {
        String strH = h();
        return TextUtils.isEmpty(strH) ? F() : strH;
    }

    public static String d() {
        return a(Environment.getDataDirectory());
    }

    public static String e() {
        return a(Environment.getDownloadCacheDirectory());
    }

    public static String f() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
    }

    public static String g() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_ALARMS));
    }

    public static String h() {
        return !i.z0() ? "" : a(Utils.a().getExternalCacheDir());
    }

    public static String i() {
        File externalCacheDir;
        return (i.z0() && (externalCacheDir = Utils.a().getExternalCacheDir()) != null) ? a(externalCacheDir.getParentFile()) : "";
    }

    public static String j() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_DCIM));
    }

    public static String k() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));
    }

    public static String l() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String m() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(null));
    }

    public static String n() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_MOVIES));
    }

    public static String o() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_MUSIC));
    }

    public static String p() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String q() {
        return !i.z0() ? "" : a(Utils.a().getObbDir());
    }

    public static String r() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    public static String s() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_PODCASTS));
    }

    public static String t() {
        return !i.z0() ? "" : a(Utils.a().getExternalFilesDir(Environment.DIRECTORY_RINGTONES));
    }

    public static String u() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    public static String v() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
    }

    public static String w() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String x() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    public static String y() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
    }

    public static String z() {
        return !i.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
    }
}
