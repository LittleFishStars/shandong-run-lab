package com.fl.saas.adx.base.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.fl.saas.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SuppressLint({"AppCompatCustomView"})
public class DownloadProgressTextView extends TextView {
    public static final float SCALE = 1.0f;
    public static final int STATE_DOWNLOADING = 1;
    public static final int STATE_FINISH = 3;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PAUSE = 2;
    public static final int STYLE_BALL_JUMP = 2;
    public static final int STYLE_BALL_PULSE = 1;
    private ArrayList<ValueAnimator> mAnimators;
    private RectF mBackgroundBounds;
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private int mBackgroundSecondColor;
    private float mBallRadius;
    private float mBallSpacing;
    private int mBallStyle;
    private float mBorderWidth;
    private float mButtonRadius;
    private CharSequence mCurrentText;
    private int mMaxProgress;
    private int mMinProgress;
    private float mProgress;
    private ValueAnimator mProgressAnimation;
    private float mProgressPercent;
    private LinearGradient mProgressTextGradient;
    private int mState;
    private float mTextBottomBorder;
    private int mTextColor;
    private int mTextCoverColor;
    private volatile Paint mTextPaint;
    private float mTextRightBorder;
    private float mToProgress;
    private float[] scaleFloats;
    private boolean showBorder;
    private float[] translateYFloats;

    public DownloadProgressTextView(Context context) {
        this(context, null);
    }

