package com.fl.saas;

import android.content.Context;
import android.os.Environment;
import com.fl.saas.adx.util.LogcatUtil;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class Z0 {
    private static File a(Context context, boolean z) {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            externalStorageState = "";
        }
        File fileA = (z && "mounted".equals(externalStorageState)) ? a(context) : null;
        if (fileA == null) {
            fileA = context.getCacheDir();
        }
        if (fileA != null) {
            return fileA;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        LogcatUtil.d("Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    public static File b(Context context) {
        return new File(a(context, true), "video-cache");
    }

    private static File a(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        LogcatUtil.d("Unable to create external cache directory");
        return null;
    }
}
