package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class dl {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static void b(String str) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        c(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static boolean a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || !a(str)) {
            return false;
        }
        try {
            Runtime.getRuntime().exec("chmod " + str2 + " " + str + "\n").waitFor();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(String str, Boolean bool) {
        if (bool.booleanValue()) {
            a("771", new File(str).getParentFile().getAbsolutePath());
        }
    }

    public static boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                for (int i = 0; i < strArrSplit.length && i < strArrSplit2.length; i++) {
                    int iIntValue = Integer.valueOf(strArrSplit[i]).intValue() - Integer.valueOf(strArrSplit2[i]).intValue();
                    if (iIntValue != 0) {
                        return iIntValue > 0;
                    }
                }
                if (strArrSplit.length > strArrSplit2.length) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
