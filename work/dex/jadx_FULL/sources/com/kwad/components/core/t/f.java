package com.kwad.components.core.t;

import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    public static String a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + Consts.DOT + stackTraceElement.getMethodName();
    }

    public static boolean bl(@Nullable String str) {
        if (str == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement).equals(str)) {
                return true;
            }
        }
        return false;
    }
}
