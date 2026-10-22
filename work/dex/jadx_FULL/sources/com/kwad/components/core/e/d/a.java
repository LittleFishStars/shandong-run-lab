package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.innerEc.logger.InnerEcError;
import com.kwad.components.core.innerEc.logger.InnerEcEvent;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.wrapper.m;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static List<WeakReference<k.b>> QH;
    public static InnerEcEvent QI;
    public static InnerEcError QJ;

    /* JADX INFO: renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    public static class C1201a {
        private boolean QK;
        private boolean QL;
        private boolean QM;
        private boolean QN;
        private boolean QO;
        private boolean QP;
        private boolean QQ;
        private b QR;
        private d QS;
        private boolean QT;
        private boolean QU;
        private long QV;
        private boolean QW;
        public String QY;
        public com.kwad.sdk.core.adlog.a.C1273a QZ;
        private JSONObject Rc;
        private boolean Re;
        private int Rf;
        private int Rg;
        private int Rh;
        private int Ri;
        private Callable<String> Rj;
        private String Rk;
        private boolean Rl;
        private boolean Rm;
        private AdTemplate adTemplate;
        private final Context context;
        private boolean needReport;
        private int nk;
        private int nm;
        public al.a no;
        public long zV;
        public int QX = -1;
        public int Ra = 0;
        public int Rb = -1;
        private boolean Rd = false;

        public C1201a(Context context) {
            this.context = context;
        }

        public final C1201a D(long j) {
            this.QV = j;
            return this;
        }

        public final C1201a E(long j) {
            this.zV = j;
            return this;
        }

        public final C1201a a(@Nullable Callable<String> callable) {
            this.Rj = callable;
            return this;
        }

        public final C1201a aA(boolean z) {
            this.QM = true;
            return this;
        }

        public final void aB(boolean z) {
            this.Rl = true;
        }

        public final void aC(boolean z) {
            this.Rm = true;
        }

        public final C1201a aJ(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final void aK(int i) {
            this.Rg = i;
        }

        public final C1201a aL(int i) {
            this.Ri = i;
            return this;
        }

        public final C1201a aM(int i) {
            this.nm = i;
            return this;
        }

        public final C1201a aN(int i) {
            this.nk = i;
            return this;
        }

        public final C1201a aO(int i) {
            this.Ra = i;
            return this;
        }

        public final C1201a aP(int i) {
            this.Rb = i;
            return this;
        }

        public final C1201a aQ(int i) {
            this.Rf = i;
            return this;
        }

        public final C1201a aR(int i) {
            this.Rh = i;
            return this;
        }

        public final void ao(boolean z) {
            this.QU = true;
        }

        public final C1201a ap(String str) {
            this.Rk = str;
            return this;
        }

        public final C1201a aq(boolean z) {
            this.QQ = true;
            return this;
        }

        public final C1201a ar(boolean z) {
            this.QO = true;
            return this;
        }

        public final C1201a as(boolean z) {
            this.QT = z;
            return this;
        }

        public final C1201a at(boolean z) {
            this.QW = z;
            return this;
        }

        public final C1201a au(boolean z) {
            this.needReport = z;
            return this;
        }

        public final C1201a av(boolean z) {
            this.Rd = z;
            return this;
        }

        public final C1201a aw(boolean z) {
            this.QL = z;
            return this;
        }

        public final C1201a ax(boolean z) {
            this.QN = true;
            return this;
        }

        public final C1201a ay(boolean z) {
            this.QK = z;
            return this;
        }

        public final C1201a az(boolean z) {
            this.Re = z;
            return this;
        }

        public final C1201a b(d dVar) {
            this.QS = dVar;
            return this;
        }

        public final C1201a d(al.a aVar) {
            this.no = aVar;
            return this;
        }

        public final int ed() {
            return this.nk;
        }

        public final int eg() {
            return this.nm;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final JSONObject iK() {
            return this.Rc;
        }

        public final d iv() {
            return this.QS;
        }

        public final String pN() {
            return this.Rk;
        }

        public final Callable<String> pO() {
            return this.Rj;
        }

        public final boolean pP() {
            return this.QU;
        }

        public final int pQ() {
            return this.Rg;
        }

        public final b pR() {
            return this.QR;
        }

        public final boolean pS() {
            return this.QO;
        }

        public final int pT() {
            return this.Ri;
        }

        public final boolean pU() {
            return this.QP;
        }

        public final boolean pV() {
            return this.QQ;
        }

        public final boolean pW() {
            return this.QT;
        }

        public final long pX() {
            return this.QV;
        }

        public final boolean pY() {
            return this.QW;
        }

        public final boolean pZ() {
            return this.needReport;
        }

        public final com.kwad.sdk.core.adlog.c.a qa() {
            return com.kwad.sdk.core.adlog.c.a.Jf().dW(this.nm).eb(this.QY).e(this.no).dX(this.Ra).dY(this.Rb).aA(this.zV).a(this.QZ).dZ(this.QX);
        }

        public final boolean qb() {
            return this.Rd;
        }

        public final boolean qc() {
            return this.QL;
        }

        public final boolean qd() {
            return this.QN;
        }

        public final boolean qe() {
            return this.QK;
        }

        public final boolean qf() {
            return this.Re;
        }

        public final int qg() {
            return this.Rf;
        }

        public final int qh() {
            return this.Rh;
        }

        public final boolean qi() {
            return this.QM;
        }

        public final boolean qj() {
            return this.Rl;
        }

        public final boolean qk() {
            return this.Rm;
        }

        public final C1201a a(b bVar) {
            this.QR = bVar;
            return this;
        }

        public final C1201a ap(boolean z) {
            this.QP = z;
            return this;
        }

        public final C1201a aq(String str) {
            this.QY = str;
            return this;
        }

        public final C1201a d(JSONObject jSONObject) {
            this.Rc = jSONObject;
            return this;
        }

        public final C1201a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.QZ == null) {
                this.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
            }
            this.QZ.a(this.adTemplate, null, null, null);
            return this;
        }
    }

    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable d dVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.convert.a.h(adTemplate, true);
        adTemplate.converted = true;
        e.aD(false);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C1201a c1201aAv = new C1201a(context).aJ(adTemplate).a(bVar).b(dVar).as(z).at(z2).ap(z4).av(false);
        int iAt = com.kwad.sdk.core.response.helper.a.at(adInfoEO);
        if (!(z3 || c1201aAv.qh() == 2 || c1201aAv.qh() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(adInfoEO)) && !c1201aAv.qd()) {
            if (iAt == 1) {
                return com.kwad.sdk.core.response.helper.a.bo(adInfoEO) ? k(c1201aAv) : l(c1201aAv);
            }
            if (iAt == 2) {
                int iH = h(c1201aAv);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                return com.kwad.sdk.core.response.helper.a.bo(adInfoEO) ? k(c1201aAv) : l(c1201aAv);
            }
        }
        int iH2 = h(c1201aAv);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            if (j(c1201aAv)) {
                return 11;
            }
            return l(c1201aAv);
        }
        int iM = m(c1201aAv);
        int i = adInfoEO.status;
        if (i != 2 && i != 3) {
            e(c1201aAv);
        }
        return iM;
    }

    private static void aI(AdTemplate adTemplate) {
        AdInfo adInfoEO;
        if (adTemplate == null || (adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate)) == null) {
            return;
        }
        adInfoEO.convertCount++;
    }

    private static int b(C1201a c1201a) {
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.helper.a.Y(adInfoEO) || c1201a.pP() || c1201a.pU()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C1220a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).aR(true).ua());
            f(adTemplate, 20);
            return 20;
        }
        c1201a.aK(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c1201a);
        f(adTemplate, 19);
        return 19;
    }

    public static boolean c(C1201a c1201a) {
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(c1201a.getAdTemplate()))) {
            return !c1201a.qf() && d.E(c1201a) == 3;
        }
        return d(c1201a) == 1;
    }

    private static int d(C1201a c1201a) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c1201a.getAdTemplate());
        if (adInfoEO.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int iEd = c1201a.ed();
        if (iEd != 2) {
            return iEd != 3 ? adInfoEO.unDownloadConf.unDownloadRegionConf.actionBarType : adInfoEO.unDownloadConf.unDownloadRegionConf.materialJumpType;
        }
        return adInfoEO.unDownloadConf.unDownloadRegionConf.describeBarType;
    }

    private static void e(C1201a c1201a) {
        if (c1201a.pP() || c1201a.qj()) {
            return;
        }
        g(c1201a);
        f(c1201a);
        if (c1201a.pR() != null) {
            try {
                c1201a.pR().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.convert.a.bK(c1201a.getAdTemplate());
        aI(c1201a.getAdTemplate());
    }

    private static void f(C1201a c1201a) {
        if (c1201a.pZ()) {
            com.kwad.sdk.core.adlog.c.a(c1201a.adTemplate, c1201a.qa(), c1201a.iK());
        }
    }

    private static void g(C1201a c1201a) {
        k.b bVar;
        List<WeakReference<k.b>> list = QH;
        if (list == null || list.isEmpty() || c1201a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : QH) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.Y(com.kwad.sdk.core.response.helper.e.eY(c1201a.adTemplate));
            }
        }
    }

    private static int h(C1201a c1201a) {
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        int iA = e.a(c1201a, 1);
        if (iA == 1) {
            e.aD(true);
            e(c1201a);
            if ((com.kwad.sdk.core.response.helper.a.cX(adInfoEO) || com.kwad.sdk.core.response.helper.a.cY(adInfoEO)) && !c1201a.qi()) {
                com.kwad.sdk.core.adlog.c.q(c1201a.getAdTemplate(), (int) Math.ceil(c1201a.pX() / 1000.0f));
            }
            f(adTemplate, 13);
        } else if (iA == 2) {
            e(c1201a);
            f(adTemplate, 16);
        }
        return iA;
    }

    private static int i(C1201a c1201a) {
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c1201a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c1201a.getContext());
        if (activityFromContext == null || !com.kwad.sdk.core.response.helper.a.W(adInfoEO) || c1201a.pP() || !f.G(adInfoEO) || c1201a.pU()) {
            int iE = f.e(context, adTemplate);
            if (iE == 1) {
                e(c1201a);
                f(adTemplate, 12);
            }
            return iE;
        }
        c1201a.aK(1);
        com.kwad.components.core.e.e.e.a(activityFromContext, c1201a);
        e(c1201a);
        f(adTemplate, 17);
        return 2;
    }

    private static boolean j(C1201a c1201a) {
        AdTemplate adTemplate = c1201a.getAdTemplate();
        boolean zL = com.kwad.sdk.utils.f.l(c1201a.getContext(), adTemplate);
        if (zL) {
            e(c1201a);
            com.kwad.sdk.core.adlog.c.o(adTemplate, 0);
            f(adTemplate, 11);
        }
        return zL;
    }

    private static int k(C1201a c1201a) {
        e(c1201a);
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c1201a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c1201a.getContext());
        if (activityFromContext == null || !com.kwad.sdk.core.response.helper.a.Y(adInfoEO) || c1201a.pP() || c1201a.pU()) {
            AdWebViewVideoActivityProxy.launch(c1201a.getContext(), adTemplate);
            f(adTemplate, 15);
            return 15;
        }
        c1201a.aK(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c1201a);
        f(adTemplate, 19);
        return 19;
    }

    private static int l(C1201a c1201a) {
        e(c1201a);
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.helper.a.Y(adInfoEO) || c1201a.pP() || c1201a.pU()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C1220a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).aS(c1201a.pS()).bv(com.kwad.components.core.innerEc.f.aK(adTemplate) ? 2 : 1).ua());
            f(adTemplate, 14);
            return 14;
        }
        c1201a.aK(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c1201a);
        f(adTemplate, 19);
        return 19;
    }

    private static int m(C1201a c1201a) {
        d dVarIv = c1201a.iv();
        if (dVarIv == null) {
            dVarIv = new d(c1201a.adTemplate);
            c1201a.b(dVarIv);
        }
        int iV = dVarIv.v(c1201a);
        f(c1201a.getAdTemplate(), iV);
        return iV;
    }

    private static int n(C1201a c1201a) {
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (j(c1201a)) {
            return 11;
        }
        return (!com.kwad.sdk.core.response.helper.a.b(adInfoEO, com.kwad.sdk.core.config.e.JJ()) || adTemplate.mAdWebVideoPageShowing) ? l(c1201a) : k(c1201a);
    }

    public static void f(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.convert.a.ca(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.convert.a.bP(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.convert.a.bZ(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.convert.a.bR(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.convert.a.bX(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.convert.a.bY(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.convert.a.bS(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.convert.a.bT(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.convert.a.bU(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.convert.a.bW(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.convert.a.bV(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.convert.a.bO(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.convert.a.bN(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.convert.a.bM(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.convert.a.bL(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.convert.a.bQ(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.convert.a.cc(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.convert.a.cf(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.convert.a.cb(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.convert.a.cd(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.convert.a.ce(adTemplate);
                break;
        }
    }

    public static void b(k.b bVar) {
        if (QH == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= QH.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = QH.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            QH.remove(i);
        }
    }

    public static int a(C1201a c1201a) {
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        e.aD(false);
        if (c1201a.pV()) {
            return b(c1201a);
        }
        if (c1201a.qe()) {
            return a(context, adTemplate, c1201a.pR(), c1201a.iv(), c1201a.QT, c1201a.pY(), false, c1201a.pU());
        }
        com.kwad.sdk.commercial.convert.a.h(adTemplate, false);
        if (c(c1201a)) {
            f(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        boolean zAK = com.kwad.components.core.innerEc.f.aK(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.dG(adInfoEO)) {
            com.kwad.components.core.innerEc.logger.a.d(adTemplate, c1201a.qk());
        }
        if (zAK && !adTemplate.hasInnerEcFailed() && !c1201a.qk()) {
            QJ = InnerEcError.createEmptyError(adTemplate);
            QI = InnerEcEvent.createEmptyEvent(adTemplate);
            e(c1201a);
            c1201a.aB(true);
            int iA = com.kwad.components.core.innerEc.f.a(context, adTemplate, c1201a);
            if (iA == 1) {
                return 14;
            }
            if (iA == 2) {
                com.kwad.components.core.innerEc.qcpx.b.h(context, adTemplate);
                if (com.kwad.sdk.core.response.helper.e.fm(adTemplate)) {
                    com.kwad.components.core.innerEc.live.b.c(com.kwad.sdk.core.c.b.LW().getApplication());
                    com.kwad.components.core.innerEc.live.b.b(context, adTemplate, c1201a);
                    return 14;
                }
                com.kwad.components.core.innerEc.f.g(context, adTemplate);
                return 14;
            }
            if (iA == 3) {
                return com.kwad.components.core.innerEc.f.G(c1201a);
            }
        }
        int iAt = com.kwad.sdk.core.response.helper.a.at(adInfoEO);
        if (!(c1201a.qh() == 2 || c1201a.qh() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(adInfoEO)) && !c1201a.qd()) {
            if (iAt == 1) {
                if (com.kwad.sdk.core.response.helper.a.bo(adInfoEO)) {
                    return k(c1201a);
                }
                return l(c1201a);
            }
            if (iAt == 2) {
                int iH = h(c1201a);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.helper.a.bo(adInfoEO)) {
                    return k(c1201a);
                }
                return l(c1201a);
            }
        }
        int iH2 = h(c1201a);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        int i = i(c1201a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c1201a.qc() && !com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            return n(c1201a);
        }
        if (!com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            if (adTemplate.isWebViewDownload) {
                int iM = m(c1201a);
                adTemplate.isWebViewDownload = false;
                return iM;
            }
            if (j(c1201a)) {
                return 11;
            }
            return l(c1201a);
        }
        if (c1201a.qh() != 2 && c1201a.qh() != 1) {
            if (c1201a.qc() && com.kwad.sdk.core.response.helper.a.b(adInfoEO, com.kwad.sdk.core.config.e.JJ()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(adInfoEO)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int iU = c1201a.iv().u(c1201a);
                if (iU == 0) {
                    return k(c1201a);
                }
                e(c1201a);
                f(adTemplate, iU);
                return iU;
            }
            e(c1201a);
            c1201a.av(true);
            return m(c1201a);
        }
        c1201a.av(false);
        e(c1201a);
        return m(c1201a);
    }

    public static void a(k.b bVar) {
        if (QH == null) {
            QH = new CopyOnWriteArrayList();
        }
        QH.add(new WeakReference<>(bVar));
    }
}
