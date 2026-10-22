package com.huachenjie.common.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class GradientRoundProgress extends View {
    private final int endColor;
    private int max;
    private final int maxAngle;
    private final int midColor;
    private final float numSize;
    private final Paint paint;
    private int progress;
    private int progressColor;
    private float progressWidth;
    private int roundColor;
    private float roundWidth;
    private int startAngle;
    private final int startColor;
    private String text;
    private final int textColor;
    private final boolean textShow;
    private final float textSize;

    public GradientRoundProgress(Context context) {
        this(context, null);
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        String str;
        int i;
        float[] fArr;
        int[] iArr;
        int[] iArr2;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f2 = width;
        int i2 = (int) (f2 - (this.roundWidth / 2.0f));
        float f3 = width - i2;
        float f4 = width + i2;
        RectF rectF = new RectF(f3, f3, f4, f4);
        canvas.save();
        canvas.rotate(this.startAngle, f2, f2);
        float f5 = this.roundWidth;
        if (f5 > 0.0f) {
            this.paint.setStrokeWidth(f5);
            this.paint.setColor(this.roundColor);
            this.paint.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, 0.0f, this.maxAngle, false, this.paint);
        }
        if (this.progress > 0) {
            this.paint.setStrokeWidth(this.progressWidth);
            this.paint.setColor(this.progressColor);
            int i3 = this.maxAngle;
            int i4 = (this.progress * i3) / this.max;
            int i5 = this.startColor;
            if (i5 == -1 || (i = this.endColor) == -1) {
                f = f2;
            } else {
                float f6 = (float) (1.0d - (((double) (this.roundWidth * 2.0f)) / (((double) (i2 * 2.0f)) * 3.141592653589793d)));
                if (i3 == 360) {
                    int i6 = this.midColor;
                    if (i6 == -1) {
                        iArr = new int[]{i5, i, i5};
                        fArr = new float[]{0.0f, f6, 1.0f};
                    } else {
                        iArr2 = new int[]{i5, i6, i, i5};
                        fArr = new float[]{0.0f, (i3 / 360.0f) / 2.0f, f6, 1.0f};
                        iArr = iArr2;
                    }
                } else {
                    int i7 = this.midColor;
                    if (i7 == -1) {
                        iArr2 = new int[]{i5, i, i, i5};
                        fArr = new float[]{0.0f, i3 / 360.0f, f6, 1.0f};
                        iArr = iArr2;
                    } else {
                        int[] iArr3 = {i5, i7, i, i, i5};
                        fArr = new float[]{0.0f, (i3 / 360.0f) / 2.0f, i3 / 360.0f, f6, 1.0f};
                        iArr = iArr3;
                    }
                }
                f = f2;
                this.paint.setShader(new SweepGradient(f, f, iArr, fArr));
            }
            canvas.drawArc(rectF, 0.0f, i4, false, this.paint);
            this.paint.setShader(null);
        } else {
            f = f2;
        }
        canvas.rotate(-this.startAngle, f, f);
        canvas.restore();
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        int i8 = (int) ((this.progress / this.max) * 100.0f);
        if (!this.textShow || (str = this.text) == null || str.length() <= 0 || i8 < 0) {
            return;
        }
        this.paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText(this.text, f - (this.paint.measureText(this.text) / 2.0f), this.textSize + f + 5.0f, this.paint);
        this.paint.setTextSize(this.numSize);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText(i8 + "%", f - (this.paint.measureText(i8 + "%") / 2.0f), f, this.paint);
    }

    public synchronized void setGrpProgress(int progress) {
        setProgress(progress);
    }

    public synchronized void setMax(int max) {
        try {
            if (max < 0) {
                throw new IllegalArgumentException("max not less than 0");
            }
            this.max = max;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setProgress(int progress) {
        try {
            if (progress < 0) {
                throw new IllegalArgumentException("progress not less than 0");
            }
            int i = this.max;
            if (progress > i) {
                progress = i;
            }
            this.progress = progress;
            postInvalidate();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
    }

    public void setProgressWidth(float progressWidth) {
        this.progressWidth = progressWidth;
    }

    public void setRoundColor(int roundColor) {
        this.roundColor = roundColor;
    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public GradientRoundProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientRoundProgress(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Paint paint = new Paint();
        this.paint = paint;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.GradientRoundProgress);
        this.roundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.GradientRoundProgress_grp_roundColor, 0);
        this.roundWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.GradientRoundProgress_grp_roundWidth, 0.0f);
        this.progressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.GradientRoundProgress_grp_progressColor, -16711936);
        this.progressWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.GradientRoundProgress_grp_progressWidth, this.roundWidth);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.GradientRoundProgress_grp_text);
        this.text = string;
        if (TextUtils.isEmpty(string)) {
            this.text = "";
        }
        this.textColor = typedArrayObtainStyledAttributes.getColor(R.styleable.GradientRoundProgress_grp_textColor, -16711936);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.GradientRoundProgress_grp_textSize, 11.0f);
        this.numSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.GradientRoundProgress_grp_numSize, 14.0f);
        this.max = typedArrayObtainStyledAttributes.getInteger(R.styleable.GradientRoundProgress_grp_max, 100);
        this.maxAngle = typedArrayObtainStyledAttributes.getInteger(R.styleable.GradientRoundProgress_grp_maxAngle, 360);
        this.progress = typedArrayObtainStyledAttributes.getInteger(R.styleable.GradientRoundProgress_grp_progress, 0);
        this.startAngle = typedArrayObtainStyledAttributes.getInt(R.styleable.GradientRoundProgress_grp_startAngle, 90);
        this.textShow = typedArrayObtainStyledAttributes.getBoolean(R.styleable.GradientRoundProgress_grp_textShow, true);
        this.startColor = typedArrayObtainStyledAttributes.getColor(R.styleable.GradientRoundProgress_grp_startColor, -1);
        this.midColor = typedArrayObtainStyledAttributes.getColor(R.styleable.GradientRoundProgress_grp_midColor, -1);
        this.endColor = typedArrayObtainStyledAttributes.getColor(R.styleable.GradientRoundProgress_grp_endColor, -1);
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.GradientRoundProgress_grp_capRound, true)) {
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
