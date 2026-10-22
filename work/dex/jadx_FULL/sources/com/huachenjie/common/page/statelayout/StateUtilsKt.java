package com.huachenjie.common.page.statelayout;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleObserver;
import androidx.p002lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005¨\u0006\u0007"}, d2 = {"Landroid/app/Activity;", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "a", "Landroidx/fragment/app/Fragment;", "c", "Landroid/view/View;", "b", "common_release"}, k = 2, mv = {1, 8, 0})
public final class StateUtilsKt {
    @NotNull
    public static final StateLayout a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View viewFindViewById = activity.findViewById(R.id.content);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) viewFindViewById).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "view");
        return b(childAt);
    }

    @NotNull
    public static final StateLayout b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        if ((viewGroup instanceof ViewPager) || (viewGroup instanceof RecyclerView)) {
            throw new UnsupportedOperationException("You should using StateLayout wrap [ " + view + " ] in layout when parent is ViewPager or RecyclerView");
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        StateLayout stateLayout = new StateLayout(context, null, 0, 6, null);
        stateLayout.setId(view.getId());
        int iIndexOfChild = viewGroup.indexOfChild(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        viewGroup.removeView(view);
        viewGroup.addView(stateLayout, iIndexOfChild, layoutParams);
        if (view instanceof ConstraintLayout) {
            stateLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        } else {
            stateLayout.addView(view);
        }
        stateLayout.setContentView(view);
        return stateLayout;
    }

    @NotNull
    public static final StateLayout c(@NotNull final Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        View view = fragment.getView();
        Intrinsics.checkNotNull(view);
        final StateLayout stateLayoutB = b(view);
        fragment.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.huachenjie.common.page.statelayout.StateUtilsKt$state$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void removeState() {
                ViewParent parent = stateLayoutB.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(stateLayoutB);
                fragment.getLifecycle().removeObserver(this);
            }
        });
        return stateLayoutB;
    }
}
