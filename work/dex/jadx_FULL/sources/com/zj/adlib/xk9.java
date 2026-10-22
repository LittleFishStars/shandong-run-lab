package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class xk9 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f45842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f20675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20676a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public xk9(String str, String str2, String str3, String str4, String str5, String str6, int i, char c, String str7) {
        super(ParsedResultType.VIN);
        this.f20676a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.f20675a = i;
        this.f45842a = c;
        this.g = str7;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.c);
        sb.append(' ');
        sb.append(this.d);
        sb.append('\n');
        String str = this.e;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f20675a);
        sb.append(' ');
        sb.append(this.f45842a);
        sb.append(' ');
        sb.append(this.g);
        sb.append('\n');
        return sb.toString();
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.f20675a;
    }

    public char f() {
        return this.f45842a;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.f20676a;
    }

    public String i() {
        return this.f;
    }

    public String j() {
        return this.c;
    }

    public String k() {
        return this.d;
    }

    public String l() {
        return this.b;
    }
}
