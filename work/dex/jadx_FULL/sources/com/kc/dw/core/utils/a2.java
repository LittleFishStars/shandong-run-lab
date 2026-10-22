package com.kc.dw.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kc.dw.core.loader.aac;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a2 {
    public static Intent a(String str, Context context) {
        String strA;
        String strA2;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = false;
            Intent uri = Intent.parseUri(str, 0);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            uri.setFlags(268435456);
            if (context != null && uri.resolveActivity(context.getPackageManager()) == null) {
                z = true;
            }
            if (z) {
                return null;
            }
            ah ahVar = new ah();
            try {
                strA = d1.a(aac.dd);
            } catch (Exception e) {
                e.printStackTrace();
                strA = "";
            }
            ahVar.d(strA);
            try {
                strA2 = d1.a(aac.df);
            } catch (Exception e2) {
                e2.printStackTrace();
                strA2 = "";
            }
            return (Intent) ahVar.c(uri, strA2, "");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
