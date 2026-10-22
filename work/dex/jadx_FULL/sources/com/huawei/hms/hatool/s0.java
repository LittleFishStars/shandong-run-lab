package com.huawei.hms.hatool;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f37585a;
    private boolean b;
    private String c;
    private String d;
    private String e;
    private String f;
    private j0 g;
    private String h;
    private Map<String, String> i;
    private String j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private long q;

    public s0() {
        this.e = "";
        this.f = "";
        this.g = new j0();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
    }

    public s0(s0 s0Var) {
        this.e = "";
        this.f = "";
        this.g = new j0();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
        this.g = s0Var.g;
        b(s0Var.f37585a);
        a(s0Var.c);
        b(s0Var.d);
        e(s0Var.e);
        g(s0Var.f);
        d(s0Var.h);
        f(s0Var.j);
        c(s0Var.b);
        a(s0Var.k);
        b(s0Var.l);
        d(s0Var.m);
        a(s0Var.n);
        e(s0Var.o);
        a(s0Var.i);
        c(s0Var.p);
        a(s0Var.q);
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(Map<String, String> map) {
        this.i = map;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.k;
    }

    public void b(int i) {
        this.l = i;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.f37585a = z;
    }

    public void c(String str) {
        this.p = str;
    }

    public void c(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.f37585a;
    }

    public int d() {
        return this.l;
    }

    public void d(String str) {
        this.h = str;
    }

    public void d(boolean z) {
        this.m = z;
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(boolean z) {
        this.o = z;
    }

    public boolean e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.f = str;
    }

    public boolean g() {
        return this.m;
    }

    public String h() {
        return this.d;
    }

    public boolean i() {
        return this.o;
    }

    public j0 j() {
        return this.g;
    }

    public Map<String, String> k() {
        return this.i;
    }

    public long l() {
        return this.q;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        return this.h;
    }

    public String o() {
        return this.e;
    }

    public String p() {
        return this.j;
    }

    public String q() {
        return this.f;
    }
}
