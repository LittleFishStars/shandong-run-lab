package com.zj.adlib;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class sk2 {

    public static class a implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayoutListener f44707a;

        public a(CoordinatorLayoutListener coordinatorLayoutListener) {
            this.f44707a = coordinatorLayoutListener;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            this.f44707a.c(i >= 0, appBarLayout.getTotalScrollRange() + i <= 0);
        }
    }

    public static void a(View view, RefreshKernel refreshKernel, CoordinatorLayoutListener coordinatorLayoutListener) {
        try {
            if (view instanceof CoordinatorLayout) {
                refreshKernel.k().setEnableNestedScroll(false);
                b((ViewGroup) view, coordinatorLayoutListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(ViewGroup viewGroup, CoordinatorLayoutListener coordinatorLayoutListener) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(coordinatorLayoutListener));
            }
        }
    }
}
