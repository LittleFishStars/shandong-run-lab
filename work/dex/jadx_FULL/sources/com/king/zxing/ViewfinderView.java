package com.king.zxing;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zj.adlib.xg7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class ViewfinderView extends View {
    public static final int c0 = 160;
    public static final int d0 = 20;
    public static final int e0 = 20;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f40016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f15016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f15017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextPaint f15018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LaserStyle f15019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextLocation f15020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<xg7> f15021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15022a;
    public int a0;
    public float b;
    public int b0;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<xg7> f15023c;
    public String f;
    public int scannerEnd;
    public int scannerStart;

    public enum LaserStyle {
        NONE(0),
        LINE(1),
        GRID(2);

        private int mValue;

        LaserStyle(int i) {
            this.mValue = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LaserStyle getFromInt(int i) {
            for (LaserStyle laserStyle : values()) {
                if (laserStyle.mValue == i) {
                    return laserStyle;
                }
            }
            return LINE;
        }
    }

    public enum TextLocation {
        TOP(0),
        BOTTOM(1);

        private int mValue;

        TextLocation(int i) {
            this.mValue = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TextLocation getFromInt(int i) {
            for (TextLocation textLocation : values()) {
                if (textLocation.mValue == i) {
                    return textLocation;
                }
            }
            return TOP;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40017a;

        static {
            int[] iArr = new int[LaserStyle.values().length];
            f40017a = iArr;
            try {
                iArr[LaserStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40017a[LaserStyle.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public final void a(Canvas canvas, Rect rect) {
        this.f15016a.setColor(this.N);
        int i = rect.left;
        int i2 = rect.top;
        canvas.drawRect(i, i2, i + this.W, i2 + this.X, this.f15016a);
        int i3 = rect.left;
        int i4 = rect.top;
        canvas.drawRect(i3, i4, i3 + this.X, i4 + this.W, this.f15016a);
        int i5 = rect.right;
        float f = i5 - this.W;
        int i6 = rect.top;
        canvas.drawRect(f, i6, i5, i6 + this.X, this.f15016a);
        int i7 = rect.right;
        float f2 = i7 - this.X;
        int i8 = rect.top;
        canvas.drawRect(f2, i8, i7, i8 + this.W, this.f15016a);
        int i9 = rect.left;
        int i10 = rect.bottom;
        canvas.drawRect(i9, i10 - this.W, i9 + this.X, i10, this.f15016a);
        int i11 = rect.left;
        int i12 = rect.bottom;
        canvas.drawRect(i11, i12 - this.X, i11 + this.W, i12, this.f15016a);
        int i13 = rect.right;
        float f3 = i13 - this.W;
        int i14 = rect.bottom;
        canvas.drawRect(f3, i14 - this.X, i13, i14, this.f15016a);
        int i15 = rect.right;
        float f4 = i15 - this.X;
        int i16 = rect.bottom;
        canvas.drawRect(f4, i16 - this.W, i15, i16, this.f15016a);
    }

    public void addPossibleResultPoint(xg7 xg7Var) {
        if (this.f15022a) {
            List<xg7> list = this.f15021a;
            synchronized (list) {
                list.add(xg7Var);
                int size = list.size();
                if (size > 20) {
                    list.subList(0, size - 10).clear();
                }
            }
        }
    }

    public final void b(Canvas canvas, Rect rect, int i, int i2) {
        this.f15016a.setColor(this.K);
        float f = i;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, this.f15016a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f15016a);
        canvas.drawRect(rect.right, rect.top, f, rect.bottom, this.f15016a);
        canvas.drawRect(0.0f, rect.bottom, f, i2, this.f15016a);
    }

    public final void c(Canvas canvas, Rect rect) {
        this.f15016a.setColor(this.L);
        float f = rect.left;
        int i = rect.top;
        canvas.drawRect(f, i, rect.right, i + this.a0, this.f15016a);
        int i2 = rect.left;
        canvas.drawRect(i2, rect.top, i2 + this.a0, rect.bottom, this.f15016a);
        int i3 = rect.right;
        canvas.drawRect(i3 - this.a0, rect.top, i3, rect.bottom, this.f15016a);
        float f2 = rect.left;
        int i4 = rect.bottom;
        canvas.drawRect(f2, i4 - this.a0, rect.right, i4, this.f15016a);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final void d(Canvas canvas, Rect rect) {
        int i;
        this.f15016a.setStrokeWidth(2);
        int i2 = this.V;
        if (i2 > 0) {
            int i3 = this.scannerStart;
            if (i3 - rect.top > i2) {
                i = i3 - i2;
            } else {
                i = rect.top;
            }
        } else {
            i = rect.top;
        }
        float f = i;
        int i4 = 0;
        this.f15016a.setShader(new LinearGradient(rect.left + (rect.width() / 2), f, rect.left + (rect.width() / 2), this.scannerStart, new int[]{shadeColor(this.M), this.M}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        float fWidth = (rect.width() * 1.0f) / this.U;
        for (int i5 = 1; i5 < this.U; i5++) {
            int i6 = rect.left;
            float f2 = i5 * fWidth;
            canvas.drawLine(i6 + f2, f, i6 + f2, this.scannerStart, this.f15016a);
        }
        int i7 = this.V;
        if (i7 <= 0 || this.scannerStart - rect.top <= i7) {
            i7 = this.scannerStart - rect.top;
        }
        while (true) {
            float f3 = i4;
            if (f3 > i7 / fWidth) {
                break;
            }
            float f4 = rect.left;
            int i8 = this.scannerStart;
            float f5 = f3 * fWidth;
            canvas.drawLine(f4, i8 - f5, rect.right, i8 - f5, this.f15016a);
            i4++;
        }
        int i9 = this.scannerStart;
        if (i9 < this.scannerEnd) {
            this.scannerStart = i9 + this.Y;
        } else {
            this.scannerStart = rect.top;
        }
    }

    public void drawViewfinder() {
        invalidate();
    }

    public final void e(Canvas canvas, Rect rect) {
        if (this.f15019a != null) {
            this.f15016a.setColor(this.M);
            int i = a.f40017a[this.f15019a.ordinal()];
            if (i == 1) {
                f(canvas, rect);
            } else if (i == 2) {
                d(canvas, rect);
            }
            this.f15016a.setShader(null);
        }
    }

    public final void f(Canvas canvas, Rect rect) {
        int i = rect.left;
        int i2 = this.scannerStart;
        this.f15016a.setShader(new LinearGradient(i, i2, i, i2 + this.Z, shadeColor(this.M), this.M, Shader.TileMode.MIRROR));
        if (this.scannerStart > this.scannerEnd) {
            this.scannerStart = rect.top;
            return;
        }
        int i3 = rect.left;
        int i4 = this.Z;
        int i5 = this.scannerStart;
        canvas.drawOval(new RectF(i3 + (i4 * 2), i5, rect.right - (i4 * 2), i5 + i4), this.f15016a);
        this.scannerStart += this.Y;
    }

    public final void g(Canvas canvas, Rect rect) {
        if (this.f15022a) {
            List<xg7> list = this.f15021a;
            List<xg7> list2 = this.f15023c;
            if (list.isEmpty()) {
                this.f15023c = null;
            } else {
                this.f15021a = new ArrayList(5);
                this.f15023c = list;
                this.f15016a.setAlpha(160);
                this.f15016a.setColor(this.O);
                synchronized (list) {
                    for (xg7 xg7Var : list) {
                        canvas.drawCircle(xg7Var.c(), xg7Var.d(), 10.0f, this.f15016a);
                    }
                }
            }
            if (list2 != null) {
                this.f15016a.setAlpha(80);
                this.f15016a.setColor(this.O);
                synchronized (list2) {
                    for (xg7 xg7Var2 : list2) {
                        canvas.drawCircle(xg7Var2.c(), xg7Var2.d(), 10.0f, this.f15016a);
                    }
                }
            }
        }
    }

    public final void h(Canvas canvas, Rect rect) {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        this.f15018a.setColor(this.P);
        this.f15018a.setTextSize(this.b);
        this.f15018a.setTextAlign(Paint.Align.CENTER);
        StaticLayout staticLayout = new StaticLayout(this.f, this.f15018a, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        if (this.f15020a == TextLocation.BOTTOM) {
            canvas.translate(rect.left + (rect.width() / 2), rect.bottom + this.f40016a);
            staticLayout.draw(canvas);
        } else {
            canvas.translate(rect.left + (rect.width() / 2), (rect.top - this.f40016a) - staticLayout.getHeight());
            staticLayout.draw(canvas);
        }
    }

    public final void i(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        this.K = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_maskColor, ContextCompat.getColor(context, R.color.viewfinder_mask));
        this.L = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_frameColor, ContextCompat.getColor(context, R.color.viewfinder_frame));
        this.N = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_cornerColor, ContextCompat.getColor(context, R.color.viewfinder_corner));
        this.M = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_laserColor, ContextCompat.getColor(context, R.color.viewfinder_laser));
        this.O = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_resultPointColor, ContextCompat.getColor(context, R.color.viewfinder_result_point_color));
        this.f = typedArrayObtainStyledAttributes.getString(R.styleable.ViewfinderView_labelText);
        this.P = typedArrayObtainStyledAttributes.getColor(R.styleable.ViewfinderView_labelTextColor, ContextCompat.getColor(context, R.color.viewfinder_text_color));
        this.b = typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.f40016a = typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.f15020a = TextLocation.getFromInt(typedArrayObtainStyledAttributes.getInt(R.styleable.ViewfinderView_labelTextLocation, 0));
        this.f15022a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_showResultPoint, false);
        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_frameWidth, 0);
        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_frameHeight, 0);
        this.f15019a = LaserStyle.getFromInt(typedArrayObtainStyledAttributes.getInt(R.styleable.ViewfinderView_laserStyle, LaserStyle.LINE.mValue));
        this.U = typedArrayObtainStyledAttributes.getInt(R.styleable.ViewfinderView_gridColumn, 20);
        this.V = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.W = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_cornerRectWidth, TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        this.X = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_cornerRectHeight, TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics()));
        this.Y = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scannerLineMoveDistance, TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.Z = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scannerLineHeight, TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()));
        this.a0 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ViewfinderView_frameLineWidth, TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.b0 = typedArrayObtainStyledAttributes.getInteger(R.styleable.ViewfinderView_scannerAnimationDelay, 15);
        this.c = typedArrayObtainStyledAttributes.getFloat(R.styleable.ViewfinderView_frameRatio, 0.625f);
        typedArrayObtainStyledAttributes.recycle();
        this.f15016a = new Paint(1);
        this.f15018a = new TextPaint(1);
        this.f15021a = new ArrayList(5);
        this.f15023c = null;
        this.Q = getDisplayMetrics().widthPixels;
        int i = getDisplayMetrics().heightPixels;
        this.R = i;
        int iMin = (int) (Math.min(this.Q, i) * this.c);
        int i2 = this.S;
        if (i2 <= 0 || i2 > this.Q) {
            this.S = iMin;
        }
        int i3 = this.T;
        if (i3 <= 0 || i3 > this.R) {
            this.T = iMin;
        }
    }

    public boolean isShowResultPoint() {
        return this.f15022a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect = this.f15017a;
        if (rect == null) {
            return;
        }
        if (this.scannerStart == 0 || this.scannerEnd == 0) {
            this.scannerStart = rect.top;
            this.scannerEnd = rect.bottom - this.Z;
        }
        b(canvas, this.f15017a, canvas.getWidth(), canvas.getHeight());
        e(canvas, this.f15017a);
        c(canvas, this.f15017a);
        a(canvas, this.f15017a);
        h(canvas, this.f15017a);
        g(canvas, this.f15017a);
        long j = this.b0;
        Rect rect2 = this.f15017a;
        postInvalidateDelayed(j, rect2.left - 20, rect2.top - 20, rect2.right + 20, rect2.bottom + 20);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (((this.Q - this.S) / 2) + getPaddingLeft()) - getPaddingRight();
        int paddingTop = (((this.R - this.T) / 2) + getPaddingTop()) - getPaddingBottom();
        this.f15017a = new Rect(paddingLeft, paddingTop, this.S + paddingLeft, this.T + paddingTop);
    }

    public void setLabelText(String str) {
        this.f = str;
    }

    public void setLabelTextColor(@ColorInt int i) {
        this.P = i;
    }

    public void setLabelTextColorResource(@ColorRes int i) {
        this.P = ContextCompat.getColor(getContext(), i);
    }

    public void setLabelTextSize(float f) {
        this.b = f;
    }

    public void setLaserStyle(LaserStyle laserStyle) {
        this.f15019a = laserStyle;
    }

    public void setShowResultPoint(boolean z) {
        this.f15022a = z;
    }

    public int shadeColor(int i) {
        return Integer.valueOf(HiAnalyticsConstant.KeyAndValue.NUMBER_01 + Integer.toHexString(i).substring(2), 16).intValue();
    }

    public ViewfinderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scannerStart = 0;
        this.scannerEnd = 0;
        i(context, attributeSet);
    }
}
