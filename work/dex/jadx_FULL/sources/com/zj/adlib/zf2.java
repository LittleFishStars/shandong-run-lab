package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zf2 implements ExtractorInput {
    public static final int c = 65536;
    public static final int d = 524288;
    public static final int e = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f21044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataReader f21045a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f21047b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte[] f21048b = new byte[65536];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f21046a = new byte[4096];

    static {
        ab3.a("goog.exo.extractor");
    }

    public zf2(DataReader dataReader, long j, long j2) {
        this.f21045a = dataReader;
        this.f21047b = j;
        this.f21044a = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i, boolean z) throws IOException {
        g(i);
        int i2 = this.b - this.f46252a;
        while (i2 < i) {
            i2 = i(this.f21048b, this.f46252a, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.b = this.f46252a + i2;
        }
        this.f46252a += i;
        return true;
    }

    public final void d(int i) {
        if (i != -1) {
            this.f21047b += (long) i;
        }
    }

    public final void g(int i) {
        int i2 = this.f46252a + i;
        byte[] bArr = this.f21048b;
        if (i2 > bArr.length) {
            this.f21048b = Arrays.copyOf(this.f21048b, gj9.s(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.f21044a;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.f21047b + ((long) this.f46252a);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.f21047b;
    }

    public final int h(byte[] bArr, int i, int i2) {
        int i3 = this.b;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.f21048b, 0, bArr, i, iMin);
        k(iMin);
        return iMin;
    }

    public final int i(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i4 = this.f21045a.read(bArr, i + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    public final int j(int i) {
        int iMin = Math.min(this.b, i);
        k(iMin);
        return iMin;
    }

    public final void k(int i) {
        int i2 = this.b - i;
        this.b = i2;
        this.f46252a = 0;
        byte[] bArr = this.f21048b;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.f21048b = bArr2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int peek(byte[] bArr, int i, int i2) throws IOException {
        int iMin;
        g(i2);
        int i3 = this.b;
        int i4 = this.f46252a;
        int i5 = i3 - i4;
        if (i5 == 0) {
            iMin = i(this.f21048b, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.b += iMin;
        } else {
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(this.f21048b, this.f46252a, bArr, i, iMin);
        this.f46252a += iMin;
        return iMin;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        System.arraycopy(this.f21048b, this.f46252a - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iH = h(bArr, i, i2);
        if (iH == 0) {
            iH = i(bArr, i, i2, 0, true);
        }
        d(iH);
        return iH;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int iH = h(bArr, i, i2);
        while (iH < i2 && iH != -1) {
            iH = i(bArr, i, i2, iH, z);
        }
        d(iH);
        return iH != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.f46252a = 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Throwable */
    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e2) throws Throwable {
        sb0.a(j >= 0);
        this.f21047b = j;
        throw e2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i) throws IOException {
        int iJ = j(i);
        if (iJ == 0) {
            byte[] bArr = this.f21046a;
            iJ = i(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        d(iJ);
        return iJ;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) throws IOException {
        int iJ = j(i);
        while (iJ < i && iJ != -1) {
            iJ = i(this.f21046a, -iJ, Math.min(i, this.f21046a.length + iJ), iJ, z);
        }
        d(iJ);
        return iJ != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) throws IOException {
        peekFully(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        readFully(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i) throws IOException {
        skipFully(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i) throws IOException {
        advancePeekPosition(i, false);
    }
}
