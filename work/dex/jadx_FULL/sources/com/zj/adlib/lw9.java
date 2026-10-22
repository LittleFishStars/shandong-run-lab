package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class lw9 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f43174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18099a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public lw9(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        ParsedResult.b(this.f43174a, sb);
        ParsedResult.b(this.b, sb);
        ParsedResult.b(this.c, sb);
        ParsedResult.b(Boolean.toString(this.f18099a), sb);
        return sb.toString();
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.b;
    }

    public String h() {
        return this.c;
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.f43174a;
    }

    public boolean k() {
        return this.f18099a;
    }

    public lw9(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, z, null, null, null, null);
    }

    public lw9(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        super(ParsedResultType.WIFI);
        this.f43174a = str2;
        this.b = str;
        this.c = str3;
        this.f18099a = z;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }
}
