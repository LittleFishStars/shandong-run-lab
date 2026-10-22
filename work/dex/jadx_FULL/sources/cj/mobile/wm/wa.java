package cj.mobile.wm;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class wa {
    public static va dexa = null;
    public static String dexb = null;
    public static boolean dexc = false;

    public static synchronized String dexa(Context context) {
        if (context == null) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        if (dexa == null) {
            dexa = eb.dexa();
        }
        va vaVar = dexa;
        if (vaVar != null) {
            try {
                String strA = vaVar.a(context);
                if (!TextUtils.isEmpty(strA)) {
                    dexb = strA;
                }
                dexc = true;
                return dexb;
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
