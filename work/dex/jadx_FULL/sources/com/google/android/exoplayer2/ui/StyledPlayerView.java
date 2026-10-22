package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.gj9;
import com.zj.adlib.hp9;
import com.zj.adlib.sb0;
import com.zj.adlib.xy1;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class StyledPlayerView extends FrameLayout implements AdViewProvider {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    public int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Drawable f31074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final View f4923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final FrameLayout f4924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ImageView f4925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TextView f4926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Player f4927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final AspectRatioFrameLayout f4928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public StyledPlayerControlView.VisibilityListener f4929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final StyledPlayerControlView f4930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ControllerVisibilityListener f4931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public FullscreenButtonClickListener f4932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f4933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final SubtitleView f4934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ErrorMessageProvider<? super PlaybackException> f4935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public CharSequence f4936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4937a;

    @Nullable
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final FrameLayout f4938b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4939b;

    @Nullable
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4940c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public interface ControllerVisibilityListener {
        void onVisibilityChanged(int i);
    }

    public interface FullscreenButtonClickListener {
        void a(boolean z);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowBuffering {
    }

    public final class a implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, StyledPlayerControlView.VisibilityListener, StyledPlayerControlView.OnFullScreenModeChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Timeline.b f31075a = new Timeline.b();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f4942a;

        public a() {
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void C(Player.d dVar, Player.d dVar2, int i) {
            if (StyledPlayerView.this.g() && StyledPlayerView.this.f) {
                StyledPlayerView.this.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void G(p pVar) {
            Player player = (Player) sb0.g(StyledPlayerView.this.f4927a);
            Timeline timelineA0 = player.a0();
            if (timelineA0.w()) {
                this.f4942a = null;
            } else if (player.s().d()) {
                Object obj = this.f4942a;
                if (obj != null) {
                    int iF = timelineA0.f(obj);
                    if (iF != -1) {
                        if (player.getCurrentMediaItemIndex() == timelineA0.j(iF, this.f31075a).K) {
                            return;
                        }
                    }
                    this.f4942a = null;
                }
            } else {
                this.f4942a = timelineA0.k(player.getCurrentPeriodIndex(), this.f31075a, true).f2194b;
            }
            StyledPlayerView.this.t(false);
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener
        public void e(int i) {
            StyledPlayerView.this.q();
            if (StyledPlayerView.this.f4931a != null) {
                StyledPlayerView.this.f4931a.onVisibilityChanged(i);
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void j(xy1 xy1Var) {
            if (StyledPlayerView.this.f4934a != null) {
                StyledPlayerView.this.f4934a.setCues(xy1Var.f20751a);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.OnFullScreenModeChangedListener
        public void k(boolean z) {
            if (StyledPlayerView.this.f4932a != null) {
                StyledPlayerView.this.f4932a.a(z);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StyledPlayerView.this.n();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            StyledPlayerView.a((TextureView) view, StyledPlayerView.this.M);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            StyledPlayerView.this.p();
            StyledPlayerView.this.r();
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackStateChanged(int i) {
            StyledPlayerView.this.p();
            StyledPlayerView.this.s();
            StyledPlayerView.this.r();
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onRenderedFirstFrame() {
            if (StyledPlayerView.this.f4923a != null) {
                StyledPlayerView.this.f4923a.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onVideoSizeChanged(hp9 hp9Var) {
            StyledPlayerView.this.o();
        }
    }

    public StyledPlayerView(Context context) {
        this(context, null);
    }

    public static void a(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    public static void c(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color));
    }

    @RequiresApi(23)
    public static void d(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, null));
    }

    public static void k(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public static void switchTargetView(Player player, @Nullable StyledPlayerView styledPlayerView, @Nullable StyledPlayerView styledPlayerView2) {
        if (styledPlayerView == styledPlayerView2) {
            return;
        }
        if (styledPlayerView2 != null) {
            styledPlayerView2.setPlayer(player);
        }
        if (styledPlayerView != null) {
            styledPlayerView.setPlayer(null);
        }
    }

    public final void b() {
        View view = this.f4923a;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.f4927a;
        if (player != null && player.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zF = f(keyEvent.getKeyCode());
        if (zF && v() && !this.f4930a.isFullyVisible()) {
            h(true);
            return true;
        }
        if (dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            h(true);
            return true;
        }
        if (zF && v()) {
            h(true);
        }
        return false;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return v() && this.f4930a.dispatchMediaKeyEvent(keyEvent);
    }

    public final void e() {
        ImageView imageView = this.f4925a;
        if (imageView != null) {
            imageView.setImageResource(android.R.color.transparent);
            this.f4925a.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    public final boolean f(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public final boolean g() {
        Player player = this.f4927a;
        return player != null && player.isPlayingAd() && this.f4927a.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.ui.AdViewProvider
    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f4938b;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        StyledPlayerControlView styledPlayerControlView = this.f4930a;
        if (styledPlayerControlView != null) {
            arrayList.add(new AdOverlayInfo(styledPlayerControlView, 1));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    @Override // com.google.android.exoplayer2.ui.AdViewProvider
    public ViewGroup getAdViewGroup() {
        return (ViewGroup) sb0.l(this.f4924a, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.e;
    }

    public boolean getControllerHideOnTouch() {
        return this.g;
    }

    public int getControllerShowTimeoutMs() {
        return this.L;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f31074a;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f4938b;
    }

    @Nullable
    public Player getPlayer() {
        return this.f4927a;
    }

    public int getResizeMode() {
        sb0.k(this.f4928a);
        return this.f4928a.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f4934a;
    }

    public boolean getUseArtwork() {
        return this.f4940c;
    }

    public boolean getUseController() {
        return this.f4939b;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.b;
    }

    public final void h(boolean z) {
        if (!(g() && this.f) && v()) {
            boolean z2 = this.f4930a.isFullyVisible() && this.f4930a.getShowTimeoutMs() <= 0;
            boolean zL = l();
            if (z || z2 || zL) {
                m(zL);
            }
        }
    }

    public void hideController() {
        StyledPlayerControlView styledPlayerControlView = this.f4930a;
        if (styledPlayerControlView != null) {
            styledPlayerControlView.hide();
        }
    }

    @RequiresNonNull({"artworkView"})
    public final boolean i(MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.f2109a;
        if (bArr == null) {
            return false;
        }
        return j(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public boolean isControllerFullyVisible() {
        StyledPlayerControlView styledPlayerControlView = this.f4930a;
        return styledPlayerControlView != null && styledPlayerControlView.isFullyVisible();
    }

    @RequiresNonNull({"artworkView"})
    public final boolean j(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(this.f4928a, intrinsicWidth / intrinsicHeight);
                this.f4925a.setImageDrawable(drawable);
                this.f4925a.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        Player player = this.f4927a;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        return this.e && !this.f4927a.a0().w() && (playbackState == 1 || playbackState == 4 || !((Player) sb0.g(this.f4927a)).getPlayWhenReady());
    }

    public final void m(boolean z) {
        if (v()) {
            this.f4930a.setShowTimeoutMs(z ? 0 : this.L);
            this.f4930a.show();
        }
    }

    public final void n() {
        if (!v() || this.f4927a == null) {
            return;
        }
        if (!this.f4930a.isFullyVisible()) {
            h(true);
        } else if (this.g) {
            this.f4930a.hide();
        }
    }

    public final void o() {
        Player player = this.f4927a;
        hp9 hp9VarJ = player != null ? player.j() : hp9.f17050a;
        int i = hp9VarJ.K;
        int i2 = hp9VarJ.L;
        int i3 = hp9VarJ.M;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * hp9VarJ.f17051a) / i2;
        View view = this.b;
        if (view instanceof TextureView) {
            if (f > 0.0f && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            if (this.M != 0) {
                view.removeOnLayoutChangeListener(this.f4933a);
            }
            this.M = i3;
            if (i3 != 0) {
                this.b.addOnLayoutChangeListener(this.f4933a);
            }
            a((TextureView) this.b, this.M);
        }
        onContentAspectRatioChanged(this.f4928a, this.f4937a ? 0.0f : f);
    }

    public void onContentAspectRatioChanged(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public void onPause() {
        View view = this.b;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.b;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!v() || this.f4927a == null) {
            return false;
        }
        h(true);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    public final void p() {
        boolean z;
        if (this.c != null) {
            Player player = this.f4927a;
            if (player == null || player.getPlaybackState() != 2) {
                z = false;
            } else {
                int i = this.K;
                z = true;
                if (i != 2 && (i != 1 || !this.f4927a.getPlayWhenReady())) {
                    z = false;
                }
            }
            this.c.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        n();
        return super.performClick();
    }

    public final void q() {
        StyledPlayerControlView styledPlayerControlView = this.f4930a;
        if (styledPlayerControlView == null || !this.f4939b) {
            setContentDescription(null);
        } else if (styledPlayerControlView.isFullyVisible()) {
            setContentDescription(this.g ? getResources().getString(R.string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R.string.exo_controls_show));
        }
    }

    public final void r() {
        if (g() && this.f) {
            hideController();
        } else {
            h(false);
        }
    }

    public final void s() {
        ErrorMessageProvider<? super PlaybackException> errorMessageProvider;
        TextView textView = this.f4926a;
        if (textView != null) {
            CharSequence charSequence = this.f4936a;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f4926a.setVisibility(0);
                return;
            }
            Player player = this.f4927a;
            PlaybackException playbackExceptionF = player != null ? player.f() : null;
            if (playbackExceptionF == null || (errorMessageProvider = this.f4935a) == null) {
                this.f4926a.setVisibility(8);
            } else {
                this.f4926a.setText((CharSequence) errorMessageProvider.getErrorMessage(playbackExceptionF).second);
                this.f4926a.setVisibility(0);
            }
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        sb0.k(this.f4928a);
        this.f4928a.setAspectRatioListener(aspectRatioListener);
    }

    public void setControllerAutoShow(boolean z) {
        this.e = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.f = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        sb0.k(this.f4930a);
        this.g = z;
        q();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        sb0.k(this.f4930a);
        this.f4932a = null;
        this.f4930a.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    public void setControllerShowTimeoutMs(int i) {
        sb0.k(this.f4930a);
        this.L = i;
        if (this.f4930a.isFullyVisible()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(@Nullable ControllerVisibilityListener controllerVisibilityListener) {
        this.f4931a = controllerVisibilityListener;
        setControllerVisibilityListener((StyledPlayerControlView.VisibilityListener) null);
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        sb0.i(this.f4926a != null);
        this.f4936a = charSequence;
        s();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f31074a != drawable) {
            this.f31074a = drawable;
            t(false);
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.f4935a != errorMessageProvider) {
            this.f4935a = errorMessageProvider;
            s();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        sb0.k(this.f4930a);
        this.f4930a.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setFullscreenButtonClickListener(@Nullable FullscreenButtonClickListener fullscreenButtonClickListener) {
        sb0.k(this.f4930a);
        this.f4932a = fullscreenButtonClickListener;
        this.f4930a.setOnFullScreenModeChangedListener(this.f4933a);
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.d != z) {
            this.d = z;
            t(false);
        }
    }

    public void setPlayer(@Nullable Player player) {
        sb0.i(Looper.myLooper() == Looper.getMainLooper());
        sb0.a(player == null || player.getApplicationLooper() == Looper.getMainLooper());
        Player player2 = this.f4927a;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.V(this.f4933a);
            View view = this.b;
            if (view instanceof TextureView) {
                player2.clearVideoTextureView((TextureView) view);
            } else if (view instanceof SurfaceView) {
                player2.clearVideoSurfaceView((SurfaceView) view);
            }
        }
        SubtitleView subtitleView = this.f4934a;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f4927a = player;
        if (v()) {
            this.f4930a.setPlayer(player);
        }
        p();
        s();
        t(true);
        if (player == null) {
            hideController();
            return;
        }
        if (player.isCommandAvailable(27)) {
            View view2 = this.b;
            if (view2 instanceof TextureView) {
                player.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                player.setVideoSurfaceView((SurfaceView) view2);
            }
            o();
        }
        if (this.f4934a != null && player.isCommandAvailable(28)) {
            this.f4934a.setCues(player.m().f20751a);
        }
        player.u(this.f4933a);
        h(false);
    }

    public void setRepeatToggleModes(int i) {
        sb0.k(this.f4930a);
        this.f4930a.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        sb0.k(this.f4928a);
        this.f4928a.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.K != i) {
            this.K = i;
            p();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowNextButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowShuffleButton(z);
    }

    public void setShowSubtitleButton(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowSubtitleButton(z);
    }

    public void setShowVrButton(boolean z) {
        sb0.k(this.f4930a);
        this.f4930a.setShowVrButton(z);
    }

    public void setShutterBackgroundColor(@ColorInt int i) {
        View view = this.f4923a;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z) {
        sb0.i((z && this.f4925a == null) ? false : true);
        if (this.f4940c != z) {
            this.f4940c = z;
            t(false);
        }
    }

    public void setUseController(boolean z) {
        sb0.i((z && this.f4930a == null) ? false : true);
        setClickable(z || hasOnClickListeners());
        if (this.f4939b == z) {
            return;
        }
        this.f4939b = z;
        if (v()) {
            this.f4930a.setPlayer(this.f4927a);
        } else {
            StyledPlayerControlView styledPlayerControlView = this.f4930a;
            if (styledPlayerControlView != null) {
                styledPlayerControlView.hide();
                this.f4930a.setPlayer(null);
            }
        }
        q();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.b;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void showController() {
        m(l());
    }

    public final void t(boolean z) {
        Player player = this.f4927a;
        if (player == null || player.s().d()) {
            if (this.d) {
                return;
            }
            e();
            b();
            return;
        }
        if (z && !this.d) {
            b();
        }
        if (player.s().e(2)) {
            e();
            return;
        }
        b();
        if (u() && (i(player.h0()) || j(this.f31074a))) {
            return;
        }
        e();
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    public final boolean u() {
        if (!this.f4940c) {
            return false;
        }
        sb0.k(this.f4925a);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    public final boolean v() {
        if (!this.f4939b) {
            return false;
        }
        sb0.k(this.f4930a);
        return true;
    }

    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2;
        boolean z;
        int i3;
        int integer;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        boolean z6;
        boolean z7;
        int i7;
        boolean z8;
        super(context, attributeSet, i);
        a aVar = new a();
        this.f4933a = aVar;
        if (isInEditMode()) {
            this.f4928a = null;
            this.f4923a = null;
            this.b = null;
            this.f4937a = false;
            this.f4925a = null;
            this.f4934a = null;
            this.c = null;
            this.f4926a = null;
            this.f4930a = null;
            this.f4924a = null;
            this.f4938b = null;
            ImageView imageView = new ImageView(context);
            if (gj9.f41922a >= 23) {
                d(getResources(), imageView);
            } else {
                c(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = R.layout.exo_styled_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.StyledPlayerView, i, 0);
            try {
                int i9 = R.styleable.StyledPlayerView_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i9);
                int color = typedArrayObtainStyledAttributes.getColor(i9, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StyledPlayerView_player_layout_id, i8);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StyledPlayerView_default_artwork, 0);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_use_controller, true);
                int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerView_surface_type, 1);
                int i11 = typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerView_resize_mode, 0);
                int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerView_show_timeout, 5000);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_hide_on_touch, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.StyledPlayerView_show_buffering, 0);
                this.d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_keep_content_on_player_reset, this.d);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                z3 = z11;
                z = z12;
                i3 = i11;
                z6 = z10;
                i6 = resourceId2;
                z5 = z9;
                z4 = zHasValue;
                i5 = color;
                i4 = i10;
                i8 = resourceId;
                i2 = i12;
                z2 = z13;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i2 = 5000;
            z = true;
            i3 = 0;
            integer = 0;
            z2 = true;
            z3 = true;
            i4 = 1;
            i5 = 0;
            z4 = false;
            z5 = true;
            i6 = 0;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i8, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        this.f4928a = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            k(aspectRatioFrameLayout, i3);
        }
        View viewFindViewById = findViewById(R.id.exo_shutter);
        this.f4923a = viewFindViewById;
        if (viewFindViewById != null && z4) {
            viewFindViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                this.b = new TextureView(context);
            } else {
                if (i4 == 3) {
                    try {
                        this.b = (View) Class.forName("com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView").getConstructor(Context.class).newInstance(context);
                        z8 = true;
                    } catch (Exception e) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                    }
                } else if (i4 != 4) {
                    this.b = new SurfaceView(context);
                } else {
                    try {
                        this.b = (View) Class.forName("com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView").getConstructor(Context.class).newInstance(context);
                    } catch (Exception e2) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                    }
                }
                this.b.setLayoutParams(layoutParams);
                this.b.setOnClickListener(aVar);
                this.b.setClickable(false);
                aspectRatioFrameLayout.addView(this.b, 0);
                z7 = z8;
            }
            z8 = false;
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(aVar);
            this.b.setClickable(false);
            aspectRatioFrameLayout.addView(this.b, 0);
            z7 = z8;
        } else {
            this.b = null;
            z7 = false;
        }
        this.f4937a = z7;
        this.f4924a = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.f4938b = (FrameLayout) findViewById(R.id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_artwork);
        this.f4925a = imageView2;
        this.f4940c = z5 && imageView2 != null;
        if (i6 != 0) {
            this.f31074a = ContextCompat.getDrawable(getContext(), i6);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.f4934a = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(R.id.exo_buffering);
        this.c = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.K = integer;
        TextView textView = (TextView) findViewById(R.id.exo_error_message);
        this.f4926a = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i13 = R.id.exo_controller;
        StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) findViewById(i13);
        View viewFindViewById3 = findViewById(R.id.exo_controller_placeholder);
        if (styledPlayerControlView != null) {
            this.f4930a = styledPlayerControlView;
            i7 = 0;
        } else if (viewFindViewById3 != null) {
            i7 = 0;
            StyledPlayerControlView styledPlayerControlView2 = new StyledPlayerControlView(context, null, 0, attributeSet);
            this.f4930a = styledPlayerControlView2;
            styledPlayerControlView2.setId(i13);
            styledPlayerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(styledPlayerControlView2, iIndexOfChild);
        } else {
            i7 = 0;
            this.f4930a = null;
        }
        StyledPlayerControlView styledPlayerControlView3 = this.f4930a;
        this.L = styledPlayerControlView3 != null ? i2 : i7;
        this.g = z3;
        this.e = z;
        this.f = z2;
        this.f4939b = (!z6 || styledPlayerControlView3 == null) ? i7 : 1;
        if (styledPlayerControlView3 != null) {
            styledPlayerControlView3.hideImmediately();
            this.f4930a.addVisibilityListener(aVar);
        }
        if (z6) {
            setClickable(true);
        }
        q();
    }

    @Deprecated
    public void setControllerVisibilityListener(@Nullable StyledPlayerControlView.VisibilityListener visibilityListener) {
        sb0.k(this.f4930a);
        StyledPlayerControlView.VisibilityListener visibilityListener2 = this.f4929a;
        if (visibilityListener2 == visibilityListener) {
            return;
        }
        if (visibilityListener2 != null) {
            this.f4930a.removeVisibilityListener(visibilityListener2);
        }
        this.f4929a = visibilityListener;
        if (visibilityListener != null) {
            this.f4930a.addVisibilityListener(visibilityListener);
        }
        setControllerVisibilityListener((ControllerVisibilityListener) null);
    }
}
