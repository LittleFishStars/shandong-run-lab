package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class x2 extends d2 implements a2 {
    private Context U;
    private String V;
    private long W;
    private long X;
    private gm Y;
    private AdSpacesBean.UniteControlBean a0;
    private int b0;
    private boolean e0;
    private long f0;
    private String g0;
    private String h0;
    protected String Z = null;
    private boolean c0 = false;
    private boolean d0 = false;

    public class a implements BeiZiInitCallBack {
        public a() {
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void fail(int i, String str) {
            x2.this.a(String.valueOf(10160), 10160);
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void success() {
            x2.this.O0();
        }
    }

    public x2(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, String str2, String str3, m3 m3Var) {
        this.U = context;
        this.V = str;
        this.W = j;
        this.X = j2;
        this.e = buyerBean;
        this.d = m3Var;
        this.f = forwardBean;
        this.g0 = str2;
        this.h0 = str3;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        se.a aVar = new se.a();
        aVar.a(j());
        aVar.b(this.W);
        String strT = t();
        if (!TextUtils.isEmpty(strT)) {
            aVar.b(strT);
        }
        Map mapI = i();
        if (mapI != null) {
            aVar.a(mapI);
        }
        gm gmVar = new gm(this.U, (se) aVar.a(this.i));
        this.Y = gmVar;
        gmVar.a((te) new b());
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
                this.c0 = true;
                for (int i = 0; i < callBackStrategy.size(); i++) {
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        this.d0 = ol.a(Integer.parseInt(callBackStrategyBean.getRate()));
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
        gm gmVar = this.Y;
        if (gmVar == null) {
            return false;
        }
        return gmVar.f();
    }

    @Override // com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        t2.a().a(this.U, this.h, new a());
    }

    public class b implements te {
        public b() {
        }

        @Override // com.beizi.fusion.te
        public void a() {
            if (x2.this.d != null) {
                x2.this.d.N();
            }
        }

        @Override // com.beizi.fusion.y9
        public void b() {
            Log.d("BeiZis", "showAsnpRewardedVideoAd onAdExposure()");
            x2.this.j = b2.ADSHOW;
            x2 x2Var = x2.this;
            if (x2Var.e0) {
                x2Var.b.setIsCacheAd("1");
                if (x2.this.f0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    x2 x2Var2 = x2.this;
                    x2Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - x2Var2.f0));
                }
                x2.this.H0();
            }
            if (x2.this.d != null && x2.this.d.z() != 2) {
                x2.this.d.d(x2.this.x());
                x2.this.L0();
            }
            x2.this.i0();
            x2.this.y0();
            x2.this.d0();
        }

        @Override // com.beizi.fusion.te
        public void c() {
            Log.d("BeiZis", "showAsnpRewardedVideoAd onReward()");
            x2.this.h0();
            if (x2.this.d != null) {
                x2.this.d.M();
            }
        }

        @Override // com.beizi.fusion.te
        public void d() {
            if (x2.this.d != null) {
                x2.this.d.P();
            }
        }

        @Override // com.beizi.fusion.y9
        public void e() {
            Log.d("BeiZis", "showAsnpRewardedVideoAd onAdLoaded()");
            x2.this.j = b2.ADLOAD;
            try {
                x2 x2Var = x2.this;
                gm gmVar = x2Var.Y;
                if (gmVar != null) {
                    x2Var.a(gmVar.getECPM());
                    x2 x2Var2 = x2.this;
                    x2Var2.e(x2Var2.Y.c());
                }
            } catch (Exception unused) {
            }
            x2.this.f0();
            if (x2.this.V()) {
                x2.this.N0();
            } else {
                x2.this.A();
            }
        }

        @Override // com.beizi.fusion.te
        public void f() {
            if (x2.this.d != null) {
                x2.this.d.O();
            }
        }

        @Override // com.beizi.fusion.y9
        public void onAdClicked() {
            Log.d("BeiZis", "showAsnpRewardedVideoAd onAdClick()");
            x2 x2Var = x2.this;
            if (x2Var.c0 && x2Var.e != null) {
                x2.this.b.setCallBackStrategyUuid(x2.this.e.getCallBackStrategyUuid());
                x2.this.H0();
            }
            x2.this.Z();
            x2 x2Var2 = x2.this;
            if (!x2Var2.c0 || x2Var2.d0) {
                if (x2Var2.d != null && x2.this.d.z() != 2) {
                    x2.this.d.b(x2.this.x());
                }
                x2.this.Y();
                x2.this.I0();
            }
        }

        @Override // com.beizi.fusion.y9
        public void onAdClosed() {
            Log.d("BeiZis", "showAsnpRewardedVideoAd onAdClosed()");
            if (x2.this.d != null && x2.this.d.z() != 2) {
                x2.this.d.c(x2.this.x());
            }
            x2.this.b0();
        }

        @Override // com.beizi.fusion.y9
        public void onAdLoaded() {
        }

        @Override // com.beizi.fusion.y9
        public void onAdShown() {
            Log.d("BeiZis", "showAsnpRewardedVideoAd onAdShown()");
        }

        @Override // com.beizi.fusion.ea
        public void a(int i, String str) {
            Log.d("BeiZis", "showAsnpRewardedVideoAd onAdFailedToLoad: " + i);
            x2.this.a(str, i);
        }
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        String str;
        String str2;
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        try {
            if (this.Y == null) {
                return;
            }
            String str3 = null;
            if (map.containsKey("winPrice") && (obj3 = map.get("winPrice")) != null && (obj3 instanceof String)) {
                str = (String) obj3;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setWinPrice(str);
                }
            } else {
                str = null;
            }
            if (map.containsKey("adnId") && (obj2 = map.get("adnId")) != null && (obj2 instanceof String)) {
                str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setAdnId(str2);
                }
            } else {
                str2 = null;
            }
            if (map.containsKey("lossReason") && (obj = map.get("lossReason")) != null && (obj instanceof String)) {
                str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setLossReason(str3);
                }
            }
            if (TextUtils.isEmpty(str)) {
                i = 0;
            } else {
                try {
                    i = Integer.parseInt(str);
                } catch (Exception unused) {
                    i = 0;
                }
            }
            this.Y.b(mb.a.a(i, -1, str2, str3, -1));
            H0();
            r0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        String str;
        String str2;
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            gm gmVar = this.Y;
            if (gmVar == null) {
                return;
            }
            int ecpm = gmVar.getECPM();
            if (map.containsKey("winPrice") && (obj4 = map.get("winPrice")) != null && (obj4 instanceof String)) {
                String str3 = (String) obj4;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setWinPrice(str3);
                }
            }
            String str4 = null;
            if (map.containsKey("adnId") && (obj3 = map.get("adnId")) != null && (obj3 instanceof String)) {
                str = (String) obj3;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setAdnId(str);
                }
            } else {
                str = null;
            }
            if (map.containsKey("highestLossPrice") && (obj2 = map.get("highestLossPrice")) != null && (obj2 instanceof String)) {
                str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setHighestLossPrice(str2);
                }
            } else {
                str2 = null;
            }
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null && (obj instanceof String)) {
                str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    this.b.setSecondPrice(str4);
                }
            }
            try {
                i = !TextUtils.isEmpty(str2) ? Integer.parseInt(str2) : 0;
            } catch (Exception unused) {
            }
            Map mapA = mb.a.a(ecpm, i, str, -1);
            if (mapA != null && !TextUtils.isEmpty(str4)) {
                mapA.put("auctionPrice", str4);
            }
            this.Y.a(mapA);
            H0();
            s0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void g() {
        gm gmVar = this.Y;
        if (gmVar != null) {
            gmVar.d();
        }
        this.U = null;
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
        gm gmVar = this.Y;
        if (gmVar == null) {
            return null;
        }
        return a(gmVar.e());
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        gm gmVar = this.Y;
        if (gmVar == null) {
            return null;
        }
        return b(gmVar.e());
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        gm gmVar = this.Y;
        if (gmVar == null) {
            return null;
        }
        return String.valueOf(gmVar.getECPM());
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.Y == null) {
            return;
        }
        F0();
    }

    @Override // com.beizi.fusion.d2
    public void a(Activity activity) {
        Log.d("BeiZis", x() + " out make show ad");
        try {
            if (!M0()) {
                a(String.valueOf(10170), 10170);
                return;
            }
            gm gmVar = this.Y;
            if (gmVar == null || !gmVar.f()) {
                return;
            }
            this.Y.b(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
