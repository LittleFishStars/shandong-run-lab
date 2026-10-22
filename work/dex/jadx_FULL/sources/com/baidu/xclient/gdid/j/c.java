package com.baidu.xclient.gdid.j;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {
    public static String a(String str, String str2, StringBuilder sb) {
        if (!a(str2) && !TextUtils.isEmpty(str2)) {
            return str2;
        }
        a(sb, str, str2);
        return "";
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append(LoginConstants.UNDER_LINE);
        }
        sb.append(str);
        sb.append("*");
        sb.append(str2);
    }

    public static boolean a(String str) {
        return "-1000".equals(str) || "-1001".equals(str);
    }
}
