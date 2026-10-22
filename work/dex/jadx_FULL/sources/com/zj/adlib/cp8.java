package com.zj.adlib;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cp8 implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<Cue>> f41018a;
    public final List<Long> c;

    public cp8(List<List<Cue>> list, List<Long> list2) {
        this.f41018a = list;
        this.c = list2;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        int iH = gj9.h(this.c, Long.valueOf(j), true, false);
        return iH == -1 ? Collections.emptyList() : this.f41018a.get(iH);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        sb0.a(i >= 0);
        sb0.a(i < this.c.size());
        return this.c.get(i).longValue();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.c.size();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iD = gj9.d(this.c, Long.valueOf(j), false, false);
        if (iD < this.c.size()) {
            return iD;
        }
        return -1;
    }
}
