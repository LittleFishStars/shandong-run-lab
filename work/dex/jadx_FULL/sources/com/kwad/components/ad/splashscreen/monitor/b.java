package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b {
    private static volatile b Hq;

    public static void a(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(jElapsedRealtime).setBeforeLoadDataTime(j2).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.Hn) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aQo)).setVisibleCheckDelayTime(e.KL()).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(com.kwad.sdk.core.response.helper.e.eO(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void ap(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(4).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aQo)).setVisibleCheckDelayTime(e.KL()).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void aq(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(200).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ar(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(201).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void as(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(204).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void at(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(205).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void au(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(206).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void av(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(207).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void aw(@Nullable AdTemplate adTemplate) {
        String str;
        boolean z;
        int i;
        AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfoDW = com.kwad.sdk.core.response.helper.b.dW(adTemplate);
        boolean z2 = true;
        if (TextUtils.isEmpty(splashPlayCardTKInfoDW.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z = true;
        } else {
            str = "";
            z = false;
        }
        if (splashPlayCardTKInfoDW.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i = splashPlayCardTKInfoDW.renderType;
        } else {
            i = -1;
            z2 = z;
        }
        if (z2) {
            com.kwad.sdk.commercial.c.o(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(jElapsedRealtime).setBeforeLoadDataTime(j2).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setUrl(com.kwad.sdk.core.response.helper.a.bi(adInfoEO) ? com.kwad.sdk.core.response.helper.a.M(adInfoEO) : com.kwad.sdk.core.response.helper.a.ba(adInfoEO).materialUrl).setAdTemplate(adTemplate));
    }

    public static void c(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void d(@NonNull AdTemplate adTemplate, int i, String str) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setUrl(com.kwad.sdk.core.response.helper.a.bi(adInfoEO) ? com.kwad.sdk.core.response.helper.a.M(adInfoEO) : com.kwad.sdk.core.response.helper.a.ba(adInfoEO).materialUrl).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.helper.a.bi(adInfoEO) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.Hn) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aQo)).setVisibleCheckDelayTime(e.KL()).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(com.kwad.sdk.core.response.helper.e.eO(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void f(long j, long j2) {
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j2).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.Hn) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aQo)).setVisibleCheckDelayTime(e.KL()).setPosId(j));
    }

    public static void g(@NonNull AdTemplate adTemplate, long j) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(5).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setAdTemplate(adTemplate));
    }

    public static void k(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                com.kwad.sdk.commercial.c.l(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setMaterialTypes(arrayList3).setStatus(1).setPosId(adResultData.getPosId()));
                return;
            }
            AdTemplate next = it.next();
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.helper.a.L(com.kwad.sdk.core.response.helper.e.eO(next))));
            arrayList2.add(com.kwad.sdk.core.response.helper.a.bf(com.kwad.sdk.core.response.helper.e.eO(next)));
            if (com.kwad.sdk.core.response.helper.a.bi(com.kwad.sdk.core.response.helper.e.eO(next))) {
                i = 2;
            }
            arrayList3.add(Integer.valueOf(i));
        }
    }

    public static b mv() {
        if (Hq == null) {
            synchronized (b.class) {
                if (Hq == null) {
                    Hq = new b();
                }
            }
        }
        return Hq;
    }

    public static void x(long j) {
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setStatus(1).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.Hn) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aQo)).setVisibleCheckDelayTime(e.KL()).setPosId(j));
    }

    public static void y(long j) {
        com.kwad.sdk.commercial.c.k(new SplashMonitorInfo().setStatus(1).setPosId(j));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long jDT;
        StyleTemplate styleTemplateC = c(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.helper.b.dY(adTemplate)).setTemplateId(styleTemplateC.templateId).setTemplateVersionCode(styleTemplateC.templateVersionCode);
        com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (h.aj(adTemplate)) {
            jDT = com.kwad.sdk.core.response.helper.b.dX(adTemplate);
        } else {
            jDT = com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(jDT).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void f(@NonNull AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(1).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aQo)).setVisibleCheckDelayTime(e.KL()).setType(com.kwad.sdk.core.response.helper.a.bj(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) ? 2 : 1).setCostTime(j).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.Hn) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i, String str) {
        String strM;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        boolean zBj = com.kwad.sdk.core.response.helper.a.bj(adInfoEO);
        SplashMonitorInfo type = new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(3).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setType(zBj ? 2 : 1);
        if (zBj) {
            strM = com.kwad.sdk.core.response.helper.a.ba(adInfoEO).materialUrl;
        } else {
            strM = com.kwad.sdk.core.response.helper.a.M(adInfoEO);
        }
        com.kwad.sdk.commercial.c.m(type.setUrl(strM).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void k(AdTemplate adTemplate, int i, int i2) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(3001).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setUrl(com.kwad.sdk.core.response.helper.a.ba(adInfoEO).materialUrl).setShowType(i2).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long jDT;
        StyleTemplate styleTemplateC = c(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(styleTemplateC.templateId).setTemplateVersionCode(styleTemplateC.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.helper.b.dY(adTemplate)).setErrorMsg(str);
        com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (h.aj(adTemplate)) {
            jDT = com.kwad.sdk.core.response.helper.b.dX(adTemplate);
        } else {
            jDT = com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(errorMsg.setTkDefaultTimeout(jDT).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.helper.a.bf(com.kwad.sdk.core.response.helper.e.eO(it.next())));
        }
        com.kwad.sdk.commercial.c.k(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).setPosId(j2));
    }

    public static void b(int i, String str, long j) {
        com.kwad.sdk.commercial.c.k(new SplashMonitorInfo().setStatus(3).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDT;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.helper.b.dY(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (h.aj(adTemplate)) {
            jDT = com.kwad.sdk.core.response.helper.b.dX(adTemplate);
        } else {
            jDT = com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(jDT).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, long j, int i, int i2) {
        String strM;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.bi(adInfoEO)) {
            strM = com.kwad.sdk.core.response.helper.a.M(adInfoEO);
        } else {
            strM = com.kwad.sdk.core.response.helper.a.ba(adInfoEO).materialUrl;
        }
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(com.kwad.sdk.core.response.helper.a.bf(adInfoEO));
        com.kwad.sdk.commercial.c.g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setCostTime(j).setCacheValidTime(((long) adInfoEO.adPreloadInfo.validityPeriod) * 1000).setSize((fileCO == null || !fileCO.exists()) ? 0L : fileCO.length()).setUrl(strM).setMaterialType(com.kwad.sdk.core.response.helper.a.bi(adInfoEO) ? 1 : 2).setType(i).setRequestType(i2).setAdTemplate(adTemplate));
    }

    public static void a(long j, List<String> list, List<Integer> list2) {
        com.kwad.sdk.commercial.c.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setStatus(2).setPosId(j));
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = com.kwad.sdk.core.response.helper.b.t(adTemplate, com.kwad.sdk.core.response.helper.b.em(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (matrixTemplateT != null) {
            styleTemplate.templateId = matrixTemplateT.templateId;
            styleTemplate.templateMd5 = matrixTemplateT.templateMd5;
            styleTemplate.templateUrl = matrixTemplateT.templateUrl;
            styleTemplate.templateVersionCode = (int) matrixTemplateT.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void a(long j, List<String> list, List<Integer> list2, int i, int i2, int i3, int i4) {
        com.kwad.sdk.commercial.c.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setUpdateType(i).setClearCount(i2).setClearImageCount(i3).setClearVideoCount(i4).setStatus(3).setPosId(j));
    }

    public static void b(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.c.p(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2, long j3) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(2).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setCostTime(j).setAddLoadTime(j2).setRequestLoadTime(j3).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aQo)).setVisibleCheckDelayTime(e.KL()).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.Hn) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDT;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.helper.b.dY(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (h.aj(adTemplate)) {
            jDT = com.kwad.sdk.core.response.helper.b.dX(adTemplate);
        } else {
            jDT = com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(jDT).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(3003).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setUrl(com.kwad.sdk.core.response.helper.a.ba(adInfoEO).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(6).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setViewSource(z ? 1 : 2).setLoadDataTime(jElapsedRealtime).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(202).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setRootVisible(z).setParentVisible(z2).setHasUnbind(z3).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, boolean z, boolean z2) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(203).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setLoadDataTime(SystemClock.elapsedRealtime() - j).setRootVisible(z).setParentVisible(z2).setType(com.kwad.sdk.core.response.helper.a.bj(adInfoEO) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, boolean z) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.c.n(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.c.n(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.helper.a.L(com.kwad.sdk.core.response.helper.e.eO(adTemplate))).setErrorMsg(str).setViewSource(z ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDT;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.helper.b.dY(adTemplate));
        com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (h.aj(adTemplate)) {
            jDT = com.kwad.sdk.core.response.helper.b.dX(adTemplate);
        } else {
            jDT = com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(tkRenderType.setTkDefaultTimeout(jDT).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i, long j, int i2, long j2, long j3, long j4, long j5, long j6) {
        long jDT;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.helper.b.dY(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (h.aj(adTemplate)) {
            jDT = com.kwad.sdk.core.response.helper.b.dX(adTemplate);
        } else {
            jDT = com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(jDT).setSoSource(i).setSoLoadTime(j).setOfflineSource(i2).setOfflineLoadTime(j2).setTkFileLoadTime(j3).setTkInitTime(j4).setTkRenderTime(j5).setTkTotalTime(j6).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(3002).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.helper.a.bf(adInfoEO)).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setUrl(com.kwad.sdk.core.response.helper.a.ba(adInfoEO).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }
}
