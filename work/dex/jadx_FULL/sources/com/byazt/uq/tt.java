package com.byazt.uq;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1759, 13})
public class tt {
    public static String c;

    public static String c(Context context) {
        if (c == null) {
            String[] strArrC = ve.c(new File(context.getApplicationInfo().sourceDir));
            String str = strArrC[0];
            c = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + strArrC[2]);
            }
        }
        return c;
    }

    public static boolean c() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
