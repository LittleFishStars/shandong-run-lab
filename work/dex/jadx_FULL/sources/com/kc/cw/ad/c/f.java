package com.kc.cw.ad.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f38744a = null;
    private static String b = null;
    private static boolean c = false;

    public static String a(Context context) {
        synchronized (f.class) {
            if (context != null) {
                try {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        if (f38744a == null) {
                            f38744a = a.a();
                        }
                        c cVar = f38744a;
                        if (cVar != null) {
                            try {
                                String strA = cVar.a(context);
                                if (!TextUtils.isEmpty(strA)) {
                                    b = strA;
                                }
                                c = true;
                                return b;
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public static String b(Context context) {
        return c ? b : a(context);
    }
}
