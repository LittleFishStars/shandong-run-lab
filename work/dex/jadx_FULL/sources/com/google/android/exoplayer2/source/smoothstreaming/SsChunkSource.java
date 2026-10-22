package com.google.android.exoplayer2.source.smoothstreaming;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface SsChunkSource extends ChunkSource {

    public interface Factory {
        SsChunkSource a(LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, ExoTrackSelection exoTrackSelection, @Nullable TransferListener transferListener);
    }

    void b(ExoTrackSelection exoTrackSelection);

    void g(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar);
}
