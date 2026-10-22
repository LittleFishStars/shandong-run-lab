package com.alibaba.ariver.jsapi.internalapi;

import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingId;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.b;
import com.alibaba.ariver.remotedebug.b.c;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class InternalApiBridgeExtension implements BridgeExtension {
    public static final Set<String> API_INIT_LIST;
    private static final String INTERNAL_API_ID_PREFIX = "InternalAPI_";
    private static final String TAG = "AriverAPI:InternalApiBridgeExtension";

    static {
        HashSet hashSet = new HashSet();
        API_INIT_LIST = hashSet;
        hashSet.add("setOptionMenu");
        hashSet.add(RVParams.LONG_SHOW_OPTION_MENU);
        hashSet.add("inputFocus4Android");
        hashSet.add("getConfig");
        hashSet.add("getLifestyleInfo");
        hashSet.add("addFollow");
        hashSet.add(RVStartParams.START_SCENE_START_APP);
        hashSet.add("requestTemplateData");
        hashSet.add("getAppType");
        hashSet.add("onAppPerfEvent");
        hashSet.add("getShareImageUrl");
        hashSet.add("hideCustomKeyBoard");
        hashSet.add("resetNativeKeyBoardInput");
        hashSet.add("updateNativeKeyBoardInput");
        hashSet.add("getStartupParams");
        hashSet.add("getConfig4Appx");
        hashSet.add(b.e);
        hashSet.add("add2Favorite");
        hashSet.add("cancelKeepFavorite");
        hashSet.add("shareTinyAppMsg");
        hashSet.add("setAppxVersion");
        hashSet.add("showBackHome");
        hashSet.add("getComponentAuth");
        hashSet.add("getBusinessAuth");
        hashSet.add("getAuthorize");
        hashSet.add("appxrpc");
        hashSet.add("launchApp");
        hashSet.add("goBackThirdPartApp");
        hashSet.add(c.b);
        hashSet.add("shareToAlipayContact");
        hashSet.add("startMiniService");
        hashSet.add("addPkgRes");
        hashSet.add("saveSnapshot");
        hashSet.add("deleteSnapshot");
        hashSet.add("executeDefaultBehavior");
        hashSet.add("initialTraceDebug");
        hashSet.add("postMethodTrace");
        hashSet.add("handleLoggingAction");
        hashSet.add("makePhoneCall");
        hashSet.add("getExtConfig");
        hashSet.add("healthKitRequest");
        hashSet.add("resizeNativeKeyBoardInput");
        hashSet.add("rpc");
        hashSet.add("getClientConfig");
        hashSet.add("cdpFeedback");
        hashSet.add("getCdpSpaceInfo");
        hashSet.add("shouldShowAddComponent");
        hashSet.add("questionaireApp2HomeShow");
        hashSet.add("addNotifyListener");
        hashSet.add("closeAddComponentAction");
        hashSet.add("addToHomeWithComponent");
        hashSet.add("getSharedData");
        hashSet.add("setSharedData");
        hashSet.add(JSApiCachePoint.GET_USER_INFO);
        hashSet.add("disablePageMonitor");
        hashSet.add("reportTinyData");
        hashSet.add("antUIGetCascadePicker");
        hashSet.add("loadPlugin");
        hashSet.add("reportUEPData");
        hashSet.add("handleUEPEvent");
        hashSet.add("skipKeepAlive");
    }

    public boolean hasPermission(String str) {
        return API_INIT_LIST.contains(str);
    }

    @ActionFilter
    public void internalAPI(@BindingRequest JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingId String str) {
        if (page == null) {
            RVLogger.d(TAG, "page is null");
            return;
        }
        NativeCallContext.Builder builder = new NativeCallContext.Builder();
        String string = JSONUtils.getString(jSONObject, "method", "");
        if (!hasPermission(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, "not allowed to use internalAPI: " + string));
            return;
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "param", null);
        RVLogger.d(TAG, "internalAPI...method: " + string + " params: " + jSONObject2);
        NativeCallContext.Builder builderParams = builder.node(page).name(string).params(jSONObject2);
        StringBuilder sb = new StringBuilder();
        sb.append(INTERNAL_API_ID_PREFIX);
        sb.append(NativeCallContext.generateUniqueId());
        apiContext.callBridgeApi(builderParams.id(sb.toString()).render(page.getRender()).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.jsapi.internalapi.InternalApiBridgeExtension.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject3, boolean z) {
                bridgeCallback.sendJSONResponse(jSONObject3, z);
            }
        }, false);
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
}
