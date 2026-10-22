package com.google.android.exoplayer2.extractor.mp3;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.zj.adlib.gj9;
import com.zj.adlib.q25;
import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements Seeker {

    @VisibleForTesting
    public static final long c = 100000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final q25 f2930a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final q25 f2931b;

    public b(long j, long j2, long j3) {
        this.b = j;
        this.f30665a = j3;
        q25 q25Var = new q25();
        this.f2930a = q25Var;
        q25 q25Var2 = new q25();
        this.f2931b = q25Var2;
        q25Var.a(0L);
        q25Var2.a(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        int iG = gj9.g(this.f2930a, j, true, true);
        x38 x38Var = new x38(this.f2930a.b(iG), this.f2931b.b(iG));
        if (x38Var.f20602a == j || iG == this.f2930a.c() - 1) {
            return new SeekMap.a(x38Var);
        }
        int i = iG + 1;
        return new SeekMap.a(x38Var, new x38(this.f2930a.b(i), this.f2931b.b(i)));
    }

    public boolean b(long j) {
        q25 q25Var = this.f2930a;
        return j - q25Var.b(q25Var.c() - 1) < 100000;
    }

    public void c(long j, long j2) {
        if (b(j)) {
            return;
        }
        this.f2930a.a(j);
        this.f2931b.a(j2);
    }

    public void d(long j) {
        this.b = j;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.f30665a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return this.f2930a.b(gj9.g(this.f2931b, j, true, true));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
