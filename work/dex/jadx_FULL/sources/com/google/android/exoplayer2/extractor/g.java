package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.common.primitives.UnsignedBytes;
import com.zj.adlib.gj9;
import com.zj.adlib.nm6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30649a = "FlacStreamMetadata";
    public static final int j = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final a f2776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Metadata f2777a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f30650a;
        public final long[] b;

        public a(long[] jArr, long[] jArr2) {
            this.f30650a = jArr;
            this.b = jArr2;
        }
    }

    public g(byte[] bArr, int i) {
        nm6 nm6Var = new nm6(bArr);
        nm6Var.q(i * 8);
        this.f2774a = nm6Var.h(16);
        this.b = nm6Var.h(16);
        this.c = nm6Var.h(24);
        this.d = nm6Var.h(24);
        int iH = nm6Var.h(20);
        this.e = iH;
        this.f = m(iH);
        this.g = nm6Var.h(3) + 1;
        int iH2 = nm6Var.h(5) + 1;
        this.h = iH2;
        this.i = f(iH2);
        this.f2775a = nm6Var.j(36);
        this.f2776a = null;
        this.f2777a = null;
    }

    @Nullable
    public static Metadata a(List<String> list, List<PictureFrame> list2) {
        Metadata metadataC = j.c(list);
        if (metadataC == null && list2.isEmpty()) {
            return null;
        }
        return new Metadata(list2).copyWithAppendedEntriesFrom(metadataC);
    }

    public static int f(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int m(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case com.google.android.exoplayer2.video.spherical.a.h /* 32000 */:
                return 8;
            case com.google.android.exoplayer2.source.i.K /* 44100 */:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public g b(List<PictureFrame> list) {
        return new g(this.f2774a, this.b, this.c, this.d, this.e, this.g, this.h, this.f2775a, this.f2776a, k(new Metadata(list)));
    }

    public g c(@Nullable a aVar) {
        return new g(this.f2774a, this.b, this.c, this.d, this.e, this.g, this.h, this.f2775a, aVar, this.f2777a);
    }

    public g d(List<String> list) {
        return new g(this.f2774a, this.b, this.c, this.d, this.e, this.g, this.h, this.f2775a, this.f2776a, k(j.c(list)));
    }

    public long e() {
        long j2;
        long j3;
        int i = this.d;
        if (i > 0) {
            j2 = (((long) i) + ((long) this.c)) / 2;
            j3 = 1;
        } else {
            int i2 = this.f2774a;
            j2 = ((((i2 != this.b || i2 <= 0) ? 4096L : i2) * ((long) this.g)) * ((long) this.h)) / 8;
            j3 = 64;
        }
        return j2 + j3;
    }

    public int g() {
        return this.h * this.e * this.g;
    }

    public long h() {
        long j2 = this.f2775a;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / ((long) this.e);
    }

    public com.google.android.exoplayer2.d i(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = UnsignedBytes.f32243a;
        int i = this.d;
        if (i <= 0) {
            i = -1;
        }
        return new com.google.android.exoplayer2.d.b().e0("audio/flac").W(i).H(this.g).f0(this.e).T(Collections.singletonList(bArr)).X(k(metadata)).E();
    }

    public int j() {
        return this.b * this.g * (this.h / 8);
    }

    @Nullable
    public Metadata k(@Nullable Metadata metadata) {
        Metadata metadata2 = this.f2777a;
        return metadata2 == null ? metadata : metadata2.copyWithAppendedEntriesFrom(metadata);
    }

    public long l(long j2) {
        return gj9.t((j2 * ((long) this.e)) / 1000000, 0L, this.f2775a - 1);
    }

    public g(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j2, ArrayList<String> arrayList, ArrayList<PictureFrame> arrayList2) {
        this(i, i2, i3, i4, i5, i6, i7, j2, (a) null, a(arrayList, arrayList2));
    }

    public g(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j2, @Nullable a aVar, @Nullable Metadata metadata) {
        this.f2774a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = m(i5);
        this.g = i6;
        this.h = i7;
        this.i = f(i7);
        this.f2775a = j2;
        this.f2776a = aVar;
        this.f2777a = metadata;
    }
}
