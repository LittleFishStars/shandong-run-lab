package com.beizi.fusion;

import com.alibaba.ariver.resource.api.prepare.PrepareException;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f27229a = {"0", "1", "2", "3", "4", "5", "6", "7", PrepareException.ERROR_AUTH_FAIL, "9", "a", "b", "c", "d", "e", "f"};

    public static String a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            try {
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
                try {
                    while (digestInputStream.read(new byte[4096]) != -1) {
                    }
                    String strA = a(digestInputStream.getMessageDigest().digest());
                    digestInputStream.close();
                    fileInputStream.close();
                    return strA;
                } catch (Throwable th) {
                    try {
                        digestInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
