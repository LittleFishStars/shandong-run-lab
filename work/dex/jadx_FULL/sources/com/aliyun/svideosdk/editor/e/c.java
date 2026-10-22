package com.aliyun.svideosdk.editor.e;

import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class c {
    private Source c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25714a = -1;
    private int b = 0;
    private int d = 2;
    private int e = 80;

    @Deprecated
    public String a() {
        Source source = this.c;
        if (source != null) {
            return source.getPath();
        }
        return null;
    }

    public void a(int i) {
        this.f25714a = i;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void a(Source source) {
        this.c = source;
    }

    public Source b() {
        return this.c;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.f25714a;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b;
    }

    public String toString() {
        return "RollCaptionStyle{mTextColor=" + this.f25714a + ", mTextStrokeColor=" + this.b + ", mFont='" + this.c + "', mTextSizeUnit=" + this.d + ", mTextSize=" + this.e + '}';
    }
}
