package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.zj.adlib.fn6;
import com.zj.adlib.qk8;
import com.zj.adlib.xm8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DropBoxHeader extends InternalAbstract implements RefreshHeader {
    protected int mAccentColor;
    protected e mBoxBody;
    protected Drawable mDrawable1;
    protected Drawable mDrawable2;
    protected Drawable mDrawable3;
    protected ValueAnimator mDropOutAnimator;
    protected boolean mDropOutOverFlow;
    protected float mDropOutPercent;
    protected int mHeaderHeight;
    protected Paint mPaint;
    protected Path mPath;
    protected ValueAnimator mReboundAnimator;
    protected float mReboundPercent;
    protected RefreshState mState;
    protected static String[] drawable1Paths = {"M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z"};
    protected static int[] drawable1Colors = {-1249039, -245496};
    protected static String[] drawable2Paths = {"M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z"};
    protected static int[] drawable2Colors = {-76695, -2773417};
    protected static String[] drawable3Paths = {"M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z"};
    protected static int[] drawable3Colors = {-6760607};

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropBoxHeader dropBoxHeader = DropBoxHeader.this;
            dropBoxHeader.mReboundPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            dropBoxHeader.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DropBoxHeader dropBoxHeader = DropBoxHeader.this;
            if (dropBoxHeader.mState != RefreshState.Refreshing) {
                dropBoxHeader.mDropOutPercent = 0.0f;
                return;
            }
            ValueAnimator valueAnimator = dropBoxHeader.mDropOutAnimator;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropBoxHeader dropBoxHeader = DropBoxHeader.this;
            float f = dropBoxHeader.mDropOutPercent;
            if (f < 1.0f || f >= 3.0f) {
                dropBoxHeader.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (f < 2.0f) {
                dropBoxHeader.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
            } else if (f < 3.0f) {
                dropBoxHeader.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                DropBoxHeader dropBoxHeader2 = DropBoxHeader.this;
                if (dropBoxHeader2.mDropOutPercent == 3.0f) {
                    dropBoxHeader2.mDropOutOverFlow = true;
                }
            }
            DropBoxHeader.this.invalidate();
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ValueAnimator valueAnimator = DropBoxHeader.this.mReboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40366a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public e() {
        }

        public e a(int i, int i2, int i3, int i4) {
            this.i = i3;
            int i5 = i / 2;
            this.f40366a = i5;
            int i6 = i2 - i4;
            this.c = i6;
            this.d = i6 - (i3 * 2);
            int iSin = i5 - ((int) (((double) i3) * Math.sin(1.0471975511965976d)));
            this.e = iSin;
            int i7 = i3 / 2;
            this.f = this.d + i7;
            int i8 = this.c;
            this.g = i8 - i7;
            this.h = i - iSin;
            this.b = i8 - i3;
            return this;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public DropBoxHeader(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        e eVarI = i(width, getHeight(), m());
        this.mPaint.setColor(ColorUtils.setAlphaComponent(this.mAccentColor, 150));
        canvas.drawPath(j(eVarI), this.mPaint);
        this.mPaint.setColor(this.mAccentColor);
        canvas.drawPath(k(eVarI), this.mPaint);
        if (isInEditMode()) {
            this.mDropOutPercent = 2.5f;
        }
        if (this.mDropOutPercent > 0.0f) {
            canvas.clipPath(l(eVarI, width));
            float fMin = Math.min(this.mDropOutPercent, 1.0f);
            Rect bounds = this.mDrawable1.getBounds();
            int i = width / 2;
            bounds.offsetTo(i - (bounds.width() / 2), ((int) (((eVarI.b - (bounds.height() / 2)) + bounds.height()) * fMin)) - bounds.height());
            this.mDrawable1.draw(canvas);
            float fMin2 = Math.min(Math.max(this.mDropOutPercent - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.mDrawable2.getBounds();
            bounds2.offsetTo(i - (bounds2.width() / 2), ((int) (((eVarI.b - (bounds2.height() / 2)) + bounds2.height()) * fMin2)) - bounds2.height());
            this.mDrawable2.draw(canvas);
            float fMin3 = Math.min(Math.max(this.mDropOutPercent - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.mDrawable3.getBounds();
            bounds3.offsetTo(i - (bounds3.width() / 2), ((int) (((eVarI.b - (bounds3.height() / 2)) + bounds3.height()) * fMin3)) - bounds3.height());
            this.mDrawable3.draw(canvas);
            if (this.mDropOutOverFlow) {
                bounds.offsetTo(i - (bounds.width() / 2), eVarI.b - (bounds.height() / 2));
                this.mDrawable1.draw(canvas);
                bounds2.offsetTo(i - (bounds2.width() / 2), eVarI.b - (bounds2.height() / 2));
                this.mDrawable2.draw(canvas);
                bounds3.offsetTo(i - (bounds3.width() / 2), eVarI.b - (bounds3.height() / 2));
                this.mDrawable3.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    @NonNull
    public final e i(int i, int i2, int i3) {
        return this.mBoxBody.a(i, i2, i3, i3 / 2);
    }

    @NonNull
    public final Path j(e eVar) {
        this.mPath.reset();
        this.mPath.moveTo(eVar.e, eVar.g);
        this.mPath.lineTo(eVar.f40366a, eVar.c);
        this.mPath.lineTo(eVar.h, eVar.g);
        Path path = this.mPath;
        int i = eVar.h;
        path.quadTo(i + ((eVar.i / 2.0f) * this.mReboundPercent), eVar.b, i, eVar.f);
        this.mPath.lineTo(eVar.f40366a, eVar.d);
        this.mPath.lineTo(eVar.e, eVar.f);
        Path path2 = this.mPath;
        int i2 = eVar.e;
        path2.quadTo(i2 - ((eVar.i / 2.0f) * this.mReboundPercent), eVar.b, i2, eVar.g);
        this.mPath.close();
        return this.mPath;
    }

    @NonNull
    public final Path k(e eVar) {
        this.mPath.reset();
        int i = ((eVar.f40366a - eVar.e) * 4) / 5;
        double d2 = ((double) this.mReboundPercent) * 1.2566370614359172d;
        float f = i;
        double d3 = 1.0471975511965976d - (d2 / 2.0d);
        float fSin = ((float) Math.sin(d3)) * f;
        float fCos = ((float) Math.cos(d3)) * f;
        this.mPath.moveTo(eVar.e, eVar.f);
        this.mPath.lineTo(eVar.f40366a, eVar.d);
        this.mPath.lineTo(eVar.f40366a - fSin, eVar.d - fCos);
        this.mPath.lineTo(eVar.e - fSin, eVar.f - fCos);
        this.mPath.close();
        double d4 = d2 + 1.0471975511965976d;
        float fSin2 = ((float) Math.sin(d4)) * f;
        float fCos2 = ((float) Math.cos(d4)) * f;
        this.mPath.moveTo(eVar.e, eVar.f);
        this.mPath.lineTo(eVar.f40366a, (eVar.c + eVar.d) / 2.0f);
        this.mPath.lineTo(eVar.f40366a - fSin2, ((eVar.c + eVar.d) / 2.0f) + fCos2);
        this.mPath.lineTo(eVar.e - fSin2, eVar.f + fCos2);
        this.mPath.close();
        float fSin3 = ((float) Math.sin(d3)) * f;
        float fCos3 = ((float) Math.cos(d3)) * f;
        this.mPath.moveTo(eVar.h, eVar.f);
        this.mPath.lineTo(eVar.f40366a, eVar.d);
        this.mPath.lineTo(eVar.f40366a + fSin3, eVar.d - fCos3);
        this.mPath.lineTo(eVar.h + fSin3, eVar.f - fCos3);
        this.mPath.close();
        float fSin4 = ((float) Math.sin(d4)) * f;
        float fCos4 = f * ((float) Math.cos(d4));
        this.mPath.moveTo(eVar.h, eVar.f);
        this.mPath.lineTo(eVar.f40366a, (eVar.c + eVar.d) / 2.0f);
        this.mPath.lineTo(eVar.f40366a + fSin4, ((eVar.c + eVar.d) / 2.0f) + fCos4);
        this.mPath.lineTo(eVar.h + fSin4, eVar.f + fCos4);
        this.mPath.close();
        return this.mPath;
    }

    @NonNull
    public final Path l(e eVar, int i) {
        this.mPath.reset();
        this.mPath.lineTo(0.0f, eVar.f);
        this.mPath.lineTo(eVar.e, eVar.f);
        this.mPath.lineTo(eVar.f40366a, eVar.b);
        this.mPath.lineTo(eVar.h, eVar.f);
        float f = i;
        this.mPath.lineTo(f, eVar.f);
        this.mPath.lineTo(f, 0.0f);
        this.mPath.close();
        return this.mPath;
    }

    public final int m() {
        return this.mHeaderHeight / 5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.mReboundAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(accelerateInterpolator);
        this.mReboundAnimator.setDuration(300L);
        this.mReboundAnimator.addUpdateListener(new a());
        this.mReboundAnimator.addListener(new b());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropOutAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(accelerateInterpolator);
        this.mDropOutAnimator.setDuration(300L);
        this.mDropOutAnimator.addUpdateListener(new c());
        this.mDropOutAnimator.addListener(new d());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mReboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mReboundAnimator.removeAllListeners();
            this.mReboundAnimator = null;
        }
        ValueAnimator valueAnimator2 = this.mDropOutAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.mDropOutAnimator.removeAllListeners();
            this.mDropOutAnimator = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mDropOutPercent = 0.0f;
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mHeaderHeight = i;
        int iM = m();
        this.mDrawable1.setBounds(0, 0, iM, iM);
        this.mDrawable2.setBounds(0, 0, iM, iM);
        this.mDrawable3.setBounds(0, 0, iM, iM);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z && this.mState == RefreshState.Refreshing) {
            return;
        }
        this.mReboundPercent = (Math.max(0, i - i2) * 1.0f) / i3;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        ValueAnimator valueAnimator = this.mDropOutAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        this.mState = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.mDropOutOverFlow = false;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.mAccentColor = iArr[1];
            }
        }
    }

    public DropBoxHeader(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropBoxHeader(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mBoxBody = new e(null);
        this.mPaint.setAntiAlias(true);
        this.mAccentColor = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(qk8.d(150.0f));
        this.mSpinnerStyle = xm8.b;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DropBoxHeader);
        int i2 = R.styleable.DropBoxHeader_dhDrawable1;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.mDrawable1 = typedArrayObtainStyledAttributes.getDrawable(i2);
        } else {
            fn6 fn6Var = new fn6();
            fn6Var.e(drawable1Colors);
            if (!fn6Var.f(drawable1Paths)) {
                fn6Var.c(2, 1, 20, 22);
            }
            this.mDrawable1 = fn6Var;
        }
        int i3 = R.styleable.DropBoxHeader_dhDrawable2;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.mDrawable2 = typedArrayObtainStyledAttributes.getDrawable(i3);
        } else {
            fn6 fn6Var2 = new fn6();
            fn6Var2.e(drawable2Colors);
            if (!fn6Var2.f(drawable2Paths)) {
                fn6Var2.c(8, 3, 41, 53);
            }
            this.mDrawable2 = fn6Var2;
        }
        int i4 = R.styleable.DropBoxHeader_dhDrawable3;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.mDrawable3 = typedArrayObtainStyledAttributes.getDrawable(i4);
        } else {
            fn6 fn6Var3 = new fn6();
            fn6Var3.e(drawable3Colors);
            if (!fn6Var3.f(drawable3Paths)) {
                fn6Var3.c(2, 0, 15, 16);
            }
            this.mDrawable3 = fn6Var3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
