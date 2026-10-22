package com.zj.adlib;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huachenjie.common.cache_webview.WebViewCacheManager;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ba1 {
    public static void a(Context context, String... filepath) {
        g(context);
        e(context);
        d(context);
        h(context);
        f(context);
        if (filepath == null) {
            return;
        }
        for (String str : filepath) {
            b(str);
        }
    }

    public static void b(String filePath) {
        l(new File(filePath));
    }

    public static void c(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }

    public static void d(Context context) {
        l(new File("/data/data/" + context.getPackageName() + "/databases"));
    }

    public static void e(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            l(context.getExternalCacheDir());
        }
    }

    public static void f(Context context) {
        l(context.getFilesDir());
    }

    public static void g(Context context) {
        l(context.getCacheDir());
    }

    public static void h(Context context) {
        l(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
    }

    public static void i(Context context) {
        k(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            k(context.getExternalCacheDir());
        }
        WebViewCacheManager.INSTANCE.a().clearCache();
    }

    public static void j(String filePath) {
        File file = new File(filePath + "/webcache");
        if (file.exists()) {
            k(file);
        }
    }

    public static boolean k(File dir) {
        if (dir != null && dir.isDirectory()) {
            for (String str : dir.list()) {
                if (!k(new File(dir, str))) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public static void l(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    public static void m(String filePath, boolean deleteThisPath) {
        if (TextUtils.isEmpty(filePath)) {
            return;
        }
        try {
            File file = new File(filePath);
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    m(file2.getAbsolutePath(), true);
                }
            }
            if (deleteThisPath) {
                if (!file.isDirectory()) {
                    file.delete();
                } else if (file.listFiles().length == 0) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long n(File file) throws Exception {
        long jN = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i = 0; i < fileArrListFiles.length; i++) {
                jN += fileArrListFiles[i].isDirectory() ? n(fileArrListFiles[i]) : fileArrListFiles[i].length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jN;
    }

    public static long o(Context context) throws Exception {
        long jN = n(context.getCacheDir());
        return Environment.getExternalStorageState().equals("mounted") ? jN + n(context.getExternalCacheDir()) : jN;
    }
}
