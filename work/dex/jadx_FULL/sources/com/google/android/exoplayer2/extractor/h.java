package com.google.android.exoplayer2.extractor;

import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f2779a;
    public final long[] b;

    public h(long[] jArr, long[] jArr2, long j) {
        sb0.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.f2778a = z;
        if (!z || jArr2[0] <= 0) {
            this.f2779a = jArr;
            this.b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.f2779a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f30651a = j;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        if (!this.f2778a) {
            return new SeekMap.a(x38.f45741a);
        }
        int iJ = gj9.j(this.b, j, true, true);
        x38 x38Var = new x38(this.b[iJ], this.f2779a[iJ]);
        if (x38Var.f20602a == j || iJ == this.b.length - 1) {
            return new SeekMap.a(x38Var);
        }
        int i = iJ + 1;
        return new SeekMap.a(x38Var, new x38(this.b[i], this.f2779a[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f30651a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.f2778a;
    }
}
