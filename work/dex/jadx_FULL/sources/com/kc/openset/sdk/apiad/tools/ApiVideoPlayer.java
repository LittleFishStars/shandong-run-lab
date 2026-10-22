package com.kc.openset.sdk.apiad.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.TextureView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.OSETCountDownTimer;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ApiVideoPlayer implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f39912a;
    private ADVPlayerListener b;
    private TextureView c;
    private MediaPlayer d;
    private boolean e = false;
    private boolean f = false;
    private OSETCountDownTimer g;
    private int h;
    private SurfaceTexture i;
    private int j;
    private int k;

    @Keep
    public interface ADVPlayerListener {
        void onVideoComplete();

        void onVideoError(String str);

        void onVideoPause();

        void onVideoResume(long j);

        void onVideoStart(MediaPlayer mediaPlayer, long j);
    }

    @Keep
    public class a implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ADVPlayerListener f39913a;
        final ApiVideoPlayer b;

        static {
            OSETSDKProtected.interface11(4871);
        }

        public a(ApiVideoPlayer apiVideoPlayer, ADVPlayerListener aDVPlayerListener) {
            this.b = apiVideoPlayer;
            this.f39913a = aDVPlayerListener;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public native void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

        @Override // android.view.TextureView.SurfaceTextureListener
        public native boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

        @Override // android.view.TextureView.SurfaceTextureListener
        public native void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

        @Override // android.view.TextureView.SurfaceTextureListener
        public native void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);
    }

    @Keep
    public class b extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ApiVideoPlayer f39914a;

        static {
            OSETSDKProtected.interface11(4872);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApiVideoPlayer apiVideoPlayer, long j, long j2) {
            super(j, j2);
            this.f39914a = apiVideoPlayer;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    public static native /* synthetic */ void $r8$lambda$H89Y7FcELpSmBGMRgM1ZlAxEZsY(ApiVideoPlayer apiVideoPlayer, MediaPlayer mediaPlayer, int i, int i2);

    public static native /* synthetic */ void $r8$lambda$fQrmbzzflnDSk3ZNpTCP0AADCaQ(ApiVideoPlayer apiVideoPlayer, ADVPlayerListener aDVPlayerListener, MediaPlayer mediaPlayer);

    /* JADX INFO: renamed from: $r8$lambda$h1-cxD5ofv8eLNbgUoJg3ThFmkI, reason: not valid java name */
    public static native /* synthetic */ boolean m1048$r8$lambda$h1cxD5ofv8eLNbgUoJg3ThFmkI(ApiVideoPlayer apiVideoPlayer, ADVPlayerListener aDVPlayerListener, MediaPlayer mediaPlayer, int i, int i2);

    static {
        OSETSDKProtected.interface11(4873);
    }

    public static native /* synthetic */ SurfaceTexture a(ApiVideoPlayer apiVideoPlayer);

    public static native /* synthetic */ SurfaceTexture a(ApiVideoPlayer apiVideoPlayer, SurfaceTexture surfaceTexture);

    private native void a(int i, int i2);

    private native /* synthetic */ void a(MediaPlayer mediaPlayer, int i, int i2);

    private native /* synthetic */ void a(ADVPlayerListener aDVPlayerListener, MediaPlayer mediaPlayer);

    private native /* synthetic */ boolean a(ADVPlayerListener aDVPlayerListener, MediaPlayer mediaPlayer, int i, int i2);

    public static native /* synthetic */ TextureView b(ApiVideoPlayer apiVideoPlayer);

    public static native /* synthetic */ boolean c(ApiVideoPlayer apiVideoPlayer);

    public static native /* synthetic */ MediaPlayer d(ApiVideoPlayer apiVideoPlayer);

    public native void changeVideoSize();

    public native void destroy();

    public native int getCurrentPosition();

    public native int getOnErrorExtra();

    public native int getOnErrorWhat();

    public native int[] getVideoSize();

    public native ApiVideoPlayer init(Context context, TextureView textureView);

    public native boolean isCompleted();

    public native boolean isPlaying();

    @Override // android.media.MediaPlayer.OnPreparedListener
    public native void onPrepared(MediaPlayer mediaPlayer);

    public native void pause();

    public native void resume();

    public native void setVolume(boolean z);

    public native void start(String str, ADVPlayerListener aDVPlayerListener);

    public native void startCountdown(long j);

    public native void stop();
}
