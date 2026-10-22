package com.byazt.vn;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.byazt.nr.m;
import com.byazt.rb.sp;
import com.byazt.rb.x;
import com.byazt.sa.uj;
import com.byazt.sz.n;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 660, 1887})
public class RoundImageView extends ImageView implements sp, n {
    public static final /* synthetic */ boolean tt = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f29136a;
    public final RectF d;
    public boolean da;
    public Path gr;
    public uj gt;
    public float gu;
    public Bitmap h;
    public ColorFilter i;
    public int m;
    public Canvas md;
    public Shader.TileMode my;
    public final float[] n;
    public ImageView.ScaleType nu;
    public float p;
    public boolean qy;
    public Shader.TileMode rh;
    public x rl;
    public Drawable sl;
    public ColorStateList sp;
    public boolean t;
    public boolean u;
    public float ve;
    public float x;
    public boolean yp;
    public float yv;
    public int z;
    public Paint zm;
    public static final Shader.TileMode c = Shader.TileMode.CLAMP;
    public static final ImageView.ScaleType[] uj = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: com.byazt.vn.RoundImageView$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 660, 1571})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            c = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundImageView(Context context) {
        super(context);
        this.n = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.sp = ColorStateList.valueOf(-16777216);
        this.x = 0.0f;
        this.i = null;
        this.da = false;
        this.t = false;
        this.u = false;
        this.yp = false;
        Shader.TileMode tileMode = c;
        this.rh = tileMode;
        this.my = tileMode;
        this.qy = false;
        this.gu = 50.0f;
        this.d = new RectF();
        this.rl = new x(this);
    }

    private Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.z;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                m.tt("RoundedImageView", "Unable to find resource: " + this.z, e);
                this.z = 0;
            }
        }
        return c.c(drawable);
    }

    private Drawable tt() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.m;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                m.tt("RoundedImageView", "Unable to find resource: " + this.m, e);
                this.m = 0;
            }
        }
        return c.c(drawable);
    }

    private void uj() {
        Drawable drawable = this.sl;
        if (drawable == null || !this.da) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.sl = drawableMutate;
        if (this.t) {
            drawableMutate.setColorFilter(this.i);
        }
    }

    private void ve() {
        c(this.sl, this.nu);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.tt(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.sp.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.sp;
    }

    public float getBorderRadius() {
        return this.rl.c();
    }

    public float getBorderWidth() {
        return this.x;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.n) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    @Override // com.byazt.rb.sp
    public float getRipple() {
        return this.ve;
    }

    @Override // com.byazt.rb.sp
    public float getRubIn() {
        return this.rl.getRubIn();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.nu;
    }

    @Override // com.byazt.rb.sp
    public float getShine() {
        return this.rl.getShine();
    }

    @Override // com.byazt.rb.sp
    public float getStretch() {
        return this.rl.getStretch();
    }

    public Shader.TileMode getTileModeX() {
        return this.rh;
    }

    public Shader.TileMode getTileModeY() {
        return this.my;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.a();
        }
        Canvas canvas = this.md;
        if (canvas != null) {
            canvas.setBitmap(null);
        }
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            bitmap.recycle();
            this.md = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (!this.qy || (canvas2 = this.md) == null || this.h == null) {
            super.onDraw(canvas);
        } else {
            super.onDraw(canvas2);
            this.md.drawPath(this.gr, this.zm);
            canvas.drawBitmap(this.h, 0.0f, 0.0f, (Paint) null);
        }
        uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.c(canvas, this);
            this.gt.c(canvas);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.c(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.gt;
        if (ujVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i3);
        }
        if (i <= 0 || i2 <= 0 || !this.qy) {
            return;
        }
        this.h = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.md = new Canvas(this.h);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iWidth;
        if (!this.qy) {
            return super.onTouchEvent(motionEvent);
        }
        this.gt.n();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.gr.moveTo(x, y);
            this.yv = x;
            this.p = y;
            HashMap map = new HashMap();
            map.put("state", 1);
            this.gt.c("eraseState", map);
        } else if (action == 1) {
            this.gr.computeBounds(this.d, true);
            try {
                iWidth = (int) (((this.d.width() * this.d.height()) / (getWidth() * getHeight())) * 100.0f);
            } catch (Exception unused) {
                iWidth = 0;
            }
            HashMap map2 = new HashMap();
            map2.put("state", 2);
            map2.put("percent", Integer.valueOf(iWidth));
            this.gt.c("eraseState", map2);
        } else if (action == 2 && x > 0.0f && x < getWidth() && y > 0.0f && y < getHeight()) {
            float f = this.yv;
            float f2 = this.p;
            this.gr.quadTo(f, f2, (f + x) / 2.0f, (f2 + y) / 2.0f);
            this.yv = x;
            this.p = y;
        }
        postInvalidate();
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.f29136a = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f29136a = drawable;
        c(true);
        super.setBackgroundDrawable(this.f29136a);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.m != i) {
            this.m = i;
            Drawable drawableTt = tt();
            this.f29136a = drawableTt;
            setBackgroundDrawable(drawableTt);
        }
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderRadius(float f) {
        x xVar = this.rl;
        if (xVar != null) {
            xVar.c(f);
        }
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.i != colorFilter) {
            this.i = colorFilter;
            this.t = true;
            this.da = true;
            uj();
            invalidate();
        }
    }

    public void setCornerRadius(float f) {
        c(f, f, f, f);
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        c(dimension, dimension, dimension, dimension);
    }

    public void setEraseEnabled(boolean z) {
        if (z) {
            this.gr = new Path();
            Paint paint = new Paint();
            this.zm = paint;
            paint.setAntiAlias(true);
            this.zm.setDither(true);
            this.zm.setStyle(Paint.Style.STROKE);
            this.zm.setStrokeWidth(this.gu * 2.0f);
            this.zm.setStrokeCap(Paint.Cap.ROUND);
            this.zm.setStrokeJoin(Paint.Join.ROUND);
            this.zm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.zm.setColor(0);
            this.qy = true;
        } else {
            this.qy = false;
        }
        postInvalidate();
    }

    public void setEraseRadius(float f) {
        this.gu = f;
        Paint paint = this.zm;
        if (paint != null) {
            paint.setStrokeWidth(f * 2.0f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.z = 0;
        this.sl = c.c(bitmap);
        ve();
        super.setImageDrawable(this.sl);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.z = 0;
        this.sl = c.c(drawable);
        ve();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.z != i) {
            this.z = i;
            this.sl = c();
            ve();
            super.setImageDrawable(this.sl);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.u = z;
        ve();
        c(false);
        invalidate();
    }

    public void setRipple(float f) {
        this.ve = f;
        x xVar = this.rl;
        if (xVar != null) {
            xVar.tt(f);
        }
        postInvalidate();
    }

    public void setRubIn(float f) {
        x xVar = this.rl;
        if (xVar != null) {
            xVar.n(f);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!tt && scaleType == null) {
            throw new AssertionError();
        }
        if (this.nu != scaleType) {
            this.nu = scaleType;
            int i = AnonymousClass1.c[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            ve();
            c(false);
            invalidate();
        }
    }

    public void setShine(float f) {
        x xVar = this.rl;
        if (xVar != null) {
            xVar.ve(f);
        }
    }

    public void setStretch(float f) {
        x xVar = this.rl;
        if (xVar != null) {
            xVar.uj(f);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.rh == tileMode) {
            return;
        }
        this.rh = tileMode;
        ve();
        c(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.my == tileMode) {
            return;
        }
        this.my = tileMode;
        ve();
        c(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.sp.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.sp = colorStateList;
        ve();
        c(false);
        if (this.x > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.x == f) {
            return;
        }
        this.x = f;
        ve();
        c(false);
        invalidate();
    }

    private void c(boolean z) {
        if (this.yp) {
            if (z) {
                this.f29136a = c.c(this.f29136a);
            }
            c(this.f29136a, ImageView.ScaleType.FIT_XY);
        }
    }

    private void c(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof c) {
            c cVar = (c) drawable;
            cVar.c(scaleType).c(this.x).c(this.sp).c(this.u).c(this.rh).tt(this.my);
            float[] fArr = this.n;
            if (fArr != null) {
                cVar.c(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            uj();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                c(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    public void c(float f, float f2, float f3, float f4) {
        float[] fArr = this.n;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        ve();
        c(false);
        invalidate();
    }

    public void c(uj ujVar) {
        this.gt = ujVar;
    }
}
