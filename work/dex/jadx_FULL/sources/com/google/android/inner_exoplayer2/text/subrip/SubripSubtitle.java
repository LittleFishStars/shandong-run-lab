package com.google.android.inner_exoplayer2.text.subrip;

import com.google.android.inner_exoplayer2.text.Cue;
import com.google.android.inner_exoplayer2.text.Subtitle;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        Cue cue;
        int iBinarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j, true, false);
        return (iBinarySearchFloor == -1 || (cue = this.cues[iBinarySearchFloor]) == Cue.EMPTY) ? Collections.emptyList() : Collections.singletonList(cue);
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i >= 0);
        Assertions.checkArgument(i < this.cueTimesUs.length);
        return this.cueTimesUs[i];
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    @Override // com.google.android.inner_exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j, false, false);
        if (iBinarySearchCeil < this.cueTimesUs.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }
}
