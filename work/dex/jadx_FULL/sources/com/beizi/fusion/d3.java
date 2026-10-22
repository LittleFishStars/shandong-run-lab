package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.unified.BZUnifiedAdActionData;
import com.beizi.fusion.unified.BZUnifiedAdResponse;
import com.beizi.fusion.update.ShakeArcView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d3 extends d2 {
    private Context U;
    private gj V;
    private BZUnifiedAdResponse W;
    private ViewGroup X;
    private long Y;
    private boolean Z;
    private long a0;
    private int b0;
    private boolean c0;
    private boolean d0;
    private tn g0;
    private View k0;
    private boolean e0 = false;
    private boolean f0 = false;
    private String h0 = null;
    private boolean i0 = false;
    private int j0 = -1;

    public class a implements ij {
        public a() {
        }

        @Override // com.beizi.fusion.ij
        public void onAdClick() {
            Log.d("BeiZis", "showBZUnifiedAd onAdClicked()");
            d3.this.Z();
            d3.this.M0();
        }

        @Override // com.beizi.fusion.ij
        public void onAdFailed(int i) {
            Log.d("BeiZis", "showBZUnifiedAd onAdFailedToLoad:" + i);
            d3.this.a(String.valueOf(i), i);
        }

        @Override // com.beizi.fusion.ij
        public void onAdLoaded(BZUnifiedAdResponse bZUnifiedAdResponse) {
            if (bZUnifiedAdResponse == null) {
                Log.d("BeiZis", "showBZUnifiedAd onAdFailedToLoad splashUnifiedAdResponse is null:");
                d3.this.a(String.valueOf(3), 3);
                return;
            }
            Log.d("BeiZis", "showBZUnifiedAd onAdLoaded:" + System.currentTimeMillis());
            d3 d3Var = d3.this;
            d3Var.W = bZUnifiedAdResponse;
            d3Var.j = b2.ADLOAD;
            if (bZUnifiedAdResponse.getEcpm() != 0) {
                try {
                    d3.this.a(bZUnifiedAdResponse.getEcpm());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            d3 d3Var2 = d3.this;
            d3Var2.Z = d3Var2.V.u();
            d3 d3Var3 = d3.this;
            if (d3Var3.Z) {
                d3Var3.a0 = d3Var3.V.f();
                d3.this.b.setIsCacheAd("1");
                if (d3.this.a0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    d3 d3Var4 = d3.this;
                    d3Var4.b.setCacheTime(String.valueOf(jCurrentTimeMillis - d3Var4.a0));
                }
                d3.this.H0();
            }
            d3.this.f0();
            if (d3.this.V()) {
                d3.this.O0();
            } else {
                d3.this.A();
            }
        }

        @Override // com.beizi.fusion.ij
        public void onAdShown() {
            Log.d("BeiZis", "showBZUnifiedAd onAdShown()");
            d3.this.j = b2.ADSHOW;
            d3 d3Var = d3.this;
            if (d3Var.Z) {
                d3Var.b.setIsCacheAd("1");
                if (d3.this.a0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    d3 d3Var2 = d3.this;
                    d3Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - d3Var2.a0));
                }
                d3.this.H0();
            }
            if (d3.this.d != null) {
                if (d3.this.d.z() != 2) {
                    d3.this.d.d(d3.this.x());
                }
                d3.this.L0();
            }
            d3.this.i0();
            d3.this.y0();
            d3.this.d0();
            d3.this.N0();
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f27157a;

        public b(String[] strArr) {
            this.f27157a = strArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d3.this.V != null) {
                hj hjVar = new hj();
                hjVar.a(0);
                hjVar.c(this.f27157a[0]);
                hjVar.d(this.f27157a[1]);
                hjVar.a(this.f27157a[2]);
                hjVar.b(this.f27157a[3]);
                hjVar.g(this.f27157a[0]);
                hjVar.h(this.f27157a[1]);
                hjVar.e(this.f27157a[2]);
                hjVar.f(this.f27157a[3]);
                d3.this.a(0, hjVar);
            }
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f27158a;

        public c(String[] strArr) {
            this.f27158a = strArr;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f27158a[0] = String.valueOf(motionEvent.getX());
                    this.f27158a[1] = String.valueOf(motionEvent.getY());
                    this.f27158a[2] = String.valueOf(motionEvent.getRawX());
                    this.f27158a[3] = String.valueOf(motionEvent.getRawY());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public class d implements tn.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27159a;

        public d(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27159a = shakeViewBean;
        }

        @Override // com.beizi.fusion.tn.c
        public void a() {
            try {
                d3 d3Var = d3.this;
                if (d3Var.c0) {
                    return;
                }
                if (d3Var.i0 && this.f27159a.getCoolShakeView() != null) {
                    d3 d3Var2 = d3.this;
                    co.b(d3Var2.U, d3Var2.h0, Long.valueOf(System.currentTimeMillis()));
                }
                d3.this.b.setClickType("shake");
                d3.this.H0();
                hj hjVar = new hj();
                hjVar.a(2);
                d3.this.a(1, hjVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27160a;

        public e(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27160a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            d3 d3Var = d3.this;
            d3Var.i0 = true;
            d3Var.g0.a(this.f27160a);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27161a;

        public f(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27161a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            d3 d3Var = d3.this;
            d3Var.i0 = true;
            tn tnVar = d3Var.g0;
            if (tnVar != null) {
                tnVar.a(this.f27161a);
            }
        }
    }

    public d3(Context context, long j, int i, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var) {
        this.U = context;
        this.Y = j;
        this.b0 = i;
        this.e = buyerBean;
        this.f = forwardBean;
        this.d = m3Var;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void M0() {
        if (this.d0 || !this.e0 || this.f0) {
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
                if (buyerBean == null || this.X == null || (shakeView = buyerBean.getShakeView()) == null || shakeView.getPosition() == null) {
                    return;
                }
                if (this.g0 == null) {
                    this.g0 = new tn(this.U);
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
                gj gjVar = this.V;
                if (gjVar != null) {
                    this.g0.a(Boolean.valueOf(gjVar.s()));
                }
                View viewA = this.g0.a(so.b(this.U, this.X.getWidth()), so.b(this.U, this.X.getHeight()), shakeView.getPosition());
                this.k0 = viewA;
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        if (iC == 0) {
                            this.k0.setVisibility(4);
                        } else {
                            this.k0.setVisibility(0);
                        }
                        this.X.addView(this.k0, layoutParams2);
                    }
                }
                a(shakeView);
                b(shakeView2, shakeView);
                this.g0.a(new d(shakeView));
                a(shakeView2, shakeView, this.k0);
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
            this.d.a(x(), this.W);
            return;
        }
        if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    private void P0() {
        try {
            tn tnVar = this.g0;
            if (tnVar != null) {
                tnVar.q();
            }
            this.g0 = null;
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
        this.h0 = "splash_cool_" + this.i;
        jh.c("BeiZis", "AdWorker chanel = " + this.c);
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.e0 = true;
                for (int i = 0; i < callBackStrategy.size(); i++) {
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        this.f0 = ol.a(Integer.parseInt(callBackStrategyBean.getRate()));
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
        gj gjVar = this.V;
        if (gjVar == null) {
            return false;
        }
        return gjVar.v();
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
        gj gjVar = new gj(this.U, this.i, this.b0);
        this.V = gjVar;
        gjVar.a(new a());
        this.V.a((int) this.Y);
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
            gj gjVar = this.V;
            if (gjVar == null) {
                return;
            }
            gjVar.a(map);
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
            gj gjVar = this.V;
            if (gjVar == null) {
                return;
            }
            gjVar.b(map);
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
            gj gjVar = this.V;
            if (gjVar != null) {
                gjVar.a();
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
        gj gjVar = this.V;
        if (gjVar == null) {
            return null;
        }
        return gjVar.d();
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        if (this.W == null) {
            return null;
        }
        return this.W.getEcpm() + "";
    }

    @Override // com.beizi.fusion.d2
    public void b(int i) {
        gj gjVar = this.V;
        if (gjVar == null) {
            return;
        }
        gjVar.a(this.X, i);
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

    private void b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = shakeViewBean != null ? shakeViewBean : shakeViewBean2;
        int regulatoryAngle = shakeViewBean3.getRegulatoryAngle();
        tn tnVar = this.g0;
        if (tnVar != null) {
            tnVar.g(regulatoryAngle);
            f5 f5Var = this.E;
            if (f5Var != null) {
                this.g0.a(f5Var.b());
            }
        }
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeView = shakeViewBean2.getCoolShakeView();
        if (coolShakeView == null) {
            if (a(shakeViewBean, shakeViewBean2)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean3.getAliaseShakeView();
                if (aliaseShakeView != null) {
                    this.g0.a(aliaseShakeView);
                    new Handler().postDelayed(new e(shakeViewBean3), ol.b(aliaseShakeView.getPassivationTime()));
                    return;
                }
                return;
            }
            this.i0 = true;
            this.g0.a(shakeViewBean3);
            return;
        }
        if (b(coolShakeView.getCoolTime())) {
            this.j0 = coolShakeView.getFeedback();
            this.g0.a(coolShakeView);
            return;
        }
        if (c(coolShakeView.getUserProtectTime())) {
            this.j0 = coolShakeView.getFeedback();
            this.g0.a(coolShakeView);
        } else {
            if (a(shakeViewBean, shakeViewBean2)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean3.getAliaseShakeView();
                if (aliaseShakeView2 != null) {
                    this.g0.a(aliaseShakeView2);
                    new Handler().postDelayed(new f(shakeViewBean3), ol.b(aliaseShakeView2.getPassivationTime()));
                    return;
                }
                return;
            }
            this.i0 = true;
            this.g0.a(shakeViewBean3);
        }
    }

    @Override // com.beizi.fusion.d2
    public void a(ViewGroup viewGroup, List list) {
        this.X = viewGroup;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a((View) it.next());
            }
        }
        gj gjVar = this.V;
        if (gjVar == null) {
            return;
        }
        gjVar.a(this.X);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        String[] strArr = new String[4];
        view.setOnClickListener(new b(strArr));
        view.setOnTouchListener(new c(strArr));
    }

    @Override // com.beizi.fusion.d2
    public void a(BZUnifiedAdActionData bZUnifiedAdActionData) {
        try {
            if (this.V != null && this.X != null && bZUnifiedAdActionData != null) {
                hj hjVar = new hj();
                hjVar.a(bZUnifiedAdActionData.getType());
                int downX = bZUnifiedAdActionData.getDownX();
                int downY = bZUnifiedAdActionData.getDownY();
                int upX = bZUnifiedAdActionData.getUpX();
                int upY = bZUnifiedAdActionData.getUpY();
                int[] iArr = new int[2];
                this.X.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = downY + i2;
                hjVar.c(String.valueOf(downX));
                hjVar.d(String.valueOf(downY));
                hjVar.a(String.valueOf(downX + i));
                hjVar.b(String.valueOf(i3));
                hjVar.g(String.valueOf(upX));
                hjVar.h(String.valueOf(upY));
                hjVar.e(String.valueOf(i + upX));
                hjVar.f(String.valueOf(i2 + upY));
                a(0, hjVar);
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
        long jLongValue = ((Long) co.a(this.U, this.h0, (Object) 0L)).longValue();
        return jLongValue != 0 && System.currentTimeMillis() - jLongValue < j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, hj hjVar) {
        try {
            View view = this.k0;
            if (view != null) {
                view.setVisibility(4);
            }
            if (i == 0) {
                this.d0 = true;
            }
            this.c0 = true;
            this.V.a(this.X, hjVar);
        } catch (Exception e2) {
            e2.printStackTrace();
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
        if (this.j0 == -1) {
            this.j0 = shakeViewBean2.getFeedback();
            if (shakeViewBean != null) {
                this.j0 = shakeViewBean.getFeedback();
            }
        }
        if (this.j0 == 0 || view == null || this.g0 == null) {
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
            this.X.addView(shakeArcView, layoutParams2);
            this.g0.a(shakeArcView, this.j0);
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
        gj gjVar = this.V;
        Map mapR = gjVar != null ? gjVar.r() : null;
        tn tnVar = this.g0;
        if (tnVar == null) {
            return;
        }
        tnVar.a(sensorParam, compliantAngle, zIsReturnAngle, isUnidirection, mapR);
    }
}
