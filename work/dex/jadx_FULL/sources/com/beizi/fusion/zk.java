package com.beizi.fusion;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class zk {
    private static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean b(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
