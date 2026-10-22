package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class yh3 extends BaseTrackSelection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f46031a;
    public final int f;

    public yh3(da9 da9Var, int i) {
        this(da9Var, i, 0);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void c(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectedIndex() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object getSelectionData() {
        return this.f46031a;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int getSelectionReason() {
        return this.f;
    }

    public yh3(da9 da9Var, int i, int i2) {
        this(da9Var, i, i2, 0, null);
    }

    public yh3(da9 da9Var, int i, int i2, int i3, @Nullable Object obj) {
        super(da9Var, new int[]{i}, i2);
        this.f = i3;
        this.f46031a = obj;
    }
}
