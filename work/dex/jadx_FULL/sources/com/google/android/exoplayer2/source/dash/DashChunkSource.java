package com.google.android.exoplayer2.source.dash;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.at6;
import com.zj.adlib.c62;
import com.zj.adlib.xr0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface DashChunkSource extends ChunkSource {

    public interface Factory {
        DashChunkSource a(LoaderErrorThrower loaderErrorThrower, c62 c62Var, xr0 xr0Var, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, long j, boolean z, List<d> list, @Nullable PlayerEmsgHandler.b bVar, @Nullable TransferListener transferListener, at6 at6Var);
    }

    void b(ExoTrackSelection exoTrackSelection);

    void c(c62 c62Var, int i);
}
