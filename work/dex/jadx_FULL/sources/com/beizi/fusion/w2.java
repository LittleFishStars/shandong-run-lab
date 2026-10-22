package com.beizi.fusion;

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
public class w2 extends d2 implements a2 {
    private Context U;
    private String V;
    private long W;
    private long X;
    private hi Y;
    private AdSpacesBean.UniteControlBean a0;
    private int b0;
    private boolean e0;
    private long f0;
    private pd g0;
    private float h0;
    private float i0;
    protected String Z = null;
    private boolean c0 = false;
    private boolean d0 = false;

    public class a implements BeiZiInitCallBack {
        public a() {
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void fail(int i, String str) {
            w2.this.a(String.valueOf(10160), 10160);
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void success() {
            w2.this.O0();
        }
    }

    public class c implements td {
        public c() {
        }

        @Override // com.beizi.fusion.td
        public void onAdClicked() {
            Log.d("BeiZis", "showAsnpNativeAd onAdClick()");
            w2 w2Var = w2.this;
            if (w2Var.c0 && w2Var.e != null) {
                w2.this.b.setCallBackStrategyUuid(w2.this.e.getCallBackStrategyUuid());
                w2.this.H0();
            }
            w2.this.Z();
            w2 w2Var2 = w2.this;
            if (!w2Var2.c0 || w2Var2.d0) {
                if (w2Var2.d != null && w2.this.d.z() != 2) {
                    w2.this.d.b(w2.this.x());
                }
                w2.this.Y();
                w2.this.I0();
            }
        }
    }

    public class d implements sd {
        public d() {
        }

        @Override // com.beizi.fusion.sd
        public void b() {
            Log.d("BeiZis", "showAsnpNativeAd onAdShown()");
            w2.this.j = b2.ADSHOW;
            w2 w2Var = w2.this;
            if (w2Var.e0) {
                w2Var.b.setIsCacheAd("1");
                if (w2.this.f0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    w2 w2Var2 = w2.this;
                    w2Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - w2Var2.f0));
                }
                w2.this.H0();
            }
            if (w2.this.d != null && w2.this.d.z() != 2) {
                w2.this.d.d(w2.this.x());
                w2.this.L0();
            }
            w2.this.i0();
            w2.this.y0();
            w2.this.d0();
        }

        @Override // com.beizi.fusion.sd
        public void onAdClosed() {
            Log.d("BeiZis", "showAsnpNativeAd onAdClosed()");
            if (w2.this.d != null && w2.this.d.z() != 2) {
                w2.this.d.a(w2.this.x(), w2.this.r());
            }
            w2.this.b0();
        }

        @Override // com.beizi.fusion.sd
        public void onAdShown() {
        }
    }

    public class e implements ud {
        public e() {
        }

        @Override // com.beizi.fusion.ud
        public void a(View view) {
            Log.d("BeiZis", "showAsnpNativeAd renderSuccess()");
            w2.this.d.b(w2.this.x(), view);
        }

        @Override // com.beizi.fusion.ud
        public void f() {
            Log.d("BeiZis", "showAsnpNativeAd renderFailed()");
            w2.this.d.a(10190);
        }
    }

