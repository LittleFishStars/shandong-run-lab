package com.alibaba.triver.content;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.triver.utils.CommonUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@ViewPager.DecorView
public class TriverTabLayout extends HorizontalScrollView {
    private static final int A = -1;
    private static final int B = 48;
    private static final int C = 56;
    private static final int D = 300;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f24793a = 8;
    static final int b = 16;
    static final int c = 24;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 0;
    public static final int g = 1;
    private static final int z = 72;
    private final ArrayList<f> F;
    private f G;
    private final e H;
    private int I;
    private int J;
    private int K;
    private int L;
    private c M;
    private final ArrayList<c> N;
    private c O;
    private ValueAnimator P;
    private PagerAdapter Q;
    private DataSetObserver R;
    private h S;
    private a T;
    private boolean U;
    private final Pools.Pool<i> V;
    int h;
    int i;
    int j;
    int k;
    int l;
    ColorStateList m;
    float n;
    float o;
    int p;
    int q;
    int r;
    int s;
    ViewPager t;
    private static final Pools.Pool<f> E = new Pools.SynchronizedPool(16);
    static final Interpolator u = new LinearInterpolator();
    static final Interpolator v = new FastOutSlowInInterpolator();
    static final Interpolator w = new FastOutLinearInInterpolator();
    static final Interpolator x = new LinearOutSlowInInterpolator();
    static final Interpolator y = new DecelerateInterpolator();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface b {
    }

    public interface c {
        void a(f fVar);

        void b(f fVar);

        void c(f fVar);
    }

    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TriverTabLayout.this.d();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TriverTabLayout.this.d();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f24800a = -1;
        TriverTabLayout b;
        i c;
        private Object d;
        private Drawable e;
        private CharSequence f;
        private CharSequence g;
        private int h = -1;
        private View i;

        @Nullable
        public Object a() {
            return this.d;
        }

        @Nullable
        public View b() {
            return this.i;
        }

        @Nullable
        public Drawable c() {
            return this.e;
        }

        public int d() {
            return this.h;
        }

        @Nullable
        public CharSequence e() {
            return this.f;
        }

