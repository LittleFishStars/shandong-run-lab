package com.kc.dw.core.loader.serverbidding;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.comm.managers.GDTAdSdk;
import com.tencent.mm.opensdk.constants.Build;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class S2SBUtil {
    private static Gson gson = new Gson();

    private static GDTS2sbBean generateGdt(Context context, S2sbCacheEntity.S2SBDataBean s2SBDataBean) {
        if (TextUtils.isEmpty(AdSdk.getGDTVersionName())) {
            return null;
        }
        GDTAdSdk.init(context, s2SBDataBean.getAppId());
        String buyerId = GDTAdSdk.getGDTAdManger().getBuyerId((Map) null);
        String sDKInfo = GDTAdSdk.getGDTAdManger().getSDKInfo(s2SBDataBean.getPid());
        GDTS2sbBean gDTS2sbBean = new GDTS2sbBean();
        gDTS2sbBean.setApp_id(s2SBDataBean.getAppId());
        gDTS2sbBean.setBuyer_id(buyerId);
        gDTS2sbBean.setPid(s2SBDataBean.getPid());
        gDTS2sbBean.setSdk_info(sDKInfo);
        gDTS2sbBean.setSdk(s2SBDataBean.getPlatform());
        if (!TextUtils.isEmpty(a.adConfig().getWxAppid())) {
            try {
                Object objNewInstance = Build.class.newInstance();
                Field field = Build.class.getField("SDK_VERSION_NAME");
                field.setAccessible(true);
                gDTS2sbBean.setOpensdk_ver((String) field.get(objNewInstance));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        gDTS2sbBean.setSupport_h265(false);
        gDTS2sbBean.setSupport_splash_zoomout(false);
        return gDTS2sbBean;
    }

    private static KSS2sbBean generateKs(Context context, S2sbCacheEntity.S2SBDataBean s2SBDataBean) {
        try {
            if (TextUtils.isEmpty(AdSdk.getKSVersionName())) {
                return null;
            }
            SdkConfig.Builder builder = new SdkConfig.Builder();
            builder.appId(s2SBDataBean.getAppId()).debug(true);
            KsAdSDK.init(context, builder.build());
            String bidRequestToken = KsAdSDK.getLoadManager().getBidRequestToken(new KsScene.Builder(Long.parseLong(s2SBDataBean.getPid())).build());
            KSS2sbBean kSS2sbBean = new KSS2sbBean();
            kSS2sbBean.setApp_id(s2SBDataBean.getAppId());
            kSS2sbBean.setPid(s2SBDataBean.getPid());
            kSS2sbBean.setSdk(s2SBDataBean.getPlatform());
            kSS2sbBean.setToken(bidRequestToken);
            return kSS2sbBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getS2SBJson(Context context, S2sbCacheEntity s2sbCacheEntity) {
        List<S2sbCacheEntity.S2SBDataBean> s2sbList;
        Object objGenerateKs;
        try {
            ArrayList arrayList = new ArrayList();
            if (s2sbCacheEntity == null || (s2sbList = s2sbCacheEntity.getS2sbList()) == null) {
                return null;
            }
            for (int i = 0; i < s2sbList.size(); i++) {
                S2sbCacheEntity.S2SBDataBean s2SBDataBean = s2sbList.get(i);
                if (s2SBDataBean != null && s2SBDataBean.isValid()) {
                    if ("GDT".equals(s2SBDataBean.getPlatform())) {
                        objGenerateKs = generateGdt(context, s2SBDataBean);
                        if (objGenerateKs != null) {
                            arrayList.add(objGenerateKs);
                        }
                    } else if ("KS".equals(s2SBDataBean.getPlatform()) && (objGenerateKs = generateKs(context, s2SBDataBean)) != null) {
                        arrayList.add(objGenerateKs);
                    }
                }
            }
            return gson.toJson(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
