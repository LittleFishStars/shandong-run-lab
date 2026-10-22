package com.alipay.apmobilesecuritysdk.b;

import com.alipay.sdk.m.i0.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25339a = 0;

    public static a a() {
        return b;
    }

    private String a(String str, String str2) {
        return str + str2;
    }

    public void a(int i) {
        this.f25339a = i;
    }

    public int b() {
        return this.f25339a;
    }

    public String c() {
        String str;
        String strA = d.a();
        if (com.alipay.sdk.m.d0.a.b(strA)) {
            return strA;
        }
        int i = this.f25339a;
        if (i == 1) {
            str = "://mobilegw.stable.alipay.net/mgw.htm";
        } else {
            if (i == 2) {
                return "https://mobilegwpre.alipay.com/mgw.htm";
            }
            if (i == 3) {
                str = "://mobilegw-1-64.test.alipay.net/mgw.htm";
            } else {
                if (i != 4) {
                    return "https://mobilegw.alipay.com/mgw.htm";
                }
                str = "://mobilegw.aaa.alipay.net/mgw.htm";
            }
        }
        return a("http", str);
    }
}
