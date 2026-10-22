package com.byazt.ka;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 874, 13})
public class tt {
    public static int c(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            m.c(th);
            return -1;
        }
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }
}
