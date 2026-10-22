package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class bz2 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f15659a;
    public final String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String[] f15660b;
    public final String[] c;

    public bz2(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.c(this.f15659a, sb);
        ParsedResult.c(this.f15660b, sb);
        ParsedResult.c(this.c, sb);
        ParsedResult.b(this.f40866a, sb);
        ParsedResult.b(this.b, sb);
        return sb.toString();
    }

    public String[] d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public String[] f() {
        return this.f15660b;
    }

    @Deprecated
    public String g() {
        String[] strArr = this.f15659a;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String h() {
        return "mailto:";
    }

    public String i() {
        return this.f40866a;
    }

    public String[] j() {
        return this.f15659a;
    }

    public bz2(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.f15659a = strArr;
        this.f15660b = strArr2;
        this.c = strArr3;
        this.f40866a = str;
        this.b = str2;
    }
}
