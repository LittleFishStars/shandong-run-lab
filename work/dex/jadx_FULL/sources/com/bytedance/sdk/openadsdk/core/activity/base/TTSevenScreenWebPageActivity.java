package com.bytedance.sdk.openadsdk.core.activity.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.el.SSWebView;
import com.byazt.nr.m;
import com.byazt.ows.BottomGradientHintView;
import com.byazt.ukr.yp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTSevenScreenWebPageActivity extends TTWebPageActivity {
    private int aw;
    private View bm;
    private int hd;
    private int ic;
    private boolean iu;
    private float kk;
    private float l;
    private float lo;
    private FrameLayout lr;
    private GestureDetector lt;
    private long os;
    private float oz;
    private GestureDetector pu;
    private float r;
    private boolean s;
    private int sv;
    private View to;
    private BottomGradientHintView v;
    private boolean y;
    private boolean nb = false;
    private boolean pf = false;
    private boolean bx = false;
    private int tk = 0;
    private Rect kp = new Rect();
    private Rect b = new Rect();
    private Rect q = new Rect();
    private boolean tx = true;

    private void my() {
        if (this.bx || !this.nb) {
            return;
        }
        this.bx = true;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(z(), this.sv);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.tt(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.pf = false;
                TTSevenScreenWebPageActivity.this.bx = false;
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.lo = tTSevenScreenWebPageActivity.sv;
            }
        });
        valueAnimatorOfInt.start();
        c(pf.ve(this, 20.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        this.bx = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (TTSevenScreenWebPageActivity.this.bm != null) {
                    TTSevenScreenWebPageActivity.this.bm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                if (TTSevenScreenWebPageActivity.this.v != null) {
                    TTSevenScreenWebPageActivity.this.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTSevenScreenWebPageActivity.this.bm != null) {
                    TTSevenScreenWebPageActivity.this.bm.setVisibility(8);
                }
                if (TTSevenScreenWebPageActivity.this.v != null) {
                    TTSevenScreenWebPageActivity.this.v.setVisibility(8);
                }
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(z(), this.aw);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.tt(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.nb = false;
                TTSevenScreenWebPageActivity.this.pf = false;
                TTSevenScreenWebPageActivity.this.bx = false;
                TTSevenScreenWebPageActivity.this.finish();
            }
        });
        valueAnimatorOfInt.start();
    }

    private void rh() {
        if (this.bx || this.pf) {
            return;
        }
        this.bx = true;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(z(), 0);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.tt(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.pf = true;
                TTSevenScreenWebPageActivity.this.bx = false;
                TTSevenScreenWebPageActivity.this.lo = 0.0f;
                if (TTSevenScreenWebPageActivity.this.v != null) {
                    TTSevenScreenWebPageActivity.this.v.setVisibility(8);
                }
                TTSevenScreenWebPageActivity.this.c(0.0f);
            }
        });
        valueAnimatorOfInt.start();
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void da() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.cty.BaseLandingPageActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BottomGradientHintView bottomGradientHintView = this.v;
        if (bottomGradientHintView != null) {
            bottomGradientHintView.tt();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity
    public int sl() {
        return -1;
    }

    private void m() {
        this.bx = true;
        this.bm.setVisibility(0);
        this.v.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (TTSevenScreenWebPageActivity.this.bm != null) {
                    TTSevenScreenWebPageActivity.this.bm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                if (TTSevenScreenWebPageActivity.this.v != null) {
                    TTSevenScreenWebPageActivity.this.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTSevenScreenWebPageActivity.this.v != null) {
                    TTSevenScreenWebPageActivity.this.v.c();
                }
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.aw, this.sv);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.tt(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.nb = true;
                TTSevenScreenWebPageActivity.this.bx = false;
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.lo = tTSevenScreenWebPageActivity.sv;
                if (TTSevenScreenWebPageActivity.this.v != null) {
                    TTSevenScreenWebPageActivity.this.v.setVisibility(0);
                }
            }
        });
        valueAnimatorOfInt.start();
        c(pf.ve(this, 20.0f));
    }

    private void u() {
        int i = getResources().getDisplayMetrics().heightPixels;
        this.aw = i;
        this.ic = i;
        this.sv = (int) (i * 0.3f);
        this.hd = pf.ve(this, 55.0f);
        this.tk = pf.ve(this, 44.0f);
    }

    private void yp() {
        this.pu = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.12
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!TTSevenScreenWebPageActivity.this.nb || TTSevenScreenWebPageActivity.this.bx) {
                    return false;
                }
                TTSevenScreenWebPageActivity.this.nu();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (!TTSevenScreenWebPageActivity.this.nb || TTSevenScreenWebPageActivity.this.bx) {
                    return false;
                }
                TTSevenScreenWebPageActivity.this.nu();
                return true;
            }
        });
        this.lt = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.17
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!TTSevenScreenWebPageActivity.this.nb || TTSevenScreenWebPageActivity.this.bx) {
                    return true;
                }
                TTSevenScreenWebPageActivity.this.l = motionEvent.getY();
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.lo = tTSevenScreenWebPageActivity.z();
                return true;
            }
        });
        this.bm.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.nb) {
                    return TTSevenScreenWebPageActivity.this.pu.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        this.to.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.nb) {
                    return TTSevenScreenWebPageActivity.this.lt.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        SSWebView sSWebView = this.qy;
        if (sSWebView != null) {
            sSWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.20
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTSevenScreenWebPageActivity.this.nb && !TTSevenScreenWebPageActivity.this.pf && !TTSevenScreenWebPageActivity.this.s && !TTSevenScreenWebPageActivity.this.y && !TTSevenScreenWebPageActivity.this.iu) {
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action != 1) {
                                if (action == 2) {
                                    return true;
                                }
                                if (action != 3) {
                                    return false;
                                }
                            }
                            long jCurrentTimeMillis = System.currentTimeMillis() - TTSevenScreenWebPageActivity.this.os;
                            float fAbs = Math.abs(motionEvent.getX() - TTSevenScreenWebPageActivity.this.oz);
                            float fAbs2 = Math.abs(motionEvent.getY() - TTSevenScreenWebPageActivity.this.r);
                            int iVe = pf.ve(TTSevenScreenWebPageActivity.this.n, 5.0f);
                            if (jCurrentTimeMillis < 200) {
                                float f = iVe;
                                if (fAbs < f && fAbs2 < f) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        TTSevenScreenWebPageActivity.this.os = System.currentTimeMillis();
                        TTSevenScreenWebPageActivity.this.oz = motionEvent.getX();
                        TTSevenScreenWebPageActivity.this.r = motionEvent.getY();
                    }
                    return false;
                }
            });
            this.qy.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.21
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    TTSevenScreenWebPageActivity.this.tx = i2 == 0;
                }
            });
        }
        ImageView imageView = this.yp;
        if (imageView != null) {
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.22
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
        ImageView imageView2 = this.z;
        if (imageView2 != null) {
            imageView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.23
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
        TextView textView = this.nu;
        if (textView != null) {
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z() {
        try {
            return ((FrameLayout.LayoutParams) this.to.getLayoutParams()).topMargin;
        } catch (Exception e) {
            yp.c().c("sc_getContainerTop", e);
            return (int) this.lo;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.cty.BaseLandingPageActivity
    public void a() {
        super.a();
        yp();
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.cty.BaseLandingPageActivity
    public View sp() {
        u();
        this.to = super.sp();
        FrameLayout frameLayout = new FrameLayout(this);
        this.lr = frameLayout;
        if (this.to == null) {
            m.ve("mSevenScreenContainer is null");
            yp.c().c("sc_finish", (Throwable) null);
            finish();
            return this.lr;
        }
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bm = new View(this);
        this.bm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bm.setBackgroundColor(Integer.MIN_VALUE);
        this.bm.setAlpha(0.0f);
        this.bm.setVisibility(8);
        this.lr.addView(this.bm);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = this.sv;
        this.to.setLayoutParams(layoutParams);
        this.to.setBackgroundColor(-1);
        this.lr.addView(this.to);
        return this.lr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity
    public LinearLayout t() {
        return new LinearLayout(this.n) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.1
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return TTSevenScreenWebPageActivity.this.ve(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.bx || !TTSevenScreenWebPageActivity.this.nb || TTSevenScreenWebPageActivity.this.s || TTSevenScreenWebPageActivity.this.y || TTSevenScreenWebPageActivity.this.iu) {
                    return false;
                }
                return TTSevenScreenWebPageActivity.this.uj(motionEvent) || super.onTouchEvent(motionEvent);
            }
        };
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public boolean x() {
        if (!super.x()) {
            nu();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.cty.BaseLandingPageActivity
    public void n() {
        super.n();
        this.v = new BottomGradientHintView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, pf.ve(this, 80.0f));
        layoutParams.gravity = 80;
        this.v.setVisibility(8);
        this.v.setAlpha(0.0f);
        this.lr.addView(this.v, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uj(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                tt((int) Math.min(Math.max(this.lo + (motionEvent.getY() - this.l), 0.0f), this.aw));
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        int iZ = z();
        if (!this.pf) {
            int i = iZ - this.sv;
            if (i > this.hd) {
                nu();
                return true;
            }
            if (Math.abs(i) > this.hd) {
                rh();
                return true;
            }
            my();
            return true;
        }
        if (iZ > this.hd) {
            my();
            return true;
        }
        this.pf = false;
        rh();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ve(MotionEvent motionEvent) {
        ImageView imageView = this.yp;
        if (imageView != null) {
            imageView.getHitRect(this.kp);
        }
        ImageView imageView2 = this.z;
        if (imageView2 != null) {
            imageView2.getHitRect(this.b);
        }
        TextView textView = this.nu;
        if (textView != null) {
            textView.getHitRect(this.q);
        }
        this.s = this.kp.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.y = this.b.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        boolean zContains = this.q.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.iu = zContains;
        if (this.s || this.y || zContains || this.bx || !this.nb) {
            return false;
        }
        return this.pf ? c(motionEvent) : tt(motionEvent);
    }

    private boolean tt(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.os = System.currentTimeMillis();
            this.oz = motionEvent.getX();
            this.r = motionEvent.getY();
            this.l = motionEvent.getY();
            this.kk = 0.0f;
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.oz);
            float fAbs2 = Math.abs(motionEvent.getY() - this.r);
            float fVe = pf.ve(this.n, 5.0f);
            if (fAbs > fVe || fAbs2 > fVe) {
                z = true;
            }
        }
        BottomGradientHintView bottomGradientHintView = this.v;
        if (bottomGradientHintView != null && bottomGradientHintView.getVisibility() == 0) {
            this.v.setVisibility(8);
        }
        return z;
    }

    private boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.l = motionEvent.getY();
            this.kk = 0.0f;
            return false;
        }
        if (action != 2) {
            return false;
        }
        float y = motionEvent.getY() - this.l;
        this.kk = y;
        return this.tx && y > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final float f) {
        View view = this.to;
        if (view != null) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.14
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            this.to.setClipToOutline(true);
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void ve() {
        super.ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i) {
        View view = this.to;
        if (view == null) {
            return;
        }
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            this.to.setLayoutParams(layoutParams);
            this.lo = i;
        } catch (Exception e) {
            yp.c().c("sc_updateContainerTop", e);
        }
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void uj() {
        c("detail_skip");
        nu();
    }
}
