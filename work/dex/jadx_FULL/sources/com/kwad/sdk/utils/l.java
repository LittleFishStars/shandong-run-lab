package com.kwad.sdk.utils;

import com.ali.auth.third.login.LoginConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class l {
    public static void at(String str, String str2) {
        com.kwad.sdk.core.d.c.d("callbackLog", str + str2);
    }

    public static void b(String str, String str2, String str3, String str4) {
        at(str, str2 + LoginConstants.UNDER_LINE + str3 + LoginConstants.UNDER_LINE + str4);
    }

    public static void s(String str, int i) {
        com.kwad.sdk.core.d.c.d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }
}
