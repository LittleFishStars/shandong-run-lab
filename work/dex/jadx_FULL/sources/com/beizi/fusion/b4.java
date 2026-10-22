package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b4 extends d2 implements a2 {
    private Context U;
    private String V;
    private long W;
    private long X;
    private yf Y;
    protected String Z = null;
    private AdSpacesBean.UniteControlBean a0;
    private int b0;
    private boolean c0;
    private long d0;

    public b4(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var) {
        this.U = context;
        this.V = str;
        this.W = j;
        this.X = j2;
        this.e = buyerBean;
        this.d = m3Var;
        this.f = forwardBean;
        C();
    }

    private boolean M0() {
        try {
            AdSpacesBean.UniteControlBean uniteControlBean = this.a0;
            if (uniteControlBean == null) {
                return true;
            }
            int random = uniteControlBean.getRandom();
            long duration = this.a0.getDuration();
            long jLongValue = ((Long) co.a(this.U, "uniteTime", (Object) 0L)).longValue();
            return jLongValue <= 0 || duration <= 0 || System.currentTimeMillis() - jLongValue >= duration || random >= this.b0 || random == 100;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        m3 m3Var = this.d;
        if (m3Var == null) {
            return;
        }
        Log.d("BeiZis", "splashWorkers:" + m3Var.C().toString());
        f();
        s5 s5Var = this.g;
        if (s5Var == s5.SUCCESS) {
            this.d.b(x(), (View) null);
            return;
        }
        if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    private void O0() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.e.getEulerAngleRule();
        if (eulerAngleRule == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBeanA = a(eulerAngleRule.getOrderData(), this.Y.c());
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule2 = (orderDataEulerAngleViewBeanA == null || orderDataEulerAngleViewBeanA.getEulerAngleRule() == null) ? null : orderDataEulerAngleViewBeanA.getEulerAngleRule();
        if (eulerAngleRule2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setEulerAngleUuid(eulerAngleRule2.getEulerAngleUuid());
                H0();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setEulerAngleUuid(eulerAngleRule.getEulerAngleUuid());
            H0();
        }
    }

    private void P0() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick = this.e.getFullScreenClick();
        if (fullScreenClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBeanB = b(fullScreenClick.getOrderData(), this.Y.c());
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick2 = (orderDataFullScreenClickBeanB == null || orderDataFullScreenClickBeanB.getFullScreenClick() == null) ? null : orderDataFullScreenClickBeanB.getFullScreenClick();
        if (fullScreenClick2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setFullScreenClickUuid(fullScreenClick2.getFullScreenClickUuid());
                H0();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setFullScreenClickUuid(fullScreenClick.getFullScreenClickUuid());
            H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        R0();
        P0();
        T0();
        S0();
        O0();
    }

    private void R0() {
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = this.e.getRegionalClickView();
        if (regionalClickView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBeanC = c(regionalClickView.getOrderData(), this.Y.c());
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView2 = (orderDataRegionalClickViewBeanC == null || orderDataRegionalClickViewBeanC.getRegionalClickView() == null) ? null : orderDataRegionalClickViewBeanC.getRegionalClickView();
        if (regionalClickView2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setRegionalClickUuid(regionalClickView2.getRegionalClickUuid());
                H0();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setRegionalClickUuid(regionalClickView.getRegionalClickUuid());
            H0();
        }
    }

    private void S0() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick = this.e.getScrollClick();
        if (scrollClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanD = d(scrollClick.getOrderData(), this.Y.c());
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick2 = (orderDataScrollViewOrderBeanD == null || orderDataScrollViewOrderBeanD.getScrollClick() == null) ? null : orderDataScrollViewOrderBeanD.getScrollClick();
        if (scrollClick2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setScrollClickUuid(scrollClick2.getScrollClickUuid());
                H0();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setScrollClickUuid(scrollClick.getScrollClickUuid());
            H0();
        }
    }

    private void T0() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        if (shakeView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanE = e(shakeView.getOrderData(), this.Y.c());
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView2 = (orderDataShakeViewBeanE == null || orderDataShakeViewBeanE.getShakeView() == null) ? null : orderDataShakeViewBeanE.getShakeView();
        if (shakeView2 != null) {
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setShakeViewUuid(shakeView2.getShakeViewUuid());
                H0();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.b;
        if (eventBean2 != null) {
            eventBean2.setShakeViewUuid(shakeView.getShakeViewUuid());
            H0();
        }
    }

    @Override // com.beizi.fusion.d2
    public void A0() {
        if (this.d == null) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        this.Z = "complain_config_" + this.i;
        AdSpacesBean.FilterBean filter = this.e.getFilter();
        if (filter != null) {
            this.a0 = filter.getUniteControl();
        }
        this.b0 = ol.b(100);
        if (!M0()) {
            a(String.valueOf(10170), 10170);
            return;
        }
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.I = true;
                for (int i = 0; i < callBackStrategy.size(); i++) {
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        this.J = ol.a(Integer.parseInt(callBackStrategyBean.getRate()));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            EventBean eventBeanB = ikVar.a().b(this.c);
            this.b = eventBeanB;
            if (eventBeanB != null) {
                D();
                u0();
                vq.b(this.U, this.h);
                v0();
            }
        }
        Log.d("BeiZis", x() + ":requestAd:" + this.h + "====" + this.i + "===" + this.X);
        long j = this.X;
        if (j > 0) {
            this.L.sendEmptyMessageDelayed(1, j);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var == null || m3Var.n() >= 1 || this.d.z() == 2) {
            return;
        }
        z0();
    }

    @Override // com.beizi.fusion.d2
    public void G0() {
    }

    @Override // com.beizi.fusion.d2
    public boolean R() {
        yf yfVar = this.Y;
        if (yfVar == null) {
            return false;
        }
        return yfVar.v();
    }

    @Override // com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        yf yfVar = new yf(this.U, false);
        this.Y = yfVar;
        yfVar.a(this.i);
        this.Y.a(this.e);
        this.Y.a(new a());
        this.Y.b(true);
        try {
            this.Y.a(this.b.m167clone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.Y.a((int) this.W);
        this.Y.a(this.e);
        if ("S2S".equals(l())) {
            this.Y.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.Y.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            this.Y.c(m3Var2.y());
            this.Y.d(this.d.v());
        }
        this.Y.w();
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean c(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean = (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean) it.next();
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean d(List list, String str) {
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

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean e(List list, String str) {
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

    @Override // com.beizi.fusion.d2
    public void g() {
        yf yfVar = this.Y;
        if (yfVar != null) {
            yfVar.a();
        }
    }

    @Override // com.beizi.fusion.d2
    public b2 h() {
        return this.j;
    }

    @Override // com.beizi.fusion.d2
    public AdSpacesBean.BuyerBean m() {
        return this.e;
    }

    @Override // com.beizi.fusion.d2
    public String n() {
        yf yfVar = this.Y;
        if (yfVar == null) {
            return null;
        }
        return yfVar.d();
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        yf yfVar = this.Y;
        if (yfVar == null) {
            return null;
        }
        return yfVar.l();
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        yf yfVar = this.Y;
        if (yfVar == null) {
            return null;
        }
        return yfVar.q();
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        yf yfVar;
        if (L() && (yfVar = this.Y) != null && yfVar.t()) {
            F0();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean b(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean = (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean) it.next();
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
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
            yf yfVar = this.Y;
            if (yfVar == null) {
                return;
            }
            yfVar.a(map);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            yf yfVar = this.Y;
            if (yfVar == null) {
                return;
            }
            yfVar.b(map);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void a(Activity activity) {
        Log.d("BeiZis", x() + " out make show ad");
        try {
            if (!M0()) {
                a(String.valueOf(10170), 10170);
                return;
            }
            yf yfVar = this.Y;
            if (yfVar == null || !yfVar.t()) {
                return;
            }
            this.Y.a(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public class a extends p1 {
        public a() {
        }

        @Override // com.beizi.fusion.p1
        public void a() {
            super.a();
            Log.d("BeiZis", "showBeiZiInterstitialAd onAdClick()");
            if (b4.this.I && b4.this.e != null) {
                b4.this.b.setCallBackStrategyUuid(b4.this.e.getCallBackStrategyUuid());
                b4.this.H0();
            }
            b4.this.Z();
            if (b4.this.O()) {
                yf yfVar = b4.this.Y;
                if (yfVar == null || yfVar.g() != 2) {
                    if (b4.this.d != null && b4.this.d.z() != 2) {
                        b4.this.d.b(b4.this.x());
                    }
                    b4.this.Y();
                    b4.this.I0();
                }
            }
        }

        @Override // com.beizi.fusion.p1
        public void b() {
            Log.d("BeiZis", "showBeiZiInterstitialAd onAdClosed()");
            if (b4.this.d != null && b4.this.d.z() != 2) {
                b4.this.d.c(b4.this.x());
            }
            b4.this.b0();
        }

        @Override // com.beizi.fusion.p1
        public void c() {
            super.c();
            Log.d("BeiZis", "showBeiZiInterstitialAd onAdLoaded()");
            b4.this.j = b2.ADLOAD;
            if (b4.this.Y.q() != null) {
                try {
                    b4 b4Var = b4.this;
                    b4Var.a(Double.parseDouble(b4Var.Y.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            b4 b4Var2 = b4.this;
            b4Var2.c0 = b4Var2.Y.u();
            b4 b4Var3 = b4.this;
            yf yfVar = b4Var3.Y;
            if (yfVar != null) {
                b4Var3.E = yfVar.i();
                if (b4.this.E != null) {
                    b4 b4Var4 = b4.this;
                    b4Var4.F = b4Var4.E.c();
                    if (b4.this.F != 0) {
                        b4 b4Var5 = b4.this;
                        b4Var5.G = b4Var5.E.e() + 1;
                    }
                }
                b4 b4Var6 = b4.this;
                b4Var6.H = b4Var6.Y.m();
            }
            b4 b4Var7 = b4.this;
            if (b4Var7.c0) {
                b4Var7.d0 = b4Var7.Y.f();
                b4.this.b.setIsCacheAd("1");
                if (b4.this.d0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    b4 b4Var8 = b4.this;
                    b4Var8.b.setCacheTime(String.valueOf(jCurrentTimeMillis - b4Var8.d0));
                }
                b4.this.H0();
            }
            b4.this.f0();
            if (b4.this.V()) {
                b4.this.N0();
            } else {
                b4.this.A();
            }
            b4.this.Q0();
        }

        @Override // com.beizi.fusion.p1
        public void d() {
            super.d();
            Log.d("BeiZis", "showBeiZiInterstitialAd onAdShown()");
            b4.this.j = b2.ADSHOW;
            b4 b4Var = b4.this;
            if (b4Var.c0) {
                b4Var.b.setIsCacheAd("1");
                if (b4.this.d0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    b4 b4Var2 = b4.this;
                    b4Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - b4Var2.d0));
                }
                b4.this.H0();
            }
            if (b4.this.d != null && b4.this.d.z() != 2) {
                b4.this.d.d(b4.this.x());
                b4.this.L0();
            }
            b4.this.i0();
            b4.this.y0();
            b4.this.d0();
        }

        @Override // com.beizi.fusion.p1
        public void a(int i) {
            super.a(i);
            Log.d("BeiZis", "showBeiZiInterstitialAd onAdFailedToLoad: " + i);
            b4.this.a(String.valueOf(i), i);
        }

        @Override // com.beizi.fusion.p1
        public void a(String str) {
            super.a(str);
            try {
                b4 b4Var = b4.this;
                co.b(b4Var.U, b4Var.Z, Long.valueOf(System.currentTimeMillis()));
                b4.this.b.setComplain(str);
                b4.this.H0();
                b4.this.c0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean a(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean = (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean) it.next();
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }
}
