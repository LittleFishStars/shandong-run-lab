package com.aliyun.tea.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class IOUtils {
    private IOUtils() {
    }

    public static void closeIfCloseable(Object obj) {
        if (obj instanceof AutoCloseable) {
            closeQuietly((AutoCloseable) obj);
        }
    }

    public static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception unused) {
            }
        }
    }
}
