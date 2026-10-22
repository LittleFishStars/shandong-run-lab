package android.taobao.windvane.d;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c {
    public static void a(Context context) {
    }

    public static boolean a() {
        String str;
        String str2 = Build.MODEL;
        if (str2 == null || !str2.contains("GT-I95") || (str = Build.MANUFACTURER) == null) {
            return false;
        }
        str.equals("samsung");
        return false;
    }
}
