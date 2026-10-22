package com.zj.adlib;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p53 implements SampleStream {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f18773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s53 f18775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f18777a;
    public boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final n53 f18774a = new n53();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f43907a = -9223372036854775807L;

    public p53(s53 s53Var, d dVar, boolean z) {
        this.f18773a = dVar;
        this.f18775a = s53Var;
        this.f18777a = s53Var.f19517a;
        d(s53Var, z);
    }

    public String a() {
        return this.f18775a.a();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int i2 = this.K;
        boolean z = i2 == this.f18777a.length;
        if (z && !this.f18776a) {
            decoderInputBuffer.i(4);
            return -4;
        }
        if ((i & 2) != 0 || !this.b) {
            yk3Var.f46052a = this.f18773a;
            this.b = true;
            return -5;
        }
        if (z) {
            return -3;
        }
        if ((i & 1) == 0) {
            this.K = i2 + 1;
        }
        if ((i & 4) == 0) {
            byte[] bArrA = this.f18774a.a(this.f18775a.f19518a[i2]);
            decoderInputBuffer.k(bArrA.length);
            decoderInputBuffer.f2588a.put(bArrA);
        }
        decoderInputBuffer.f30576a = this.f18777a[i2];
        decoderInputBuffer.i(1);
        return -4;
    }

    public void c(long j) {
        int iF = gj9.f(this.f18777a, j, true, false);
        this.K = iF;
        if (!(this.f18776a && iF == this.f18777a.length)) {
            j = -9223372036854775807L;
        }
        this.f43907a = j;
    }

    public void d(s53 s53Var, boolean z) {
        int i = this.K;
        long j = i == 0 ? -9223372036854775807L : this.f18777a[i - 1];
        this.f18776a = z;
        this.f18775a = s53Var;
        long[] jArr = s53Var.f19517a;
        this.f18777a = jArr;
        long j2 = this.f43907a;
        if (j2 != -9223372036854775807L) {
            c(j2);
        } else if (j != -9223372036854775807L) {
            this.K = gj9.f(jArr, j, false, false);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        int iMax = Math.max(this.K, gj9.f(this.f18777a, j, true, false));
        int i = iMax - this.K;
        this.K = iMax;
        return i;
    }
}
