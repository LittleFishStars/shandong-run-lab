package com.alibaba.triver.open.impl;

import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibcprotocol.TRiverConstant;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.inside.impl.RVMonitorProxyImpl;
import com.alibaba.triver.trace.c;
import com.alibaba.triver.utils.CommonUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.heytap.mcssdk.constant.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MonitorProxyImpl extends RVMonitorProxyImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25057a = "MonitorProxyImpl";

    private synchronized void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String string = jSONObject.getString("errorCode");
            if ("EXECUTE_JS_CONTEXT_FAIL".equals(string)) {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(LoginConstants.EXT);
                if (jSONObject2 != null) {
                    String string2 = jSONObject2.getString("url");
                    if (!TextUtils.isEmpty(string2) && string2.contains("3000000003738335")) {
                        TRiverConstant.BC_LINK_CODE = TSErrorEnum.JS_EXECUTE_ERROR_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
                    }
                }
            } else if ("APP_LOAD_CACHE_FAIL".equals(string)) {
                if ("3000000003738335".equals(jSONObject.getString("appId"))) {
                    TRiverConstant.BC_LINK_CODE = TSErrorEnum.PLUGIN_LOAD_ERROR_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
                }
            } else if (c.B.equals(string)) {
                TRiverConstant.BC_LINK_CODE = TSErrorEnum.APP_START_ERROR_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
            }
        }
    }

    @Override // com.alibaba.triver.inside.impl.RVMonitorProxyImpl, com.alibaba.ariver.app.api.monitor.RVMonitor
    public void errorLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorCode", TextUtils.isEmpty(str) ? "" : str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put("errorMsg", (Object) str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            jSONObject.put("subType", (Object) str3);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            jSONObject.put("appId", (Object) str4);
            if (TextUtils.isEmpty(str5)) {
                str5 = "";
            }
            jSONObject.put("pageName", (Object) str5);
            jSONObject.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry != null) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception unused) {
            }
            if (c.K.equals(str)) {
                jSONObject2.put(AlibcCommonConstant.OPEN_ERROR_CODE, (Object) "TA1000");
                jSONObject2.put("技术支持", (Object) "请根据错误码到答疑群@答疑机器人");
            }
            jSONObject.put(LoginConstants.EXT, (Object) jSONObject2);
            jSONObject.put("processName", ProcessUtils.getProcessName());
            if (CommonUtils.isCatchToolsLogForRelease()) {
                RVLogger.e("Triver.errorLog", jSONObject.toJSONString());
            }
            RVLogger.e("errorLog", jSONObject.toJSONString());
            a(jSONObject);
        } catch (Throwable th) {
            RVLogger.e(f25057a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.inside.impl.RVMonitorProxyImpl, com.alibaba.ariver.app.api.monitor.RVMonitor
    public void flowLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                RVLogger.w(Log.getStackTraceString(th));
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        jSONObject.put(b.k, (Object) str);
        jSONObject.put(AliyunLogCommon.LogLevel.INFO, TextUtils.isEmpty(str2) ? "" : str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        jSONObject.put("stage", (Object) str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        jSONObject.put("appId", (Object) str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        jSONObject.put("pageName", (Object) str5);
        jSONObject.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject2 = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String strValueOf = String.valueOf(entry.getValue());
                    if (!TextUtils.isEmpty(str2) && str2.contains("sendMtop")) {
                        if ("data".equals(key)) {
                            if (strValueOf.length() > 2000) {
                                strValueOf = "返回数据过长不展示";
                            }
                        } else if ("api".equals(key) && "mtop.uzjump.business.cps.click.add".equals(strValueOf)) {
                            TRiverConstant.BC_LINK_CODE = TSErrorEnum.LIVE_CPS_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
                        }
                    }
                    jSONObject2.put(key, (Object) strValueOf);
                }
            }
        } catch (Exception unused) {
        }
        jSONObject.put(LoginConstants.EXT, (Object) jSONObject2);
        jSONObject.put("processName", ProcessUtils.getProcessName());
        if (CommonUtils.isCatchToolsLogForRelease()) {
            RVLogger.e("Triver.flowLog", jSONObject.toJSONString());
        }
        RVLogger.d("flowLog", jSONObject.toJSONString());
    }
}
