package com.google.android.inner_exoplayer2.source;

import com.google.android.inner_exoplayer2.SeekParameters;
import com.google.android.inner_exoplayer2.offline.StreamKey;
import com.google.android.inner_exoplayer2.trackselection.ExoTrackSelection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    @Override // com.google.android.inner_exoplayer2.source.SequenceableLoader
    boolean continueLoading(long j);

    void discardBuffer(long j, boolean z);

    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    @Override // com.google.android.inner_exoplayer2.source.SequenceableLoader
    long getBufferedPositionUs();

    @Override // com.google.android.inner_exoplayer2.source.SequenceableLoader
    long getNextLoadPositionUs();

    default List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        return Collections.emptyList();
    }

    TrackGroupArray getTrackGroups();

    @Override // com.google.android.inner_exoplayer2.source.SequenceableLoader
    boolean isLoading();

    void maybeThrowPrepareError();

    void prepare(Callback callback, long j);

    long readDiscontinuity();

    @Override // com.google.android.inner_exoplayer2.source.SequenceableLoader
    void reevaluateBuffer(long j);

    long seekToUs(long j);

    long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);
}
