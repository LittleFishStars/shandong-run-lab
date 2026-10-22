package com.kc.cw.ad.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.ipd.dsp.internal.b1.b;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class FlickerProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PorterDuffXfermode f39077a;
    private int b;
    private final float c;
    private Paint d;
    private Paint e;
    private Paint f;
    private String g;
    private Rect h;
    private RectF i;
    private Canvas j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private Bitmap o;
    private float p;
    private int q;
    private int r;
    private int s;

    public FlickerProgressBar(Context context) {
        this(context, null, 0);
    }

    public FlickerProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlickerProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39077a = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.c = 100.0f;
        a(attributeSet);
    }

    private void a(Canvas canvas) {
        this.e.setColor(this.s);
        RectF rectF = this.i;
        int i = this.n;
        canvas.drawRoundRect(rectF, i, i, this.e);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SsFlickerProgressBar);
        try {
            this.m = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.SsFlickerProgressBar_ssTextSize, 12.0f);
            this.q = typedArrayObtainStyledAttributes.getColor(R.styleable.SsFlickerProgressBar_ssLoadingColor, Color.parseColor("#40c4ff"));
            this.r = typedArrayObtainStyledAttributes.getColor(R.styleable.SsFlickerProgressBar_ssStopColor, Color.parseColor("#ff9800"));
            this.n = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.SsFlickerProgressBar_ssRadius, 0.0f);
            this.b = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.SsFlickerProgressBar_ssBorderWidth, 2.0f);
            this.g = "立即下载";
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void b(Canvas canvas) {
        this.f.setColor(this.s);
        float f = this.p / 100.0f;
        float measuredWidth = getMeasuredWidth();
        this.j.save();
        this.j.clipRect(0.0f, 0.0f, f * measuredWidth, getMeasuredHeight());
        this.j.drawColor(this.s);
        this.j.restore();
        if (!this.l) {
            this.f.setXfermode(this.f39077a);
            this.f.setXfermode(null);
        }
        Bitmap bitmap = this.o;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        RectF rectF = this.i;
        int i = this.n;
        canvas.drawRoundRect(rectF, i, i, this.f);
    }

    private void c() {
        Paint paint = new Paint(5);
        this.e = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.b);
        Paint paint2 = new Paint(1);
        this.f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setTextSize(this.m);
        this.h = new Rect();
        int i = this.b;
        this.i = new RectF(i, i, getMeasuredWidth() - this.b, getMeasuredHeight() - this.b);
        this.s = this.l ? this.r : this.q;
        d();
    }

    private void c(Canvas canvas) {
        this.d.setColor(this.s);
        Paint paint = this.d;
        String str = this.g;
        paint.getTextBounds(str, 0, str.length(), this.h);
        canvas.drawText(this.g, (getMeasuredWidth() - this.h.width()) / 2.0f, (getMeasuredHeight() + this.h.height()) / 2.0f, this.d);
    }

    private void d() {
        this.o = Bitmap.createBitmap(getMeasuredWidth() - this.b, getMeasuredHeight() - this.b, Bitmap.Config.ARGB_8888);
        this.j = new Canvas(this.o);
    }

    private void d(Canvas canvas) {
        this.d.setColor(-1);
        int iWidth = this.h.width();
        int iHeight = this.h.height();
        float measuredWidth = (getMeasuredWidth() - iWidth) / 2.0f;
        float measuredHeight = (getMeasuredHeight() + iHeight) / 2.0f;
        float measuredWidth2 = (this.p / 100.0f) * getMeasuredWidth();
        if (measuredWidth2 > measuredWidth) {
            canvas.save();
            canvas.clipRect(measuredWidth, 0.0f, Math.min(measuredWidth2, (iWidth * 1.1f) + measuredWidth), getMeasuredHeight());
            canvas.drawText(this.g, measuredWidth, measuredHeight, this.d);
            canvas.restore();
        }
    }

    public void a() {
        this.g = "点击安装";
        this.k = true;
        setStop(true);
    }

    public void b() {
        setStop(true);
        this.p = 0.0f;
        this.k = false;
        this.l = false;
        this.s = this.q;
        this.g = "立即下载";
        d();
    }

    public float getProgress() {
        return this.p;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
        c(canvas);
        d(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size2 = ViewUtil.dip2px(getContext(), 36.0f);
        } else if (mode != 0 && mode != 1073741824) {
            size2 = 0;
        }
        setMeasuredDimension(size, size2);
        if (this.o == null) {
            c();
        }
    }

    public void setProgress(float f) {
        if (this.l) {
            return;
        }
        if (f < 100.0f) {
            this.p = f;
        } else {
            this.p = 100.0f;
            a();
        }
        invalidate();
    }

    public void setStatus(int i) {
        String str;
        if (i == 2) {
            this.l = false;
            str = b.a.m + this.p + "%";
        } else if (i == 4) {
            this.l = true;
            str = b.a.n;
        } else {
            if (i != 8) {
                if (i == 16) {
                    str = "下载失败";
                }
                invalidate();
            }
            this.k = true;
            str = "点击安装";
        }
        this.g = str;
        invalidate();
    }

    public void setStop(boolean z) {
        this.l = z;
        this.s = z ? this.r : this.q;
        invalidate();
    }
}
