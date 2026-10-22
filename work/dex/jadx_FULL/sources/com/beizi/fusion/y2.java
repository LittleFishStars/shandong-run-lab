package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class y2 extends d2 implements a2 {
    private Context U;
    private String V;
    private long W;
    private long X;
    private eo Y;
    private AdSpacesBean.UniteControlBean a0;
    private int b0;
    private boolean e0;
    private long f0;
    private ViewGroup g0;
    private int h0;
    private int i0;
    protected String Z = null;
    private boolean c0 = false;
    private boolean d0 = false;

    public class a implements BeiZiInitCallBack {
        public a() {
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void fail(int i, String str) {
            y2.this.a(String.valueOf(10160), 10160);
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void success() {
            y2.this.O0();
        }
    }

    public class b implements y9 {
        public b() {
        }

        @Override // com.beizi.fusion.ea
        public void a(int i, String str) {
            Log.d("BeiZis", "showAsnpSplashAd onAdFailedToLoad: " + i);
            try {
                y2 y2Var = y2.this;
                eo eoVar = y2Var.Y;
                if (eoVar != null) {
                    y2Var.e(eoVar.c());
                }
            } catch (Exception unused) {
            }
            y2.this.a(str, i);
        }

        @Override // com.beizi.fusion.y9
        public void b() {
            Log.d("BeiZis", "showAsnpSplashAd onAdShown()");
            y2.this.j = b2.ADSHOW;
            y2 y2Var = y2.this;
            if (y2Var.e0) {
                y2Var.b.setIsCacheAd("1");
                if (y2.this.f0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    y2 y2Var2 = y2.this;
                    y2Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - y2Var2.f0));
                }
                y2.this.H0();
            }
            if (y2.this.d != null && y2.this.d.z() != 2) {
                y2.this.d.d(y2.this.x());
                y2.this.L0();
            }
            y2.this.i0();
            y2.this.y0();
            y2.this.d0();
        }

        @Override // com.beizi.fusion.y9
        public void e() {
            Log.d("BeiZis", "showAsnpSplashAd onRenderSuccess()");
            y2.this.j = b2.ADLOAD;
            try {
                y2 y2Var = y2.this;
                eo eoVar = y2Var.Y;
                if (eoVar != null) {
                    y2Var.a(eoVar.getECPM());
                    y2 y2Var2 = y2.this;
                    y2Var2.e(y2Var2.Y.c());
                }
            } catch (Exception unused) {
            }
            y2.this.f0();
            if (y2.this.V()) {
                y2.this.N0();
            } else {
                y2.this.A();
            }
        }

        @Override // com.beizi.fusion.y9
        public void onAdClicked() {
            Log.d("BeiZis", "showAsnpSplashAd onAdClick()");
            y2 y2Var = y2.this;
            if (y2Var.c0 && y2Var.e != null) {
                y2.this.b.setCallBackStrategyUuid(y2.this.e.getCallBackStrategyUuid());
                y2.this.H0();
            }
            y2.this.Z();
            y2 y2Var2 = y2.this;
            if (!y2Var2.c0 || y2Var2.d0) {
                if (y2Var2.d != null && y2.this.d.z() != 2) {
                    y2.this.d.b(y2.this.x());
                }
                y2.this.Y();
                y2.this.I0();
            }
        }

        @Override // com.beizi.fusion.y9
        public void onAdClosed() {
            Log.d("BeiZis", "showAsnpSplashAd onAdClosed()");
            if (y2.this.d != null && y2.this.d.z() != 2) {
                y2.this.d.c(y2.this.x());
            }
            y2.this.b0();
        }

        @Override // com.beizi.fusion.y9
        public void onAdLoaded() {
            Log.d("BeiZis", "showAsnpSplashAd onAdLoaded()");
        }

        @Override // com.beizi.fusion.y9
        public void onAdShown() {
        }
    }

    public y2(Context context, String str, long j, long j2, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, int i, int i2, m3 m3Var) {
        this.U = context;
        this.V = str;
        this.g0 = viewGroup;
        this.W = j;
        this.X = j2;
        this.e = buyerBean;
        this.d = m3Var;
        this.f = forwardBean;
        this.h0 = i;
        this.i0 = i2;
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
        xe.a aVar = new xe.a();
        aVar.a(j());
        aVar.b(this.W);
        int i = this.h0;
        int iA = i > 0 ? so.a(this.U, i) : 0;
        int i2 = this.i0;
        aVar.b(iA, i2 > 0 ? so.a(this.U, i2) : 0);
        String strT = t();
        if (!TextUtils.isEmpty(strT)) {
            aVar.b(strT);
        }
        Map mapI = i();
        if (mapI != null) {
            aVar.a(mapI);
        }
        eo eoVar = new eo(this.U, (xe) aVar.a(this.i));
        this.Y = eoVar;
        eoVar.a((y9) new b());
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
        Log.d("BeiZis", x() + " out make show ad");
        try {
            eo eoVar = this.Y;
            if (eoVar != null) {
                eoVar.d(this.g0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public boolean R() {
        eo eoVar = this.Y;
        if (eoVar == null) {
            return false;
        }
        return eoVar.f();
    }

    @Override // com.beizi.fusion.d2
    public void a(Activity activity) {
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
        } catch (Exception unused2) {
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
            eo eoVar = this.Y;
            if (eoVar == null) {
                return;
            }
            int ecpm = eoVar.getECPM();
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
        eo eoVar = this.Y;
        if (eoVar != null) {
            eoVar.d();
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
        eo eoVar = this.Y;
        if (eoVar == null) {
            return null;
        }
        return a(eoVar.e());
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        eo eoVar = this.Y;
        if (eoVar == null) {
            return null;
        }
        return b(eoVar.e());
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        eo eoVar = this.Y;
        if (eoVar == null) {
            return null;
        }
        return String.valueOf(eoVar.getECPM());
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.Y == null) {
            return;
        }
        F0();
    }

    @Override // com.beizi.fusion.d2
    public void a(ViewGroup viewGroup) {
        Log.d("BeiZis", x() + " out make show ad");
        try {
            if (!M0()) {
                a(String.valueOf(10170), 10170);
                return;
            }
            eo eoVar = this.Y;
            if (eoVar != null) {
                eoVar.d(viewGroup);
            }
        } catch (Throwable unused) {
        }
    }
}
