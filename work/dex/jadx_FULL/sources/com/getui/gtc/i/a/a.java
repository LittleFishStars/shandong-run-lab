package com.getui.gtc.i.a;

import com.getui.gtc.base.util.io.IOUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f30377a = true;

    public static String a(String str) {
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = bArrDigest[i2];
                int i3 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i3 + 1;
                cArr2[i3] = cArr[b & com.google.common.base.a.q];
            }
            return new String(cArr2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(File file, File file2, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = fileInputStream2.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byte[] bArr2 = new byte[i];
                            System.arraycopy(bArr, 0, bArr2, 0, i);
                            bufferedOutputStream.write(b.a(bArr2, str));
                        }
                        bufferedOutputStream.flush();
                        IOUtils.safeClose(fileInputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            com.getui.gtc.i.c.a.c(e);
                            com.getui.gtc.i.b.a.a(file2);
                            IOUtils.safeClose(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            IOUtils.safeClose(fileInputStream);
                            IOUtils.safeClose(bufferedOutputStream);
                            IOUtils.safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        IOUtils.safeClose(fileInputStream);
                        IOUtils.safeClose(bufferedOutputStream);
                        IOUtils.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        IOUtils.safeClose(bufferedOutputStream);
        IOUtils.safeClose(fileOutputStream);
    }
}
