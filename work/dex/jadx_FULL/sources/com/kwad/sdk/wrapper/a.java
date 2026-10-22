package com.kwad.sdk.wrapper;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
final class a {
    private static File aIg;

    private static File br(Context context) {
        if (aIg == null) {
            aIg = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return aIg;
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.isDirectory();
        }
        return file;
    }

    private static String w(Context context, String str) {
        return i(new File(br(context), "apk-" + str)).getPath();
    }

    public static String y(Context context, String str) {
        File file = new File(w(context, str), "dynamic.apk");
        return file.exists() ? file.getPath() : new File(w(context, str), "dynamic_apk").getPath();
    }
}
