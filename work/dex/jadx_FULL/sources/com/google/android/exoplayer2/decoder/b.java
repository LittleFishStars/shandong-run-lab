package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b extends DecoderOutputBuffer {
    public static final int R = 0;
    public static final int S = 1;
    public static final int T = 2;
    public static final int U = 3;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public d f30582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DecoderOutputBuffer.Owner<b> f2604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ByteBuffer f2605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public int[] f2606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ByteBuffer[] f2607a;

    @Nullable
    public ByteBuffer b;

    public b(DecoderOutputBuffer.Owner<b> owner) {
        this.f2604a = owner;
    }

    public static boolean n(int i, int i2) {
        return i >= 0 && i2 >= 0 && (i2 <= 0 || i < Integer.MAX_VALUE / i2);
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderOutputBuffer
    public void j() {
        this.f2604a.a(this);
    }

    public void k(long j, int i, @Nullable ByteBuffer byteBuffer) {
        ((DecoderOutputBuffer) this).f30577a = j;
        this.N = i;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            this.b = null;
            return;
        }
        a(268435456);
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = this.b;
        if (byteBuffer2 == null || byteBuffer2.capacity() < iLimit) {
            this.b = ByteBuffer.allocate(iLimit);
        } else {
            this.b.clear();
        }
        this.b.put(byteBuffer);
        this.b.flip();
        byteBuffer.position(0);
    }

    public void l(int i, int i2) {
        this.O = i;
        this.P = i2;
    }

    public boolean m(int i, int i2, int i3, int i4, int i5) {
        this.O = i;
        this.P = i2;
        this.Q = i5;
        int i6 = (int) ((((long) i2) + 1) / 2);
        if (n(i3, i2) && n(i4, i6)) {
            int i7 = i2 * i3;
            int i8 = i6 * i4;
            int i9 = (i8 * 2) + i7;
            if (n(i8, 2) && i9 >= i7) {
                ByteBuffer byteBuffer = this.f2605a;
                if (byteBuffer == null || byteBuffer.capacity() < i9) {
                    this.f2605a = ByteBuffer.allocateDirect(i9);
                } else {
                    this.f2605a.position(0);
                    this.f2605a.limit(i9);
                }
                if (this.f2607a == null) {
                    this.f2607a = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.f2605a;
                ByteBuffer[] byteBufferArr = this.f2607a;
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferArr[0] = byteBufferSlice;
                byteBufferSlice.limit(i7);
                byteBuffer2.position(i7);
                ByteBuffer byteBufferSlice2 = byteBuffer2.slice();
                byteBufferArr[1] = byteBufferSlice2;
                byteBufferSlice2.limit(i8);
                byteBuffer2.position(i7 + i8);
                ByteBuffer byteBufferSlice3 = byteBuffer2.slice();
                byteBufferArr[2] = byteBufferSlice3;
                byteBufferSlice3.limit(i8);
                if (this.f2606a == null) {
                    this.f2606a = new int[3];
                }
                int[] iArr = this.f2606a;
                iArr[0] = i3;
                iArr[1] = i4;
                iArr[2] = i4;
                return true;
            }
        }
        return false;
    }
}
