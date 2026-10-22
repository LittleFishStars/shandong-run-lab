package com.ipd.dsp.internal.c2;

import android.util.Log;
import com.ipd.dsp.Dsp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class r {
    public static void a(Throwable th) {
        if (Dsp.isDebugLogEnable()) {
            try {
                th.getClass().getMethod("printStackTrace", null).invoke(th, null);
            } catch (Throwable unused) {
                Log.w("Dsp", th);
            }
        }
    }

    public static String b(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            return simpleName;
        }
        return simpleName + ": " + localizedMessage;
    }
}
