package com.zj.adlib;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b57 {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40679a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ErrorCorrectionLevel f15444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Mode f15445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lm9 f15446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r51 f15447a;

    public static boolean f(int i) {
        return i >= 0 && i < 8;
    }

    public ErrorCorrectionLevel a() {
        return this.f15444a;
    }

    public int b() {
        return this.f40679a;
    }

    public r51 c() {
        return this.f15447a;
    }

    public Mode d() {
        return this.f15445a;
    }

    public lm9 e() {
        return this.f15446a;
    }

    public void g(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f15444a = errorCorrectionLevel;
    }

    public void h(int i) {
        this.f40679a = i;
    }

    public void i(r51 r51Var) {
        this.f15447a = r51Var;
    }

    public void j(Mode mode) {
        this.f15445a = mode;
    }

    public void k(lm9 lm9Var) {
        this.f15446a = lm9Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f15445a);
        sb.append("\n ecLevel: ");
        sb.append(this.f15444a);
        sb.append("\n version: ");
        sb.append(this.f15446a);
        sb.append("\n maskPattern: ");
        sb.append(this.f40679a);
        if (this.f15447a == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f15447a);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
