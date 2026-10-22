package com.huachenjie.base.util;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayoutBase;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.huachenjie.base.R;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ0\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bJ&\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001f¨\u0006#"}, d2 = {"Lcom/huachenjie/base/util/CustomTabStyle;", "", "Lcom/flyco/tablayout/SlidingTabLayoutBase;", "tabLayout", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "onTabSelectListener", "", "currentPosition", "", y6b.f, "Landroidx/viewpager/widget/ViewPager;", "e", "indicatorColor", "resourcesId", "a", "c", "position", "", "checkLast", "i", "Landroid/graphics/drawable/Drawable;", "b", "I", "lastPosition", "Lcom/flyco/tablayout/SlidingTabLayoutBase;", "mTabLayout", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "mResources", "Landroid/graphics/drawable/Drawable;", "mDrawable", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class CustomTabStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int lastPosition;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Resources mResources;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Drawable mDrawable;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public SlidingTabLayoutBase mTabLayout;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/base/util/CustomTabStyle$a", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements OnTabSelectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayoutBase f32955a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OnTabSelectListener f7240a;

        public a(SlidingTabLayoutBase slidingTabLayoutBase, OnTabSelectListener onTabSelectListener) {
            this.f32955a = slidingTabLayoutBase;
            this.f7240a = onTabSelectListener;
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            CustomTabStyle.j(CustomTabStyle.this, this.f32955a, position, false, 4, null);
            OnTabSelectListener onTabSelectListener = this.f7240a;
            if (onTabSelectListener != null) {
                onTabSelectListener.b(position);
            }
        }
    }

    public static /* synthetic */ void d(CustomTabStyle customTabStyle, SlidingTabLayoutBase slidingTabLayoutBase, int i, OnTabSelectListener onTabSelectListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            onTabSelectListener = null;
        }
        customTabStyle.c(slidingTabLayoutBase, i, onTabSelectListener);
    }

    public static /* synthetic */ void f(CustomTabStyle customTabStyle, SlidingTabLayoutBase slidingTabLayoutBase, ViewPager viewPager, OnTabSelectListener onTabSelectListener, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            viewPager = null;
        }
        if ((i2 & 4) != 0) {
            onTabSelectListener = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        customTabStyle.e(slidingTabLayoutBase, viewPager, onTabSelectListener, i);
    }

    public static /* synthetic */ void h(CustomTabStyle customTabStyle, SlidingTabLayoutBase slidingTabLayoutBase, ViewPager2 viewPager2, OnTabSelectListener onTabSelectListener, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            viewPager2 = null;
        }
        if ((i2 & 4) != 0) {
            onTabSelectListener = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        customTabStyle.g(slidingTabLayoutBase, viewPager2, onTabSelectListener, i);
    }

    public static /* synthetic */ void j(CustomTabStyle customTabStyle, SlidingTabLayoutBase slidingTabLayoutBase, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        customTabStyle.i(slidingTabLayoutBase, i, z);
    }

    public final void a(int indicatorColor, int resourcesId) {
        Resources resources = this.mResources;
        if (resources != null) {
            Intrinsics.checkNotNull(resources);
            this.mDrawable = resources.getDrawable(resourcesId);
        }
        SlidingTabLayoutBase slidingTabLayoutBase = this.mTabLayout;
        if (slidingTabLayoutBase == null) {
            return;
        }
        slidingTabLayoutBase.setIndicatorColor(indicatorColor);
        int tabCount = slidingTabLayoutBase.getTabCount();
        int i = this.lastPosition;
        if (i >= 0 && i < tabCount) {
            TextView tabTitleView = slidingTabLayoutBase.getTabTitleView(i);
            Drawable drawable = this.mDrawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                tabTitleView.setCompoundDrawablePadding(jj8.a(4.0f));
                tabTitleView.setCompoundDrawables(drawable, null, null, null);
            }
        }
    }

    public final Drawable b() {
        Resources resources;
        if (this.mDrawable == null && (resources = this.mResources) != null) {
            Intrinsics.checkNotNull(resources);
            this.mDrawable = resources.getDrawable(R.drawable.ic_tab_indicator);
        }
        return this.mDrawable;
    }

    public final void c(SlidingTabLayoutBase tabLayout, int currentPosition, OnTabSelectListener onTabSelectListener) {
        this.mTabLayout = tabLayout;
        this.mResources = tabLayout.getResources();
        this.lastPosition = currentPosition;
        tabLayout.setIndicatorColor(Color.parseColor("#FF0BD3FF"));
        Drawable drawableB = b();
        int tabCount = tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TextView tabTitleView = tabLayout.getTabTitleView(i);
            if (this.lastPosition == i) {
                if (drawableB != null) {
                    drawableB.setBounds(0, 0, drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
                }
                tabTitleView.setCompoundDrawablePadding(jj8.a(4.0f));
                tabTitleView.setCompoundDrawables(drawableB, null, null, null);
            } else {
                tabTitleView.setCompoundDrawablePadding(0);
                tabTitleView.setCompoundDrawables(null, null, null, null);
            }
            if (tabLayout.isTabSpaceEqual()) {
                tabTitleView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
        }
        i(tabLayout, this.lastPosition, false);
        tabLayout.setOnTabSelectListener(new a(tabLayout, onTabSelectListener));
    }

    public final void e(@NotNull final SlidingTabLayoutBase tabLayout, @Nullable ViewPager viewPager, @Nullable final OnTabSelectListener onTabSelectListener, int currentPosition) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        c(tabLayout, currentPosition, onTabSelectListener);
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.huachenjie.base.util.CustomTabStyle$initStyle$1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    CustomTabStyle.j(this.f7243a, tabLayout, position, false, 4, null);
                    OnTabSelectListener onTabSelectListener2 = onTabSelectListener;
                    if (onTabSelectListener2 != null) {
                        onTabSelectListener2.b(position);
                    }
                }
            });
        }
    }

    public final void g(@NotNull final SlidingTabLayoutBase tabLayout, @Nullable ViewPager2 viewPager, @Nullable final OnTabSelectListener onTabSelectListener, int currentPosition) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        c(tabLayout, currentPosition, onTabSelectListener);
        if (viewPager != null) {
            viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.huachenjie.base.util.CustomTabStyle$initStyle2$1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int position) {
                    CustomTabStyle.j(this.f7245a, tabLayout, position, false, 4, null);
                    OnTabSelectListener onTabSelectListener2 = onTabSelectListener;
                    if (onTabSelectListener2 != null) {
                        onTabSelectListener2.b(position);
                    }
                }
            });
        }
    }

    public final void i(SlidingTabLayoutBase tabLayout, int position, boolean checkLast) {
        if (checkLast && this.lastPosition == position) {
            return;
        }
        Drawable drawableB = b();
        int i = this.lastPosition;
        if (i != position) {
            TextView tabTitleView = tabLayout.getTabTitleView(i);
            tabTitleView.setCompoundDrawablePadding(0);
            tabTitleView.setCompoundDrawables(null, null, null, null);
        }
        TextView tabTitleView2 = tabLayout.getTabTitleView(position);
        if (drawableB != null) {
            drawableB.setBounds(0, 0, drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
        }
        tabTitleView2.setCompoundDrawablePadding(jj8.a(4.0f));
        tabTitleView2.setCompoundDrawables(drawableB, null, null, null);
        tabLayout.postInvalidate();
        this.lastPosition = position;
    }
}
