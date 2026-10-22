package com.aliyun.android.libqueen.aiobasic.helper;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ContextManager {
    private static Context sContext;

    @Keep
    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context == null ? null : context.getApplicationContext();
    }
}
