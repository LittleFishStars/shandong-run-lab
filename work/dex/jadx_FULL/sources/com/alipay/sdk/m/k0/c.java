package com.alipay.sdk.m.k0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends a {
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final String o = "APPKEY_ERROR";
    public static final String p = "SUCCESS";
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k = "";

    public String a() {
        String str = this.f;
        return str == null ? "0" : str;
    }

    public boolean b() {
        return "1".equals(this.e);
    }

    public int c() {
        if (this.f25453a) {
            return com.alipay.sdk.m.d0.a.a(this.c) ? 2 : 1;
        }
        return o.equals(this.b) ? 3 : 2;
    }
}