    public w2(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, float f, float f2, m3 m3Var) {
        this.U = context;
        this.V = str;
        this.W = j;
        this.X = j2;
        this.e = buyerBean;
        this.d = m3Var;
        this.f = forwardBean;
        this.h0 = f;
        this.i0 = f2;
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
        } catch (Exception e2) {
            e2.printStackTrace();
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
            this.g0.a(new c());
            this.g0.a(new d());
            this.g0.a(new e());
        } else if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        od.a aVar = new od.a();
        aVar.b(this.W);
        float f = this.h0;
        int iA = f > 0.0f ? so.a(this.U, f) : 0;
        float f2 = this.i0;
        aVar.b(iA, f2 > 0.0f ? so.a(this.U, f2) : 0);
        String strT = t();
        if (!TextUtils.isEmpty(strT)) {
            aVar.b(strT);
        }
        Map mapI = i();
        if (mapI != null) {
            aVar.a(mapI);
        }
        aVar.a(j());
        hi hiVar = new hi(this.U, (od) aVar.a(this.i));
        this.Y = hiVar;
        hiVar.a((qd) new b());
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
            if (callBackStrategy != null && !callBackStrategy.isEmpty()) {
                this.c0 = true;
                for (int i = 0; i < callBackStrategy.size(); i++) {
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        this.d0 = ol.a(Integer.parseInt(callBackStrategyBean.getRate()));
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
        pd pdVar = this.g0;
        if (pdVar == null) {
            return false;
        }
        return pdVar.j();
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
    public void g() {
        pd pdVar = this.g0;
        if (pdVar != null) {
            pdVar.b();
            this.g0 = null;
        }
        this.Y = null;
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
        pd pdVar = this.g0;
        if (pdVar == null) {
            return null;
        }
        return a(pdVar.e());
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        pd pdVar = this.g0;
        if (pdVar == null) {
            return null;
        }
        return b(pdVar.e());
    }

    @Override // com.beizi.fusion.d2
    public View r() {
        pd pdVar = this.g0;
        if (pdVar != null) {
            return pdVar.a();
        }
        return null;
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        mb mbVarF;
        pd pdVar = this.g0;
        if (pdVar == null || (mbVarF = pdVar.f()) == null) {
            return null;
        }
        return String.valueOf(mbVarF.getECPM());
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.Y == null) {
            return;
        }
        F0();
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        String str;
        String str2;
        int i;
        mb mbVarF;
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
            Map mapA = mb.a.a(i, -1, str2, str3, -1);
            pd pdVar = this.g0;
            if (pdVar != null && (mbVarF = pdVar.f()) != null) {
                mbVarF.b(mapA);
            }
            H0();
            r0();
        } catch (Exception unused2) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        int ecpm;
        mb mbVarF;
        String str;
        String str2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            if (this.Y == null) {
                return;
            }
            pd pdVar = this.g0;
            int i = 0;
            String str3 = null;
            if (pdVar != null) {
                mbVarF = pdVar.f();
                ecpm = mbVarF != null ? mbVarF.getECPM() : 0;
            } else {
                ecpm = 0;
                mbVarF = null;
            }
            if (map.containsKey("winPrice") && (obj4 = map.get("winPrice")) != null && (obj4 instanceof String)) {
                String str4 = (String) obj4;
                if (!TextUtils.isEmpty(str4)) {
                    this.b.setWinPrice(str4);
                }
            }
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
                str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setSecondPrice(str3);
                }
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    i = Integer.parseInt(str2);
                }
            } catch (Exception unused) {
            }
            Map mapA = mb.a.a(ecpm, i, str, -1);
            if (mapA != null && !TextUtils.isEmpty(str3)) {
                mapA.put("auctionPrice", str3);
            }
            if (mbVarF != null) {
                mbVarF.a(mapA);
            }
            H0();
            s0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class b implements qd {
        public b() {
        }

        @Override // com.beizi.fusion.qd
        public void a(List list) {
            Log.d("BeiZis", "showAsnpNativeAd onAdLoaded()");
            w2.this.j = b2.ADLOAD;
            if (list == null || list.isEmpty()) {
                w2.this.a("3", 3);
                return;
            }
            w2.this.g0 = (pd) list.get(0);
            w2 w2Var = w2.this;
            pd pdVar = w2Var.g0;
            if (pdVar == null) {
                w2Var.a("3", 3);
                return;
            }
            try {
                mb mbVarF = pdVar.f();
                if (mbVarF != null) {
                    w2.this.a(mbVarF.getECPM());
                }
                w2 w2Var2 = w2.this;
                hi hiVar = w2Var2.Y;
                if (hiVar != null) {
                    w2Var2.e(hiVar.c());
                }
            } catch (Exception unused) {
            }
            w2.this.f0();
            if (w2.this.V()) {
                w2.this.N0();
            } else {
                w2.this.A();
            }
        }

        @Override // com.beizi.fusion.ea
        public void a(int i, String str) {
            Log.d("BeiZis", "showAsnpNativeAd onAdFailedToLoad: " + i);
            try {
                w2 w2Var = w2.this;
                hi hiVar = w2Var.Y;
                if (hiVar != null) {
                    w2Var.e(hiVar.c());
                }
            } catch (Exception unused) {
            }
            w2.this.a(str, i);
        }
    }
}
