package com.byazt.rn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.byazt.eu.tt;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_UNLIKE, 434})
public class RefreshableBannerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f28996a;
    public boolean c;
    public final ViewTreeObserver.OnScrollChangedListener n;
    public boolean tt;
    public final Rect uj;
    public boolean ve;

    public interface c {
        void c(boolean z);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.c = true;
        this.tt = true;
        this.ve = true;
        this.uj = new Rect();
        this.n = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.rn.RefreshableBannerView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
                refreshableBannerView.tt = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.uj);
                RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
                refreshableBannerView2.c(refreshableBannerView2.tt);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.n);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.n);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        this.c = z;
        c(z);
    }

    public void setVisibilityChangeListener(c cVar) {
        this.f28996a = cVar;
    }

    @UiThread
    public void c(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.rn.RefreshableBannerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RefreshableBannerView.this.getChildCount() > 1) {
                        RefreshableBannerView.this.removeViewAt(0);
                        tt.c("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
                    }
                }
            });
            duration.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        boolean z2 = this.c && this.tt;
        if (z) {
            if (!z2 || this.ve) {
                return;
            }
            this.ve = true;
            c cVar = this.f28996a;
            if (cVar != null) {
                cVar.c(true);
                return;
            }
            return;
        }
        if (z2 || !this.ve) {
            return;
        }
        this.ve = false;
        c cVar2 = this.f28996a;
        if (cVar2 != null) {
            cVar2.c(false);
        }
    }
}
