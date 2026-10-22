package com.kc.aw.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.kc.aw._m0;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgRoundFrameLayout extends FrameLayout {
    public _a _a;

    @Keep
    public static final class _a {
        public float[] _a;
        public Path _b;
        public Paint _c;
        public boolean _d;
        public int _e;
        public int _f;
        public ColorStateList _g;
        public int _h;
        public boolean _i;
        public boolean _j;
        public RectF _k;
        public RectF _l;
        public PointF _m;
        public PorterDuffXfermode _n;
        public PorterDuffXfermode _o;
        public PorterDuffXfermode _p;

        public _a() {
            this._a = new float[8];
            this._d = false;
        }

        public /* synthetic */ _a(int i) {
            this();
        }

        public static void _b(View view) {
            view.setLayerType(2, null);
        }

        public final void _a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AwRoundFrameLayoutStyle);
            this._d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AwRoundFrameLayoutStyle_aw_round_as_circle, false);
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.AwRoundFrameLayoutStyle_aw_round_stroke_color);
            this._g = colorStateList;
            if (colorStateList != null) {
                this._f = colorStateList.getDefaultColor();
                this._e = this._g.getDefaultColor();
            } else {
                this._f = -1;
                this._e = -1;
            }
            this._h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AwRoundFrameLayoutStyle_aw_round_stroke_width, 0);
            this._i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AwRoundFrameLayoutStyle_aw_clip_background, true);
            this._j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AwRoundFrameLayoutStyle_aw_clip_padding, false);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AwRoundFrameLayoutStyle_aw_round_corner, 0);
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AwRoundFrameLayoutStyle_aw_round_corner_top_left, dimensionPixelSize);
            int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AwRoundFrameLayoutStyle_aw_round_corner_top_right, dimensionPixelSize);
            int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AwRoundFrameLayoutStyle_aw_round_corner_bottom_left, dimensionPixelSize);
            int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AwRoundFrameLayoutStyle_aw_round_corner_bottom_right, dimensionPixelSize);
            typedArrayObtainStyledAttributes.recycle();
            float[] fArr = this._a;
            float f = dimensionPixelSize2;
            fArr[0] = f;
            fArr[1] = f;
            float f2 = dimensionPixelSize3;
            fArr[2] = f2;
            fArr[3] = f2;
            float f3 = dimensionPixelSize5;
            fArr[4] = f3;
            fArr[5] = f3;
            float f4 = dimensionPixelSize4;
            fArr[6] = f4;
            fArr[7] = f4;
            this._k = new RectF();
            this._b = new Path();
            Paint paint = new Paint();
            this._c = paint;
            paint.setColor(-1);
            this._c.setAntiAlias(true);
            this._c.setDither(true);
            this._c.setStrokeCap(Paint.Cap.ROUND);
            this._c.setStrokeJoin(Paint.Join.ROUND);
            this._l = new RectF();
            this._m = new PointF(0.0f, 0.0f);
            this._n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this._o = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
            this._p = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void _a(View view) {
            ColorStateList colorStateList;
            if ((view instanceof _m0) && (colorStateList = this._g) != null && colorStateList.isStateful()) {
                ArrayList arrayList = new ArrayList();
                if (view instanceof Checkable) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_checkable));
                    if (((Checkable) view).isChecked()) {
                        arrayList.add(Integer.valueOf(android.R.attr.state_checked));
                    }
                }
                if (view.isEnabled()) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_enabled));
                }
                if (view.isFocused()) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_focused));
                }
                if (view.isPressed()) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_pressed));
                }
                if (view.isHovered()) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_hovered));
                }
                if (view.isSelected()) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_selected));
                }
                if (view.isActivated()) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_activated));
                }
                if (view.hasWindowFocus()) {
                    arrayList.add(Integer.valueOf(android.R.attr.state_window_focused));
                }
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
                ((PtgRoundFrameLayout) view).setStrokeColor(this._g.getColorForState(iArr, this._e));
            }
        }

        public final void _c(View view) {
            int iWidth = (int) this._k.width();
            int iHeight = (int) this._k.height();
            if (this._j) {
                this._l.left = view.getPaddingLeft();
                this._l.top = view.getPaddingTop();
                this._l.right = iWidth - view.getPaddingRight();
                this._l.bottom = iHeight - view.getPaddingBottom();
            } else {
                RectF rectF = this._l;
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = iWidth;
                rectF.bottom = iHeight;
            }
            this._b.reset();
            if (!this._d) {
                this._b.addRoundRect(this._l, this._a, Path.Direction.CW);
                return;
            }
            float fMin = Math.min(this._l.width(), this._l.height()) / 2.0f;
            PointF pointF = this._m;
            float f = iWidth / 2;
            pointF.x = f;
            float f2 = iHeight / 2;
            pointF.y = f2;
            this._b.addCircle(f, f2, fMin, Path.Direction.CW);
        }
    }

    public PtgRoundFrameLayout(Context context) {
        super(context);
        _a _aVar = new _a(0);
        this._a = _aVar;
        _aVar._a(context, null);
    }

    public PtgRoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        _a _aVar = new _a(0);
        this._a = _aVar;
        _aVar._a(context, attributeSet);
    }

    public PtgRoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a _aVar = new _a(0);
        this._a = _aVar;
        _aVar._a(context, attributeSet);
    }

    public PtgRoundFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        _a _aVar = new _a(0);
        this._a = _aVar;
        _aVar._a(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(this._a._k, null, 31);
        super.dispatchDraw(canvas);
        this._a.getClass();
        _a._b(this);
        _a _aVar = this._a;
        if (!_aVar._d) {
            float[] fArr = _aVar._a;
            if (fArr[0] <= 0.0f && fArr[2] <= 0.0f && fArr[4] <= 0.0f) {
                float f = fArr[6];
            }
        }
        if (_aVar._h > 0) {
            _aVar._c.setXfermode(_aVar._n);
            _aVar._c.setColor(-1);
            _aVar._c.setStrokeWidth(_aVar._h);
            _aVar._c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(_aVar._b, _aVar._c);
            _aVar._c.setXfermode(_aVar._o);
            _aVar._c.setColor(_aVar._f);
            _aVar._c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(_aVar._b, _aVar._c);
        }
        _aVar._c.setXfermode(_aVar._p);
        _aVar._c.setColor(-1);
        _aVar._c.setStyle(Paint.Style.FILL);
        canvas.drawPath(_aVar._b, _aVar._c);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        this._a._c(this);
        if (!this._a._i) {
            super.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this._a._b);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this._a._a(this);
    }

    public float getBottomLeftRadius() {
        return this._a._a[4];
    }

    public float getBottomRightRadius() {
        return this._a._a[6];
    }

    public int getStrokeColor() {
        return this._a._f;
    }

    public int getStrokeWidth() {
        return this._a._h;
    }

    public float getTopLeftRadius() {
        return this._a._a[0];
    }

    public float getTopRightRadius() {
        return this._a._a[2];
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        _a _aVar = this._a;
        _aVar._k.set(0.0f, 0.0f, i, i2);
        _aVar._c(this);
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        this._a._a(this);
    }

    public void setBottomLeftRadius(int i) {
        float[] fArr = this._a._a;
        float f = i;
        fArr[4] = f;
        fArr[5] = f;
        invalidate();
    }

    public void setBottomRightRadius(int i) {
        float[] fArr = this._a._a;
        float f = i;
        fArr[6] = f;
        fArr[7] = f;
        invalidate();
    }

    public void setClipBackground(boolean z) {
        this._a._i = z;
        invalidate();
    }

    public void setRadius(int i) {
        int i2 = 0;
        while (true) {
            float[] fArr = this._a._a;
            if (i2 >= fArr.length) {
                invalidate();
                return;
            } else {
                fArr[i2] = i;
                i2++;
            }
        }
    }

    public void setRoundAsCircle(boolean z) {
        this._a._d = z;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this._a._f = i;
        invalidate();
    }

    public void setStrokeWidth(int i) {
        this._a._h = i;
        invalidate();
    }

    public void setTopLeftRadius(int i) {
        float[] fArr = this._a._a;
        float f = i;
        fArr[0] = f;
        fArr[1] = f;
        invalidate();
    }

    public void setTopRightRadius(int i) {
        float[] fArr = this._a._a;
        float f = i;
        fArr[2] = f;
        fArr[3] = f;
        invalidate();
    }
}
