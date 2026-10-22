package com.alibaba.ariver.jsapi.security;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.extension.auth.b;
import com.alibaba.ariver.permission.openauth.model.request.JsApiInvokeRequestModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static List<String> a(App app) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        ArrayList arrayList = new ArrayList();
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(app.getAppId(), b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
        TBAccessToken tBAccessToken = !TextUtils.isEmpty(string) ? new TBAccessToken(string) : null;
        if (tBAccessToken != null && !tBAccessToken.isFailure()) {
            SendMtopParams sendMtopParams = new SendMtopParams(app.getAppId(), app.getStartParams());
            sendMtopParams.addData("accessToken", tBAccessToken.accessToken);
            sendMtopParams.api = "mtop.taobao.miniapp.auth.check";
            sendMtopParams.v = "1.0";
            sendMtopParams.needLogin = true;
            HashMap map = new HashMap();
            map.put(com.alibaba.ariver.jsapi.mtop.a.f, app.getAppId());
            sendMtopParams.setHeaders(map);
            SendMtopResponse sendMtopResponseRequestInnerSync = ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestInnerSync(sendMtopParams);
            if (sendMtopResponseRequestInnerSync.success) {
                try {
                    byte[] bArr = sendMtopResponseRequestInnerSync.data;
                    if (bArr != null && bArr.length > 0) {
                        String str = new String(bArr, Charset.forName("UTF-8"));
                        if (!TextUtils.isEmpty(str) && (jSONObject = JSON.parseObject(str).getJSONObject("data")) != null && !jSONObject.isEmpty() && (jSONObject2 = jSONObject.getJSONObject("authStatus")) != null && !jSONObject2.isEmpty()) {
                            for (String str2 : jSONObject2.keySet()) {
                                if (jSONObject2.getBoolean(str2).booleanValue()) {
                                    arrayList.add(str2);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public static JSONObject a(App app, ApiContext apiContext) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        JSONObject jSONObject = new JSONObject();
        SendMtopParams sendMtopParams = new SendMtopParams(apiContext.getAppId(), app.getStartParams());
        sendMtopParams.api = "mtop.taobao.openlink.fusionapp.user.get";
        sendMtopParams.v = "1.0";
        Map<String, String> mapA = com.alibaba.ariver.jsapi.mtop.a.a(app, appModel, apiContext);
        sendMtopParams.needAuth = !((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(app).create()).isOfficial(apiContext.getPluginId()) && com.alibaba.ariver.jsapi.mtop.a.a(app, appModel, apiContext.getPluginId());
        sendMtopParams.ignoreAuth = com.alibaba.ariver.jsapi.mtop.a.a(appModel, apiContext.getPluginId(), sendMtopParams.api);
        sendMtopParams.needLogin = true;
        sendMtopParams.setHeaders(mapA);
        SendMtopResponse sendMtopResponseRequestSync = ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestSync(app, sendMtopParams);
        if (sendMtopResponseRequestSync == null) {
            jSONObject.put("success", (Object) Boolean.FALSE);
            jSONObject.put("error", (Object) 2);
            jSONObject.put("message", (Object) "invalid parameter!");
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) "invalid parameter!");
            return jSONObject;
        }
        if (sendMtopResponseRequestSync.success) {
            try {
                byte[] bArr = sendMtopResponseRequestSync.data;
                if (bArr != null && bArr.length > 0) {
                    String str = new String(bArr, Charset.forName("UTF-8"));
                    if (!TextUtils.isEmpty(str)) {
                        return JSON.parseObject(str).getJSONObject("data");
                    }
                }
            } catch (Exception e) {
                jSONObject.put("success", (Object) Boolean.FALSE);
                jSONObject.put("error", (Object) 6);
                jSONObject.put("message", (Object) e.getMessage());
                jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) e.getMessage());
            }
        } else {
            jSONObject.put("success", (Object) Boolean.FALSE);
            jSONObject.put("error", (Object) (-1));
            jSONObject.put("message", (Object) sendMtopResponseRequestSync.errorMsg);
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) sendMtopResponseRequestSync.errorMsg);
        }
        return jSONObject;
    }

    public static Map<String, Boolean> a(App app, JsApiInvokeRequestModel jsApiInvokeRequestModel, String str) {
        List<String> listA;
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        Map<String, Boolean> allPermissions = ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).getAllPermissions(((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app), jsApiInvokeRequestModel.getAppId(), appModel, app, app.getActivePage());
        if (!((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(app).create()).isOfficial(str) && com.alibaba.ariver.jsapi.mtop.a.a(app, appModel, str) && (listA = a(app)) != null && listA.size() > 0) {
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                allPermissions.put(it.next(), Boolean.TRUE);
            }
        }
        return allPermissions;
    }
}
