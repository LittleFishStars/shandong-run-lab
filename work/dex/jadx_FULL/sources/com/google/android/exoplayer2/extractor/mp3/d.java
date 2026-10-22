package com.google.android.exoplayer2.extractor.mp3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.hs5;
import com.zj.adlib.om6;
import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements Seeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30667a = "VbriSeeker";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f2934a;
    public final long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long[] f2935b;

    public d(long[] jArr, long[] jArr2, long j, long j2) {
        this.f2934a = jArr;
        this.f2935b = jArr2;
        this.f2933a = j;
        this.b = j2;
    }

    @Nullable
    public static d b(long j, long j2, hs5.a aVar, om6 om6Var) {
        int iG;
        om6Var.T(10);
        int iO = om6Var.o();
        if (iO <= 0) {
            return null;
        }
        int i = aVar.c;
        long jO1 = gj9.o1(iO, ((long) (i >= 32000 ? 1152 : hs5.f)) * 1000000, i);
        int iM = om6Var.M();
        int iM2 = om6Var.M();
        int iM3 = om6Var.M();
        om6Var.T(2);
        long j3 = j2 + ((long) aVar.b);
        long[] jArr = new long[iM];
        long[] jArr2 = new long[iM];
        int i2 = 0;
        long j4 = j2;
        while (i2 < iM) {
            int i3 = iM2;
            long j5 = j3;
            jArr[i2] = (((long) i2) * jO1) / ((long) iM);
            jArr2[i2] = Math.max(j4, j5);
            if (iM3 == 1) {
                iG = om6Var.G();
            } else if (iM3 == 2) {
                iG = om6Var.M();
            } else if (iM3 == 3) {
                iG = om6Var.J();
            } else {
                if (iM3 != 4) {
                    return null;
                }
                iG = om6Var.K();
            }
            j4 += ((long) iG) * ((long) i3);
            i2++;
            jArr = jArr;
            iM2 = i3;
            j3 = j5;
        }
        long[] jArr3 = jArr;
        if (j != -1 && j != j4) {
            Log.n(f30667a, "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new d(jArr3, jArr2, jO1, j4);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        int iJ = gj9.j(this.f2934a, j, true, true);
        x38 x38Var = new x38(this.f2934a[iJ], this.f2935b[iJ]);
        if (x38Var.f20602a >= j || iJ == this.f2934a.length - 1) {
            return new SeekMap.a(x38Var);
        }
        int i = iJ + 1;
        return new SeekMap.a(x38Var, new x38(this.f2934a[i], this.f2935b[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f2933a;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return this.f2934a[gj9.j(this.f2935b, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
