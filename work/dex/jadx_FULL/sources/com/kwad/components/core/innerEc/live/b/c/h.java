package com.kwad.components.core.innerEc.live.b.c;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.innerEc.live.like.LikeResponse;
import com.kwad.components.core.innerEc.live.widget.PhotoSpeedControlFrameLayout;
import com.kwad.sdk.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h extends com.kwad.components.core.innerEc.live.b.a.a implements com.kwad.components.core.k.a {
    private RelativeLayout WF;
    private PhotoSpeedControlFrameLayout WG;
    private com.kwad.components.core.innerEc.live.widget.d WH;
    private GestureDetector.SimpleOnGestureListener WI;
    private long WJ;
    private boolean WK;
    private com.kwad.components.core.innerEc.live.like.b WL;
    private Runnable WP;
    private final List<Integer> WE = new ArrayList();
    private long WM = 1000;
    private int WN = 0;
    private final Handler WO = new Handler(Looper.getMainLooper());
    private volatile boolean WQ = false;
    private final Object WR = new Object();
    private final Runnable WS = new Runnable() { // from class: com.kwad.components.core.innerEc.live.b.c.h.1
        @Override // java.lang.Runnable
        public final void run() {
            h.this.WH.J(com.kwad.components.core.innerEc.live.widget.d.Yo);
        }
    };
    private final com.kwad.components.core.k.a WT = new com.kwad.components.core.k.a() { // from class: com.kwad.components.core.innerEc.live.b.c.h.2
    };
    private final com.kwad.components.core.innerEc.live.like.b.a WU = new com.kwad.components.core.innerEc.live.like.b.a() { // from class: com.kwad.components.core.innerEc.live.b.c.h.5
        @Override // com.kwad.components.core.innerEc.live.like.b.a
        public final void a(LikeResponse likeResponse) {
            h.this.WM = likeResponse.likeIntervalMs;
            synchronized (h.this.WR) {
                h.a(h.this, false);
                if (h.this.WN > 0) {
                    h.this.sv();
                }
            }
        }

        @Override // com.kwad.components.core.innerEc.live.like.b.a
        public final void sz() {
            synchronized (h.this.WR) {
                h.a(h.this, false);
            }
        }
    };

    private void f(float f, float f2) {
        com.kwad.sdk.core.d.c.d("LiveLikePresenter", "playLikeImageViewAnimator: " + f + ", " + f2);
        com.kwad.components.core.innerEc.live.base.a aVar = this.Ub.UA;
        if (aVar != null) {
            aVar.c(f, f2);
        }
        com.kwad.components.core.innerEc.live.a.e eVar = this.Ub.UT;
        if (eVar != null) {
            eVar.a(new com.kwad.sdk.core.b() { // from class: com.kwad.components.core.innerEc.live.b.c.h.7
                @Override // com.kwad.sdk.core.b
                public final void parseJson(@Nullable JSONObject jSONObject) {
                }

                @Override // com.kwad.sdk.core.b
                public final JSONObject toJson() {
                    return new JSONObject();
                }
            });
        }
    }

    private void sp() {
        this.Ub.UB.add(this.WT);
    }

    private void sq() {
        this.WF.removeCallbacks(this.WS);
        this.WH.J(com.kwad.components.core.innerEc.live.widget.d.Yo);
        this.Ub.UB.remove(this.WT);
        RelativeLayout relativeLayout = this.WF;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    private void sr() {
        if (this.WI == null) {
            this.WI = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.components.core.innerEc.live.b.c.h.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public final boolean onDoubleTap(MotionEvent motionEvent) {
                    return h.this.onDoubleTap(motionEvent);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return super.onSingleTapConfirmed(motionEvent);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    h.this.onSingleTapUp(motionEvent);
                    return super.onSingleTapUp(motionEvent);
                }
            };
        }
    }

    private void ss() {
        this.WP = new Runnable() { // from class: com.kwad.components.core.innerEc.live.b.c.h.4
            @Override // java.lang.Runnable
            public final void run() {
                h.this.sw();
            }
        };
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void st() {
        if (this.WH == null) {
            if (this.WI == null) {
                sr();
            }
            this.WH = new com.kwad.components.core.innerEc.live.widget.d(getContext(), this.WI) { // from class: com.kwad.components.core.innerEc.live.b.c.h.6
                @Override // com.kwad.components.core.innerEc.live.widget.d, android.view.GestureDetector
                public final boolean onTouchEvent(MotionEvent motionEvent) {
                    return motionEvent.getActionMasked() == 6 ? h.this.g(motionEvent) : super.onTouchEvent(motionEvent);
                }
            };
        }
    }

    private void su() {
        synchronized (this.WR) {
            this.WN++;
            if (!this.WQ) {
                sv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv() {
        this.WO.removeCallbacks(this.WP);
        this.WO.postDelayed(this.WP, this.WM);
        this.WQ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw() {
        synchronized (this.WR) {
            int i = this.WN;
            if (i <= 0) {
                this.WQ = false;
            } else {
                this.WN = 0;
                this.WL.aZ(i);
            }
        }
    }

    private void sx() {
        Runnable runnable = this.WP;
        if (runnable != null) {
            this.WO.removeCallbacks(runnable);
        }
        synchronized (this.WR) {
            if (this.WN > 0) {
                sw();
            }
            this.WQ = false;
        }
    }

    private boolean sy() {
        return SystemClock.elapsedRealtime() - this.WJ < ((long) ViewConfiguration.getJumpTapTimeout());
    }

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.WG.a(this.WH);
        this.WF.setVisibility(0);
        com.kwad.components.core.innerEc.live.like.b bVar = new com.kwad.components.core.innerEc.live.like.b(this.Ub.mAdTemplate);
        this.WL = bVar;
        bVar.a(this.WU);
        sp();
    }

    public final boolean g(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (sy()) {
            return e(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.WF = (RelativeLayout) findViewById(R.id.ksad_slide_play_like_image);
        this.WG = (PhotoSpeedControlFrameLayout) findViewById(R.id.ksad_video_container);
        sr();
        for (int i = -15; i < 15; i++) {
            this.WE.add(Integer.valueOf(i));
        }
        this.WG.setClickable(true);
        st();
        ss();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        RelativeLayout relativeLayout = this.WF;
        if (relativeLayout != null) {
            relativeLayout.removeCallbacks(this.WS);
        }
        sx();
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        this.WJ = SystemClock.elapsedRealtime();
        if (this.WK) {
            return true;
        }
        d(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (sy()) {
            return e(motionEvent.getX(), motionEvent.getY());
        }
        this.WK = false;
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    @SuppressLint({"ClickableViewAccessibility"})
    public final void onUnbind() {
        super.onUnbind();
        getRootView().setOnTouchListener(null);
        this.WF.setOnTouchListener(null);
        this.WG.b(this.WH);
        this.Ub.UB.remove(this.WT);
        this.WL.b(this.WU);
        sx();
        sq();
    }

    private boolean d(float f, float f2) {
        this.WH.J(500L);
        this.WF.removeCallbacks(this.WS);
        this.WF.postDelayed(this.WS, 500L);
        com.kwad.components.core.innerEc.live.b.a.b bVar = this.Ub;
        if (bVar.UU) {
            f(f, f2);
            su();
        } else {
            bVar.UU = true;
        }
        return true;
    }

    private boolean e(float f, float f2) {
        this.WJ = SystemClock.elapsedRealtime();
        this.WK = true;
        return d(f, f2);
    }

    public static /* synthetic */ boolean a(h hVar, boolean z) {
        hVar.WQ = false;
        return false;
    }
}
