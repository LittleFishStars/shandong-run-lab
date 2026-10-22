package cn.hzjizhun.admin.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MD5Util {
    public static String getMDStr(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
