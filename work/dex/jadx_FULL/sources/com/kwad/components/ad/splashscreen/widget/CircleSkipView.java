package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class CircleSkipView extends KSFrameLayout implements b {
    private float La;
    private float Lb;
    private int Lc;
    private ValueAnimator Ld;
    private boolean Le;
    private SkipView.a Lf;
    private long Lg;
    private float Lh;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;
    private boolean wV;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void O(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        af(context);
        addView(ag(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.Lf != null) {
                    CircleSkipView.this.Lf.mA();
                }
            }
        });
    }

    private void af(Context context) {
        this.Lc = com.kwad.sdk.c.a.a.a(context, 2.0f);
        int iA = com.kwad.sdk.c.a.a.a(context, 32.0f);
        int i = this.Lc;
        this.radius = iA - i;
        this.padding = i / 2;
        int i2 = this.padding;
        int i3 = this.radius;
        this.mRectF = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    private static TextView ag(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i) {
        SkipView.a aVar = this.Lf;
        if (aVar != null) {
            aVar.ay(i);
        }
    }

    private void nR() {
        this.Le = true;
        ValueAnimator valueAnimator = this.Ld;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.Lg);
            this.Ld.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nS() {
        this.Le = false;
        ValueAnimator valueAnimator = this.Ld;
        if (valueAnimator != null) {
            this.Lg = valueAnimator.getCurrentPlayTime();
            this.Ld.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Lc);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Lc);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // java.lang.Runnable
            public final void run() {
                CircleSkipView.this.nS();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void C(AdInfo adInfo) {
        nR();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int aA(int i) {
        getLayoutParams().height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void cw() {
        nS();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, fMin - this.Lc, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.Le) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.La, -this.Lb, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(SkipView.a aVar) {
        this.Lf = aVar;
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.La = 270.0f;
        this.Lb = 360.0f;
        this.radius = 0;
        this.Lc = 0;
        this.Le = false;
        this.Lg = 0L;
        this.Lh = 0.0f;
        this.padding = 0;
        this.wV = true;
        O(context);
    }

    private void c(final int i, final boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Ld = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(i);
        this.Ld.setInterpolator(new LinearInterpolator());
        this.Ld.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.Lh != 1.0f || CircleSkipView.this.Lf == null) {
                    return;
                }
                CircleSkipView.this.Lf.mB();
            }
        });
        this.Ld.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.Lh = fFloatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.ax((int) ((i / 1000) * circleSkipView.Lh));
                if (z) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f = fFloatValue * 360.0f;
                    CircleSkipView.this.La = 270.0f - f;
                    CircleSkipView.this.Lb = 360.0f - f;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.Le = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.wV = com.kwad.sdk.core.response.helper.a.cK(adInfo);
        boolean zCL = com.kwad.sdk.core.response.helper.a.cL(adInfo);
        if (this.wV) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, zCL);
    }
}