    private ArrayList<ValueAnimator> createBallJumpAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {70, 140, 210};
        for (final int i = 0; i < 3; i++) {
            float f = this.mTextBottomBorder;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f - (this.mBallRadius * 2.0f), f);
            valueAnimatorOfFloat.setDuration(600L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i]);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fl.saas.adx.base.widget.DownloadProgressTextView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DownloadProgressTextView.this.translateYFloats[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    DownloadProgressTextView.this.postInvalidate();
                }
            });
            arrayList.add(valueAnimatorOfFloat);
        }
        return arrayList;
    }

    private ArrayList<ValueAnimator> createBallPulseAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (final int i = 0; i < 3; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            valueAnimatorOfFloat.setDuration(750L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i]);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fl.saas.adx.base.widget.DownloadProgressTextView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DownloadProgressTextView.this.scaleFloats[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    DownloadProgressTextView.this.postInvalidate();
                }
            });
            arrayList.add(valueAnimatorOfFloat);
        }
        return arrayList;
    }

    private int dp2px(int i) {
        return (int) (i * getContext().getResources().getDisplayMetrics().density);
    }

    private void drawBackground(Canvas canvas) {
        RectF rectF = new RectF();
        this.mBackgroundBounds = rectF;
        boolean z = this.showBorder;
        rectF.left = z ? this.mBorderWidth : 0.0f;
        rectF.top = z ? this.mBorderWidth : 0.0f;
        rectF.right = getMeasuredWidth() - (this.showBorder ? this.mBorderWidth : 0.0f);
        RectF rectF2 = this.mBackgroundBounds;
        float measuredHeight = getMeasuredHeight();
        boolean z2 = this.showBorder;
        rectF2.bottom = measuredHeight - (z2 ? this.mBorderWidth : 0.0f);
        if (z2) {
            this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
            this.mBackgroundPaint.setColor(this.mBackgroundColor);
            this.mBackgroundPaint.setStrokeWidth(this.mBorderWidth);
            RectF rectF3 = this.mBackgroundBounds;
            float f = this.mButtonRadius;
            canvas.drawRoundRect(rectF3, f, f, this.mBackgroundPaint);
        }
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        int i = this.mState;
        if (i != 0) {
            if (i == 1 || i == 2) {
                this.mProgressPercent = this.mProgress / (this.mMaxProgress + 0.0f);
                this.mBackgroundPaint.setColor(this.mBackgroundSecondColor);
                canvas.save();
                RectF rectF4 = this.mBackgroundBounds;
                float f2 = this.mButtonRadius;
                canvas.drawRoundRect(rectF4, f2, f2, this.mBackgroundPaint);
                PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
                this.mBackgroundPaint.setColor(this.mBackgroundColor);
                this.mBackgroundPaint.setXfermode(porterDuffXfermode);
                RectF rectF5 = this.mBackgroundBounds;
                canvas.drawRect(rectF5.left, rectF5.top, rectF5.right * this.mProgressPercent, rectF5.bottom, this.mBackgroundPaint);
                canvas.restore();
                this.mBackgroundPaint.setXfermode(null);
                return;
            }
            if (i != 3) {
                return;
            }
        }
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        RectF rectF6 = this.mBackgroundBounds;
        float f3 = this.mButtonRadius;
        canvas.drawRoundRect(rectF6, f3, f3, this.mBackgroundPaint);
    }

    private void drawLoadingBall(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f = i;
            canvas.translate(this.mTextRightBorder + 10.0f + (this.mBallRadius * 2.0f * f) + (this.mBallSpacing * f), this.mTextBottomBorder);
            canvas.drawCircle(0.0f, this.translateYFloats[i], this.mBallRadius * this.scaleFloats[i], this.mTextPaint);
            canvas.restore();
        }
    }

    private void drawTextAbove(Canvas canvas) {
        Paint paint;
        int i;
        float height = (canvas.getHeight() / 2) - ((this.mTextPaint.descent() / 2.0f) + (this.mTextPaint.ascent() / 2.0f));
        if (this.mCurrentText == null) {
            this.mCurrentText = "";
        }
        float fMeasureText = this.mTextPaint.measureText(this.mCurrentText.toString());
        this.mTextBottomBorder = height;
        this.mTextRightBorder = (getMeasuredWidth() + fMeasureText) / 2.0f;
        int i2 = this.mState;
        if (i2 == 0) {
            this.mTextPaint.setShader(null);
            paint = this.mTextPaint;
            i = this.mTextCoverColor;
        } else {
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.mTextPaint.setColor(this.mTextCoverColor);
                canvas.drawText(this.mCurrentText.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.mTextPaint);
                drawLoadingBall(canvas);
                return;
            }
            float measuredWidth = getMeasuredWidth() * this.mProgressPercent;
            float f = fMeasureText / 2.0f;
            float measuredWidth2 = (getMeasuredWidth() / 2) - f;
            float measuredWidth3 = (getMeasuredWidth() / 2) + f;
            float measuredWidth4 = ((f - (getMeasuredWidth() / 2)) + measuredWidth) / fMeasureText;
            if (measuredWidth > measuredWidth2) {
                if (measuredWidth2 >= measuredWidth || measuredWidth > measuredWidth3) {
                    this.mTextPaint.setShader(null);
                    paint = this.mTextPaint;
                    i = this.mTextCoverColor;
                } else {
                    this.mProgressTextGradient = new LinearGradient((getMeasuredWidth() - fMeasureText) / 2.0f, 0.0f, (getMeasuredWidth() + fMeasureText) / 2.0f, 0.0f, new int[]{this.mTextCoverColor, this.mTextColor}, new float[]{measuredWidth4, 0.001f + measuredWidth4}, Shader.TileMode.CLAMP);
                    this.mTextPaint.setColor(this.mTextColor);
                    this.mTextPaint.setShader(this.mProgressTextGradient);
                }
                canvas.drawText(this.mCurrentText.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.mTextPaint);
            }
            this.mTextPaint.setShader(null);
            paint = this.mTextPaint;
            i = this.mTextColor;
        }
        paint.setColor(i);
        canvas.drawText(this.mCurrentText.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.mTextPaint);
    }

    private void drawing(Canvas canvas) {
        drawBackground(canvas);
        drawTextAbove(canvas);
    }

    private void init() {
        this.mMaxProgress = 100;
        this.mMinProgress = 0;
        this.mProgress = 0.0f;
        this.showBorder = true;
        Paint paint = new Paint();
        this.mBackgroundPaint = paint;
        paint.setAntiAlias(true);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint = new Paint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(dp2px(15));
        setLayerType(1, this.mTextPaint);
        this.mState = 0;
        invalidate();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FLAdxDownloadProgressButton);
        try {
            this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FLAdxDownloadProgressButton_fl_adx_progress_btn_background_color, Color.parseColor("#00C983"));
            this.mBackgroundSecondColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FLAdxDownloadProgressButton_fl_adx_progress_btn_background_second_color, Color.parseColor("#FFFFFF"));
            this.mButtonRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FLAdxDownloadProgressButton_fl_adx_progress_btn_radius, dp2px(8));
            this.mTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FLAdxDownloadProgressButton_fl_adx_progress_btn_text_color, this.mBackgroundColor);
            this.mTextCoverColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FLAdxDownloadProgressButton_fl_adx_progress_btn_text_cover_color, -1);
            this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FLAdxDownloadProgressButton_fl_adx_progress_btn_border_width, dp2px(2));
            this.mBallStyle = typedArrayObtainStyledAttributes.getInt(R.styleable.FLAdxDownloadProgressButton_fl_adx_progress_btn_ball_style, 2);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void setBallStyle(int i) {
        this.mBallStyle = i;
        this.mAnimators = i == 1 ? createBallPulseAnimators() : createBallJumpAnimators();
    }

    private void setupAnimations() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(500L);
        this.mProgressAnimation = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fl.saas.adx.base.widget.DownloadProgressTextView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                DownloadProgressTextView downloadProgressTextView = DownloadProgressTextView.this;
                downloadProgressTextView.mProgress = ((downloadProgressTextView.mToProgress - DownloadProgressTextView.this.mProgress) * fFloatValue) + DownloadProgressTextView.this.mProgress;
                DownloadProgressTextView.this.invalidate();
            }
        });
        setBallStyle(this.mBallStyle);
    }

    private void startAnimators() {
        for (int i = 0; i < this.mAnimators.size(); i++) {
            this.mAnimators.get(i).start();
        }
    }

    private void stopAnimators() {
        ArrayList<ValueAnimator> arrayList = this.mAnimators;
        if (arrayList != null) {
            for (ValueAnimator valueAnimator : arrayList) {
                if (valueAnimator != null && valueAnimator.isStarted()) {
                    valueAnimator.end();
                }
            }
        }
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getButtonRadius() {
        return this.mButtonRadius;
    }

    public CharSequence getCurrentText() {
        return this.mCurrentText;
    }

    public int getMaxProgress() {
        return this.mMaxProgress;
    }

    public int getMinProgress() {
        return this.mMinProgress;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public int getState() {
        return this.mState;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextCoverColor() {
        return this.mTextCoverColor;
    }

    public boolean isShowBorder() {
        return this.showBorder;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        drawing(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mState = savedState.state;
        this.mProgress = savedState.progress;
        this.mCurrentText = savedState.currentText;
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), (int) this.mProgress, this.mState, this.mCurrentText.toString());
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = dp2px(i);
    }

    public void setButtonRadius(float f) {
        this.mButtonRadius = f;
    }

    public void setCurrentText(CharSequence charSequence) {
        this.mCurrentText = charSequence;
        invalidate();
    }

    public void setMaxProgress(int i) {
        this.mMaxProgress = i;
    }

    public void setMinProgress(int i) {
        this.mMinProgress = i;
    }

    public void setProgress(float f) {
        this.mProgress = f;
    }

    public void setProgressText(String str, int i) {
        int i2 = this.mMinProgress;
        if (i >= i2 && i <= this.mMaxProgress) {
            this.mCurrentText = str + i + "%";
            this.mToProgress = (float) i;
            if (this.mProgressAnimation.isRunning()) {
                this.mProgressAnimation.resume();
            }
            this.mProgressAnimation.start();
            return;
        }
        if (i < i2) {
            this.mProgress = 0.0f;
            return;
        }
        if (i > this.mMaxProgress) {
            this.mProgress = 100.0f;
            this.mCurrentText = str + i + "%";
            invalidate();
        }
    }

    public void setShowBorder(boolean z) {
        this.showBorder = z;
    }

    public void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            invalidate();
            if (i == 3) {
                startAnimators();
            } else {
                stopAnimators();
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTextCoverColor(int i) {
        this.mTextCoverColor = i;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.fl.saas.adx.base.widget.DownloadProgressTextView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private String currentText;
        private int progress;
        private int state;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            this.state = parcel.readInt();
            this.currentText = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
            parcel.writeInt(this.state);
            parcel.writeString(this.currentText);
        }

        public SavedState(Parcelable parcelable, int i, int i2, String str) {
            super(parcelable);
            this.progress = i;
            this.state = i2;
            this.currentText = str;
        }
    }

    public DownloadProgressTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBallStyle = 2;
        this.mProgress = -1.0f;
        this.mBallSpacing = 4.0f;
        this.mBallRadius = 6.0f;
        this.scaleFloats = new float[]{1.0f, 1.0f, 1.0f};
        this.translateYFloats = new float[3];
        if (isInEditMode()) {
            return;
        }
        initAttrs(context, attributeSet);
        init();
        setupAnimations();
    }
}
