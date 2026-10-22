package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18804a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    public void a(long j) {
        b(j, 1);
    }

    public final void b(long j, int i) {
        this.f18804a += j;
        this.k += i;
    }

    public synchronized void c() {
    }

    public void d(p82 p82Var) {
        this.f43924a += p82Var.f43924a;
        this.b += p82Var.b;
        this.c += p82Var.c;
        this.d += p82Var.d;
        this.e += p82Var.e;
        this.f += p82Var.f;
        this.g += p82Var.g;
        this.h += p82Var.h;
        this.i = Math.max(this.i, p82Var.i);
        this.j += p82Var.j;
        b(p82Var.f18804a, p82Var.k);
    }

    public String toString() {
        return gj9.H("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f43924a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), Long.valueOf(this.f18804a), Integer.valueOf(this.k));
    }
}
