package com.kwad.components.core.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g extends com.kwad.sdk.core.video.a.a {
    private static AtomicBoolean anD = new AtomicBoolean(false);
    private com.kwad.components.core.offline.a.b.a anB;
    private IAdWaynePlayerPlayModule anC;
    private String anz;
    private AdTemplate mAdTemplate;
    private final String TAG = "KwaiWaynePlayer";
    private final Object any = new Object();
    private boolean anE = false;
    private boolean anF = false;
    private boolean anG = false;
    private final a anA = new a(this, "KwaiWaynePlayer");

    public static class a implements IAdWaynePlayerPlayModule.OnBufferingUpdateListener, IAdWaynePlayerPlayModule.OnCompletionListener, IAdWaynePlayerPlayModule.OnErrorListener, IAdWaynePlayerPlayModule.OnInfoListener, IAdWaynePlayerPlayModule.OnPreparedListener, IAdWaynePlayerPlayModule.OnSeekCompleteListener, IAdWaynePlayerPlayModule.OnVideoSizeChangedListener, IAdWaynePlayerPlayModule.OnVseReportListener {
        final String TAG;
        final WeakReference<g> mWeakMediaPlayer;

        public a(g gVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(gVar);
            this.TAG = str;
        }

        private g xM() {
            return this.mWeakMediaPlayer.get();
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnBufferingUpdateListener
        public final void onBufferingUpdate(int i) {
            g gVarXM = xM();
            if (gVarXM != null) {
                gVarXM.notifyOnBufferingUpdate(i);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnCompletionListener
        public final void onCompletion() {
            g gVarXM = xM();
            if (gVarXM != null) {
                gVarXM.notifyOnCompletion();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnErrorListener
        public final boolean onError(int i, int i2) {
            g gVarXM = xM();
            if (gVarXM != null) {
                return gVarXM.notifyOnError(i, i2);
            }
            return false;
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnInfoListener
        public final boolean onInfo(int i, int i2) {
            g gVarXM = xM();
            if (gVarXM == null) {
                return false;
            }
            if (i != 3) {
                return gVarXM.notifyOnInfo(i, i2);
            }
            if (gVarXM.anG) {
                return false;
            }
            g.a(gVarXM, true);
            return gVarXM.notifyOnInfo(i, i2);
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnPreparedListener
        public final void onPrepared() {
            g gVarXM = xM();
            if (gVarXM != null) {
                gVarXM.notifyOnPrepared();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnSeekCompleteListener
        public final void onSeekComplete() {
            g gVarXM = xM();
            if (gVarXM != null) {
                gVarXM.notifyOnSeekComplete();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(int i, int i2) {
            g gVarXM = xM();
            if (gVarXM != null) {
                gVarXM.D(i, i2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVseReportListener
        public final void onVseReport(String str, String str2) {
            g gVarXM = xM();
            if (gVarXM != null) {
                gVarXM.p(str, str2);
            }
        }
    }

    public g(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        com.kwad.components.core.offline.a.b.a aVar = (com.kwad.components.core.offline.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.b.a.class);
        this.anB = aVar;
        if (aVar == null || !aVar.tt()) {
            return;
        }
        if (TextUtils.isEmpty(bVar.manifest)) {
            String str = bVar.videoUrl;
            this.anz = str;
            this.anC = this.anB.getAdWaynePlayerPlayModule(str, false);
        } else {
            String str2 = bVar.manifest;
            this.anz = str2;
            this.anC = this.anB.getAdWaynePlayerPlayModule(str2, true);
        }
        if (this.anC != null) {
            anD.set(true);
            this.anC.setLooping(false);
            xK();
        }
    }

    public static boolean isWaynePlayerReady() {
        return anD.get();
    }

    private void xK() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(this.anA);
            this.anC.setOnCompletionListener(this.anA);
            this.anC.setOnBufferingUpdateListener(this.anA);
            this.anC.setOnSeekCompleteListener(this.anA);
            this.anC.setOnVideoSizeChangedListener(this.anA);
            this.anC.setOnErrorListener(this.anA);
            this.anC.setOnInfoListener(this.anA);
            this.anC.setOnVseReportListener(this.anA);
        }
    }

    private void xL() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(null);
            this.anC.setOnCompletionListener(null);
            this.anC.setOnBufferingUpdateListener(null);
            this.anC.setOnSeekCompleteListener(null);
            this.anC.setOnVideoSizeChangedListener(null);
            this.anC.setOnErrorListener(null);
            this.anC.setOnInfoListener(null);
            this.anC.setOnVseReportListener(null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getAudioSessionId();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        return iAdWaynePlayerPlayModule != null ? iAdWaynePlayerPlayModule.getCurrentPlayingUrl() : "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.anz;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getDuration();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 3;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isLooping();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isPlaying();
        }
        return false;
    }

    public final void p(String str, String str2) {
        final com.kwad.components.core.video.a.e eVar = new com.kwad.components.core.video.a.e();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            eVar.setAdTemplate(adTemplate);
        }
        eVar.br(str);
        eVar.bs(str2);
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.components.core.video.g.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.w(eVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        if (this.anC != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "pause");
            this.anC.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        if (!this.anF && (iAdWaynePlayerPlayModule = this.anC) != null) {
            try {
                this.anF = true;
                boolean zPrepareAsync = iAdWaynePlayerPlayModule.prepareAsync();
                OF();
                com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "prepareAsync result: " + zPrepareAsync);
                return zPrepareAsync;
            } catch (IllegalStateException e) {
                com.kwad.sdk.core.d.c.e("KwaiWaynePlayer", "prepareAsync failed ", e);
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            this.anE = true;
            iAdWaynePlayerPlayModule.release();
            try {
                resetListeners();
                xL();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.anF = false;
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.reset();
                resetListeners();
                xK();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.seekTo(j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setAudioStreamType(i);
        }
    }

    public final void setClickCoordForOpaque(float f, float f2) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setClickCoordForOpaque(f, f2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        if (this.anC != null) {
            this.anz = str;
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
                this.anC.setDataSource(str, false);
            } else {
                this.anC.setDataSource(uri.getPath(), false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        synchronized (this.any) {
            if (!this.anE && (iAdWaynePlayerPlayModule = this.anC) != null) {
                iAdWaynePlayerPlayModule.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.setSpeed(f);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.anC;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setVolume(f, f2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        if (this.anC != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "start");
            this.anC.start();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        if (this.anC != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "stop");
            this.anC.stop();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean xJ() {
        return prepareAsync();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (this.anC != null) {
            if (!TextUtils.isEmpty(bVar.manifest)) {
                String str = bVar.manifest;
                this.anz = str;
                this.anC.setDataSource(str, true);
            } else {
                String str2 = bVar.videoUrl;
                this.anz = str2;
                this.anC.setDataSource(str2, false);
            }
        }
    }

    public static /* synthetic */ boolean a(g gVar, boolean z) {
        gVar.anG = true;
        return true;
    }
}
