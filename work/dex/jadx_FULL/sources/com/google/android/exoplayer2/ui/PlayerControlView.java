package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.zj.adlib.ab3;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    public static final int N = 1000;
    public int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f31058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f4757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final View f4758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ImageView f4759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TextView f4760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Player f4761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f4762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f4763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ProgressUpdateListener f4764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f4765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TimeBar f4766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f4768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Formatter f4769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArrayList<VisibilityListener> f4770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f4772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f4773a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f4774b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Drawable f4775b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final View f4776b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final ImageView f4777b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final TextView f4778b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f4779b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4780b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long[] f4781b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean[] f4782b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Drawable f4783c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final View f4784c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4785c;
    public long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Drawable f4786d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public final View f4787d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4788d;
    public final Drawable e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    public final View f4789e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4790e;

    @Nullable
    public final View f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final String f4791f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4792f;

    @Nullable
    public final View g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final String f4793g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4794g;
    public final String h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4795h;
    public final String i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4796i;
    public final String j;

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    public interface VisibilityListener {
        void e(int i);
    }

    @RequiresApi(21)
    public static final class b {
        @DoNotInline
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    public final class c implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void e(TimeBar timeBar, long j) {
            PlayerControlView.this.f4788d = true;
            if (PlayerControlView.this.f4778b != null) {
                PlayerControlView.this.f4778b.setText(gj9.s0(PlayerControlView.this.f4768a, PlayerControlView.this.f4769a, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void k(TimeBar timeBar, long j, boolean z) {
            PlayerControlView.this.f4788d = false;
            if (z || PlayerControlView.this.f4761a == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.l(playerControlView.f4761a, j);
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void l(TimeBar timeBar, long j) {
            if (PlayerControlView.this.f4778b != null) {
                PlayerControlView.this.f4778b.setText(gj9.s0(PlayerControlView.this.f4768a, PlayerControlView.this.f4769a, j));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Player player = PlayerControlView.this.f4761a;
            if (player == null) {
                return;
            }
            if (PlayerControlView.this.f4776b == view) {
                player.seekToNext();
                return;
            }
            if (PlayerControlView.this.f4758a == view) {
                player.seekToPrevious();
                return;
            }
            if (PlayerControlView.this.f4789e == view) {
                if (player.getPlaybackState() != 4) {
                    player.seekForward();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f == view) {
                player.seekBack();
                return;
            }
            if (PlayerControlView.this.f4784c == view) {
                PlayerControlView.this.d(player);
                return;
            }
            if (PlayerControlView.this.f4787d == view) {
                PlayerControlView.this.c(player);
            } else if (PlayerControlView.this.f4759a == view) {
                player.setRepeatMode(RepeatModeUtil.a(player.getRepeatMode(), PlayerControlView.this.M));
            } else if (PlayerControlView.this.f4777b == view) {
                player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void t(Player player, Player.c cVar) {
            if (cVar.b(4, 5)) {
                PlayerControlView.this.q();
            }
            if (cVar.b(4, 5, 7)) {
                PlayerControlView.this.r();
            }
            if (cVar.a(8)) {
                PlayerControlView.this.s();
            }
            if (cVar.a(9)) {
                PlayerControlView.this.t();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                PlayerControlView.this.p();
            }
            if (cVar.b(11, 0)) {
                PlayerControlView.this.u();
            }
        }
    }

    static {
        ab3.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public static boolean b(Timeline timeline, Timeline.d dVar) {
        if (timeline.v() > 100) {
            return false;
        }
        int iV = timeline.v();
        for (int i = 0; i < iV; i++) {
            if (timeline.t(i, dVar).f2209e == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public static int f(TypedArray typedArray, int i) {
        return typedArray.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, i);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean h(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    public void addVisibilityListener(VisibilityListener visibilityListener) {
        sb0.g(visibilityListener);
        this.f4770a.add(visibilityListener);
    }

    public final void c(Player player) {
        player.pause();
    }

    public final void d(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            player.prepare();
        } else if (playbackState == 4) {
            k(player, player.getCurrentMediaItemIndex(), -9223372036854775807L);
        }
        player.play();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.f4761a;
        if (player == null || !h(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            player.seekForward();
            return true;
        }
        if (keyCode == 89) {
            player.seekBack();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            e(player);
            return true;
        }
        if (keyCode == 87) {
            player.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            player.seekToPrevious();
            return true;
        }
        if (keyCode == 126) {
            d(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        c(player);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f4779b);
        } else if (motionEvent.getAction() == 1) {
            g();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.getPlayWhenReady()) {
            d(player);
        } else {
            c(player);
        }
    }

    public final void g() {
        removeCallbacks(this.f4779b);
        if (this.K <= 0) {
            this.f4756a = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.K;
        this.f4756a = jUptimeMillis + ((long) i);
        if (this.f4771a) {
            postDelayed(this.f4779b, i);
        }
    }

    @Nullable
    public Player getPlayer() {
        return this.f4761a;
    }

    public int getRepeatToggleModes() {
        return this.M;
    }

    public boolean getShowShuffleButton() {
        return this.f4796i;
    }

    public int getShowTimeoutMs() {
        return this.K;
    }

    public boolean getShowVrButton() {
        View view = this.g;
        return view != null && view.getVisibility() == 0;
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator<VisibilityListener> it = this.f4770a.iterator();
            while (it.hasNext()) {
                it.next().e(getVisibility());
            }
            removeCallbacks(this.f4767a);
            removeCallbacks(this.f4779b);
            this.f4756a = -9223372036854775807L;
        }
    }

    public final void i() {
        View view;
        View view2;
        boolean zM = m();
        if (!zM && (view2 = this.f4784c) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zM || (view = this.f4787d) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public final void j() {
        View view;
        View view2;
        boolean zM = m();
        if (!zM && (view2 = this.f4784c) != null) {
            view2.requestFocus();
        } else {
            if (!zM || (view = this.f4787d) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    public final void k(Player player, int i, long j) {
        player.seekTo(i, j);
    }

    public final void l(Player player, long j) {
        int currentMediaItemIndex;
        Timeline timelineA0 = player.a0();
        if (this.f4785c && !timelineA0.w()) {
            int iV = timelineA0.v();
            currentMediaItemIndex = 0;
            while (true) {
                long jG = timelineA0.t(currentMediaItemIndex, this.f4763a).g();
                if (j < jG) {
                    break;
                }
                if (currentMediaItemIndex == iV - 1) {
                    j = jG;
                    break;
                } else {
                    j -= jG;
                    currentMediaItemIndex++;
                }
            }
        } else {
            currentMediaItemIndex = player.getCurrentMediaItemIndex();
        }
        k(player, currentMediaItemIndex, j);
        r();
    }

    public final boolean m() {
        Player player = this.f4761a;
        return (player == null || player.getPlaybackState() == 4 || this.f4761a.getPlaybackState() == 1 || !this.f4761a.getPlayWhenReady()) ? false : true;
    }

    public final void n() {
        q();
        p();
        s();
        t();
        u();
    }

    public final void o(boolean z, boolean z2, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.f31058a : this.b);
        view.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4771a = true;
        long j = this.f4756a;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.f4779b, jUptimeMillis);
            }
        } else if (isVisible()) {
            g();
        }
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4771a = false;
        removeCallbacks(this.f4767a);
        removeCallbacks(this.f4779b);
    }

    public final void p() {
        boolean zIsCommandAvailable;
        boolean zIsCommandAvailable2;
        boolean zIsCommandAvailable3;
        boolean zIsCommandAvailable4;
        boolean zIsCommandAvailable5;
        if (isVisible() && this.f4771a) {
            Player player = this.f4761a;
            if (player != null) {
                zIsCommandAvailable = player.isCommandAvailable(5);
                zIsCommandAvailable3 = player.isCommandAvailable(7);
                zIsCommandAvailable4 = player.isCommandAvailable(11);
                zIsCommandAvailable5 = player.isCommandAvailable(12);
                zIsCommandAvailable2 = player.isCommandAvailable(9);
            } else {
                zIsCommandAvailable = false;
                zIsCommandAvailable2 = false;
                zIsCommandAvailable3 = false;
                zIsCommandAvailable4 = false;
                zIsCommandAvailable5 = false;
            }
            o(this.f4794g, zIsCommandAvailable3, this.f4758a);
            o(this.f4790e, zIsCommandAvailable4, this.f);
            o(this.f4792f, zIsCommandAvailable5, this.f4789e);
            o(this.f4795h, zIsCommandAvailable2, this.f4776b);
            TimeBar timeBar = this.f4766a;
            if (timeBar != null) {
                timeBar.setEnabled(zIsCommandAvailable);
            }
        }
    }

    public final void q() {
        boolean z;
        boolean z2;
        boolean z3;
        if (isVisible() && this.f4771a) {
            boolean zM = m();
            View view = this.f4784c;
            boolean z4 = true;
            if (view != null) {
                z = (zM && view.isFocused()) | false;
                if (gj9.f41922a < 21) {
                    z3 = z;
                } else {
                    z3 = zM && b.a(this.f4784c);
                }
                z2 = z3 | false;
                this.f4784c.setVisibility(zM ? 8 : 0);
            } else {
                z = false;
                z2 = false;
            }
            View view2 = this.f4787d;
            if (view2 != null) {
                z |= !zM && view2.isFocused();
                if (gj9.f41922a < 21) {
                    z4 = z;
                } else if (zM || !b.a(this.f4787d)) {
                    z4 = false;
                }
                z2 |= z4;
                this.f4787d.setVisibility(zM ? 0 : 8);
            }
            if (z) {
                j();
            }
            if (z2) {
                i();
            }
        }
    }

    public final void r() {
        long contentPosition;
        long contentBufferedPosition;
        if (isVisible() && this.f4771a) {
            Player player = this.f4761a;
            if (player != null) {
                contentPosition = this.f4774b + player.getContentPosition();
                contentBufferedPosition = this.f4774b + player.getContentBufferedPosition();
            } else {
                contentPosition = 0;
                contentBufferedPosition = 0;
            }
            boolean z = contentPosition != this.c;
            boolean z2 = contentBufferedPosition != this.d;
            this.c = contentPosition;
            this.d = contentBufferedPosition;
            TextView textView = this.f4778b;
            if (textView != null && !this.f4788d && z) {
                textView.setText(gj9.s0(this.f4768a, this.f4769a, contentPosition));
            }
            TimeBar timeBar = this.f4766a;
            if (timeBar != null) {
                timeBar.setPosition(contentPosition);
                this.f4766a.setBufferedPosition(contentBufferedPosition);
            }
            ProgressUpdateListener progressUpdateListener = this.f4764a;
            if (progressUpdateListener != null && (z || z2)) {
                progressUpdateListener.onProgressUpdate(contentPosition, contentBufferedPosition);
            }
            removeCallbacks(this.f4767a);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f4767a, 1000L);
                return;
            }
            TimeBar timeBar2 = this.f4766a;
            long jMin = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f = player.b().f3399a;
            postDelayed(this.f4767a, gj9.t(f > 0.0f ? (long) (jMin / f) : 1000L, this.L, 1000L));
        }
    }

    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.f4770a.remove(visibilityListener);
    }

    public final void s() {
        ImageView imageView;
        if (isVisible() && this.f4771a && (imageView = this.f4759a) != null) {
            if (this.M == 0) {
                o(false, false, imageView);
                return;
            }
            Player player = this.f4761a;
            if (player == null) {
                o(true, false, imageView);
                this.f4759a.setImageDrawable(this.f4757a);
                this.f4759a.setContentDescription(this.f4791f);
                return;
            }
            o(true, true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f4759a.setImageDrawable(this.f4757a);
                this.f4759a.setContentDescription(this.f4791f);
            } else if (repeatMode == 1) {
                this.f4759a.setImageDrawable(this.f4775b);
                this.f4759a.setContentDescription(this.f4793g);
            } else if (repeatMode == 2) {
                this.f4759a.setImageDrawable(this.f4783c);
                this.f4759a.setContentDescription(this.h);
            }
            this.f4759a.setVisibility(0);
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f4781b = new long[0];
            this.f4782b = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) sb0.g(zArr);
            sb0.a(jArr.length == zArr2.length);
            this.f4781b = jArr;
            this.f4782b = zArr2;
        }
        u();
    }

    public void setPlayer(@Nullable Player player) {
        boolean z = true;
        sb0.i(Looper.myLooper() == Looper.getMainLooper());
        if (player != null && player.getApplicationLooper() != Looper.getMainLooper()) {
            z = false;
        }
        sb0.a(z);
        Player player2 = this.f4761a;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.V(this.f4765a);
        }
        this.f4761a = player;
        if (player != null) {
            player.u(this.f4765a);
        }
        n();
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.f4764a = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i) {
        this.M = i;
        Player player = this.f4761a;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.f4761a.setRepeatMode(0);
            } else if (i == 1 && repeatMode == 2) {
                this.f4761a.setRepeatMode(1);
            } else if (i == 2 && repeatMode == 1) {
                this.f4761a.setRepeatMode(2);
            }
        }
        s();
    }

    public void setShowFastForwardButton(boolean z) {
        this.f4792f = z;
        p();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.f4780b = z;
        u();
    }

    public void setShowNextButton(boolean z) {
        this.f4795h = z;
        p();
    }

    public void setShowPreviousButton(boolean z) {
        this.f4794g = z;
        p();
    }

    public void setShowRewindButton(boolean z) {
        this.f4790e = z;
        p();
    }

    public void setShowShuffleButton(boolean z) {
        this.f4796i = z;
        t();
    }

    public void setShowTimeoutMs(int i) {
        this.K = i;
        if (isVisible()) {
            g();
        }
    }

    public void setShowVrButton(boolean z) {
        View view = this.g;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.L = gj9.s(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.g;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            o(getShowVrButton(), onClickListener != null, this.g);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator<VisibilityListener> it = this.f4770a.iterator();
            while (it.hasNext()) {
                it.next().e(getVisibility());
            }
            n();
            j();
            i();
        }
        g();
    }

    public final void t() {
        ImageView imageView;
        if (isVisible() && this.f4771a && (imageView = this.f4777b) != null) {
            Player player = this.f4761a;
            if (!this.f4796i) {
                o(false, false, imageView);
                return;
            }
            if (player == null) {
                o(true, false, imageView);
                this.f4777b.setImageDrawable(this.e);
                this.f4777b.setContentDescription(this.j);
            } else {
                o(true, true, imageView);
                this.f4777b.setImageDrawable(player.getShuffleModeEnabled() ? this.f4786d : this.e);
                this.f4777b.setContentDescription(player.getShuffleModeEnabled() ? this.i : this.j);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4 A[SYNTHETIC] */
    public final void u() {
        int i;
        Timeline.d dVar;
        long jS;
        long[] jArr;
        int length;
        Player player = this.f4761a;
        if (player == null) {
            return;
        }
        boolean z = true;
        this.f4785c = this.f4780b && b(player.a0(), this.f4763a);
        long j = 0;
        this.f4774b = 0L;
        Timeline timelineA0 = player.a0();
        if (timelineA0.w()) {
            i = 0;
        } else {
            int currentMediaItemIndex = player.getCurrentMediaItemIndex();
            boolean z2 = this.f4785c;
            int i2 = z2 ? 0 : currentMediaItemIndex;
            int iV = z2 ? timelineA0.v() - 1 : currentMediaItemIndex;
            long j2 = 0;
            i = 0;
            while (i2 <= iV) {
                if (i2 == currentMediaItemIndex) {
                    this.f4774b = gj9.H1(j2);
                }
                timelineA0.t(i2, this.f4763a);
                Timeline.d dVar2 = this.f4763a;
                if (dVar2.f2209e == -9223372036854775807L) {
                    sb0.i(this.f4785c ^ z);
                    break;
                }
                int i3 = dVar2.K;
                while (true) {
                    dVar = this.f4763a;
                    if (i3 <= dVar.L) {
                        timelineA0.j(i3, this.f4762a);
                        int iF = this.f4762a.f();
                        for (int iT = this.f4762a.t(); iT < iF; iT++) {
                            long jI = this.f4762a.i(iT);
                            if (jI == Long.MIN_VALUE) {
                                long j3 = this.f4762a.f2190a;
                                if (j3 != -9223372036854775807L) {
                                    jI = j3;
                                    jS = jI + this.f4762a.s();
                                    if (jS >= 0) {
                                        jArr = this.f4772a;
                                        if (i == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.f4772a = Arrays.copyOf(jArr, length);
                                            this.f4773a = Arrays.copyOf(this.f4773a, length);
                                        }
                                        this.f4772a[i] = gj9.H1(j2 + jS);
                                        this.f4773a[i] = this.f4762a.u(iT);
                                        i++;
                                    }
                                }
                            } else {
                                jS = jI + this.f4762a.s();
                                if (jS >= 0) {
                                    jArr = this.f4772a;
                                    if (i == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.f4772a = Arrays.copyOf(jArr, length);
                                        this.f4773a = Arrays.copyOf(this.f4773a, length);
                                    }
                                    this.f4772a[i] = gj9.H1(j2 + jS);
                                    this.f4773a[i] = this.f4762a.u(iT);
                                    i++;
                                }
                            }
                        }
                        i3++;
                    }
                }
                j2 += dVar.f2209e;
                i2++;
                z = true;
            }
            j = j2;
        }
        long jH1 = gj9.H1(j);
        TextView textView = this.f4760a;
        if (textView != null) {
            textView.setText(gj9.s0(this.f4768a, this.f4769a, jH1));
        }
        TimeBar timeBar = this.f4766a;
        if (timeBar != null) {
            timeBar.setDuration(jH1);
            int length2 = this.f4781b.length;
            int i4 = i + length2;
            long[] jArr2 = this.f4772a;
            if (i4 > jArr2.length) {
                this.f4772a = Arrays.copyOf(jArr2, i4);
                this.f4773a = Arrays.copyOf(this.f4773a, i4);
            }
            System.arraycopy(this.f4781b, 0, this.f4772a, i, length2);
            System.arraycopy(this.f4782b, 0, this.f4773a, i, length2);
            this.f4766a.setAdGroupTimesMs(this.f4772a, this.f4773a, i4);
        }
        r();
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int resourceId = R.layout.exo_player_control_view;
        this.K = 5000;
        this.M = 0;
        this.L = 200;
        this.f4756a = -9223372036854775807L;
        this.f4790e = true;
        this.f4792f = true;
        this.f4794g = true;
        this.f4795h = true;
        this.f4796i = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlayerControlView, i, 0);
            try {
                this.K = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_show_timeout, this.K);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_controller_layout_id, resourceId);
                this.M = f(typedArrayObtainStyledAttributes, this.M);
                this.f4790e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_rewind_button, this.f4790e);
                this.f4792f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_fastforward_button, this.f4792f);
                this.f4794g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_previous_button, this.f4794g);
                this.f4795h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_next_button, this.f4795h);
                this.f4796i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_shuffle_button, this.f4796i);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_time_bar_min_update_interval, this.L));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f4770a = new CopyOnWriteArrayList<>();
        this.f4762a = new Timeline.b();
        this.f4763a = new Timeline.d();
        StringBuilder sb = new StringBuilder();
        this.f4768a = sb;
        this.f4769a = new Formatter(sb, Locale.getDefault());
        this.f4772a = new long[0];
        this.f4773a = new boolean[0];
        this.f4781b = new long[0];
        this.f4782b = new boolean[0];
        c cVar = new c();
        this.f4765a = cVar;
        this.f4767a = new Runnable() { // from class: com.zj.adlib.ys6
            @Override // java.lang.Runnable
            public final void run() {
                this.f46108a.r();
            }
        };
        this.f4779b = new Runnable() { // from class: com.zj.adlib.zs6
            @Override // java.lang.Runnable
            public final void run() {
                this.f46333a.hide();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i2 = R.id.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i2);
        View viewFindViewById = findViewById(R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.f4766a = timeBar;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i2);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f4766a = defaultTimeBar;
        } else {
            this.f4766a = null;
        }
        this.f4760a = (TextView) findViewById(R.id.exo_duration);
        this.f4778b = (TextView) findViewById(R.id.exo_position);
        TimeBar timeBar2 = this.f4766a;
        if (timeBar2 != null) {
            timeBar2.addListener(cVar);
        }
        View viewFindViewById2 = findViewById(R.id.exo_play);
        this.f4784c = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R.id.exo_pause);
        this.f4787d = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R.id.exo_prev);
        this.f4758a = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R.id.exo_next);
        this.f4776b = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R.id.exo_rew);
        this.f = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R.id.exo_ffwd);
        this.f4789e = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.f4759a = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_shuffle);
        this.f4777b = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R.id.exo_vr);
        this.g = viewFindViewById8;
        setShowVrButton(false);
        o(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.f31058a = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.b = resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f4757a = resources.getDrawable(R.drawable.exo_controls_repeat_off);
        this.f4775b = resources.getDrawable(R.drawable.exo_controls_repeat_one);
        this.f4783c = resources.getDrawable(R.drawable.exo_controls_repeat_all);
        this.f4786d = resources.getDrawable(R.drawable.exo_controls_shuffle_on);
        this.e = resources.getDrawable(R.drawable.exo_controls_shuffle_off);
        this.f4791f = resources.getString(R.string.exo_controls_repeat_off_description);
        this.f4793g = resources.getString(R.string.exo_controls_repeat_one_description);
        this.h = resources.getString(R.string.exo_controls_repeat_all_description);
        this.i = resources.getString(R.string.exo_controls_shuffle_on_description);
        this.j = resources.getString(R.string.exo_controls_shuffle_off_description);
        this.c = -9223372036854775807L;
        this.d = -9223372036854775807L;
    }
}
