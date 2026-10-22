package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.zj.adlib.qk8;
import com.zj.adlib.xm8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class WaveSwipeHeader extends InternalAbstract implements RefreshHeader {
    protected static final float MAX_PROGRESS_ROTATION_RATE = 0.8f;
    protected ProgressAnimationImageView mCircleView;
    protected float mLastFirstBounds;
    protected MaterialProgressDrawable mProgress;
    protected RefreshState mState;
    protected WaveView mWaveView;

    public class ProgressAnimationImageView extends ImageView {
        protected Animation.AnimationListener mListener;

        public ProgressAnimationImageView(Context context) {
            super(context);
            MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(WaveSwipeHeader.this);
            WaveSwipeHeader.this.mProgress = materialProgressDrawable;
            materialProgressDrawable.e(0);
            if (WaveSwipeHeader.isOver600dp()) {
                WaveSwipeHeader.this.mProgress.n(0);
            }
            super.setImageDrawable(WaveSwipeHeader.this.mProgress);
        }

        @Override // android.view.View
        public void onAnimationEnd() {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }

        @Override // android.view.View
        public void onAnimationStart() {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        public void setAnimationListener(Animation.AnimationListener animationListener) {
            this.mListener = animationListener;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SECOND' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class VERTICAL_DRAG_THRESHOLD {
        private static final /* synthetic */ VERTICAL_DRAG_THRESHOLD[] $VALUES;
        public static final VERTICAL_DRAG_THRESHOLD FIRST;
        public static final VERTICAL_DRAG_THRESHOLD SECOND;
        public static final VERTICAL_DRAG_THRESHOLD THIRD;
        final float val;

        static {
            VERTICAL_DRAG_THRESHOLD vertical_drag_threshold = new VERTICAL_DRAG_THRESHOLD("FIRST", 0, 0.1f);
            FIRST = vertical_drag_threshold;
            VERTICAL_DRAG_THRESHOLD vertical_drag_threshold2 = new VERTICAL_DRAG_THRESHOLD("SECOND", 1, vertical_drag_threshold.val + 0.16f);
            SECOND = vertical_drag_threshold2;
            VERTICAL_DRAG_THRESHOLD vertical_drag_threshold3 = new VERTICAL_DRAG_THRESHOLD("THIRD", 2, vertical_drag_threshold.val + 0.5f);
            THIRD = vertical_drag_threshold3;
            $VALUES = new VERTICAL_DRAG_THRESHOLD[]{vertical_drag_threshold, vertical_drag_threshold2, vertical_drag_threshold3};
        }

        private VERTICAL_DRAG_THRESHOLD(String str, int i, float f) {
            super(str, i);
            this.val = f;
        }

        public static VERTICAL_DRAG_THRESHOLD valueOf(String str) {
            return (VERTICAL_DRAG_THRESHOLD) Enum.valueOf(VERTICAL_DRAG_THRESHOLD.class, str);
        }

        public static VERTICAL_DRAG_THRESHOLD[] values() {
            return (VERTICAL_DRAG_THRESHOLD[]) $VALUES.clone();
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveSwipeHeader waveSwipeHeader = WaveSwipeHeader.this;
            ProgressAnimationImageView progressAnimationImageView = waveSwipeHeader.mCircleView;
            progressAnimationImageView.setTranslationY(waveSwipeHeader.mWaveView.getCurrentCircleCenterY() + (progressAnimationImageView.getHeight() / 2.0f));
        }
    }

    public class b extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40380a;

        public b(View view) {
            this.f40380a = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            float f2 = 1.0f - f;
            this.f40380a.setScaleX(f2);
            this.f40380a.setScaleY(f2);
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WaveSwipeHeader.this.mProgress.stop();
            WaveSwipeHeader.this.mProgress.setAlpha(255);
            WaveSwipeHeader.this.mWaveView.startDisappearCircleAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40382a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f40382a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40382a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40382a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40382a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40382a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WaveSwipeHeader(Context context) {
        this(context, null);
    }

    public static boolean isOver600dp() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        b bVar = new b(progressAnimationImageView);
        bVar.setDuration(200L);
        this.mCircleView.setAnimationListener(new c());
        progressAnimationImageView.clearAnimation();
        progressAnimationImageView.startAnimation(bVar);
        return 0;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WaveView waveView = this.mWaveView;
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        waveView.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = progressAnimationImageView.getMeasuredWidth();
        progressAnimationImageView.layout((measuredWidth - measuredWidth2) / 2, -progressAnimationImageView.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            onMoving(true, 0.99f, qk8.d(99.0f), qk8.d(100.0f), qk8.d(100.0f));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        WaveView waveView = this.mWaveView;
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mProgress.getIntrinsicWidth(), 1073741824);
        progressAnimationImageView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        waveView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        float f2;
        if (!z) {
            if (this.mLastFirstBounds == 0.0f || this.mState != RefreshState.None) {
                return;
            }
            this.mProgress.l(false);
            this.mProgress.g(0.0f);
            this.mProgress.j(0.0f, 0.0f);
            this.mWaveView.startWaveAnimation(this.mLastFirstBounds);
            this.mLastFirstBounds = 0.0f;
            return;
        }
        if (this.mState == RefreshState.Refreshing) {
            return;
        }
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        float fMax = (((float) Math.max(((double) Math.min(1.0f, f)) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        if (f > 3.0f) {
            f2 = 2.0f;
        } else {
            f2 = f > 1.0f ? f - 1.0f : 0.0f;
        }
        float f3 = ((4.0f - f2) * f2) / 8.0f;
        if (f < 1.0f) {
            this.mProgress.j(0.0f, Math.min(0.8f, fMax * 0.8f));
            this.mProgress.d(Math.min(1.0f, fMax));
        }
        this.mProgress.g((((fMax * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
        progressAnimationImageView.setTranslationY(this.mWaveView.getCurrentCircleCenterY());
        float fMin = (i * 1.0f) / Math.min(getMeasuredWidth(), getMeasuredHeight());
        float f4 = (fMin * (5.0f - (2.0f * fMin))) / 3.5f;
        float f5 = VERTICAL_DRAG_THRESHOLD.FIRST.val;
        float f6 = f4 - f5;
        float f7 = VERTICAL_DRAG_THRESHOLD.SECOND.val;
        float f8 = (f4 - f7) / 5.0f;
        this.mLastFirstBounds = f4;
        if (f4 < f5) {
            this.mWaveView.beginPhase(f4);
        } else if (f4 < f7) {
            this.mWaveView.appearPhase(f4, f6);
        } else {
            this.mWaveView.expandPhase(f4, f6, f8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mLastFirstBounds = 0.0f;
        this.mWaveView.animationDropCircle();
        this.mProgress.setAlpha(255);
        this.mProgress.start();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new a());
        valueAnimatorOfFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ProgressAnimationImageView progressAnimationImageView = this.mCircleView;
        this.mState = refreshState2;
        int i = d.f40382a[refreshState2.ordinal()];
        if (i == 2) {
            this.mProgress.l(true);
            progressAnimationImageView.setScaleX(1.0f);
            progressAnimationImageView.setScaleY(1.0f);
            this.mProgress.setAlpha(255);
            return;
        }
        if (i != 3) {
            return;
        }
        this.mProgress.l(false);
        this.mProgress.g(0.0f);
        this.mProgress.j(0.0f, 0.0f);
        this.mWaveView.startWaveAnimation(this.mLastFirstBounds);
        this.mLastFirstBounds = 0.0f;
    }

    public void setColorSchemeColorIds(@IdRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(context, iArr[1]);
        }
        this.mProgress.f(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mProgress.f(iArr);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.mWaveView.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.mProgress.f(iArr[1]);
            }
        }
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpinnerStyle = xm8.e;
        WaveView waveView = new WaveView(context);
        this.mWaveView = waveView;
        addView(waveView);
        ProgressAnimationImageView progressAnimationImageView = new ProgressAnimationImageView(context);
        this.mCircleView = progressAnimationImageView;
        addView(progressAnimationImageView);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveSwipeHeader);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.mWaveView.setWaveColor(color);
        }
        if (color2 != 0) {
            this.mProgress.f(color2);
        } else {
            this.mProgress.f(-1);
        }
        int i2 = R.styleable.WaveSwipeHeader_wshShadowRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.mWaveView.setShadow(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i2, 0), typedArrayObtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshShadowColor, -16777216));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
