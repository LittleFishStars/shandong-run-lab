package com.igexin.c.a.b;

import android.database.Cursor;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.zj.adlib.u15;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f37830a = 512;
    public static final String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    static final char c = '=';
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 1;
    public static final int k = 2;
    private static final String l = "IoUtil";
    private static int[] m;

    public static int a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        return 4;
    }

    public static int a(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((j2 >> 56) & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 7] = (byte) (j2 & 255);
        return 8;
    }

    public static int a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        System.arraycopy(bArr, 0, bArr2, i2, i3);
        return i3;
    }

    private static String a(String str, String str2, String str3) {
        if (str3 == null || str == null || str2 == null) {
            return null;
        }
        if (!str3.contains(str)) {
            return str3;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int iIndexOf = str3.indexOf(str);
            if (iIndexOf == -1) {
                sb.append(str3);
                return sb.toString();
            }
            sb.append(str3.substring(0, iIndexOf));
            sb.append(str2);
            str3 = str3.substring(iIndexOf + str.length());
        }
    }

    private static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (!strArr[0].equals("")) {
            sb.append(strArr[0]);
            sb.append("://");
        }
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(com.google.common.net.c.b);
            sb.append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals(WVNativeCallbackUtil.SEPERATER)) {
                sb.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?');
            sb.append(strArr[5]);
        }
        return sb.toString();
    }

    public static short a(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    private static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(l, th.toString());
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                com.igexin.c.a.c.a.a(l, e2.toString());
            }
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        b bVar = new b(outputStream, i2);
        a(inputStream, bVar);
        bVar.a();
    }

    public static byte[] a(int i2) {
        int i3;
        int i4 = 0;
        int i5 = 0;
        do {
            i3 = 24;
            i4 |= (i2 & 127) << 24;
            i2 >>>= 7;
            i5++;
            if (i2 > 0) {
                i4 = (i4 >>> 8) | Integer.MIN_VALUE;
            }
        } while (i2 > 0);
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = (byte) (i4 >>> i3);
            i3 -= 8;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                try {
                    com.igexin.c.a.c.a.a(th);
                } finally {
                    a(gZIPOutputStream);
                    a(byteArrayOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
        return byteArray;
    }

    public static String[] a(String str) {
        StringBuilder sb = new StringBuilder(str.toLowerCase());
        String[] strArr = new String[6];
        for (int i2 = 0; i2 < 6; i2++) {
            strArr[i2] = "";
        }
        int iIndexOf = str.indexOf(u15.f19942b);
        if (iIndexOf > 0) {
            strArr[0] = str.substring(0, iIndexOf);
            sb.delete(0, iIndexOf + 1);
        } else if (iIndexOf == 0) {
            throw new IllegalArgumentException("url format error - protocol");
        }
        if (sb.length() >= 2 && sb.charAt(0) == '/' && sb.charAt(1) == '/') {
            sb.delete(0, 2);
            int iIndexOf2 = sb.toString().indexOf(47);
            if (iIndexOf2 < 0) {
                iIndexOf2 = sb.length();
            }
            if (iIndexOf2 != 0) {
                int iLastIndexOf = sb.toString().lastIndexOf(58);
                if (iLastIndexOf < 0) {
                    iLastIndexOf = iIndexOf2;
                } else {
                    if (iLastIndexOf > iIndexOf2) {
                        throw new IllegalArgumentException("url format error - port");
                    }
                    strArr[2] = sb.toString().substring(iLastIndexOf + 1, iIndexOf2);
                }
                strArr[1] = sb.toString().substring(0, iLastIndexOf);
                sb.delete(0, iIndexOf2);
            }
        }
        if (sb.length() > 0) {
            String string = sb.toString();
            int iLastIndexOf2 = string.lastIndexOf(47);
            if (iLastIndexOf2 > 0) {
                strArr[3] = string.substring(0, iLastIndexOf2);
            } else if (iLastIndexOf2 == 0) {
                if (string.indexOf(63) > 0) {
                    throw new IllegalArgumentException("url format error - path");
                }
                strArr[3] = string;
                return strArr;
            }
            if (iLastIndexOf2 < string.length() - 1) {
                String strSubstring = string.substring(iLastIndexOf2 + 1);
                int iIndexOf3 = strSubstring.indexOf(63);
                if (iIndexOf3 >= 0) {
                    strArr[4] = strSubstring.substring(0, iIndexOf3);
                    strArr[5] = strSubstring.substring(iIndexOf3 + 1);
                } else {
                    strArr[4] = strSubstring;
                }
            }
        } else {
            strArr[3] = WVNativeCallbackUtil.SEPERATER;
        }
        return strArr;
    }

    public static int b(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        return 2;
    }

    public static int b(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    private static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        a(new a(inputStream), outputStream);
    }

    public static byte[] b(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byte[] byteArray = null;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int i2 = gZIPInputStream.read();
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(i2);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.igexin.c.a.c.a.a(th);
                        } finally {
                            a(byteArrayOutputStream);
                            a(gZIPInputStream);
                            a(byteArrayInputStream);
                        }
                    }
                }
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        return byteArray;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        return 1;
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static byte[] c(byte[] bArr) throws RuntimeException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b bVar = new b(byteArrayOutputStream, 0);
            a(byteArrayInputStream, bVar);
            bVar.a();
            a(byteArrayInputStream);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                throw new RuntimeException("Unexpected I/O error", th);
            } catch (Throwable th2) {
                a(byteArrayInputStream);
                a(byteArrayOutputStream);
                throw th2;
            }
        }
    }

    public static long d(byte[] bArr, int i2) {
        return (((long) bArr[i2 + 7]) & 255) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2 + 2]) & 255) << 40) | ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8);
    }

    private static byte[] d(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i2 = gZIPInputStream.read(bArr2);
            if (i2 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, i2);
        }
    }

    private static int e(byte[] bArr, int i2) {
        return bArr[i2] & 255;
    }

    private static byte[] e(byte[] bArr) throws RuntimeException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(new a(byteArrayInputStream), byteArrayOutputStream);
            a(byteArrayInputStream);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                throw new RuntimeException("Unexpected I/O error", th);
            } catch (Throwable th2) {
                a(byteArrayInputStream);
                a(byteArrayOutputStream);
                throw th2;
            }
        }
    }
}
