package com.byazt.cc;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.s;
import com.byazt.ga.LottieAnimationView;
import com.byazt.nr.zm;
import com.byazt.omf.gt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 1961})
public class SplashClickBarBtn extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f28344a;
    public GradientDrawable c;
    public int d;
    public SlideUpView da;
    public int eo;
    public float gr;
    public int[] gt;
    public com.byazt.hkv.c gu;
    public JSONObject h;
    public SplashClickBarArrow i;
    public final AnimatorSet m;
    public JSONObject md;
    public LinearGradient my;
    public LottieAnimationView n;
    public final ValueAnimator nu;
    public JSONObject p;
    public zm qy;
    public final ValueAnimator rh;
    public boolean rl;
    public RockView sl;
    public RelativeLayout sp;
    public AnimatorSet t;
    public s tt;
    public Path u;
    public TextView uj;
    public TextView ve;
    public LinearLayout x;
    public Rect yp;
    public float yv;
    public Paint z;
    public ic zb;
    public float zm;

    public SplashClickBarBtn(Context context, ic icVar) {
        super(context);
        this.tt = new s();
        this.m = new AnimatorSet();
        this.nu = new ValueAnimator();
        this.rh = new ValueAnimator();
        this.gt = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.rl = false;
        this.gr = 13.0f;
        this.yv = 50.0f;
        this.zb = icVar;
        n();
    }

    private void da() {
        s sVar = this.tt;
        if (sVar == null || sVar.i() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.byazt.cc.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.da == null) {
                    return;
                }
                SplashClickBarBtn.this.da.c();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.da.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.byazt.cc.SplashClickBarBtn.7.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.byazt.cc.SplashClickBarBtn.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                slideUpAnimatorSet.start();
                            }
                        }, 200L);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }, 500L);
    }

    public Animator getAnimator() {
        return this.m;
    }

    public zm getShakeUtils() {
        return this.qy;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
        post(new Runnable() { // from class: com.byazt.cc.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.c();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zm zmVar = this.qy;
        if (zmVar != null) {
            ic icVar = this.zb;
            zmVar.tt(icVar != null ? icVar.eo() : 0);
        }
        AnimatorSet animatorSet = this.t;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.m;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.da;
        if (slideUpView != null) {
            slideUpView.tt();
        }
        LottieAnimationView lottieAnimationView = this.n;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        a();
        super.onDraw(canvas);
        if (this.nu.isRunning()) {
            this.z.setShader(this.my);
            canvas.drawRoundRect(new RectF(this.yp), pf.ve(getContext(), 50.0f), pf.ve(getContext(), 50.0f), this.z);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        zm zmVar = this.qy;
        if (zmVar != null) {
            if (z) {
                ic icVar = this.zb;
                zmVar.c(icVar != null ? icVar.eo() : 0);
            } else {
                ic icVar2 = this.zb;
                zmVar.tt(icVar2 != null ? icVar2.eo() : 0);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.c.setColor(i);
        setBackgroundDrawable(this.c);
    }

    public void setCalculationMethod(int i) {
        this.d = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.eo = i;
    }

    public void setDeepShakeValue(float f) {
        this.zm = f;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.md = jSONObject;
    }

    public void setShakeValue(float f) {
        this.gr = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.p = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public void setWriggleValue(float f) {
        this.yv = f;
    }

    private void a() {
        if (this.rl) {
            return;
        }
        this.rl = true;
        int i = this.tt.i();
        if (i == 1 || i == 2) {
            x();
            sp();
        }
    }

    private void i() {
        if (this.tt != null && isShown()) {
            if (this.tt.i() == 4 || this.tt.i() == 7) {
                if (this.qy == null) {
                    if (this.tt.i() == 4) {
                        this.qy = new zm(gt.getContext(), 1, com.byazt.omf.x.m().uj());
                    } else if (this.tt.i() == 7) {
                        this.qy = new zm(gt.getContext(), 2, com.byazt.omf.x.m().uj());
                    }
                }
                this.qy.c(this.gr);
                this.qy.ve(this.zm);
                this.qy.tt(this.yv);
                this.qy.c(this.p);
                this.qy.ve(this.md);
                this.qy.tt(this.h);
                this.qy.n(this.d);
                this.qy.a(this.eo);
                this.qy.c(new zm.c() { // from class: com.byazt.cc.SplashClickBarBtn.3
                    @Override // com.byazt.nr.zm.c
                    public void c(int i) {
                        if (SplashClickBarBtn.this.gu == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.qy.c() && SplashClickBarBtn.this.zb != null) {
                            com.byazt.yzg.a.uj = true;
                        }
                        if (i == 1) {
                            if (SplashClickBarBtn.this.tt.i() == 4) {
                                ((com.byazt.vis.c) SplashClickBarBtn.this.gu.c(com.byazt.vis.c.class)).c();
                                SplashClickBarBtn.this.gu.onClick(SplashClickBarBtn.this);
                                return;
                            }
                            return;
                        }
                        if (i == 2 && SplashClickBarBtn.this.tt.i() == 7) {
                            ((com.byazt.vis.c) SplashClickBarBtn.this.gu.c(com.byazt.vis.c.class)).tt();
                            SplashClickBarBtn.this.gu.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                zm zmVar = this.qy;
                ic icVar = this.zb;
                zmVar.c(icVar != null ? icVar.eo() : 0);
            }
        }
    }

    private void n() {
        View viewC = c(getContext());
        if (viewC == null) {
            return;
        }
        addView(viewC);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.i = splashClickBarArrow;
        this.f28344a.addView(splashClickBarArrow);
        this.i.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.sp.getId());
        this.c = c(Color.parseColor("#57000000"));
        this.u = new Path();
        Paint paint = new Paint();
        this.z = paint;
        paint.isAntiAlias();
    }

    private void sp() {
        int color = Color.parseColor("#57000000");
        int color2 = Color.parseColor(this.tt.da());
        this.c.setColor(color);
        this.rh.setIntValues(color, color2);
        this.rh.setEvaluator(new ArgbEvaluator());
        this.rh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.cc.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.c.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.c);
            }
        });
        this.rh.setDuration(300L);
        this.rh.setStartDelay(800L);
        this.rh.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.m.playTogether(this.rh);
    }

    private void x() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.u.moveTo(point.x, point.y);
        this.u.lineTo(point2.x, point2.y);
        this.u.lineTo(point3.x, point3.y);
        this.u.lineTo(point4.x, point4.y);
        this.u.close();
        this.yp = getBackground().getBounds();
        final int iVe = pf.ve(getContext(), 36.0f);
        final int iVe2 = pf.ve(getContext(), 45.0f);
        this.nu.setIntValues(point.x - iVe, point2.x + iVe);
        this.nu.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.nu.setDuration(1600L);
        this.nu.setStartDelay(1300L);
        this.nu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.cc.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashClickBarBtn.this.my = new LinearGradient(iIntValue, 0.0f, iIntValue + iVe, iVe2, SplashClickBarBtn.this.gt, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.m.playTogether(this.nu);
    }

    public void tt() {
        if (this.tt.i() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public void uj() {
        if (this.tt.i() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.byazt.cc.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.n != null) {
                        SplashClickBarBtn.this.n.c();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    public void ve() {
        RockView rockView;
        if (this.tt.i() == 4 && (rockView = this.sl) != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
            postDelayed(new Runnable() { // from class: com.byazt.cc.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.sl != null) {
                        SplashClickBarBtn.this.sl.c();
                    }
                }
            }, 500L);
        }
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387577);
        relativeLayout.setLayoutParams(layoutParams);
        this.f28344a = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.f28344a.setId(2114387576);
        this.f28344a.setClipChildren(false);
        layoutParams2.addRule(13);
        this.f28344a.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f28344a);
        this.sl = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.sl.setId(2114387575);
        layoutParams3.addRule(14);
        this.sl.setLayoutParams(layoutParams3);
        pf.c((View) this.sl, 8);
        this.f28344a.addView(this.sl);
        this.sp = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.sp.setId(2114387574);
        this.sp.setClipChildren(false);
        layoutParams4.addRule(13);
        this.sp.setGravity(17);
        this.sp.setLayoutParams(layoutParams4);
        this.f28344a.addView(this.sp);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387573);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.sp.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.n = lottieAnimationView;
        lottieAnimationView.setId(2114387572);
        this.n.setAnimation("lottie_json/twist_multi_angle.json");
        this.n.setImageAssetsFolder("images/");
        this.n.c(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = pf.ve(context, 4.0f);
        layoutParams6.gravity = 17;
        this.n.setLayoutParams(layoutParams6);
        linearLayout.addView(this.n);
        pf.c((View) this.n, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.da = slideUpView;
        slideUpView.setId(2114387569);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = pf.ve(context, -140.0f);
        this.da.setLayoutParams(layoutParams7);
        linearLayout.addView(this.da);
        pf.c((View) this.da, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.x = linearLayout2;
        linearLayout2.setId(2114387573);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.x.setGravity(17);
        this.x.setOrientation(1);
        this.x.setLayoutParams(layoutParams8);
        this.sp.addView(this.x);
        TextView textView = new TextView(context);
        this.uj = textView;
        textView.setId(2114387568);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.uj.setSingleLine();
        this.uj.setText("查看详情");
        this.uj.setTextColor(-1);
        this.uj.setTextSize(20.0f);
        this.uj.setTypeface(Typeface.defaultFromStyle(1));
        this.uj.setLayoutParams(layoutParams9);
        this.x.addView(this.uj);
        pf.c((View) this.uj, 8);
        TextView textView2 = new TextView(context);
        this.ve = textView2;
        textView2.setId(2114387567);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.ve.setShadowLayer(2.0f, 0.0f, 0.5f, 1291845632);
        this.ve.setSingleLine();
        this.ve.setText("查看详情");
        this.ve.setTextColor(-1);
        this.ve.setTextSize(15.0f);
        this.ve.setTypeface(Typeface.defaultFromStyle(1));
        this.ve.setLayoutParams(layoutParams10);
        this.x.addView(this.ve);
        pf.c((View) this.ve, 8);
        return relativeLayout;
    }

    private GradientDrawable c(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(pf.ve(gt.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void c(s sVar) {
        if (sVar == null) {
            return;
        }
        this.tt = sVar;
        if (sVar.i() == 4) {
            this.sl.c(this.tt);
            return;
        }
        TextView textView = this.ve;
        if (textView != null) {
            textView.setVisibility(0);
            this.ve.setText(TextUtils.isEmpty(this.tt.tt()) ? "点击跳转至详情页或第三方应用" : this.tt.tt());
            if (this.tt.t() != null) {
                this.ve.setTextSize(2, this.tt.t().tt());
            }
        }
        if (this.uj != null && this.tt.u() != null) {
            this.uj.setTextSize(2, this.tt.u().tt());
        }
        this.c.setColor(Color.parseColor("#57000000"));
        this.i.c(this.tt.i());
        int i = this.tt.i();
        if (i == 1 || i == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.t = animatorSet;
            animatorSet.playTogether(getAnimator(), this.i.getAnimator());
        } else if (i == 3) {
            TextView textView2 = this.uj;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.uj.setText(this.tt.sl());
            }
            TextView textView3 = this.ve;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.c = c(Color.parseColor(this.tt.da()));
        } else {
            if (i == 4) {
                return;
            }
            if (i == 5) {
                SlideUpView slideUpView = this.da;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.x;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.x.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.uj;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.uj.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.tt.sl())) {
                        this.uj.setText("向上滑动");
                    } else {
                        this.uj.setText(this.tt.sl());
                    }
                }
                TextView textView5 = this.ve;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.tt.tt()) ? "滑动查看详情" : this.tt.tt());
                    this.ve.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            }
            if (i != 7) {
                this.c.setStroke(0, -16777216);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.t = animatorSet2;
                animatorSet2.playTogether(getAnimator(), this.i.getAnimator());
                try {
                    setBackgroundColor(Color.parseColor(this.tt.da()));
                } catch (Throwable unused) {
                    setBackgroundColor(Color.parseColor("#008DEA"));
                }
            } else {
                TextView textView6 = this.uj;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.uj.setText(this.tt.sl());
                    this.uj.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.ve;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.ve.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.n;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        setBackgroundDrawable(this.c);
    }

    public void c() {
        AnimatorSet animatorSet = this.t;
        if (animatorSet != null) {
            animatorSet.start();
        }
        tt();
        ve();
        uj();
        da();
    }

    public void c(com.byazt.hkv.c cVar) {
        this.gu = cVar;
        if (this.tt.i() == 4 || this.tt.i() == 7 || this.tt.i() == 5 || cVar == null) {
            return;
        }
        cVar.c(this);
        setOnClickListener(cVar);
        setOnTouchListener(cVar);
        setId(2114387633);
    }
}
