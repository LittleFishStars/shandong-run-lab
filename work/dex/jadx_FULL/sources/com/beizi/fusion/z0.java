package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid.BiddingModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.ImageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.VideoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.land.LandingOptimizeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.ReportModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class z0 implements ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f28077a;
    protected final AdItemModel b;
    protected final ba c;
    protected final AdTraceModel d;
    protected final q9 g;
    private final q0 h;
    private final BiddingModel3 j;
    private ec k;
    private ad l;
    private ef m;
    private wd n;
    protected t9 o;
    private s9 p;
    private qi q;
    private sg r;
    private final kb s;
    private e t;
    protected c3 u;
    protected final dd e = new d();
    protected final x9 f = m();
    private final b i = new b();

    public class a implements x9 {
        private w9 b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f28078a = false;
        private final s9.a c = new C0337a();

        /* JADX INFO: renamed from: com.beizi.fusion.z0$a$a, reason: collision with other inner class name */
        public class C0337a implements s9.a {
            public C0337a() {
            }

            @Override // com.beizi.fusion.s9.a
            public void a() {
                if (!z0.this.d.isCallbackExposure()) {
                    z0 z0Var = z0.this;
                    if (z0Var.k != null) {
                        z0Var.d.setCallbackExposure();
                        z0.this.k.b();
                    }
                }
                ad adVar = z0.this.l;
                if (adVar != null) {
                    adVar.onAdClicked();
                }
            }

            @Override // com.beizi.fusion.s9.a
            public void b() {
            }
        }

        public a() {
        }

        @Override // com.beizi.fusion.x9
        public void d(xa xaVar) {
            View viewA = z0.this.a();
            if (viewA instanceof ScopeExpressContainer) {
                ((ScopeExpressContainer) viewA).removeFromParent();
            }
            ec ecVar = z0.this.k;
            if (ecVar != null) {
                ecVar.onAdClosed();
                if (z0.this.b.isIndependentAd()) {
                    z0 z0Var = z0.this;
                    z0Var.g.a(u7.EVENT_REPORT_CLOSE_CODE, z0Var.d);
                }
            }
        }

        @Override // com.beizi.fusion.x9
        public void f(xa xaVar) {
            String strA;
            z0 z0Var = z0.this;
            t5.a(z0Var.f28077a, z0Var.c, System.currentTimeMillis());
            View viewA = z0.this.a();
            if (viewA instanceof ScopeExpressContainer) {
                strA = ScopeExpressContainer.d.a((ScopeExpressContainer) viewA);
                z0.this.d.setComplain(strA);
            } else {
                strA = "";
            }
            z0 z0Var2 = z0.this;
            z0Var2.g.a(u7.EVENT_REPORT_COMPLAIN_CODE, z0Var2.d);
            wd wdVar = z0.this.n;
            if (wdVar != null) {
                wdVar.a(strA);
            }
            d(x9.a.AD_CLOSE);
        }

        @Override // com.beizi.fusion.ya
        public void a(w9 w9Var) {
            this.b = w9Var;
        }

        @Override // com.beizi.fusion.x9
        public void a(xa xaVar, View view) {
            z0 z0Var = z0.this;
            q9 q9Var = z0Var.g;
            u7 u7Var = u7.EVENT_REPORT_CLICK_CODE;
            q9Var.a(u7Var, z0Var.d);
            w9 w9Var = this.b;
            if (w9Var instanceof cc) {
                ((cc) w9Var).a(z0.this.d.m165deepCopy());
            }
            z0 z0Var2 = z0.this;
            s9 s9Var = z0Var2.p;
            if (s9Var != null) {
                s9Var.a(xaVar, view, z0Var2.d, this.c);
                if (!this.f28078a) {
                    this.f28078a = true;
                    z0 z0Var3 = z0.this;
                    z0Var3.h.a(z0Var3.c.g(), u7Var);
                    z0 z0Var4 = z0.this;
                    z0Var4.g.a(u7.EVENT_REPORT_CALL_CLICK_CODE, z0Var4.d);
                }
            }
            if (z0.this.c.b() == com.beizi.fusion.d.SPLASH) {
                d(x9.a.AD_CLOSE);
            }
        }

        @Override // com.beizi.fusion.x9
        public void a(x9.a aVar) {
            if (x9.a.AD_CLOSE == aVar) {
                if (z0.this.b.isIndependentAd()) {
                    z0 z0Var = z0.this;
                    z0Var.o.a(aVar, z0Var.d, z0Var.n());
                    return;
                }
                return;
            }
            z0 z0Var2 = z0.this;
            z0Var2.o.a(aVar, z0Var2.d, z0Var2.n());
        }
    }

    public class b implements mb {
        private b() {
        }

        @Override // com.beizi.fusion.mb
        public void a(Map map) {
            z0.this.b(map);
        }

        @Override // com.beizi.fusion.mb
        public void b(Map map) {
            z0.this.a(map);
        }

        @Override // com.beizi.fusion.mb
        public int getECPM() {
            return z0.this.o();
        }
    }

    public class c implements gc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f28081a = false;
        private boolean b = false;
        private final s9.a c = new a();

        public class a implements s9.a {
            public a() {
            }

            @Override // com.beizi.fusion.s9.a
            public void a() {
                z0 z0Var = z0.this;
                z0Var.g.a(u7.EVENT_REPORT_CALL_EXPOSURE_CODE, z0Var.d);
                z0.this.d.setCallbackExposure();
                ec ecVar = z0.this.k;
                if (ecVar != null) {
                    ecVar.b();
                }
            }

            @Override // com.beizi.fusion.s9.a
            public void b() {
                c.this.b = true;
            }
        }

        public c() {
        }

        @Override // com.beizi.fusion.ya
        public void a(fc fcVar) {
        }

        @Override // com.beizi.fusion.gc
        public void b(xa xaVar, View view) {
            if (this.b) {
                return;
            }
            z0 z0Var = z0.this;
            s9 s9Var = z0Var.p;
            if (s9Var == null || z0Var.k == null) {
                return;
            }
            s9Var.a(xaVar, view, z0Var.d, this.c);
            z0 z0Var2 = z0.this;
            qi qiVar = z0Var2.q;
            if (qiVar != null) {
                qiVar.a(z0Var2.a());
            }
            c3 c3Var = z0.this.u;
            if (c3Var != null) {
                c3Var.b();
            }
        }

        @Override // com.beizi.fusion.gc
        public void c(xa xaVar, View view) {
            qi qiVar = z0.this.q;
            if (qiVar != null) {
                qiVar.d();
            }
            if (z0.this.d.getShownTimestamp() == 0) {
                z0.this.d.recordShownTimestamp();
            }
            if (z0.this.d.isCallbackShown()) {
                return;
            }
            z0 z0Var = z0.this;
            if (z0Var.k != null) {
                z0Var.d.setCallbackShown();
                z0.this.k.onAdShown();
                z0 z0Var2 = z0.this;
                z0Var2.g.a(u7.EVENT_REPORT_SHOW_CODE, z0Var2.d);
            }
        }

        @Override // com.beizi.fusion.gc
        public void a(View view) {
            qi qiVar = z0.this.q;
            if (qiVar != null) {
                qiVar.c();
            }
        }

        @Override // com.beizi.fusion.gc
        public void b(View view) {
            if (this.f28081a) {
                return;
            }
            this.f28081a = true;
            hf hfVarA = z0.this.a(view);
            if (hfVarA != null) {
                hfVarA.a(view);
            }
            z0.this.d.recordExposureTimestamp();
            z0 z0Var = z0.this;
            q0 q0Var = z0Var.h;
            String strG = z0Var.c.g();
            u7 u7Var = u7.EVENT_REPORT_EXPOSURE_CODE;
            q0Var.a(strG, u7Var);
            z0 z0Var2 = z0.this;
            z0Var2.o.a(gc.a.AD_EXPOSURE, z0Var2.d, z0Var2.n());
            z0 z0Var3 = z0.this;
            z0Var3.g.a(u7Var, z0Var3.d);
        }
    }

    public class d implements dd {
        private d() {
        }

        @Override // com.beizi.fusion.ya
        public void a(cd cdVar) {
        }

        @Override // com.beizi.fusion.dd
        public void a(View view, dd.a aVar) {
            ScopeExpressContainer scopeExpressContainer;
            hf hfVarF;
            sg sgVar = z0.this.r;
            if (sgVar != null) {
                sgVar.a();
            }
            ad adVar = z0.this.l;
            if (adVar != null) {
                adVar.f();
            }
            qi qiVar = z0.this.q;
            if (qiVar != null) {
                qiVar.e();
            }
            z0.this.d.setInteractiveType(aVar.getEventCode());
            if (view instanceof ScopeExpressContainer) {
                scopeExpressContainer = (ScopeExpressContainer) view;
            } else {
                scopeExpressContainer = view != null ? (ScopeExpressContainer) view.getTag(dm.a(z0.this.f28077a, "scope_root_container")) : null;
            }
            if (scopeExpressContainer != null && (hfVarF = ScopeExpressContainer.d.f(scopeExpressContainer)) != null) {
                hfVarF.a(scopeExpressContainer);
                hfVarF.a(view, aVar.getEventCode());
            }
            if (aVar == dd.a.LANDING_PAGE_ENDCARD_INTERACTIVE_TRIGGER) {
                z0 z0Var = z0.this;
                z0Var.o.a(x9.a.AD_CLICK, z0Var.d, z0Var.n());
                z0 z0Var2 = z0.this;
                z0Var2.g.a(u7.EVENT_REPORT_CLICK_CODE, z0Var2.d);
            }
        }
    }

    public class f implements gf {
        public f() {
        }

        @Override // com.beizi.fusion.ya
        public void a(ff ffVar) {
        }

        @Override // com.beizi.fusion.gf
        public void b(xa xaVar, int i) {
            ef efVar = z0.this.m;
            if (efVar != null) {
                efVar.a();
            }
        }

        @Override // com.beizi.fusion.gf
        public void c(xa xaVar) {
            ef efVar = z0.this.m;
            if (efVar != null) {
                efVar.e();
            }
        }

        @Override // com.beizi.fusion.gf
        public void e(xa xaVar) {
            ef efVar = z0.this.m;
            if (efVar != null) {
                efVar.d();
            }
        }

        @Override // com.beizi.fusion.gf
        public void i(xa xaVar) {
            ef efVar = z0.this.m;
            if (efVar != null) {
                efVar.g();
            }
        }

        @Override // com.beizi.fusion.gf
        public void j(xa xaVar) {
            ef efVar = z0.this.m;
            if (efVar != null) {
                efVar.g();
            }
        }

        @Override // com.beizi.fusion.gf
        public void a(xa xaVar, int i) {
            ef efVar = z0.this.m;
            if (efVar != null) {
                efVar.a(i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z0(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        this.f28077a = context;
        this.b = adItemModel;
        this.j = adItemModel.getBiddingModel();
        this.c = baVar;
        this.d = adTraceModel;
        this.g = (q9) p.a().b(context);
        this.h = (q0) r0.a().b(context);
        d(adItemModel);
        c(adItemModel);
        NativeModel nativeModelA = a(adItemModel);
        a(nativeModelA);
        this.s = (kb) u4.a().b(context);
        b(nativeModelA);
    }

    private void a(NativeModel nativeModel) {
        e eVar = new e(nativeModel);
        this.t = eVar;
        eVar.a(this.f28077a.getApplicationContext());
    }

    private void c(AdItemModel adItemModel) {
        s9 s9Var = (s9) g0.a().b(this.f28077a);
        this.p = s9Var;
        if (adItemModel != null) {
            s9Var.a(adItemModel.getReport());
        }
    }

    private void d(AdItemModel adItemModel) {
        t9 t9Var = (t9) j0.a().b(this.f28077a);
        this.o = t9Var;
        t9Var.a(adItemModel);
    }

    private boolean l() {
        v vVarA;
        g gVar = (g) h.a().b(this.f28077a);
        if (gVar == null || (vVarA = gVar.a()) == null) {
            return true;
        }
        return vVarA.x();
    }

    @Override // com.beizi.fusion.ib
    public void b() {
        this.t = null;
    }

    @Override // com.beizi.fusion.ib
    public Map e() {
        return t.a().a(this.f28077a, this.c, this.d, this.b);
    }

    @Override // com.beizi.fusion.ib
    public mb f() {
        return this.i;
    }

    @Override // com.beizi.fusion.ib
    public boolean j() {
        return System.currentTimeMillis() < this.b.getExpired();
    }

    public x9 m() {
        return new a();
    }

    public String n() {
        return this.b.getAdnTraceTag();
    }

    public int o() {
        BiddingModel3 biddingModel3 = this.j;
        return (int) (biddingModel3 != null ? biddingModel3.getPrice() : AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final void p() {
        x9 x9Var = this.f;
        if (x9Var != null) {
            x9Var.d(x9.a.AD_CLOSE);
        }
    }

    public c q() {
        return new c();
    }

    public f r() {
        return new f();
    }

    public void b(Map map) {
        if (map != null) {
            BiddingModel3 biddingModel3 = this.j;
            String winURL = biddingModel3 != null ? biddingModel3.getWinURL() : "";
            if (TextUtils.isEmpty(winURL)) {
                return;
            }
            String str = (String) map.get("winPrice");
            String str2 = (String) map.get("secHighPrice");
            String str3 = (String) map.get("adnId");
            v4 v4Var = new v4(str, str2, "", str3, (String) map.get("expectPrice"), (String) map.get("auctionPrice"));
            om.d("NativeImpl", "上报竞价结果... 竞价成功 竞成价格:" + str + " 次高价: " + str2 + " adn " + str3);
            this.d.setWinPrice(str);
            this.d.setBidResult("1");
            a(winURL, v4Var);
        }
    }

    @Override // com.beizi.fusion.ib
    public void a(ec ecVar) {
        this.k = ecVar;
    }

    @Override // com.beizi.fusion.ib
    public void a(ad adVar) {
        this.l = adVar;
    }

    @Override // com.beizi.fusion.ib
    public void a(ef efVar) {
        this.m = efVar;
    }

    public void a(Map map) {
        if (map != null) {
            BiddingModel3 biddingModel3 = this.j;
            String loseURL = biddingModel3 != null ? biddingModel3.getLoseURL() : "";
            if (TextUtils.isEmpty(loseURL)) {
                return;
            }
            String str = (String) map.get("winPrice");
            String str2 = (String) map.get("lossReason");
            String str3 = (String) map.get("secHighPrice");
            String str4 = (String) map.get("adnId");
            v4 v4Var = new v4(str, str3, str2, str4, (String) map.get("expectPrice"), (String) map.get("auctionPrice"));
            om.d("NativeImpl", "上报竞价结果... 竞价失败 竞成价格:" + str + " 原因: " + str2 + " adn " + str4);
            this.d.setWinPrice(str);
            this.d.setBidResult("0");
            a(loseURL, v4Var);
        }
    }

    private void b(NativeModel nativeModel) {
        if (nativeModel != null && nativeModel.getIncome() != null) {
            a(nativeModel.getIncome().getOptimizeModelList());
            a(nativeModel.getIncome().getLandingOptimizeModel());
            c3 c3Var = new c3(this.f28077a, nativeModel.getIncome().getInvoke());
            this.u = c3Var;
            c3Var.a(this.e);
            return;
        }
        c3 c3Var2 = new c3(this.f28077a, 0);
        this.u = c3Var2;
        c3Var2.a(this.e);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f28084a;
        private final List b;
        private final List c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f28085a;

            public a(Context context) {
                this.f28085a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context applicationContext = this.f28085a.getApplicationContext();
                e eVar = e.this;
                l0.a(applicationContext, eVar.f28084a, eVar.b, eVar.c);
            }
        }

        private e(NativeModel nativeModel) {
            this.f28084a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            a(nativeModel);
        }

        private void a(NativeModel nativeModel) {
            if (nativeModel != null) {
                DownloadInfoModel downloadInfo = nativeModel.getDownloadInfo();
                if (downloadInfo != null) {
                    this.f28084a.add(downloadInfo.getIconUrl());
                }
                List<RenderModel> render = nativeModel.getRender();
                if (render != null) {
                    for (RenderModel renderModel : render) {
                        if (renderModel != null && renderModel.getViewModel() != null) {
                            String imageURL = renderModel.getViewModel().getImageURL();
                            if (!TextUtils.isEmpty(imageURL)) {
                                this.b.add(imageURL);
                            }
                        }
                    }
                }
                List<AssetModel> asset = nativeModel.getAsset();
                if (asset != null) {
                    for (AssetModel assetModel : asset) {
                        if (assetModel != null) {
                            ImageModel image = assetModel.getImage();
                            if (image != null && !TextUtils.isEmpty(image.getUrl())) {
                                this.f28084a.add(image.getUrl());
                            }
                            if (image != null && !TextUtils.isEmpty(image.getPlaceHolder())) {
                                this.f28084a.add(image.getPlaceHolder());
                            }
                            VideoModel video = assetModel.getVideo();
                            if (video != null && !TextUtils.isEmpty(video.getUrl())) {
                                this.c.add(video.getUrl());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context) {
            ((fb) cn.a().b(context)).f(new a(context));
        }
    }

    private void a(LandingOptimizeModel landingOptimizeModel) {
        if (landingOptimizeModel == null || !ml.a(landingOptimizeModel.getRandom())) {
            return;
        }
        sg sgVar = new sg(this.f28077a, landingOptimizeModel);
        this.r = sgVar;
        sgVar.a(this.e);
    }

    public ReportModel3 b(AdItemModel adItemModel) {
        if (adItemModel != null) {
            return adItemModel.getReport();
        }
        return null;
    }

    private void a(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z = false;
        OptimizeModel optimizeModel = (OptimizeModel) list.get(0);
        kb kbVar = this.s;
        if (kbVar != null && kbVar.a("4dcfae5406670c0ebd29c13c287229d7", m0.e(), 8)) {
            z = true;
        }
        if (optimizeModel == null || !z) {
            return;
        }
        com.beizi.fusion.f.a(this.f28077a).a("4dcfae5406670c0ebd29c13c287229d7");
        qi qiVar = new qi(this.f28077a, optimizeModel);
        this.q = qiVar;
        qiVar.a(this.e);
    }

    private void a(String str, v4 v4Var) {
        new xm(this.f28077a, true).a(rl.a(str, v4Var.getMacrosReplaceMap()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public hf a(View view) {
        if (view != 0) {
            ScopeExpressContainer expressRoot = view instanceof he ? ((he) view).getExpressRoot() : null;
            if (view instanceof ScopeExpressContainer) {
                expressRoot = (ScopeExpressContainer) view;
            }
            if (expressRoot != null) {
                return ScopeExpressContainer.d.f(expressRoot);
            }
        }
        return null;
    }

    public NativeModel a(AdItemModel adItemModel) {
        if (adItemModel != null) {
            return adItemModel.getNativeModel();
        }
        return null;
    }

    public xc a(Object obj, String str, String str2) {
        xc xcVarA = xf.a(this.f28077a, str, l());
        if (xcVarA != null) {
            if (xcVarA instanceof yc) {
                this.d.addSensorRecorder(((yc) xcVarA).c());
            }
            xcVarA.a(obj, this.c.b());
            NativeModel nativeModelA = a(this.b);
            if (nativeModelA != null) {
                dc dcVarA = a(str2, nativeModelA.getLink() != null ? nativeModelA.getLink().getInteractType() : -1, nativeModelA, n());
                qi qiVar = this.q;
                if (qiVar != null) {
                    qiVar.a(dcVarA, obj);
                }
                c3 c3Var = this.u;
                if (c3Var != null) {
                    c3Var.a(dcVarA, obj);
                }
                sg sgVar = this.r;
                if (sgVar != null) {
                    sgVar.a(dcVarA, obj);
                }
                if (dcVarA != null) {
                    xcVarA.a(dcVarA);
                    if (xcVarA instanceof wa) {
                        wa waVar = (wa) xcVarA;
                        if (waVar.d() != null) {
                            waVar.d().a(this.e);
                        }
                    }
                }
            }
        }
        return xcVarA;
    }

    public dc a(String str, int i, NativeModel nativeModel, String str2) {
        va vaVarD;
        dc dcVarA = f1.a(str, i);
        if (dcVarA != null) {
            dcVarA.a(this.f28077a, nativeModel, str2);
            if ((dcVarA instanceof wa) && (vaVarD = ((wa) dcVarA).d()) != null) {
                vaVarD.a(this.f);
            }
        }
        return dcVarA;
    }
}
