package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;
    public static final float b = 0.01f;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f31053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AspectRatioListener f4720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f4721a;

    public interface AspectRatioListener {
        void a(float f, float f2, boolean z);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f31054a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4723a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4724b;

        public b() {
        }

        public void a(float f, float f2, boolean z) {
            this.f31054a = f;
            this.b = f2;
            this.f4723a = z;
            if (this.f4724b) {
                return;
            }
            this.f4724b = true;
            AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4724b = false;
            if (AspectRatioFrameLayout.this.f4720a == null) {
                return;
            }
            AspectRatioFrameLayout.this.f4720a.a(this.f31054a, this.b, this.f4723a);
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.K;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.f31053a <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f3 = measuredWidth;
        float f4 = measuredHeight;
        float f5 = f3 / f4;
        float f6 = (this.f31053a / f5) - 1.0f;
        if (Math.abs(f6) <= 0.01f) {
            this.f4721a.a(this.f31053a, f5, false);
            return;
        }
        int i3 = this.K;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f = this.f31053a;
                } else if (i3 == 4) {
                    if (f6 > 0.0f) {
                        f = this.f31053a;
                    } else {
                        f2 = this.f31053a;
                    }
                }
                measuredWidth = (int) (f4 * f);
            } else {
                f2 = this.f31053a;
            }
            measuredHeight = (int) (f3 / f2);
        } else if (f6 > 0.0f) {
            f2 = this.f31053a;
            measuredHeight = (int) (f3 / f2);
        } else {
            f = this.f31053a;
            measuredWidth = (int) (f4 * f);
        }
        this.f4721a.a(this.f31053a, f5, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f) {
        if (this.f31053a != f) {
            this.f31053a = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioListener aspectRatioListener) {
        this.f4720a = aspectRatioListener;
    }

    public void setResizeMode(int i) {
        if (this.K != i) {
            this.K = i;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.K = typedArrayObtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f4721a = new b();
    }
}
