package com.kc.cw.ad.internal.d;

import android.content.Context;
import android.os.Environment;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
final class t {
    public static File a(Context context) {
        return new File(a(context, true), "video-cache");
    }

    private static File a(Context context, boolean z) {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            externalStorageState = "";
        }
        File fileB = (z && "mounted".equals(externalStorageState)) ? b(context) : null;
        if (fileB == null) {
            fileB = context.getCacheDir();
        }
        if (fileB != null) {
            return fileB;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        com.kc.cw.ad.internal.c.f.d(com.kc.cw.ad.internal.c.f.u, "Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        com.kc.cw.ad.internal.c.f.d(com.kc.cw.ad.internal.c.f.u, "Unable to create external cache directory");
        return null;
    }
}
