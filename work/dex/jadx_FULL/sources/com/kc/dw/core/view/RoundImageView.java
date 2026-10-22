package com.kc.dw.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RoundImageView extends GifImageView {
    private int borderColor;
    private float[] borderRadii;
    private RectF borderRectF;
    private int borderWidth;
    private Context context;
    private int cornerBottomLeftRadius;
    private int cornerBottomRightRadius;
    private int cornerRadius;
    private int cornerTopLeftRadius;
    private int cornerTopRightRadius;
    private int height;
    private int innerBorderColor;
    private int innerBorderWidth;
    private boolean isCircle;
    private boolean isCoverSrc;
    private int maskColor;
    private Paint paint;
    private Path path;
    private float radius;
    private Path srcPath;
    private float[] srcRadii;
    private RectF srcRectF;
    private int width;
    private Xfermode xfermode;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.borderColor = -1;
        this.innerBorderColor = -1;
        this.context = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Ssd_RoundImageView, 0, 0);
        for (int i2 = 0; i2 < typedArrayObtainStyledAttributes.getIndexCount(); i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.Ssd_RoundImageView_ssd_is_cover_src) {
                this.isCoverSrc = typedArrayObtainStyledAttributes.getBoolean(index, this.isCoverSrc);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_is_circle) {
                this.isCircle = typedArrayObtainStyledAttributes.getBoolean(index, this.isCircle);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_border_width) {
                this.borderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_border_color) {
                this.borderColor = typedArrayObtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_inner_border_width) {
                this.innerBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.innerBorderWidth);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_inner_border_color) {
                this.innerBorderColor = typedArrayObtainStyledAttributes.getColor(index, this.innerBorderColor);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_corner_radius) {
                this.cornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_corner_top_left_radius) {
                this.cornerTopLeftRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopLeftRadius);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_corner_top_right_radius) {
                this.cornerTopRightRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopRightRadius);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_corner_bottom_left_radius) {
                this.cornerBottomLeftRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomLeftRadius);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_corner_bottom_right_radius) {
                this.cornerBottomRightRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomRightRadius);
            } else if (index == R.styleable.Ssd_RoundImageView_ssd_mask_color) {
                this.maskColor = typedArrayObtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        this.borderRadii = new float[8];
        this.srcRadii = new float[8];
        this.borderRectF = new RectF();
        this.srcRectF = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.srcPath = new Path();
        }
        calculateRadii();
        clearInnerBorderWidth();
    }

    private void calculateRadii() {
        if (this.isCircle) {
            return;
        }
        int i = 0;
        if (this.cornerRadius <= 0) {
            float[] fArr = this.borderRadii;
            float f = this.cornerTopLeftRadius;
            fArr[1] = f;
            fArr[0] = f;
            float f2 = this.cornerTopRightRadius;
            fArr[3] = f2;
            fArr[2] = f2;
            float f3 = this.cornerBottomRightRadius;
            fArr[5] = f3;
            fArr[4] = f3;
            float f4 = this.cornerBottomLeftRadius;
            fArr[7] = f4;
            fArr[6] = f4;
            float[] fArr2 = this.srcRadii;
            float f5 = this.borderWidth / 2.0f;
            float f6 = f - f5;
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = f2 - f5;
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = f3 - f5;
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = f4 - f5;
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.borderRadii;
            if (i >= fArr3.length) {
                return;
            }
            float f10 = this.cornerRadius;
            fArr3[i] = f10;
            this.srcRadii[i] = f10 - (this.borderWidth / 2.0f);
            i++;
        }
    }

    private void calculateRadiiAndRectF(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        calculateRadii();
        initBorderRectF();
        invalidate();
    }

    private void clearInnerBorderWidth() {
        if (this.isCircle) {
            return;
        }
        this.innerBorderWidth = 0;
    }

    private void drawBorders(Canvas canvas) {
        if (!this.isCircle) {
            int i = this.borderWidth;
            if (i > 0) {
                drawRectFBorder(canvas, i, this.borderColor, this.borderRectF, this.borderRadii);
                return;
            }
            return;
        }
        int i2 = this.borderWidth;
        if (i2 > 0) {
            drawCircleBorder(canvas, i2, this.borderColor, this.radius - (i2 / 2.0f));
        }
        int i3 = this.innerBorderWidth;
        if (i3 > 0) {
            drawCircleBorder(canvas, i3, this.innerBorderColor, (this.radius - this.borderWidth) - (i3 / 2.0f));
        }
    }

    private void drawCircleBorder(Canvas canvas, int i, int i2, float f) {
        initBorderPaint(i, i2);
        this.path.addCircle(this.width / 2.0f, this.height / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void drawRectFBorder(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        initBorderPaint(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void initBorderPaint(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void initBorderRectF() {
        if (this.isCircle) {
            return;
        }
        RectF rectF = this.borderRectF;
        float f = this.borderWidth / 2.0f;
        rectF.set(f, f, this.width - f, this.height - f);
    }

    private void initSrcRectF() {
        if (!this.isCircle) {
            this.srcRectF.set(0.0f, 0.0f, this.width, this.height);
            if (this.isCoverSrc) {
                this.srcRectF = this.borderRectF;
                return;
            }
            return;
        }
        float fMin = Math.min(this.width, this.height) / 2.0f;
        this.radius = fMin;
        RectF rectF = this.srcRectF;
        float f = this.width / 2.0f;
        float f2 = this.height / 2.0f;
        rectF.set(f - fMin, f2 - fMin, f + fMin, f2 + fMin);
    }

    public void isCircle(boolean z) {
        this.isCircle = z;
        clearInnerBorderWidth();
        initSrcRectF();
        invalidate();
    }

    public void isCoverSrc(boolean z) {
        this.isCoverSrc = z;
        initSrcRectF();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.srcRectF, null, 31);
        if (!this.isCoverSrc) {
            int i = this.width;
            int i2 = this.borderWidth * 2;
            int i3 = this.innerBorderWidth * 2;
            float f = (i - i2) - i3;
            float f2 = i;
            int i4 = this.height;
            float f3 = (i4 - i2) - i3;
            float f4 = i4;
            canvas.scale((f * 1.0f) / f2, (f3 * 1.0f) / f4, f2 / 2.0f, f4 / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        if (this.isCircle) {
            this.path.addCircle(this.width / 2.0f, this.height / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.srcRectF, this.srcRadii, Path.Direction.CCW);
        }
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setXfermode(this.xfermode);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.path, this.paint);
        } else {
            this.srcPath.addRect(this.srcRectF, Path.Direction.CCW);
            this.srcPath.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(this.srcPath, this.paint);
            this.srcPath.reset();
        }
        this.paint.setXfermode(null);
        int i5 = this.maskColor;
        if (i5 != 0) {
            this.paint.setColor(i5);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        drawBorders(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        initBorderRectF();
        initSrcRectF();
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = (int) DimensionUtils.dip2px(this.context, i);
        calculateRadiiAndRectF(false);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.cornerBottomLeftRadius = (int) DimensionUtils.dip2px(this.context, i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.cornerBottomRightRadius = (int) DimensionUtils.dip2px(this.context, i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = (int) DimensionUtils.dip2px(this.context, i);
        calculateRadiiAndRectF(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.cornerTopLeftRadius = (int) DimensionUtils.dip2px(this.context, i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.cornerTopRightRadius = (int) DimensionUtils.dip2px(this.context, i);
        calculateRadiiAndRectF(true);
    }

    public void setInnerBorderColor(int i) {
        this.innerBorderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.innerBorderWidth = (int) DimensionUtils.dip2px(this.context, i);
        clearInnerBorderWidth();
        invalidate();
    }

    public void setMaskColor(int i) {
        this.maskColor = i;
        invalidate();
    }
}
