package com.zj.adlib;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class td7 implements RefreshContent, CoordinatorLayoutListener, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f44897a;
    public View b;
    public View c;
    public View d;
    public View e;
    public int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19780a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19781b = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gx7 f19779a = new gx7();

    public td7(@NonNull View view) {
        this.c = view;
        this.b = view;
        this.f44897a = view;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public boolean a() {
        return this.f19781b && this.f19779a.a(this.f44897a);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void b(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f44897a.getLeft(), -this.f44897a.getTop());
        View view = this.c;
        View view2 = this.f44897a;
        if (view != view2) {
            this.c = findScrollableViewByPoint(view2, pointF, view);
        }
        if (this.c == this.f44897a) {
            this.f19779a.f42007a = null;
        } else {
            this.f19779a.f42007a = pointF;
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener
    public void c(boolean z, boolean z2) {
        this.f19780a = z;
        this.f19781b = z2;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public boolean d() {
        return this.f19780a && this.f19779a.b(this.f44897a);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void e(int i, int i2, int i3) {
        boolean z;
        View viewFindViewById;
        View viewFindViewById2;
        boolean z2 = true;
        if (i2 == -1 || (viewFindViewById2 = this.b.findViewById(i2)) == null) {
            z = false;
        } else if (i > 0) {
            viewFindViewById2.setTranslationY(i);
            z = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z = false;
        }
        if (i3 == -1 || (viewFindViewById = this.b.findViewById(i3)) == null) {
            z2 = z;
        } else if (i < 0) {
            viewFindViewById.setTranslationY(i);
        } else {
            if (viewFindViewById.getTranslationY() < 0.0f) {
                viewFindViewById.setTranslationY(0.0f);
            }
            z2 = z;
        }
        if (z2) {
            this.b.setTranslationY(0.0f);
        } else {
            this.b.setTranslationY(i);
        }
        View view = this.d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i));
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i));
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void f(ScrollBoundaryDecider scrollBoundaryDecider) {
        if (scrollBoundaryDecider instanceof gx7) {
            this.f19779a = (gx7) scrollBoundaryDecider;
        } else {
            this.f19779a.f16902a = scrollBoundaryDecider;
        }
    }

    public void findScrollableView(View view, RefreshKernel refreshKernel) {
        boolean zIsInEditMode = this.f44897a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = findScrollableViewInternal(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!zIsInEditMode) {
                sk2.a(view, refreshKernel, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.c = view2;
        }
    }

    public View findScrollableViewByPoint(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (qk8.h(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && qk8.f(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewFindScrollableViewByPoint = findScrollableViewByPoint(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewFindScrollableViewByPoint;
                }
            }
        }
        return view2;
    }

    public View findScrollableViewInternal(View view, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && qk8.f(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    @NonNull
    public View g() {
        return this.c;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    @NonNull
    public View getView() {
        return this.f44897a;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void h(RefreshKernel refreshKernel, View view, View view2) {
        findScrollableView(this.f44897a, refreshKernel);
        if (view == null && view2 == null) {
            return;
        }
        this.d = view;
        this.e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f44897a.getContext());
        refreshKernel.k().getLayout().removeView(this.f44897a);
        ViewGroup.LayoutParams layoutParams = this.f44897a.getLayoutParams();
        frameLayout.addView(this.f44897a, -1, -1);
        refreshKernel.k().getLayout().addView(frameLayout, layoutParams);
        this.f44897a = frameLayout;
        if (view != null) {
            view.setTag("fixed-top");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = qk8.i(view);
            viewGroup.addView(new Space(this.f44897a.getContext()), iIndexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setTag("fixed-bottom");
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int iIndexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = qk8.i(view2);
            viewGroup2.addView(new Space(this.f44897a.getContext()), iIndexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public void i(boolean z) {
        this.f19779a.f16903a = z;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshContent
    public ValueAnimator.AnimatorUpdateListener j(int i) {
        View view = this.c;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !qk8.c(view, 1)) && (i <= 0 || !qk8.c(this.c, -1))) {
            return null;
        }
        this.K = i;
        return this;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.K) * this.c.getScaleY();
            View view = this.c;
            if (view instanceof AbsListView) {
                qk8.k((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.K = iIntValue;
    }
}
