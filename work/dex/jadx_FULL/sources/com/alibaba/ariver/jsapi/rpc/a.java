package com.alibaba.ariver.jsapi.rpc;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.rpc.RVRpcConfig;
import com.alibaba.ariver.kernel.common.rpc.RVRpcProxy;
import com.alibaba.ariver.kernel.common.rpc.RVRpcResponse;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.PatternUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24172a = "RVRpcCallHelper";
    private static final String b = "{\"http(s?):\\\\/\\\\/bkmobilegw(.*)\\\\/mgw\\\\.htm\":\"23387407\"}";

    public static Object a(boolean z, String str, String str2, String str3, boolean z2, JSONObject jSONObject, String str4, boolean z3, App app, Page page, int i, String str5) {
        return a(z, str, str2, str3, z2, jSONObject, str4, z3, app, page, i, "json", false, -1, str5).getResponse();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_rpcAppKeyConfig_android", "{\"http(s?):\\\\/\\\\/mobilegw\\\\.shulidata\\\\.com\\\\/mgw\\\\.htm\": \"rpc-sdk-online\",\"http(s?):\\\\/\\\\/bkmobilegw(.*)\\\\/mgw\\\\.htm\": \"23387407\"}");
        if (TextUtils.isEmpty(config)) {
            config = b;
        }
        JSONObject object = JSONUtils.parseObject(config);
        if (object == null) {
            return "";
        }
        for (String str2 : object.keySet()) {
            if (PatternUtils.matchRegex(str2, str)) {
                RVLogger.d(f24172a, "getAppKey match key " + str2);
                return object.getString(str2);
            }
        }
        return "";
    }

    public static RVRpcResponse a(boolean z, String str, Object obj, String str2, boolean z2, JSONObject jSONObject, String str3, boolean z3, App app, Page page, int i, String str4, boolean z4, int i2, String str5) {
        RVLogger.d(f24172a, "rpcCall, type " + str4);
        boolean zA = a(str4);
        String str6 = !TextUtils.isEmpty(str2) ? str2 : "https://mobilegw.alipay.com/mgw.htm";
        RVLogger.debug(f24172a, "set rpc url " + str6);
        if (z && jSONObject != null && page != null) {
            jSONObject.put("OPEN_RPC_REQUEST_URL", (Object) page.getPageURI());
        }
        return ((RVRpcProxy) RVProxy.get(RVRpcProxy.class)).sendSimpleRpc(page == null ? app : page, zA, str, new RVRpcConfig.Builder().gwUrl(str6).compress(Boolean.valueOf(z2)).getMethod(Boolean.valueOf(z4)).allowRetry(Boolean.valueOf(z3)).timeout(Long.valueOf(((long) i) * 1000)).appKey(str3).region(str5).requestHeader(a(jSONObject)).build(), obj, null);
    }

    private static Map<String, String> a(JSONObject jSONObject) {
        if (jSONObject != null && !jSONObject.isEmpty()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                map.put(entry.getKey(), (String) entry.getValue());
            }
            return map;
        }
        return new HashMap();
    }

    public static boolean a(String str) {
        return "pb".equals(str);
    }
}
