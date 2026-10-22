package com.alipay.sdk.m.h0;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25440a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f25440a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public String toString() {
        StringBuilder sb;
        String strSubstring;
        StringBuilder sb2;
        String strSubstring2;
        StringBuilder sb3;
        String strSubstring3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f25440a);
        stringBuffer.append("," + this.b);
        stringBuffer.append("," + this.c);
        stringBuffer.append("," + this.d);
        if (com.alipay.sdk.m.d0.a.a(this.e) || this.e.length() < 20) {
            sb = new StringBuilder();
            sb.append(",");
            strSubstring = this.e;
        } else {
            sb = new StringBuilder();
            sb.append(",");
            strSubstring = this.e.substring(0, 20);
        }
        sb.append(strSubstring);
        stringBuffer.append(sb.toString());
        if (com.alipay.sdk.m.d0.a.a(this.f) || this.f.length() < 20) {
            sb2 = new StringBuilder();
            sb2.append(",");
            strSubstring2 = this.f;
        } else {
            sb2 = new StringBuilder();
            sb2.append(",");
            strSubstring2 = this.f.substring(0, 20);
        }
        sb2.append(strSubstring2);
        stringBuffer.append(sb2.toString());
        if (com.alipay.sdk.m.d0.a.a(this.g) || this.g.length() < 20) {
            sb3 = new StringBuilder();
            sb3.append(",");
            strSubstring3 = this.g;
        } else {
            sb3 = new StringBuilder();
            sb3.append(",");
            strSubstring3 = this.g.substring(0, 20);
        }
        sb3.append(strSubstring3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
