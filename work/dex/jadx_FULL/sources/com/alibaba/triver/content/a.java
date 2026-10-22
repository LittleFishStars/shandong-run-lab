package com.alibaba.triver.content;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24804a;
    private float b;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;
    private float l;
    private int m;
    private boolean n;
    private InterfaceC0161a o;

    /* JADX INFO: renamed from: com.alibaba.triver.content.a$a, reason: collision with other inner class name */
    public interface InterfaceC0161a {
        void a(View view);

        void a(View view, int i);

        void b(View view);

        void c(View view);

        void d(View view);
    }

    public a(@NonNull Context context) {
        super(context);
        this.f24804a = false;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        setOnTouchListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        try {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                this.f = windowManager.getDefaultDisplay().getWidth();
                this.g = windowManager.getDefaultDisplay().getHeight();
            } else {
                ViewGroup viewGroup = (ViewGroup) getParent();
                this.f = viewGroup.getMeasuredWidth();
                this.g = viewGroup.getMeasuredHeight();
            }
            this.h = this.f / 2;
            this.k = getMeasuredWidth();
            float measuredHeight = getMeasuredHeight();
            this.l = measuredHeight;
            this.j = (int) ((this.g - this.i) - measuredHeight);
        } catch (Exception e) {
            Log.e("MovingView", "onLayout get screen width error", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x008c A[PHI: r10
      0x008c: PHI (r10v19 int) = (r10v17 int), (r10v18 int) binds: [B:40:0x008a, B:43:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f;
        float f2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f24804a = false;
            this.b = motionEvent.getRawX();
            this.c = motionEvent.getRawY();
            setAlpha(0.8f);
        } else if (action == 1) {
            setAlpha(1.0f);
            if (!this.n) {
                if (this.f24804a) {
                    InterfaceC0161a interfaceC0161a = this.o;
                    if (interfaceC0161a != null) {
                        interfaceC0161a.d(this);
                    }
                    float f3 = this.d;
                    if (f3 > this.h) {
                        f = this.f - this.k;
                        this.m = 1;
                    } else {
                        this.m = 0;
                        f = 0.0f;
                    }
                    float f4 = f;
                    float f5 = this.e;
                    int i = this.i;
                    if (f5 < i) {
                        f2 = i;
                    } else {
                        i = this.j;
                        if (f5 > i) {
                            f2 = i;
                        } else {
                            f2 = f5;
                        }
                    }
                    a(this.m, f3, f4, f5, f2);
                    this.f24804a = false;
                } else {
                    InterfaceC0161a interfaceC0161a2 = this.o;
                    if (interfaceC0161a2 != null) {
                        interfaceC0161a2.a(this, this.m);
                        this.o.b(view);
                    }
                }
            }
        } else if (action == 2 && !this.f24804a) {
            if (Math.abs(motionEvent.getRawY() - this.c) > 20.0f || Math.abs(motionEvent.getRawX() - this.b) > 20.0f) {
                this.f24804a = true;
                InterfaceC0161a interfaceC0161a3 = this.o;
                if (interfaceC0161a3 != null) {
                    interfaceC0161a3.c(this);
                }
                setAlpha(1.0f);
            }
        }
        if (!this.f24804a) {
            return false;
        }
        this.d = motionEvent.getRawX() - (this.k / 2.0f);
        this.e = motionEvent.getRawY() - (this.l / 2.0f);
        setX(this.d);
        setY(this.e);
        return true;
    }

    public void setDefaultDirection(int i) {
        this.m = i;
    }

    public void setListener(InterfaceC0161a interfaceC0161a) {
        this.o = interfaceC0161a;
    }

    public void setSuckedOffsetY(int i) {
        this.i = i;
        int i2 = this.g;
        if (i2 > 0) {
            float f = this.l;
            if (f > 0.0f) {
                this.j = (int) ((i2 - i) - f);
            }
        }
    }

    private void a(final int i, float f, float f2, float f3, float f4) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "x", f, f2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "y", f3, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.alibaba.triver.content.a.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.o != null) {
                    a.this.o.a(a.this, i);
                }
                a.this.n = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (a.this.o != null) {
                    a.this.o.a(a.this);
                }
                a.this.n = true;
            }
        });
        animatorSet.setDuration(200L);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.start();
    }
}
