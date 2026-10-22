package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class CurrentParsingState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32523a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public State f6770a = State.NUMERIC;

    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f32523a;
    }

    public void b(int i) {
        this.f32523a += i;
    }

    public boolean c() {
        return this.f6770a == State.ALPHA;
    }

    public boolean d() {
        return this.f6770a == State.ISO_IEC_646;
    }

    public boolean e() {
        return this.f6770a == State.NUMERIC;
    }

    public void f() {
        this.f6770a = State.ALPHA;
    }

    public void g() {
        this.f6770a = State.ISO_IEC_646;
    }

    public void h() {
        this.f6770a = State.NUMERIC;
    }

    public void i(int i) {
        this.f32523a = i;
    }
}
