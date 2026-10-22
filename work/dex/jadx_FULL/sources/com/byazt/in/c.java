package com.byazt.in;

import com.byazt.as.tt;
import com.byazt.nr.m;
import com.byazt.oz.ve;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1155, 20})
public class c {
    public static String c(String str, String str2) {
        return str + File.separator + str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.Closeable] */
    public static byte[] c(ve veVar) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? cacheDir = veVar.yp().getCacheDir();
        String url = veVar.getUrl();
        if (cacheDir != 0 && url != null) {
            File file = new File((File) cacheDir, url);
            if (file.exists()) {
                ?? IsFile = file.isFile();
                try {
                    if (IsFile != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i = fileInputStream.read(bArr);
                                        if (i == -1) {
                                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                                            tt.c(fileInputStream);
                                            tt.c(byteArrayOutputStream);
                                            return byteArray;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                } catch (OutOfMemoryError e) {
                                    e = e;
                                    m.tt("LocalResHelp", e.toString());
                                    cacheDir = byteArrayOutputStream;
                                    IsFile = fileInputStream;
                                    tt.c(IsFile);
                                    tt.c(cacheDir);
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    m.tt("LocalResHelp", th.toString());
                                    cacheDir = byteArrayOutputStream;
                                    IsFile = fileInputStream;
                                    tt.c(IsFile);
                                    tt.c(cacheDir);
                                    return null;
                                }
                            } catch (OutOfMemoryError e2) {
                                e = e2;
                                byteArrayOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream = null;
                            }
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            fileInputStream = null;
                            byteArrayOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = null;
                            byteArrayOutputStream = null;
                        }
                    }
                } catch (Throwable th4) {
                    tt.c(IsFile);
                    tt.c(cacheDir);
                    throw th4;
                }
            }
        }
        return null;
    }
}
