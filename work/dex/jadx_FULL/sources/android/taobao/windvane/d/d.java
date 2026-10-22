package android.taobao.windvane.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.taobao.windvane.view.AbstractNaviBar;
import android.taobao.windvane.view.WebErrorView;
import android.taobao.windvane.view.WebWaitingView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huachenjie.shandong_school.splash.SplashActivity;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class d {
    private LinearLayout e;
    private View f;
    private Context g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f21208a = null;
    private View b = null;
    private AbstractNaviBar c = null;
    private TextView d = null;
    private boolean h = false;
    private boolean i = true;
    private AtomicBoolean j = new AtomicBoolean(false);
    private boolean k = false;

    public d(Context context, View view) {
        this.g = context;
        this.f = view;
        this.e = new LinearLayout(context);
    }

    public boolean c() {
        return this.h;
    }

    public void d() {
        if (this.f21208a == null) {
            WebWaitingView webWaitingView = new WebWaitingView(this.g);
            this.f21208a = webWaitingView;
            a(webWaitingView);
        }
        this.f21208a.bringToFront();
        if (this.f21208a.getVisibility() != 0) {
            this.f21208a.setVisibility(0);
        }
    }

    public void e() {
        View view = this.f21208a;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.f21208a.setVisibility(8);
    }

    public void f() {
        if (this.b == null) {
            WebErrorView webErrorView = new WebErrorView(this.g);
            this.b = webErrorView;
            b(webErrorView);
        }
        this.e.bringToFront();
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
            this.k = true;
        }
    }

    public void g() {
        LinearLayout linearLayout = this.e;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.e.setVisibility(8);
        this.k = false;
    }

    public boolean h() {
        return this.k;
    }

    public View i() {
        if (this.b == null) {
            b(new WebErrorView(this.g));
        }
        return this.b;
    }

    public void j() {
        AbstractNaviBar abstractNaviBar = this.c;
        if (abstractNaviBar != null) {
            abstractNaviBar.a();
        }
    }

    public void k() {
        AbstractNaviBar abstractNaviBar = this.c;
        if (abstractNaviBar == null || abstractNaviBar.getVisibility() == 8) {
            return;
        }
        this.c.setVisibility(8);
    }

    public void b() {
        this.h = false;
    }

    public void b(View view) {
        if (view == null || !this.j.compareAndSet(false, true)) {
            return;
        }
        this.b = view;
        this.e.setVisibility(8);
        ViewParent parent = this.b.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.b);
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(14, 1);
        }
        this.e.addView(this.b, layoutParams);
        this.e.setBackgroundColor(-1);
        this.e.setAlpha(1.0f);
        ViewParent parent2 = this.f.getParent();
        if (parent2 != null) {
            try {
                if (this.e.getParent() == null) {
                    ((ViewGroup) parent2).addView(this.e, layoutParams);
                }
                this.j.set(false);
            } catch (Exception unused) {
                ViewParent parent3 = parent2.getParent();
                if (parent3 != null && this.e.getParent() == null) {
                    ((ViewGroup) parent3).addView(this.e, layoutParams);
                }
                this.j.set(false);
            }
        }
    }

    public void a() {
        this.h = true;
    }

    public void a(View view) {
        if (view != null) {
            this.f21208a = view;
            view.setVisibility(8);
            ViewParent parent = this.f21208a.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f21208a);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, 1);
            ViewParent parent2 = this.f.getParent();
            if (parent2 != null) {
                try {
                    ((ViewGroup) parent2).addView(this.f21208a, layoutParams);
                } catch (Exception unused) {
                    ViewParent parent3 = parent2.getParent();
                    if (parent3 != null) {
                        ((ViewGroup) parent3).addView(this.f21208a, layoutParams);
                    }
                }
            }
        }
    }

    public void a(AbstractNaviBar abstractNaviBar) {
        AbstractNaviBar abstractNaviBar2 = this.c;
        if (abstractNaviBar2 != null) {
            abstractNaviBar2.setVisibility(8);
            this.c = null;
        }
        if (abstractNaviBar != null) {
            this.c = abstractNaviBar;
        }
    }

    public void a(int i) {
        AbstractNaviBar abstractNaviBar = this.c;
        if (abstractNaviBar == null || i != 1) {
            return;
        }
        abstractNaviBar.b();
    }

    public void a(Drawable drawable, String str, int i) {
        TextView textView = this.d;
        if (textView == null || (str != null && !str.equals(textView.getText()))) {
            b(drawable, str, i);
        }
        this.d.bringToFront();
        this.d.setTranslationY(0.0f);
        float f = -i;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "translationY", f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        final ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat);
        animatorSet.play(objectAnimatorOfFloat2).after(SplashActivity.f36053a);
        objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: android.taobao.windvane.d.d.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (d.this.d != null) {
                    ViewParent parent = d.this.d.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(d.this.d);
                    }
                    d.this.d = null;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.d != null) {
                    ViewParent parent = d.this.d.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(d.this.d);
                    }
                    d.this.d = null;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
        this.d.setOnClickListener(new View.OnClickListener() { // from class: android.taobao.windvane.d.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.i) {
                    animatorSet.cancel();
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.play(objectAnimatorOfFloat2);
                    animatorSet2.start();
                    d.this.i = false;
                }
            }
        });
    }

    private void b(Drawable drawable, String str, int i) {
        TextView textView = new TextView(this.g);
        this.d = textView;
        textView.setTextColor(Color.parseColor("#666666"));
        this.d.setBackgroundColor(Color.parseColor("#ffe7b3"));
        this.d.setText(str);
        this.d.setTextAlignment(4);
        this.d.setGravity(16);
        ViewParent parent = this.d.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.d);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.d.setCompoundDrawables(drawable, null, null, null);
            int i2 = i / 10;
            this.d.setCompoundDrawablePadding(i2);
            this.d.setPadding(i2, 0, 0, 0);
        }
        try {
            this.d.setElevation(2.0f);
        } catch (Throwable unused) {
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, i);
        ViewParent parent2 = this.f.getParent();
        if (parent2 != null) {
            try {
                ((ViewGroup) parent2).addView(this.d, layoutParams);
            } catch (Exception unused2) {
                ViewParent parent3 = parent2.getParent();
                if (parent3 != null) {
                    ((ViewGroup) parent3).addView(this.d, layoutParams);
                }
            }
        }
    }
}
