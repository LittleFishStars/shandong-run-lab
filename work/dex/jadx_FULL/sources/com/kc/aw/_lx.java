package com.kc.aw;

import android.os.Build;
import com.igexin.assist.util.AssistUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lx {
    public static boolean _a() {
        String str = Build.MANUFACTURER;
        return str.equalsIgnoreCase(AssistUtils.BRAND_HW) || str.equalsIgnoreCase(AssistUtils.BRAND_HON);
    }
}
