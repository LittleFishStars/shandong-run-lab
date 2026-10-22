package com.kc.aw.lib.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.security.NetworkSecurityPolicy;
import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b {
    public static volatile Integer _a;

    public static void _a() {
        Context context = PtgAdSdk.getContext();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.targetSdkVersion < 28) {
                _a = 1;
            } else if ((applicationInfo.flags & 134217728) != 0) {
                _a = 1;
            } else {
                _a = Integer.valueOf(NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? 1 : 0);
            }
        } catch (Exception e) {
            Logger.e("HttpChecker", "Error checking manifest config", e);
            _a = -1;
        }
    }

    public static boolean _b() {
        Boolean bool = PtgAdSdk.getConfig()._F;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (_a == null) {
            _a();
        }
        return _a.intValue() == 1;
    }
}
