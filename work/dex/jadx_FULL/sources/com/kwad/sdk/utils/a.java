package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class a {
    @Nullable
    @WorkerThread
    public static String getFileMD5(File file) {
        try {
            byte[] fileMD5Digest = getFileMD5Digest(file);
            if (fileMD5Digest != null && fileMD5Digest.length != 0) {
                return an.toHexString(fileMD5Digest, 0, fileMD5Digest.length);
            }
            return null;
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.e("FileMD5Utils", "cannot calculate md5 of file", e);
            return null;
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] getFileMD5Digest(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4096];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, i);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("FileMD5Utils", "getting file md5 digest error.", e);
            return null;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] hD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileMD5Digest(new File(str));
    }
}
