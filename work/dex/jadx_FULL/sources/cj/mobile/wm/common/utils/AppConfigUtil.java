package cj.mobile.wm.common.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.common.bean.AppConfigRespBean;
import cj.mobile.wm.common.bean.Appconfig;
import cj.mobile.wm.common.bean.MediaAdSlotIdConfig;
import cj.mobile.wm.dexc;
import com.zj.adlib.c49;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppConfigUtil {
    public static final String TAG = "AppConfigUtil";
    public static volatile AppConfigUtil appConfigUtil;

    public static AppConfigUtil getInstance() {
        if (appConfigUtil == null) {
            synchronized (AppConfigUtil.class) {
                if (appConfigUtil == null) {
                    appConfigUtil = new AppConfigUtil();
                }
            }
        }
        return appConfigUtil;
    }

    public static void reportErrorInfo(Context context, String str, Throwable th) {
        ReportUtils.exReport(context, 999961, dexc.dexa("睭東轔殙ꆎ辯鰼懚楲鵦"), str + (th != null ? th.toString() : ""));
    }

    public static void updateAppConfig(Appconfig appconfig) {
        DebugLog.common_weak(dexc.dexa("vqebuf!dgh"));
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
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l2"));
            if (!TextUtils.isEmpty(preferencesString)) {
                return (AppConfigRespBean) GsonUtils.getInstance().fromJson(preferencesString, AppConfigRespBean.class);
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexc.dexa("bqq!dpogjhvsbujpo!sfbe!gbjmfe-") + th);
            reportErrorInfo(context, dexc.dexa("滕蕩ꆎ辯鰼搗楲鵦)hfuBqqDpogjh*-"), th);
        }
        return null;
    }

    public MediaAdSlotIdConfig getMediaAdSlotConfigByAdSlotId(AppConfigRespBean appConfigRespBean, String str) {
        ThreadUtils.isUIThread(dexc.dexa("BqqDpogjhVujm.hfuNfejbBeTmpuDpogjhCzBeTmpuJe"));
        if (appConfigRespBean != null) {
            try {
                for (MediaAdSlotIdConfig mediaAdSlotIdConfig : appConfigRespBean.getAppConfig().getAdslotIdsConfig()) {
                    if (mediaAdSlotIdConfig.getSdkAdslotId().equals(str)) {
                        return mediaAdSlotIdConfig;
                    }
                }
            } catch (Throwable th) {
                DebugLog.release_e(TAG, dexc.dexa("beTmpu!dpogjhvsbujpo!sfbe!gbjmfe-") + th);
                reportErrorInfo(ContextContainer.getApplicationContext(), dexc.dexa("弤衂徎ꆎ辯鰼搗楲鵦)hfuNfejbBeTmpuDpogjhCzBeTmpuJe*�beTmpuJe>") + str + dexc.dexa(c49.f40900a), th);
            }
        }
        return null;
    }

    public void saveAppConfig(Context context, AppConfigRespBean appConfigRespBean) {
        try {
            saveAppConfig(context, GsonUtils.getInstance().toJson(appConfigRespBean));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.common_e(dexc.dexa("nfejb!dpogjh!tbwf!gbjmfe-") + stackTraceString);
            ReportUtils.exReport(context, 200019, dexc.dexa("TEL扞樌捗櫓徔ꆎ辯���殙楲鵦"), stackTraceString);
        }
    }

    public void saveAppConfig(Context context, String str) {
        try {
            ConstantInfo.Config.mediaConfigCreateTime = System.currentTimeMillis();
            SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l2"), str);
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.common_e(dexc.dexa("nfejb!dpogjh)tus*!tbwf!gbjmfe-") + stackTraceString);
            ReportUtils.exReport(context, 200019, dexc.dexa("TEL扞樌捗櫓徔ꆎ辯���殙楲鵦"), stackTraceString);
        }
    }
}
