package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ViewPagerIndicator extends View {
    private int lU;
    private final Context mContext;
    private int ma;
    private int mb;
    private int mc;
    private float md;
    private float me;
    private Paint mf;
    private float mg;
    private float mh;
    private float mi;
    private int mj;
    private Paint mk;
    private float ml;
    private a mm;
    private ValueAnimator mn;

    public interface a {
        void T(int i);
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i) {
        if (this.mj <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mi, this.mh);
        this.mn = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(((long) this.mj) * 1000);
        this.mn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.ml = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.mn.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (ViewPagerIndicator.this.mm != null) {
                    ViewPagerIndicator.this.mm.T(i);
                }
            }
        });
        this.mn.start();
    }

    private void dL() {
        Paint paint = new Paint(1);
        this.mf = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mf.setStrokeWidth(1.0f);
        this.mf.setColor(this.mb);
        Paint paint2 = new Paint(1);
        this.mk = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mk.setStrokeWidth(1.0f);
        this.mk.setColor(this.ma);
    }

    @RequiresApi(api = 19)
    public final void dM() {
        ValueAnimator valueAnimator = this.mn;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void dN() {
        ValueAnimator valueAnimator = this.mn;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.mg : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                int i3 = this.mc;
                size = i3 > 1 ? (int) (this.mh + ((i3 - 1) * (this.me + this.mi))) : (int) this.mh;
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setAdShowTime(int i) {
        this.mj = i;
    }

    public void setPlayProgressListener(a aVar) {
        this.mm = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.mc = count;
        if (count <= 1) {
            return;
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                ViewPagerIndicator.this.ml = 0.0f;
                ViewPagerIndicator.this.lU = i;
                ViewPagerIndicator.this.md = f;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                ViewPagerIndicator.this.lU = i;
                ViewPagerIndicator.this.md = 1.0f;
                ViewPagerIndicator.this.invalidate();
                if (i < ViewPagerIndicator.this.mc - 1) {
                    ViewPagerIndicator.this.V(i);
                }
            }
        });
        V(this.lU);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i);
        dL();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i, 0);
        this.me = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.c.a.a.a(this.mContext, 5.0f));
        this.mg = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.mh = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.c.a.a.a(this.mContext, 50.0f));
        this.mi = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.mb = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.ma = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void b(Canvas canvas) {
        if (this.ml > 0.0f) {
            int i = this.lU;
            float f = this.me;
            float f2 = this.mi;
            RectF rectF = new RectF(i * (f + f2), 0.0f, (i * (f + f2)) + this.ml, this.mg);
            float f3 = this.mg;
            canvas.drawRoundRect(rectF, f3 / 2.0f, f3 / 2.0f, this.mk);
        }
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i = 0; i < this.mc; i++) {
            int i2 = this.lU;
            if (i < i2 && i != i2 - 1) {
                float f = this.me;
                float f2 = this.mi;
                float f3 = i * (f + f2);
                rectF.left = f3;
                rectF.right = f3 + f2;
                this.mf.setColor(this.mb);
            } else if (i == i2 - 1) {
                float f4 = this.me;
                float f5 = this.mi;
                float f6 = i * (f4 + f5);
                rectF.left = f6;
                rectF.right = f6 + f5 + ((this.mh - f5) * (1.0f - this.md));
                this.mf.setColor(this.mb);
            } else if (i == i2) {
                float f7 = i2 != 0 ? this.md : 1.0f;
                float f8 = this.me;
                float f9 = this.mi;
                float f10 = this.mh;
                float f11 = ((i - 1) * (f8 + f9)) + f9 + ((f10 - f9) * (1.0f - f7)) + f8;
                rectF.left = f11;
                rectF.right = f11 + (f7 * (f10 - f9)) + f9;
                this.mf.setColor(this.mb);
            } else {
                float f12 = this.me;
                float f13 = this.mi;
                float f14 = ((i - 1) * (f12 + f13)) + f12 + this.mh;
                rectF.left = f14;
                rectF.right = f14 + f13;
                this.mf.setColor(this.mb);
            }
            rectF.top = 0.0f;
            float f15 = this.mg;
            rectF.bottom = 0.0f + f15;
            canvas.drawRoundRect(rectF, f15 / 2.0f, f15 / 2.0f, this.mf);
        }
    }
}
