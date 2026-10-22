package com.fl.saas;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: com.fl.saas.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1431r {
    public static File a(Context context) {
        File file = new File(context.getCacheDir(), "video_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
