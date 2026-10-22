package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.fusion.asnp.adn.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class v2 extends d2 implements a2 {
    private Context U;
    private String V;
    private long W;
    private long X;
    private hp Y;
    private AdSpacesBean.UniteControlBean a0;
    private int b0;
    private boolean e0;
    private long f0;
    private ze g0;
    private NativeUnifiedAdResponse h0;
    protected FrameLayout i0;
    protected String Z = null;
    private boolean c0 = false;
    private boolean d0 = false;

    public class a implements BeiZiInitCallBack {
        public a() {
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void fail(int i, String str) {
            v2.this.a(String.valueOf(10160), 10160);
        }

        @Override // com.beizi.fusion.BeiZiInitCallBack
        public void success() {
            v2.this.O0();
        }
    }

    public class c implements NativeUnifiedAdResponse {

        public class a implements sd {
            public a() {
            }

            @Override // com.beizi.fusion.sd
            public void b() {
                Log.d("BeiZis", "showAsnpNativeUnifiedAd onAdShown()");
                v2.this.j = b2.ADSHOW;
                v2 v2Var = v2.this;
                if (v2Var.e0) {
                    v2Var.b.setIsCacheAd("1");
                    if (v2.this.f0 > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        v2 v2Var2 = v2.this;
                        v2Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - v2Var2.f0));
                    }
                    v2.this.H0();
                }
                if (v2.this.d != null && v2.this.d.z() != 2) {
                    v2.this.d.d(v2.this.x());
                    v2.this.L0();
                }
                v2.this.i0();
                v2.this.y0();
                v2.this.d0();
            }

            @Override // com.beizi.fusion.sd
            public void onAdClosed() {
                Log.d("BeiZis", "showAsnpNativeUnifiedAd onAdClosed()");
                if (v2.this.d != null && v2.this.d.z() != 2) {
                    v2.this.d.a(v2.this.x(), v2.this.i0);
                }
                v2.this.b0();
            }

            @Override // com.beizi.fusion.sd
            public void onAdShown() {
            }
        }

        public class b implements td {
            public b() {
            }

            @Override // com.beizi.fusion.td
            public void onAdClicked() {
                Log.d("BeiZis", "showAsnpNativeUnifiedAd onAdClick()");
                v2 v2Var = v2.this;
                if (v2Var.c0 && v2Var.e != null) {
                    v2.this.b.setCallBackStrategyUuid(v2.this.e.getCallBackStrategyUuid());
                    v2.this.H0();
                }
                v2.this.Z();
                v2 v2Var2 = v2.this;
                if (!v2Var2.c0 || v2Var2.d0) {
                    if (v2Var2.d != null && v2.this.d.z() != 2) {
                        v2.this.d.b(v2.this.x());
                    }
                    v2.this.Y();
                    v2.this.I0();
                }
            }
        }

        public c() {
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getActionText() {
            ze zeVar = v2.this.g0;
            if (zeVar != null) {
                return zeVar.g();
            }
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getAdLogoUrl() {
            ze zeVar = v2.this.g0;
            if (zeVar != null) {
                return zeVar.getAdLogoUrl();
            }
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getDescription() {
            ze zeVar = v2.this.g0;
            if (zeVar != null) {
                return zeVar.getDesc();
            }
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public UnifiedAdDownloadAppInfo getDownloadAppInfo() {
            bf bfVarD;
            try {
                ze zeVar = v2.this.g0;
                if (zeVar == null || (bfVarD = zeVar.d()) == null) {
                    return null;
                }
                UnifiedAdDownloadAppInfo unifiedAdDownloadAppInfo = new UnifiedAdDownloadAppInfo();
                unifiedAdDownloadAppInfo.setAppName(bfVarD.getName());
                unifiedAdDownloadAppInfo.setAppVersion(bfVarD.c());
                unifiedAdDownloadAppInfo.setAppDeveloper(bfVarD.e());
                String strB = bfVarD.b();
                if (TextUtils.isEmpty(strB)) {
                    List<bf.a> listA = bfVarD.a();
                    if (listA != null && !listA.isEmpty()) {
                        HashMap map = new HashMap();
                        for (bf.a aVar : listA) {
                            if (aVar != null) {
                                map.put(aVar.getTitle(), aVar.a());
                            }
                        }
                        unifiedAdDownloadAppInfo.setAppPermission(map.toString());
                    }
                } else {
                    unifiedAdDownloadAppInfo.setAppPermission(strB);
                }
                String strF = bfVarD.f();
                if (!TextUtils.isEmpty(strF)) {
                    unifiedAdDownloadAppInfo.setAppPrivacy(strF);
                }
                unifiedAdDownloadAppInfo.setAppIntro(bfVarD.d());
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public int getECPM() {
            String strS = v2.this.s();
            if (strS == null) {
                return -1;
            }
            try {
                return Integer.parseInt(strS);
            } catch (Exception unused) {
                return -1;
            }
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getIconUrl() {
            ze zeVar = v2.this.g0;
            if (zeVar != null) {
                return zeVar.getIconUrl();
            }
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getImageUrl() {
            ze zeVar = v2.this.g0;
            if (zeVar != null) {
                return zeVar.h();
            }
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public List getImgList() {
            ze zeVar = v2.this.g0;
            if (zeVar != null) {
                return zeVar.c();
            }
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public int getMaterialType() {
            ze zeVar = v2.this.g0;
            if (zeVar == null) {
                return 0;
            }
            int iOrdinal = zeVar.i().ordinal();
            return (iOrdinal == 0 || iOrdinal == 1) ? 1 : 0;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getTitle() {
            ze zeVar = v2.this.g0;
            if (zeVar != null) {
                return zeVar.getTitle();
            }
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public View getVideoView() {
            return null;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public ViewGroup getViewContainer() {
            return v2.this.i0;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public boolean isVideo() {
            return false;
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public void registerDownloadAppInfoClickEvent(View view) {
            v2.this.a(view);
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public void registerViewForInteraction(List list) {
            try {
                v2 v2Var = v2.this;
                Context context = v2Var.U;
                if (context != null && v2Var.i0 != null && v2Var.g0 != null && (context instanceof Activity)) {
                    ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer = new ASNPUnifiedExpressContainer(v2.this.U);
                    v2 v2Var2 = v2.this;
                    v2Var2.a(v2Var2.i0, aSNPUnifiedExpressContainer);
                    v2.this.g0.a(new a());
                    v2.this.g0.a(new b());
                    v2 v2Var3 = v2.this;
                    v2Var3.g0.a((Activity) v2Var3.U, aSNPUnifiedExpressContainer, list);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ze zeVar;
            bf bfVarD;
            try {
                v2 v2Var = v2.this;
                if (v2Var.U == null || (zeVar = v2Var.g0) == null || (bfVarD = zeVar.d()) == null) {
                    return;
                }
                String name = bfVarD.getName();
                String string = "";
                String strB = bfVarD.b();
                if (TextUtils.isEmpty(strB)) {
                    List<bf.a> listA = bfVarD.a();
                    if (listA != null && !listA.isEmpty()) {
                        HashMap map = new HashMap();
                        for (bf.a aVar : listA) {
                            if (aVar != null) {
                                map.put(aVar.getTitle(), aVar.a());
                            }
                        }
                        string = map.toString();
                    }
                } else {
                    string = strB;
                }
                String strF = bfVarD.f();
                String strD = bfVarD.d();
                Intent intent = new Intent(v2.this.U, (Class<?>) DownloadAppInfoActivity.class);
                intent.putExtra("title_content_key", name);
                intent.putExtra("privacy_content_key", strF);
                intent.putExtra("permission_content_key", string);
                intent.putExtra("intro_content_key", strD);
                intent.setFlags(268435456);
                v2.this.U.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public v2(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var) {
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
            P0();
            this.d.b(x(), (View) null);
        } else if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        ye.a aVar = new ye.a();
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
        hp hpVar = new hp(this.U, (ye) aVar.a(this.i));
        this.Y = hpVar;
        hpVar.a((af) new b());
    }

    private void P0() {
        try {
            this.i0 = new FrameLayout(this.U);
            this.h0 = new c();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
        ze zeVar = this.g0;
        if (zeVar == null) {
            return false;
        }
        return zeVar.j();
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
        ze zeVar = this.g0;
        if (zeVar != null) {
            zeVar.b();
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
        ze zeVar = this.g0;
        if (zeVar == null) {
            return null;
        }
        return a(zeVar.e());
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        ze zeVar = this.g0;
        if (zeVar == null) {
            return null;
        }
        return b(zeVar.e());
    }

    @Override // com.beizi.fusion.d2
    public NativeUnifiedAdResponse q() {
        return this.h0;
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        mb mbVarF;
        ze zeVar = this.g0;
        if (zeVar == null || (mbVarF = zeVar.f()) == null) {
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
            ze zeVar = this.g0;
            if (zeVar != null && (mbVarF = zeVar.f()) != null) {
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
            ze zeVar = this.g0;
            int i = 0;
            String str3 = null;
            if (zeVar != null) {
                mbVarF = zeVar.f();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setOnClickListener(new d());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout, ViewGroup viewGroup) {
        if (frameLayout == null || viewGroup == null) {
            return;
        }
        try {
            int childCount = frameLayout.getChildCount();
            if (childCount <= 0) {
                return;
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = frameLayout.getChildAt(i);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                frameLayout.removeView(childAt);
                viewGroup.addView(childAt, layoutParams);
            }
            frameLayout.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class b implements af {
        public b() {
        }

        @Override // com.beizi.fusion.af
        public void a(List list) {
            Log.d("BeiZis", "showAsnpNativeUnifiedAd onAdLoaded()");
            v2.this.j = b2.ADLOAD;
            if (list == null || list.isEmpty()) {
                v2.this.a("3", 3);
                return;
            }
            v2.this.g0 = (ze) list.get(0);
            v2 v2Var = v2.this;
            ze zeVar = v2Var.g0;
            if (zeVar == null) {
                v2Var.a("3", 3);
                return;
            }
            try {
                mb mbVarF = zeVar.f();
                if (mbVarF != null) {
                    v2.this.a(mbVarF.getECPM());
                }
                v2 v2Var2 = v2.this;
                hp hpVar = v2Var2.Y;
                if (hpVar != null) {
                    v2Var2.e(hpVar.c());
                }
            } catch (Exception unused) {
            }
            v2.this.f0();
            if (v2.this.V()) {
                v2.this.N0();
            } else {
                v2.this.A();
            }
        }

        @Override // com.beizi.fusion.ea
        public void a(int i, String str) {
            Log.d("BeiZis", "showAsnpNativeUnifiedAd onAdFailedToLoad: " + i);
            try {
                v2 v2Var = v2.this;
                hp hpVar = v2Var.Y;
                if (hpVar != null) {
                    v2Var.e(hpVar.c());
                }
            } catch (Exception unused) {
            }
            v2.this.a(str, i);
        }
    }
}
