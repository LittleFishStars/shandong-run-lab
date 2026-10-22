package com.kc.dw.core.utils;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class y0 {
    public static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }
}
