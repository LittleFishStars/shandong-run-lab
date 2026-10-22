package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends com.kwad.sdk.core.video.a.a {
    private final MediaPlayer aZj;
    private final a aZk;
    private MediaDataSource aZl;
    private boolean anE;
    private boolean anG;
    private final Object any;
    private String anz;

    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        public a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar == null) {
                return false;
            }
            if (i != 3) {
                return bVar.notifyOnInfo(i, i2);
            }
            if (bVar.anG) {
                return false;
            }
            b.a(bVar, true);
            return bVar.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.D(i, i2);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.any = obj;
        this.anG = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.aZj = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.aZk = new a(this);
        xK();
        setLooping(false);
    }

    private void OG() {
        MediaDataSource mediaDataSource = this.aZl;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aZl = null;
        }
    }

    private void xK() {
        this.aZj.setOnPreparedListener(this.aZk);
        this.aZj.setOnBufferingUpdateListener(this.aZk);
        this.aZj.setOnCompletionListener(this.aZk);
        this.aZj.setOnSeekCompleteListener(this.aZk);
        this.aZj.setOnVideoSizeChangedListener(this.aZk);
        this.aZj.setOnErrorListener(this.aZk);
        this.aZj.setOnInfoListener(this.aZk);
        this.aZj.setOnTimedTextListener(this.aZk);
    }

    private void xL() {
        this.aZj.setOnPreparedListener(null);
        this.aZj.setOnBufferingUpdateListener(null);
        this.aZj.setOnCompletionListener(null);
        this.aZj.setOnSeekCompleteListener(null);
        this.aZj.setOnVideoSizeChangedListener(null);
        this.aZj.setOnErrorListener(null);
        this.aZj.setOnInfoListener(null);
        this.aZj.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) throws IOException {
        if (!bVar.isNoCache) {
            setDataSource(bVar.videoUrl);
            return;
        }
        HashMap map = new HashMap();
        map.put("Content-Type", "video/mp4");
        map.put("Accept-Ranges", "bytes");
        map.put("Status", "206");
        map.put("Cache-control", "no-cache");
        setDataSource(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), Uri.parse(bVar.videoUrl), map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aZj.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aZj.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.anz;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aZj.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aZj.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aZj.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aZj.isLooping();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aZj.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aZj.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        this.aZj.prepareAsync();
        OF();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        try {
            this.anE = true;
            this.aZj.release();
            OG();
            resetListeners();
            xL();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        try {
            this.aZj.reset();
            this.anG = false;
        } catch (IllegalStateException unused) {
        }
        OG();
        resetListeners();
        xK();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        this.aZj.seekTo((int) j, 3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        this.aZj.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) throws IOException {
        this.aZj.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.any) {
            if (!this.anE) {
                this.aZj.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aZj.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
        this.aZj.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        try {
            PlaybackParams playbackParams = this.aZj.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f);
            this.aZj.setPlaybackParams(playbackParams);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aZj.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aZj.setVolume(f, f2);
        com.kwad.sdk.core.video.a.a.o(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        this.aZj.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aZj.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean xJ() {
        this.aZj.prepareAsync();
        OF();
        return true;
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.anG = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        this.aZj.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        this.aZj.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) throws IOException {
        this.anz = str;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.aZj.setDataSource(uri.getPath());
        } else {
            this.aZj.setDataSource(str);
        }
    }
}
