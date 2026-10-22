package com.scwang.smartrefresh.header.fungame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.header.R;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.zj.adlib.qk8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FunGameView<T extends FunGameView> extends FunGameBase {
    protected static final int STATUS_GAME_FAIL = 4;
    protected static final int STATUS_GAME_FINISHED = 3;
    protected static final int STATUS_GAME_OVER = 2;
    protected static final int STATUS_GAME_PLAY = 1;
    protected static final int STATUS_GAME_PREPARE = 0;
    protected static final float VIEW_HEIGHT_RATIO = 0.161f;
    protected float DIVIDING_LINE_SIZE;
    protected float controllerPosition;
    protected int controllerSize;
    protected int lModelColor;
    protected int mBackColor;
    protected int mBoundaryColor;
    protected int mHalfHeaderHeight;
    public String mMaskTextBottom;
    public String mMaskTextTopPull;
    public String mMaskTextTopRelease;
    protected TextView mMaskViewBottom;
    protected TextView mMaskViewTop;
    protected int mModelColor;
    protected Paint mPaint;
    protected Paint mPaintText;
    protected View mShadowView;
    public String mTextGameOver;
    public String mTextLoading;
    public String mTextLoadingFailed;
    public String mTextLoadingFinish;
    protected int rModelColor;
    protected int status;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40383a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;

        public a(View view, View view2, View view3) {
            this.f40383a = view;
            this.b = view2;
            this.c = view3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f40383a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            FunGameView.this.postStatus(1);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40384a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f40384a = iArr;
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40384a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FunGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DIVIDING_LINE_SIZE = 1.0f;
        this.status = 0;
        this.mBoundaryColor = -10461088;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameView);
        this.mMaskTextBottom = getResources().getString(R.string.fgh_mask_bottom);
        this.mMaskTextTopPull = getResources().getString(R.string.fgh_mask_top_pull);
        this.mMaskTextTopRelease = getResources().getString(R.string.fgh_mask_top_release);
        int i2 = R.styleable.FunGameView_fghMaskTextTop;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            String string = typedArrayObtainStyledAttributes.getString(i2);
            this.mMaskTextTopRelease = string;
            this.mMaskTextTopPull = string;
        }
        int i3 = R.styleable.FunGameView_fghMaskTextTopPull;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.mMaskTextTopPull = typedArrayObtainStyledAttributes.getString(i3);
        }
        int i4 = R.styleable.FunGameView_fghMaskTextTopRelease;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.mMaskTextTopRelease = typedArrayObtainStyledAttributes.getString(i4);
        }
        int i5 = R.styleable.FunGameView_fghMaskTextBottom;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            this.mMaskTextBottom = typedArrayObtainStyledAttributes.getString(i5);
        }
        int iApplyDimension = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int i6 = (iApplyDimension * 14) / 16;
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FunGameView_fghMaskTextSizeTop, iApplyDimension);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FunGameView_fghMaskTextSizeBottom, i6);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.mShadowView = relativeLayout2;
        relativeLayout2.setBackgroundColor(-12961222);
        this.mMaskViewTop = createMaskView(context, this.mMaskTextTopPull, dimensionPixelSize, 80);
        this.mMaskViewBottom = createMaskView(context, this.mMaskTextBottom, dimensionPixelSize2, 48);
        if (!isInEditMode()) {
            int iD = qk8.d(100.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iD);
            addView(this.mShadowView, layoutParams);
            addView(relativeLayout, layoutParams);
            this.mHalfHeaderHeight = (int) (iD * 0.5f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.mHalfHeaderHeight);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.mHalfHeaderHeight);
            layoutParams3.topMargin = iD - this.mHalfHeaderHeight;
            relativeLayout.addView(this.mMaskViewTop, layoutParams2);
            relativeLayout.addView(this.mMaskViewBottom, layoutParams3);
        }
        this.DIVIDING_LINE_SIZE = Math.max(1, qk8.d(0.5f));
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStrokeWidth(this.DIVIDING_LINE_SIZE);
        this.controllerPosition = this.DIVIDING_LINE_SIZE;
        TextPaint textPaint = new TextPaint(1);
        this.mPaintText = textPaint;
        textPaint.setColor(-4078910);
        this.mTextGameOver = context.getString(R.string.fgh_text_game_over);
        this.mTextLoading = context.getString(R.string.fgh_text_loading);
        this.mTextLoadingFinish = context.getString(R.string.fgh_text_loading_finish);
        this.mTextLoadingFailed = context.getString(R.string.fgh_text_loading_failed);
        this.mBackColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FunGameView_fghBackColor, 0);
        this.lModelColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FunGameView_fghLeftColor, -16777216);
        this.mModelColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FunGameView_fghMiddleColor, -16777216);
        this.rModelColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FunGameView_fghRightColor, -5921371);
        int i7 = R.styleable.FunGameView_fghTextGameOver;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            this.mTextGameOver = typedArrayObtainStyledAttributes.getString(i7);
        }
        int i8 = R.styleable.FunGameView_fghTextLoading;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.mTextLoading = typedArrayObtainStyledAttributes.getString(i8);
        }
        int i9 = R.styleable.FunGameView_fghTextLoadingFinished;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.mTextLoadingFinish = typedArrayObtainStyledAttributes.getString(i9);
        }
        int i10 = R.styleable.FunGameView_fghTextLoadingFailed;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.mTextLoadingFailed = typedArrayObtainStyledAttributes.getString(i10);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public TextView createMaskView(Context context, String str, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setTextColor(-16777216);
        textView.setGravity(i2 | 1);
        textView.setTextSize(0, i);
        textView.setText(str);
        textView.setBackgroundColor(-1);
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i = this.mHeaderHeight;
        i(canvas, width, i);
        j(canvas, width, i);
        drawGame(canvas, width, i);
        super.dispatchDraw(canvas);
    }

    public abstract void drawGame(Canvas canvas, int i, int i2);

    public final void i(Canvas canvas, int i, int i2) {
        this.mPaint.setColor(this.mBackColor);
        float f = i;
        float f2 = i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, this.mPaint);
        this.mPaint.setColor(this.mBoundaryColor);
        canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.mPaint);
        float f3 = this.DIVIDING_LINE_SIZE;
        canvas.drawLine(0.0f, f2 - f3, f, f2 - f3, this.mPaint);
    }

    public final void j(Canvas canvas, int i, int i2) {
        int i3 = this.status;
        if (i3 == 0 || i3 == 1) {
            this.mPaintText.setTextSize(qk8.d(25.0f));
            k(canvas, this.mTextLoading, i, i2);
            return;
        }
        if (i3 == 2) {
            this.mPaintText.setTextSize(qk8.d(25.0f));
            k(canvas, this.mTextGameOver, i, i2);
        } else if (i3 == 3) {
            this.mPaintText.setTextSize(qk8.d(20.0f));
            k(canvas, this.mTextLoadingFinish, i, i2);
        } else {
            if (i3 != 4) {
                return;
            }
            this.mPaintText.setTextSize(qk8.d(20.0f));
            k(canvas, this.mTextLoadingFailed, i, i2);
        }
    }

    public final void k(Canvas canvas, String str, int i, int i2) {
        canvas.drawText(str, (i - this.mPaintText.measureText(str)) * 0.5f, (i2 * 0.5f) - ((this.mPaintText.ascent() + this.mPaintText.descent()) * 0.5f), this.mPaintText);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        if (this.mManualOperation) {
            postStatus(z ? 3 : 4);
        } else {
            postStatus(0);
            TextView textView = this.mMaskViewTop;
            TextView textView2 = this.mMaskViewBottom;
            View view = this.mShadowView;
            textView.setTranslationY(textView.getTranslationY() + this.mHalfHeaderHeight);
            textView2.setTranslationY(textView2.getTranslationY() - this.mHalfHeaderHeight);
            view.setAlpha(1.0f);
            textView.setVisibility(0);
            textView2.setVisibility(0);
            view.setVisibility(0);
        }
        return super.onFinish(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        if (this.mHeaderHeight != i && !isInEditMode()) {
            TextView textView = this.mMaskViewTop;
            TextView textView2 = this.mMaskViewBottom;
            this.mHalfHeaderHeight = (int) (i * 0.5f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            int i3 = this.mHalfHeaderHeight;
            layoutParams2.height = i3;
            layoutParams.height = i3;
            layoutParams2.topMargin = i - i3;
            textView.setLayoutParams(layoutParams);
            textView2.setLayoutParams(layoutParams2);
        }
        super.onInitialized(refreshKernel, i, i2);
        postStatus(0);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase
    public void onManualOperationMove(float f, int i, int i2, int i3) {
        float fMax = Math.max(i, 0);
        float f2 = (this.mHeaderHeight - (this.DIVIDING_LINE_SIZE * 2.0f)) - this.controllerSize;
        if (fMax > f2) {
            fMax = f2;
        }
        this.controllerPosition = fMax;
        postInvalidate();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        super.onStartAnimator(refreshLayout, i, i2);
        TextView textView = this.mMaskViewTop;
        View view = this.mShadowView;
        TextView textView2 = this.mMaskViewBottom;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), -this.mHalfHeaderHeight)).with(ObjectAnimator.ofFloat(textView2, "translationY", textView2.getTranslationY(), this.mHalfHeaderHeight)).with(ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 0.0f));
        animatorSet.addListener(new a(textView, textView2, view));
        animatorSet.setDuration(800L);
        animatorSet.setStartDelay(200L);
        animatorSet.start();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        super.onStateChanged(refreshLayout, refreshState, refreshState2);
        int i = b.f40384a[refreshState2.ordinal()];
        if (i == 1) {
            this.mMaskViewTop.setText(this.mMaskTextTopPull);
        } else {
            if (i != 2) {
                return;
            }
            this.mMaskViewTop.setText(this.mMaskTextTopRelease);
        }
    }

    public void postStatus(int i) {
        this.status = i;
        if (i == 0) {
            resetConfigParams();
        }
        postInvalidate();
    }

    public abstract void resetConfigParams();

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.mMaskViewTop.setTextColor(iArr[0]);
            this.mMaskViewBottom.setTextColor(iArr[0]);
            int i = iArr[0];
            this.mBackColor = i;
            this.mBoundaryColor = i;
            if (i == 0 || i == -1) {
                this.mBoundaryColor = -10461088;
            }
            if (iArr.length > 1) {
                TextView textView = this.mMaskViewTop;
                TextView textView2 = this.mMaskViewBottom;
                this.mShadowView.setBackgroundColor(iArr[1]);
                textView.setBackgroundColor(iArr[1]);
                textView2.setBackgroundColor(iArr[1]);
                int i2 = iArr[1];
                this.mModelColor = i2;
                this.lModelColor = ColorUtils.setAlphaComponent(i2, 225);
                this.rModelColor = ColorUtils.setAlphaComponent(iArr[1], 200);
                this.mPaintText.setColor(ColorUtils.setAlphaComponent(iArr[1], 150));
            }
        }
    }
}
