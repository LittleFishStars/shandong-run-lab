package com.alibaba.ariver.commonability.file.fs.a.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a {
    public static String a(byte b) {
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() >= 2) {
            return hexString;
        }
        return "0" + hexString;
    }

    public static byte b(String str) {
        try {
            return (byte) Integer.parseInt(str, 16);
        } catch (Exception unused) {
            return (byte) 0;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 == 1) {
            length++;
            bArr = new byte[length / 2];
            str = "0" + str;
        } else {
            bArr = new byte[length / 2];
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 2;
            bArr[i2] = b(str.substring(i, i3));
            i2++;
            i = i3;
        }
        return bArr;
    }
}
