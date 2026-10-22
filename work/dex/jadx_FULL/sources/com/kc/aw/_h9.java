package com.kc.aw;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _h9 {
    public static boolean _a(Context context) {
        if (context != null) {
            try {
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
