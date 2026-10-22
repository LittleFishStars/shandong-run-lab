package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class p4 extends p3 implements tn.c, hn.d, View.OnClickListener {
    private ViewGroup D0;
    private FrameLayout E0;
    private jp F0;
    private mi G0;
    private AdSpacesBean.BuyerBean.ShakeViewBean H0;
    private AdSpacesBean.BuyerBean.ScrollClickBean I0;
    private List J0;
    private Boolean K0;

    public class a implements ki {
        public a() {
        }

        @Override // com.beizi.fusion.ki
        public void a(mi miVar) {
            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdLoaded()");
            p4.this.j = b2.ADLOAD;
            p4 p4Var = p4.this;
            p4Var.K0 = Boolean.valueOf(p4Var.F0.s());
            if (p4.this.F0.q() != null) {
                try {
                    p4 p4Var2 = p4.this;
                    p4Var2.a(Double.parseDouble(p4Var2.F0.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            p4.this.f0();
            if (miVar == null) {
                p4.this.a(-991);
                return;
            }
            p4 p4Var3 = p4.this;
            p4Var3.G0 = miVar;
            p4Var3.Y0();
        }

        @Override // com.beizi.fusion.ki
        public void onAdFailed(int i) {
            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdFailed: " + i);
            p4.this.a(String.valueOf(i), i);
        }
    }

    public class c implements ji {
        public c() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            p4.this.M0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
        }
    }

    public class d implements ji {
        public d() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            p4.this.M0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onAdWillLeaveApplication");
        }
    }

    public class e implements oi {
        public e() {
        }

        @Override // com.beizi.fusion.oi
        public void onAdShown() {
            p4.this.N0();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p4.this.c("optimize");
        }
    }

    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup viewGroup = p4.this.e0;
            if (viewGroup == null) {
                return;
            }
            viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            p4.this.j1();
            p4.this.i1();
        }
    }

    public p4(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, int i) {
        super(context, j, buyerBean, forwardBean, m3Var, i);
        this.J0 = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            if (this.F0 != null) {
                this.b.setClickType(str);
                H0();
                jh.a("BeiZis", "enter showBeiZiUnifiedCustomAd clickUnifiedAd clickEventType:" + str);
                int[] iArr = new int[2];
                this.E0.getLocationOnScreen(iArr);
                this.E0.measure(0, 0);
                int[] iArrB = ol.b(this.E0.getMeasuredWidth() / 2, this.E0.getMeasuredHeight() / 2);
                pi.a(this.G0, this.E0, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.I0;
        if (scrollClickBean == null || this.x0 == null || scrollClickBean.getPosition() == null) {
            return;
        }
        String scrollClickUuid = this.I0.getScrollClickUuid();
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanA = a(this.I0.getOrderData(), this.F0.c());
        if (orderDataScrollViewOrderBeanA != null) {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClick = orderDataScrollViewOrderBeanA.getScrollClick();
            if (scrollClick != null) {
                scrollClickUuid = scrollClick.getScrollClickUuid();
            }
            this.x0.a(orderDataScrollViewOrderBeanA.getScrollClick());
        } else {
            this.x0.a(this.I0);
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setScrollClickUuid(scrollClickUuid);
            H0();
        }
        this.x0.a(this.K0);
        View viewA = this.x0.a(so.b(this.u0, this.e0.getWidth()), so.b(this.u0, this.e0.getHeight()), this.I0.getPosition());
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    this.e0.addView(viewA, layoutParams2);
                    this.x0.a(this);
                    a(this.e0, this.I0.getScrollDirection(), this.I0.getScrollDistance(), this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        if (q1.h().u()) {
            return;
        }
        if (this.w0 == null) {
            this.w0 = new tn(this.u0);
        }
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.H0;
        if (shakeViewBean == null || this.w0 == null || shakeViewBean.getPosition() == null) {
            return;
        }
        String shakeViewUuid = this.H0.getShakeViewUuid();
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanB = b(this.H0.getOrderData(), this.F0.c());
        if (orderDataShakeViewBeanB != null) {
            AdSpacesBean.BuyerBean.ShakeViewBean shakeView = orderDataShakeViewBeanB.getShakeView();
            if (shakeView != null) {
                shakeViewUuid = shakeView.getShakeViewUuid();
            }
            this.w0.a(orderDataShakeViewBeanB.getShakeView());
        } else {
            this.w0.a(this.H0);
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setShakeViewUuid(shakeViewUuid);
            H0();
        }
        this.w0.a(this.K0);
        View viewA = this.w0.a(so.b(this.u0, this.e0.getWidth()), so.b(this.u0, this.e0.getHeight()), this.H0.getPosition());
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    this.e0.addView(viewA, layoutParams2);
                    this.w0.a(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void k1() {
        if (this.F0 == null) {
            B();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shakeViewBean != null ? ");
        sb.append(this.H0 != null);
        jh.a("BeiZis", sb.toString());
        this.e0.removeAllViews();
        this.e0.getViewTreeObserver().addOnGlobalLayoutListener(new g());
    }

    @Override // com.beizi.fusion.p3
    public void O0() {
        if (ol.a(this.A0.getCec())) {
            c("regionalClick");
        } else {
            U0();
        }
    }

    @Override // com.beizi.fusion.p3
    public String P0() {
        ArrayList arrayListL;
        String strK = this.G0.k();
        return (!TextUtils.isEmpty(strK) || (arrayListL = this.G0.l()) == null || arrayListL.size() < 3) ? strK : (String) arrayListL.get(2);
    }

    @Override // com.beizi.fusion.p3
    public String Q0() {
        return this.G0.d();
    }

    @Override // com.beizi.fusion.d2
    public boolean R() {
        jp jpVar = this.F0;
        if (jpVar == null) {
            return false;
        }
        return jpVar.v();
    }

    @Override // com.beizi.fusion.p3
    public String R0() {
        return this.G0.getIconUrl();
    }

    @Override // com.beizi.fusion.p3
    public int S0() {
        return R.layout.beizi_layout_unified_view;
    }

    @Override // com.beizi.fusion.p3
    public String T0() {
        return this.G0.b();
    }

    @Override // com.beizi.fusion.p3
    public void W0() {
        super.W0();
        this.D0 = (ViewGroup) this.V.findViewById(R.id.fl_container_mask);
    }

    @Override // com.beizi.fusion.hn.d
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
    }

    @Override // com.beizi.fusion.p3
    public void a1() {
        u0();
        vq.b(this.u0, this.h);
        v0();
        Log.d("BeiZis", x() + ":requestAd:" + this.h + "====" + this.i + "===" + this.o0);
        long j = this.o0;
        if (j > 0) {
            this.L.sendEmptyMessageDelayed(1, j);
        } else {
            m3 m3Var = this.d;
            if (m3Var != null && m3Var.n() < 1 && this.d.z() != 2) {
                z0();
            }
        }
        this.x0 = new hn(this.u0);
    }

    @Override // com.beizi.fusion.p3
    public void b1() {
        this.H0 = this.e.getShakeView();
        this.I0 = this.e.getScrollClick();
        jp jpVar = new jp(this.u0, this.i, new a());
        this.F0 = jpVar;
        jpVar.b(true);
        if ("S2S".equals(l())) {
            this.F0.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.F0.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            this.F0.c(m3Var2.y());
            this.F0.d(this.d.v());
        }
        this.F0.w();
    }

    @Override // com.beizi.fusion.p3
    public void c1() {
        k1();
        List list = this.J0;
        if (list == null || list.size() <= 0) {
            pi.a(this.G0, this.E0, new d());
        } else {
            pi.a(this.G0, this.E0, this.J0, new c());
        }
        jp jpVar = this.F0;
        if (jpVar != null) {
            jpVar.a(this.E0, new e());
        }
        if (ol.a(this.A0.getRmc())) {
            new Handler().postDelayed(new f(), (long) ((Math.random() * 1000.0d) + 1000.0d));
        }
    }

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            jp jpVar = this.F0;
            if (jpVar == null) {
                return;
            }
            jpVar.b(map);
            if (map.containsKey("winPrice") && (obj4 = map.get("winPrice")) != null && (obj4 instanceof String)) {
                String str = (String) obj4;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj3 = map.get("adnId")) != null && (obj3 instanceof String)) {
                String str2 = (String) obj3;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setAdnId(str2);
                }
            }
            if (map.containsKey("highestLossPrice") && (obj2 = map.get("highestLossPrice")) != null && (obj2 instanceof String)) {
                String str3 = (String) obj2;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setHighestLossPrice(str3);
                }
            }
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null && (obj instanceof String)) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    this.b.setSecondPrice(str4);
                }
            }
            H0();
            s0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.p3, com.beizi.fusion.d2
    public void g() {
        mi miVar = this.G0;
        if (miVar != null) {
            miVar.destroy();
        }
        jp jpVar = this.F0;
        if (jpVar != null) {
            jpVar.a();
        }
    }

    @Override // com.beizi.fusion.p3
    public void g1() {
        this.a0.removeAllViews();
        this.a0.addView(this.E0, new FrameLayout.LayoutParams(-1, -1));
        this.D0.setLayoutParams(this.a0.getLayoutParams());
    }

    @Override // com.beizi.fusion.p3
    public void h1() {
        if (this.G0 == null) {
            a(-991);
        } else {
            of.a((Context) null).a(this.G0.getImageUrl(), new b());
        }
    }

    @Override // com.beizi.fusion.d2
    public String n() {
        jp jpVar = this.F0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c("regionalClick");
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        jp jpVar = this.F0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.l();
    }

    @Override // com.beizi.fusion.p3, com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.F0 == null) {
            return;
        }
        F0();
    }

    public class b implements of.f {
        public b() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            p4 p4Var = p4.this;
            p4Var.E0 = pi.a(p4Var.u0, bitmap, p4Var.G0);
            p4.this.V0();
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
            p4.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean b(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean = (AdSpacesBean.BuyerBean.OrderDataShakeViewBean) it.next();
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.hn.d
    public void b() {
        if (this.I0 != null) {
            jh.a("BeiZis", "enter showBeiZiUnifiedCustomAd onScrollDistanceMeet  ");
            c("scroll");
        }
    }

    @Override // com.beizi.fusion.p3
    public void a(List list) {
        List<String> clickView = this.A0.getClickView();
        if (clickView != null && clickView.size() > 0) {
            if (!clickView.contains("bg") && !clickView.contains("ad") && !clickView.contains("image")) {
                this.D0.setVisibility(0);
            } else {
                this.D0.setVisibility(8);
            }
            this.J0.clear();
            this.J0.addAll(list);
            return;
        }
        this.D0.setVisibility(0);
    }

    @Override // com.beizi.fusion.p3
    public void b(boolean z) {
        boolean zA = ol.a(this.A0.getSlc());
        boolean zA2 = ol.a(this.A0.getSlac());
        if (z && zA) {
            c("regionalClick");
        } else if (!z && zA2) {
            c("regionalClick");
        } else {
            U0();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean a(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean = (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean) it.next();
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            jp jpVar = this.F0;
            if (jpVar == null) {
                return;
            }
            jpVar.a(map);
            if (map.containsKey("winPrice") && (obj3 = map.get("winPrice")) != null && (obj3 instanceof String)) {
                String str = (String) obj3;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj2 = map.get("adnId")) != null && (obj2 instanceof String)) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setAdnId(str2);
                }
            }
            if (map.containsKey("lossReason") && (obj = map.get("lossReason")) != null && (obj instanceof String)) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setLossReason(str3);
                }
            }
            H0();
            r0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.tn.c
    public void a() {
        jh.a("BeiZis", "enter showBeiZiUnifiedCustomAd onShakeHappened  ");
        c("shake");
    }
}
