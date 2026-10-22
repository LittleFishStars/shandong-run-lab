package com.kc.aw;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a5 {
    public static volatile String _a;
    public static volatile String _b;
    public static volatile String _c;
    public static volatile String _d;

    public static String _a() {
        if (!TextUtils.isEmpty(_a)) {
            return _a;
        }
        try {
            Context context = PtgAdSdk.getContext();
            if (context != null) {
                CharSequence charSequence = context.getApplicationInfo().nonLocalizedLabel;
                if (charSequence != null) {
                    _a = charSequence.toString();
                }
                if (TextUtils.isEmpty(_a)) {
                    PackageManager packageManager = context.getPackageManager();
                    _a = packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager).toString();
                }
            }
        } catch (Exception unused) {
        }
        return _a;
    }
}
