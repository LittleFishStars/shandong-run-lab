package com.huawei.hms.utils;

import com.aliyun.openapiutil.Client;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class SHA256 {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance(Client.HASH_SHA256).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            HMSLog.e("SHA256", "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] digest(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (true) {
                        int i2 = bufferedInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        i += i2;
                        messageDigest.update(bArr, 0, i2);
                    }
                    if (i > 0) {
                        byte[] bArrDigest = messageDigest.digest();
                        IOUtils.closeQuietly((InputStream) bufferedInputStream);
                        return bArrDigest;
                    }
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                } catch (IOException | NoSuchAlgorithmException unused) {
                    bufferedInputStream2 = bufferedInputStream;
                    HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    throw th;
                }
            } catch (IOException | NoSuchAlgorithmException unused2) {
            }
            return new byte[0];
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
    }
}
