package com.alibaba.ariver.commonability.file;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MD5Util {
    public static final String ALGORIGTHM_MD5 = "MD5";
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final int READ_BUFFER_SIZE = 1024;
    private static final String TAG = "MD5Util";
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getMD5Base64(String str) {
        try {
            return Base64.encodeToString(getMD5Byte(str.getBytes("UTF-8")), 2);
        } catch (Throwable th) {
            RVLogger.e(TAG, th.getMessage(), th);
            return null;
        }
    }

    public static byte[] getMD5Byte(byte[] bArr) {
        MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr);
        return mD5Digest.digest();
    }

    public static MessageDigest getMD5Digest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMD5String(String str) {
        try {
            return j.b(getMD5Byte(str.getBytes("UTF-8")));
        } catch (Throwable th) {
            RVLogger.e(TAG, th.getMessage(), th);
            return null;
        }
    }

    public static String getMD5String(byte[] bArr) {
        try {
            return j.b(getMD5Byte(bArr));
        } catch (Throwable th) {
            RVLogger.e(TAG, th.getMessage(), th);
            return null;
        }
    }

    public static byte[] getMD5Byte(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            return getMD5Byte(str.getBytes(str2));
        } catch (Throwable th) {
            RVLogger.e(TAG, th.getMessage(), th);
            return null;
        }
    }

    public static byte[] getMD5Byte(String str) {
        return getMD5Byte(str, "UTF-8");
    }
}
