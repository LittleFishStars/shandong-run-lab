package com.czhj.wire.okio;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class SegmentPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f29550a = 65536;
    static Segment b;
    static long c;

    private SegmentPool() {
    }

    public static Segment a() {
        synchronized (SegmentPool.class) {
            Segment segment = b;
            if (segment == null) {
                return new Segment();
            }
            b = segment.h;
            segment.h = null;
            c -= 8192;
            return segment;
        }
    }

    public static void a(Segment segment) {
        if (segment.h != null || segment.i != null) {
            throw new IllegalArgumentException();
        }
        if (segment.f) {
            return;
        }
        synchronized (SegmentPool.class) {
            long j = c;
            if (j + 8192 > 65536) {
                return;
            }
            c = j + 8192;
            segment.h = b;
            segment.e = 0;
            segment.d = 0;
            b = segment;
        }
    }
}
