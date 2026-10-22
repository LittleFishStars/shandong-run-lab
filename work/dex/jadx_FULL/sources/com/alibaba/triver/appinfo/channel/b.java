package com.alibaba.triver.appinfo.channel;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.Triver;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.utils.g;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24633a = "AppInfoCenter";
    private static final Pattern b = Pattern.compile("charset=([a-z0-9-]+)");
    private RouterConfigModel.ChannelModel c;

    public static int b() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return 10000;
            }
            String str = configsByGroup.get("cndRequestTimeoutMillis");
            if (TextUtils.isEmpty(str)) {
                return 10000;
            }
            return Integer.parseInt(str);
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "getTimeout error", e);
            return 10000;
        }
    }

    private static String c() {
        try {
            return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appVersion");
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "http channel getAppVersion error", e);
            return "";
        }
    }

    private static String d() {
        try {
            return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appKey");
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "http channel getAppKey error", e);
            return "";
        }
    }

    private static String e() {
        try {
            return ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(null);
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "http channel getUserId error", e);
            return "";
        }
    }

    private static String f() {
        try {
            return ((RVAccountService) RVProxy.get(RVAccountService.class)).getNick(null);
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "http channel getUserNick error", e);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v63, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [com.alibaba.triver.kit.api.network.CommonResponse] */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.alibaba.triver.kit.api.network.CommonResponse, com.alibaba.triver.kit.api.network.CommonResponse<java.util.List<com.alibaba.triver.appinfo.channel.TriverAppModel>, com.alibaba.fastjson.JSONObject>] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.alibaba.triver.appinfo.channel.b] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.alibaba.triver.appinfo.channel.b] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.alibaba.triver.appinfo.core.AppRequestParams] */
    /* JADX WARN: Type inference failed for: r32v1 */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3 */
    /* JADX WARN: Type inference failed for: r32v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r32v6 */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.alibaba.triver.kit.api.network.CommonResponse, com.alibaba.triver.kit.api.network.CommonResponse<java.util.List<com.alibaba.triver.appinfo.channel.TriverAppModel>, com.alibaba.fastjson.JSONObject>] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.alibaba.triver.kit.api.network.CommonResponse, com.alibaba.triver.kit.api.network.CommonResponse<java.util.List<com.alibaba.triver.appinfo.channel.TriverAppModel>, com.alibaba.fastjson.JSONObject>] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.alibaba.triver.kit.api.network.CommonResponse<java.util.List<com.alibaba.triver.appinfo.channel.TriverAppModel>, com.alibaba.fastjson.JSONObject>] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v45, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v46, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v29, types: [com.alibaba.ariver.app.api.monitor.RVMonitor] */
    @Override // com.alibaba.triver.appinfo.channel.d
    public CommonResponse<List<TriverAppModel>, JSONObject> a(AppRequestParams appRequestParams) {
        String str;
        ?? r15;
        long jCurrentTimeMillis = System.currentTimeMillis();
        RouterConfigModel.ChannelModel channelModel = this.c;
        String str2 = (channelModel == null || TextUtils.isEmpty(channelModel.name)) ? "cdnRequest_ori" : this.c.name + "_ori";
        Pair<String, String> pair = appRequestParams.mainRequest;
        String str3 = (String) pair.first;
        String str4 = (String) pair.second;
        CommonResponse<List<TriverAppModel>, JSONObject> commonResponse = new CommonResponse<>();
        String strC = c();
        String strC2 = a.a().c();
        String strE = e();
        String strF = f();
        String utdid = Triver.getUtdid();
        if (TextUtils.isEmpty(utdid)) {
            RVLogger.e("AppInfoCenter", "utdid获取失败，降级回mtop请求。");
            commonResponse.success = false;
            commonResponse.errorCode = "ERR_UTDID_NOT_FOUND";
            commonResponse.errorMsg = "utdid未找到";
            com.alibaba.triver.appinfo.a.b.a(str3, str4, str2, jCurrentTimeMillis, System.currentTimeMillis(), commonResponse.errorCode, commonResponse.errorMsg, null);
            return commonResponse;
        }
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            RVLogger.e("AppInfoCenter", "mtopAppKey获取失败，降级回mtop请求。");
            commonResponse.success = false;
            commonResponse.errorCode = "ERR_MTOP_APPKEY_NOT_FOUND";
            commonResponse.errorMsg = "mtopAppKey未找到";
            com.alibaba.triver.appinfo.a.b.a(str3, str4, str2, jCurrentTimeMillis, System.currentTimeMillis(), commonResponse.errorCode, commonResponse.errorMsg, null);
            return commonResponse;
        }
        String str5 = TextUtils.equals("*", str4) ? "" : str4;
        String str6 = appRequestParams.oriUrl;
        Map<String, String> map = new HashMap<>();
        map.put("miniapp-cx-client-version", strC == null ? "" : a(strC));
        map.put("miniapp-cx-router-version", strC2 == null ? "" : a(strC2));
        map.put("miniapp-cx-platform", a("Android"));
        map.put("miniapp-cx-sdk-version", a(TRiverConstants.REQUEST_SDK_VERSION));
        map.put("miniapp-cx-user-id", strE == null ? "" : a(strE));
        map.put("miniapp-cx-user-nick", strF == null ? "" : a(strF));
        map.put("miniapp-cx-utdid", a(utdid));
        List<String> listA = g.a(map.keySet());
        ArrayList arrayList = new ArrayList();
        arrayList.add("GET");
        for (String str7 : listA) {
            arrayList.add(str7 + "=" + map.get(str7));
        }
        arrayList.add("");
        arrayList.add("appId=" + str3);
        arrayList.add("mtopAppkey=" + strD);
        StringBuilder sb = new StringBuilder();
        sb.append("version=");
        sb.append(str5 == null ? "" : str5);
        arrayList.add(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fullUrl=");
        sb2.append(str6 == null ? "" : str6);
        arrayList.add(sb2.toString());
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        String strA = g.a(arrayList);
        String str8 = str3 + " http request sign cost " + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms.";
        String str9 = "";
        ?? r1 = commonResponse;
        r1 = 0;
        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("APP_INFO_STATIC_SIGN_SUCCESS", str8, "AppInfo", str3, null, null);
        RVLogger.d("AppInfoCenter", str8);
        if (TextUtils.isEmpty(strA)) {
            RVLogger.e("AppInfoCenter", "请求加签失败，降级回mtop请求。");
            r1.success = false;
            r1.errorCode = "ERR_LOCAL_SIGN_FAIL";
            r1.errorMsg = "本地签名生成失败";
            com.alibaba.triver.appinfo.a.b.a(str3, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r1.errorCode, r1.errorMsg, null);
            return r1;
        }
        map.put("miniapp-sign-content", strA);
        map.put("miniapp-utdid-hash", a.a().b() + str9);
        try {
            String envValue = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue(TRiverConstants.KEY_ENVIRONMENT_INDEX);
            try {
                if (TextUtils.isEmpty(envValue) || "0".equals(envValue)) {
                    b bVar = this;
                    str = bVar.c.onlineHost;
                    r1 = bVar;
                } else {
                    b bVar2 = this;
                    str = bVar2.c.preHost;
                    r1 = bVar2;
                }
            } catch (Exception e) {
                e = e;
                RVLogger.e("AppInfoCenter", "http channel check env error", e);
                str = r1.c.onlineHost;
            }
        } catch (Exception e2) {
            e = e2;
            r1 = r1;
            r1 = this;
        }
        Uri uriBuild = Uri.parse(str).buildUpon().appendQueryParameter("mtopAppkey", strD).appendQueryParameter("appId", str3).appendQueryParameter("version", str5 == null ? str9 : str5).appendQueryParameter("fullUrl", str6 != null ? str6 : "").build();
        int iB = b();
        RVTransportService rVTransportService = (RVTransportService) RVProxy.get(RVTransportService.class);
        RVHttpRequest rVHttpRequestBuild = RVHttpRequest.newBuilder().headers(map).method("GET").url(uriBuild.toString()).requestData(null).timeout(iB).build();
        rVHttpRequestBuild.addExtParams("retryTime", "0");
        boolean zDrowngradeSyncCdnRequest = TROrangeController.drowngradeSyncCdnRequest();
        ?? r5 = TRiverConstants.CDN_REQUEST_TYPE;
        if (zDrowngradeSyncCdnRequest) {
            rVHttpRequestBuild.addExtParams(TRiverConstants.CDN_REQUEST_TYPE, NativeCallContext.CALL_MODE_SYNC);
        } else {
            rVHttpRequestBuild.addExtParams(TRiverConstants.CDN_REQUEST_TYPE, "async");
        }
        try {
            RVHttpResponse rVHttpResponseHttpRequest = rVTransportService.httpRequest(rVHttpRequestBuild);
            try {
                if (rVHttpResponseHttpRequest == null) {
                    r1.success = false;
                    r1.errorCode = "ERR_EMPTY_RESPONSE";
                    r1.errorMsg = "ERR_EMPTY_RESPONSE";
                    ?? r6 = r1;
                    com.alibaba.triver.appinfo.a.b.a(str3, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r1.errorCode, r1.errorMsg, null);
                    return r6;
                }
                r5 = r1;
                appRequestParams = str3;
                try {
                    if (rVHttpResponseHttpRequest.getStatusCode() < 200 || rVHttpResponseHttpRequest.getStatusCode() >= 300) {
                        if (rVHttpResponseHttpRequest.getStatusCode() == -1) {
                            r5.success = false;
                            r5.errorCode = com.alibaba.triver.open.api.c.c;
                            r5.errorMsg = com.alibaba.triver.open.api.c.c;
                            com.alibaba.triver.appinfo.a.b.a(appRequestParams, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r5.errorCode, r5.errorMsg, null);
                            return r5;
                        }
                        r5.success = false;
                        r5.errorCode = "ERR_REQUEST_FAILED";
                        r5.errorMsg = "errorCode::" + rVHttpResponseHttpRequest.getStatusCode();
                        com.alibaba.triver.appinfo.a.b.a(appRequestParams, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r5.errorCode, r5.errorMsg, null);
                        return r5;
                    }
                    InputStream resStream = rVHttpResponseHttpRequest.getResStream();
                    if (resStream == null) {
                        r5.success = false;
                        r5.errorCode = "ERR_EMPTY_DATA";
                        r5.errorMsg = "ERR_EMPTY_DATA";
                        com.alibaba.triver.appinfo.a.b.a(appRequestParams, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r5.errorCode, r5.errorMsg, null);
                        return r5;
                    }
                    Map<String, String> mapA = a(rVHttpResponseHttpRequest);
                    String str10 = mapA.get(com.alipay.sdk.m.t.e.f);
                    if (TextUtils.isEmpty(str10)) {
                        str10 = mapA.get("Content-Type");
                    }
                    String strA2 = a(resStream, str10);
                    if (strA2 == null) {
                        r5.success = false;
                        r5.errorCode = "ERR_EMPTY_DATA";
                        r5.errorMsg = "ERR_EMPTY_DATA";
                        com.alibaba.triver.appinfo.a.b.a(appRequestParams, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r5.errorCode, r5.errorMsg, null);
                        return r5;
                    }
                    ?? sb3 = new StringBuilder();
                    ?? r16 = appRequestParams;
                    try {
                        sb3.append(r16);
                        sb3.append(" response data:");
                        sb3.append(strA2);
                        RVLogger.d("AppInfoCenter", sb3.toString());
                        try {
                            ?? r0 = (List) JSON.parseObject(strA2, new TypeReference<List<TriverAppModel>>() { // from class: com.alibaba.triver.appinfo.channel.b.1
                            }, new Feature[0]);
                            if (r0 != 0 && !r0.isEmpty()) {
                                r5.success = true;
                                r5.successData = r0;
                                String str11 = r16 + " http SyncLoad request cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms.";
                                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("APP_INFO_STATIC_REQUEST_SUCCESS", str11, "AppInfo", r16, null, null);
                                RVLogger.d("AppInfoCenter", str11);
                                ?? r17 = r16;
                                for (TriverAppModel triverAppModel : r0) {
                                    if (triverAppModel != null && TextUtils.equals(r17, triverAppModel.getAppId())) {
                                        if (triverAppModel.success) {
                                            com.alibaba.triver.appinfo.a.b.a((String) r17, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), (Bundle) null);
                                        } else {
                                            com.alibaba.triver.appinfo.a.b.a(r17, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), triverAppModel.errorCode, triverAppModel.errorMsg, null);
                                        }
                                    }
                                    r17 = r17;
                                }
                                return r5;
                            }
                            r5.success = false;
                            r5.errorCode = "ERR_EMPTY_DATA";
                            r5.errorMsg = "ERR_EMPTY_DATA";
                            com.alibaba.triver.appinfo.a.b.a(r16, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r5.errorCode, r5.errorMsg, null);
                            return r5;
                        } catch (Exception e3) {
                            ?? sb4 = new StringBuilder();
                            sb4.append(r16);
                            try {
                                sb4.append("http channel send request error");
                                RVLogger.e("AppInfoCenter", sb4.toString(), e3);
                                r5.success = false;
                                r5.errorCode = "ERR_RESPONSE_PARSE";
                                r5.errorMsg = e3.getMessage();
                                com.alibaba.triver.appinfo.a.b.a(r16, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r5.errorCode, r5.errorMsg, null);
                                return r5;
                            } catch (Exception e4) {
                                e = e4;
                                r1 = "http channel send request error";
                                appRequestParams = r16;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        r5 = r5;
                        r15 = r16;
                        appRequestParams = r15;
                        r1 = "http channel send request error";
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Exception e7) {
                e = e7;
                r1 = "http channel send request error";
            }
        } catch (Exception e8) {
            e = e8;
            r5 = r1;
            r15 = str3;
        }
        appRequestParams = r15;
        r1 = "http channel send request error";
        ?? sb5 = new StringBuilder();
        ?? r7 = appRequestParams;
        sb5.append(r7);
        sb5.append(r1);
        RVLogger.e("AppInfoCenter", sb5.toString(), e);
        r5.success = false;
        r5.errorCode = "ERR_SYSTEM_ERROR";
        r5.errorMsg = e.getMessage();
        com.alibaba.triver.appinfo.a.b.a(r7, str5, str2, jCurrentTimeMillis, System.currentTimeMillis(), r5.errorCode, r5.errorMsg, null);
        return r5;
    }

    @Override // com.alibaba.triver.appinfo.channel.d
    public void a(RouterConfigModel.ChannelModel channelModel) {
        this.c = channelModel;
    }

    @Override // com.alibaba.triver.appinfo.channel.d
    public RouterConfigModel.GuardConfig a() {
        RouterConfigModel.ChannelModel channelModel = this.c;
        if (channelModel != null) {
            return channelModel.guardConfig;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    private static String a(InputStream inputStream, String str) {
        String strGroup;
        if (str != null) {
            Matcher matcher = b.matcher(str.toLowerCase());
            if (matcher.find()) {
                strGroup = matcher.group(1);
            } else {
                strGroup = "utf-8";
            }
        } else {
            strGroup = "utf-8";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            return byteArrayOutputStream.toString(strGroup);
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "http channel readAsString error", e);
            return byteArrayOutputStream.toString();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e2) {
                RVLogger.e("AppInfoCenter", "http channel readAsString error", e2);
            }
        }
    }

    private static Map<String, String> a(RVHttpResponse rVHttpResponse) {
        HashMap map = new HashMap();
        if (rVHttpResponse.getHeaders() != null) {
            for (Map.Entry<String, List<String>> entry : rVHttpResponse.getHeaders().entrySet()) {
                if (entry.getValue().size() > 0) {
                    map.put(entry.getKey() == null ? LoginConstants.UNDER_LINE : entry.getKey(), entry.getValue().get(0));
                }
            }
        }
        return map;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "encode str error", e);
            return null;
        }
    }
}
