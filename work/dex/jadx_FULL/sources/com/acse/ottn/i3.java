package com.acse.ottn;

import android.content.Context;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f23058a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String c(String str) {
        if (str != null && str.length() != 0) {
            try {
                String str2 = "";
                for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str2 = str2 + hexString;
                }
                return str2.toLowerCase();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String a(long j) {
        float f;
        String str;
        if (j >= 1000) {
            f = j / 1000;
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "GHz";
            } else {
                str = "MHz";
            }
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "THz";
            }
        } else {
            f = j;
            str = "KHz";
        }
        return new DecimalFormat("#0.0").format(f) + str;
    }

    public String b(long j) {
        float f;
        String str;
        if (j >= 1000) {
            f = j / 1000;
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "MB";
            } else {
                str = "KB";
            }
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "GB";
            }
        } else {
            f = j;
            str = "B";
        }
        return new DecimalFormat("#0.0").format(f) + str;
    }

    public static boolean a(Context context, String str) {
        return context != null && context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public String b(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            System.out.println("error");
            return null;
        }
    }

    public static void a(String str) {
        h2.d("PgyerAnalytics", str);
    }

    public String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(this.f23058a[(bArr[i] & 240) >>> 4]);
            sb.append(this.f23058a[bArr[i] & com.google.common.base.a.q]);
        }
        return sb.toString();
    }
}
