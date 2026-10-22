package com.kwad.sdk.utils;

import com.aliyun.openapiutil.Client;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bh {
    public static String ae(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            String hexString = an.toHexString(messageDigest.digest());
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                            return hexString;
                        }
                        messageDigest.update(bArr, 0, i);
                        th = th;
                        fileInputStream2 = fileInputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String ia(String str) {
        try {
            return an.toHexString(MessageDigest.getInstance(Client.HASH_SHA256).digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }
}
