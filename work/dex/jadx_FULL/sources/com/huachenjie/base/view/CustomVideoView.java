package com.huachenjie.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.upstream.c;
import com.huachenjie.base.R;
import com.zj.adlib.hp9;
import com.zj.adlib.i4a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CustomVideoView extends FrameLayout implements Player.Listener {
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = 2;
    public static final int P = 3;
    public static final int Q = 4;
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f32969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f7268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExoPlayer f7269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CustomTextureView f7270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PlayerListener f7271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f7272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7273a;
    public ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f7274b;

    public interface PlayerListener {
        void onError();

        void onPrepared();
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CustomVideoView.this.K == 4 || CustomVideoView.this.K == 2) {
                return;
            }
            CustomVideoView.this.b.setVisibility(8);
        }
    }

    public CustomVideoView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        ExoPlayer exoPlayer;
        int i = this.K;
        if (i == 4 || i == 0 || i == 3 || (exoPlayer = this.f7269a) == null) {
            return;
        }
        this.b.setImageResource(exoPlayer.isPlaying() ? R.drawable.ic_video_pause : R.drawable.ic_video_play);
        this.b.setVisibility(0);
        this.f32969a.removeCallbacks(this.f7272a);
        this.f32969a.postDelayed(this.f7272a, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        int i = this.K;
        if (i == 0) {
            this.K = 1;
            startClick();
            return;
        }
        if (i == 4) {
            this.f7269a.seekTo(0L);
            this.K = 1;
            startClick();
        } else if (i == 1 || i == 2) {
            ExoPlayer exoPlayer = this.f7269a;
            if (exoPlayer == null || !exoPlayer.isPlaying()) {
                startClick();
            } else {
                pauseClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str, boolean z) {
        if (this.f7269a == null) {
            D();
        }
        this.f7274b = false;
        this.K = 0;
        g gVarC = new g.b(new c.a(getContext())).c(com.google.android.exoplayer2.g.e(str));
        if (z) {
            this.f7269a.setRepeatMode(2);
        }
        this.f7269a.setPlayWhenReady(false);
        this.f7269a.c0(gVarC);
        I();
    }

    public final void D() {
        release();
        ExoPlayer exoPlayerW = new ExoPlayer.a(getContext()).w();
        this.f7269a = exoPlayerW;
        exoPlayerW.setVideoTextureView(this.f7270a);
        this.f7269a.u(this);
        this.f7269a.setPlayWhenReady(false);
    }

    public final void I() {
        if (this.f7273a || this.b == null) {
            return;
        }
        this.f32969a.removeCallbacks(this.f7272a);
        this.b.setImageResource(R.drawable.ic_video_play);
        this.b.setVisibility(0);
    }

    public final void o(Context context) {
        View viewInflate = View.inflate(context, R.layout.view_custom_video, this);
        this.f7270a = (CustomTextureView) viewInflate.findViewById(R.id.custom_texture_view);
        this.f7268a = (ImageView) viewInflate.findViewById(R.id.iv_thumbnail);
        this.b = (ImageView) viewInflate.findViewById(R.id.iv_control);
        D();
        if (this.f7273a) {
            this.f7268a.setVisibility(8);
            this.b.setVisibility(8);
        } else {
            setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.oz1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43858a.v(view);
                }
            });
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.pz1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44090a.w(view);
                }
            });
        }
    }

    public void onCompletion() {
        this.b.setImageResource(R.drawable.ic_video_replay);
        this.b.setVisibility(0);
        this.K = 4;
    }

    public void onError() {
        this.K = 3;
        PlayerListener playerListener = this.f7271a;
        if (playerListener != null) {
            playerListener.onError();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaybackStateChanged(int playbackState) {
        if (playbackState != 3) {
            if (playbackState != 4) {
                return;
            }
            this.f7269a.setPlayWhenReady(false);
            onCompletion();
            return;
        }
        if (this.f7274b) {
            return;
        }
        this.f7274b = true;
        onPrepared();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(PlaybackException error) {
        onError();
    }

    public void onPrepared() {
        if (this.K == 0) {
            I();
        }
        PlayerListener playerListener = this.f7271a;
        if (playerListener != null) {
            playerListener.onPrepared();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onVideoSizeChanged(hp9 videoSize) {
        setVideoSize(videoSize.K, videoSize.L);
    }

    public void pause() {
        pauseClick();
    }

    public void pauseClick() {
        ExoPlayer exoPlayer;
        int i = this.K;
        if (i == 0 || i == 3 || i == 4 || (exoPlayer = this.f7269a) == null) {
            return;
        }
        exoPlayer.setPlayWhenReady(false);
        I();
        this.K = 2;
    }

    public void playVideo(String url) {
        playVideo(url, false);
    }

    public void release() {
        if (this.f7269a != null) {
            Handler handler = this.f32969a;
            if (handler != null) {
                handler.removeCallbacks(this.f7272a);
            }
            this.f7274b = false;
            this.f7269a.release();
            this.f7269a = null;
        }
    }

    public void setThumbnailRes(@DrawableRes int resId) {
        ImageView imageView = this.f7268a;
        if (imageView != null) {
            imageView.setImageResource(resId);
        }
    }

    public void setVideoDisplayType(int videoDisplayType) {
        this.L = videoDisplayType;
    }

    public void setVideoPath(String url) {
        i4a.a("" + url);
        if (this.f7269a == null || TextUtils.isEmpty(url)) {
            return;
        }
        playVideo(url);
    }

    public void setVideoPlayerListener(PlayerListener videoPlayerListener) {
        this.f7271a = videoPlayerListener;
    }

    public void setVideoSize(int videoWidth, int videoHeight) {
        CustomTextureView customTextureView = this.f7270a;
        if (customTextureView == null) {
            return;
        }
        customTextureView.setVideoCustomCropSize(videoWidth, videoHeight, this.L);
    }

    public void start() {
        ExoPlayer exoPlayer;
        int i = this.K;
        if (i == 0 || i == 3 || i == 4) {
            if (i == 4 && (exoPlayer = this.f7269a) != null) {
                exoPlayer.seekTo(0L);
            }
            this.K = 1;
        }
        startClick();
    }

    public void startClick() {
        int i = this.K;
        if (i == 0 || i == 3 || i == 4 || this.f7269a == null) {
            return;
        }
        this.f7268a.setVisibility(8);
        this.f7269a.setPlayWhenReady(true);
        this.b.setVisibility(8);
        this.K = 1;
    }

    public CustomVideoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void playVideo(final String url, final boolean isLoop) {
        this.f32969a.post(new Runnable() { // from class: com.zj.adlib.qz1
            @Override // java.lang.Runnable
            public final void run() {
                this.f44330a.y(url, isLoop);
            }
        });
    }

    public CustomVideoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.K = 0;
        this.L = 0;
        this.f32969a = new Handler();
        this.f7272a = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomVideoView, defStyleAttr, 0);
        this.f7273a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CustomVideoView_hide_play_ui, false);
        typedArrayObtainStyledAttributes.recycle();
        o(context);
    }
}
