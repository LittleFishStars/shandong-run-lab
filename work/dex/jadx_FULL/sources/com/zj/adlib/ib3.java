package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ib3 extends ParsedResult {
    public static final String o = "KG";
    public static final String p = "LB";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, String> f17177a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public ib3(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.f42318a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.f17177a = map;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        return String.valueOf(this.f42318a);
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ib3)) {
            return false;
        }
        ib3 ib3Var = (ib3) obj;
        return Objects.equals(this.b, ib3Var.b) && Objects.equals(this.c, ib3Var.c) && Objects.equals(this.d, ib3Var.d) && Objects.equals(this.e, ib3Var.e) && Objects.equals(this.g, ib3Var.g) && Objects.equals(this.h, ib3Var.h) && Objects.equals(this.i, ib3Var.i) && Objects.equals(this.j, ib3Var.j) && Objects.equals(this.k, ib3Var.k) && Objects.equals(this.l, ib3Var.l) && Objects.equals(this.m, ib3Var.m) && Objects.equals(this.n, ib3Var.n) && Objects.equals(this.f17177a, ib3Var.f17177a);
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.l;
    }

    public int hashCode() {
        return (((((((((((Objects.hashCode(this.b) ^ Objects.hashCode(this.c)) ^ Objects.hashCode(this.d)) ^ Objects.hashCode(this.e)) ^ Objects.hashCode(this.g)) ^ Objects.hashCode(this.h)) ^ Objects.hashCode(this.i)) ^ Objects.hashCode(this.j)) ^ Objects.hashCode(this.k)) ^ Objects.hashCode(this.l)) ^ Objects.hashCode(this.m)) ^ Objects.hashCode(this.n)) ^ Objects.hashCode(this.f17177a);
    }

    public String i() {
        return this.n;
    }

    public String j() {
        return this.m;
    }

    public String k() {
        return this.b;
    }

    public String l() {
        return this.e;
    }

    public String m() {
        return this.f42318a;
    }

    public String n() {
        return this.c;
    }

    public Map<String, String> o() {
        return this.f17177a;
    }

    public String p() {
        return this.i;
    }

    public String q() {
        return this.k;
    }

    public String r() {
        return this.j;
    }
}
