package com.igexin.push.core.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k implements Comparable<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f37961a;
    public String b;
    public String c;
    public String d;
    public byte[] e;
    public byte[] f;
    public String g;
    public int h;
    public long i;
    private String j;
    private long k;
    private int l;
    private long m;
    private int n;
    private int o;

    public k(long j, String str, String str2, String str3, byte[] bArr, byte[] bArr2, String str4, int i, long j2) {
        this.f37961a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bArr;
        this.f = bArr2;
        this.g = str4;
        this.h = i;
        this.i = j2;
    }

    public k(byte[] bArr, String str, long j) {
        this.f = bArr;
        this.j = str;
        this.k = j;
    }

    private int a(k kVar) {
        return (int) (this.k - kVar.k);
    }

    private void a(int i) {
        this.h = i;
    }

    private void a(long j) {
        this.f37961a = j;
    }

    private void a(String str) {
        this.b = str;
    }

    private void a(byte[] bArr) {
        this.f = bArr;
    }

    private long b() {
        return this.f37961a;
    }

    private void b(int i) {
        this.l = i;
    }

    private void b(long j) {
        this.i = j;
    }

    private void b(String str) {
        this.c = str;
    }

    private void b(byte[] bArr) {
        this.e = bArr;
    }

    private String c() {
        return this.b;
    }

    private void c(int i) {
        this.n = i;
    }

    private void c(long j) {
        this.k = j;
    }

    private void c(String str) {
        this.d = str;
    }

    private String d() {
        return this.c;
    }

    private void d(int i) {
        this.o = i;
    }

    private void d(long j) {
        this.m = j;
    }

    private void d(String str) {
        this.g = str;
    }

    private String e() {
        return this.d;
    }

    private void e(String str) {
        this.j = str;
    }

    private String f() {
        return this.g;
    }

    private int g() {
        return this.h;
    }

    private long h() {
        return this.i;
    }

    private int i() {
        return this.l;
    }

    private long j() {
        return this.m;
    }

    private int k() {
        return this.n;
    }

    private int l() {
        return this.o;
    }

    private byte[] m() {
        return this.f;
    }

    private long n() {
        return this.k;
    }

    private String o() {
        return this.j;
    }

    private byte[] p() {
        return this.e;
    }

    public final JSONObject a() {
        try {
            return new JSONObject(this.j);
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(k kVar) {
        return (int) (this.k - kVar.k);
    }
}
