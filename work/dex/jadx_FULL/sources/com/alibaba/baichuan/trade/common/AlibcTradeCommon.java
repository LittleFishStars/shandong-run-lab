package com.alibaba.baichuan.trade.common;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.baichuan.log.LogLevel;
import com.alibaba.baichuan.log.TLogInitializer;
import com.alibaba.baichuan.trade.common.callback.AlibcCommonInitCallback;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.mtop.AlibcMtop;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTradeCommon extends AlibcBaseTradeCommon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24541a = "AlibcTradeCommon";
    public static boolean initialized = false;
    public static Application sApplication;
    public static Map<String, Object> sExtParams;

    public static class AlibcTradeCommonResult {
        public static final int COMMON_INIT_AD = 2;
        public static final int COMMON_INIT_FAIL = 1;
        public static final int COMMON_INIT_SUCCESS = 0;
        public int errCode;
        public String errMsg;
        public int result = 0;
    }

    public static boolean checkCommon() {
        return (AlibcBaseTradeCommon.context == null || TextUtils.isEmpty("5.0.2.5")) ? false : true;
    }

    public static AlibcTradeCommonResult init(Application application, JSONObject jSONObject, Map<String, Object> map) {
        int i;
        int i2;
        AlibcTradeCommonResult alibcTradeCommonResult = new AlibcTradeCommonResult();
        if (initialized) {
            return alibcTradeCommonResult;
        }
        if (application == null || TextUtils.isEmpty("5.0.2.5")) {
            alibcTradeCommonResult.errCode = -1;
            alibcTradeCommonResult.errMsg = AlibcCommonConstant.PARAM_INVALID_MSG;
            return alibcTradeCommonResult;
        }
        AlibcBaseTradeCommon.context = application;
        long jCurrentTimeMillis = System.currentTimeMillis();
        AlibcSecurityGuard.a aVarInit = AlibcSecurityGuard.getInstance().init();
        int i3 = aVarInit.f24562a;
        if (i3 == 1) {
            alibcTradeCommonResult.errCode = aVarInit.b;
            alibcTradeCommonResult.errMsg = aVarInit.c;
        }
        alibcTradeCommonResult.result = i3;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (alibcTradeCommonResult.result == 1) {
            HashMap map2 = new HashMap();
            map2.put("cost", jCurrentTimeMillis2 + "ms");
            map2.put("errorCode", String.valueOf(alibcTradeCommonResult.errCode));
            map2.put("errorMsg", alibcTradeCommonResult.errMsg);
            AlibcLogger.saveLog("baichuan", "SECURITY_INIT_FAIL", "SECURITY_SDK_INIT", "security init fail", map2, "error");
            return alibcTradeCommonResult;
        }
        HashMap map3 = new HashMap();
        map3.put("cost", jCurrentTimeMillis2 + "ms");
        AlibcLogger.saveLog("baichuan", "SECURITY_INIT_SUCCESS", "SECURITY_SDK_INIT", "security init success", map3, "normal");
        jSONObject.put("security_cost", (Object) String.valueOf(jCurrentTimeMillis2));
        if (AlibcCommonUtils.verifySdkExist("com.ut.device.UTDevice", AlibcCommonConstant.UT_SDK_TAG)) {
            AlibcBaseTradeCommon.utdid = UTDevice.getUtdid(AlibcBaseTradeCommon.context);
        }
        AlibcBaseTradeCommon.appKey = AlibcSecurityGuard.getInstance().getAppKey();
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        AlibcUserTracker.AlibcUserTrackerResult alibcUserTrackerResultInit = AlibcUserTracker.getInstance().init();
        if (alibcUserTrackerResultInit == null || (i2 = alibcUserTrackerResultInit.result) == 1) {
            alibcTradeCommonResult.errCode = 200;
            alibcTradeCommonResult.errMsg = AlibcCommonConstant.UT_INIT_FAIL_ERROR_MSG;
        } else {
            alibcTradeCommonResult.result = i2;
        }
        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
        if (alibcTradeCommonResult.result == 1) {
            HashMap map4 = new HashMap();
            map4.put("cost", jCurrentTimeMillis4 + "ms");
            map4.put("errorCode", String.valueOf(alibcTradeCommonResult.errCode));
            map4.put("errorMsg", alibcTradeCommonResult.errMsg);
            AlibcLogger.saveLog("baichuan", "UT_INIT_FAIL", "UT_SDK_INIT", "ut init fail", map4, "error");
            return alibcTradeCommonResult;
        }
        HashMap map5 = new HashMap();
        map5.put("cost", jCurrentTimeMillis2 + "ms");
        AlibcLogger.saveLog("baichuan", "UT_INIT_SUCCESS", "UT_SDK_INIT", "ut init success", map5, "normal");
        jSONObject.put("ut_cost", (Object) String.valueOf(jCurrentTimeMillis4));
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        AlibcMtop.a aVarInit2 = AlibcMtop.getInstance().init(map);
        if (aVarInit2 == null || (i = aVarInit2.f24549a) == 1) {
            alibcTradeCommonResult.errCode = 300;
            alibcTradeCommonResult.errMsg = AlibcCommonConstant.MTOP_INIT_FAIL_ERROR_MSG;
        } else {
            alibcTradeCommonResult.result = i;
        }
        long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis5;
        if (alibcTradeCommonResult.result == 1) {
            HashMap map6 = new HashMap();
            map6.put("cost", jCurrentTimeMillis6 + "ms");
            map6.put("errorCode", String.valueOf(alibcTradeCommonResult.errCode));
            map6.put("errorMsg", alibcTradeCommonResult.errMsg);
            AlibcLogger.saveLog("baichuan", "MTOP_INIT_FAIL", "MTOP_SDK_INIT", "mtop init fail", map6, "error");
            return alibcTradeCommonResult;
        }
        HashMap map7 = new HashMap();
        map7.put("cost", jCurrentTimeMillis2 + "ms");
        AlibcLogger.saveLog("baichuan", "MTOP_INIT_SUCCESS", "MTOP_SDK_INIT", "mtop init success", map7, "normal");
        jSONObject.put("mtop_cost", (Object) String.valueOf(jCurrentTimeMillis6));
        long jCurrentTimeMillis7 = System.currentTimeMillis();
        TLogInitializer.getInstance().changeRsaPublishKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCeRP3+TkDD5u9Y/XLEGvjvUZKCx6uhcH83BrsMAqDtYB+ixUqAlOYRme4IIisnavuIlnAqJBKxdrIKFu8eR03refR+YmWUE80e4IkxPj9RamwtxWOu6ETRRVWubo4Yg8cuSNWGt2LLWcZ53XsNiJRW2iCVVZRIooHA798orl6eiwIDAQAB");
        TLogInitializer.getInstance().builder(application, LogLevel.ALL, "baichuan", application.getPackageName(), AlibcBaseTradeCommon.appKey, "5.0.2.5").setApplication(application).setSecurityKey("65914cd31012d1dab0a663373deef813").setUtdid(AlibcBaseTradeCommon.utdid).init();
        jSONObject.put("tlog_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis7));
        initialized = true;
        return alibcTradeCommonResult;
    }

    public static synchronized void init(final Application application, final AlibcCommonInitCallback alibcCommonInitCallback) {
        ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.baichuan.trade.common.AlibcTradeCommon.1
            @Override // java.lang.Runnable
            public final void run() {
                final AlibcTradeCommonResult alibcTradeCommonResultInit = AlibcTradeCommon.init(application, new JSONObject(), new HashMap());
                if (alibcTradeCommonResultInit.result == 0) {
                    ExecutorManager.getTaskExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.baichuan.trade.common.AlibcTradeCommon.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AlibcLogger.i(AlibcTradeCommon.f24541a, "common init success");
                            alibcCommonInitCallback.onSuccess();
                        }
                    });
                } else {
                    ExecutorManager.getTaskExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.baichuan.trade.common.AlibcTradeCommon.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AlibcLogger.e(AlibcTradeCommon.f24541a, "common init fail");
                            AlibcCommonInitCallback alibcCommonInitCallback2 = alibcCommonInitCallback;
                            AlibcTradeCommonResult alibcTradeCommonResult = alibcTradeCommonResultInit;
                            alibcCommonInitCallback2.onFailure(alibcTradeCommonResult.errCode, alibcTradeCommonResult.errMsg);
                        }
                    });
                }
            }
        });
    }
}
