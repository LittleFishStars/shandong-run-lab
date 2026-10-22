package com.google.android.exoplayer2;

import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.zj.adlib.ga9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface LoadControl {
    void a(Renderer[] rendererArr, ga9 ga9Var, ExoTrackSelection[] exoTrackSelectionArr);

    Allocator b();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j, long j2, float f);

    boolean shouldStartPlayback(long j, float f, boolean z, long j2);
}
