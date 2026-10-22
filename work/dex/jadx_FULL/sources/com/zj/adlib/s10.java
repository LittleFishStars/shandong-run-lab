package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class s10 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f19487a;
    public final String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String[] f19488b;
    public final String c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String[] f19489c;
    public final String d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final String[] f19490d;
    public final String e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final String[] f19491e;
    public final String f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final String[] f19492f;
    public final String[] g;
    public final String[] h;
    public final String[] i;
    public final String[] j;

    public s10(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.c(this.f19487a, sb);
        ParsedResult.c(this.f19488b, sb);
        ParsedResult.b(this.f44582a, sb);
        ParsedResult.b(this.f, sb);
        ParsedResult.b(this.d, sb);
        ParsedResult.c(this.g, sb);
        ParsedResult.c(this.f19489c, sb);
        ParsedResult.c(this.f19491e, sb);
        ParsedResult.b(this.b, sb);
        ParsedResult.c(this.i, sb);
        ParsedResult.b(this.e, sb);
        ParsedResult.c(this.j, sb);
        ParsedResult.b(this.c, sb);
        return sb.toString();
    }

    public String[] d() {
        return this.h;
    }

    public String[] e() {
        return this.g;
    }

    public String f() {
        return this.e;
    }

    public String[] g() {
        return this.f19492f;
    }

    public String[] h() {
        return this.f19491e;
    }

    public String[] i() {
        return this.j;
    }

    public String j() {
        return this.b;
    }

    public String[] k() {
        return this.f19487a;
    }

    public String[] l() {
        return this.f19488b;
    }

    public String m() {
        return this.c;
    }

    public String n() {
        return this.d;
    }

    public String[] o() {
        return this.f19489c;
    }

    public String[] p() {
        return this.f19490d;
    }

    public String q() {
        return this.f44582a;
    }

    public String r() {
        return this.f;
    }

    public String[] s() {
        return this.i;
    }

    public s10(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        if (strArr3 != null && strArr4 != null && strArr3.length != strArr4.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        }
        if (strArr5 != null && strArr6 != null && strArr5.length != strArr6.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        }
        if (strArr7 != null && strArr8 != null && strArr7.length != strArr8.length) {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
        this.f19487a = strArr;
        this.f19488b = strArr2;
        this.f44582a = str;
        this.f19489c = strArr3;
        this.f19490d = strArr4;
        this.f19491e = strArr5;
        this.f19492f = strArr6;
        this.b = str2;
        this.c = str3;
        this.g = strArr7;
        this.h = strArr8;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.i = strArr9;
        this.j = strArr10;
    }
}
