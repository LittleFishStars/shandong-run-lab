package com.kwad.components.core.offline.b.c;

import android.content.Context;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IVideo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e implements IVideo {
    @Override // com.kwad.components.offline.api.core.video.IVideo
    public final IKsMediaPlayer createMediaPlayer(IKsMediaPlayerView iKsMediaPlayerView) {
        if (iKsMediaPlayerView instanceof b) {
            return new a().a(new com.kwad.components.core.video.b(((b) iKsMediaPlayerView).tI()));
        }
        throw new IllegalArgumentException("playerView not instanceof KsMediaPlayerView");
    }

    @Override // com.kwad.components.offline.api.core.video.IVideo
    public final BaseKsMediaPlayerView createMediaPlayerView(Context context) {
        DetailVideoView detailVideoView = new DetailVideoView(context);
        detailVideoView.setAd(true);
        detailVideoView.setFillXY(true);
        detailVideoView.updateTextureViewGravity(17);
        detailVideoView.g(true, 1);
        return new b(context).b(detailVideoView);
    }
}
