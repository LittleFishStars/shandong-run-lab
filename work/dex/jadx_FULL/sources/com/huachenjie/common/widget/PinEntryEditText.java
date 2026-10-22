package com.huachenjie.common.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class PinEntryEditText extends AppCompatEditText {
    public static final String DEFAULT_MASK = "●";
    private static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    protected boolean mAnimate;
    protected int mAnimatedType;
    protected float[] mCharBottom;
    protected Paint mCharPaint;
    protected float mCharSize;
    protected View.OnClickListener mClickListener;
    protected ColorStateList mColorStates;
    protected int[] mColors;
    protected boolean mHasError;
    protected boolean mIsDigitSquare;
    protected Paint mLastCharPaint;
    protected RectF[] mLineCoords;
    protected float mLineStroke;
    protected float mLineStrokeSelected;
    protected Paint mLinesPaint;
    protected String mMask;
    protected StringBuilder mMaskChars;
    protected int mMaxLength;
    protected float mNumChars;
    protected OnPinEnteredListener mOnPinEnteredListener;
    protected ColorStateList mOriginalTextColors;
    protected Drawable mPinBackground;
    protected String mSingleCharHint;
    protected Paint mSingleCharPaint;
    protected float mSpace;
    protected int[][] mStates;
    protected float mTextBottomPadding;
    protected Rect mTextHeight;

    public interface OnPinEnteredListener {
        void onPinEntered(CharSequence str);
    }

    public PinEntryEditText(Context context) {
        super(context);
        this.mMask = null;
        this.mMaskChars = null;
        this.mSingleCharHint = null;
        this.mAnimatedType = 0;
        this.mSpace = 24.0f;
        this.mNumChars = 4.0f;
        this.mTextBottomPadding = 8.0f;
        this.mMaxLength = 4;
        this.mTextHeight = new Rect();
        this.mIsDigitSquare = false;
        this.mOnPinEnteredListener = null;
        this.mLineStroke = 1.0f;
        this.mLineStrokeSelected = 2.0f;
        this.mAnimate = false;
        this.mHasError = false;
        this.mStates = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.mColors = new int[]{-16711936, -65536, -16777216, -7829368};
        this.mColorStates = new ColorStateList(this.mStates, this.mColors);
    }

    private void animateBottomUp(CharSequence text, final int start) {
        float[] fArr = this.mCharBottom;
        float f = this.mLineCoords[start].bottom - this.mTextBottomPadding;
        fArr[start] = f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f + getPaint().getTextSize(), this.mCharBottom[start]);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.PinEntryEditText.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                PinEntryEditText.this.mCharBottom[start] = ((Float) animation.getAnimatedValue()).floatValue();
                PinEntryEditText.this.invalidate();
            }
        });
        this.mLastCharPaint.setAlpha(255);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.PinEntryEditText.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                PinEntryEditText.this.mLastCharPaint.setAlpha(((Integer) animation.getAnimatedValue()).intValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        if (text.length() == this.mMaxLength && this.mOnPinEnteredListener != null) {
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.huachenjie.common.widget.PinEntryEditText.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                    pinEntryEditText.mOnPinEnteredListener.onPinEntered(pinEntryEditText.getText());
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }
            });
        }
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfInt);
        animatorSet.start();
    }

    private void animatePopIn() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, getPaint().getTextSize());
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.PinEntryEditText.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                PinEntryEditText.this.mLastCharPaint.setTextSize(((Float) animation.getAnimatedValue()).floatValue());
                PinEntryEditText.this.invalidate();
            }
        });
        if (getText().length() == this.mMaxLength && this.mOnPinEnteredListener != null) {
            valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.huachenjie.common.widget.PinEntryEditText.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                    pinEntryEditText.mOnPinEnteredListener.onPinEntered(pinEntryEditText.getText());
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }
            });
        }
        valueAnimatorOfFloat.start();
    }

    private int getColorForState(int... states) {
        return this.mColorStates.getColorForState(states, -7829368);
    }

    private CharSequence getFullText() {
        return TextUtils.isEmpty(this.mMask) ? getText() : getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.mMaskChars == null) {
            this.mMaskChars = new StringBuilder();
        }
        int length = getText().length();
        while (this.mMaskChars.length() != length) {
            if (this.mMaskChars.length() < length) {
                this.mMaskChars.append(this.mMask);
            } else {
                StringBuilder sb = this.mMaskChars;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return this.mMaskChars;
    }

    private void init(Context context, AttributeSet attrs) {
        float f = context.getResources().getDisplayMetrics().density;
        this.mLineStroke *= f;
        this.mLineStrokeSelected *= f;
        this.mSpace *= f;
        this.mTextBottomPadding = f * this.mTextBottomPadding;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, com.huachenjie.common.R.styleable.PinEntryEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            typedArrayObtainStyledAttributes.getValue(com.huachenjie.common.R.styleable.PinEntryEditText_pinAnimationType, typedValue);
            this.mAnimatedType = typedValue.data;
            this.mMask = typedArrayObtainStyledAttributes.getString(com.huachenjie.common.R.styleable.PinEntryEditText_pinCharacterMask);
            this.mSingleCharHint = typedArrayObtainStyledAttributes.getString(com.huachenjie.common.R.styleable.PinEntryEditText_pinRepeatedHint);
            this.mLineStroke = typedArrayObtainStyledAttributes.getDimension(com.huachenjie.common.R.styleable.PinEntryEditText_pinLineStroke, this.mLineStroke);
            this.mLineStrokeSelected = typedArrayObtainStyledAttributes.getDimension(com.huachenjie.common.R.styleable.PinEntryEditText_pinLineStrokeSelected, this.mLineStrokeSelected);
            this.mSpace = typedArrayObtainStyledAttributes.getDimension(com.huachenjie.common.R.styleable.PinEntryEditText_pinCharacterSpacing, this.mSpace);
            this.mTextBottomPadding = typedArrayObtainStyledAttributes.getDimension(com.huachenjie.common.R.styleable.PinEntryEditText_pinTextBottomPadding, this.mTextBottomPadding);
            this.mIsDigitSquare = typedArrayObtainStyledAttributes.getBoolean(com.huachenjie.common.R.styleable.PinEntryEditText_pinBackgroundIsSquare, this.mIsDigitSquare);
            this.mPinBackground = typedArrayObtainStyledAttributes.getDrawable(com.huachenjie.common.R.styleable.PinEntryEditText_pinBackgroundDrawable);
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(com.huachenjie.common.R.styleable.PinEntryEditText_pinLineColors);
            if (colorStateList != null) {
                this.mColorStates = colorStateList;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.mCharPaint = new Paint(getPaint());
            this.mLastCharPaint = new Paint(getPaint());
            this.mSingleCharPaint = new Paint(getPaint());
            Paint paint = new Paint(getPaint());
            this.mLinesPaint = paint;
            paint.setStrokeWidth(this.mLineStroke);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(com.huachenjie.common.R.attr.colorControlActivated, typedValue2, true);
            this.mColors[0] = typedValue2.data;
            this.mColors[1] = isInEditMode() ? -7829368 : -16777216;
            this.mColors[2] = isInEditMode() ? -16711936 : -16777216;
            setBackgroundResource(0);
            int attributeIntValue = attrs.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 4);
            this.mMaxLength = attributeIntValue;
            this.mNumChars = attributeIntValue;
            super.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: com.huachenjie.common.widget.PinEntryEditText.1
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }
            });
            super.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.PinEntryEditText.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                    pinEntryEditText.setSelection(pinEntryEditText.getText().length());
                    View.OnClickListener onClickListener = PinEntryEditText.this.mClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(v);
                    }
                }
            });
            super.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.huachenjie.common.widget.PinEntryEditText.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View v) {
                    PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                    pinEntryEditText.setSelection(pinEntryEditText.getText().length());
                    return true;
                }
            });
            if ((getInputType() & 128) == 128 && TextUtils.isEmpty(this.mMask)) {
                this.mMask = DEFAULT_MASK;
            } else if ((getInputType() & 16) == 16 && TextUtils.isEmpty(this.mMask)) {
                this.mMask = DEFAULT_MASK;
            }
            if (!TextUtils.isEmpty(this.mMask)) {
                this.mMaskChars = getMaskChars();
            }
            getPaint().getTextBounds("|", 0, 1, this.mTextHeight);
            this.mAnimate = this.mAnimatedType > -1;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void setCustomTypeface(@Nullable Typeface tf) {
        Paint paint = this.mCharPaint;
        if (paint != null) {
            paint.setTypeface(tf);
            this.mLastCharPaint.setTypeface(tf);
            this.mSingleCharPaint.setTypeface(tf);
            this.mLinesPaint.setTypeface(tf);
        }
    }

    public void focus() {
        requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
    }

    public boolean isError() {
        return this.mHasError;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(fullText, 0, length, fArr);
        String str = this.mSingleCharHint;
        float f = 0.0f;
        if (str != null) {
            int length2 = str.length();
            float[] fArr2 = new float[length2];
            getPaint().getTextWidths(this.mSingleCharHint, fArr2);
            for (int i = 0; i < length2; i++) {
                f += fArr2[i];
            }
        }
        float f2 = f;
        int i2 = 0;
        while (i2 < this.mNumChars) {
            if (this.mPinBackground != null) {
                updateDrawableState(i2 < length, i2 == length);
                Drawable drawable = this.mPinBackground;
                RectF rectF = this.mLineCoords[i2];
                drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.mPinBackground.draw(canvas);
            }
            float f3 = this.mLineCoords[i2].left + (this.mCharSize / 2.0f);
            if (length <= i2) {
                String str2 = this.mSingleCharHint;
                if (str2 != null) {
                    canvas.drawText(str2, f3 - (f2 / 2.0f), this.mCharBottom[i2], this.mSingleCharPaint);
                }
            } else if (this.mAnimate && i2 == length - 1) {
                canvas.drawText(fullText, i2, i2 + 1, f3 - (fArr[i2] / 2.0f), this.mCharBottom[i2], this.mLastCharPaint);
            } else {
                canvas.drawText(fullText, i2, i2 + 1, f3 - (fArr[i2] / 2.0f), this.mCharBottom[i2], this.mCharPaint);
            }
            if (this.mPinBackground == null) {
                updateColorForLines(i2 <= length);
                RectF rectF2 = this.mLineCoords[i2];
                canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.mLinesPaint);
            }
            i2++;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft;
        float f;
        float f2;
        float f3;
        int size;
        float f4;
        float f5;
        float f6;
        if (!this.mIsDigitSquare) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode != 1073741824) {
            if (mode2 == 1073741824) {
                size = View.MeasureSpec.getSize(heightMeasureSpec);
                f4 = this.mNumChars;
                f5 = size * f4;
                f6 = this.mSpace;
            } else if (mode == Integer.MIN_VALUE) {
                paddingLeft = View.MeasureSpec.getSize(widthMeasureSpec);
                f = paddingLeft;
                f2 = this.mNumChars;
                f3 = this.mSpace;
            } else if (mode2 == Integer.MIN_VALUE) {
                size = View.MeasureSpec.getSize(heightMeasureSpec);
                f4 = this.mNumChars;
                f5 = size * f4;
                f6 = this.mSpace;
            } else {
                paddingLeft = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
                f = paddingLeft;
                f2 = this.mNumChars;
                f3 = this.mSpace;
            }
            paddingLeft = (int) (f5 + ((f6 * f4) - 1.0f));
            setMeasuredDimension(View.resolveSizeAndState(paddingLeft, widthMeasureSpec, 1), View.resolveSizeAndState(size, heightMeasureSpec, 0));
        }
        paddingLeft = View.MeasureSpec.getSize(widthMeasureSpec);
        f = paddingLeft;
        f2 = this.mNumChars;
        f3 = this.mSpace;
        size = (int) ((f - (f2 - (f3 * 1.0f))) / f2);
        setMeasuredDimension(View.resolveSizeAndState(paddingLeft, widthMeasureSpec, 1), View.resolveSizeAndState(size, heightMeasureSpec, 0));
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        int paddingStart;
        super.onSizeChanged(w, h, oldw, oldh);
        ColorStateList textColors = getTextColors();
        this.mOriginalTextColors = textColors;
        if (textColors != null) {
            this.mLastCharPaint.setColor(textColors.getDefaultColor());
            this.mCharPaint.setColor(this.mOriginalTextColors.getDefaultColor());
            this.mSingleCharPaint.setColor(getCurrentHintTextColor());
        }
        int width = (getWidth() - ViewCompat.getPaddingEnd(this)) - ViewCompat.getPaddingStart(this);
        float f = this.mSpace;
        if (f < 0.0f) {
            this.mCharSize = width / ((this.mNumChars * 2.0f) - 1.0f);
        } else {
            float f2 = this.mNumChars;
            this.mCharSize = (width - (f * (f2 - 1.0f))) / f2;
        }
        float f3 = this.mNumChars;
        this.mLineCoords = new RectF[(int) f3];
        this.mCharBottom = new float[(int) f3];
        int height = getHeight() - getPaddingBottom();
        int i = 1;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            paddingStart = (int) ((getWidth() - ViewCompat.getPaddingStart(this)) - this.mCharSize);
            i = -1;
        } else {
            paddingStart = ViewCompat.getPaddingStart(this);
        }
        for (int i2 = 0; i2 < this.mNumChars; i2++) {
            float f4 = paddingStart;
            float f5 = height;
            this.mLineCoords[i2] = new RectF(f4, f5, this.mCharSize + f4, f5);
            if (this.mPinBackground != null) {
                if (this.mIsDigitSquare) {
                    this.mLineCoords[i2].top = getPaddingTop();
                    RectF rectF = this.mLineCoords[i2];
                    rectF.right = rectF.width() + f4;
                } else {
                    this.mLineCoords[i2].top -= this.mTextHeight.height() + (this.mTextBottomPadding * 2.0f);
                }
            }
            float f6 = this.mSpace;
            paddingStart = (int) (f6 < 0.0f ? f4 + (i * this.mCharSize * 2.0f) : f4 + (i * (this.mCharSize + f6)));
            this.mCharBottom[i2] = this.mLineCoords[i2].bottom - this.mTextBottomPadding;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence text, final int start, int lengthBefore, final int lengthAfter) {
        setError(false);
        if (this.mLineCoords == null || !this.mAnimate) {
            if (this.mOnPinEnteredListener == null || text.length() != this.mMaxLength) {
                return;
            }
            this.mOnPinEnteredListener.onPinEntered(text);
            return;
        }
        int i = this.mAnimatedType;
        if (i == -1) {
            invalidate();
        } else if (lengthAfter > lengthBefore) {
            if (i == 0) {
                animatePopIn();
            } else {
                animateBottomUp(text, start);
            }
        }
    }

    public void setAnimateText(boolean animate) {
        this.mAnimate = animate;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    public void setError(boolean hasError) {
        this.mHasError = hasError;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setInputType(int type) {
        super.setInputType(type);
        if ((type & 128) != 128 && (type & 16) != 16) {
            setMask(null);
        } else if (TextUtils.isEmpty(this.mMask)) {
            setMask(DEFAULT_MASK);
        }
    }

    public void setMask(String mask) {
        this.mMask = mask;
        this.mMaskChars = null;
        invalidate();
    }

    public void setMaxLength(final int maxLength) {
        this.mMaxLength = maxLength;
        this.mNumChars = maxLength;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        setText((CharSequence) null);
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.mClickListener = l;
    }

    public void setOnPinEnteredListener(OnPinEnteredListener l) {
        this.mOnPinEnteredListener = l;
    }

    public void setPinBackground(Drawable pinBackground) {
        this.mPinBackground = pinBackground;
        invalidate();
    }

    public void setPinLineColors(ColorStateList colors) {
        this.mColorStates = colors;
        invalidate();
    }

    public void setSingleCharHint(String hint) {
        this.mSingleCharHint = hint;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface tf) {
        super.setTypeface(tf);
        setCustomTypeface(tf);
    }

    public void updateColorForLines(boolean hasTextOrIsNext) {
        if (this.mHasError) {
            this.mLinesPaint.setColor(getColorForState(R.attr.state_active));
            return;
        }
        if (!isFocused()) {
            this.mLinesPaint.setStrokeWidth(this.mLineStroke);
            this.mLinesPaint.setColor(getColorForState(-16842908));
            return;
        }
        this.mLinesPaint.setStrokeWidth(this.mLineStrokeSelected);
        this.mLinesPaint.setColor(getColorForState(R.attr.state_focused));
        if (hasTextOrIsNext) {
            this.mLinesPaint.setColor(getColorForState(R.attr.state_selected));
        }
    }

    public void updateDrawableState(boolean hasText, boolean isNext) {
        if (this.mHasError) {
            this.mPinBackground.setState(new int[]{R.attr.state_active});
            return;
        }
        if (!isFocused()) {
            if (hasText) {
                this.mPinBackground.setState(new int[]{-16842908, R.attr.state_checked});
                return;
            } else {
                this.mPinBackground.setState(new int[]{-16842908});
                return;
            }
        }
        this.mPinBackground.setState(new int[]{R.attr.state_focused});
        if (isNext) {
            this.mPinBackground.setState(new int[]{R.attr.state_focused, R.attr.state_selected});
        } else if (hasText) {
            this.mPinBackground.setState(new int[]{R.attr.state_focused, R.attr.state_checked});
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface tf, int style) {
        super.setTypeface(tf, style);
        setCustomTypeface(tf);
    }

    public PinEntryEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMask = null;
        this.mMaskChars = null;
        this.mSingleCharHint = null;
        this.mAnimatedType = 0;
        this.mSpace = 24.0f;
        this.mNumChars = 4.0f;
        this.mTextBottomPadding = 8.0f;
        this.mMaxLength = 4;
        this.mTextHeight = new Rect();
        this.mIsDigitSquare = false;
        this.mOnPinEnteredListener = null;
        this.mLineStroke = 1.0f;
        this.mLineStrokeSelected = 2.0f;
        this.mAnimate = false;
        this.mHasError = false;
        this.mStates = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.mColors = new int[]{-16711936, -65536, -16777216, -7829368};
        this.mColorStates = new ColorStateList(this.mStates, this.mColors);
        init(context, attrs);
    }

    public PinEntryEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mMask = null;
        this.mMaskChars = null;
        this.mSingleCharHint = null;
        this.mAnimatedType = 0;
        this.mSpace = 24.0f;
        this.mNumChars = 4.0f;
        this.mTextBottomPadding = 8.0f;
        this.mMaxLength = 4;
        this.mTextHeight = new Rect();
        this.mIsDigitSquare = false;
        this.mOnPinEnteredListener = null;
        this.mLineStroke = 1.0f;
        this.mLineStrokeSelected = 2.0f;
        this.mAnimate = false;
        this.mHasError = false;
        this.mStates = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.mColors = new int[]{-16711936, -65536, -16777216, -7829368};
        this.mColorStates = new ColorStateList(this.mStates, this.mColors);
        init(context, attrs);
    }
}
