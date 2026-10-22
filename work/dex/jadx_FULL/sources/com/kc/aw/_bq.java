package com.kc.aw;

import android.app.Application;
import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bq {
    public static Application _a(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        if (context != null) {
            return (Application) context.getApplicationContext();
        }
        return null;
    }
}
