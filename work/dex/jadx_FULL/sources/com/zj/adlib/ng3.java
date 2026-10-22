package com.zj.adlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ng3 {
    public static byte[] a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return j == 0 ? s51.d(inputStream) : s51.e(inputStream, (int) j);
        }
        throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
    }

    public static byte[] b(File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArrA = a(fileInputStream2, fileInputStream2.getChannel().size());
                fileInputStream2.close();
                return bArrA;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
