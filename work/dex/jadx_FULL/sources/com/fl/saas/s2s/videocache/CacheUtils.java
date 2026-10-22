package com.fl.saas.s2s.videocache;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CacheUtils {
    private static void cleanDirectory(File file) throws IOException {
        File[] fileArrListFiles;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                delete(file2);
            }
        }
    }

    public static void cleanVideoCacheDir(Context context) throws IOException {
        cleanDirectory(getVideoCacheDir(context));
    }

    private static void delete(File file) throws IOException {
        if (!file.isFile() || !file.exists()) {
            cleanDirectory(file);
        }
        deleteOrThrow(file);
    }

    private static void deleteOrThrow(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("File %s can't be deleted", file.getAbsolutePath()));
        }
    }

    public static File getVideoCacheDir(Context context) {
        return context.getExternalCacheDir();
    }
}
