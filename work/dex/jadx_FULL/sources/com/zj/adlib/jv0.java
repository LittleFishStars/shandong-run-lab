package com.zj.adlib;

import com.google.zxing.Binarizer;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class jv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Binarizer f42678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public tv0 f17502a;

    public jv0(Binarizer binarizer) {
        if (binarizer == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f42678a = binarizer;
    }

    public jv0 a(int i, int i2, int i3, int i4) {
        return new jv0(this.f42678a.a(this.f42678a.e().a(i, i2, i3, i4)));
    }

    public tv0 b() throws NotFoundException {
        if (this.f17502a == null) {
            this.f17502a = this.f42678a.b();
        }
        return this.f17502a;
    }

    public qv0 c(int i, qv0 qv0Var) throws NotFoundException {
        return this.f42678a.c(i, qv0Var);
    }

    public int d() {
        return this.f42678a.d();
    }

    public int e() {
        return this.f42678a.f();
    }

    public boolean f() {
        return this.f42678a.e().g();
    }

    public boolean g() {
        return this.f42678a.e().h();
    }

    public jv0 h() {
        return new jv0(this.f42678a.a(this.f42678a.e().i()));
    }

    public jv0 i() {
        return new jv0(this.f42678a.a(this.f42678a.e().j()));
    }

    public String toString() {
        try {
            return b().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
