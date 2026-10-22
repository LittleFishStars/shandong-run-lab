package com.alibaba.triver.kit.api.network;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SendMtopRequestClient {
    private static final String TAG = "SyncMtopRequestClient";

    public interface CommonListener {
        void onFailure(String str, String str2, String str3);

        void onSuccess(String str);
    }

    public static class CommonParam {
        public String api;
        private Map<String, String> dataMap = new HashMap();
        public boolean needLogin;
        public String v;

        public void addData(String str, String str2) {
            this.dataMap.put(str, str2);
        }
    }

    public static class CommonResponse {
        public String data;
        public String errorCode;
        public String errorMsg;
        public boolean success;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CommonResponse buildResponse(SendMtopResponse sendMtopResponse) {
        CommonResponse commonResponse = new CommonResponse();
        if (sendMtopResponse == null) {
            commonResponse.success = false;
            commonResponse.errorCode = "MTOP_RESPONSE_NULL";
            commonResponse.errorMsg = "网络请求异常";
            return commonResponse;
        }
        byte[] bArr = sendMtopResponse.data;
        if (bArr == null) {
            RVLogger.d("[mtop]", "response data is null");
            commonResponse.success = false;
            commonResponse.errorCode = sendMtopResponse.errorCode;
            commonResponse.errorMsg = sendMtopResponse.errorMsg;
            return commonResponse;
        }
        commonResponse.success = sendMtopResponse.success;
        commonResponse.errorCode = sendMtopResponse.errorCode;
        commonResponse.errorMsg = sendMtopResponse.errorMsg;
        commonResponse.data = configResponse(bArr);
        return commonResponse;
    }

    private SendMtopParams createParams(App app, String str, CommonParam commonParam) {
        SendMtopParams sendMtopParams = new SendMtopParams(app != null ? app.getAppId() : null, app != null ? app.getStartParams() : null);
        if (app != null) {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
            sendMtopParams.addData("mainAppId", app.getAppId());
            if (appModel != null) {
                sendMtopParams.addData("mainAppKey", appModel.getAppInfoModel().getAppKey());
                sendMtopParams.addData("invokerAppId", getInvokeAppId(str, appModel));
                sendMtopParams.addData("invokerAppKey", getInvokeAppKey(str, appModel, dynamicPluginInfo));
            }
            if (commonParam != null) {
                sendMtopParams.needLogin = commonParam.needLogin;
                sendMtopParams.api = commonParam.api;
                sendMtopParams.v = commonParam.v;
                for (Map.Entry entry : commonParam.dataMap.entrySet()) {
                    sendMtopParams.addData((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (appModel != null) {
                HashMap map = new HashMap();
                map.put("appId", appModel.getAppId());
                sendMtopParams.setHeaders(map);
            }
        }
        return sendMtopParams;
    }

    private String getInvokeAppId(String str, AppModel appModel) {
        String appId = appModel.getAppId();
        if (appModel.getAppInfoModel().getTemplateConfig() != null && appModel.getAppInfoModel().getTemplateConfig().getTemplateId() != null) {
            appId = appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
        }
        return !TextUtils.isEmpty(str) ? str : appId;
    }

    private String getInvokeAppKey(String str, AppModel appModel, DynamicPluginInfo dynamicPluginInfo) {
        String appKey = appModel.getAppInfoModel().getAppKey();
        if (appModel.getAppInfoModel().getTemplateConfig() != null && appModel.getAppInfoModel().getTemplateConfig().getAppKey() != null) {
            appKey = appModel.getAppInfoModel().getTemplateConfig().getAppKey();
        }
        if (!TextUtils.isEmpty(str)) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            if (plugins != null) {
                for (PluginModel pluginModel : plugins) {
                    if (TextUtils.equals(pluginModel.getAppId(), str)) {
                        return pluginModel.getAppKey();
                    }
                }
            }
            if (dynamicPluginInfo != null && dynamicPluginInfo.getPluginModels() != null) {
                for (PluginModel pluginModel2 : dynamicPluginInfo.getPluginModels()) {
                    if (TextUtils.equals(pluginModel2.getAppId(), str)) {
                        return pluginModel2.getAppKey();
                    }
                }
            }
        }
        return appKey;
    }

    public String configResponse(byte[] bArr) {
        JSONObject object;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (TextUtils.isEmpty(str) || (object = JSON.parseObject(str)) == null) {
            return null;
        }
        return object.getString("data");
    }

    public void executeAsync(App app, String str, CommonParam commonParam, final CommonListener commonListener) {
        try {
            ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestInnerAsync(createParams(app, str, commonParam), new IMtopProxy.Callback() { // from class: com.alibaba.triver.kit.api.network.SendMtopRequestClient.1
                @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy.Callback
                public void onResult(SendMtopResponse sendMtopResponse) {
                    CommonResponse commonResponseBuildResponse = SendMtopRequestClient.this.buildResponse(sendMtopResponse);
                    if (!commonResponseBuildResponse.success) {
                        commonListener.onFailure(commonResponseBuildResponse.errorCode, commonResponseBuildResponse.errorMsg, commonResponseBuildResponse.data);
                        return;
                    }
                    try {
                        commonListener.onSuccess(commonResponseBuildResponse.data);
                    } catch (Exception e) {
                        RVLogger.e(SendMtopRequestClient.TAG, "execute error", e);
                        commonListener.onFailure(e.getClass().getName(), e.getMessage(), null);
                    }
                }
            });
        } catch (Exception e) {
            RVLogger.e(TAG, "execute error", e);
            commonListener.onFailure(e.getClass().getName(), e.getMessage(), null);
        }
    }

    public CommonResponse executeSync(App app, String str, CommonParam commonParam) {
        try {
            return buildResponse(((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestInnerSync(createParams(app, str, commonParam)));
        } catch (Exception e) {
            RVLogger.e(TAG, "execute error", e);
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.success = false;
            commonResponse.errorCode = e.getClass().getName();
            commonResponse.errorMsg = e.getMessage();
            return commonResponse;
        }
    }
}
