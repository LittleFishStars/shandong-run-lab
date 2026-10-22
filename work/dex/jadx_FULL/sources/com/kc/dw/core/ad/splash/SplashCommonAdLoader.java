package com.kc.dw.core.ad.splash;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.ad.splash.d;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.utils.SdkClsUtil;
import com.kc.dw.own.splash.OwnSplashAdapter;
import com.kc.dw.platform.ad_adapter.splash.j;
import com.kc.dw.platform.custom.PlatfromFactory;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SplashCommonAdLoader extends a<SplashAdLoadListener> {
    public static final String KEY_AUTO_SHOW = "KEY_AUTO_SHOW";
    public static final String KEY_SKIP_BUTTON = "KEY_SKIP_BUTTON";
    private static final String TAG = "SplashCommonAdLoader";
    public ViewGroup adContainer;
    public int fetchDelay;
    public boolean isHideSkipBtn;
    public boolean isLoadAndShow;
    public boolean isVideoMute = true;

    @Override // com.kc.dw.core.loader.a
    public b createDelegate(SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        if (sdkAdInfo == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getCls())) {
                return null;
            }
            MsCustomSplashAdapter msCustomSplashAdapterSplashLoader = PlatfromFactory.getCustomPlatfrom().splashLoader(this, sdkAdInfo, ssdAdInfo);
            msCustomSplashAdapterSplashLoader.init(this, sdkAdInfo);
            return msCustomSplashAdapterSplashLoader;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.loader.a
    public b createOwnAdDelegate(Context context, SsdAdInfo ssdAdInfo) {
        d.a packageName = new d.a(new d()).setAppId(com.kc.dw.base.a.adConfig().appId()).setWxAppId(ssdAdInfo.getWx_appid()).setScaleType(ssdAdInfo.getScale_type()).setEventUrl(ssdAdInfo.getEventUrl()).setWinUrl(ssdAdInfo.getWinUrl()).setLossUrl(ssdAdInfo.getLossUrl()).setActionDesc(ssdAdInfo.getAction_desc()).setScheme(ssdAdInfo.getScheme()).setDynamicMap(ssdAdInfo.getDynamicMap()).setFieldExport(ssdAdInfo.getFieldExport()).setAdg(ssdAdInfo.getAdg()).setAdp(ssdAdInfo.getAdp()).setDefaultCoord(ssdAdInfo.getDefault_coord()).setDpSign(ssdAdInfo.getDpsign()).setActExt(ssdAdInfo.getAct_ext()).setUob(ssdAdInfo.getUob()).setDPSIGN(ssdAdInfo.getDPSIGN()).setLoadedTime(ssdAdInfo.getLoadedTime()).setExpireTimestamp(ssdAdInfo.getExpire_timestamp()).setEcpm(ssdAdInfo.getEcpm()).setDClickData(ssdAdInfo.getDclk()).setActType(ssdAdInfo.getAct_type()).setAdType(ssdAdInfo.getAd_type()).setCBC(ssdAdInfo.getCbc()).setNOP(ssdAdInfo.getNop()).setS_code(ssdAdInfo.getS_code()).setS_ext(ssdAdInfo.getS_ext()).setReqId(ssdAdInfo.getReq_id()).setFromId(ssdAdInfo.getFrom_id()).setDirectMarket(ssdAdInfo.getDirect_market()).setPackageName(ssdAdInfo.getPackage_name());
        packageName.f39170a.I = ssdAdInfo.getIs_eyes();
        d.a appIntroUrl = packageName.setPosId(ssdAdInfo.getPid()).setPermissionUrl(ssdAdInfo.getApp_permission_url()).setPermisssList(ssdAdInfo.getApp_permission()).setAppIntroUrl(ssdAdInfo.getApp_intor_url());
        appIntroUrl.f39170a.E = ssdAdInfo.getClk_type();
        appIntroUrl.f39170a.F = ssdAdInfo.getClk_area();
        d.a clickType = appIntroUrl.setClickType(ssdAdInfo.getClk_type());
        clickType.f39170a.G = ssdAdInfo.getPower_index();
        d.a powerIndex2 = clickType.setPowerIndex2(ssdAdInfo.getPower_index2());
        powerIndex2.f39170a.H = ssdAdInfo.getPower_type();
        d.a dp_succ = powerIndex2.setPowerCount(ssdAdInfo.getPower_count()).setPowerDelay(ssdAdInfo.getPower_delay()).setCid(ssdAdInfo.getCid()).setCat(ssdAdInfo.getCat()).setAderId(ssdAdInfo.getAder_id()).setImageUrls(ssdAdInfo.getSrcUrls()).setInteractionType(ssdAdInfo.getTarget_type()).setDUrl(ssdAdInfo.getdUrl()).setAppName(ssdAdInfo.getApp_name()).setIcon(ssdAdInfo.getIcon()).setScore(ssdAdInfo.getScore()).setDeveloper(ssdAdInfo.getDeveloper()).setAppIntro(ssdAdInfo.getApp_intro()).setAppFeature(ssdAdInfo.getApp_feature()).setPaymentTypes(ssdAdInfo.getPayment_types()).setAppSize(ssdAdInfo.getApp_size()).setAppVer(ssdAdInfo.getApp_ver()).setAppPrivacy(ssdAdInfo.getApp_privacy()).setPrivacyAgreement(ssdAdInfo.getPrivacy_agreement()).setDeepLink(ssdAdInfo.getDeep_link()).setWx_username(ssdAdInfo.getWx_username()).setWx_path(ssdAdInfo.getWx_path()).setWxStart(ssdAdInfo.getWx_start()).setWxSuccess(ssdAdInfo.getWx_succ()).setWxFail(ssdAdInfo.getWx_fail()).setMonitorUrl(ssdAdInfo.getMonitorUrl()).setResponUrl(ssdAdInfo.getResponUrl()).setClickUrl(ssdAdInfo.getClickUrl()).setDn_start(ssdAdInfo.getDn_start()).setDn_succ(ssdAdInfo.getDn_succ()).setDn_inst_start(ssdAdInfo.getDn_inst_start()).setDn_inst_succ(ssdAdInfo.getDn_inst_succ()).setDn_active(ssdAdInfo.getDn_active()).setDp_start(ssdAdInfo.getDp_start()).setDp_fail(ssdAdInfo.getDp_fail()).setDp_succ(ssdAdInfo.getDp_succ());
        dp_succ.f39170a.j = ssdAdInfo.getVideo_start();
        dp_succ.f39170a.k = ssdAdInfo.getVideo_one_quarter();
        dp_succ.f39170a.l = ssdAdInfo.getVideo_one_half();
        dp_succ.f39170a.m = ssdAdInfo.getVideo_three_quarter();
        dp_succ.f39170a.n = ssdAdInfo.getVideo_complete();
        dp_succ.f39170a.o = ssdAdInfo.getVideo_pause();
        dp_succ.f39170a.p = ssdAdInfo.getVideo_resume();
        dp_succ.f39170a.q = ssdAdInfo.getVideo_mute();
        dp_succ.f39170a.r = ssdAdInfo.getVideo_unmute();
        dp_succ.f39170a.s = ssdAdInfo.getVideo_replay();
        d.a video_cover = dp_succ.setVideo_cover(ssdAdInfo.getVideo_cover());
        video_cover.f39170a.h = ssdAdInfo.getVideo_endcover();
        long video_keep_time = ssdAdInfo.getVideo_keep_time();
        video_cover.f39170a.i = Long.valueOf(video_keep_time).longValue();
        d dVar = video_cover.setClickid(ssdAdInfo.getClickid()).setFromLogo(ssdAdInfo.getFrom_logo()).setDrawing(ssdAdInfo.getDrawing()).setTitle(ssdAdInfo.getTitle()).setDesc(ssdAdInfo.getContent()).setIconUrl(ssdAdInfo.getIcon()).setAdPatternType(ssdAdInfo.getCreative_type()).setErrorUrl(ssdAdInfo.getErrorUrl()).setRs(ssdAdInfo.getRs()).setDefImage(ssdAdInfo.getDefImage()).setMaterialTimeout(ssdAdInfo.getMaterialTimeout()).f39170a;
        if (ssdAdInfo.getCreative_type() == 2 && ssdAdInfo.getSrcUrls() != null && ssdAdInfo.getSrcUrls().length > 0) {
            dVar.g = ssdAdInfo.getSrcUrls()[0];
        }
        j jVar = new j(this, dVar);
        SdkAdInfo sdkAdInfo = new SdkAdInfo();
        SdkClsUtil.handleOwnSdkCls(sdkAdInfo, getAdType());
        sdkAdInfo.setSdk("SSD");
        sdkAdInfo.setEventUrl(dVar.getEventUrl());
        sdkAdInfo.setAppendInfo(ssdAdInfo.getAppendInfo());
        b bVarCreateDelegate = createDelegate(sdkAdInfo, ssdAdInfo);
        if (bVarCreateDelegate instanceof OwnSplashAdapter) {
            jVar.init(this, sdkAdInfo);
            ((OwnSplashAdapter) bVarCreateDelegate).setSplashAdDelegate(jVar);
        }
        return bVarCreateDelegate;
    }

    public ViewGroup getAdContainer() {
        return this.adContainer;
    }

    @Override // com.kc.dw.core.loader.a
    public int getFetchDelay() {
        return this.fetchDelay;
    }

    public boolean getIsHideSkipBtn() {
        return this.isHideSkipBtn;
    }

    public boolean getIsLoadAndShow() {
        return this.isLoadAndShow;
    }

    public boolean getVideoIsMute() {
        return this.isVideoMute;
    }

    @Override // com.kc.dw.core.loader.a, com.kc.dw.core.loader.IAdLoader
    public void loadAd() {
        loadAd((View) null);
    }

    public void loadAd(View view) {
        HashMap map = new HashMap();
        map.put(KEY_SKIP_BUTTON, view);
        map.put(KEY_AUTO_SHOW, Boolean.FALSE);
        super.loadAd(map);
    }

    public void loadAd(View view, String str) {
        HashMap map = new HashMap();
        map.put(KEY_SKIP_BUTTON, view);
        map.put(KEY_AUTO_SHOW, Boolean.FALSE);
        map.put(a.KEY_TOKEN, str);
        super.loadAd(map);
    }

    public void loadAd(String str) {
        loadAd((View) null, str);
    }
}
