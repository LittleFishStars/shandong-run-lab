package com.zj.adlib;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class y51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45958a = "C2Mp3TimestampTracker";
    public static final long c = 529;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f20782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20783a;
    public long b;

    public final long a(long j) {
        return this.f20782a + Math.max(0L, ((this.b - 529) * 1000000) / j);
    }

    public long b(d dVar) {
        return a(dVar.V);
    }

    public void c() {
        this.f20782a = 0L;
        this.b = 0L;
        this.f20783a = false;
    }

    public long d(d dVar, DecoderInputBuffer decoderInputBuffer) {
        if (this.b == 0) {
            this.f20782a = decoderInputBuffer.f30576a;
        }
        if (this.f20783a) {
            return decoderInputBuffer.f30576a;
        }
        ByteBuffer byteBuffer = (ByteBuffer) sb0.g(decoderInputBuffer.f2588a);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int iM = hs5.m(i);
        if (iM != -1) {
            long jA = a(dVar.V);
            this.b += (long) iM;
            return jA;
        }
        this.f20783a = true;
        this.b = 0L;
        this.f20782a = decoderInputBuffer.f30576a;
        Log.n(f45958a, "MPEG audio header is invalid.");
        return decoderInputBuffer.f30576a;
    }
}