        public void f() {
            TriverTabLayout triverTabLayout = this.b;
            if (triverTabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            triverTabLayout.c(this);
        }

        public boolean g() {
            TriverTabLayout triverTabLayout = this.b;
            if (triverTabLayout != null) {
                return triverTabLayout.getSelectedTabPosition() == this.h;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @Nullable
        public CharSequence h() {
            return this.g;
        }

        public void i() {
            i iVar = this.c;
            if (iVar != null) {
                iVar.b();
            }
        }

        public void j() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = -1;
            this.i = null;
        }

        @NonNull
        public f a(@Nullable Object obj) {
            this.d = obj;
            return this;
        }

        public void b(int i) {
            this.h = i;
        }

        @NonNull
        public f c(@DrawableRes int i) {
            TriverTabLayout triverTabLayout = this.b;
            if (triverTabLayout != null) {
                return a(AppCompatResources.getDrawable(triverTabLayout.getContext(), i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public f d(@StringRes int i) {
            TriverTabLayout triverTabLayout = this.b;
            if (triverTabLayout != null) {
                return a(triverTabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public f e(@StringRes int i) {
            TriverTabLayout triverTabLayout = this.b;
            if (triverTabLayout != null) {
                return b(triverTabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public f a(@Nullable View view) {
            this.i = view;
            i();
            return this;
        }

        @NonNull
        public f b(@Nullable CharSequence charSequence) {
            this.g = charSequence;
            i();
            return this;
        }

        @NonNull
        public f a(@LayoutRes int i) {
            return a(LayoutInflater.from(this.c.getContext()).inflate(i, (ViewGroup) this.c, false));
        }

        @NonNull
        public f a(@Nullable Drawable drawable) {
            this.e = drawable;
            i();
            return this;
        }

        @NonNull
        public f a(@Nullable CharSequence charSequence) {
            this.f = charSequence;
            i();
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    public static class j implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f24803a;

        public j(ViewPager viewPager) {
            this.f24803a = viewPager;
        }

        @Override // com.alibaba.triver.content.TriverTabLayout.c
        public void a(f fVar) {
            this.f24803a.setCurrentItem(fVar.d());
        }

        @Override // com.alibaba.triver.content.TriverTabLayout.c
        public void b(f fVar) {
        }

        @Override // com.alibaba.triver.content.TriverTabLayout.c
        public void c(f fVar) {
        }
    }

    public TriverTabLayout(Context context) {
        this(context, null);
    }

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    private void e() {
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.F.get(i2).i();
        }
    }

    private LinearLayout.LayoutParams f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void g() {
        if (this.P == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.P = valueAnimator;
            valueAnimator.setInterpolator(v);
            this.P.setDuration(300L);
            this.P.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.triver.content.TriverTabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TriverTabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private int getDefaultHeight() {
        int size = this.F.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.F.get(i2);
            if (fVar != null && fVar.c() != null && !TextUtils.isEmpty(fVar.e())) {
                z2 = true;
                break;
            }
        }
        return z2 ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.H.b();
    }

    private int getTabMinWidth() {
        int i2 = this.I;
        if (i2 != -1) {
            return i2;
        }
        if (this.s == 0) {
            return this.K;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.H.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(@NonNull f fVar) {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            this.N.get(size).c(fVar);
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.H.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                this.H.getChildAt(i3).setSelected(i3 == i2);
                i3++;
            }
        }
    }

    public void a(int i2, float f2, boolean z2) {
        a(i2, f2, z2, true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    public void b(@NonNull c cVar) {
        this.N.remove(cVar);
    }

    public void c() {
        for (int childCount = this.H.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<f> it = this.F.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.j();
            E.release(next);
        }
        this.G = null;
    }

    public void d() {
        int currentItem;
        c();
        PagerAdapter pagerAdapter = this.Q;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                a(b().a(this.Q.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.t;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            c(a(currentItem));
        }
    }

    public int getSelectedTabPosition() {
        f fVar = this.G;
        if (fVar != null) {
            return fVar.d();
        }
        return -1;
    }

    public int getTabCount() {
        return this.F.size();
    }

    public int getTabGravity() {
        return this.r;
    }

    public int getTabMaxWidth() {
        return this.q;
    }

    public int getTabMode() {
        return this.s;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.t == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.U) {
            setupWithViewPager(null);
            this.U = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0075  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int iC = c(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(iC, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(iC, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int iC2 = this.J;
            if (iC2 <= 0) {
                iC2 = size - c(56);
            }
            this.q = iC2;
        }
        super.onMeasure(i2, i3);
        boolean z2 = true;
        if (getChildCount() == 1) {
            boolean z3 = false;
            View childAt = getChildAt(0);
            int i4 = this.s;
            if (i4 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    z2 = false;
                }
                z3 = z2;
            } else if (i4 == 1) {
                if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                    z2 = false;
                }
                z3 = z2;
            }
            if (z3) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.M;
        if (cVar2 != null) {
            b(cVar2);
        }
        this.M = cVar;
        if (cVar != null) {
            a(cVar);
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.P.addListener(animatorListener);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.H.a(i2);
    }

    public void setSelectedTabIndicatorHeight(int i2) {
        this.H.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.r != i2) {
            this.r = i2;
            h();
        }
    }

    public void setTabMode(int i2) {
        if (i2 != this.s) {
            this.s = i2;
            h();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            e();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        a(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        a(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public class a implements ViewPager.OnAdapterChangeListener {
        private boolean b;

        public a() {
        }

        public void a(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TriverTabLayout triverTabLayout = TriverTabLayout.this;
            if (triverTabLayout.t == viewPager) {
                triverTabLayout.a(pagerAdapter2, this.b);
            }
        }

        public void a(boolean z) {
            this.b = z;
        }
    }

    public static class h implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<TriverTabLayout> f24801a;
        private int b;
        private int c;

        public h(TriverTabLayout triverTabLayout) {
            this.f24801a = new WeakReference<>(triverTabLayout);
        }

        public void a(int i) {
            this.b = this.c;
            this.c = i;
        }

        public void b(int i) {
            TriverTabLayout triverTabLayout = this.f24801a.get();
            if (triverTabLayout == null || triverTabLayout.getSelectedTabPosition() == i || i >= triverTabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            triverTabLayout.b(triverTabLayout.a(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }

        public void a(int i, float f, int i2) {
            TriverTabLayout triverTabLayout = this.f24801a.get();
            if (triverTabLayout != null) {
                int i3 = this.c;
                triverTabLayout.a(i, f, i3 != 2 || this.b == 1, (i3 == 2 && this.b == 0) ? false : true);
            }
        }

        public void a() {
            this.c = 0;
            this.b = 0;
        }
    }

    public TriverTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i2, float f2, boolean z2, boolean z3) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.H.getChildCount()) {
            return;
        }
        if (z3) {
            this.H.a(i2, f2);
        }
        ValueAnimator valueAnimator = this.P;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.P.cancel();
        }
        scrollTo(a(i2, f2), 0);
        if (z2) {
            setSelectedTabView(iRound);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    @NonNull
    public f b() {
        f fVarAcquire = E.acquire();
        if (fVarAcquire == null) {
            fVarAcquire = new f();
        }
        fVarAcquire.b = this;
        fVarAcquire.c = d(fVarAcquire);
        return fVarAcquire;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public class e extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24797a;
        float b;
        private int d;
        private final Paint e;
        private int f;
        private int g;
        private int h;
        private ValueAnimator i;

        public e(Context context) {
            super(context);
            this.f24797a = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            setWillNotDraw(false);
            this.e = new Paint();
        }

        private void c() {
            int left;
            int right;
            View childAt = getChildAt(this.f24797a);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                if (this.b > 0.0f && this.f24797a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f24797a + 1);
                    float left2 = this.b * childAt2.getLeft();
                    float f = this.b;
                    left = (int) (left2 + ((1.0f - f) * left));
                    right = (int) ((f * childAt2.getRight()) + ((1.0f - this.b) * right));
                }
            }
            a(left, right);
        }

        public void a(int i) {
            if (this.e.getColor() != i) {
                this.e.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void b(int i) {
            if (this.d != i) {
                this.d = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            int i = this.g;
            if (i < 0 || this.h <= i) {
                return;
            }
            canvas.drawRect(i, getHeight() - this.d, this.h, getHeight(), this.e);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                c();
                return;
            }
            this.i.cancel();
            b(this.f24797a, Math.round((1.0f - this.i.getAnimatedFraction()) * this.i.getDuration()));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TriverTabLayout triverTabLayout = TriverTabLayout.this;
            boolean z = true;
            if (triverTabLayout.s == 1 && triverTabLayout.r == 1) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (TriverTabLayout.this.c(16) * 2)) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TriverTabLayout triverTabLayout2 = TriverTabLayout.this;
                    triverTabLayout2.r = 0;
                    triverTabLayout2.a(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
        }

        public boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public float b() {
            return this.f24797a + this.b;
        }

        public void b(final int i, int i2) {
            final int i3;
            final int i4;
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                c();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.f24797a) <= 1) {
                i3 = this.g;
                i4 = this.h;
            } else {
                int iC = TriverTabLayout.this.c(24);
                i3 = (i >= this.f24797a ? !z : z) ? left - iC : iC + right;
                i4 = i3;
            }
            if (i3 == left && i4 == right) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.i = valueAnimator2;
            valueAnimator2.setInterpolator(TriverTabLayout.v);
            valueAnimator2.setDuration(i2);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.triver.content.TriverTabLayout.e.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float animatedFraction = valueAnimator3.getAnimatedFraction();
                    e.this.a(TriverTabLayout.a(i3, left, animatedFraction), TriverTabLayout.a(i4, right, animatedFraction));
                }
            });
            valueAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.alibaba.triver.content.TriverTabLayout.e.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e eVar = e.this;
                    eVar.f24797a = i;
                    eVar.b = 0.0f;
                }
            });
            valueAnimator2.start();
        }

        public void a(int i, float f) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            this.f24797a = i;
            this.b = f;
            c();
        }

        public void a(int i, int i2) {
            if (i == this.g && i2 == this.h) {
                return;
            }
            this.g = i;
            this.h = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public class i extends LinearLayout {
        private f b;
        private TextView c;
        private ImageView d;
        private View e;
        private TextView f;
        private ImageView g;
        private int h;

        public i(Context context) {
            super(context);
            this.h = 2;
            int i = TriverTabLayout.this.p;
            if (i != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, i));
            }
            ViewCompat.setPaddingRelative(this, TriverTabLayout.this.h, TriverTabLayout.this.i, TriverTabLayout.this.j, TriverTabLayout.this.k);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public void a(@Nullable f fVar) {
            if (fVar != this.b) {
                this.b = fVar;
                b();
            }
        }

        public final void b() {
            f fVar = this.b;
            View viewB = fVar != null ? fVar.b() : null;
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.e = viewB;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.d.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewB.findViewById(R.id.text1);
                this.f = textView2;
                if (textView2 != null) {
                    this.h = TextViewCompat.getMaxLines(textView2);
                }
                this.g = (ImageView) viewB.findViewById(R.id.icon);
            } else {
                View view = this.e;
                if (view != null) {
                    removeView(view);
                    this.e = null;
                }
                this.f = null;
                this.g = null;
            }
            if (this.e == null) {
                if (this.d == null) {
                    int iDp2px = CommonUtils.dp2px(24);
                    ImageView imageView2 = new ImageView(getContext());
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    addView(imageView2, 0, new ViewGroup.LayoutParams(iDp2px, iDp2px));
                    this.d = imageView2;
                }
                if (this.c == null) {
                    TextView textView3 = new TextView(getContext());
                    textView3.setEllipsize(TextUtils.TruncateAt.END);
                    textView3.setGravity(1);
                    textView3.setMaxLines(2);
                    addView(textView3);
                    this.c = textView3;
                    this.h = TextViewCompat.getMaxLines(textView3);
                }
                TextViewCompat.setTextAppearance(this.c, TriverTabLayout.this.l);
                ColorStateList colorStateList = TriverTabLayout.this.m;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
                a(this.c, this.d);
            } else {
                TextView textView4 = this.f;
                if (textView4 != null || this.g != null) {
                    a(textView4, this.g);
                }
            }
            setSelected(fVar != null && fVar.g());
        }

        public f c() {
            return this.b;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TriverTabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TriverTabLayout.this.q, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.c != null) {
                getResources();
                float f = TriverTabLayout.this.n;
                int i3 = this.h;
                ImageView imageView = this.d;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TriverTabLayout.this.o;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.c.getTextSize();
                int lineCount = this.c.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.c);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TriverTabLayout.this.s == 1 && f > textSize && lineCount == 1 && ((layout = this.c.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.c.setTextSize(0, f);
                        this.c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.b == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.b.f();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.e;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void a() {
            a(null);
            setSelected(false);
        }

        private void a(@Nullable TextView textView, @Nullable ImageView imageView) {
            f fVar = this.b;
            Drawable drawableC = fVar != null ? fVar.c() : null;
            f fVar2 = this.b;
            CharSequence charSequenceE = fVar2 != null ? fVar2.e() : null;
            f fVar3 = this.b;
            CharSequence charSequenceH = fVar3 != null ? fVar3.h() : null;
            int iC = 0;
            if (imageView != null) {
                if (drawableC != null) {
                    imageView.setImageDrawable(drawableC);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequenceH);
            }
            boolean z = !TextUtils.isEmpty(charSequenceE);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceE);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequenceH);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    iC = TriverTabLayout.this.c(8);
                }
                if (iC != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iC;
                    imageView.requestLayout();
                }
            }
            TooltipCompat.setTooltipText(this, z ? null : charSequenceH);
        }

        private float a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    public TriverTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = new ArrayList<>();
        this.q = Integer.MAX_VALUE;
        this.N = new ArrayList<>();
        this.V = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(context);
        this.H = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        eVar.b(0);
        eVar.a(0);
        this.k = 0;
        this.j = 0;
        this.i = 0;
        this.h = 0;
        this.I = -1;
        this.J = -1;
        this.p = 0;
        this.L = 0;
        this.s = 1;
        this.r = 0;
        this.o = CommonUtils.dp2px(12);
        this.K = CommonUtils.dp2px(72);
        h();
    }

    private void e(f fVar) {
        this.H.addView(fVar.c, fVar.d(), f());
    }

    private void f(@NonNull f fVar) {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            this.N.get(size).a(fVar);
        }
    }

    private void h() {
        ViewCompat.setPaddingRelative(this.H, this.s == 0 ? Math.max(0, this.L - this.h) : 0, 0, 0, 0);
        int i2 = this.s;
        if (i2 == 0) {
            this.H.setGravity(GravityCompat.START);
        } else if (i2 == 1) {
            this.H.setGravity(1);
        }
        a(true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    private void e(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.H.a()) {
            int scrollX = getScrollX();
            int iA = a(i2, 0.0f);
            if (scrollX != iA) {
                g();
                this.P.setIntValues(scrollX, iA);
                this.P.start();
            }
            this.H.b(i2, 300);
            return;
        }
        a(i2, 0.0f, true);
    }

    private void g(@NonNull f fVar) {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            this.N.get(size).b(fVar);
        }
    }

    public void b(f fVar) {
        if (fVar.b == this) {
            b(fVar.d());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    private i d(@NonNull f fVar) {
        Pools.Pool<i> pool = this.V;
        i iVarAcquire = pool != null ? pool.acquire() : null;
        if (iVarAcquire == null) {
            iVarAcquire = new i(getContext());
        }
        iVarAcquire.a(fVar);
        iVarAcquire.setFocusable(true);
        iVarAcquire.setMinimumWidth(getTabMinWidth());
        return iVarAcquire;
    }

    public void a(@NonNull f fVar) {
        a(fVar, this.F.isEmpty());
    }

    public void b(int i2) {
        f fVar = this.G;
        int iD = fVar != null ? fVar.d() : 0;
        d(i2);
        f fVarRemove = this.F.remove(i2);
        if (fVarRemove != null) {
            fVarRemove.j();
            E.release(fVarRemove);
        }
        int size = this.F.size();
        for (int i3 = i2; i3 < size; i3++) {
            this.F.get(i3).b(i3);
        }
        if (iD == i2) {
            c(this.F.isEmpty() ? null : this.F.get(Math.max(0, i2 - 1)));
        }
    }

    public int c(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    public void a(@NonNull f fVar, int i2) {
        a(fVar, i2, this.F.isEmpty());
    }

    public void c(f fVar) {
        b(fVar, true);
    }

    public void a(@NonNull f fVar, boolean z2) {
        a(fVar, this.F.size(), z2);
    }

    public void a(@NonNull f fVar, int i2, boolean z2) {
        if (fVar.b == this) {
            b(fVar, i2);
            e(fVar);
            if (z2) {
                fVar.f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void d(int i2) {
        i iVar = (i) this.H.getChildAt(i2);
        this.H.removeViewAt(i2);
        if (iVar != null) {
            iVar.a();
            this.V.release(iVar);
        }
        requestLayout();
    }

    private void a(@NonNull TriverTabItem triverTabItem) {
        f fVarB = b();
        CharSequence charSequence = triverTabItem.f24792a;
        if (charSequence != null) {
            fVarB.a(charSequence);
        }
        Drawable drawable = triverTabItem.b;
        if (drawable != null) {
            fVarB.a(drawable);
        }
        int i2 = triverTabItem.c;
        if (i2 != 0) {
            fVarB.a(i2);
        }
        if (!TextUtils.isEmpty(triverTabItem.getContentDescription())) {
            fVarB.b(triverTabItem.getContentDescription());
        }
        a(fVarB);
    }

    private void b(f fVar, int i2) {
        fVar.b(i2);
        this.F.add(i2, fVar);
        int size = this.F.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.F.get(i2).b(i2);
            }
        }
    }

    public void b(f fVar, boolean z2) {
        f fVar2 = this.G;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                h(fVar);
                e(fVar.d());
                return;
            }
            return;
        }
        int iD = fVar != null ? fVar.d() : -1;
        if (z2) {
            if ((fVar2 == null || fVar2.d() == -1) && iD != -1) {
                a(iD, 0.0f, true);
            } else {
                e(iD);
            }
            if (iD != -1) {
                setSelectedTabView(iD);
            }
        }
        if (fVar2 != null) {
            g(fVar2);
        }
        this.G = fVar;
        if (fVar != null) {
            f(fVar);
        }
    }

    public void a(@NonNull c cVar) {
        if (this.N.contains(cVar)) {
            return;
        }
        this.N.add(cVar);
    }

    public void a() {
        this.N.clear();
    }

    @Nullable
    public f a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.F.get(i2);
    }

    public void a(int i2, int i3) {
        setTabTextColors(b(i2, i3));
    }

    private static ColorStateList b(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    public void a(@Nullable ViewPager viewPager, boolean z2) {
        a(viewPager, z2, false);
    }

    private void a(@Nullable ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.t;
        if (viewPager2 != null) {
            h hVar = this.S;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            a aVar = this.T;
            if (aVar != null) {
                this.t.removeOnAdapterChangeListener(aVar);
            }
        }
        c cVar = this.O;
        if (cVar != null) {
            b(cVar);
            this.O = null;
        }
        if (viewPager != null) {
            this.t = viewPager;
            if (this.S == null) {
                this.S = new h(this);
            }
            this.S.a();
            viewPager.addOnPageChangeListener(this.S);
            j jVar = new j(viewPager);
            this.O = jVar;
            a(jVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z2);
            }
            if (this.T == null) {
                this.T = new a();
            }
            this.T.a(z2);
            viewPager.addOnAdapterChangeListener(this.T);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.t = null;
            a((PagerAdapter) null, false);
        }
        this.U = z3;
    }

    public void a(@Nullable PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.Q;
        if (pagerAdapter2 != null && (dataSetObserver = this.R) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.Q = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.R == null) {
                this.R = new d();
            }
            pagerAdapter.registerDataSetObserver(this.R);
        }
        d();
    }

    private void a(View view) {
        if (view instanceof TriverTabItem) {
            a((TriverTabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.s == 1 && this.r == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private int a(int i2, float f2) {
        if (this.s != 0) {
            return 0;
        }
        View childAt = this.H.getChildAt(i2);
        int i3 = i2 + 1;
        View childAt2 = i3 < this.H.getChildCount() ? this.H.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f2);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
    }

    public void a(boolean z2) {
        for (int i2 = 0; i2 < this.H.getChildCount(); i2++) {
            View childAt = this.H.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public static int a(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * (i3 - i2));
    }
}
