package com.zj.adlib;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class p4b {
    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(s4b.v("ETUQ1"));
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                String strB = s4b.B(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    v6b.b(e, "MD5", "gfm");
                }
                return strB;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            v6b.b(th, "MD5", "gfm");
            return null;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    v6b.b(e2, "MD5", "gfm");
                }
            }
        }
    }

    public static String b(byte[] bArr) {
        return s4b.B(c(bArr, s4b.v("ETUQ1")));
    }

    public static byte[] c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            v6b.b(th, "MD5", "gmb");
            return null;
        }
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return s4b.B(f(str));
    }

    public static String e(String str) {
        return s4b.E(g(str));
    }

    public static byte[] f(String str) {
        try {
            return h(str);
        } catch (Throwable th) {
            v6b.b(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    public static byte[] g(String str) {
        try {
            return h(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] h(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(s4b.v("ETUQ1"));
        messageDigest.update(s4b.p(str));
        return messageDigest.digest();
    }
}
