package com.byazt.xzj;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.acse.ottn.v;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.rpt.SlideUpLoadMoreArrow;
import com.byazt.zqa.c;
import com.king.zxing.camera.CameraManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, CameraManager.i, 1285})
public class RewardLpBottomView extends LinearLayout {
    public boolean c;
    public SlideUpLoadMoreArrow tt;
    public RewardLandingPageAppInfoView ve;

    public RewardLpBottomView(Context context) {
        super(context);
        this.c = false;
    }

    private void uj() {
        if (this.ve == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.xzj.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.ve == null) {
                    return;
                }
                int measuredHeight = RewardLpBottomView.this.ve.getMeasuredHeight();
                View viewFindViewById = RewardLpBottomView.this.getRootView().findViewById(2114387658);
                if (viewFindViewById == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = measuredHeight;
                    viewFindViewById.setLayoutParams(layoutParams2);
                }
            }
        });
    }

    private void ve() {
        this.tt = new SlideUpLoadMoreArrow(getContext(), this.c ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.tt, layoutParams);
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.ve;
        if (rewardLandingPageAppInfoView == null || onClickListener == null) {
            return;
        }
        rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
    }

    public void tt() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.tt) != null) {
            slideUpLoadMoreArrow.tt();
            this.tt.setVisibility(8);
        }
    }

    public void c(ic icVar, String str) {
        if (icVar == null) {
            return;
        }
        this.c = c(icVar);
        ve();
        if (!my.ve(icVar)) {
            tt(icVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, v.f}));
    }

    private void tt(ic icVar, String str) {
        if (this.c) {
            RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
            this.ve = rewardLandingPageAppInfoView;
            rewardLandingPageAppInfoView.c(icVar, str);
            addView(this.ve, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private boolean c(ic icVar) {
        return icVar.i() == 4;
    }

    public void c() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.tt;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.c();
        }
        uj();
    }
}
