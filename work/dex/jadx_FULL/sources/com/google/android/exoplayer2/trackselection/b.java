package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.zj.adlib.da9;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends BaseTrackSelection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Random f31047a;
    public int f;

    public b(da9 da9Var, int[] iArr, int i, Random random) {
        super(da9Var, iArr, i);
        this.f31047a = random;
        this.f = random.nextInt(this.c);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void c(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        for (int i2 = 0; i2 < this.c; i2++) {
            if (!isBlacklisted(i2, jElapsedRealtime)) {
                i++;
            }
        }
        this.f = this.f31047a.nextInt(i);
        if (i != this.c) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.c; i4++) {
                if (!isBlacklisted(i4, jElapsedRealtime)) {
                    int i5 = i3 + 1;
                    if (this.f == i3) {
                        this.f = i4;
                        return;
                    }
                    i3 = i5;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return 3;
    }

    public static final class a implements ExoTrackSelection.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Random f31048a;

        public a() {
            this.f31048a = new Random();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ExoTrackSelection c(ExoTrackSelection.a aVar) {
            return new b(aVar.f4675a, aVar.f4676a, aVar.f4674a, this.f31048a);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.Factory
        public ExoTrackSelection[] a(ExoTrackSelection.a[] aVarArr, BandwidthMeter bandwidthMeter, MediaSource.a aVar, Timeline timeline) {
            return TrackSelectionUtil.d(aVarArr, new TrackSelectionUtil.AdaptiveTrackSelectionFactory() { // from class: com.zj.adlib.ha7
                @Override // com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
                public final ExoTrackSelection a(ExoTrackSelection.a aVar2) {
                    return this.f42084a.c(aVar2);
                }
            });
        }

        public a(int i) {
            this.f31048a = new Random(i);
        }
    }
}
