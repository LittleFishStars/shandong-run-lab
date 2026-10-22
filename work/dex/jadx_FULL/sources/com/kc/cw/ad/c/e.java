package com.kc.cw.ad.c;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e {
    public static void a(Context context, d dVar) {
        if (context == null) {
            if (dVar != null) {
                dVar.a("");
            }
        } else {
            String strB = f.b(context.getApplicationContext());
            if (dVar != null) {
                dVar.a(strB);
            }
        }
    }
}
