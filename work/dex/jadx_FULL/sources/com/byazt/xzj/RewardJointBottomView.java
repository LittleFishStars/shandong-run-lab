package com.byazt.xzj;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.byazt.aas.cu;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.fq.uj;
import com.byazt.fq.ve;
import com.byazt.rpt.SlideUpLoadMoreArrow;
import com.byazt.zqa.c;
import com.king.zxing.camera.CameraManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, CameraManager.i, 978})
public class RewardJointBottomView extends FrameLayout implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29197a;
    public float c;
    public final SlideUpLoadMoreArrow da;
    public boolean i;
    public uj n;
    public View.OnClickListener sp;
    public int[] tt;
    public SSWebView uj;
    public int[] ve;
    public boolean x;

    public RewardJointBottomView(Context context, ic icVar) {
        super(context);
        this.tt = new int[2];
        this.ve = new int[2];
        this.f29197a = 0;
        this.x = false;
        this.i = false;
        SSWebView sSWebView = new SSWebView(context);
        this.uj = sSWebView;
        sSWebView.setMaterialMeta(cu.c(icVar));
        this.uj.setWebViewClient(null);
        addView(this.uj, new ViewGroup.LayoutParams(-1, -1));
        this.uj.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.byazt.xzj.RewardJointBottomView.1
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                if (Math.abs((RewardJointBottomView.this.uj.getWebView().getHeight() + RewardJointBottomView.this.uj.getWebView().getScrollY()) - (RewardJointBottomView.this.uj.getWebView().getContentHeight() * RewardJointBottomView.this.uj.getWebView().getScale())) >= 10.0f) {
                    RewardJointBottomView.this.x = false;
                } else {
                    if (RewardJointBottomView.this.x) {
                        return;
                    }
                    RewardJointBottomView.this.x = true;
                }
            }
        });
        getScrollingChildHelper().c(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.da = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.c();
    }

    private uj getScrollingChildHelper() {
        if (this.n == null) {
            this.n = new uj(this);
        }
        return this.n;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return super.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return super.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f29197a = 0;
            this.c = motionEvent.getY();
            c(2, 0);
            this.i = this.x;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.c;
                if (y < 0.0f) {
                    c();
                    if (c(0, (int) y, this.tt, this.ve, 0)) {
                        y -= this.tt[1];
                    }
                    this.f29197a += c((int) ((Math.floor((double) Math.abs(y)) != AudioStats.AUDIO_AMPLITUDE_NONE ? y : 0.0f) - this.f29197a));
                } else {
                    int i = (int) (y - this.f29197a);
                    int iC = c(i);
                    this.f29197a += iC;
                    c(0, i - iC, this.tt, this.ve, 0);
                }
            }
        } else if (this.i && this.c - motionEvent.getY() > 100.0f && (onClickListener = this.sp) != null) {
            onClickListener.onClick(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public SSWebView getWebView() {
        return this.uj;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.sp = onClickListener;
    }

    public void tt() {
        c();
    }

    public void c(String str) {
        this.uj.loadUrl(str);
    }

    public boolean c(int i, int i2) {
        return getScrollingChildHelper().tt(0);
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().c(i, i2, iArr, iArr2, i3);
    }

    public int c(int i) {
        if (i < 0) {
            return (int) (-Math.abs(Math.min(this.uj.getWebView().getContentHeight() - (this.uj.getWebView().getHeight() + this.uj.getWebView().getScrollY()), -i)));
        }
        if (i > 0) {
            return Math.min(this.uj.getWebView().getScrollY(), i);
        }
        return 0;
    }

    public void c() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.da;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.da.tt();
        }
    }
}
