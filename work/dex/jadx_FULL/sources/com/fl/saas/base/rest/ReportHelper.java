package com.fl.saas.base.rest;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.fl.saas.base.bean.PMControlBean;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.saas.bean.PreAdPlace;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.JSONUtil;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.KParams;
import com.fl.saas.config.utils.KUtil;
import com.fl.saas.config.utils.LoadConfigUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.OaidUtils;
import com.fl.saas.config.utils.SensorUtil;
import com.fl.saas.config.utils.YdAppBackgroundUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ReportHelper {
    private static final int INIT_REP_FAILED = -1;
    private static final int INIT_REP_FINISH = 2;
    private static final int INIT_REP_ING = 1;
    private static final int INIT_REP_INIT = 0;
    private static ReportHelper sInstance;
    private List<AdSource> listShowAd;
    private int INIT_REP_STATUS = 0;
    private Map<String, Ucf> mapUcf = new HashMap();

    /* JADX INFO: renamed from: com.fl.saas.base.rest.ReportHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements HttpCallbackStringListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$0(List list) {
            list.add(CommConstant.ImageUrl.ICON_RAIN1);
            list.add(CommConstant.ImageUrl.ICON_RAIN2);
            list.add(CommConstant.ImageUrl.ICON_RAIN3);
            list.add(CommConstant.ImageUrl.ICON_RAIN4);
            list.add(CommConstant.ImageUrl.ICON_RAIN5);
            PreResManager.handleDownload(PreResManager.RAIN_CACHE, list);
            PreResManager.loadImageCache();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onSuccess$1(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onSuccess$2(Object obj) {
            return obj instanceof String ? (String) obj : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onSuccess$3(Object obj) {
            return obj instanceof String ? (String) obj : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onSuccess$4(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$onSuccess$5(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onError(Exception exc) {
            LogcatUtil.d("YdSDk-Preload", "上报失败:" + exc.toString());
            ReportHelper.this.INIT_REP_STATUS = -1;
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onJump(String str) {
        }

        @Override // com.fl.saas.config.http.HttpCallbackStringListener
        public void onSuccess(String str) {
            JSONArray jSONArrayOptJSONArray;
            ReportHelper.this.INIT_REP_STATUS = 2;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject responseNew = NetDataUtils.parseResponseNew(str);
                if (responseNew != null) {
                    JSONArray jSONArrayOptJSONArray2 = responseNew.optJSONArray("app_list");
                    if (jSONArrayOptJSONArray2 != null) {
                        DeviceUtil.appList = jSONArrayOptJSONArray2;
                    }
                    int iOptInt = responseNew.optInt("cacheSwitch", 0);
                    int iOptInt2 = responseNew.optInt("cacheAdTime", 30);
                    int iOptInt3 = responseNew.optInt("queueNum", 5);
                    ConfigHelper.getInstance().setCacheSwitch(iOptInt);
                    ConfigHelper.getInstance().setCacheAdTime(iOptInt2);
                    ConfigHelper.getInstance().setQueueNum(iOptInt3);
                    JSONArray jSONArrayOptJSONArray3 = responseNew.optJSONArray("public_config_list");
                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                        LogcatUtil.d("YdSDK-Preload", "configList:" + jSONArrayOptJSONArray3.length());
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayOptJSONArray3.length(); i++) {
                            String strOptString = jSONArrayOptJSONArray3.optJSONObject(i).optString("place_id");
                            int iOptInt4 = jSONArrayOptJSONArray3.optJSONObject(i).optInt("position");
                            if (!TextUtils.isEmpty(strOptString) && iOptInt4 != 0) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i);
                                AdPlace adPlaceHandleData = ConfigHelper.getInstance().handleData(jSONObjectOptJSONObject, DeviceUtil.getReqID(strOptString), strOptString);
                                if (adPlaceHandleData != null) {
                                    adPlaceHandleData.setSourceStr(jSONObjectOptJSONObject.toString());
                                    arrayList.add(PreAdPlace.create(iOptInt4, adPlaceHandleData));
                                }
                            }
                        }
                        LogcatUtil.d("YdSDK-Preload", "preload adPlaces:" + arrayList.size());
                        if (!arrayList.isEmpty()) {
                            PreloadHelper.getInstance().addAdPlace(arrayList);
                        }
                    }
                    String strOptString2 = responseNew.optString("global_cache_position");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        AdCacheManager.getInstance().setGlobalCachePosition(strOptString2.split(","));
                    }
                    final ArrayList arrayList2 = new ArrayList();
                    if (PreResManager.isRainRedCacheEmpty() && (jSONArrayOptJSONArray = responseNew.optJSONArray("img_url_list")) != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList2.add(jSONArrayOptJSONArray.optString(i2));
                        }
                    }
                    ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.fl.saas.base.rest.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReportHelper.AnonymousClass1.lambda$onSuccess$0(arrayList2);
                        }
                    });
                    DeviceUtil.setMaterialAdv(JSONUtil.jsonArrayToList(responseNew.optJSONArray("adv_id_list"), new Function() { // from class: com.fl.saas.base.rest.b
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return ReportHelper.AnonymousClass1.lambda$onSuccess$1(obj);
                        }
                    }));
                    QuickAppHelper.getInstance().setCollectWebviewWakeup(responseNew.optInt("collect_webview_wakeup", 0));
                    QuickAppHelper.getInstance().setQuickAppBlockRatio(responseNew.optDouble("quick_app_block_ratio", 100.0d));
                    QuickAppHelper.getInstance().setWebviewWakeupLimit(responseNew.optInt("webview_wakeup_limit", 0));
                    QuickAppHelper.getInstance().setQuickAppInterceptionType(responseNew.optInt("quick_app_interception_type", 1));
                    QuickAppHelper.getInstance().setQuickAppFreqDay(responseNew.optInt("quick_app_freq_day", 0));
                    String strOptString3 = responseNew.optString("whitelist_headers", "");
                    if (!strOptString3.isEmpty()) {
                        QuickAppHelper.getInstance().setWhitelistHeaders(Arrays.asList(strOptString3.split(",")));
                    }
                    String strOptString4 = responseNew.optString("device_permisson_info");
                    if (!TextUtils.isEmpty(strOptString4) && !c49.f40900a.equals(strOptString4)) {
                        PMControlBean pMControlBean = new PMControlBean();
                        JSONObject jSONObject = new JSONObject(strOptString4);
                        int iOptInt5 = jSONObject.optInt(DeviceIdType.ANDROID_ID, 1);
                        int iOptInt6 = jSONObject.optInt("mac", 1);
                        int iOptInt7 = jSONObject.optInt("iemi", 1);
                        int iOptInt8 = jSONObject.optInt(DeviceIdType.OAID, 1);
                        int iOptInt9 = jSONObject.optInt("bootId", 1);
                        int iOptInt10 = jSONObject.optInt("sensor", 1);
                        pMControlBean.setCanGetAndroidId(iOptInt5 == 1);
                        pMControlBean.setCanGetMac(iOptInt6 == 1);
                        pMControlBean.setCanGetIMEI(iOptInt7 == 1);
                        pMControlBean.setCanGetOaid(iOptInt8 == 1);
                        pMControlBean.setCanGetBootId(iOptInt9 == 1);
                        pMControlBean.setCanGetSensor(iOptInt10 == 1);
                        DeviceUtil.controlBean = pMControlBean;
                        if (!DeviceUtil.isCanUseSensor && iOptInt10 == 1) {
                            boolean zCheckAccelerometerSensor = DeviceUtil.checkAccelerometerSensor(DeviceUtil.getContext());
                            DeviceUtil.deviceHasAccelerometerSensor = zCheckAccelerometerSensor;
                            if (zCheckAccelerometerSensor) {
                                SensorUtil.getInstance().checkSensorEnable();
                            }
                        }
                        if (!OaidUtils.isIsCanUseOAID() && iOptInt8 == 1) {
                            OaidUtils.init();
                        }
                    }
                    String strOptString5 = responseNew.optString("ucf");
                    if (!TextUtils.isEmpty(strOptString5)) {
                        JSONObject jSONObject2 = new JSONObject(strOptString5);
                        List<String> listJsonArrayToList = JSONUtil.jsonArrayToList(jSONObject2.optJSONArray("ubx"), new Function() { // from class: com.fl.saas.base.rest.c
                            @Override // androidx.arch.core.util.Function
                            public final Object apply(Object obj) {
                                return ReportHelper.AnonymousClass1.lambda$onSuccess$2(obj);
                            }
                        });
                        if (!listJsonArrayToList.isEmpty()) {
                            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("ukm");
                            JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("uvr");
                            for (String str2 : listJsonArrayToList) {
                                Ucf ucf = ReportHelper.this.new Ucf();
                                ucf.setKey(str2);
                                if (jSONObjectOptJSONObject2 != null) {
                                    ucf.setListUbx(JSONUtil.jsonArrayToList(jSONObjectOptJSONObject2.optJSONArray(str2), new Function() { // from class: com.fl.saas.base.rest.d
                                        @Override // androidx.arch.core.util.Function
                                        public final Object apply(Object obj) {
                                            return ReportHelper.AnonymousClass1.lambda$onSuccess$3(obj);
                                        }
                                    }));
                                }
                                if (jSONObjectOptJSONObject3 != null) {
                                    ucf.setUvr(jSONObjectOptJSONObject3.optInt(str2));
                                }
                                ReportHelper.this.mapUcf.put(str2, ucf);
                            }
                        }
                    }
                    if (responseNew.optInt("keyword_ad_sts", 0) == 1) {
                        KParams kParams = new KParams();
                        kParams.setKeyword_url(responseNew.optString("keyword_url", ""));
                        kParams.setKeyword_regex(responseNew.optString("keyword_regex", ""));
                        kParams.setDevice_keyword_freq(responseNew.optInt("device_keyword_freq", 0));
                        kParams.setDevice_keyword_interval(responseNew.optInt("device_keyword_interval", 0));
                        kParams.setKeyword_use_time_range(responseNew.optInt("keyword_use_time_range", 0));
                        kParams.setCopyJs(responseNew.optString("kcs", ""));
                        KUtil.getInstance().setKeywordParams(kParams);
                    }
                    AdHttpUtils.getInstance().setBlackList(JSONUtil.jsonArrayToList(responseNew.optJSONArray("quickapp_block_domains"), new Function() { // from class: com.fl.saas.base.rest.e
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return ReportHelper.AnonymousClass1.lambda$onSuccess$4(obj);
                        }
                    }));
                    AdHttpUtils.getInstance().setWhiteList(JSONUtil.jsonArrayToList(responseNew.optJSONArray("quickapp_whitelist_domains"), new Function() { // from class: com.fl.saas.base.rest.f
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return ReportHelper.AnonymousClass1.lambda$onSuccess$5(obj);
                        }
                    }));
                    DeviceUtil.filling_timing = responseNew.optInt("filling_timing", 0);
                    YdAppBackgroundUtil.getInstance().setBrtr(responseNew.optInt("bg_reporting_time_range", 0));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class Ucf {
        private String key;
        private List<String> listUbx;
        private int uvr;

        public Ucf() {
        }

        public String getKey() {
            return this.key;
        }

        public List<String> getListUbx() {
            return this.listUbx;
        }

        public int getUvr() {
            return this.uvr;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setListUbx(List<String> list) {
            this.listUbx = list;
        }

        public void setUvr(int i) {
            this.uvr = i;
        }
    }

    private synchronized void doRequest(final int i, final AdSource adSource) {
        if (adSource == null) {
            return;
        }
        if (!adSource.isApiBidAd || 9 == i) {
            ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.bf7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40740a.lambda$doRequest$1(i, adSource);
                }
            });
        }
    }

    private String getAdFullUrl(AdSource adSource, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("price", Integer.valueOf(adSource.getPrice()));
            jSONObject.putOpt("time", Long.valueOf(adSource.responseTime));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("is_proload", adSource.getPreLoadStr());
            jSONObject.putOpt("traffic_resp_time", Long.valueOf(j));
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(adSource.responseTime));
            jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/traffic_response?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private JSONArray getAdvInfoJsonArray(List<AdSource> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (AdSource adSource : list) {
            if (adSource.getAdCacheBean() == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
                jSONObject.putOpt("tag_id", adSource.tagid);
                jSONObject.putOpt("time", Long.valueOf(adSource.responseTime));
                jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
                int i = adSource.price;
                if (i <= 0) {
                    i = adSource.bidfloor;
                }
                jSONObject.putOpt("price", Integer.valueOf(i));
                jSONObject.putOpt("uqf", Integer.valueOf(adSource.uqf));
                jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    private String getClickUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("creative_id", adSource.creative_id);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("public_ad_pool", adSource.adPool);
            if (!"0".equals(adSource.adPool)) {
                jSONObject.putOpt("global_place_id", adSource.global_place_id);
                jSONObject.putOpt("global_group_id", adSource.global_group_id);
                jSONObject.putOpt("global_test_id", adSource.global_test_id);
            }
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
            jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/click?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getDisplayUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("creative_id", adSource.creative_id);
            jSONObject.putOpt("is_cached", Integer.valueOf(adSource.isCacheAd ? 1 : 0));
            jSONObject.putOpt("price", Integer.valueOf(adSource.getAdvPrice()));
            int i = adSource.price;
            jSONObject.putOpt("adv_price", i > 0 ? Integer.valueOf(i) : Integer.valueOf(adSource.bidfloor));
            jSONObject.putOpt("time", Long.valueOf(adSource.responseTime));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("public_ad_pool", adSource.adPool);
            if (!"0".equals(adSource.adPool)) {
                jSONObject.putOpt("global_place_id", adSource.global_place_id);
                jSONObject.putOpt("global_group_id", adSource.global_group_id);
                jSONObject.putOpt("global_test_id", adSource.global_test_id);
            }
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
            jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/impress?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getErrorUrl(String str, String str2, String str3, String str4, List<ErrorInfo> list, String str5, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", str);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", str2);
            jSONObject.putOpt("group_id", str3);
            jSONObject.putOpt("test_id", str4);
            jSONObject.putOpt("track_id", str5);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            JSONArray jSONArray = new JSONArray();
            for (ErrorInfo errorInfo : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("adv_id", errorInfo.adv_id);
                jSONObject2.putOpt("tagid", errorInfo.tagid);
                int i = errorInfo.code;
                if (i == 20412) {
                    i = errorInfo.errorType;
                }
                if ("1".equals(errorInfo.adv_id) && !TextUtils.isEmpty(errorInfo.msg) && errorInfo.msg.contains("reason:") && errorInfo.msg.contains("message:") && errorInfo.msg.indexOf("message:") > 0) {
                    try {
                        int i2 = Integer.parseInt(errorInfo.msg.substring(errorInfo.msg.indexOf("reason:") + 7, errorInfo.msg.indexOf("message:")).trim());
                        jSONObject2.putOpt("code", i2 != 0 ? i + LoginConstants.UNDER_LINE + i2 : Integer.valueOf(i));
                    } catch (NumberFormatException unused) {
                        jSONObject2.putOpt("code", Integer.valueOf(i));
                    }
                } else {
                    jSONObject2.putOpt("code", Integer.valueOf(i));
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.putOpt("error_info", jSONArray);
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(j));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/error_response2?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + str2;
    }

    public static ReportHelper getInstance() {
        if (sInstance == null) {
            synchronized (ReportHelper.class) {
                sInstance = new ReportHelper();
            }
        }
        return sInstance;
    }

    private String getReportDpUrl(AdSource adSource, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("price", Integer.valueOf(adSource.getPrice()));
            jSONObject.putOpt("time", Long.valueOf(adSource.cost_time));
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("js_dpurl", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/js_dpurl?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getRequestC2SBiddingUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            int i = adSource.price;
            jSONObject.putOpt("price", i > 0 ? Integer.valueOf(i) : Integer.valueOf(adSource.bidfloor));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/bid_response?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getRequestShowUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            int i = adSource.price;
            jSONObject.putOpt("price", i > 0 ? Integer.valueOf(i) : Integer.valueOf(adSource.bidfloor));
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("public_ad_pool", adSource.adPool);
            if (!"0".equals(adSource.adPool)) {
                jSONObject.putOpt("global_place_id", adSource.global_place_id);
                jSONObject.putOpt("global_group_id", adSource.global_group_id);
                jSONObject.putOpt("global_test_id", adSource.global_test_id);
            }
            jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/trigger_impress?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private String getRequestUrl(List<AdSource> list, AdPlace adPlace) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            if (adPlace != null) {
                jSONObject.putOpt("id", adPlace.req_id);
                jSONObject.putOpt("place_id", adPlace.place_id);
                jSONObject.putOpt("group_id", adPlace.group_id);
                jSONObject.putOpt("test_id", adPlace.test_id);
                str = adPlace.track_id;
            } else {
                jSONObject.putOpt("id", list.get(0).req_id);
                jSONObject.putOpt("place_id", list.get(0).place_id);
                jSONObject.putOpt("group_id", list.get(0).group_id);
                jSONObject.putOpt("test_id", list.get(0).test_id);
                str = list.get(0).track_id;
            }
            jSONObject.putOpt("track_id", str);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("adv_info_list", getAdvInfoJsonArray(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/adv_request_merge_info?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + list.get(0).place_id;
    }

    private String getResponseUrl(List<AdSource> list, AdPlace adPlace) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            if (adPlace != null) {
                jSONObject.putOpt("id", adPlace.req_id);
                jSONObject.putOpt("place_id", adPlace.place_id);
                jSONObject.putOpt("group_id", adPlace.group_id);
                jSONObject.putOpt("test_id", adPlace.test_id);
                str = adPlace.track_id;
            } else {
                jSONObject.putOpt("id", list.get(0).req_id);
                jSONObject.putOpt("place_id", list.get(0).place_id);
                jSONObject.putOpt("group_id", list.get(0).group_id);
                jSONObject.putOpt("test_id", list.get(0).test_id);
                str = list.get(0).track_id;
            }
            jSONObject.putOpt("track_id", str);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("adv_info_list", getAdvInfoJsonArray(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/adv_response_merge_info?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + list.get(0).place_id;
    }

    private String getSDKInitUrl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("is_applist", Boolean.valueOf(DeviceUtil.isAppList()));
            jSONObject.putOpt("device_id_info", DeviceUtil.customConfig);
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/newInitialization?e=" + AesUtils.encrypt(jSONObject.toString());
    }

    private String getSdkRequestUrl(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("is_proload", adSource.getPreLoadStr());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(adSource.cost_time));
            jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://adtracker.adfunlink.com/log/traffic_request?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id;
    }

    private JSONArray getShowAdvInfoJsonArray(List<AdSource> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (AdSource adSource : list) {
            if (adSource.getAdCacheBean() == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
                jSONObject.putOpt("tag_id", adSource.tagid);
                jSONObject.putOpt("time", Long.valueOf(adSource.responseTime));
                jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
                int i = adSource.price;
                if (i <= 0) {
                    i = adSource.bidfloor;
                }
                jSONObject.putOpt("price", Integer.valueOf(i));
                jSONObject.putOpt("uqf", Integer.valueOf(adSource.uqf));
                jSONObject.putOpt("bg_reporting_time_range", Long.valueOf(adSource.distanceFromShowTime));
                jSONObject.putOpt("click_cb", Integer.valueOf(adSource.hasClickCallBack ? 1 : 0));
                jSONObject.putOpt("test_id", adSource.test_id);
                jSONObject.putOpt("track_id", adSource.track_id);
                jSONObject.putOpt("place_id", adSource.place_id);
                jSONObject.putOpt("group_id", adSource.group_id);
                jSONObject.putOpt("public_ad_pool", adSource.adPool);
                if (!"0".equals(adSource.adPool)) {
                    jSONObject.putOpt("global_place_id", adSource.global_place_id);
                    jSONObject.putOpt("global_group_id", adSource.global_group_id);
                    jSONObject.putOpt("global_test_id", adSource.global_test_id);
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doRequest$1(int i, AdSource adSource) {
        String requestC2SBiddingUrl;
        if (1 == i) {
            requestC2SBiddingUrl = getDisplayUrl(adSource);
        } else if (2 == i) {
            requestC2SBiddingUrl = getClickUrl(adSource);
        } else if (8 == i) {
            requestC2SBiddingUrl = getSdkRequestUrl(adSource);
        } else if (9 == i) {
            requestC2SBiddingUrl = getRequestShowUrl(adSource);
        } else {
            requestC2SBiddingUrl = 10 == i ? getRequestC2SBiddingUrl(adSource) : "";
        }
        requestUrl(requestC2SBiddingUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportSDKInit$0() {
        ConfigHelper.getInstance().initShowCount();
        this.INIT_REP_STATUS = 1;
        OaidUtils.init();
        if (DeviceUtil.isCanUseSensor) {
            boolean zCheckAccelerometerSensor = DeviceUtil.checkAccelerometerSensor(DeviceUtil.getContext());
            DeviceUtil.deviceHasAccelerometerSensor = zCheckAccelerometerSensor;
            if (zCheckAccelerometerSensor) {
                SensorUtil.getInstance().checkSensorEnable();
            }
        }
        AdHttpUtils.getInstance().doGet(getSDKInitUrl(), new AnonymousClass1());
        LoadConfigUtil.getInstance().getRequestData();
    }

    private synchronized void requestUrl(String str) {
        AdHttpUtils.getInstance().doGet(str, new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ReportHelper.3
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                LogcatUtil.d("YdSDk-doRequest", "上报失败:" + exc.toString());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str2) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str2) {
            }
        });
    }

    public synchronized void addShowAd(AdSource adSource) {
        if (adSource != null) {
            try {
                adSource.showTime = System.currentTimeMillis();
                if (this.listShowAd == null) {
                    this.listShowAd = new ArrayList();
                }
                this.listShowAd.add(adSource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<AdSource> getShowAd() {
        return this.listShowAd;
    }

    public Ucf getUcf(String str) {
        Map<String, Ucf> map = this.mapUcf;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized void removeShowAd(AdSource adSource) {
        if (adSource != null) {
            try {
                if (this.listShowAd == null) {
                    this.listShowAd = new ArrayList();
                }
                this.listShowAd.remove(adSource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void reportC2SBiddingAd(AdSource adSource) {
        doRequest(10, adSource);
    }

    public synchronized void reportClick(AdSource adSource) {
        doRequest(2, adSource);
    }

    public synchronized void reportDisplay(AdSource adSource) {
        doRequest(1, adSource);
    }

    public void reportDpEffect(AdSource adSource, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("price", Integer.valueOf(adSource.getPrice()));
            jSONObject.putOpt("time", Long.valueOf(adSource.cost_time));
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("creative_id", adSource.creative_id);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - adSource.reqTime));
            jSONObject.putOpt("public_ad_pool", adSource.adPool);
            if (!"0".equals(adSource.adPool)) {
                jSONObject.putOpt("global_place_id", adSource.global_place_id);
                jSONObject.putOpt("global_group_id", adSource.global_group_id);
                jSONObject.putOpt("global_test_id", adSource.global_test_id);
            }
            jSONObject.putOpt("is_background_switch", str);
            jSONObject.putOpt("background_stay_time", Long.valueOf(j));
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestUrl("http://adtracker.adfunlink.com/log/dpEffect?e=" + AesUtils.encrypt(jSONObject.toString()) + "&place_id=" + adSource.place_id);
    }

    public synchronized void reportDpUrl(AdSource adSource, String str) {
        if (adSource != null) {
            if (!TextUtils.isEmpty(str)) {
                requestUrl(getReportDpUrl(adSource, str));
            }
        }
    }

    public synchronized void reportFillFail(String str, String str2, String str3, String str4, List<ErrorInfo> list, String str5, long j) {
        if (list != null) {
            if (list.size() > 0) {
                requestUrl(getErrorUrl(str, str2, str3, str4, list, str5, j));
            }
        }
    }

    public synchronized void reportFullAd(AdSource adSource, long j) {
        requestUrl(getAdFullUrl(adSource, j));
    }

    public void reportKeyword(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", DeviceUtil.getReqID(""));
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("keyword_url_result", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestUrl("http://adtracker.adfunlink.com/log/ka_rep?e=" + AesUtils.encrypt(jSONObject.toString()));
    }

    public synchronized void reportRequestAd(AdSource adSource) {
        doRequest(8, adSource);
    }

    public synchronized void reportRequestList(List<AdSource> list, AdPlace adPlace) {
        if (list != null) {
            if (!list.isEmpty()) {
                requestUrl(getRequestUrl(list, adPlace));
            }
        }
    }

    public synchronized void reportRequestShow(AdSource adSource) {
        doRequest(9, adSource);
    }

    public synchronized void reportResponseList(List<AdSource> list, AdPlace adPlace) {
        if (list != null) {
            if (!list.isEmpty()) {
                requestUrl(getResponseUrl(list, adPlace));
            }
        }
    }

    public synchronized void reportSDKBidding(JSONObject jSONObject) {
        AdHttpUtils.getInstance().doPost(CommConstant.API.NEW_S2S_BIDDING_REPORT, AesUtils.encrypt(jSONObject.toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ReportHelper.2
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                LogcatUtil.d("YdSDk-doRequest", "s2s上报失败:" + exc.toString());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str) {
            }
        });
    }

    public synchronized void reportSDKInit() {
        int i = this.INIT_REP_STATUS;
        if (i != 1 && i != 2) {
            ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.cf7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40962a.lambda$reportSDKInit$0();
                }
            });
        }
    }

    public synchronized void reportShowAd(List<AdSource> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
                    jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
                    jSONObject.putOpt("version", "2.9.0");
                    jSONObject.putOpt("sdkVersionCode", "29004");
                    jSONObject.putOpt("adv_info_list", getShowAdvInfoJsonArray(list));
                    requestUrl("http://adtracker.adfunlink.com/log/adv_impress_background_merge_info?e=" + AesUtils.encrypt(jSONObject.toString()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject reqBidJson(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("adv_id", Integer.valueOf(i));
            jSONObject.putOpt("is_win", Integer.valueOf(i2));
            jSONObject.putOpt("auction_price", str);
            jSONObject.putOpt("highest_loss_price", str2);
            jSONObject.putOpt("win_adv_id", str3);
            jSONObject.putOpt("nurl", str4);
            jSONObject.putOpt("lurl", str5);
            jSONObject.putOpt("tagid", str6);
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(j));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
