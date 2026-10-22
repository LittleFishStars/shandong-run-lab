package com.beizi.fusion;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class kl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27477a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;

    private boolean n() {
        int i = this.e;
        if (i == 2) {
            return !TextUtils.isEmpty(this.m) && this.m.startsWith("http");
        }
        return i == 5 && !TextUtils.isEmpty(this.m) && this.m.contains("market://");
    }

    private boolean o() {
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.h) || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.l)) {
            return false;
        }
        if (TextUtils.isEmpty(this.i) && TextUtils.isEmpty(this.j)) {
            return false;
        }
        int i = this.e;
        return i == 2 || i == 5;
    }

    public void a(int i) {
        this.e = i;
    }

    public String b() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public String f() {
        return this.h;
    }

    public void g(String str) {
        this.h = str;
    }

    public String h() {
        return this.f27477a;
    }

    public String i() {
        return this.d;
    }

    public void j(String str) {
        this.f27477a = str;
    }

    public String k() {
        return this.c;
    }

    public String l() {
        return this.b;
    }

    public void m(String str) {
        this.b = str;
    }

    public String a() {
        return this.g;
    }

    public void b(String str) {
        this.m = str;
    }

    public String c() {
        return this.j;
    }

    public void d(String str) {
        this.j = str;
    }

    public String e() {
        return this.k;
    }

    public void f(String str) {
        this.k = str;
    }

    public String g() {
        return this.l;
    }

    public void h(String str) {
        this.l = str;
    }

    public void i(String str) {
        this.n = str;
    }

    public int j() {
        return this.e;
    }

    public void k(String str) {
        this.d = str;
    }

    public void l(String str) {
        this.c = str;
    }

    public boolean m() {
        return TextUtils.isEmpty(this.n) && o() && n();
    }

    public void a(String str) {
        this.g = str;
    }
}
