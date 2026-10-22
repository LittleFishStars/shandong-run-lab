package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.da9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ExoTrackSelection extends TrackSelection {

    public interface Factory {
        ExoTrackSelection[] a(a[] aVarArr, BandwidthMeter bandwidthMeter, MediaSource.a aVar, Timeline timeline);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f31039a = "ETSDefinition";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f4674a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final da9 f4675a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f4676a;

        public a(da9 da9Var, int... iArr) {
            this(da9Var, iArr, 0);
        }

        public a(da9 da9Var, int[] iArr, int i) {
            if (iArr.length == 0) {
                Log.e(f31039a, "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f4675a = da9Var;
            this.f4676a = iArr;
            this.f4674a = i;
        }
    }

    d a();

    boolean blacklist(int i, long j);

    void c(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr);

    void disable();

    void enable();

    int evaluateQueueSize(long j, List<? extends MediaChunk> list);

    default boolean f(long j, Chunk chunk, List<? extends MediaChunk> list) {
        return false;
    }

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    @Nullable
    Object getSelectionData();

    int getSelectionReason();

    boolean isBlacklisted(int i, long j);

    default void onDiscontinuity() {
    }

    default void onPlayWhenReadyChanged(boolean z) {
    }

    void onPlaybackSpeed(float f);

    default void onRebuffer() {
    }
}
