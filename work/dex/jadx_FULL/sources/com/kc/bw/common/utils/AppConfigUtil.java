package com.kc.bw.common.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.common.bean.AppConfigRespBean;
import com.kc.bw.common.bean.Appconfig;
import com.kc.bw.common.bean.MediaAdSlotIdConfig;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AppConfigUtil {
    public static final String TAG = "AppConfigUtil";
    public static volatile AppConfigUtil appConfigUtil;

    public static AppConfigUtil getInstance() {
        if (appConfigUtil == null) {
            synchronized (AppConfigUtil.class) {
                try {
                    if (appConfigUtil == null) {
                        appConfigUtil = new AppConfigUtil();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return appConfigUtil;
    }

    public static void reportErrorInfo(Context context, String str, Throwable th) {
        ReportUtils.exReport(context, 999961, dexg.dexa("睭東轔殙ꆎ辯鰼懚楲鵦"), str + (th != null ? th.toString() : ""));
    }

    public static void updateAppConfig(Appconfig appconfig) {
        DebugLog.common_weak(dexg.dexa("vqebuf!dgh"));
        ConstantInfo.Config.adLogoUrl = appconfig.getCornerLogo();
        ConstantInfo.Config.adTextLogoUrl = appconfig.getCornerLogoAd();
        ConstantInfo.Config.trackEventRatio = appconfig.getTrackeventRatio();
        ConstantInfo.Config.setEnableStrictInterceptQuickApp(appconfig.getShieldFastappOnOff() != 0);
        List<String> shieldFastappSensitiveWords = appconfig.getShieldFastappSensitiveWords();
        if (shieldFastappSensitiveWords != null && !shieldFastappSensitiveWords.isEmpty()) {
            ConstantInfo.Config.quickAppSchemes.addAll(shieldFastappSensitiveWords);
        }
        List<String> shieldFastappSensitiveWordsContent = appconfig.getShieldFastappSensitiveWordsContent();
        if (shieldFastappSensitiveWordsContent != null && !shieldFastappSensitiveWordsContent.isEmpty()) {
            ConstantInfo.Config.quickAppContentSchemes = shieldFastappSensitiveWordsContent;
        }
        if (appconfig.getCheckDPObj() != null) {
            ConstantInfo.Config.schemeMap = appconfig.getCheckDPObj().getSchemeMap();
            ConstantInfo.Config.appWakeupCheckDuration = appconfig.getCheckDPObj().getCheckDuration();
        }
    }

    public AppConfigRespBean getAppConfig(Context context) {
        try {
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexg.dexa("nn`tq`l2"));
            if (!TextUtils.isEmpty(preferencesString)) {
                return (AppConfigRespBean) GsonUtils.getInstance().fromJson(preferencesString, AppConfigRespBean.class);
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexg.dexa("bqq!dpogjhvsbujpo!sfbe!gbjmfe-") + th);
            reportErrorInfo(context, dexg.dexa("滕蕩ꆎ辯鰼搗楲鵦)hfuBqqDpogjh*-"), th);
        }
        return null;
    }

    public MediaAdSlotIdConfig getMediaAdSlotConfigByAdSlotId(AppConfigRespBean appConfigRespBean, String str) {
        ThreadUtils.isUIThread(dexg.dexa("BqqDpogjhVujm.hfuNfejbBeTmpuDpogjhCzBeTmpuJe"));
        if (appConfigRespBean != null) {
            try {
                for (MediaAdSlotIdConfig mediaAdSlotIdConfig : appConfigRespBean.getAppConfig().getAdslotIdsConfig()) {
                    if (mediaAdSlotIdConfig.getSdkAdslotId().equals(str)) {
                        return mediaAdSlotIdConfig;
                    }
                }
            } catch (Throwable th) {
                DebugLog.release_e(TAG, dexg.dexa("beTmpu!dpogjhvsbujpo!sfbe!gbjmfe-") + th);
                reportErrorInfo(ContextContainer.getApplicationContext(), dexg.dexa("弤衂徎ꆎ辯鰼搗楲鵦)hfuNfejbBeTmpuDpogjhCzBeTmpuJe*�beTmpuJe>") + str + dexg.dexa(c49.f40900a), th);
            }
        }
        return null;
    }

    public void saveAppConfig(Context context, AppConfigRespBean appConfigRespBean) {
        try {
            saveAppConfig(context, GsonUtils.getInstance().toJson(appConfigRespBean));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.common_e(dexg.dexa("nfejb!dpogjh!tbwf!gbjmfe-") + stackTraceString);
            ReportUtils.exReport(context, 200019, dexg.dexa("TEL扞樌捗櫓徔ꆎ辯���殙楲鵦"), stackTraceString);
        }
    }

    public void saveAppConfig(Context context, String str) {
        try {
            ConstantInfo.Config.mediaConfigCreateTime = System.currentTimeMillis();
            SharedPreferencesHelper.getInstance(context).savePreferencesString(dexg.dexa("nn`tq`l2"), str);
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.common_e(dexg.dexa("nfejb!dpogjh)tus*!tbwf!gbjmfe-") + stackTraceString);
            ReportUtils.exReport(context, 200019, dexg.dexa("TEL扞樌捗櫓徔ꆎ辯���殙楲鵦"), stackTraceString);
        }
    }
}
