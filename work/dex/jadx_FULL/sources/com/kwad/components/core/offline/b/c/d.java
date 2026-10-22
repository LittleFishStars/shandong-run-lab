package com.kwad.components.core.offline.b.c;

import android.media.TimedText;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public static com.kwad.sdk.contentalliance.a.a.b a(PlayVideoInfo playVideoInfo) {
        if (playVideoInfo == null) {
            return null;
        }
        return new com.kwad.sdk.contentalliance.a.a.b.a(playVideoInfo.videoUrl).dR(playVideoInfo.manifest).b(a(playVideoInfo.ksplayerLogParams)).a(playVideoInfo.videoPlayerStatus).bD(playVideoInfo.isNoCache).IG();
    }

    public static com.kwad.sdk.contentalliance.a.a.a a(KsPlayerLogParams ksPlayerLogParams) {
        if (ksPlayerLogParams == null) {
            return null;
        }
        com.kwad.sdk.contentalliance.a.a.a aVar = new com.kwad.sdk.contentalliance.a.a.a();
        aVar.photoId = ksPlayerLogParams.photoId;
        aVar.clickTime = ksPlayerLogParams.clickTime;
        aVar.adStyle = ksPlayerLogParams.adStyle;
        aVar.contentType = ksPlayerLogParams.contentType;
        return aVar;
    }

    public static com.kwad.sdk.core.video.a.c.e a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.e() { // from class: com.kwad.components.core.offline.b.c.d.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    onPreparedListener.onPrepared(iMediaPlayer);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    public static com.kwad.sdk.core.video.a.c.b a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.b() { // from class: com.kwad.components.core.offline.b.c.d.4
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void tK() {
                onCompletionListener.onCompletion(iMediaPlayer);
            }
        };
    }

    public static com.kwad.sdk.core.video.a.c.a a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.a() { // from class: com.kwad.components.core.offline.b.c.d.5
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void br(int i) {
                onBufferingUpdateListener.onBufferingUpdate(iMediaPlayer, i);
            }
        };
    }

    public static com.kwad.sdk.core.video.a.c.g a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.g() { // from class: com.kwad.components.core.offline.b.c.d.6
            @Override // com.kwad.sdk.core.video.a.c.g
            public final void tL() {
                onSeekCompleteListener.onSeekComplete(iMediaPlayer);
            }
        };
    }

    public static com.kwad.sdk.core.video.a.c.i a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.i() { // from class: com.kwad.components.core.offline.b.c.d.7
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void n(int i, int i2) {
                onVideoSizeChangedListener.onVideoSizeChanged(iMediaPlayer, i, i2);
            }
        };
    }

    public static com.kwad.sdk.core.video.a.c.InterfaceC1289c a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.InterfaceC1289c() { // from class: com.kwad.components.core.offline.b.c.d.8
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC1289c
            public final boolean o(int i, int i2) {
                return onErrorListener.onError(iMediaPlayer, i, i2);
            }
        };
    }

    public static com.kwad.sdk.core.video.a.c.d a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.d() { // from class: com.kwad.components.core.offline.b.c.d.9
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i, int i2) {
                return onInfoListener.onInfo(iMediaPlayer, i, i2);
            }
        };
    }

    public static com.kwad.sdk.core.video.a.c.h a(final IMediaPlayer iMediaPlayer, final IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener == null) {
            return null;
        }
        return new com.kwad.sdk.core.video.a.c.h() { // from class: com.kwad.components.core.offline.b.c.d.10
            @Override // com.kwad.sdk.core.video.a.c.h
            public final void a(TimedText timedText) {
                onTimedTextListener.onTimedText(iMediaPlayer, timedText);
            }
        };
    }

    public static l a(final OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        if (offlineVideoPlayStateListener == null) {
            return null;
        }
        return new l() { // from class: com.kwad.components.core.offline.b.c.d.11
            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                offlineVideoPlayStateListener.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                offlineVideoPlayStateListener.onMediaPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayPaused() {
                offlineVideoPlayStateListener.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                offlineVideoPlayStateListener.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                offlineVideoPlayStateListener.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                offlineVideoPlayStateListener.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPrepared() {
                offlineVideoPlayStateListener.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                offlineVideoPlayStateListener.onMediaPreparing();
            }

            @Override // com.kwad.components.core.video.l
            public final void onVideoPlayBufferingPaused() {
                offlineVideoPlayStateListener.onVideoPlayBufferingPaused();
            }

            @Override // com.kwad.components.core.video.l
            public final void onVideoPlayBufferingPlaying() {
                offlineVideoPlayStateListener.onVideoPlayBufferingPlaying();
            }
        };
    }

    public static i a(final OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        if (offlineMediaPlayStateListener == null) {
            return null;
        }
        return new i() { // from class: com.kwad.components.core.offline.b.c.d.2
            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                offlineMediaPlayStateListener.onMediaPlayCompleted();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                offlineMediaPlayStateListener.onMediaPlayError(i, i2);
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayPaused() {
                offlineMediaPlayStateListener.onMediaPlayPaused();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                offlineMediaPlayStateListener.onMediaPlayProgress(j, j2);
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                offlineMediaPlayStateListener.onMediaPlayStart();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                offlineMediaPlayStateListener.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPrepared() {
                offlineMediaPlayStateListener.onMediaPrepared();
            }

            @Override // com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                offlineMediaPlayStateListener.onMediaPreparing();
            }
        };
    }

    public static com.kwad.components.core.video.b.a a(final ReleaseCallback releaseCallback) {
        if (releaseCallback == null) {
            return null;
        }
        return new com.kwad.components.core.video.b.a() { // from class: com.kwad.components.core.offline.b.c.d.3
            @Override // com.kwad.components.core.video.b.a
            public final void onReleaseSuccess() {
                releaseCallback.onReleaseSuccess();
            }
        };
    }
}
