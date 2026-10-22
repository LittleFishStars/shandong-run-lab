package com.zj.adlib;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Landroidx/viewpager2/widget/ViewPager2;", "", "a", "base_release"}, k = 2, mv = {1, 8, 0})
public final class lr9 {
    public static final void a(@NotNull ViewPager2 viewPager2) {
        Intrinsics.checkNotNullParameter(viewPager2, "<this>");
        if (viewPager2.getChildCount() == 0) {
            return;
        }
        try {
            int childCount = viewPager2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewPager2.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (childAt instanceof RecyclerView) {
                    ((RecyclerView) childAt).setScrollingTouchSlop(1);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
