package com.kc.dw.core.ad.interstitial;

import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.utils.SdkClsUtil;
import com.kc.dw.own.intertitial.OwnIntertitialAdapter;
import com.kc.dw.platform.custom.PlatfromFactory;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class InterstitialCommonAdLoader extends a<InterstitialAdLoadListener> {
    public static final String KEY_HEIGHT = "KEY_HEIGHT";
    public static final String KEY_WIDTH = "KEY_WIDTH";
    private static final String TAG = "InterstitialCommonAdLoader";
    public boolean isClickToClose;
    public boolean isVideoAutoPlay;

    @Override // com.kc.dw.core.loader.a
    public b createDelegate(SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        if (sdkAdInfo == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
                return null;
            }
            MsCustomInterstitialAdapter msCustomInterstitialAdapterInterstitialLoader = PlatfromFactory.getCustomPlatfrom().interstitialLoader(this, sdkAdInfo, ssdAdInfo);
            msCustomInterstitialAdapterInterstitialLoader.init(this, sdkAdInfo);
            return msCustomInterstitialAdapterInterstitialLoader;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.loader.a
    public b createOwnAdDelegate(Context context, SsdAdInfo ssdAdInfo) {
        com.kc.dw.ad.interstitial.b.a interactionType = new com.kc.dw.ad.interstitial.b.a(new com.kc.dw.ad.interstitial.b()).setAppId(com.kc.dw.base.a.adConfig().appId()).setWxAppId(ssdAdInfo.getWx_appid()).setScaleType(ssdAdInfo.getScale_type()).setEventUrl(ssdAdInfo.getEventUrl()).setWinUrl(ssdAdInfo.getWinUrl()).setLossUrl(ssdAdInfo.getLossUrl()).setActionDesc(ssdAdInfo.getAction_desc()).setScheme(ssdAdInfo.getScheme()).setVideo_cover(ssdAdInfo.getVideo_cover()).setDynamicMap(ssdAdInfo.getDynamicMap()).setFieldExport(ssdAdInfo.getFieldExport()).setAdg(ssdAdInfo.getAdg()).setAdp(ssdAdInfo.getAdp()).setDefaultCoord(ssdAdInfo.getDefault_coord()).setDpSign(ssdAdInfo.getDpsign()).setActExt(ssdAdInfo.getAct_ext()).setUob(ssdAdInfo.getUob()).setDPSIGN(ssdAdInfo.getDPSIGN()).setLoadedTime(ssdAdInfo.getLoadedTime()).setClickType(ssdAdInfo.getClk_type()).setPowerIndex(ssdAdInfo.getPower_index()).setPowerIndex2(ssdAdInfo.getPower_index2()).setPowerDelay(ssdAdInfo.getPower_delay()).setPowerCount(ssdAdInfo.getPower_count()).setExpireTimestamp(ssdAdInfo.getExpire_timestamp()).setEcpm(ssdAdInfo.getEcpm()).setDClickData(ssdAdInfo.getDclk()).setActType(ssdAdInfo.getAct_type()).setAdType(ssdAdInfo.getAd_type()).setCBC(ssdAdInfo.getCbc()).setNOP(ssdAdInfo.getNop()).setS_code(ssdAdInfo.getS_code()).setS_ext(ssdAdInfo.getS_ext()).setReqId(ssdAdInfo.getReq_id()).setFromId(ssdAdInfo.getFrom_id()).setDirectMarket(ssdAdInfo.getDirect_market()).setPackageName(ssdAdInfo.getPackage_name()).setPosId(ssdAdInfo.getPid()).setPermissionUrl(ssdAdInfo.getApp_permission_url()).setPermisssList(ssdAdInfo.getApp_permission()).setAppIntroUrl(ssdAdInfo.getApp_intor_url()).setCid(ssdAdInfo.getCid()).setCat(ssdAdInfo.getCat()).setAderId(ssdAdInfo.getAder_id()).setImageUrls(ssdAdInfo.getSrcUrls()).setInteractionType(ssdAdInfo.getTarget_type());
        ssdAdInfo.getWidth();
        interactionType.f39095a.getClass();
        ssdAdInfo.getHeight();
        interactionType.f39095a.getClass();
        ssdAdInfo.getInsert_style();
        interactionType.f39095a.getClass();
        com.kc.dw.ad.interstitial.b.a errorUrl = interactionType.setDUrl(ssdAdInfo.getdUrl()).setAppName(ssdAdInfo.getApp_name()).setIcon(ssdAdInfo.getIcon()).setScore(ssdAdInfo.getScore()).setDeveloper(ssdAdInfo.getDeveloper()).setAppIntro(ssdAdInfo.getApp_intro()).setAppFeature(ssdAdInfo.getApp_feature()).setPaymentTypes(ssdAdInfo.getPayment_types()).setAppSize(ssdAdInfo.getApp_size()).setAppVer(ssdAdInfo.getApp_ver()).setAppPrivacy(ssdAdInfo.getApp_privacy()).setPrivacyAgreement(ssdAdInfo.getPrivacy_agreement()).setDeepLink(ssdAdInfo.getDeep_link()).setWx_username(ssdAdInfo.getWx_username()).setWx_path(ssdAdInfo.getWx_path()).setWxStart(ssdAdInfo.getWx_start()).setWxSuccess(ssdAdInfo.getWx_succ()).setWxFail(ssdAdInfo.getWx_fail()).setMonitorUrl(ssdAdInfo.getMonitorUrl()).setResponUrl(ssdAdInfo.getResponUrl()).setClickUrl(ssdAdInfo.getClickUrl()).setDn_start(ssdAdInfo.getDn_start()).setDn_succ(ssdAdInfo.getDn_succ()).setDn_inst_start(ssdAdInfo.getDn_inst_start()).setDn_inst_succ(ssdAdInfo.getDn_inst_succ()).setDn_active(ssdAdInfo.getDn_active()).setDp_start(ssdAdInfo.getDp_start()).setDp_fail(ssdAdInfo.getDp_fail()).setDp_succ(ssdAdInfo.getDp_succ()).setClickid(ssdAdInfo.getClickid()).setFromLogo(ssdAdInfo.getFrom_logo()).setDrawing(ssdAdInfo.getDrawing()).setAdPatternType(ssdAdInfo.getCreative_type()).setErrorUrl(ssdAdInfo.getErrorUrl());
        ssdAdInfo.getAction_text();
        errorUrl.f39095a.getClass();
        errorUrl.f39095a.f39094a = ssdAdInfo.getTitle();
        com.kc.dw.ad.interstitial.b bVar = errorUrl.setDesc(ssdAdInfo.getContent()).setIconUrl(ssdAdInfo.getIcon()).f39095a;
        com.kc.dw.platform.ad_adapter.interstitial.b bVar2 = new com.kc.dw.platform.ad_adapter.interstitial.b(this, bVar);
        SdkAdInfo sdkAdInfo = new SdkAdInfo();
        SdkClsUtil.handleOwnSdkCls(sdkAdInfo, getAdType());
        sdkAdInfo.setSdk("SSD");
        sdkAdInfo.setEventUrl(bVar.getEventUrl());
        sdkAdInfo.setAppendInfo(ssdAdInfo.getAppendInfo());
        b bVarCreateDelegate = createDelegate(sdkAdInfo, ssdAdInfo);
        if (bVarCreateDelegate instanceof OwnIntertitialAdapter) {
            bVar2.init(this, sdkAdInfo);
            ((OwnIntertitialAdapter) bVarCreateDelegate).setOwnAdDelegate(bVar2);
        }
        return bVarCreateDelegate;
    }

    public boolean getIsClickToClose() {
        return this.isClickToClose;
    }

    public boolean getIsVideoAutoPlay() {
        return this.isVideoAutoPlay;
    }

    public void loadAd(float f, float f2) {
        HashMap map = new HashMap();
        map.put("KEY_WIDTH", Float.valueOf(f));
        map.put("KEY_HEIGHT", Float.valueOf(f2));
        loadAd(map);
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(a.KEY_TOKEN, str);
        super.loadAd(map);
    }
}
