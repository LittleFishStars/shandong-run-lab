package com.kc.aw.component.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdvertRatioLayout extends FrameLayout {
    public float _a;
    public float _b;
    public int _c;
    public float _d;
    public int _e;
    public int _f;
    public _a _g;

    @Keep
    public interface _a {
        void _a(int i, int i2);
    }

    public AdvertRatioLayout(Context context) {
        this(context, null, 0);
        _a();
    }

    public AdvertRatioLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        _a();
    }

    public AdvertRatioLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._a = -1.0f;
        this._b = -1.0f;
        this._c = 0;
        _a();
    }

    public final void _a() {
        this._c = 1;
        this._d = 0.55f;
    }

    public float getMaxHeight() {
        return this._a;
    }

    public float getMaxWidth() {
        return this._b;
    }

    public float getRatio() {
        return this._d;
    }

    public int getRatioStandard() {
        return this._c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        _a _aVar;
        int i3;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (this._d == 0.0f && (mode == 0 || mode == Integer.MIN_VALUE)) {
            this._d = 0.55f;
        }
        float f = this._d;
        if (!(f > 0.0f && ((i3 = this._c) == 1 || i3 == 2))) {
            super.onMeasure(i, i2);
            return;
        }
        int i4 = this._c;
        if (i4 != 1) {
            if (i4 == 2) {
                float f2 = this._a;
                if (f2 > -1.0f && size > f2) {
                    size = (int) f2;
                }
                if (f >= 0.0f) {
                    size2 = (int) (size * f);
                }
                float f3 = this._b;
                if (f3 > -1.0f && size2 > f3) {
                    size2 = (int) f3;
                }
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            } else {
                float f4 = this._b;
                if (f4 > -1.0f && size2 > f4) {
                    size2 = (int) f4;
                }
                float f5 = this._a;
                if (f5 > -1.0f && size > f5) {
                    size = (int) f5;
                }
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
            }
            super.onMeasure(iMakeMeasureSpec2, iMakeMeasureSpec);
            if ((this._e == size2 || this._f != size) && (_aVar = this._g) != null) {
                _aVar._a(size2, size);
            }
            this._e = size2;
            this._f = size;
        }
        float f6 = this._b;
        if (f6 > -1.0f && size2 > f6) {
            size2 = (int) f6;
        }
        if (f >= 0.0f) {
            size = (int) (size2 * f);
        }
        float f7 = this._a;
        if (f7 > -1.0f && size > f7) {
            size = (int) f7;
        }
        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, mode2);
        super.onMeasure(iMakeMeasureSpec2, iMakeMeasureSpec);
        if (this._e == size2) {
            _aVar._a(size2, size);
        } else {
            _aVar._a(size2, size);
        }
        this._e = size2;
        this._f = size;
    }

    public void setMaxHeight(float f) {
        this._a = f;
    }

    public void setMaxWidth(float f) {
        this._b = f;
    }

    public void setRatio(float f) {
        this._d = f;
    }

    public void setRatioStandard(int i) {
        this._c = i;
    }

    public void setSizeCallback(_a _aVar) {
        this._g = _aVar;
    }
}
