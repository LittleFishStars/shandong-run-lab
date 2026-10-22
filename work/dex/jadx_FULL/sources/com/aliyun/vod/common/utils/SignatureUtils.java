package com.aliyun.vod.common.utils;

import android.content.Context;
import com.google.common.base.a;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SignatureUtils {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getSingInfo(Context context) {
        try {
            return hexdigest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String hexdigest(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = bArrDigest[i2];
                int i3 = i + 1;
                char[] cArr2 = hexDigits;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = cArr2[b & a.q];
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
