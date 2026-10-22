package com.acse.ottn;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k0 {
    public static void a(Context context) {
        a(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            a(context.getExternalCacheDir());
        }
    }

    public static String b(Context context) throws Exception {
        long jB = b(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            jB += b(context.getExternalCacheDir());
        }
        return a(jB);
    }

    public static boolean a(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file == null) {
            return true;
        }
        return file.delete();
    }

    public static long b(File file) throws Exception {
        long length;
        long j = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                int length2 = fileArrListFiles.length;
                for (int i = 0; i < length2; i++) {
                    if (fileArrListFiles[i].isDirectory()) {
                        length = b(fileArrListFiles[i]);
                    } else {
                        length = fileArrListFiles[i].length();
                    }
                    j += length;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    public static String a(double d) {
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return "0K";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return new BigDecimal(Double.toString(d2)).setScale(2, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d5).setScale(2, 4).toPlainString() + "TB";
    }
}
