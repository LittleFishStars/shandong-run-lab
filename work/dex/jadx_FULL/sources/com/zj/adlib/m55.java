package com.zj.adlib;

import com.alibaba.ariver.resource.api.prepare.PrepareException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class m55 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f43225a = {"0", "1", "2", "3", "4", "5", "6", "7", PrepareException.ERROR_AUTH_FAIL, "9", "a", "b", "c", "d", "e", "f"};

    public static String a(byte[] b) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : b) {
            stringBuffer.append(b(b2));
        }
        return stringBuffer.toString();
    }

    public static String b(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f43225a;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }

    public static String c(String origin) {
        return d(origin, "UTF-8");
    }

    public static String d(String origin, String charsetname) {
        String str = null;
        try {
            String str2 = new String(origin);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.digest(str2.getBytes(charsetname));
                return (charsetname == null || "".equals(charsetname)) ? a(messageDigest.digest(str2.getBytes())) : a(messageDigest.digest(str2.getBytes(charsetname)));
            } catch (Exception unused) {
                str = str2;
                return str;
            }
        } catch (Exception unused2) {
        }
    }
}
