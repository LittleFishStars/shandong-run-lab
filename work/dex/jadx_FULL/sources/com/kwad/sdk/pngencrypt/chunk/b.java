package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    public static final byte[] blv = hp("IHDR");
    public static final byte[] blw = hp("PLTE");
    public static final byte[] blx = hp("IDAT");
    public static final byte[] bly = hp("IEND");
    private static byte[] blz = new byte[4096];
    public static Pattern blA = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, int i, int i2, boolean z) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream3;
        InflaterInputStream inflaterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                InflaterInputStream inflaterInputStream2 = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        g(inflaterInputStream2, byteArrayOutputStream2);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        return byteArray;
                    } catch (Exception unused) {
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream3);
                        return new byte[0];
                    } catch (Throwable th) {
                        th = th;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    byteArrayOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception unused3) {
                byteArrayOutputStream3 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception unused4) {
            byteArrayOutputStream3 = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
    }

    public static String c(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.bld);
    }

    public static String d(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.ble);
    }

    private static void g(InputStream inputStream, OutputStream outputStream) {
        synchronized (blz) {
            while (true) {
                int i = inputStream.read(blz);
                if (i > 0) {
                    outputStream.write(blz, 0, i);
                }
            }
        }
    }

    public static byte[] hp(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.bld);
    }

    public static boolean hq(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean hr(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean hs(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static String i(byte[] bArr, int i) {
        return (bArr == null || bArr.length < 8) ? "?" : c(bArr, 4, 4);
    }

    public static String m(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.bld);
    }

    public static String n(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.ble);
    }
}
