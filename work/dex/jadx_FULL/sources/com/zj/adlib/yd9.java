package com.zj.adlib;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class yd9 implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yd9 f46008a = new yd9();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Cue> f20840a;

    public yd9(Cue cue) {
        this.f20840a = Collections.singletonList(cue);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return j >= 0 ? this.f20840a : Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        sb0.a(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }

    public yd9() {
        this.f20840a = Collections.emptyList();
    }
}
