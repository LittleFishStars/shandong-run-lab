package com.czhj.wire.okio;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class Segment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f29549a = 8192;
    static final int b = 1024;
    final byte[] c;
    int d;
    int e;
    boolean f;
    boolean g;
    Segment h;
    Segment i;

    public Segment() {
        this.c = new byte[8192];
        this.g = true;
        this.f = false;
    }

    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.g = z2;
    }

    public final Segment a() {
        this.f = true;
        return new Segment(this.c, this.d, this.e, true, false);
    }

    public final Segment b() {
        return new Segment((byte[]) this.c.clone(), this.d, this.e, false, true);
    }

    public final void compact() {
        Segment segment = this.i;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.g) {
            int i = this.e - this.d;
            if (i > (8192 - segment.e) + (segment.f ? 0 : segment.d)) {
                return;
            }
            writeTo(segment, i);
            pop();
            SegmentPool.a(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.h;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.i;
        segment3.h = segment;
        this.h.i = segment3;
        this.h = null;
        this.i = null;
        return segment2;
    }

    public final Segment push(Segment segment) {
        segment.i = this;
        segment.h = this.h;
        this.h.i = segment;
        this.h = segment;
        return segment;
    }

    public final Segment split(int i) {
        Segment segmentA;
        if (i <= 0 || i > this.e - this.d) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            segmentA = a();
        } else {
            segmentA = SegmentPool.a();
            System.arraycopy(this.c, this.d, segmentA.c, 0, i);
        }
        segmentA.e = segmentA.d + i;
        this.d += i;
        this.i.push(segmentA);
        return segmentA;
    }

    public final void writeTo(Segment segment, int i) {
        if (!segment.g) {
            throw new IllegalArgumentException();
        }
        int i2 = segment.e;
        if (i2 + i > 8192) {
            if (segment.f) {
                throw new IllegalArgumentException();
            }
            int i3 = segment.d;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.c;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            segment.e -= segment.d;
            segment.d = 0;
        }
        System.arraycopy(this.c, this.d, segment.c, segment.e, i);
        segment.e += i;
        this.d += i;
    }
}
