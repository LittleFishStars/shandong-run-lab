package com.kc.dw.core.ad.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkClsUtil;
import com.kc.dw.own.feed.OwnFeedAdapter;
import com.kc.dw.platform.ad_adapter.recycler.e;
import com.kc.dw.platform.custom.PlatfromFactory;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RecyclerMixCommonAdLoader extends a<RecyclerAdEventAdapterListener> {
    private static final String TAG = "RecyclerMixCommonAdLoader";
    public int fetchCount = 1;

    private e newOwnAdNativeWarapper(i iVar, SsdAdInfo ssdAdInfo) {
        iVar.setImageUrls(ssdAdInfo.getSrcUrls());
        return new e(this, iVar);
    }

    @Override // com.kc.dw.core.loader.a
    public b createDelegate(SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        if (sdkAdInfo == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
                return null;
            }
            MsCustomRecyclerAdapter msCustomRecyclerAdapterRecyclerLoader = PlatfromFactory.getCustomPlatfrom().recyclerLoader(this, sdkAdInfo, ssdAdInfo);
            msCustomRecyclerAdapterRecyclerLoader.init(this, sdkAdInfo);
            return msCustomRecyclerAdapterRecyclerLoader;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.loader.a
    public b createOwnAdDelegate(Context context, SsdAdInfo ssdAdInfo) {
        e eVarNewOwnAdNativeWarapper;
        i.a nop = new i.a(new i()).setAppId(com.kc.dw.base.a.adConfig().appId()).setWxAppId(ssdAdInfo.getWx_appid()).setScaleType(ssdAdInfo.getScale_type()).setEventUrl(ssdAdInfo.getEventUrl()).setWinUrl(ssdAdInfo.getWinUrl()).setLossUrl(ssdAdInfo.getLossUrl()).setActionDesc(ssdAdInfo.getAction_desc()).setScheme(ssdAdInfo.getScheme()).setDynamicMap(ssdAdInfo.getDynamicMap()).setFieldExport(ssdAdInfo.getFieldExport()).setAdg(ssdAdInfo.getAdg()).setAdp(ssdAdInfo.getAdp()).setDefaultCoord(ssdAdInfo.getDefault_coord()).setDpSign(ssdAdInfo.getDpsign()).setActExt(ssdAdInfo.getAct_ext()).setUob(ssdAdInfo.getUob()).setDPSIGN(ssdAdInfo.getDPSIGN()).setNativeSE(ssdAdInfo.getNative_s_e()).setLoadedTime(ssdAdInfo.getLoadedTime()).setClickType(ssdAdInfo.getClk_type()).setPowerIndex(ssdAdInfo.getPower_index()).setPowerIndex2(ssdAdInfo.getPower_index2()).setPowerDelay(ssdAdInfo.getPower_delay()).setPowerCount(ssdAdInfo.getPower_count()).setExpireTimestamp(ssdAdInfo.getExpire_timestamp()).setEcpm(ssdAdInfo.getEcpm()).setDClickData(ssdAdInfo.getDclk()).setActType(ssdAdInfo.getAct_type()).setAdType(ssdAdInfo.getAd_type()).setCBC(ssdAdInfo.getCbc()).setNOP(ssdAdInfo.getNop());
        nop.f39133a.y = ssdAdInfo.getVideo_duration();
        i.a appIntroUrl = nop.setS_code(ssdAdInfo.getS_code()).setS_ext(ssdAdInfo.getS_ext()).setReqId(ssdAdInfo.getReq_id()).setFromId(ssdAdInfo.getFrom_id()).setDirectMarket(ssdAdInfo.getDirect_market()).setPackageName(ssdAdInfo.getPackage_name()).setPosId(ssdAdInfo.getPid()).setAllTimes(ssdAdInfo.getAllTimes()).setPermissionUrl(ssdAdInfo.getApp_permission_url()).setPermisssList(ssdAdInfo.getApp_permission()).setAppIntroUrl(ssdAdInfo.getApp_intor_url());
        appIntroUrl.f39133a.x = ssdAdInfo.getStyle_id();
        i.a aderId = appIntroUrl.setCid(ssdAdInfo.getCid()).setCat(ssdAdInfo.getCat()).setAderId(ssdAdInfo.getAder_id());
        aderId.f39133a.title = ssdAdInfo.getTitle();
        aderId.f39133a.desc = ssdAdInfo.getContent();
        i.a interactionType = aderId.setInteractionType(ssdAdInfo.getTarget_type());
        interactionType.f39133a.f39132a = ssdAdInfo.getWidth();
        interactionType.f39133a.b = ssdAdInfo.getHeight();
        i.a drawing = interactionType.setDrawing(ssdAdInfo.getDrawing());
        drawing.f39133a.z = ssdAdInfo.isVideoAutoPlay();
        drawing.f39133a.A = ssdAdInfo.isVideoMute();
        drawing.f39133a.getClass();
        i.a dUrl = drawing.setDUrl(ssdAdInfo.getdUrl());
        dUrl.f39133a.appName = ssdAdInfo.getApp_name();
        i.a dp_succ = dUrl.setIcon(ssdAdInfo.getIcon()).setScore(ssdAdInfo.getScore()).setDeveloper(ssdAdInfo.getDeveloper()).setAppIntro(ssdAdInfo.getApp_intro()).setAppFeature(ssdAdInfo.getApp_feature()).setPaymentTypes(ssdAdInfo.getPayment_types()).setAppSize(ssdAdInfo.getApp_size()).setAppVer(ssdAdInfo.getApp_ver()).setAppPrivacy(ssdAdInfo.getApp_privacy()).setPrivacyAgreement(ssdAdInfo.getPrivacy_agreement()).setDeepLink(ssdAdInfo.getDeep_link()).setWx_username(ssdAdInfo.getWx_username()).setWx_path(ssdAdInfo.getWx_path()).setWxStart(ssdAdInfo.getWx_start()).setWxSuccess(ssdAdInfo.getWx_succ()).setWxFail(ssdAdInfo.getWx_fail()).setMonitorUrl(ssdAdInfo.getMonitorUrl()).setResponUrl(ssdAdInfo.getResponUrl()).setClickUrl(ssdAdInfo.getClickUrl()).setDn_start(ssdAdInfo.getDn_start()).setDn_succ(ssdAdInfo.getDn_succ()).setDn_inst_start(ssdAdInfo.getDn_inst_start()).setDn_inst_succ(ssdAdInfo.getDn_inst_succ()).setDn_active(ssdAdInfo.getDn_active()).setDp_start(ssdAdInfo.getDp_start()).setDp_fail(ssdAdInfo.getDp_fail()).setDp_succ(ssdAdInfo.getDp_succ());
        dp_succ.f39133a.j = ssdAdInfo.getVideo_start();
        dp_succ.f39133a.k = ssdAdInfo.getVideo_one_quarter();
        dp_succ.f39133a.l = ssdAdInfo.getVideo_one_half();
        dp_succ.f39133a.m = ssdAdInfo.getVideo_three_quarter();
        dp_succ.f39133a.n = ssdAdInfo.getVideo_complete();
        dp_succ.f39133a.o = ssdAdInfo.getVideo_pause();
        dp_succ.f39133a.p = ssdAdInfo.getVideo_resume();
        dp_succ.f39133a.t = ssdAdInfo.getVideo_skip();
        dp_succ.f39133a.u = ssdAdInfo.getVideo_close();
        dp_succ.f39133a.q = ssdAdInfo.getVideo_mute();
        dp_succ.f39133a.r = ssdAdInfo.getVideo_unmute();
        dp_succ.f39133a.s = ssdAdInfo.getVideo_replay();
        i.a packageName = dp_succ.setImageUrls(ssdAdInfo.getSrcUrls()).setVideo_cover(ssdAdInfo.getVideo_cover()).setClickid(ssdAdInfo.getClickid()).setPackageName(ssdAdInfo.getPackage_name());
        packageName.f39133a.c = ssdAdInfo.getContent();
        packageName.f39133a.d = ssdAdInfo.getAction_text();
        packageName.f39133a.iconUrl = ssdAdInfo.getIcon();
        packageName.f39133a.e = ssdAdInfo.getIcon_title();
        i.a fromLogo = packageName.setFromLogo(ssdAdInfo.getFrom_logo());
        fromLogo.f39133a.f = ssdAdInfo.getFrom();
        i iVar = fromLogo.setFromId(ssdAdInfo.getFrom_id()).setDownNum(ssdAdInfo.getDown_num()).setScore(ssdAdInfo.getScore()).setComments(ssdAdInfo.getComments()).setErrorUrl(ssdAdInfo.getErrorUrl()).setDrawing(ssdAdInfo.getDrawing()).f39133a;
        int creative_type = ssdAdInfo.getCreative_type();
        iVar.adPatternType = creative_type;
        if (creative_type == 1 || creative_type == 11 || creative_type == 12 || creative_type == 13) {
            eVarNewOwnAdNativeWarapper = newOwnAdNativeWarapper(iVar, ssdAdInfo);
        } else if (creative_type == 2) {
            if (ssdAdInfo.getSrcUrls() != null && ssdAdInfo.getSrcUrls().length > 0) {
                iVar.g = ssdAdInfo.getSrcUrls()[0];
            }
            eVarNewOwnAdNativeWarapper = new e(this, iVar);
        } else {
            LogUtil.e(TAG, "不支持的创意类型，类型标识为[" + creative_type + "]");
            eVarNewOwnAdNativeWarapper = newOwnAdNativeWarapper(iVar, ssdAdInfo);
        }
        SdkAdInfo sdkAdInfo = new SdkAdInfo();
        SdkClsUtil.handleOwnSdkCls(sdkAdInfo, getAdType());
        sdkAdInfo.setSdk("SSD");
        sdkAdInfo.setEventUrl(iVar.getEventUrl());
        sdkAdInfo.setAppendInfo(ssdAdInfo.getAppendInfo());
        b bVarCreateDelegate = createDelegate(sdkAdInfo, ssdAdInfo);
        if (bVarCreateDelegate instanceof OwnFeedAdapter) {
            eVarNewOwnAdNativeWarapper.init(this, sdkAdInfo);
            ((OwnFeedAdapter) bVarCreateDelegate).setOwnAdDelegate(eVarNewOwnAdNativeWarapper);
        }
        return bVarCreateDelegate;
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(a.KEY_TOKEN, str);
        super.loadAd(map);
    }
}
