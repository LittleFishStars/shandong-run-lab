package com.fl.saas.s2s.videocache;

import android.content.Context;
import android.os.Environment;
import com.fl.saas.config.utils.LogcatUtil;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class StorageUtils {
    private static final String INDIVIDUAL_DIR_NAME = "video-cache";

    private static File getCacheDirectory(Context context, boolean z) {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            externalStorageState = "";
        }
        File externalCacheDir = (z && "mounted".equals(externalStorageState)) ? getExternalCacheDir(context) : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        LogcatUtil.d("Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        LogcatUtil.d("Unable to create external cache directory");
        return null;
    }

    public static File getIndividualCacheDirectory(Context context) {
        return new File(getCacheDirectory(context, true), INDIVIDUAL_DIR_NAME);
    }
}
