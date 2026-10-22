package com.igexin.push.d.c;

import com.zj.adlib.ws8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class c extends com.igexin.c.a.d.b {
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 25;
    public static final int s = 26;
    public static final int t = 27;
    public static final int u = 16;
    public static final int v = 17;
    public static final int w = 33;
    public static final int x = 192;
    public int m;
    public byte n;
    public byte o = 11;

    public static int a(String str) {
        if (str.equals("UTF-8")) {
            return 1;
        }
        if (str.equals("UTF-16")) {
            return 2;
        }
        if (str.equals("UTF-16BE")) {
            return 16;
        }
        if (str.equals("UTF-16LE")) {
            return 17;
        }
        if (str.equals("GBK")) {
            return 25;
        }
        if (str.equals(ws8.b)) {
            return 26;
        }
        if (str.equals("GB18030")) {
            return 27;
        }
        return str.equals("ISO-8859-1") ? 33 : 1;
    }

    public static String a(byte b) {
        int i = b & 63;
        if (i == 1) {
            return "UTF-8";
        }
        if (i == 2) {
            return "UTF-16";
        }
        if (i == 16) {
            return "UTF-16BE";
        }
        if (i == 17) {
            return "UTF-16LE";
        }
        if (i == 33) {
            return "ISO-8859-1";
        }
        switch (i) {
            case 25:
                return "GBK";
            case 26:
                return ws8.b;
            case 27:
                return "GB18030";
            default:
                return "UTF-8";
        }
    }

    @Override // com.igexin.c.a.d.a.a
    public void a() {
    }

    public abstract void a(byte[] bArr);

    public abstract byte[] b();

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return this.m;
    }
}
