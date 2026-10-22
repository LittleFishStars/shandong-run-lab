package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ln implements we {
    private long b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final we.c f27523a = new we.c();

    @Override // com.beizi.fusion.we
    public void a(int i, float f, float f2, float f3, float f4, long j) {
        this.f27523a.a(i, new we.b(f, f2, f3, f4), j);
        this.b = System.currentTimeMillis();
    }

    @Override // com.beizi.fusion.we
    public long b() {
        return this.b;
    }

    @Override // com.beizi.fusion.we
    public we.c a() {
        return this.f27523a;
    }
}
