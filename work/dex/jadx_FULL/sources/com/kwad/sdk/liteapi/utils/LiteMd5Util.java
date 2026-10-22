package com.kwad.sdk.liteapi.utils;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.liteapi.LiteApiLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LiteMd5Util {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getFileMD5Digest(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            String hexString = toHexString(messageDigest.digest());
                            LiteCloseableUtil.closeQuietly(fileInputStream);
                            return hexString;
                        }
                        messageDigest.update(bArr, 0, i);
                        th = th;
                        fileInputStream2 = fileInputStream;
                        LiteCloseableUtil.closeQuietly(fileInputStream2);
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    LiteApiLogger.printStackTraceOnly(e);
                    LiteCloseableUtil.closeQuietly(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    public static String getPartOfFileMD5Digest(String str, long j, long j2) throws Throwable {
        RandomAccessFile randomAccessFile;
        int i;
        File file = new File(str);
        RandomAccessFile randomAccessFile2 = null;
        if (file.length() > 0) {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                if (j >= 0) {
                    try {
                        try {
                            if (j >= file.length()) {
                                j = 0;
                            }
                        } catch (Exception e) {
                            e = e;
                            LiteApiLogger.printStackTrace(e);
                            LiteCloseableUtil.closeQuietly(randomAccessFile);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile2 = randomAccessFile;
                        LiteCloseableUtil.closeQuietly(randomAccessFile2);
                        throw th;
                    }
                } else {
                    j = 0;
                }
                randomAccessFile.seek(j);
                byte[] bArr = new byte[4096];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                int i2 = 0;
                while (true) {
                    long j3 = i2;
                    if (j3 >= j2 || (i = randomAccessFile.read(bArr)) == -1) {
                        break;
                    }
                    if (i <= 0 || i2 + i <= j2) {
                        messageDigest.update(bArr, 0, i);
                        i2 += i;
                    } else {
                        int i3 = (int) (j2 - j3);
                        messageDigest.update(bArr, 0, i3);
                        i2 += i3;
                    }
                }
                String hexString = toHexString(messageDigest.digest());
                LiteCloseableUtil.closeQuietly(randomAccessFile);
                return hexString;
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                LiteCloseableUtil.closeQuietly(randomAccessFile2);
                throw th;
            }
        }
        return null;
    }

    @NonNull
    public static String md5(String str) {
        return TextUtils.isEmpty(str) ? "" : md5ForByte(str.getBytes());
    }

    public static String md5ForByte(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = bArrDigest.length;
            for (int i = 0; i < length; i++) {
                int i2 = bArrDigest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String sha1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            return toHexString(bArrDigest, 0, bArrDigest.length);
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
            return "";
        }
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String toHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static String getFileMD5Digest(String str) {
        return getFileMD5Digest(new File(str));
    }
}
