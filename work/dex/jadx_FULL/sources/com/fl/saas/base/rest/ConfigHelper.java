package com.fl.saas.base.rest;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.fl.saas.common.crash.CrashHandler;
import com.fl.saas.common.listener.ApiSaaSListener;
import com.fl.saas.common.listener.SdkBidListener;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.saas.bean.QuickappMatchRuleVo;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.config.ConfigLib;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.ConfigParseUtil;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.SPUtil;
import com.fl.saas.config.utils.WParams;
import com.fl.saas.config.utils.YdAppBackgroundUtil;
import com.fl.saas.ydsdk.manager.YdConfig;
import com.huawei.hms.adapter.internal.CommonCode;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ConfigHelper {
    private static ConfigHelper sInstance;
    public AdSource adSource;
    private int cacheAdTime;
    private int cacheSwitch;
    private List<String> installeds;
    private int mAdType;
    private List<Integer> mThreadAdvIds;
    private int queueNum;
    private long showCount;
    private Map<String, Boolean> videoMutePlay;
    private final boolean[] isTimeout = {false};
    private final boolean[] isReqDone = {false};
    private boolean mIsHot = false;

    public class ConfigSaveBean {
        private String config;
        private String groupId;
        private String key;
        private String testId;
        private long time;

        public ConfigSaveBean() {
        }

        public String getConfig() {
            return this.config;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getKey() {
            return this.key;
        }

        public String getTestId() {
            return this.testId;
        }

        public long getTime() {
            return this.time;
        }

        public void setConfig(String str) {
            this.config = str;
        }

        public void setGroupId(String str) {
            this.groupId = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setTestId(String str) {
            this.testId = str;
        }

        public void setTime(long j) {
            this.time = j;
        }
    }

    private synchronized List<AdSource> buildAdSourceList(String str, JSONObject jSONObject, String str2, String str3) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str2);
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdSource adSource = new AdSource();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                adSource.adv_id = jSONObjectOptJSONObject.optInt("adv_id");
                adSource.mAdv_id = jSONObjectOptJSONObject.optInt("adv_id");
                adSource.app_id = jSONObjectOptJSONObject.optString("app_id");
                adSource.app_key = jSONObjectOptJSONObject.optString(com.alipay.sdk.m.n.b.h);
                adSource.slot_id = jSONObjectOptJSONObject.optString("slot_id");
                adSource.bidfloor = jSONObjectOptJSONObject.optInt("bidfloor");
                adSource.bidfloor_filter_sts = jSONObjectOptJSONObject.optString("bidfloor_filter_sts", "S");
                adSource.tagid = jSONObjectOptJSONObject.optString("tagid");
                adSource.mTagid = jSONObjectOptJSONObject.optString("tagid");
                adSource.price = jSONObjectOptJSONObject.optInt("price");
                adSource.skip = jSONObjectOptJSONObject.optString(FreeSpaceBox.TYPE, "S");
                adSource.is_download = jSONObjectOptJSONObject.optString("is_download", "S");
                adSource.setCloseButtonShow(jSONObjectOptJSONObject.optString("close_button_type", "A"));
                adSource.count_down = jSONObjectOptJSONObject.optInt("count_down", 5);
                adSource.button_size = jSONObjectOptJSONObject.optInt("button_size", 50);
                adSource.sensitivity = jSONObjectOptJSONObject.optInt("sensitivity", 50);
                adSource.sequence = i;
                adSource.advName = jSONObjectOptJSONObject.optString("adv_name", "广告");
                adSource.req_id = str;
                adSource.group_id = jSONObject.optString("group_id");
                adSource.place_id = jSONObject.optString("place_id");
                adSource.test_id = jSONObject.optString("test_id");
                adSource.parseJson(jSONObjectOptJSONObject);
                adSource.track_id = str3;
                adSource.customClassName = jSONObjectOptJSONObject.optString("adapter_class");
                adSource.customParameJson = jSONObjectOptJSONObject.optString(LoginConstants.EXT);
                arrayList.add(adSource);
                if (adSource.adv_id == 3) {
                    ConfigLib.getInstance().setKsSensorConfig(jSONObjectOptJSONObject);
                    ConfigLib.getInstance().setKsAppConfig(jSONObjectOptJSONObject);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String string = SPUtil.getInstance().getString(str + "_config");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        String[] strArrSplit = string.split(",");
        return strArrSplit.length == 4 ? strArrSplit[3] : "";
    }

    private ConfigSaveBean getConfigBean(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = SPUtil.getInstance().getString(str + "_config");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String[] strArrSplit = string.split(",");
        if (strArrSplit.length != 4) {
            return null;
        }
        ConfigSaveBean configSaveBean = new ConfigSaveBean();
        configSaveBean.setGroupId(strArrSplit[0]);
        configSaveBean.setTestId(strArrSplit[1]);
        try {
            configSaveBean.setTime(Long.parseLong(strArrSplit[2]));
        } catch (Exception unused) {
        }
        configSaveBean.setConfig(strArrSplit[3]);
        return configSaveBean;
    }

    public static ConfigHelper getInstance() {
        if (sInstance == null) {
            synchronized (ConfigHelper.class) {
                sInstance = new ConfigHelper();
            }
        }
        return sInstance;
    }

    private void handleCrashReport(JSONObject jSONObject) {
        if (!"A".equals(jSONObject.optString("crash_log_sts", "S"))) {
            CrashHandler.getInstance().removeCrashLog(DeviceUtil.getContext());
        } else {
            CrashHandler.getInstance().init(DeviceUtil.getContext());
            CrashHandler.getInstance().uploadCrashLog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(boolean z, String str, String str2, JSONObject jSONObject, String str3, ApiSaaSListener apiSaaSListener, long j) {
        if (jSONObject == null) {
            sdkTrafficReq("", str3, "", "", "", false, j);
            apiSaaSListener.onFailed("Incorrect configuration information,check config");
            return;
        }
        if (!jSONObject.has("code") || jSONObject.optInt("code", -1) == -1) {
            sdkTrafficReq("", str3, "", "", "", false, j);
            String str4 = "Incorrect configuration information.";
            if (jSONObject.has("msg")) {
                str4 = "Incorrect configuration information. msg:" + jSONObject.optString("msg");
            }
            apiSaaSListener.onFailed(str4);
            if (z) {
                ConfigSaveBean configSaveBean = new ConfigSaveBean();
                configSaveBean.setKey(str3);
                configSaveBean.setGroupId("default");
                configSaveBean.setTestId("default");
                configSaveBean.setTime(0L);
                configSaveBean.setConfig(str);
                saveConfigToSP(configSaveBean);
                LogcatUtil.d("YdSDK-API", "保存策略成功");
                return;
            }
            return;
        }
        AdPlace adPlaceHandleData = handleData(jSONObject.optJSONObject("adplace"), str2, str3);
        if (adPlaceHandleData != null) {
            adPlaceHandleData.request_logic = jSONObject.optInt("request_logic", 0);
            LogcatUtil.d("YdSDK-API", "请求策略成功");
            if (!this.isTimeout[0]) {
                apiSaaSListener.onSuccess(adPlaceHandleData);
                sdkTrafficReq(adPlaceHandleData.req_id, str3, adPlaceHandleData.group_id, adPlaceHandleData.test_id, adPlaceHandleData.track_id, false, j);
            }
            if (z) {
                ConfigSaveBean configSaveBean2 = new ConfigSaveBean();
                configSaveBean2.setKey(str3);
                configSaveBean2.setGroupId(adPlaceHandleData.group_id);
                configSaveBean2.setTestId(adPlaceHandleData.test_id);
                configSaveBean2.setTime(adPlaceHandleData.update_time);
                configSaveBean2.setConfig(str);
                saveConfigToSP(configSaveBean2);
                LogcatUtil.d("YdSDK-API", "保存策略成功");
            }
        } else {
            sdkTrafficReq("", str3, "", "", "", false, j);
            apiSaaSListener.onFailed("Incorrect configuration information");
        }
        handleCrashReport(jSONObject);
    }

    private JSONObject requestParam(String str, String str2) {
        Object objValueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", str2);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("app_id", DeviceUtil.appId);
            jSONObject.putOpt("place_id", str);
            ConfigSaveBean configBean = getConfigBean(str);
            if (configBean != null) {
                LogcatUtil.d("YdSDK-API", "req update_time: " + configBean.getTime());
                jSONObject.putOpt("group_id", configBean.getGroupId());
                jSONObject.putOpt("test_id", configBean.getTestId());
                objValueOf = Long.valueOf(configBean.getTime());
            } else {
                LogcatUtil.d("YdSDK-API", "req update_time: 0");
                jSONObject.putOpt("group_id", "");
                jSONObject.putOpt("test_id", "");
                objValueOf = 0;
            }
            jSONObject.putOpt("update_time", objValueOf);
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
            JSONArray jSONArray = DeviceUtil.appList;
            if (jSONArray != null && jSONArray.length() > 0) {
                if (YdConfig.getInstance().hasDisableAppListAccess()) {
                    if (this.installeds == null) {
                        this.installeds = new ArrayList();
                    }
                    this.installeds.clear();
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < DeviceUtil.appList.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = DeviceUtil.appList.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("bundle");
                        if (DeviceUtil.checkApkExist(strOptString)) {
                            List<String> list = this.installeds;
                            if (list != null) {
                                list.add(strOptString);
                            }
                            jSONArray2.put(strOptString);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.putOpt("app_list", jSONArray2);
                }
                SPUtil.getInstance().put(SPUtil.UPLOAD_DATE, DeviceUtil.getDate());
                DeviceUtil.appList = null;
            }
            jSONObject.putOpt("cycle_limit", Long.valueOf(this.showCount));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject requestSdkBidParam(List<AdSource> list, String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("place_id", str);
            JSONArray jSONArray = new JSONArray();
            Object obj = "";
            Object obj2 = "";
            for (AdSource adSource : list) {
                Object obj3 = adSource.group_id;
                Object obj4 = adSource.test_id;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("bidfloor", Integer.valueOf(adSource.bidfloor));
                jSONObject2.putOpt("bidfloorcur", "CNY");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt(y6b.g, 1920);
                jSONObject3.putOpt("w", 1080);
                jSONObject3.putOpt("minduration", 5);
                jSONObject3.putOpt("maxduration", 60);
                jSONObject2.putOpt("video", jSONObject3);
                jSONObject2.putOpt("app_id", adSource.app_id);
                jSONObject2.putOpt("tagid", adSource.tagid);
                jSONObject2.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
                jSONObject2.putOpt("slot_id", adSource.slot_id);
                jSONObject2.putOpt("buyer_id", adSource.buyer_id);
                jSONObject2.putOpt("support_h265", Boolean.TRUE);
                jSONObject2.putOpt("support_splash_zoomout", Boolean.FALSE);
                jSONObject2.putOpt("sdk_info", adSource.sdk_info);
                jSONObject2.putOpt("opensdk_ver", adSource.opensdk_ver);
                jSONObject2.putOpt(y6b.g, Integer.valueOf(adSource.adSizeH));
                jSONObject2.putOpt("w", Integer.valueOf(adSource.adSizeW));
                jSONArray.put(jSONObject2);
                obj = obj3;
                obj2 = obj4;
            }
            jSONObject.putOpt(QdActivityType.IMP, jSONArray);
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put("CNY");
            jSONObject.putOpt("cur", jSONArray2);
            jSONObject.putOpt("api_timeout", Integer.valueOf(i));
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("group_id", obj);
            jSONObject.putOpt("test_id", obj2);
            jSONObject.putOpt("id", str2);
        } catch (JSONException | Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject requestServerVerifyParam(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(PtgRewardConstant.REWARD_PARAMS.USER_ID, str);
            jSONObject.putOpt("custom_parameters", str2);
            jSONObject.putOpt("app_id", str3);
            jSONObject.putOpt("place_id", str4);
            jSONObject.putOpt(CommonCode.MapKey.TRANSACTION_ID, str5);
            jSONObject.putOpt("reward_ecpm", str6);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void saveConfigToSP(ConfigSaveBean configSaveBean) {
        if (configSaveBean != null) {
            SPUtil.getInstance().putString(configSaveBean.getKey() + "_config", configSaveBean.getGroupId() + "," + configSaveBean.getTestId() + "," + configSaveBean.getTime() + "," + configSaveBean.getConfig());
        }
    }

    private void setVideoMutePlay(String str, boolean z) {
        if (this.videoMutePlay == null) {
            this.videoMutePlay = new HashMap();
        }
        this.videoMutePlay.put(str, Boolean.valueOf(z));
    }

    private void startReq(final String str, final ApiSaaSListener apiSaaSListener, int i, final long j) {
        final String reqID = DeviceUtil.getReqID(str);
        if (i > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.fl.saas.base.rest.ConfigHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject responseNew;
                    if (ConfigHelper.this.isReqDone[0]) {
                        return;
                    }
                    LogcatUtil.d("YdSDK-API", "Configure timeout and use the local policy");
                    String config = ConfigHelper.this.getConfig(str);
                    if (TextUtils.isEmpty(config) || (responseNew = NetDataUtils.parseResponseNew(config)) == null) {
                        return;
                    }
                    AdPlace adPlaceHandleData = ConfigHelper.this.handleData(responseNew.optJSONObject("adplace"), reqID, str);
                    if (adPlaceHandleData != null) {
                        ConfigHelper.this.isTimeout[0] = true;
                        LogcatUtil.d("YdSDK-API", "超时使用缓存策略成功");
                        long jCurrentTimeMillis = System.currentTimeMillis() - j;
                        apiSaaSListener.onSuccess(adPlaceHandleData);
                        ConfigHelper.this.sdkTrafficReq(adPlaceHandleData.req_id, str, adPlaceHandleData.group_id, adPlaceHandleData.test_id, adPlaceHandleData.track_id, false, jCurrentTimeMillis);
                    }
                }
            }, i);
        }
        AdHttpUtils.getInstance().doPost(CommConstant.API.URL_CONFIG_NEW, AesUtils.encrypt(requestParam(str, reqID).toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ConfigHelper.2
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                ConfigHelper.this.isReqDone[0] = true;
                LogcatUtil.d("YdSDK-API", "req onError: " + exc.getMessage());
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                String config = ConfigHelper.this.getConfig(str);
                if (!TextUtils.isEmpty(config)) {
                    ConfigHelper.this.parseConfig(false, "", reqID, NetDataUtils.parseResponseNew(config), str, apiSaaSListener, jCurrentTimeMillis);
                    return;
                }
                ConfigHelper.this.sdkTrafficReq(reqID, str, "", "", "", false, jCurrentTimeMillis);
                apiSaaSListener.onFailed("config response error:" + exc.getMessage());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str2) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0057, code lost:
            
                if (android.text.TextUtils.isEmpty(r14) == false) goto L18;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
            
                if (android.text.TextUtils.isEmpty(r14) == false) goto L18;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
            
                r8 = com.fl.saas.config.http.NetDataUtils.parseResponseNew(r14);
                r4 = r13.this$0;
                r7 = r5;
                r9 = r4;
                r10 = r6;
                r5 = false;
                r6 = "";
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0086, code lost:
            
                r13.this$0.sdkTrafficReq(r5, r4, "", "", "", false, r11);
                r6.onFailed("Incorrect configuration information");
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x009d, code lost:
            
                return;
             */
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccess(String str2) {
                String config;
                ApiSaaSListener apiSaaSListener2;
                String str3;
                JSONObject responseNew;
                String str4;
                String str5;
                boolean z;
                ConfigHelper configHelper;
                ConfigHelper.this.isReqDone[0] = true;
                LogcatUtil.d("YdSDK-API", "ResponseData: " + str2);
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                if (TextUtils.isEmpty(str2)) {
                    config = ConfigHelper.this.getConfig(str);
                } else {
                    responseNew = NetDataUtils.parseResponseNew(str2);
                    if (responseNew == null || !responseNew.has("code") || responseNew.optInt("code", -1) != 0 || responseNew.has("adplace")) {
                        configHelper = ConfigHelper.this;
                        str4 = reqID;
                        str3 = str;
                        apiSaaSListener2 = apiSaaSListener;
                        z = true;
                        str5 = str2;
                    } else {
                        config = ConfigHelper.this.getConfig(str);
                    }
                }
                configHelper.parseConfig(z, str5, str4, responseNew, str3, apiSaaSListener2, jCurrentTimeMillis);
            }
        });
    }

    public synchronized void addShowCount() {
        this.showCount++;
        SPUtil.getInstance().putLong("showCount", this.showCount);
    }

    public boolean canThreadInit(Integer num) {
        List<Integer> list = this.mThreadAdvIds;
        if (list != null) {
            return list.contains(num);
        }
        return false;
    }

    public int getCacheAdTime() {
        return this.cacheAdTime;
    }

    public int getCacheSwitch() {
        return this.cacheSwitch;
    }

    public List<String> getInstalleds() {
        return this.installeds;
    }

    public int getQueueNum() {
        return this.queueNum;
    }

    public boolean getVideoSoundEnable(String str) {
        Map<String, Boolean> map = this.videoMutePlay;
        if (map != null) {
            return !Boolean.TRUE.equals(map.get(str));
        }
        return false;
    }

    public AdPlace handleData(JSONObject jSONObject, String str, String str2) {
        try {
            AdPlace adPlace = new AdPlace();
            String reqID = DeviceUtil.getReqID(str2);
            adPlace.all_time = jSONObject.optInt("all_time");
            adPlace.group_id = jSONObject.optString("group_id");
            adPlace.place_id = jSONObject.optString("place_id");
            adPlace.req_id = TextUtils.isEmpty(str) ? DeviceUtil.getReqID(str2) : str;
            adPlace.test_id = jSONObject.optString("test_id");
            adPlace.request_num = jSONObject.optInt("request_num", 1);
            adPlace.timeout = jSONObject.optInt(com.alipay.sdk.m.o.b.r0);
            adPlace.requestInterval = jSONObject.optInt("request_interval", 500);
            adPlace.has_api_bid = jSONObject.optBoolean("has_api_bid");
            adPlace.api_timeout = jSONObject.optInt("api_timeout", 3000);
            adPlace.client_timeout = jSONObject.optInt("client_timeout", 5000);
            adPlace.server_verify = jSONObject.optBoolean("server_verify", false);
            adPlace.server_verify_time = jSONObject.optInt("server_verify_time", 0);
            if ("A".equals(jSONObject.optString("adv_cache_sts", "S"))) {
                adPlace.isOpenCache = true;
            }
            adPlace.enhanceTarget = jSONObject.optInt("enhance_target", 0);
            adPlace.cacheValidTime = ((long) (jSONObject.optInt("adv_cache_time", 30) * 60)) * 1000;
            adPlace.floatingRatio = jSONObject.optDouble("floating_ratio", 1.0d);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adv_cacheabled_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                adPlace.advCacheabledList = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    adPlace.advCacheabledList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                }
            }
            adPlace.track_id = reqID;
            adPlace.refresh_num = jSONObject.optInt("refresh_num", 0);
            adPlace.bid_notice_type = jSONObject.optInt("bid_notice_type", 0);
            adPlace.impress_freq_hour = jSONObject.optInt("impress_freq_hour", 0);
            adPlace.impress_freq_day = jSONObject.optInt("impress_freq_day", 0);
            adPlace.impress_interval = jSONObject.optInt("impress_interval", 0);
            adPlace.update_time = jSONObject.optLong("update_time", 0L);
            adPlace.cache_queue_length = jSONObject.optInt("cache_queue_length", 1);
            adPlace.use_public_adplace = jSONObject.optInt("use_public_adplace", 1);
            adPlace.rela_public_adplace = jSONObject.optInt("rela_public_adplace", 0);
            adPlace.is_contrast = jSONObject.optInt("is_contrast", 0);
            adPlace.lbs = jSONObject.optInt("lbs", 0);
            adPlace.lbjg = jSONObject.optInt("lbjg", 5);
            adPlace.lbsx = jSONObject.optInt("lbsx", 3);
            adPlace.highest_bid_difference = jSONObject.optInt("highest_bid_difference", 0);
            adPlace.refresh = jSONObject.optInt(com.alipay.sdk.m.c0.d.x, 0);
            adPlace.refresh_time = jSONObject.optInt("refresh_time", 30);
            adPlace.verify_ad_refresh = jSONObject.optInt("verify_ad_refresh", 0);
            adPlace.fill_price = jSONObject.optInt("fill_price", 1);
            adPlace.is_need_header = jSONObject.optInt("is_need_header", 0);
            adPlace.bdt = jSONObject.optInt("bdt", 0);
            ConfigParseUtil.li = jSONObject.optInt("enable_native_wakeup", 0);
            adPlace.post_click_strategy = jSONObject.optInt("post_click_strategy", 0);
            QuickAppHelper.getInstance().setEnableQuickApp(adPlace.place_id, jSONObject.optInt("enable_quick_app", 1));
            try {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("quick_app_list");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        arrayList.add(jSONArrayOptJSONArray2.optString(i2));
                    }
                    QuickAppHelper.getInstance().addListQuickKey(arrayList);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("quickapp_match_rule_list");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            QuickappMatchRuleVo quickappMatchRuleVo = new QuickappMatchRuleVo();
                            quickappMatchRuleVo.setPrefix(jSONObjectOptJSONObject.optString(RequestParameters.PREFIX));
                            quickappMatchRuleVo.setContainsStr(jSONObjectOptJSONObject.optString("contains_str"));
                            arrayList2.add(quickappMatchRuleVo);
                        }
                    }
                    QuickAppHelper.getInstance().addListQuickMatch(arrayList2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVideoMutePlay(adPlace.place_id, jSONObject.optInt("video_mute_playback", 1) == 1);
            int iOptInt = jSONObject.optInt("bg_wake_up", 0);
            int iOptInt2 = jSONObject.optInt("bg_wake_up_time", 300);
            if (iOptInt == 1 && iOptInt2 > 0) {
                WParams wParams = new WParams(((long) iOptInt2) * 1000, adPlace.place_id);
                int i4 = this.mAdType;
                if (i4 == 1) {
                    YdAppBackgroundUtil.getInstance().setWakeUpParamsSpread(wParams);
                } else if (i4 == 3) {
                    YdAppBackgroundUtil.getInstance().setWakeUpParamsInterstitial(wParams);
                }
            }
            adPlace.ad_sources = buildAdSourceList(str, jSONObject, "ad_sources", reqID);
            adPlace.bid_ad_sources = buildAdSourceList(str, jSONObject, "bid_ad_sources", reqID);
            adPlace.bottom_ad_sources = buildAdSourceList(str, jSONObject, "bottom_ad_sources", reqID);
            adPlace.c2s_bid_ad_sources = buildAdSourceList(str, jSONObject, "client_bid_ad_sources", reqID);
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("support_sub_threads");
            if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                    arrayList3.add(Integer.valueOf(jSONArrayOptJSONArray4.optInt(i5, 0)));
                }
                if (!arrayList3.isEmpty()) {
                    this.mThreadAdvIds = arrayList3;
                }
            }
            return adPlace;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void initShowCount() {
        this.showCount = SPUtil.getInstance().getLong("showCount", 0L);
    }

    public void reqSDKBid(List<AdSource> list, String str, String str2, int i, final SdkBidListener sdkBidListener) {
        AdHttpUtils.getInstance().doPost(CommConstant.API.NEW_SDK_BID, AesUtils.encrypt(requestSdkBidParam(list, str, str2, i).toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ConfigHelper.4
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
                LogcatUtil.d("YdSDK-API", "req onError: " + exc.getMessage());
                sdkBidListener.onFailed("config response error:" + exc.getMessage());
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str3) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str3) {
                LogcatUtil.d("YdSDK-API", "ResponseData: " + str3);
                JSONObject responseNew = NetDataUtils.parseResponseNew(str3);
                if (responseNew != null) {
                    sdkBidListener.onSuccess(responseNew);
                } else {
                    sdkBidListener.onFailed("config response is null");
                }
            }
        });
    }

    public void reqVideoVerify(String str, String str2, String str3, String str4, String str5, String str6) {
        AdHttpUtils.getInstance().doPost(CommConstant.API.NEW_VIDEO_SERVER_VERIFY, AesUtils.encrypt(requestServerVerifyParam(str, str2, str3, str4, str5, str6).toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.base.rest.ConfigHelper.3
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str7) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str7) {
                LogcatUtil.d("YdSDK-API", "VideoVerify:" + str7);
            }
        });
    }

    public void requestConfig(boolean z, int i, String str, ApiSaaSListener apiSaaSListener, long j) {
        JSONObject jSONObjectOptJSONObject;
        try {
            this.mIsHot = z;
            this.mAdType = i;
            this.isReqDone[0] = false;
            this.isTimeout[0] = false;
            String config = getConfig(str);
            if (TextUtils.isEmpty(config) || (jSONObjectOptJSONObject = NetDataUtils.parseResponseNew(config).optJSONObject("adplace")) == null) {
                startReq(str, apiSaaSListener, -1, j);
            } else {
                startReq(str, apiSaaSListener, jSONObjectOptJSONObject.optInt("config_timeout"), j);
            }
        } catch (Throwable unused) {
            startReq(str, apiSaaSListener, -1, j);
        }
    }

    public void sdkTrafficReq(String str, String str2, String str3, String str4, String str5, boolean z, long j) {
        AdSource adSource = new AdSource();
        adSource.req_id = str;
        adSource.place_id = str2;
        adSource.group_id = str3;
        adSource.test_id = str4;
        adSource.isPreload = z;
        adSource.track_id = str5;
        adSource.cost_time = j;
        adSource.isHot = this.mIsHot;
        ReportHelper.getInstance().reportRequestAd(adSource);
    }

    public void setCacheAdTime(int i) {
        this.cacheAdTime = i;
    }

    public void setCacheSwitch(int i) {
        this.cacheSwitch = i;
    }

    public void setQueueNum(int i) {
        this.queueNum = i;
    }
}
