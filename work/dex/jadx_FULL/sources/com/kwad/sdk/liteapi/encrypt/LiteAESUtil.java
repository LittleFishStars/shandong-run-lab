package com.kwad.sdk.liteapi.encrypt;

import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.utils.LiteCloseableUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
final class LiteAESUtil {
    public static final int BUFFER = 1024;
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final boolean DEBUG = false;
    private static final String KEY_ALGORITHM = "AES";
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private LiteAESUtil() {
    }

    public static byte[] compress(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    compress(byteArrayInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    LiteCloseableUtil.closeQuietly(byteArrayOutputStream);
                    LiteCloseableUtil.closeQuietly(byteArrayInputStream);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    LiteCloseableUtil.closeQuietly(byteArrayOutputStream);
                    LiteCloseableUtil.closeQuietly(byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] decompress(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    decompress(byteArrayInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    LiteCloseableUtil.closeQuietly(byteArrayOutputStream);
                    LiteCloseableUtil.closeQuietly(byteArrayInputStream);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    LiteCloseableUtil.closeQuietly(byteArrayOutputStream);
                    LiteCloseableUtil.closeQuietly(byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        return transform(str.getBytes(UTF_8), bArr, 2);
    }

    public static byte[] encrypt(byte[] bArr, String str) {
        return encrypt(bArr, str.getBytes(UTF_8));
    }

    private static byte[] transform(byte[] bArr, byte[] bArr2, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(i, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return transform(bArr, bArr2, 2);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return transform(bArr, bArr2, 1);
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr, 0, 1024);
                    if (i != -1) {
                        gZIPOutputStream2.write(bArr, 0, i);
                    } else {
                        gZIPOutputStream2.finish();
                        gZIPOutputStream2.flush();
                        LiteCloseableUtil.closeQuietly(gZIPOutputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                LiteCloseableUtil.closeQuietly(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void decompress(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = gZIPInputStream2.read(bArr, 0, 1024);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        LiteCloseableUtil.closeQuietly(gZIPInputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                LiteCloseableUtil.closeQuietly(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
