package com.kc.cw.ad.a;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38661a;
    private int b;
    private long c;
    private long d;
    private long e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private boolean k;
    private List<c.i> l;
    private String m;
    private String n;

    public String a() {
        return this.f;
    }

    public void a(int i) {
        this.f38661a = i;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(List<c.i> list) {
        this.l = list;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public String b() {
        return this.g;
    }

    public void b(int i) {
        this.b = i;
    }

    public void b(long j) {
        this.d = j;
    }

    public void b(String str) {
        this.g = str;
    }

    public String c() {
        return this.i;
    }

    public void c(long j) {
        this.e = j;
    }

    public void c(String str) {
        this.h = str;
    }

    public String d() {
        return this.j;
    }

    public void d(String str) {
        this.i = str;
    }

    public void e(String str) {
        this.j = str;
    }

    public boolean e() {
        return this.k;
    }

    public int f() {
        return this.f38661a;
    }

    public void f(String str) {
        this.m = str;
    }

    public int g() {
        return this.b;
    }

    public void g(String str) {
        this.n = str;
    }

    public long h() {
        return this.e;
    }

    public List<c.i> i() {
        return this.l;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.c < this.d;
    }

    public String k() {
        return this.m;
    }

    public String l() {
        return this.n;
    }
}
