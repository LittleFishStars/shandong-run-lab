package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.ad.internal.splash.SplashUnifiedActionData;
import com.beizi.ad.internal.splash.SplashUnifiedAdResponse;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class r4 extends d2 {
    private Context U;
    private ej V;
    private SplashUnifiedAdResponse W;
    private List X;
    private ViewGroup Y;
    private long Z;
    private boolean a0;
    private long b0;
    private boolean c0;
    private boolean d0;
    private boolean e0;
    private tn f0;
    private String g0 = null;
    private boolean h0 = false;
    private int i0 = -1;

    public class a implements go {
        public a() {
        }

        @Override // com.beizi.fusion.go
        public void a(SplashUnifiedAdResponse splashUnifiedAdResponse) {
            if (splashUnifiedAdResponse == null) {
                Log.d("BeiZis", "showBeiZiSplash onAdFailedToLoad splashUnifiedAdResponse is null:");
                r4.this.a(String.valueOf(3), 3);
                return;
            }
            Log.d("BeiZis", "showBeiZiUnifiedSplash onAdLoaded:" + System.currentTimeMillis());
            r4 r4Var = r4.this;
            r4Var.W = splashUnifiedAdResponse;
            r4Var.j = b2.ADLOAD;
            if (r4.this.V.q() != null) {
                try {
                    r4 r4Var2 = r4.this;
                    r4Var2.a(Double.parseDouble(r4Var2.V.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            r4 r4Var3 = r4.this;
            r4Var3.a0 = r4Var3.V.u();
            r4 r4Var4 = r4.this;
            if (r4Var4.a0) {
                r4Var4.b0 = r4Var4.V.f();
                r4.this.b.setIsCacheAd("1");
                if (r4.this.b0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    r4 r4Var5 = r4.this;
                    r4Var5.b.setCacheTime(String.valueOf(jCurrentTimeMillis - r4Var5.b0));
                }
                r4.this.H0();
            }
            r4.this.f0();
            if (r4.this.V()) {
                r4.this.O0();
            } else {
                r4.this.A();
            }
        }

        @Override // com.beizi.fusion.go
        public void onAdClick() {
            Log.d("BeiZis", "showBeiZiUnifiedSplash onAdClicked()");
            r4.this.Z();
            r4.this.M0();
        }

        @Override // com.beizi.fusion.go
        public void onAdClosed() {
            Log.d("BeiZis", "showBeiZiUnifiedSplash onAdClosed()");
            if (r4.this.d != null) {
                r4.this.d.c(r4.this.x());
            }
            r4.this.b0();
        }

        @Override // com.beizi.fusion.go
        public void onAdFailed(int i) {
            Log.d("BeiZis", "showBeiZiSplash onAdFailedToLoad:" + i);
            r4.this.a(String.valueOf(i), i);
        }

        @Override // com.beizi.fusion.go
        public void onAdShown() {
            Log.d("BeiZis", "showBeiZiUnifiedSplash onAdShown()");
            r4.this.j = b2.ADSHOW;
            r4 r4Var = r4.this;
            if (r4Var.a0) {
                r4Var.b.setIsCacheAd("1");
                if (r4.this.b0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    r4 r4Var2 = r4.this;
                    r4Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - r4Var2.b0));
                }
                r4.this.H0();
            }
            if (r4.this.d != null) {
                if (r4.this.d.z() != 2) {
                    r4.this.d.d(r4.this.x());
                }
                r4.this.L0();
            }
            r4.this.i0();
            r4.this.y0();
            r4.this.d0();
            r4.this.N0();
        }
    }

    public class b implements UnifiedSplashAdResponse {
        public b() {
        }

        @Override // com.beizi.fusion.UnifiedSplashAdResponse
        public String getElements() {
            SplashUnifiedAdResponse splashUnifiedAdResponse = r4.this.W;
            if (splashUnifiedAdResponse == null) {
                return null;
            }
            return splashUnifiedAdResponse.getElements();
        }

        @Override // com.beizi.fusion.UnifiedSplashAdResponse
        public String getIconUrl() {
            SplashUnifiedAdResponse splashUnifiedAdResponse = r4.this.W;
            if (splashUnifiedAdResponse == null) {
                return null;
            }
            return splashUnifiedAdResponse.getIconUrl();
        }

        @Override // com.beizi.fusion.UnifiedSplashAdResponse
        public String getImageUrl() {
            SplashUnifiedAdResponse splashUnifiedAdResponse = r4.this.W;
            if (splashUnifiedAdResponse == null) {
                return null;
            }
            return splashUnifiedAdResponse.getImageUrl();
        }

        @Override // com.beizi.fusion.UnifiedSplashAdResponse
        public String getTextUrl() {
            SplashUnifiedAdResponse splashUnifiedAdResponse = r4.this.W;
            if (splashUnifiedAdResponse == null) {
                return null;
            }
            return splashUnifiedAdResponse.getTextUrl();
        }

        @Override // com.beizi.fusion.UnifiedSplashAdResponse
        public boolean isDownloadApp() {
            SplashUnifiedAdResponse splashUnifiedAdResponse = r4.this.W;
            if (splashUnifiedAdResponse == null) {
                return false;
            }
            return splashUnifiedAdResponse.isDownloadApp();
        }
    }

    public class c implements tn.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27711a;

        public c(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27711a = shakeViewBean;
        }

        @Override // com.beizi.fusion.tn.c
        public void a() {
            r4 r4Var = r4.this;
            if (r4Var.c0) {
                return;
            }
            if (r4Var.h0 && this.f27711a.getCoolShakeView() != null) {
                r4 r4Var2 = r4.this;
                co.b(r4Var2.U, r4Var2.g0, Long.valueOf(System.currentTimeMillis()));
            }
            r4.this.b.setClickType("shake");
            r4.this.H0();
            SplashUnifiedActionData splashUnifiedActionData = new SplashUnifiedActionData();
            splashUnifiedActionData.setClickType(2);
            r4.this.a(1, splashUnifiedActionData);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27712a;

        public d(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27712a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            r4 r4Var = r4.this;
            r4Var.h0 = true;
            r4Var.f0.a(this.f27712a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27713a;

        public e(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27713a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            r4 r4Var = r4.this;
            r4Var.h0 = true;
            tn tnVar = r4Var.f0;
            if (tnVar != null) {
                tnVar.a(this.f27713a);
            }
        }
    }

    public r4(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var) {
        this.U = context;
        this.Z = j;
        this.e = buyerBean;
        this.f = forwardBean;
        this.d = m3Var;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void M0() {
        if (this.d0 && !this.e0) {
            this.e0 = true;
            Y();
            m3 m3Var = this.d;
            if (m3Var != null) {
                m3Var.b(x());
                I0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView2;
        try {
            wk wkVarP = this.V.p();
            if (wkVarP != null && wkVarP.b() == 1) {
                int iC = wkVarP.c();
                AdSpacesBean.BuyerBean buyerBean = this.e;
                if (buyerBean == null || this.Y == null || (shakeView = buyerBean.getShakeView()) == null || shakeView.getPosition() == null) {
                    return;
                }
                if (this.f0 == null) {
                    this.f0 = new tn(this.U);
                }
                String shakeViewUuid = shakeView.getShakeViewUuid();
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(shakeView.getOrderData(), this.V.c());
                if (orderDataShakeViewBeanA == null || orderDataShakeViewBeanA.getShakeView() == null) {
                    shakeView2 = null;
                } else {
                    shakeView2 = orderDataShakeViewBeanA.getShakeView();
                    if (shakeView2 != null) {
                        shakeViewUuid = shakeView2.getShakeViewUuid();
                    }
                }
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(shakeViewUuid);
                    H0();
                }
                ej ejVar = this.V;
                if (ejVar != null) {
                    this.f0.a(Boolean.valueOf(ejVar.s()));
                }
                View viewA = this.f0.a(so.b(this.U, this.Y.getWidth()), so.b(this.U, this.Y.getHeight()), shakeView.getPosition());
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        if (iC == 0) {
                            viewA.setVisibility(4);
                        } else {
                            viewA.setVisibility(0);
                        }
                        this.Y.addView(viewA, layoutParams2);
                    }
                }
                a(shakeView);
                b(shakeView2, shakeView);
                this.f0.a(new c(shakeView));
                a(shakeView2, shakeView, viewA);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        m3 m3Var = this.d;
        if (m3Var == null) {
            return;
        }
        Log.d("BeiZis", "splashWorkers:" + m3Var.C().toString());
        f();
        s5 s5Var = this.g;
        if (s5Var == s5.SUCCESS) {
            this.d.a(x(), new b());
        } else if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    private void P0() {
        try {
            tn tnVar = this.f0;
            if (tnVar != null) {
                tnVar.q();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
        this.g0 = "splash_cool_" + this.i;
        jh.c("BeiZis", "AdWorker chanel = " + this.c);
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
        long sleepTime = this.f.getSleepTime();
        if (this.d.I()) {
            sleepTime = Math.max(sleepTime, this.f.getHotRequestDelay());
        }
        Log.d("BeiZis", x() + ":requestAd:" + this.h + "====" + this.i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.L.sendEmptyMessageDelayed(1, sleepTime);
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
        ej ejVar = this.V;
        if (ejVar == null) {
            return false;
        }
        return ejVar.v();
    }

    @Override // com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.V == null) {
            return;
        }
        F0();
    }

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        this.X = this.e.getScreenConfigVo();
        ej ejVar = new ej(this.U, this.i);
        this.V = ejVar;
        ejVar.a(new a());
        this.V.a((int) this.Z);
        this.V.a(this.e);
        try {
            this.V.a(this.b.m167clone());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ("S2S".equals(l())) {
            this.V.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.V.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            this.V.c(m3Var2.y());
            this.V.d(this.d.v());
        }
        this.V.w();
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            ej ejVar = this.V;
            if (ejVar == null) {
                return;
            }
            ejVar.a(map);
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

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            ej ejVar = this.V;
            if (ejVar == null) {
                return;
            }
            ejVar.b(map);
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

    @Override // com.beizi.fusion.d2
    public void g() {
        try {
            super.g();
            ej ejVar = this.V;
            if (ejVar != null) {
                ejVar.a();
                this.V = null;
            }
            P0();
        } catch (Exception e2) {
            e2.printStackTrace();
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
        ej ejVar = this.V;
        if (ejVar == null) {
            return null;
        }
        return ejVar.d();
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        ej ejVar = this.V;
        if (ejVar == null) {
            return null;
        }
        return ejVar.l();
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        SplashUnifiedAdResponse splashUnifiedAdResponse = this.W;
        if (splashUnifiedAdResponse == null) {
            return null;
        }
        return splashUnifiedAdResponse.getPrice();
    }

    private void b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = shakeViewBean != null ? shakeViewBean : shakeViewBean2;
        int regulatoryAngle = shakeViewBean3.getRegulatoryAngle();
        tn tnVar = this.f0;
        if (tnVar != null) {
            tnVar.g(regulatoryAngle);
            f5 f5Var = this.E;
            if (f5Var != null) {
                this.f0.a(f5Var.b());
            }
        }
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeView = shakeViewBean2.getCoolShakeView();
        if (coolShakeView == null) {
            if (a(shakeViewBean, shakeViewBean2)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean3.getAliaseShakeView();
                if (aliaseShakeView != null) {
                    this.f0.a(aliaseShakeView);
                    new Handler().postDelayed(new d(shakeViewBean3), ol.b(aliaseShakeView.getPassivationTime()));
                    return;
                }
                return;
            }
            this.h0 = true;
            this.f0.a(shakeViewBean3);
            return;
        }
        if (b(coolShakeView.getCoolTime())) {
            this.i0 = coolShakeView.getFeedback();
            this.f0.a(coolShakeView);
            return;
        }
        if (c(coolShakeView.getUserProtectTime())) {
            this.i0 = coolShakeView.getFeedback();
            this.f0.a(coolShakeView);
        } else {
            if (a(shakeViewBean, shakeViewBean2)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean3.getAliaseShakeView();
                if (aliaseShakeView2 != null) {
                    this.f0.a(aliaseShakeView2);
                    new Handler().postDelayed(new e(shakeViewBean3), ol.b(aliaseShakeView2.getPassivationTime()));
                    return;
                }
                return;
            }
            this.h0 = true;
            this.f0.a(shakeViewBean3);
        }
    }

    @Override // com.beizi.fusion.d2
    public void a(Message message) {
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setError(String.valueOf(message.obj));
            this.b.setErrorCode(String.valueOf(message.obj));
            H0();
            e0();
        }
    }

    @Override // com.beizi.fusion.d2
    public void a(ViewGroup viewGroup) {
        ej ejVar;
        try {
            Log.d("BeiZis", x() + " out make show ad");
            if (viewGroup != null && (ejVar = this.V) != null) {
                this.Y = viewGroup;
                ejVar.a(viewGroup);
                return;
            }
            B();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void a(UnifiedSplashActionData unifiedSplashActionData) {
        try {
            if (this.V != null && this.Y != null) {
                SplashUnifiedActionData splashUnifiedActionData = new SplashUnifiedActionData();
                int type = unifiedSplashActionData.getType();
                splashUnifiedActionData.setClickType(type);
                if (type != 10 && type != 20) {
                    int downX = unifiedSplashActionData.getDownX();
                    int downY = unifiedSplashActionData.getDownY();
                    int upX = unifiedSplashActionData.getUpX();
                    int upY = unifiedSplashActionData.getUpY();
                    int[] iArr = new int[2];
                    this.Y.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int i3 = downY + i2;
                    splashUnifiedActionData.setDownX(String.valueOf(downX));
                    splashUnifiedActionData.setDownY(String.valueOf(downY));
                    splashUnifiedActionData.setDownRawX(String.valueOf(downX + i));
                    splashUnifiedActionData.setDownRawY(String.valueOf(i3));
                    splashUnifiedActionData.setUpX(String.valueOf(upX));
                    splashUnifiedActionData.setUpY(String.valueOf(upY));
                    splashUnifiedActionData.setUpRawX(String.valueOf(i + upX));
                    splashUnifiedActionData.setUpRawY(String.valueOf(i2 + upY));
                    a(0, splashUnifiedActionData);
                    return;
                }
                this.V.a(splashUnifiedActionData);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean c(long j) {
        try {
            return System.currentTimeMillis() - so.a(this.U).longValue() < j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean b(long j) {
        long jLongValue = ((Long) co.a(this.U, this.g0, (Object) 0L)).longValue();
        return jLongValue != 0 && System.currentTimeMillis() - jLongValue < j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, SplashUnifiedActionData splashUnifiedActionData) {
        if (i == 0) {
            this.d0 = true;
        }
        if (this.c0) {
            if (i == 0) {
                M0();
            }
        } else {
            this.c0 = true;
            P0();
            this.V.a(splashUnifiedActionData);
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List list, String str) {
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

    private boolean a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2) {
        if (shakeViewBean != null) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean.getAliaseShakeView();
            if (aliaseShakeView == null || aliaseShakeView.getPassivationTime() <= 0) {
                return false;
            }
            return aliaseShakeView.getShakeCount() > 0 || aliaseShakeView.getRotatCount() > 0;
        }
        AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean2.getAliaseShakeView();
        if (shakeViewBean2.getAliaseShakeView() == null || aliaseShakeView2.getPassivationTime() <= 0) {
            return false;
        }
        return aliaseShakeView2.getShakeCount() > 0 || aliaseShakeView2.getRotatCount() > 0;
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2, View view) {
        if (this.i0 == -1) {
            this.i0 = shakeViewBean2.getFeedback();
            if (shakeViewBean != null) {
                this.i0 = shakeViewBean.getFeedback();
            }
        }
        if (this.i0 == 0 || view == null || this.f0 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ShakeArcView shakeArcView = new ShakeArcView(this.U);
            shakeArcView.setLineRadius(5);
            int i = (int) (((double) marginLayoutParams.width) * 0.5d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.leftMargin = marginLayoutParams.leftMargin + (((marginLayoutParams.width - i) - 12) / 2);
            layoutParams2.topMargin = (int) (((double) marginLayoutParams.topMargin) + (((double) marginLayoutParams.height) * 0.08d));
            this.Y.addView(shakeArcView, layoutParams2);
            this.f0.a(shakeArcView, this.i0);
        }
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        int sensorParam = shakeViewBean.getSensorParam();
        int compliantAngle = shakeViewBean.getCompliantAngle();
        int isUnidirection = shakeViewBean.getIsUnidirection();
        boolean zIsReturnAngle = shakeViewBean.isReturnAngle();
        ej ejVar = this.V;
        Map mapR = ejVar != null ? ejVar.r() : null;
        tn tnVar = this.f0;
        if (tnVar == null) {
            return;
        }
        tnVar.a(sensorParam, compliantAngle, zIsReturnAngle, isUnidirection, mapR);
    }
}
