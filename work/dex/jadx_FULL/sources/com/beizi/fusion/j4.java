package com.beizi.fusion;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class j4 {
    public static File a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getCacheDir();
        } catch (Exception unused) {
            return context.getCacheDir();
        }
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getFilesDir();
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }
}
