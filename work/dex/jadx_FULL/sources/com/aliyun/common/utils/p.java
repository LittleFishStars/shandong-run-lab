package com.aliyun.common.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class p {
    public static File a(Context context) {
        return a(context, true);
    }

    public static File a(Context context, boolean z) {
        File fileB = (z && "mounted".equals(Environment.getExternalStorageState()) && c(context)) ? b(context) : null;
        if (fileB == null) {
            fileB = context.getCacheDir();
        }
        if (fileB != null) {
            return fileB;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        j.b("Can't define system cache directory! '%s' will be used.", str);
        return new File(str);
    }

    private static File b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (!externalCacheDir.exists()) {
            if (!externalCacheDir.mkdirs()) {
                j.b("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(externalCacheDir, ".nomedia").createNewFile();
            } catch (IOException unused) {
                j.a("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return externalCacheDir;
    }

    private static boolean c(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
