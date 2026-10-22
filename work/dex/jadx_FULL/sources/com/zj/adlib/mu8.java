package com.zj.adlib;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mu8 implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f43387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Cue[] f18313a;

    public mu8(Cue[] cueArr, long[] jArr) {
        this.f18313a = cueArr;
        this.f43387a = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        Cue cue;
        int iJ = gj9.j(this.f43387a, j, true, false);
        return (iJ == -1 || (cue = this.f18313a[iJ]) == Cue.f4518a) ? Collections.emptyList() : Collections.singletonList(cue);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        sb0.a(i >= 0);
        sb0.a(i < this.f43387a.length);
        return this.f43387a[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.f43387a.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iF = gj9.f(this.f43387a, j, false, false);
        if (iF < this.f43387a.length) {
            return iF;
        }
        return -1;
    }
}
