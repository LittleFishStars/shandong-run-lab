package cj.mobile.wm;

import android.text.TextUtils;
import com.wangmai.insightvision.openadsdk.entity.insight.AdConfigInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdDspDisplayInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdImageInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdInteractInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdLayoutInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdTmInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdVideoInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.BidInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.InsightInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex02 {
    public static com.wangmai.insightvision.openadsdk.common.f dexa(InsightInfo insightInfo) {
        if (insightInfo != null && insightInfo.isSuccess() && insightInfo.getBidInfoList() != null && !insightInfo.getBidInfoList().isEmpty()) {
            BidInfo bidInfo = (BidInfo) insightInfo.getBidInfoList().get(0);
            List adInfoList = bidInfo.getAdInfoList();
            if (adInfoList != null && !adInfoList.isEmpty()) {
                AdInfo adInfo = (AdInfo) adInfoList.get(0);
                com.wangmai.insightvision.openadsdk.common.f fVar = new com.wangmai.insightvision.openadsdk.common.f();
                HashMap map = new HashMap();
                map.put("req_id", bidInfo.getId());
                map.put("imp_id", bidInfo.getImpId());
                fVar.j(adInfo.getTitle());
                fVar.h(adInfo.getSubTitle());
                map.put("pid", adInfo.getPid());
                map.put("crid", adInfo.getCrid());
                map.put("price", Double.valueOf(adInfo.getPrice()));
                map.put("bid_ext", adInfo.getExt());
                map.put("slot_id", adInfo.getSlotId());
                if (adInfo.getDspDisplay() != null) {
                    map.put("dsp_id", adInfo.getDspDisplay().getDspId());
                }
                AdLayoutInfo layout = adInfo.getLayout();
                if (layout != null) {
                    fVar.g(layout.getShowTime());
                    fVar.d(layout.getRenderType());
                    fVar.i(layout.getRenderingTemplateIdSingle());
                    fVar.d(layout.getRewardedAchieveTime());
                    fVar.e(layout.getRewardValidType());
                    fVar.d(!"voice".equals(layout.getVoiceControl()));
                    fVar.f(layout.getSlotType());
                    dex03.dexb(fVar, layout.getDisableRepeatExp() == 0);
                }
                AdConfigInfo adConfigInfoDexa = dexa(adInfo);
                if (adConfigInfoDexa != null) {
                    AdInteractInfo interact = adConfigInfoDexa.getInteract();
                    if (interact != null) {
                        fVar.a(interact);
                    }
                    dex03.dexa(fVar, adConfigInfoDexa.getCallbackType());
                    dex03.dexb(fVar, adConfigInfoDexa.getCfjType());
                    dex03.dexc(fVar, adConfigInfoDexa.getJumpType());
                    dex03.dexa(fVar, adConfigInfoDexa.getAjdcsCbType() >= 0);
                    dex03.dexe(fVar, adConfigInfoDexa.getTouchJumpType());
                    dex03.dexc(fVar, o1.dexa(adConfigInfoDexa));
                    dex03.dexd(fVar, adConfigInfoDexa.getShakeDowngradeH5());
                } else if (layout != null) {
                    dex03.dexa(fVar, layout.getCallbackType());
                    dex03.dexb(fVar, layout.getCfjType());
                    dex03.dexc(fVar, layout.getJumpType());
                    dex03.dexa(fVar, layout.getAjdcsCbType() >= 0);
                    dex03.dexe(fVar, layout.getTouchJumpType());
                    dex03.dexc(fVar, o1.dexa(layout));
                    dex03.dexd(fVar, layout.getShakeDowngradeH5());
                    if (layout.getInteract() != null) {
                        fVar.a(layout.getInteract());
                    }
                }
                dexd(adInfo, fVar);
                dexc(adInfo, fVar);
                if (adInfo.getLogo() != null) {
                    fVar.c(adInfo.getLogo().getUrl());
                }
                fVar.a(adInfo.getDpLink());
                fVar.b(adInfo.getLdpUrl());
                fVar.a(adInfo.getApk());
                AdDspDisplayInfo dspDisplay = adInfo.getDspDisplay();
                if (dspDisplay != null) {
                    fVar.a(dspDisplay);
                }
                dexb(adInfo, fVar);
                dexa(adInfo, fVar);
                fVar.a(map);
                return fVar;
            }
        }
        return null;
    }

    public static com.wangmai.insightvision.openadsdk.common.f dexa(String str, int i) {
        try {
            return dexa((InsightInfo) dex04.a(str, InsightInfo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AdConfigInfo dexa(AdInfo adInfo) {
        if (adInfo.getlEncs() == null || adInfo.getlEncs().isEmpty()) {
            return null;
        }
        String strDexa = ie.dexa(adInfo.getlEncs());
        if (TextUtils.isEmpty(strDexa)) {
            return null;
        }
        try {
            return (AdConfigInfo) dex04.a(strDexa, AdConfigInfo.class);
        } catch (Exception e) {
            f1.dexa(e);
            return null;
        }
    }

    public static void dexa(AdInfo adInfo, com.wangmai.insightvision.openadsdk.common.f fVar) {
        fVar.e(adInfo.getDpMonitorList());
        fVar.f(adInfo.getpMonitorList());
        fVar.a(adInfo.getcMonitorList());
        fVar.d(adInfo.getdStartMonitorList());
        fVar.c(adInfo.getdFinishMonitorList());
        fVar.b(adInfo.getCsmMonitorList());
        fVar.i(adInfo.getWinMonitorList());
        fVar.g(adInfo.getLossMonitorList());
    }

    public static void dexb(AdInfo adInfo, com.wangmai.insightvision.openadsdk.common.f fVar) {
        List<AdTmInfo> list = adInfo.gettMonitorList();
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AdTmInfo adTmInfo : list) {
            dex01 dex01Var = new dex01();
            dex01Var.dexa(adTmInfo.getTime());
            dex01Var.dexa(adTmInfo.getMonitorUrl());
            arrayList.add(dex01Var);
        }
        fVar.h(arrayList);
    }

    public static void dexc(AdInfo adInfo, com.wangmai.insightvision.openadsdk.common.f fVar) {
        AdImageInfo image = adInfo.getImage();
        if (image == null) {
            return;
        }
        com.wangmai.insightvision.openadsdk.common.b bVar = new com.wangmai.insightvision.openadsdk.common.b();
        bVar.a(image.getUrl());
        bVar.b(image.getWidth());
        bVar.a(image.getHeight());
        fVar.a(bVar);
    }

    public static void dexd(AdInfo adInfo, com.wangmai.insightvision.openadsdk.common.f fVar) {
        AdVideoInfo video = adInfo.getVideo();
        if (video == null) {
            return;
        }
        com.wangmai.insightvision.openadsdk.common.i iVar = new com.wangmai.insightvision.openadsdk.common.i();
        iVar.a(video.getDuration());
        iVar.b(video.getHeight());
        iVar.d(video.getWidth());
        iVar.b(video.getUrl());
        iVar.c(video.getSize());
        iVar.a(video.getCoverImageUrl());
        fVar.a(iVar);
    }
}
