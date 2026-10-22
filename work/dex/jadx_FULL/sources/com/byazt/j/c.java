package com.byazt.j;

import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alipay.sdk.m.y.l;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 955, 20})
public class c {
    public static final String c;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z = !TextUtils.isEmpty(str);
        boolean z2 = !TextUtils.isEmpty(Build.ID);
        boolean z3 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb.append("AppDownloader");
        if (z) {
            sb.append(WVNativeCallbackUtil.SEPERATER);
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z) {
            sb.append(" ");
            sb.append(str);
        }
        if (z3 || z2) {
            sb.append(l.b);
            if (z3) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z2) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        c = sb.toString();
    }
}
