package com.google.android.exoplayer2.audio;

import com.google.common.primitives.Ints;
import com.zj.adlib.gj9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c implements DefaultAudioSink.AudioTrackBufferSizeProvider {
    public static final int g = 250000;
    public static final int h = 750000;
    public static final int i = 4;
    public static final int j = 250000;
    public static final int k = 50000000;
    public static final int l = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30561a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30562a = 250000;
        public int b = c.h;
        public int c = 4;
        public int d = 250000;
        public int e = c.k;
        public int f = 2;

        public c g() {
            return new c(this);
        }

        public a h(int i) {
            this.f = i;
            return this;
        }

        public a i(int i) {
            this.b = i;
            return this;
        }

        public a j(int i) {
            this.f30562a = i;
            return this;
        }

        public a k(int i) {
            this.e = i;
            return this;
        }

        public a l(int i) {
            this.d = i;
            return this;
        }

        public a m(int i) {
            this.c = i;
            return this;
        }
    }

    public c(a aVar) {
        this.f30561a = aVar.f30562a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public static int durationUsToBytes(int i2, int i3, int i4) {
        return Ints.d(((((long) i2) * ((long) i3)) * ((long) i4)) / 1000000);
    }

    public static int getMaximumEncodedRateBytesPerSecond(int i2) {
        switch (i2) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackBufferSizeProvider
    public int a(int i2, int i3, int i4, int i5, int i6, double d) {
        return (((Math.max(i2, (int) (((double) get1xBufferSizeInBytes(i2, i3, i4, i5, i6)) * d)) + i5) - 1) / i5) * i5;
    }

    public int get1xBufferSizeInBytes(int i2, int i3, int i4, int i5, int i6) {
        if (i4 == 0) {
            return getPcmBufferSizeInBytes(i2, i6, i5);
        }
        if (i4 == 1) {
            return getOffloadBufferSizeInBytes(i3);
        }
        if (i4 == 2) {
            return getPassthroughBufferSizeInBytes(i3);
        }
        throw new IllegalArgumentException();
    }

    public int getOffloadBufferSizeInBytes(int i2) {
        return Ints.d((((long) this.e) * ((long) getMaximumEncodedRateBytesPerSecond(i2))) / 1000000);
    }

    public int getPassthroughBufferSizeInBytes(int i2) {
        int i3 = this.d;
        if (i2 == 5) {
            i3 *= this.f;
        }
        return Ints.d((((long) i3) * ((long) getMaximumEncodedRateBytesPerSecond(i2))) / 1000000);
    }

    public int getPcmBufferSizeInBytes(int i2, int i3, int i4) {
        return gj9.s(i2 * this.c, durationUsToBytes(this.f30561a, i3, i4), durationUsToBytes(this.b, i3, i4));
    }
}
