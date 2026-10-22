package com.aliyun.vod.common.utils;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AliYunMathUtils {
    public static int convertFun(int i) {
        if (fun(i)) {
            return i;
        }
        String binaryString = Integer.toBinaryString(i);
        Log.d("Math", "the result is : " + binaryString);
        StringBuilder sb = new StringBuilder("1");
        sb.append(String.format("%0" + binaryString.length() + "d", 0));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("the fun is : ");
        sb2.append(sb.toString());
        Log.d("Math", sb2.toString());
        return Integer.parseInt(sb.toString(), 2);
    }

    public static boolean fun(int i) {
        return i > 0 && (i & (i + (-1))) == 0;
    }
}
