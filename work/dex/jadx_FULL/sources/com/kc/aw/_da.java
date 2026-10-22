package com.kc.aw;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _da {
    public static File _a(Context context, String str) {
        try {
            File file = new File(_a(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            if (TextUtils.isEmpty(str)) {
                str = String.valueOf(System.currentTimeMillis());
            }
            return new File(_a(context), str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String _a(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "ptg_download_dir";
    }

    public static String _a(String str, String str2) {
        return com.kc.aw.lib.utils._a._c(str) + str2;
    }

    public static boolean _a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }
}
