package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;
import com.kc.aw.lib.constants.BiddingConst;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hn {
    private static AdSpacesBean.BuyerBean.ScrollClickBean k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27370a;
    private int b;
    private int c;
    private d d = null;
    private boolean e = false;
    private int f = 200;
    ScrollClickView g;
    private Boolean h;
    int i;
    int j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hn.this.a();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27372a;
        final /* synthetic */ int b;
        final /* synthetic */ FrameLayout.LayoutParams c;

        public b(int i, int i2, FrameLayout.LayoutParams layoutParams) {
            this.f27372a = i;
            this.b = i2;
            this.c = layoutParams;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ScrollClickView scrollClickView = hn.this.g;
            if (scrollClickView == null) {
                return;
            }
            scrollClickView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int measuredWidth = hn.this.g.getMeasuredWidth();
            hn hnVar = hn.this;
            if (hnVar.j == 0) {
                hnVar.j = so.a(hnVar.f27370a, this.f27372a) / 2;
            }
            hn hnVar2 = hn.this;
            if (hnVar2.i == 0) {
                hnVar2.i = so.a(hnVar2.f27370a, this.b) / 2;
            }
            FrameLayout.LayoutParams layoutParams = this.c;
            hn hnVar3 = hn.this;
            layoutParams.topMargin = hnVar3.j;
            layoutParams.leftMargin = hnVar3.i - (measuredWidth / 2);
            hnVar3.g.setLayoutParams(layoutParams);
            jh.a("ScrollClickUtil", "topMargin = " + this.c.topMargin + ",leftMargin = " + this.c.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ScrollClickView scrollClickView = hn.this.g;
                if (scrollClickView != null) {
                    scrollClickView.startAnim();
                }
            } catch (Exception unused) {
            }
        }
    }

    public interface d {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void b();
    }

    public hn(Context context) {
        this.f27370a = context;
    }

    public void a(AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean) {
        if (scrollClickBean == null) {
            return;
        }
        k = scrollClickBean;
        c(scrollClickBean.getRandomClickTime());
        b(scrollClickBean.getRandomClickNum());
    }

    public void b(int i) {
        this.c = i;
        c();
    }

    public void c(int i) {
        this.b = i;
    }

    private void c() {
        Pair pairA = a(this.c);
        if (((Boolean) pairA.second).booleanValue()) {
            b9.a(new a(), this.b + (((Integer) pairA.first).intValue() * 10));
        }
    }

    public void b() {
        this.e = false;
        ScrollClickView scrollClickView = this.g;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
        this.d = null;
        this.f27370a = null;
        this.g = null;
        this.f = 200;
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public static Pair a(int i) {
        int iRandom = (int) ((Math.random() * 100.0d) + 1.0d);
        if (iRandom <= i) {
            return new Pair(Integer.valueOf(iRandom), Boolean.TRUE);
        }
        return new Pair(Integer.valueOf(iRandom), Boolean.FALSE);
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.d != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.e);
        jh.a("ScrollClickUtil", sb.toString());
        if (this.d == null || this.e) {
            return;
        }
        jh.a("ScrollClickUtil", "callback onShakeHappened()");
        this.d.a("100", "200", BiddingConst.ADN_ID.HW, "206", "100", "200", BiddingConst.ADN_ID.HW, "206");
        this.e = true;
        ScrollClickView scrollClickView = this.g;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean) {
        String downloadDetails;
        int i3;
        int i4;
        jh.a("ScrollClickUtil", "enter getScrollClick");
        if (this.f27370a == null || scrollClickPositionBean == null) {
            return null;
        }
        ScrollClickView scrollClickView = new ScrollClickView(this.f27370a);
        this.g = scrollClickView;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = k;
            if (scrollClickBean != null) {
                scrollClickView.setScrollDirection(scrollClickBean.getScrollDirection());
                this.g.setTitleText(k.getTitle());
                this.g.setTitleFont(k.getTitleFont());
                if (!this.h.booleanValue()) {
                    downloadDetails = k.getDetails();
                } else {
                    downloadDetails = k.getDownloadDetails();
                    if (TextUtils.isEmpty(downloadDetails)) {
                        downloadDetails = "下载应用";
                    }
                }
                this.g.setDetailText(downloadDetails);
                this.g.setDetailsFont(k.getDetailsFont());
                AdSpacesBean.BuyerBean.ScrollClickPositionBean position = k.getPosition();
                String width = position.getWidth();
                String height = position.getHeight();
                if (width.endsWith("%")) {
                    i3 = (Integer.parseInt(width.substring(0, width.indexOf("%"))) * i) / 100;
                } else {
                    i3 = Integer.parseInt(width);
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                } else {
                    i4 = Integer.parseInt(height);
                }
                this.g.setHandWidth(i3);
                this.g.setScrollbarHeight(i4);
                this.g.buildRealView();
            }
            String top = scrollClickPositionBean.getTop();
            String centerX = scrollClickPositionBean.getCenterX();
            if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                centerX = "50%";
            }
            if (TextUtils.isEmpty(top) || "0".equals(top)) {
                top = "50%";
            }
            so.i(this.f27370a);
            if (centerX.endsWith("%")) {
                this.i = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
            } else {
                this.i = Integer.parseInt(centerX);
            }
            if (top.endsWith("%")) {
                this.j = (Integer.parseInt(top.substring(0, top.indexOf("%"))) * i2) / 100;
            } else {
                this.j = Integer.parseInt(top);
            }
            this.i = so.a(this.f27370a, this.i);
            this.j = so.a(this.f27370a, this.j);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            jh.a("ScrollClickUtil", "topInt = " + this.j + ",centerXInt = " + this.i + ",adWidthDp = " + i + ",adHeightDp = " + i2);
            this.g.getViewTreeObserver().addOnGlobalLayoutListener(new b(i2, i, layoutParams));
            this.g.setLayoutParams(layoutParams);
            this.g.postDelayed(new c(), 10L);
        } catch (NumberFormatException unused) {
        }
        return this.g;
    }

    public void a(Boolean bool) {
        this.h = bool;
    }
}
