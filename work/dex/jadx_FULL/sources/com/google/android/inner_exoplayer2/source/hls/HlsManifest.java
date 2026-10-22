package com.google.android.inner_exoplayer2.source.hls;

import com.google.android.inner_exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.inner_exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.inner_exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class HlsManifest {

    @Deprecated
    public final HlsMasterPlaylist masterPlaylist;
    public final HlsMediaPlaylist mediaPlaylist;
    public final HlsMultivariantPlaylist multivariantPlaylist;

    public HlsManifest(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.mediaPlaylist = hlsMediaPlaylist;
        this.masterPlaylist = new HlsMasterPlaylist(hlsMultivariantPlaylist.baseUri, hlsMultivariantPlaylist.tags, hlsMultivariantPlaylist.variants, hlsMultivariantPlaylist.videos, hlsMultivariantPlaylist.audios, hlsMultivariantPlaylist.subtitles, hlsMultivariantPlaylist.closedCaptions, hlsMultivariantPlaylist.muxedAudioFormat, hlsMultivariantPlaylist.muxedCaptionFormats, hlsMultivariantPlaylist.hasIndependentSegments, hlsMultivariantPlaylist.variableDefinitions, hlsMultivariantPlaylist.sessionKeyDrmInitData);
    }
}
