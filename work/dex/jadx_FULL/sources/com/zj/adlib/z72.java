package com.zj.adlib;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.d;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class z72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46200a = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextView f20994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExoPlayer f20995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f20996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20997a;

    public final class b implements Player.Listener, Runnable {
        public b() {
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void C(Player.d dVar, Player.d dVar2, int i) {
            z72.this.updateAndPost();
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            z72.this.updateAndPost();
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackStateChanged(int i) {
            z72.this.updateAndPost();
        }

        @Override // java.lang.Runnable
        public void run() {
            z72.this.updateAndPost();
        }
    }

    public z72(ExoPlayer exoPlayer, TextView textView) {
        sb0.a(exoPlayer.getApplicationLooper() == Looper.getMainLooper());
        this.f20995a = exoPlayer;
        this.f20994a = textView;
        this.f20996a = new b();
    }

    public static String a(p82 p82Var) {
        if (p82Var == null) {
            return "";
        }
        p82Var.c();
        return " sib:" + p82Var.d + " sb:" + p82Var.f + " rb:" + p82Var.e + " db:" + p82Var.g + " mcdb:" + p82Var.i + " dk:" + p82Var.j;
    }

    public static String b(float f) {
        if (f == -1.0f || f == 1.0f) {
            return "";
        }
        return " par:" + String.format(Locale.US, "%.02f", Float.valueOf(f));
    }

    public static String c(long j, int i) {
        return i == 0 ? "N/A" : String.valueOf((long) (j / ((double) i)));
    }

    public final void d() {
        if (this.f20997a) {
            return;
        }
        this.f20997a = true;
        this.f20995a.u(this.f20996a);
        updateAndPost();
    }

    public final void e() {
        if (this.f20997a) {
            this.f20997a = false;
            this.f20995a.V(this.f20996a);
            this.f20994a.removeCallbacks(this.f20996a);
        }
    }

    public String getAudioString() {
        d dVarM = this.f20995a.M();
        p82 p82VarR = this.f20995a.r();
        if (dVarM == null || p82VarR == null) {
            return "";
        }
        return "\n" + dVarM.k + "(id:" + dVarM.f + " hz:" + dVarM.V + " ch:" + dVarM.U + a(p82VarR) + ")";
    }

    public String getDebugString() {
        return getPlayerStateString() + getVideoString() + getAudioString();
    }

    public String getPlayerStateString() {
        String str;
        int playbackState = this.f20995a.getPlaybackState();
        if (playbackState == 1) {
            str = "idle";
        } else if (playbackState == 2) {
            str = "buffering";
        } else if (playbackState != 3) {
            str = playbackState != 4 ? "unknown" : "ended";
        } else {
            str = "ready";
        }
        return String.format("playWhenReady:%s playbackState:%s item:%s", Boolean.valueOf(this.f20995a.getPlayWhenReady()), str, Integer.valueOf(this.f20995a.getCurrentMediaItemIndex()));
    }

    public String getVideoString() {
        d dVarF = this.f20995a.F();
        p82 p82VarP = this.f20995a.p();
        if (dVarF == null || p82VarP == null) {
            return "";
        }
        return "\n" + dVarF.k + "(id:" + dVarF.f + " r:" + dVarF.Q + "x" + dVarF.R + b(dVarF.f2571b) + a(p82VarP) + " vfpo: " + c(p82VarP.f18804a, p82VarP.k) + ")";
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateAndPost() {
        this.f20994a.setText(getDebugString());
        this.f20994a.removeCallbacks(this.f20996a);
        this.f20994a.postDelayed(this.f20996a, 1000L);
    }
}
