package com.zj.adlib;

import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r04 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HlsMediaPlaylist f44335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Deprecated
    public final b f19209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f19210a;

    public r04(c cVar, HlsMediaPlaylist hlsMediaPlaylist) {
        this.f19210a = cVar;
        this.f44335a = hlsMediaPlaylist;
        this.f19209a = new b(((HlsPlaylist) cVar).f30928a, ((HlsPlaylist) cVar).f4187a, cVar.f4266c, cVar.d, cVar.e, cVar.f, cVar.g, cVar.f4263a, cVar.h, ((HlsPlaylist) cVar).f4188a, cVar.f4264a, cVar.i);
    }
}
