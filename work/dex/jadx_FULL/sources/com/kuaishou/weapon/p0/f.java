package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f40124a = {"0", "1", "2", "3", "4", "5", "6", "7", PrepareException.ERROR_AUTH_FAIL, "9", "a", "b", "c", "d", "e", "f"};

    private static String a(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f40124a;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return a(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            cArr2[i2 + 1] = cArr[b & com.google.common.base.a.q];
        }
        return new String(cArr2);
    }

    public static byte[] d(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(a(b));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str3 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
            } catch (Throwable unused) {
                str2 = str3;
                return str2;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                    String strC = c(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    return strC;
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
            }
        }
        return null;
    }
}
