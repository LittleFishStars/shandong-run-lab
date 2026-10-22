package com.byazt.mg;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 133})
public class z {
    public static JSONObject c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", tt(context));
            jSONObject.put("inner_free", tt());
            jSONObject.put("inner_total", ve());
            jSONObject.put("sdcard_app_used", ve(context));
            jSONObject.put("sdcard_free", uj());
            jSONObject.put("sdcard_total", n());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long n() {
        try {
            if (c()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long tt(Context context) {
        try {
            return ve(com.byazt.nys.tt.c(context).getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long uj() {
        try {
            if (c()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long ve() {
        try {
            return c(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long ve(Context context) {
        File fileC;
        try {
            if (!c() || (fileC = com.byazt.nys.tt.c(context, null)) == null) {
                return 0L;
            }
            return ve(fileC.getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long tt() {
        try {
            return tt(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long tt(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long ve(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                length = ve(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    public static boolean c() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long c(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
