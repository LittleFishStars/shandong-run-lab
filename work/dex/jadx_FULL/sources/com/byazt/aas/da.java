package com.byazt.aas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 72})
public class da {
    public static byte[] c(byte[] bArr) {
        byte[] byteArray = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr2 = new byte[4096];
            while (true) {
                int i = byteArrayInputStream.read(bArr2, 0, 4096);
                if (i <= 0) {
                    gZIPOutputStream.close();
                    byteArrayInputStream.close();
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                gZIPOutputStream.write(bArr2, 0, i);
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return byteArray;
        }
    }

    public static String tt(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                try {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.byazt.nr.m.uj("gzip compress error.", th.getMessage());
                    try {
                    } catch (Throwable th3) {
                        return null;
                    }
                } finally {
                    try {
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Throwable th4) {
                        com.byazt.nr.m.c(th4);
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = null;
        }
    }
}
