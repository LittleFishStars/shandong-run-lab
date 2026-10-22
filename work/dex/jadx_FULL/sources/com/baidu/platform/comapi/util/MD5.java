package com.baidu.platform.comapi.util;

import com.google.common.base.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class MD5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final char[] f26793a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    public static String getFileMD5String(File file) throws IOException {
        return getFileMD5String(file, 131072);
    }

    public static String getFileMD5StringNIO(File file) throws IOException {
        return getFileMD5StringNIO(file, 131072);
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    public static String getMD5String16(String str) {
        String mD5String = getMD5String(str.getBytes());
        if (mD5String.length() == 32) {
            return mD5String.substring(8, 24);
        }
        return null;
    }

    public static String getSignMD5String(String str) {
        return URLEncodeUtils.generateSign(1, str);
    }

    public static String getWebSignMD5String(String str) {
        return URLEncodeUtils.generateSign(2, str);
    }

    public static String signOpra(String str) {
        return URLEncodeUtils.generateSign(3, str);
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    public static String getFileMD5String(File file, int i) throws IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i];
        while (true) {
            int i2 = fileInputStream.read(bArr);
            if (i2 <= 0) {
                fileInputStream.close();
                try {
                    return a(messageDigest.digest());
                } catch (Exception e) {
                    throw new IOException(e.toString());
                }
            }
            messageDigest.update(bArr, 0, i2);
        }
    }

    public static String getFileMD5StringNIO(File file, int i) throws IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        for (int i2 = channel.read(byteBufferAllocate); i2 != -1; i2 = channel.read(byteBufferAllocate)) {
            byteBufferAllocate.flip();
            messageDigest.update(byteBufferAllocate);
            if (!byteBufferAllocate.hasRemaining()) {
                byteBufferAllocate.clear();
            }
        }
        fileInputStream.close();
        try {
            return a(messageDigest.digest());
        } catch (Exception e) {
            throw new IOException(e.toString());
        }
    }

    public static String getMD5String(byte[] bArr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        messageDigest.update(bArr);
        try {
            return a(messageDigest.digest());
        } catch (Exception unused2) {
            return "";
        }
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char[] cArr = f26793a;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & a.q];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
