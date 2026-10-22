package com.kc.dw.core.utils;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o1 {
    public static int a(String str, int i) {
        try {
            return TextUtils.isEmpty(str) ? i : Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() == 1) {
                sb.append("0");
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }
}
