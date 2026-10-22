package com.google.android.inner_exoplayer2;

import com.google.android.inner_exoplayer2.source.TrackGroupArray;
import com.google.android.inner_exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.inner_exoplayer2.upstream.Allocator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface LoadControl {
    Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j, long j2, float f);

    boolean shouldStartPlayback(long j, float f, boolean z, long j2);
}
