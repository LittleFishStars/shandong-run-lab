package com.google.android.exoplayer2.extractor;

import com.zj.adlib.gj9;
import com.zj.adlib.x38;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f2734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f2735a;
    public final long[] b;
    public final long[] c;
    public final int d;

    public b(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f2734a = iArr;
        this.f2735a = jArr;
        this.b = jArr2;
        this.c = jArr3;
        int length = iArr.length;
        this.d = length;
        if (length > 0) {
            this.f30637a = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f30637a = 0L;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        int iB = b(j);
        x38 x38Var = new x38(this.c[iB], this.f2735a[iB]);
        if (x38Var.f20602a >= j || iB == this.d - 1) {
            return new SeekMap.a(x38Var);
        }
        int i = iB + 1;
        return new SeekMap.a(x38Var, new x38(this.c[i], this.f2735a[i]));
    }

    public int b(long j) {
        return gj9.j(this.c, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f30637a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.d + ", sizes=" + Arrays.toString(this.f2734a) + ", offsets=" + Arrays.toString(this.f2735a) + ", timeUs=" + Arrays.toString(this.c) + ", durationsUs=" + Arrays.toString(this.b) + ")";
    }
}
