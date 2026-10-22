package com.kuaishou.weapon.p0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class i {
    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = a(bytes[i2], bytes[i2 + 1]);
        }
        return bArr;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            stringBuffer.append((char) b);
        }
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            String hexString = Integer.toHexString(str.charAt(i) & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] bArrA = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte b = bArrA[i];
            i2 = ((b & 255) + i2) & 255;
            bArrA[i] = bArrA[i2];
            bArrA[i2] = b;
            bArr2[i3] = (byte) (bArrA[((bArrA[i] & 255) + (b & 255)) & 255] ^ bArr[i3]);
        }
        return bArr2;
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr[i] = (byte) i;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int length = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = bytes[length] & 255;
            byte b = bArr[i3];
            i2 = (i4 + (b & 255) + i2) & 255;
            bArr[i3] = bArr[i2];
            bArr[i2] = b;
            length = (length + 1) % bytes.length;
        }
        return bArr;
    }

    private static byte a(byte b, byte b2) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()));
    }
}
