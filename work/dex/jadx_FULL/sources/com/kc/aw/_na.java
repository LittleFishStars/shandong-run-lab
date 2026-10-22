package com.kc.aw;

import android.content.Context;
import android.os.Environment;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _na {
    public static File _a(Context context) {
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            StringBuilder sb_a = _jf._a("/data/data/");
            sb_a.append(context.getPackageName());
            sb_a.append("/cache/");
            externalCacheDir = new File(sb_a.toString());
        }
        return new File(externalCacheDir, "video-cache");
    }
}
