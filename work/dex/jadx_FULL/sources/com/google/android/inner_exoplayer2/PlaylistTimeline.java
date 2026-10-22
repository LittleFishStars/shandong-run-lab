package com.google.android.inner_exoplayer2;

import com.google.android.inner_exoplayer2.source.ShuffleOrder;
import com.google.android.inner_exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class PlaylistTimeline extends AbstractConcatenatedTimeline {
    private final HashMap<Object, Integer> childIndexByUid;
    private final int[] firstPeriodInChildIndices;
    private final int[] firstWindowInChildIndices;
    private final int periodCount;
    private final Timeline[] timelines;
    private final Object[] uids;
    private final int windowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaylistTimeline(Collection<? extends MediaSourceInfoHolder> collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int windowCount = 0;
        int size = collection.size();
        this.firstPeriodInChildIndices = new int[size];
        this.firstWindowInChildIndices = new int[size];
        this.timelines = new Timeline[size];
        this.uids = new Object[size];
        this.childIndexByUid = new HashMap<>();
        int periodCount = 0;
        int i = 0;
        for (MediaSourceInfoHolder mediaSourceInfoHolder : collection) {
            this.timelines[i] = mediaSourceInfoHolder.getTimeline();
            this.firstWindowInChildIndices[i] = windowCount;
            this.firstPeriodInChildIndices[i] = periodCount;
            windowCount += this.timelines[i].getWindowCount();
            periodCount += this.timelines[i].getPeriodCount();
            this.uids[i] = mediaSourceInfoHolder.getUid();
            this.childIndexByUid.put(this.uids[i], Integer.valueOf(i));
            i++;
        }
        this.windowCount = windowCount;
        this.periodCount = periodCount;
    }

    @Override // com.google.android.inner_exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByChildUid(Object obj) {
        Integer num = this.childIndexByUid.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.inner_exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByPeriodIndex(int i) {
        return Util.binarySearchFloor(this.firstPeriodInChildIndices, i + 1, false, false);
    }

    @Override // com.google.android.inner_exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByWindowIndex(int i) {
        return Util.binarySearchFloor(this.firstWindowInChildIndices, i + 1, false, false);
    }

    public List<Timeline> getChildTimelines() {
        return Arrays.asList(this.timelines);
    }

    @Override // com.google.android.inner_exoplayer2.AbstractConcatenatedTimeline
    public Object getChildUidByChildIndex(int i) {
        return this.uids[i];
    }

    @Override // com.google.android.inner_exoplayer2.AbstractConcatenatedTimeline
    public int getFirstPeriodIndexByChildIndex(int i) {
        return this.firstPeriodInChildIndices[i];
    }

    @Override // com.google.android.inner_exoplayer2.AbstractConcatenatedTimeline
    public int getFirstWindowIndexByChildIndex(int i) {
        return this.firstWindowInChildIndices[i];
    }

    @Override // com.google.android.inner_exoplayer2.Timeline
    public int getPeriodCount() {
        return this.periodCount;
    }

    @Override // com.google.android.inner_exoplayer2.AbstractConcatenatedTimeline
    public Timeline getTimelineByChildIndex(int i) {
        return this.timelines[i];
    }

    @Override // com.google.android.inner_exoplayer2.Timeline
    public int getWindowCount() {
        return this.windowCount;
    }
}
