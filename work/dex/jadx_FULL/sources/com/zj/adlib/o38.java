package com.zj.adlib;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class o38 {
    public static boolean a(String phoneNum) {
        return Pattern.compile("^1[3|4|5|6|7|8|9][0-9]\\d{8}$").matcher(phoneNum).matches();
    }

    public static String b(String oriPhone) {
        if (TextUtils.isEmpty(oriPhone) || oriPhone.length() < 4) {
            return "";
        }
        if (oriPhone.length() < 7) {
            return oriPhone;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(oriPhone.substring(0, 3));
        stringBuffer.append("****");
        stringBuffer.append(oriPhone.substring(oriPhone.length() - 4));
        return stringBuffer.toString();
    }
}
