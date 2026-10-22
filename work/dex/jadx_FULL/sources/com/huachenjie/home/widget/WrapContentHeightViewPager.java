package com.huachenjie.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.huachenjie.home.widget.WrapContentHeightViewPager;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001\u0015B\u001d\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\f\u0010\u0011\u001a\u00020\u0002*\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/huachenjie/home/widget/WrapContentHeightViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "requestHeightUpdate", "clearHeightCache", "item", "", "smoothScroll", "setCurrentItem", "Landroid/view/View;", "child", "onViewAdded", "Landroidx/viewpager/widget/ViewPager$LayoutParams;", "c", "pagePosition", "b", "Landroid/util/SparseIntArray;", "a", "Landroid/util/SparseIntArray;", "pageHeightCache", "K", "I", "lastKnownHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "home_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWrapContentHeightViewPager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WrapContentHeightViewPager.kt\ncom/huachenjie/home/widget/WrapContentHeightViewPager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
public final class WrapContentHeightViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f34376a;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int lastKnownHeight;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SparseIntArray pageHeightCache;

    static {
        Field declaredField = ViewPager.LayoutParams.class.getDeclaredField("position");
        declaredField.setAccessible(true);
        f34376a = declaredField;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    public WrapContentHeightViewPager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AttributeSet attributeSet = null;
        this(context, attributeSet, 2, attributeSet);
    }

    public /* synthetic */ WrapContentHeightViewPager(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void d(WrapContentHeightViewPager wrapContentHeightViewPager) {
        Intrinsics.checkNotNullParameter(wrapContentHeightViewPager, "this$0");
        wrapContentHeightViewPager.requestLayout();
    }

    public final int b(int widthMeasureSpec, int pagePosition) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                ViewPager.LayoutParams layoutParams2 = layoutParams instanceof ViewPager.LayoutParams ? (ViewPager.LayoutParams) layoutParams : null;
                if (layoutParams2 != null && !layoutParams2.isDecor && c(layoutParams2) == pagePosition) {
                    childAt.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight > 0) {
                        this.pageHeightCache.put(pagePosition, measuredHeight);
                        this.lastKnownHeight = measuredHeight;
                    }
                    return measuredHeight;
                }
            }
        }
        return 0;
    }

    public final int c(ViewPager.LayoutParams layoutParams) {
        return f34376a.getInt(layoutParams);
    }

    public final void clearHeightCache() {
        this.pageHeightCache.clear();
        this.lastKnownHeight = 0;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iB = b(widthMeasureSpec, getCurrentItem());
        if (iB <= 0) {
            if (this.pageHeightCache.get(getCurrentItem(), 0) > 0) {
                iB = this.pageHeightCache.get(getCurrentItem());
            } else {
                iB = this.lastKnownHeight;
                if (iB <= 0) {
                    iB = 0;
                }
            }
        }
        if (iB > 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(iB, 1073741824);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(@Nullable View child) {
        super.onViewAdded(child);
        requestHeightUpdate();
    }

    public final void requestHeightUpdate() {
        post(new Runnable() { // from class: com.zj.adlib.t0a
            @Override // java.lang.Runnable
            public final void run() {
                WrapContentHeightViewPager.d(this.f44823a);
            }
        });
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
        if (smoothScroll) {
            return;
        }
        requestHeightUpdate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WrapContentHeightViewPager(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pageHeightCache = new SparseIntArray();
        addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.huachenjie.home.widget.WrapContentHeightViewPager.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                WrapContentHeightViewPager.this.requestHeightUpdate();
            }
        });
    }
}
