package cj.mobile.wm.common.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ThreadUtils;
import cj.mobile.wm.dexc;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomVideoView2 extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {
    public MediaPlayer.OnCompletionListener completionListener;
    public MediaPlayer.OnErrorListener errorListener;
    public boolean isReleased;
    public DataSourseErrorListener mDataSourseErrorListener;
    public Surface mSurface;
    public MediaPlayer mediaPlayer;
    public MediaPlayer.OnInfoListener onInfoListener;
    public MediaPlayer.OnPreparedListener preparedListener;
    public SurfaceTexture surfaceTexture;
    public String videoPath;
    public boolean volumeOff;

    public interface DataSourseErrorListener {
        void onDataSourseErrorListener();
    }

    public CustomVideoView2(Context context) {
        super(context);
        this.isReleased = false;
        this.volumeOff = true;
        initTextureView();
    }

    private boolean checkPlayerReady() {
        if (this.isReleased) {
            DebugLog.common_w(dexc.dexa("sfmfbtfe"));
            return false;
        }
        if (this.mediaPlayer != null) {
            return true;
        }
        DebugLog.common_w(dexc.dexa("nfejbQmbzfs!jt!ovmm"));
        return false;
    }

    private void initTextureView() {
        setSurfaceTextureListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: internalPrepare, reason: merged with bridge method [inline-methods] */
    public void dexa(SurfaceTexture surfaceTexture) {
        if (TextUtils.isEmpty(this.videoPath)) {
            DebugLog.common_w(dexc.dexa("wjefpQbui!jt!ovmm"));
            return;
        }
        try {
            this.mSurface = new Surface(surfaceTexture);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.reset();
            if (this.volumeOff) {
                this.mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mediaPlayer.setVolume(1.0f, 1.0f);
            }
            this.mediaPlayer.setSurface(this.mSurface);
            this.mediaPlayer.setDataSource(this.videoPath);
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.setOnErrorListener(this);
            this.mediaPlayer.setOnInfoListener(this);
            this.mediaPlayer.prepareAsync();
        } catch (Throwable th) {
            DataSourseErrorListener dataSourseErrorListener = this.mDataSourseErrorListener;
            if (dataSourseErrorListener != null) {
                dataSourseErrorListener.onDataSourseErrorListener();
            }
            DebugLog.common_w(dexc.dexa("joufsobmQsfqbsf!gbjm!") + Log.getStackTraceString(th));
        }
    }

    private void removeViewFromParent() {
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) getParent()).removeView(this);
    }

    public void destroy() {
        releaseAll();
        removeViewFromParent();
    }

    public int getCurrentPosition() {
        if (checkPlayerReady()) {
            return this.mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (checkPlayerReady()) {
            return this.mediaPlayer.getDuration();
        }
        return 0;
    }

    public boolean isPlaying() {
        return checkPlayerReady() && this.mediaPlayer.isPlaying();
    }

    public boolean isVolumeOff() {
        return this.volumeOff;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer.OnCompletionListener onCompletionListener = this.completionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(mediaPlayer);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        DebugLog.common_w(dexc.dexa("NfejbQmbzfs!poFssps!") + i + dexc.dexa(c49.f40900a) + i2);
        MediaPlayer.OnErrorListener onErrorListener = this.errorListener;
        if (onErrorListener == null) {
            return false;
        }
        onErrorListener.onError(mediaPlayer, i, i2);
        return false;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        MediaPlayer.OnInfoListener onInfoListener = this.onInfoListener;
        if (onInfoListener == null) {
            return false;
        }
        onInfoListener.onInfo(mediaPlayer, i, i2);
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        try {
            setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            MediaPlayer.OnPreparedListener onPreparedListener = this.preparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(mediaPlayer);
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("poQsfqbsfe!gbjm!") + th);
        }
    }

    public void onResDestroy() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.surfaceTexture = null;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, int i, int i2) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.sz1
            @Override // java.lang.Runnable
            public final void run() {
                this.f19685a.dexa(surfaceTexture);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        try {
            onResDestroy();
            return true;
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("poTvsgbdfUfyuvsfEftuspzfe!gbjm!") + th);
            return true;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        try {
            if (checkPlayerReady() && this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("qbvtf!gbjm!") + th);
        }
    }

    public void releaseAll() {
        try {
            if (this.isReleased) {
                return;
            }
            DebugLog.common_weak(dexc.dexa("sfmfbtfBmm"));
            this.isReleased = true;
            onResDestroy();
            this.preparedListener = null;
            this.completionListener = null;
            this.errorListener = null;
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("sfmfbtfBmm!gbjm!") + th);
        }
    }

    public void seekTo(int i) {
        try {
            if (checkPlayerReady()) {
                this.mediaPlayer.seekTo(i);
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("tfflUp!gbjm!") + th);
        }
    }

    public void setDataSourseErrorListener(DataSourseErrorListener dataSourseErrorListener) {
        this.mDataSourseErrorListener = dataSourseErrorListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.completionListener = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.errorListener = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.onInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.preparedListener = onPreparedListener;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVolume(int i) {
        try {
            if (checkPlayerReady()) {
                float f = i;
                this.mediaPlayer.setVolume(f, f);
            }
            setVolumeOff(i == 0);
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("tfuWpmvnf!") + th);
        }
    }

    public void setVolumeOff(boolean z) {
        this.volumeOff = z;
    }

    public void startVideo() {
        try {
            if (!checkPlayerReady() || this.mediaPlayer.isPlaying()) {
                return;
            }
            this.mediaPlayer.start();
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("tubsuWjefp!gbjm!") + th);
        }
    }

    public CustomVideoView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isReleased = false;
        this.volumeOff = true;
        initTextureView();
    }

    public CustomVideoView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isReleased = false;
        this.volumeOff = true;
        initTextureView();
    }
}
