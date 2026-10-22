package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ar {
    public static boolean R(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean Z(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj != null && obj.equals(obj2);
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
