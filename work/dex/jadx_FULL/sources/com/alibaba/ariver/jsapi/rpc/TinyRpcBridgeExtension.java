package com.alibaba.ariver.jsapi.rpc;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.b;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TinyRpcBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24170a = RVLogger.makeLogTag(TinyRpcBridgeExtension.class.getName());
    private static final String b = "headers";
    private static final String c = "TINY_APP_ID";
    private static final String d = "TINY_APP_PARENT_ID";
    private static final Map<String, String> e;

    static {
        HashMap map = new HashMap();
        e = map;
        map.put("qrcode", "alipay.mobilecodec.shakeCode.encode");
        map.put("add2Favorite", "alipay.openservice.mini.miniapp.keep");
        map.put("queryIsFavorite", "alipay.openservice.mini.miniapp.iskeep.query");
        map.put("undoFavorite", "alipay.openservice.mini.miniapp.keep.cancel");
        map.put("queryContacts", "alipay.antmember.biz.rpc.invite.queryContacts");
        map.put("inviteFriend", "com.alipay.antmember.biz.rpc.invite.h5.InviteFriend");
        map.put("industryLogisticQuery", "alipay.shopminiapp.industry.logistic.query");
        map.put("industryExpressInfoQuery", "alipay.shopminiapp.industry.express.query");
        map.put("industrySendMessage", "alipay.shopminiapp.industry.send.message");
        map.put("industryWriteExpress", "alipay.shopminiapp.industry.write.express");
        map.put("industryShopInfoQuery", "alipay.shopminiapp.open.shopinfo.query");
        map.put("faceVerifyInit", "com.zoloz.zhub.zim.initflow");
        map.put("zmCreditRiskEvaluate", "com.alipay.creditexprod.biz.rpc.api.CreditRiskEvaluateRpcService.evaluate");
        map.put("riskgo", "com.alipay.rigkpluscore.mini.customerrisk.query");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void tinyRpc(@BindingParam({"type"}) String str, @BindingParam({b}) JSONObject jSONObject, @BindingRequest JSONObject jSONObject2, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        String appId;
        String string;
        if (page == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(3, "page is null"));
            RVLogger.d(f24170a, "page is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "operationType is null"));
            RVLogger.d(f24170a, "operationType is null");
            return;
        }
        if (app != null) {
            appId = app.getAppId();
            string = BundleUtils.getString(app.getStartParams(), RVConstants.EXTRA_PARENT_APP_ID);
            if (TextUtils.isEmpty(appId)) {
                String string2 = BundleUtils.getString(app.getStartParams(), "MINI-PROGRAM-WEB-VIEW-TAG");
                if (!TextUtils.isEmpty(string2)) {
                    appId = string2;
                }
            }
        } else {
            appId = "";
            string = "";
        }
        if (((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).hasPermission(appId, str, b.h, page) != ApiPermissionCheckResult.IGNORE) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(4, "has no permission"));
            RVLogger.d(f24170a, "has no permission");
            return;
        }
        String string3 = JSONUtils.getString(JSONUtils.parseObject(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_rpc_api_cfg", null)), str);
        if (StringUtils.isEmpty(string3)) {
            string3 = e.get(str);
            if (StringUtils.isEmpty(string3)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "operationType is wrong"));
                RVLogger.d(f24170a, "operationType is wrong");
                return;
            }
        }
        RVLogger.d(f24170a, "real op :" + string3);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            jSONObject2.put(b, (Object) jSONObject);
        }
        jSONObject.put(c, (Object) appId);
        if (!TextUtils.isEmpty(string)) {
            jSONObject.put(d, (Object) string);
        }
        jSONObject2.put("operationType", (Object) string3);
        apiContext.callBridgeApi(new NativeCallContext.Builder().node(page).name("rpc").params(jSONObject2).render(page.getRender()).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.jsapi.rpc.TinyRpcBridgeExtension.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject3, boolean z) {
                bridgeCallback.sendJSONResponse(jSONObject3);
            }
        }, false);
    }
}
