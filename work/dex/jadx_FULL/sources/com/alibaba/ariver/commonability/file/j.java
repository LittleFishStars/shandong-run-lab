package com.alibaba.ariver.commonability.file;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24026a = "UTF-8";
    public static final Charset b = Charset.forName("UTF-8");
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final Charset e;

    public j() {
        this.e = b;
    }

    public static byte[] a(char[] cArr) throws Exception {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new Exception("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int iA = a(cArr[i], i) << 4;
            int i3 = i + 1;
            int iA2 = iA | a(cArr[i3], i3);
            i = i3 + 1;
            bArr[i2] = (byte) (iA2 & 255);
            i2++;
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }

    public byte[] c(byte[] bArr) {
        return a(new String(bArr, b()).toCharArray());
    }

    public byte[] d(byte[] bArr) {
        return b(bArr).getBytes(b());
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.e + "]";
    }

    public Object b(Object obj) throws Exception {
        try {
            return a(obj instanceof String ? ((String) obj).getBytes(b()) : (byte[]) obj);
        } catch (ClassCastException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public j(Charset charset) {
        this.e = charset;
    }

    public j(String str) {
        this(Charset.forName(str));
    }

    public String b() {
        return this.e.name();
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, true);
    }

    public static char[] a(byte[] bArr, boolean z) {
        return a(bArr, z ? c : d);
    }

    public static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & com.google.common.base.a.q];
        }
        return cArr2;
    }

    public static int a(char c2, int i) throws Exception {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new Exception("Illegal hexadecimal character " + c2 + " at index " + i);
    }

    public Object a(Object obj) throws Exception {
        try {
            return a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public Charset a() {
        return this.e;
    }
}
