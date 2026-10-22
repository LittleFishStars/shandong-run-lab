package com.ipd.dsp.internal.q;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f38512a = new a();
    public static final q b = new b();
    public static final q c = new e();
    public static final q d = new c();
    public static final q e;
    public static final q f;
    public static final q g;
    public static final com.ipd.dsp.internal.f.h<q> h;
    public static final boolean i = true;

    public static class a extends q {
        @Override // com.ipd.dsp.internal.q.q
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // com.ipd.dsp.internal.q.q
        public float b(int i, int i2, int i3, int i4) {
            int iMin = Math.min(i2 / i4, i / i3);
            if (iMin == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(iMin);
        }
    }

    public static class b extends q {
        @Override // com.ipd.dsp.internal.q.q
        public g a(int i, int i2, int i3, int i4) {
            return g.MEMORY;
        }

        @Override // com.ipd.dsp.internal.q.q
        public float b(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int iMax = Math.max(1, Integer.highestOneBit(iCeil));
            return 1.0f / (iMax << (iMax >= iCeil ? 0 : 1));
        }
    }

    public static class c extends q {
        @Override // com.ipd.dsp.internal.q.q
        public g a(int i, int i2, int i3, int i4) {
            return b(i, i2, i3, i4) == 1.0f ? g.QUALITY : q.c.a(i, i2, i3, i4);
        }

        @Override // com.ipd.dsp.internal.q.q
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, q.c.b(i, i2, i3, i4));
        }
    }

    public static class d extends q {
        @Override // com.ipd.dsp.internal.q.q
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // com.ipd.dsp.internal.q.q
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    public static class e extends q {
        @Override // com.ipd.dsp.internal.q.q
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // com.ipd.dsp.internal.q.q
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }
    }

    public static class f extends q {
        @Override // com.ipd.dsp.internal.q.q
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // com.ipd.dsp.internal.q.q
        public float b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        e = dVar;
        f = new f();
        g = dVar;
        h = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract g a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
