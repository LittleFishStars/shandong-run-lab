package com.alibaba.ariver.engine.common.worker;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WorkerUtils {
    public static boolean isDevSession(String str) {
        return !TextUtils.isEmpty(str) && str.contains("68687029");
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length < length2) {
            return false;
        }
        return length == length2 ? str.equalsIgnoreCase(str2) : str.substring(0, length2).equalsIgnoreCase(str2);
    }
}
