package com.kc.bw.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kc.bw.common.bean.FullInstBean;
import com.kc.bw.common.bean.SdkTrackEventBean;
import com.kc.bw.common.bean.WMLocation;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ConstantInfo {
    public static String APP_KEY = null;
    public static String APP_TOKEN = null;
    public static boolean DEBUG = false;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    public static String WX_APP_ID;
    public static WMLocation devWMLocation;
    public static String logsDirPath;
    public static int sdkInitConfigType;
    public static ConcurrentHashMap<String, SdkTrackEventBean> sdkTrackEventMap;
    public static final String VERSION = dexg.dexa("8/8/25/21");
    public static final String INTERCEPT_KEY = dexg.dexa("dpn/xbohnbj");
    public static final String CHANNEL_NAME_WM = dexg.dexa("XN");
    public static final String CHANNEL_NAME_GM = dexg.dexa("HN");
    public static final String CHANNEL_NAME_TO = dexg.dexa("UP");
    public static final String TIME_OUT = dexg.dexa("ujnf`pvu");
    public static final String BID_FAILED_MISSING_PRICE = dexg.dexa("njttjoh`qsjdf");
    public static final String BID_FAILED_MISSING_MEDIA_PRICE = dexg.dexa("njttjoh`nfejb`qsjdf");
    public static final String BID_FAILED_MEDIA_SIDE_PRICE_FILTER = dexg.dexa("nfejb`tjef`qsjdf`gjmufs");
    public static final String BID_FAILED_DEMANDER_SIDE_PRICE_FILTER = dexg.dexa("efnboefs`tjef`qsjdf`gjmufs");
    public static final String BID_FAILED = dexg.dexa("cje`gbjmfe");
    public static float downX = -999.0f;
    public static float downY = -999.0f;
    public static float upX = -999.0f;
    public static float upY = -999.0f;
    public static boolean sdkInitTrackCompleted = false;
    public static long sdkInitStartTime = -1;
    public static long sdkInitEndTime = -1;
    public static long sdkInitCostTime = -1;
    public static int responseSuccessRoundByYLH = 0;
    public static boolean enablePersonalized = true;
    public static boolean enableSensor = true;
    public static String bootMark = "";
    public static String updateMark = "";
    public static String deviceFingerprint = "";
    public static String wmId = "";
    public static boolean canUseLocation = true;
    public static boolean canUsePhoneState = true;
    public static String devImei = "";
    public static boolean canUseOaid = true;
    public static boolean canUseBootId = true;
    public static String devOaid = "";
    public static boolean canUseWifiState = true;
    public static String devMacAddress = "";
    public static boolean canUseNetworkState = true;
    public static boolean canUseWriteExternal = true;
    public static boolean canUseAppList = true;
    public static boolean canUsePermissionRecordAudio = true;
    public static boolean canUseInstallPackages = true;

    @Keep
    public static class AdInfo {
        public static final String CRID = dexg.dexa("dsje");
        public static final String AdTitle = dexg.dexa("beUjumf");
        public static final String AdDescription = dexg.dexa("BeEftdsjqujpo");
        public static final String MaterialUrls = dexg.dexa("nbufsjbmVsmt");
    }

    @Keep
    public static class ClickRegionType {
        public static final int CLICK_REGION_ALL = 0;
        public static final int CLICK_REGION_ALL_COMPONENT = 1;
        public static final int CLICK_REGION_ONLY_COMPONENT = 2;
    }

    @Keep
    public static class Config {
        public static final int AD_DEFAULT_VALID_DURATION = 60;
        public static final String CHANNEL_ROOT_DIR_PATH;
        public static final String CONFIG_DIR_PATH;
        public static int DEFAULT_RECHECK_INTERVAL = 0;
        public static final int INST_CHECK_MAX_LIMIT = 1500;
        public static final int INST_CHECK_TIME_OUT = 100;
        public static final int INST_CHECK_TYPE_ALL = 2;
        public static final int INST_CHECK_TYPE_SCAN = 3;
        public static final int INST_CHECK_TYPE_VISIBLE = 1;
        public static String MM_AD_LOGO_DEFAULT_URL = null;
        public static String MM_REWARD_GIFT_ICON = null;
        public static final String PATCH_DIR_PATH;
        public static int REQUEST_SERVER_BID_BUYER_ID = 0;
        public static int REQUEST_SERVER_BID_LOAD = 0;
        public static int REQUEST_STANDARD_LOAD = 0;
        public static final int REWARD_DEFAULT_DURATION = 20;
        public static List<Integer> VALID_COUNTDOWN_RANGES;
        public static String adLogoUrl;
        public static String adTextLogoUrl;
        public static int appWakeupCheckDuration;
        public static String deliveryInstResult;
        public static boolean enableAdSlotInterceptQuickApp;
        public static boolean enableApkReceiver;
        public static boolean enableStrictInterceptQuickApp;
        public static List<String> filterMaterialIdList;
        public static List<String> filterMaterialKeyWorldList;
        public static FullInstBean fullInstBean;
        public static long mediaConfigCreateTime;
        public static List<String> quickAppContentSchemes;
        public static List<String> quickAppSchemes;
        public static Map<Integer, String> schemeMap;
        public static int trackEventRatio;
        public static final String PREFERENCE_FILE_NAME = dexg.dexa("ldcx/qsfgfsfodft");
        public static final String PREFERENCE_EXT_CONFIG_FILE_NAME = dexg.dexa("ldcx`fyu`dpogjh/qsfgfsfodft");
        public static final String AD_LOADER = dexg.dexa("dpn/ld/cx/be/efy/bmmnpevmft/BeMpbefs");

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(dexg.dexa("ldcx"));
            String str = File.separator;
            sb.append(str);
            CHANNEL_ROOT_DIR_PATH = sb.toString();
            CONFIG_DIR_PATH = dexg.dexa("ldcx") + str + dexg.dexa("dpogjhvsf");
            PATCH_DIR_PATH = dexg.dexa("ldcx") + str + dexg.dexa("qbudi");
            REQUEST_SERVER_BID_BUYER_ID = 1;
            REQUEST_SERVER_BID_LOAD = 2;
            REQUEST_STANDARD_LOAD = 3;
            VALID_COUNTDOWN_RANGES = Arrays.asList(3, 4, 5, 6);
            MM_AD_LOGO_DEFAULT_URL = dexg.dexa("iuuqt;00tubujd/bexbohnbj/dpn0nn`be`mphp/qoh");
            MM_REWARD_GIFT_ICON = dexg.dexa("iuuqt;00utubujd/77npcj/dpn0nn`sfxbse`hjgu`jdpo/qoh");
            DEFAULT_RECHECK_INTERVAL = 10000;
            quickAppSchemes = new ArrayList(Arrays.asList(dexg.dexa("ibq"), dexg.dexa("gbtubqq"), dexg.dexa("ixgbtubqq")));
            enableStrictInterceptQuickApp = false;
            enableAdSlotInterceptQuickApp = false;
        }

        public static boolean isEnableAdSlotInterceptQuickApp() {
            return enableAdSlotInterceptQuickApp;
        }

        public static boolean isEnableStrictInterceptQuickApp() {
            return enableStrictInterceptQuickApp;
        }

        public static void setEnableAdSlotInterceptQuickApp(boolean z) {
            enableAdSlotInterceptQuickApp = z;
            DebugLog.common_weak(dexg.dexa("joufsdfqu!rbqq!") + z);
        }

        public static void setEnableStrictInterceptQuickApp(boolean z) {
            enableStrictInterceptQuickApp = z;
            DebugLog.common_weak(dexg.dexa("fobcmfTusjduJoufsdfquRvjdlBqq>") + z);
        }
    }

    @Keep
    public static class DemandPlatform {
        public static final String THIRD_PARTY_API = dexg.dexa("bqj");
        public static final String THIRD_PARTY_GDT = dexg.dexa("hvbohejboupoh");
        public static final String THIRD_PARTY_CSJ = dexg.dexa("divbotibokjb");
        public static final String THIRD_PARTY_BD = dexg.dexa("cbjev");
        public static final String THIRD_PARTY_KS = dexg.dexa("lvbjtipv");
        public static final String THIRD_PARTY_JD = dexg.dexa("ke");
        public static final String THIRD_PARTY_TANX = dexg.dexa("uboy");
        public static final String THIRD_PARTY_ZHONG_JIAN = dexg.dexa("{ipohkjbo");
        public static final String THIRD_PARTY_OPPO = dexg.dexa("pqqp");
        public static final String THIRD_PARTY_QM = dexg.dexa("rvnfoh");
        public static final String THIRD_PARTY_SIGMOB = dexg.dexa("tjhnpc");
        public static final String THIRD_PARTY_MOXIU = dexg.dexa("npyjv");
        public static final String THIRD_PARTY_YOUKU = dexg.dexa("zpvlv");
        public static final String THIRD_PARTY_IQY = dexg.dexa("jrjzj");
    }

    @Keep
    public static class HttpUrl {
        public static String trackHostUrl;
        public static final String CHECK_VERSION_URL = dexg.dexa("tel0hfuBqlJogp/bqj");
        public static final String REPORT_TRACK_URL = dexg.dexa("tel0usbdlfwfou/bqj");
        public static final String SDK_INIT_CONFIG_URL = dexg.dexa("tel0bqq0nd/bqj");
        public static final String SDK_MEDIATION_CONFIG = dexg.dexa("tel0nfejbujpo0dpogjh/bqj");
        public static final String SDK_MATERIAL_REPORT = dexg.dexa("tel0usbdlben/bqj");
        public static final String CHECKER_APP_WAKEUP_REPORT = dexg.dexa("tel0dtdSfqpsu/bqj");
        public static final String SDK_REPORT_ERROR = dexg.dexa("tel0sfqpsu0fssps/bqj");
        public static final String SDK_INSTALLED_REPORT = dexg.dexa("tel0sfqpsu0jut/bqj");
        public static String realNameUrl = dexg.dexa("iuuqt;00tel/bey/bexbohnbj/dpn0");
    }

    @Keep
    public static class Permission {
        public static final String QUERY_ALL_PACKAGES = dexg.dexa("boespje/qfsnjttjpo/RVFSZ`BMM`QBDLBHFT");
        public static final String GET_INSTALLED_APPS = dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT");
        public static final String INSTALLED_APPS = dexg.dexa("dpn/ivbxfj/qfsnjttjpo/JOTUBMMFE`BQQT");
    }

    @Keep
    public static class SharedPreferencesKey {
        public static final String APP_CONFIG = dexg.dexa("nn`tq`l2");
        public static final String SDK_TRACK = dexg.dexa("nn`tq`l3");
        public static final String WM_ID = dexg.dexa("nn`tq`l4");
        public static final String DEV_OAID = dexg.dexa("nn`tq`l5");
        public static final String WM_OAID = dexg.dexa("nn`tq`l6");
        public static final String BLACKLIST_URL = dexg.dexa("nn`tq`l7");
        public static final String VIRTUAL_CLICK = dexg.dexa("nn`tq`l8");
        public static final String LOCAL_PLUGIN_VERSION = dexg.dexa("nn`tq`l23");
        public static final String REMOTE_PLUGIN_VERSION = dexg.dexa("nn`tq`l24");
        public static final String CLICK_ID = dexg.dexa("nn`tq`l25");
        public static final String PRIVATE_INFO = dexg.dexa("nn`tq`l26");
        public static final String PRIVATE_OAID = dexg.dexa("nn`tq`l27");
        public static final String PRIVATE_OPERATOR = dexg.dexa("nn`tq`l28");
        public static final String PRIVATE_OPERATOR_TYPE = dexg.dexa("nn`tq`l29");
        public static final String PRIVATE_MNC = dexg.dexa("nn`tq`l2:");
        public static final String PRIVATE_MCC = dexg.dexa("nn`tq`l31");
        public static final String PRIVATE_LATITUDE = dexg.dexa("nn`tq`l32");
        public static final String PRIVATE_LONGITUDE = dexg.dexa("nn`tq`l33");
        public static final String PRIVATE_ACCURACY = dexg.dexa("nn`tq`l34");
        public static final String PRIVATE_IMEI = dexg.dexa("nn`tq`l35");
        public static final String PRIVATE_ANDROID_ID = dexg.dexa("nn`tq`l36");
        public static final String PRIVATE_MAC = dexg.dexa("nn`tq`l37");
        public static final String PRIVATE_IMSI = dexg.dexa("nn`tq`l38");
        public static final String PRIVATE_MEID = dexg.dexa("nn`tq`l39");
        public static final String UA = dexg.dexa("nn`tq`l3:");
        public static final String APP_TOKEN_MD5 = dexg.dexa("nn`tq`l41");
        public static final String EXT_CONFIG_INFO = dexg.dexa("nn`fyu`l2");
        public static final String EXT_FULL_INST_RESULT = dexg.dexa("nn`fyu`l3");
        public static final String EXT_NORMAL_INST_RESULT = dexg.dexa("nn`fyu`l4");
    }

    public static String getAppKey() {
        return APP_KEY;
    }

    public static String getAppToken() {
        return APP_TOKEN;
    }

    public static String getDevImei() {
        return devImei;
    }

    public static String getDevMacAddress() {
        return devMacAddress;
    }

    public static String getDevOaid() {
        return devOaid;
    }

    public static WMLocation getDevWMLocation() {
        return devWMLocation;
    }

    public static String getLogsDirPath(Context context) {
        if (TextUtils.isEmpty(logsDirPath) && context.getExternalFilesDir(dexg.dexa("ldcx")) != null) {
            logsDirPath = context.getExternalFilesDir(dexg.dexa("ldcx")).getAbsolutePath() + File.separator + dexg.dexa("mpht");
        }
        return logsDirPath;
    }

    public static String getRealNameUrl() {
        return HttpUrl.realNameUrl;
    }

    public static String getTrackHostUrl() {
        return !TextUtils.isEmpty(HttpUrl.trackHostUrl) ? HttpUrl.trackHostUrl : HttpUrl.realNameUrl;
    }

    public static String getWxAppId() {
        return WX_APP_ID;
    }

    public static boolean isCanUseAppList() {
        return canUseAppList;
    }

    public static boolean isCanUseBootId() {
        return canUseBootId;
    }

    public static boolean isCanUseInstallPackages() {
        return canUseInstallPackages;
    }

    public static boolean isCanUseLocation() {
        return canUseLocation;
    }

    public static boolean isCanUseNetworkState() {
        return canUseNetworkState;
    }

    public static boolean isCanUseOaid() {
        return canUseOaid;
    }

    public static boolean isCanUsePermissionRecordAudio() {
        return canUsePermissionRecordAudio;
    }

    public static boolean isCanUsePhoneState() {
        return canUsePhoneState;
    }

    public static boolean isCanUseWifiState() {
        return canUseWifiState;
    }

    public static boolean isCanUseWriteExternal() {
        return canUseWriteExternal;
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static boolean isEnablePersonalized() {
        return enablePersonalized;
    }

    public static boolean isEnableSensor() {
        return enableSensor;
    }

    public static void resetTouchEventPosition(String str) {
        downX = -999.0f;
        downY = -999.0f;
        upX = -999.0f;
        upY = -999.0f;
    }

    public static void setAppKey(String str) {
        APP_KEY = str;
    }

    public static void setAppToken(String str) {
        APP_TOKEN = str;
    }

    public static void setCanUseAppList(boolean z) {
        canUseAppList = z;
    }

    public static void setCanUseBootId(boolean z) {
        canUseBootId = z;
    }

    public static void setCanUseInstallPackages(boolean z) {
        canUseInstallPackages = z;
    }

    public static void setCanUseLocation(boolean z) {
        canUseLocation = z;
    }

    public static void setCanUseNetworkState(boolean z) {
        canUseNetworkState = z;
    }

    public static void setCanUseOaid(boolean z) {
        canUseOaid = z;
    }

    public static void setCanUsePermissionRecordAudio(boolean z) {
        canUsePermissionRecordAudio = z;
    }

    public static void setCanUsePhoneState(boolean z) {
        canUsePhoneState = z;
    }

    public static void setCanUseWifiState(boolean z) {
        canUseWifiState = z;
    }

    public static void setCanUseWriteExternal(boolean z) {
        canUseWriteExternal = z;
    }

    public static void setDebug(boolean z) {
        DEBUG = z;
    }

    public static void setDevImei(String str) {
        devImei = str;
    }

    public static void setDevMacAddress(String str) {
        devMacAddress = str;
    }

    public static void setDevOaid(String str) {
        devOaid = str;
    }

    public static void setDevWMLocation(WMLocation wMLocation) {
        devWMLocation = wMLocation;
    }

    public static void setEnablePersonalized(boolean z) {
        enablePersonalized = z;
    }

    public static void setEnableSensor(boolean z) {
        enableSensor = z;
    }

    public static void setWxAppId(String str) {
        WX_APP_ID = str;
    }

    public static void updateRealNameUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            DebugLog.common_w(dexg.dexa("vqebuf!sfbmObnf!gbjm-sfbmObnf!jt!ovmm"));
        } else {
            HttpUrl.realNameUrl = str;
        }
    }

    public static void updateTouchEventPosition(String str, float f, float f2, float f3, float f4) {
        downX = f;
        downY = f2;
        upX = f3;
        upY = f4;
    }

    public static void updateTrackHostUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            DebugLog.common_w(dexg.dexa("vqebuf!usbdlIptu!gbjm-usbdlIptu!jt!ovmm"));
        } else {
            HttpUrl.trackHostUrl = str;
        }
    }
}
