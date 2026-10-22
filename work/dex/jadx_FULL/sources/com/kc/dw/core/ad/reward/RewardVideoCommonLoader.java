package com.kc.dw.core.ad.reward;

import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.activity.SsdRewardH5Activity;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.b;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.utils.SdkClsUtil;
import com.kc.dw.own.reward.OwnRewardAdapter;
import com.kc.dw.platform.ad_adapter.reward.c;
import com.kc.dw.platform.custom.PlatfromFactory;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RewardVideoCommonLoader extends b<RewardAdLoadListener> {
    private static final String TAG = "RewardVideoCommonLoader";
    public com.kc.dw.core.loader.b adDelegate = null;

    @Override // com.kc.dw.core.loader.a
    public com.kc.dw.core.loader.b createDelegate(SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        if (sdkAdInfo == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
                return null;
            }
            MsCustomRewardAdapter msCustomRewardAdapterRewardLoader = PlatfromFactory.getCustomPlatfrom().rewardLoader(this, sdkAdInfo, ssdAdInfo);
            msCustomRewardAdapterRewardLoader.init(this, sdkAdInfo);
            return msCustomRewardAdapterRewardLoader;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.loader.a
    public com.kc.dw.core.loader.b createOwnAdDelegate(Context context, SsdAdInfo ssdAdInfo) {
        i.a aderId = new i.a(new i()).setAppId(a.adConfig().appId()).setWxAppId(ssdAdInfo.getWx_appid()).setScaleType(ssdAdInfo.getScale_type()).setEventUrl(ssdAdInfo.getEventUrl()).setWinUrl(ssdAdInfo.getWinUrl()).setLossUrl(ssdAdInfo.getLossUrl()).setActionDesc(ssdAdInfo.getAction_desc()).setScheme(ssdAdInfo.getScheme()).setDynamicMap(ssdAdInfo.getDynamicMap()).setFieldExport(ssdAdInfo.getFieldExport()).setAdg(ssdAdInfo.getAdg()).setAdp(ssdAdInfo.getAdp()).setDefaultCoord(ssdAdInfo.getDefault_coord()).setDpSign(ssdAdInfo.getDpsign()).setActExt(ssdAdInfo.getAct_ext()).setUob(ssdAdInfo.getUob()).setDPSIGN(ssdAdInfo.getDPSIGN()).setRewardTmpTime(ssdAdInfo.getReward_tmp_time()).setRewardTmpType(ssdAdInfo.getReward_tmp_type()).setRewardTmpUrl(ssdAdInfo.getReward_tmp_url()).setRewardTmpId(ssdAdInfo.getRewardTmpId()).setLoadedTime(ssdAdInfo.getLoadedTime()).setClickType(ssdAdInfo.getClk_type()).setPowerCount(ssdAdInfo.getPower_count()).setPowerDelay(ssdAdInfo.getPower_delay()).setPowerIndex(ssdAdInfo.getPower_index()).setPowerIndex2(ssdAdInfo.getPower_index2()).setExpireTimestamp(ssdAdInfo.getExpire_timestamp()).setEcpm(ssdAdInfo.getEcpm()).setDClickData(ssdAdInfo.getDclk()).setActType(ssdAdInfo.getAct_type()).setAdType(ssdAdInfo.getAd_type()).setCBC(ssdAdInfo.getCbc()).setNOP(ssdAdInfo.getNop()).setS_code(ssdAdInfo.getS_code()).setS_ext(ssdAdInfo.getS_ext()).setReqId(ssdAdInfo.getReq_id()).setFromId(ssdAdInfo.getFrom_id()).setDirectMarket(ssdAdInfo.getDirect_market()).setPackageName(ssdAdInfo.getPackage_name()).setPosId(ssdAdInfo.getPid()).setPermissionUrl(ssdAdInfo.getApp_permission_url()).setPermisssList(ssdAdInfo.getApp_permission()).setAppIntroUrl(ssdAdInfo.getApp_intor_url()).setCid(ssdAdInfo.getCid()).setCat(ssdAdInfo.getCat()).setAderId(ssdAdInfo.getAder_id());
        aderId.f39133a.title = ssdAdInfo.getTitle();
        aderId.f39133a.desc = ssdAdInfo.getContent();
        aderId.f39133a.iconUrl = ssdAdInfo.getIcon();
        i.a interactionType = aderId.setInteractionType(ssdAdInfo.getTarget_type());
        interactionType.f39133a.f39132a = ssdAdInfo.getWidth();
        interactionType.f39133a.b = ssdAdInfo.getHeight();
        i.a video_cover = interactionType.setDUrl(ssdAdInfo.getdUrl()).setVideo_cover(ssdAdInfo.getVideo_cover());
        video_cover.f39133a.h = ssdAdInfo.getVideo_endcover();
        video_cover.f39133a.i = ssdAdInfo.getVideo_keep_time();
        video_cover.f39133a.appName = ssdAdInfo.getApp_name();
        i.a dp_succ = video_cover.setIcon(ssdAdInfo.getIcon()).setScore(ssdAdInfo.getScore()).setDeveloper(ssdAdInfo.getDeveloper()).setAppIntro(ssdAdInfo.getApp_intro()).setAppFeature(ssdAdInfo.getApp_feature()).setPaymentTypes(ssdAdInfo.getPayment_types()).setAppSize(ssdAdInfo.getApp_size()).setAppVer(ssdAdInfo.getApp_ver()).setAppPrivacy(ssdAdInfo.getApp_privacy()).setPrivacyAgreement(ssdAdInfo.getPrivacy_agreement()).setDeepLink(ssdAdInfo.getDeep_link()).setWx_username(ssdAdInfo.getWx_username()).setWx_path(ssdAdInfo.getWx_path()).setWxStart(ssdAdInfo.getWx_start()).setWxSuccess(ssdAdInfo.getWx_succ()).setWxFail(ssdAdInfo.getWx_fail()).setMonitorUrl(ssdAdInfo.getMonitorUrl()).setResponUrl(ssdAdInfo.getResponUrl()).setClickUrl(ssdAdInfo.getClickUrl()).setDn_start(ssdAdInfo.getDn_start()).setDn_succ(ssdAdInfo.getDn_succ()).setDn_inst_start(ssdAdInfo.getDn_inst_start()).setDn_inst_succ(ssdAdInfo.getDn_inst_succ()).setDn_active(ssdAdInfo.getDn_active()).setDp_start(ssdAdInfo.getDp_start()).setDp_fail(ssdAdInfo.getDp_fail()).setDp_succ(ssdAdInfo.getDp_succ());
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
        i.a clickid = dp_succ.setImageUrls(ssdAdInfo.getSrcUrls()).setClickid(ssdAdInfo.getClickid());
        clickid.f39133a.d = ssdAdInfo.getAction_text();
        i.a drawing = clickid.setFromLogo(ssdAdInfo.getFrom_logo()).setDrawing(ssdAdInfo.getDrawing());
        drawing.f39133a.v = ssdAdInfo.getClickable_range();
        drawing.f39133a.w = ssdAdInfo.getClose_btn();
        drawing.f39133a.c = ssdAdInfo.getContent();
        i.a errorUrl = drawing.setErrorUrl(ssdAdInfo.getErrorUrl());
        errorUrl.f39133a.title = ssdAdInfo.getTitle();
        errorUrl.f39133a.desc = ssdAdInfo.getContent();
        errorUrl.f39133a.iconUrl = ssdAdInfo.getIcon();
        i iVar = errorUrl.setH5Url(ssdAdInfo.getH5_url()).setH5Ext(ssdAdInfo.getH5_ext()).f39133a;
        int creative_type = ssdAdInfo.getCreative_type();
        iVar.adPatternType = creative_type;
        if (creative_type != 2) {
            iVar.setImageUrls(ssdAdInfo.getSrcUrls());
        } else if (ssdAdInfo.getSrcUrls() != null && ssdAdInfo.getSrcUrls().length > 0) {
            iVar.g = ssdAdInfo.getSrcUrls()[0];
        }
        this.adDelegate = createOwnAdDelegateInternal(iVar);
        SdkAdInfo sdkAdInfo = new SdkAdInfo();
        SdkClsUtil.handleOwnSdkCls(sdkAdInfo, getAdType());
        sdkAdInfo.setSdk("SSD");
        sdkAdInfo.setEventUrl(iVar.getEventUrl());
        sdkAdInfo.setAppendInfo(ssdAdInfo.getAppendInfo());
        com.kc.dw.core.loader.b bVarCreateDelegate = createDelegate(sdkAdInfo, ssdAdInfo);
        if (bVarCreateDelegate instanceof OwnRewardAdapter) {
            this.adDelegate.init(this, sdkAdInfo);
            ((OwnRewardAdapter) bVarCreateDelegate).setRewardAdDelegate(this.adDelegate);
        }
        return bVarCreateDelegate;
    }

    @Override // com.kc.dw.core.ad.b
    public com.kc.dw.core.loader.b createOwnAdDelegateInternal(i iVar) {
        if (AdSdk.isTestMode) {
            setVideoIsMute(iVar.A);
        }
        return new c(this, iVar);
    }

    @Override // com.kc.dw.core.ad.b, com.kc.dw.core.loader.a, com.kc.dw.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        SsdRewardH5Activity.clear();
        com.kc.dw.core.loader.b bVar = this.adDelegate;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(com.kc.dw.core.loader.a.KEY_TOKEN, str);
        super.loadAd(map);
    }
}
