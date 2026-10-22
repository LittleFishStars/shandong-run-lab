package com.kwad.sdk.api.loader;

import android.content.Context;
import com.zj.adlib.c30;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class p {
    public static int a(String str, InputStream inputStream, String str2) throws Throwable {
        try {
            boolean zA = a(str, o.decrypt(str2.getBytes("UTF-8"), a(inputStream)));
            boolean zA2 = a(inputStream, str, true);
            if (zA && zA2) {
                return 1;
            }
            if (zA) {
                return -104;
            }
            return c30.j;
        } catch (UnsupportedEncodingException unused) {
            return c30.i;
        }
    }

    public static String bs(Context context) {
        q qVarHH = r.HH();
        if (qVarHH != null) {
            return qVarHH.getAESKey(context);
        }
        return null;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static int k(byte[] bArr) {
        int i = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        System.out.println("Converted int: " + Integer.toHexString(i));
        return i;
    }

    private static byte[] a(InputStream inputStream) {
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
            int iK = k(bArr);
            byte[] bArr2 = new byte[iK];
            int i = inputStream.read(bArr2, 0, iK);
            if (i > 0) {
                System.out.println("readEncryptedByteArray bytes content: " + i);
                return bArr2;
            }
            System.out.println("readEncryptedByteArray File is empty.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    System.out.println("writeEncryptedByteToFile successfully.");
                    closeQuietly(fileOutputStream2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private static boolean a(InputStream inputStream, String str, boolean z) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str, true);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            System.out.println("File copied successfully.");
                            closeQuietly(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
