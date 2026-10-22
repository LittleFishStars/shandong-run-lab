package com.google.android.exoplayer2.extractor;

import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g f2738a;

    public f(g gVar, long j) {
        this.f2738a = gVar;
        this.f30642a = j;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        sb0.k(this.f2738a.f2776a);
        g gVar = this.f2738a;
        g.a aVar = gVar.f2776a;
        long[] jArr = aVar.f30650a;
        long[] jArr2 = aVar.b;
        int iJ = gj9.j(jArr, gVar.l(j), true, false);
        x38 x38VarB = b(iJ == -1 ? 0L : jArr[iJ], iJ != -1 ? jArr2[iJ] : 0L);
        if (x38VarB.f20602a == j || iJ == jArr.length - 1) {
            return new SeekMap.a(x38VarB);
        }
        int i = iJ + 1;
        return new SeekMap.a(x38VarB, b(jArr[i], jArr2[i]));
    }

    public final x38 b(long j, long j2) {
        return new x38((j * 1000000) / ((long) this.f2738a.e), this.f30642a + j2);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f2738a.h();
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
