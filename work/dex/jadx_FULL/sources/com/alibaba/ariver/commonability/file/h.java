package com.alibaba.ariver.commonability.file;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.zj.adlib.o61;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24024a = "SecurityUtil";

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            RVLogger.e(f24024a, "exception detail", e);
            return null;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes(), 0, str.length());
            return a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean c(String str) {
        return (str.contains("..") || str.contains(WVNativeCallbackUtil.SEPERATER) || str.contains(o61.h) || str.contains("%")) ? false : true;
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str.toLowerCase(Locale.ENGLISH);
    }
}
