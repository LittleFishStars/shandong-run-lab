package cj.mobile.wm.common.utils;

import android.content.Context;
import android.text.TextUtils;
import cj.mobile.wm.common.bean.FullInstBean;
import cj.mobile.wm.common.bean.SdkTrackEventBean;
import cj.mobile.wm.common.bean.WMLocation;
import cj.mobile.wm.dexc;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
    public static final String VERSION = dexc.dexa("8/:/29/31");
    public static final String INTERCEPT_KEY = dexc.dexa("dpn/xbohnbj");
    public static final String CHANNEL_NAME_WM = dexc.dexa("XN");
    public static final String CHANNEL_NAME_GM = dexc.dexa("HN");
    public static final String CHANNEL_NAME_TO = dexc.dexa("UP");
    public static final String CHANNEL_NAME_TP = dexc.dexa("UQ");
    public static final String TIME_OUT = dexc.dexa("ujnf`pvu");
    public static final String BID_FAILED_MISSING_PRICE = dexc.dexa("njttjoh`qsjdf");
    public static final String BID_FAILED_MISSING_MEDIA_PRICE = dexc.dexa("njttjoh`nfejb`qsjdf");
    public static final String BID_FAILED_MEDIA_SIDE_PRICE_FILTER = dexc.dexa("nfejb`tjef`qsjdf`gjmufs");
    public static final String BID_FAILED_DEMANDER_SIDE_PRICE_FILTER = dexc.dexa("efnboefs`tjef`qsjdf`gjmufs");
    public static final String BID_FAILED = dexc.dexa("cje`gbjmfe");
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

    public static class AdDownloadStatus {
        public static final int FAIL = 0;
        public static final int SUCCESS = 1;
        public static final int UNKNOWN = -1;
    }

    public static class AdInfo {
        public static final String CRID = dexc.dexa("dsje");
        public static final String AdTitle = dexc.dexa("beUjumf");
        public static final String AdDescription = dexc.dexa("BeEftdsjqujpo");
        public static final String MaterialUrls = dexc.dexa("nbufsjbmVsmt");
    }

    public static class ClickRegionType {
        public static final int CLICK_REGION_ALL = 0;
        public static final int CLICK_REGION_ALL_COMPONENT = 1;
        public static final int CLICK_REGION_ONLY_COMPONENT = 2;
    }

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
        public static final String PREFERENCE_FILE_NAME = dexc.dexa("mzxn/qsfgfsfodft");
        public static final String PREFERENCE_EXT_CONFIG_FILE_NAME = dexc.dexa("mzxn`fyu`dpogjh/qsfgfsfodft");
        public static final String AD_LOADER = dexc.dexa("dk/npcjmf/xn/be/efy/bmmnpevmft/BeMpbefs");
        public static final String VOPT = dexc.dexa("wpqu");

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(dexc.dexa("mzxn"));
            String str = File.separator;
            sb.append(str);
            CHANNEL_ROOT_DIR_PATH = sb.toString();
            CONFIG_DIR_PATH = dexc.dexa("mzxn") + str + dexc.dexa("dpogjhvsf");
            PATCH_DIR_PATH = dexc.dexa("mzxn") + str + dexc.dexa("qbudi");
            REQUEST_SERVER_BID_BUYER_ID = 1;
            REQUEST_SERVER_BID_LOAD = 2;
            REQUEST_STANDARD_LOAD = 3;
            VALID_COUNTDOWN_RANGES = Arrays.asList(3, 4, 5, 6);
            MM_AD_LOGO_DEFAULT_URL = dexc.dexa("iuuqt;00tubujd/bexbohnbj/dpn0nn`be`mphp/qoh");
            MM_REWARD_GIFT_ICON = dexc.dexa("iuuqt;00utubujd/77npcj/dpn0nn`sfxbse`hjgu`jdpo/qoh");
            DEFAULT_RECHECK_INTERVAL = 10000;
            quickAppSchemes = new ArrayList(Arrays.asList(dexc.dexa("ibq"), dexc.dexa("gbtubqq"), dexc.dexa("ixgbtubqq")));
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
            DebugLog.common_weak(dexc.dexa("joufsdfqu!rbqq!") + z);
        }

        public static void setEnableStrictInterceptQuickApp(boolean z) {
            enableStrictInterceptQuickApp = z;
            DebugLog.common_weak(dexc.dexa("fobcmfTusjduJoufsdfquRvjdlBqq>") + z);
        }
    }

    public static class DemandPlatform {
        public static final String THIRD_PARTY_API = dexc.dexa("bqj");
        public static final String THIRD_PARTY_GDT = dexc.dexa("hvbohejboupoh");
        public static final String THIRD_PARTY_CSJ = dexc.dexa("divbotibokjb");
        public static final String THIRD_PARTY_BD = dexc.dexa("cbjev");
        public static final String THIRD_PARTY_KS = dexc.dexa("lvbjtipv");
        public static final String THIRD_PARTY_JD = dexc.dexa("ke");
        public static final String THIRD_PARTY_TANX = dexc.dexa("uboy");
        public static final String THIRD_PARTY_ZHONG_JIAN = dexc.dexa("{ipohkjbo");
        public static final String THIRD_PARTY_OPPO = dexc.dexa("pqqp");
        public static final String THIRD_PARTY_QM = dexc.dexa("rvnfoh");
        public static final String THIRD_PARTY_SIGMOB = dexc.dexa("tjhnpc");
        public static final String THIRD_PARTY_MOXIU = dexc.dexa("npyjv");
        public static final String THIRD_PARTY_YOUKU = dexc.dexa("zpvlv");
        public static final String THIRD_PARTY_IQY = dexc.dexa("jrjzj");
    }

    public static class HttpUrl {
        public static String trackHostUrl;
        public static final String CHECK_VERSION_URL = dexc.dexa("tel0hfuBqlJogp/bqj");
        public static final String REPORT_TRACK_URL = dexc.dexa("tel0usbdlfwfou/bqj");
        public static final String SDK_INIT_CONFIG_URL = dexc.dexa("tel0bqq0nd/bqj");
        public static final String SDK_MEDIATION_CONFIG = dexc.dexa("tel0nfejbujpo0dpogjh/bqj");
        public static final String SDK_MATERIAL_REPORT = dexc.dexa("tel0usbdlben/bqj");
        public static final String CHECKER_APP_WAKEUP_REPORT = dexc.dexa("tel0dtdSfqpsu/bqj");
        public static final String SDK_REPORT_ERROR = dexc.dexa("tel0sfqpsu0fssps/bqj");
        public static final String SDK_INSTALLED_REPORT = dexc.dexa("tel0sfqpsu0jut/bqj");
        public static String realNameUrl = dexc.dexa("iuuqt;00tel/bey/bexbohnbj/dpn0");
    }

    public static class Permission {
        public static final String QUERY_ALL_PACKAGES = dexc.dexa("boespje/qfsnjttjpo/RVFSZ`BMM`QBDLBHFT");
        public static final String GET_INSTALLED_APPS = dexc.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT");
        public static final String INSTALLED_APPS = dexc.dexa("dpn/ivbxfj/qfsnjttjpo/JOTUBMMFE`BQQT");
    }

    public static class SharedPreferencesKey {
        public static final String APP_CONFIG = dexc.dexa("nn`tq`l2");
        public static final String SDK_TRACK = dexc.dexa("nn`tq`l3");
        public static final String WM_ID = dexc.dexa("nn`tq`l4");
        public static final String DEV_OAID = dexc.dexa("nn`tq`l5");
        public static final String WM_OAID = dexc.dexa("nn`tq`l6");
        public static final String BLACKLIST_URL = dexc.dexa("nn`tq`l7");
        public static final String VIRTUAL_CLICK = dexc.dexa("nn`tq`l8");
        public static final String LOCAL_PLUGIN_VERSION = dexc.dexa("nn`tq`l23");
        public static final String REMOTE_PLUGIN_VERSION = dexc.dexa("nn`tq`l24");
        public static final String CLICK_ID = dexc.dexa("nn`tq`l25");
        public static final String PRIVATE_INFO = dexc.dexa("nn`tq`l26");
        public static final String PRIVATE_OAID = dexc.dexa("nn`tq`l27");
        public static final String PRIVATE_OPERATOR = dexc.dexa("nn`tq`l28");
        public static final String PRIVATE_OPERATOR_TYPE = dexc.dexa("nn`tq`l29");
        public static final String PRIVATE_MNC = dexc.dexa("nn`tq`l2:");
        public static final String PRIVATE_MCC = dexc.dexa("nn`tq`l31");
        public static final String PRIVATE_LATITUDE = dexc.dexa("nn`tq`l32");
        public static final String PRIVATE_LONGITUDE = dexc.dexa("nn`tq`l33");
        public static final String PRIVATE_ACCURACY = dexc.dexa("nn`tq`l34");
        public static final String PRIVATE_IMEI = dexc.dexa("nn`tq`l35");
        public static final String PRIVATE_ANDROID_ID = dexc.dexa("nn`tq`l36");
        public static final String PRIVATE_MAC = dexc.dexa("nn`tq`l37");
        public static final String PRIVATE_IMSI = dexc.dexa("nn`tq`l38");
        public static final String PRIVATE_MEID = dexc.dexa("nn`tq`l39");
        public static final String UA = dexc.dexa("nn`tq`l3:");
        public static final String APP_TOKEN_MD5 = dexc.dexa("nn`tq`l41");
        public static final String EXT_CONFIG_INFO = dexc.dexa("nn`fyu`l2");
        public static final String EXT_FULL_INST_RESULT = dexc.dexa("nn`fyu`l3");
        public static final String EXT_NORMAL_INST_RESULT = dexc.dexa("nn`fyu`l4");
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
        if (TextUtils.isEmpty(logsDirPath) && context.getExternalFilesDir(dexc.dexa("mzxn")) != null) {
            logsDirPath = context.getExternalFilesDir(dexc.dexa("mzxn")).getAbsolutePath() + File.separator + dexc.dexa("mpht");
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
            DebugLog.common_w(dexc.dexa("vqebuf!sfbmObnf!gbjm-sfbmObnf!jt!ovmm"));
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
            DebugLog.common_w(dexc.dexa("vqebuf!usbdlIptu!gbjm-usbdlIptu!jt!ovmm"));
        } else {
            HttpUrl.trackHostUrl = str;
        }
    }
}
