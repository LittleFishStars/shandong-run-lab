package com.alibaba.triver.open.api;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.jsapi.network.NetworkBridgeExtension;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.utils.CommonUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliNetworkBridgeExtension extends NetworkBridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25029a = "AliNetworkBridgeExtension";
    private static final int b = 13;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Object obj, BridgeCallback bridgeCallback, String str2, long j, Page page) {
        if (page != null && page.getApp() != null) {
            if (!(obj instanceof Map)) {
                new HashMap().put("status", "PARSE_RESPONSE_FAILED");
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "Error"));
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("HTTP_REQUEST_FAILED", str2 + TRiverConstants.TOOL_SPLIT + "TimeCost=" + (System.currentTimeMillis() - j) + TRiverConstants.TOOL_SPLIT + "ErrorCode=12" + TRiverConstants.TOOL_SPLIT + "ErrorMsg=PARSE_RESPONSE_FAILED", "Api", page.getApp().getAppId(), null, null);
                a(str, page, System.currentTimeMillis() - j, "12", "PARSE_RESPONSE_FAILED");
                return;
            }
            Map map = (Map) obj;
            if (Boolean.TRUE.equals(map.get("ok"))) {
                JSONObject jSONObject = new JSONObject();
                Object string = map.get("data");
                if (string instanceof JSONObject) {
                    string = ((JSONObject) string).toJSONString();
                } else if (string instanceof JSONArray) {
                    string = ((JSONArray) string).toJSONString();
                } else if (!(string instanceof String) && !(string instanceof byte[])) {
                    string = string instanceof Object ? string.toString() : null;
                }
                jSONObject.put("data", string);
                jSONObject.put("headers", map.get("headers"));
                jSONObject.put("status", map.get("status"));
                bridgeCallback.sendJSONResponse(jSONObject);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("HTTP_REQUEST_SUCCESS", str2 + TRiverConstants.TOOL_SPLIT + "TimeCost=" + (System.currentTimeMillis() - j) + TRiverConstants.TOOL_SPLIT + "status=" + map.get("status"), "Api", page.getApp().getAppId(), null, null);
                a(str, page, System.currentTimeMillis() - j);
                return;
            }
            String strValueOf = String.valueOf(map.get("status"));
            String strValueOf2 = String.valueOf(map.get(b.f25039a));
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "Error"));
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("HTTP_REQUEST_FAILED", str2 + TRiverConstants.TOOL_SPLIT + "TimeCost=" + (System.currentTimeMillis() - j) + TRiverConstants.TOOL_SPLIT + "ErrorCode=12", "Api", page.getApp().getAppId(), null, null);
            a(str, page, System.currentTimeMillis() - j, strValueOf, strValueOf2);
        }
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void downloadFile(@BindingApiContext(required = true) ApiContext apiContext, @BindingNode(App.class) App app, @BindingParam(name = {"url"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Activity activity = apiContext.getActivity();
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "Url null"));
            return;
        }
        if (activity == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "Context empty"));
            return;
        }
        byte[] bArrDecode = null;
        try {
            if (CommonUtils.checkIsBase64(str)) {
                bArrDecode = Base64.decode(str, 0);
            }
        } catch (Throwable unused) {
        }
        if (bArrDecode == null) {
            a.a(activity, str, bridgeCallback, app.getAppId());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getApplicationContext().getExternalCacheDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ariver");
        sb.append(str2);
        sb.append(app.getAppId());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, String.valueOf(SystemClock.currentThreadTimeMillis()));
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            bufferedOutputStream.write(bArrDecode);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apFilePath", (Object) FileUtils.filePathToApUrl(file2.getPath(), ""));
            bridgeCallback.sendJSONResponse(jSONObject);
        } catch (Exception e) {
            RVLogger.e("downloadFile writeString2LocalFile", e);
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, "write fail"));
        }
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void httpRequest(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam(name = {"url"}) String str, @BindingParam(name = {"headers"}) Object obj, @BindingParam(name = {"method"}) String str2, @BindingParam(name = {"data"}) String str3, @BindingParam(name = {com.alipay.sdk.m.o.b.r0}) float f, @BindingParam(name = {"dataType"}) String str4, @BindingParam({"__appxDomain"}) String str5, @BindingCallback BridgeCallback bridgeCallback) {
        a(app, page, str5, str, obj, str2, str3, f, str4, bridgeCallback);
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void request(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam(name = {"url"}) String str, @BindingParam(name = {"headers"}) Object obj, @BindingParam(name = {"method"}) String str2, @BindingParam(name = {"data"}) String str3, @BindingParam(name = {com.alipay.sdk.m.o.b.r0}) float f, @BindingParam(name = {"dataType"}) String str4, @BindingParam({"__appxDomain"}) String str5, @BindingCallback BridgeCallback bridgeCallback) {
        a(app, page, str5, str, obj, str2, str3, f, str4, bridgeCallback);
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void uploadFile(@BindingApiContext(required = true) ApiContext apiContext, @BindingNode(App.class) App app, @BindingParam(name = {"url"}) String str, @BindingParam(name = {"filePath"}) String str2, @BindingParam(name = {"localId"}) String str3, @BindingParam(name = {"name"}) String str4, @BindingParam(name = {"type"}) String str5, @BindingParam(name = {"header"}) JSONObject jSONObject, @BindingParam(name = {"formData"}) JSONObject jSONObject2, @BindingCallback BridgeCallback bridgeCallback) {
        String str6 = TextUtils.isEmpty(str2) ? str3 : str2;
        if (TextUtils.isEmpty(str6)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "filePath null"));
            RVLogger.e("UploadFile filePath null");
            return;
        }
        String strApUrlToFilePath = FileUtils.apUrlToFilePath(str6);
        if (TextUtils.isEmpty(strApUrlToFilePath) || strApUrlToFilePath.split("\\.").length < 2 || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "arguments error"));
            RVLogger.e("UploadFile arguments error");
            return;
        }
        Context context = app.getAppContext().getContext();
        if (context instanceof Activity) {
            a.a((Activity) context, bridgeCallback, jSONObject2, strApUrlToFilePath, str4, str5, str, jSONObject);
        } else {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "App context not Activity"));
            RVLogger.e("UploadFile App context not Activity");
        }
    }

    private void a(String str, Page page, long j) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeCost", (Object) Long.valueOf(j));
        jSONObject.put("url", (Object) str);
        if (page != null && page.getApp() != null && page.getApp().getData(AppModel.class) != null) {
            jSONObject.put("miniAppId", (Object) page.getApp().getAppId());
            jSONObject.put("deployVersion", (Object) ((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getVersion());
            jSONObject.put("developerVersion", (Object) ((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getDeveloperVersion());
            if (((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getTemplateConfig() != null) {
                jSONObject.put("templateId", (Object) ((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getTemplateConfig().getTemplateId());
            }
            if (((AppModel) page.getApp().getData(AppModel.class)).getExtendInfos() != null) {
                jSONObject.put("bizType", (Object) String.valueOf(((AppModel) page.getApp().getData(AppModel.class)).getExtendInfos().getInteger("bizType")));
                jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, (Object) String.valueOf(((AppModel) page.getApp().getData(AppModel.class)).getExtendInfos().getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE)));
            }
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "http", null, null, jSONObject.toString());
    }

    private void a(String str, Page page, long j, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeCost", (Object) Long.valueOf(j));
        jSONObject.put("url", (Object) str);
        if (page != null && page.getApp() != null && page.getApp().getData(AppModel.class) != null) {
            jSONObject.put("miniAppId", (Object) page.getApp().getAppId());
            jSONObject.put("deployVersion", (Object) ((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getVersion());
            jSONObject.put("developerVersion", (Object) ((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getDeveloperVersion());
            if (((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getTemplateConfig() != null) {
                jSONObject.put("templateId", (Object) ((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getTemplateConfig().getTemplateId());
            }
            if (((AppModel) page.getApp().getData(AppModel.class)).getExtendInfos() != null) {
                jSONObject.put("bizType", (Object) String.valueOf(((AppModel) page.getApp().getData(AppModel.class)).getExtendInfos().getInteger("bizType")));
                jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, (Object) String.valueOf(((AppModel) page.getApp().getData(AppModel.class)).getExtendInfos().getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE)));
            }
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "http", str2, str3, jSONObject.toString());
    }

    private void a(App app, final Page page, String str, final String str2, Object obj, String str3, String str4, float f, String str5, final BridgeCallback bridgeCallback) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        final String str6 = " url = [" + str2 + "], headers = [" + obj + "], method = [" + str3 + "], data = [" + str4 + "], timeout = [" + f + "], dataType = [" + str5 + "]";
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("sendHttp", "start sendHttp, url = " + str2);
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            if (obj instanceof JSONArray) {
                JSONObject jSONObject3 = new JSONObject();
                int i = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) obj;
                    if (i >= jSONArray.size()) {
                        break;
                    }
                    for (Map.Entry<String, Object> entry : jSONArray.getJSONObject(i).entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    i++;
                }
                jSONObject2 = jSONObject3;
            } else {
                jSONObject = null;
            }
            a.a(app.getAppId(), str, str2, jSONObject2, str3, str4, f, str5, new a.InterfaceC0170a() { // from class: com.alibaba.triver.open.api.AliNetworkBridgeExtension.1
                @Override // com.alibaba.triver.open.api.a.InterfaceC0170a
                public void a(Object obj2) {
                    AliNetworkBridgeExtension.this.a(str2, obj2, bridgeCallback, str6, jCurrentTimeMillis, page);
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("sendHttp", "End sendHttp, url = " + str2);
                }
            });
        }
        jSONObject2 = jSONObject;
        a.a(app.getAppId(), str, str2, jSONObject2, str3, str4, f, str5, new a.InterfaceC0170a() { // from class: com.alibaba.triver.open.api.AliNetworkBridgeExtension.1
            @Override // com.alibaba.triver.open.api.a.InterfaceC0170a
            public void a(Object obj2) {
                AliNetworkBridgeExtension.this.a(str2, obj2, bridgeCallback, str6, jCurrentTimeMillis, page);
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("sendHttp", "End sendHttp, url = " + str2);
            }
        });
    }
}
