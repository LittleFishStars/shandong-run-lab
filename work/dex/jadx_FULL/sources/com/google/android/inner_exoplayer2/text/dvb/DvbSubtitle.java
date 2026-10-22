package com.google.android.inner_exoplayer2.text.dvb;

import com.google.android.inner_exoplayer2.text.Cue;
import com.google.android.inner_exoplayer2.text.Subtitle;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class DvbSubtitle implements Subtitle {
    private final List<Cue> cues;

    public DvbSubtitle(List<Cue> list) {
        this.cues = list;
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return this.cues;
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return 0L;
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return -1;
    }
}
