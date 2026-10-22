package com.kwad.sdk.utils;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.RequiresApi;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class r {
    public static void a(File[] fileArr, String str) throws Throwable {
        a(fileArr, str, -1);
    }

    @RequiresApi(api = 19)
    public static byte[] o(byte[] bArr) {
        byte[] byteArray = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return byteArray;
    }

    private static void a(File[] fileArr, String str, int i) throws Throwable {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                try {
                    byte[] bArr = new byte[4096];
                    int i2 = 0;
                    while (i2 < fileArr.length) {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileArr[i2]), 4096);
                        try {
                            String absolutePath = fileArr[i2].getAbsolutePath();
                            zipOutputStream.putNextEntry(new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
                            while (true) {
                                int i3 = bufferedInputStream2.read(bArr, 0, 4096);
                                if (i3 == -1) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, i3);
                                }
                            }
                            bufferedInputStream2.close();
                            i2++;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
    }
}
