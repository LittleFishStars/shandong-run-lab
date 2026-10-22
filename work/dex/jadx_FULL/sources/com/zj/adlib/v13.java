package com.zj.adlib;

import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class v13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SymbolShapeHint f20156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dy8 f20157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public tn2 f20158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f20160a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public tn2 f20161b;
    public int c;

    public v13(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & 255);
            if (c == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.f20159a = sb.toString();
        this.f20156a = SymbolShapeHint.FORCE_NONE;
        this.f20160a = new StringBuilder(str.length());
        this.b = -1;
    }

    public int a() {
        return this.f20160a.length();
    }

    public StringBuilder b() {
        return this.f20160a;
    }

    public char c() {
        return this.f20159a.charAt(this.f45269a);
    }

    public char d() {
        return this.f20159a.charAt(this.f45269a);
    }

    public String e() {
        return this.f20159a;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return i() - this.f45269a;
    }

    public dy8 h() {
        return this.f20157a;
    }

    public final int i() {
        return this.f20159a.length() - this.c;
    }

    public boolean j() {
        return this.f45269a < i();
    }

    public void k() {
        this.b = -1;
    }

    public void l() {
        this.f20157a = null;
    }

    public void m(tn2 tn2Var, tn2 tn2Var2) {
        this.f20158a = tn2Var;
        this.f20161b = tn2Var2;
    }

    public void n(int i) {
        this.c = i;
    }

    public void o(SymbolShapeHint symbolShapeHint) {
        this.f20156a = symbolShapeHint;
    }

    public void p(int i) {
        this.b = i;
    }

    public void q() {
        r(a());
    }

    public void r(int i) {
        dy8 dy8Var = this.f20157a;
        if (dy8Var == null || i > dy8Var.b()) {
            this.f20157a = dy8.o(i, this.f20156a, this.f20158a, this.f20161b, true);
        }
    }

    public void s(char c) {
        this.f20160a.append(c);
    }

    public void t(String str) {
        this.f20160a.append(str);
    }
}
