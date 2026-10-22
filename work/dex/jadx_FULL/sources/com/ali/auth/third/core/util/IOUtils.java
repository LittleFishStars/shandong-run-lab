package com.ali.auth.third.core.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static String toString(InputStream inputStream, String str) {
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr, 0, 1024);
                    if (i == -1) {
                        String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                        closeQuietly(inputStream);
                        return str2;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            closeQuietly(inputStream);
            throw th;
        }
    }
}
