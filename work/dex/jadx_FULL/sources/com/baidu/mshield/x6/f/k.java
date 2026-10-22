package com.baidu.mshield.x6.f;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k {
    public static boolean a(Context context, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        try {
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            f.b(th);
            return false;
        }
    }
}
