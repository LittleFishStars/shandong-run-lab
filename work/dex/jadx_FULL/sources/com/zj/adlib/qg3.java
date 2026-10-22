package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qg3 implements HlsPlaylistParserFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HlsPlaylistParserFactory f44204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<StreamKey> f19099a;

    public qg3(HlsPlaylistParserFactory hlsPlaylistParserFactory, List<StreamKey> list) {
        this.f44204a = hlsPlaylistParserFactory;
        this.f19099a = list;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser<HlsPlaylist> a() {
        return new rg3(this.f44204a.a(), this.f19099a);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser<HlsPlaylist> b(c cVar, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        return new rg3(this.f44204a.b(cVar, hlsMediaPlaylist), this.f19099a);
    }
}
