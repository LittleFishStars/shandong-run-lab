package com.kc.cw.ad.a;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38695a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;

    public d(int i) {
        this.f38695a = i;
    }

    public d(int i, int i2, int i3, float f, float f2, float f3, int i4, int i5, int i6) {
        this.f38695a = i == 0 ? 2 : 5;
        this.j = String.valueOf(i2);
        this.k = String.valueOf(i3);
        this.l = a(f);
        this.m = a(f2);
        this.n = a(f3);
        this.o = String.valueOf(i4);
        this.p = String.valueOf(i5);
        this.q = String.valueOf(i6);
        this.i = String.valueOf(System.currentTimeMillis());
        this.h = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public int a() {
        return this.f38695a;
    }

    public String a(double d) {
        return String.format(Locale.US, "%.2f", Double.valueOf(d));
    }

    public void a(int i) {
        this.b = String.valueOf(i);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.r = String.valueOf(i);
        this.s = String.valueOf(i2);
        this.t = String.valueOf(i3);
        this.u = String.valueOf(i4);
    }

    public void a(String str) {
        this.d = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.c = String.valueOf(i);
    }

    public void b(String str) {
        this.g = str;
    }

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.e = String.valueOf(i);
    }

    public void c(String str) {
        this.h = str;
    }

    public String d() {
        return this.d;
    }

    public void d(int i) {
        this.f = String.valueOf(i);
    }

    public void d(String str) {
        this.i = str;
    }

    public String e() {
        return this.e;
    }

    public void e(int i) {
        this.j = String.valueOf(i);
    }

    public String f() {
        return this.f;
    }

    public void f(int i) {
        this.k = String.valueOf(i);
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.k;
    }

    public String l() {
        return this.l;
    }

    public String m() {
        return this.m;
    }

    public String n() {
        return this.n;
    }

    public String o() {
        return this.o;
    }

    public String p() {
        return this.p;
    }

    public String q() {
        return this.q;
    }

    public String r() {
        return this.r;
    }

    public String s() {
        return this.s;
    }

    public String t() {
        return this.t;
    }

    public String u() {
        return this.u;
    }
}
