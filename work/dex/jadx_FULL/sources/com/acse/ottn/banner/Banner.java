package com.acse.ottn.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.acse.ottn.R;
import com.acse.ottn.a4;
import com.acse.ottn.b3;
import com.acse.ottn.banner.util.BannerLifecycleObserverAdapter;
import com.acse.ottn.banner.util.ScrollSpeedManger;
import com.acse.ottn.c3;
import com.acse.ottn.i2;
import com.acse.ottn.k2;
import com.acse.ottn.u;
import com.acse.ottn.u1;
import com.acse.ottn.v;
import com.acse.ottn.v1;
import com.acse.ottn.y;
import com.acse.ottn.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Banner<T, BA extends u> extends FrameLayout implements y {
    public static final int I = -1;
    public static final int J = 0;
    public static final int K = 1;
    public int A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public Paint F;
    public Paint G;
    public RecyclerView.AdapterDataObserver H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f22895a;
    public b b;
    public c3 c;
    public BA d;
    public u1 e;
    public CompositePageTransformer f;
    public Banner<T, BA>.c g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (Banner.this.getItemCount() <= 1) {
                Banner.this.i();
            } else {
                Banner.this.h();
            }
            Banner.this.f();
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Banner> f22897a;

        public b(Banner banner) {
            this.f22897a = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.f22897a.get();
            if (banner == null || !banner.i || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.b((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.b, banner.j);
        }
    }

    public class c extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22898a = -1;
        public boolean b;

        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i == 1 || i == 2) {
                this.b = true;
            } else if (i == 0) {
                this.b = false;
                if (this.f22898a != -1 && Banner.this.h) {
                    int i2 = this.f22898a;
                    if (i2 == 0) {
                        Banner banner = Banner.this;
                        banner.a(banner.getRealCount(), false);
                    } else if (i2 == Banner.this.getItemCount() - 1) {
                        Banner.this.a(1, false);
                    }
                }
            }
            if (Banner.this.c != null) {
                Banner.this.c.onPageScrollStateChanged(i);
            }
            if (Banner.this.e != null) {
                Banner.this.e.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            int iA = z.a(Banner.this.d(), i, Banner.this.getRealCount());
            if (Banner.this.c != null) {
                Banner.this.c.onPageScrolled(iA, f, i2);
            }
            if (Banner.this.e != null) {
                Banner.this.e.onPageScrolled(iA, f, i2);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            if (this.b) {
                this.f22898a = i;
                int iA = z.a(Banner.this.d(), i, Banner.this.getRealCount());
                if (Banner.this.c != null) {
                    Banner.this.c.onPageSelected(iA);
                }
                if (Banner.this.e != null) {
                    Banner.this.e.onPageSelected(iA);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void setRecyclerViewPadding(int i) {
        c(i, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.m <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.G, 31);
        super.dispatchDraw(canvas);
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            h();
        } else if (actionMasked == 0) {
            i();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g() {
        if (!d()) {
            a(false);
        }
        o(d() ? 1 : 0);
    }

    public BA getAdapter() {
        if (this.d == null) {
            i2.b(getContext().getString(R.string.banner_adapter_use_error));
        }
        return this.d;
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public u1 getIndicator() {
        if (this.e == null) {
            i2.b(getContext().getString(R.string.indicator_null_error));
        }
        return this.e;
    }

    public v1 getIndicatorConfig() {
        if (getIndicator() != null) {
            return getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getItemCount();
    }

    public int getRealCount() {
        return getAdapter().a();
    }

    public int getScrollTime() {
        return this.k;
    }

    public ViewPager2 getViewPager2() {
        return this.f22895a;
    }

    public Banner h() {
        if (this.i) {
            i();
            postDelayed(this.b, this.j);
        }
        return this;
    }

    public Banner i() {
        if (this.i) {
            removeCallbacks(this.b);
        }
        return this;
    }

    public Banner j(@ColorRes int i) {
        i(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public Banner k(int i) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().j(i);
        }
        return this;
    }

    public Banner l(int i) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().e(i);
        }
        return this;
    }

    public Banner m(int i) {
        getViewPager2().setOrientation(i);
        return this;
    }

    public Banner n(int i) {
        this.k = i;
        return this;
    }

    public Banner o(int i) {
        this.l = i;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled() || !this.E) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.B = motionEvent.getX();
            this.C = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float fAbs = Math.abs(x - this.B);
            float fAbs2 = Math.abs(y - this.C);
            if (getViewPager2().getOrientation() == 0) {
                this.D = fAbs > ((float) this.A) && fAbs > fAbs2;
            } else {
                this.D = fAbs2 > ((float) this.A) && fAbs2 > fAbs;
            }
            getParent().requestDisallowInterceptTouchEvent(this.D);
        } else if (action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public Banner p(int i) {
        this.A = i;
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.A = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f = new CompositePageTransformer();
        this.g = new c();
        this.b = new b(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f22895a = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f22895a.setOffscreenPageLimit(1);
        this.f22895a.registerOnPageChangeCallback(this.g);
        this.f22895a.setPageTransformer(this.f);
        ScrollSpeedManger.a(this);
        addView(this.f22895a);
        Paint paint = new Paint();
        this.F = paint;
        paint.setColor(-1);
        this.F.setAntiAlias(true);
        this.F.setStyle(Paint.Style.FILL);
        this.F.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.G = paint2;
        paint2.setXfermode(null);
    }

    public final void b(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f = width;
        float f2 = height;
        path.moveTo(f - this.m, f2);
        path.lineTo(f, f2);
        path.lineTo(f, f2 - this.m);
        float f3 = this.m * 2.0f;
        path.arcTo(new RectF(f - f3, f2 - f3, f, f2), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public final void c() {
        int i = this.t;
        if (i != 0) {
            a(new v1.b(i));
        } else {
            int i2 = this.u;
            if (i2 != 0 || this.v != 0 || this.w != 0 || this.x != 0) {
                a(new v1.b(i2, this.v, this.w, this.x));
            }
        }
        int i3 = this.s;
        if (i3 > 0) {
            l(i3);
        }
        int i4 = this.r;
        if (i4 != 1) {
            c(i4);
        }
        int i5 = this.n;
        if (i5 > 0) {
            g(i5);
        }
        int i6 = this.o;
        if (i6 > 0) {
            k(i6);
        }
        int i7 = this.y;
        if (i7 > 0) {
            d(i7);
        }
        int i8 = this.z;
        if (i8 > 0) {
            h(i8);
        }
        e(this.p);
        i(this.q);
    }

    public final void d(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f = width;
        path.moveTo(f - this.m, 0.0f);
        path.lineTo(f, 0.0f);
        path.lineTo(f, this.m);
        float f2 = this.m * 2.0f;
        path.arcTo(new RectF(f - f2, 0.0f, f, f2), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner e() {
        u1 u1Var = this.e;
        if (u1Var != null) {
            removeView(u1Var.getIndicatorView());
        }
        return this;
    }

    public Banner f() {
        if (this.e != null) {
            this.e.a(getRealCount(), z.a(d(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = true;
        this.i = true;
        this.j = 3000L;
        this.k = 600;
        this.l = 1;
        this.m = 0.0f;
        this.n = v.g;
        this.o = v.h;
        this.p = v.e;
        this.q = v.f;
        this.r = 1;
        this.y = v.k;
        this.z = v.l;
        this.E = true;
        this.H = new a();
        a(context);
        a(context, attributeSet);
    }

    public Banner i(@ColorInt int i) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().i(i);
        }
        return this;
    }

    public Banner e(@ColorInt int i) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().f(i);
        }
        return this;
    }

    public Banner g(int i) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().g(i);
        }
        return this;
    }

    public Banner<T, BA> h(int i) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().h(i);
        }
        return this;
    }

    public Banner f(@ColorRes int i) {
        e(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public boolean d() {
        return this.h;
    }

    public final void b() {
        if (this.e == null || getAdapter() == null) {
            return;
        }
        if (this.e.getIndicatorConfig().l()) {
            e();
            addView(this.e.getIndicatorView());
        }
        c();
        f();
    }

    public Banner<T, BA> d(int i) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().c(i);
        }
        return this;
    }

    public Banner d(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new BannerLifecycleObserverAdapter(lifecycleOwner, this));
        }
        return this;
    }

    public Banner b(boolean z) {
        this.E = z;
        return this;
    }

    public Banner b(int i) {
        return a(i, true);
    }

    public Banner b(ViewPager2.PageTransformer pageTransformer) {
        this.f.removeTransformer(pageTransformer);
        return this;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_radius, 0);
        this.j = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_banner_loop_time, 3000);
        this.i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_auto_loop, true);
        this.h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_infinite_loop, true);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_normal_width, v.g);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_selected_width, v.h);
        this.p = typedArrayObtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_normal_color, v.e);
        this.q = typedArrayObtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_selected_color, v.f);
        this.r = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_banner_indicator_gravity, 1);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_space, 0);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_margin, 0);
        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginLeft, 0);
        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginTop, 0);
        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginRight, 0);
        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginBottom, 0);
        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_height, v.k);
        this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_radius, v.l);
        m(typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_banner_orientation, 0));
        g();
        typedArrayObtainStyledAttributes.recycle();
    }

    @RequiresApi(api = 21)
    public Banner b(float f) {
        z.a(this, f);
        return this;
    }

    public final void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.m);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.m, 0.0f);
        float f = this.m * 2.0f;
        path.arcTo(new RectF(0.0f, 0.0f, f, f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner b(int i, int i2) {
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.getIndicatorConfig().g(i);
            this.e.getIndicatorConfig().j(i2);
        }
        return this;
    }

    @Override // com.acse.ottn.y
    public void b(LifecycleOwner lifecycleOwner) {
        h();
    }

    public final void c(int i, int i2) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(0, i, 0, i2);
        } else {
            recyclerView.setPadding(i, 0, i2, 0);
        }
        recyclerView.setClipToPadding(false);
    }

    public Banner c(boolean z) {
        getViewPager2().setUserInputEnabled(z);
        return this;
    }

    public Banner c(@Nullable ViewPager2.PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    public Banner c(int i) {
        u1 u1Var = this.e;
        if (u1Var != null && u1Var.getIndicatorConfig().l()) {
            this.e.getIndicatorConfig().b(i);
            this.e.getIndicatorView().postInvalidate();
        }
        return this;
    }

    @Override // com.acse.ottn.y
    public void c(LifecycleOwner lifecycleOwner) {
        i();
    }

    public final void a(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f = height;
        path.moveTo(0.0f, f - this.m);
        path.lineTo(0.0f, f);
        path.lineTo(this.m, f);
        float f2 = this.m * 2.0f;
        path.arcTo(new RectF(0.0f, f - f2, f2, f), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner a(int i, boolean z) {
        getViewPager2().setCurrentItem(i, z);
        return this;
    }

    public Banner a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f.addTransformer(pageTransformer);
        return this;
    }

    public Banner a(RecyclerView.ItemDecoration itemDecoration) {
        getViewPager2().addItemDecoration(itemDecoration);
        return this;
    }

    public Banner a(RecyclerView.ItemDecoration itemDecoration, int i) {
        getViewPager2().addItemDecoration(itemDecoration, i);
        return this;
    }

    public Banner a(boolean z) {
        this.i = z;
        return this;
    }

    public Banner a(long j) {
        this.j = j;
        return this;
    }

    public void a() {
        if (getViewPager2() != null && this.g != null) {
            getViewPager2().unregisterOnPageChangeCallback(this.g);
            this.g = null;
        }
        i();
    }

    public Banner a(BA ba) {
        if (ba != null) {
            this.d = ba;
            if (!d()) {
                this.d.c(0);
            }
            this.d.registerAdapterDataObserver(this.H);
            this.f22895a.setAdapter(ba);
            a(this.l, false);
            b();
            return this;
        }
        throw new NullPointerException(getContext().getString(R.string.banner_adapter_null_error));
    }

    public Banner a(BA ba, boolean z) {
        this.h = z;
        g();
        a(ba);
        return this;
    }

    public Banner a(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().a(list);
            getAdapter().notifyDataSetChanged();
            a(this.l, false);
            f();
            h();
        }
        return this;
    }

    public Banner a(b3 b3Var) {
        if (getAdapter() != null) {
            getAdapter().a(b3Var);
        }
        return this;
    }

    public Banner a(c3 c3Var) {
        this.c = c3Var;
        return this;
    }

    public Banner a(float f) {
        this.m = f;
        return this;
    }

    public Banner a(int i, int i2) {
        return a(i, i2, 0.85f);
    }

    public Banner a(int i, int i2, int i3) {
        return a(i, i2, i3, 0.85f);
    }

    public Banner a(int i, int i2, float f) {
        return a(i, i, i2, f);
    }

    public Banner a(int i, int i2, int i3, float f) {
        if (i3 > 0) {
            a(new MarginPageTransformer((int) z.a(i3)));
        }
        if (f < 1.0f && f > 0.0f) {
            a(new a4(f));
        }
        c(i > 0 ? (int) z.a(i + i3) : 0, i2 > 0 ? (int) z.a(i2 + i3) : 0);
        return this;
    }

    public Banner a(int i) {
        return a(i, 0.88f);
    }

    public Banner a(int i, float f) {
        if (f < 1.0f && f > 0.0f) {
            a(new k2(f));
        }
        setRecyclerViewPadding((int) z.a(i));
        return this;
    }

    public Banner a(u1 u1Var) {
        return a(u1Var, true);
    }

    public Banner a(u1 u1Var, boolean z) {
        e();
        u1Var.getIndicatorConfig().a(z);
        this.e = u1Var;
        b();
        return this;
    }

    public Banner a(v1.b bVar) {
        u1 u1Var = this.e;
        if (u1Var != null && u1Var.getIndicatorConfig().l()) {
            this.e.getIndicatorConfig().a(bVar);
            this.e.getIndicatorView().requestLayout();
        }
        return this;
    }

    @Override // com.acse.ottn.y
    public void a(LifecycleOwner lifecycleOwner) {
        a();
    }
}
