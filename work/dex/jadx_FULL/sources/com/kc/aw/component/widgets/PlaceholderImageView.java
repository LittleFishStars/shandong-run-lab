package com.kc.aw.component.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PlaceholderImageView extends AppCompatImageView {
    public static final int _h = Color.parseColor("#F0F0F0");
    public static final int _i = Color.parseColor("#666666");
    public Paint _a;
    public Paint _b;
    public boolean _c;
    public String _d;
    public float _e;
    public Path _f;
    public RectF _g;

    public PlaceholderImageView(Context context) {
        super(context);
        this._c = true;
        this._d = "Ad";
        this._e = 0.0f;
        _a(context, null);
    }

    public PlaceholderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._c = true;
        this._d = "Ad";
        this._e = 0.0f;
        _a(context, attributeSet);
    }

    public PlaceholderImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._c = true;
        this._d = "Ad";
        this._e = 0.0f;
        _a(context, attributeSet);
    }

    public final void _a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this._a = paint;
        paint.setColor(_h);
        this._a.setStyle(Paint.Style.FILL);
        this._a.setAntiAlias(true);
        Paint paint2 = new Paint();
        this._b = paint2;
        paint2.setColor(_i);
        this._b.setTextAlign(Paint.Align.CENTER);
        this._b.setAntiAlias(true);
        this._b.setTextSize(getResources().getDisplayMetrics().density * 16.0f);
        this._f = new Path();
        this._g = new RectF();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AwPlaceholderImageView);
            try {
                this._e = typedArrayObtainStyledAttributes.getDimension(R.styleable.AwPlaceholderImageView_aw_cornerRadius, 0.0f);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public final void _a(Canvas canvas) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (this._e > 0.0f) {
            this._g.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + height);
            RectF rectF = this._g;
            float f = this._e;
            canvas.drawRoundRect(rectF, f, f, this._a);
        } else {
            canvas.drawRect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + height, this._a);
        }
        String str = this._d;
        if (str == null || str.isEmpty()) {
            return;
        }
        Rect rect = new Rect();
        Paint paint = this._b;
        String str2 = this._d;
        paint.getTextBounds(str2, 0, str2.length(), rect);
        canvas.drawText(this._d, (width / 2.0f) + getPaddingLeft(), (rect.height() / 2.0f) + (height / 2.0f) + getPaddingTop(), this._b);
    }

    public float getCornerRadius() {
        return this._e;
    }

    public float getCornerRadiusDp() {
        return this._e / getResources().getDisplayMetrics().density;
    }

    public String getPlaceholderText() {
        return this._d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this._e <= 0.0f) {
            if (this._c && getDrawable() == null) {
                _a(canvas);
                return;
            } else {
                super.onDraw(canvas);
                return;
            }
        }
        int iSave = canvas.save();
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            this._g.set(0.0f, 0.0f, width, height);
            this._f.reset();
            Path path = this._f;
            RectF rectF = this._g;
            float f = this._e;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            canvas.clipPath(this._f);
        }
        if (this._c && getDrawable() == null) {
            _a(canvas);
        } else {
            super.onDraw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    public void setCornerRadius(float f) {
        this._e = f;
        invalidate();
    }

    public void setCornerRadiusDp(float f) {
        setCornerRadius(f * getResources().getDisplayMetrics().density);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        boolean z;
        super.setImageBitmap(bitmap);
        if (bitmap == null || bitmap.isRecycled()) {
            if (this._c) {
                return;
            } else {
                z = true;
            }
        } else if (!this._c) {
            return;
        } else {
            z = false;
        }
        this._c = z;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        boolean z;
        super.setImageDrawable(drawable);
        if (drawable != null) {
            if (!this._c) {
                return;
            } else {
                z = false;
            }
        } else if (this._c) {
            return;
        } else {
            z = true;
        }
        this._c = z;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        boolean z;
        super.setImageResource(i);
        if (i != 0) {
            if (!this._c) {
                return;
            } else {
                z = false;
            }
        } else if (this._c) {
            return;
        } else {
            z = true;
        }
        this._c = z;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        boolean z;
        super.setImageURI(uri);
        if (uri != null) {
            if (!this._c) {
                return;
            } else {
                z = false;
            }
        } else if (this._c) {
            return;
        } else {
            z = true;
        }
        this._c = z;
        invalidate();
    }

    public void setPlaceholderBackgroundColor(int i) {
        this._a.setColor(i);
        if (this._c) {
            invalidate();
        }
    }

    public void setPlaceholderText(String str) {
        this._d = str;
        if (this._c) {
            invalidate();
        }
    }

    public void setPlaceholderTextColor(int i) {
        this._b.setColor(i);
        if (this._c) {
            invalidate();
        }
    }

    public void setPlaceholderTextSize(float f) {
        this._b.setTextSize(f * getResources().getDisplayMetrics().scaledDensity);
        if (this._c) {
            invalidate();
        }
    }
}
