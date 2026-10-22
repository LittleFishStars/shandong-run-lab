package com.alibaba.ariver.engine.api.bridge;

import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.R;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.o.b;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeResponseHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private SendToNativeCallback f24048a;
    private Extension b;
    private boolean c;

    public BridgeResponseHelper(@Nullable final SendToNativeCallback sendToNativeCallback) {
        this.f24048a = new SendToNativeCallback() { // from class: com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public void onCallback(JSONObject jSONObject, boolean z) {
                SendToNativeCallback sendToNativeCallback2;
                if ((!BridgeResponseHelper.this.c || z) && (sendToNativeCallback2 = sendToNativeCallback) != null) {
                    sendToNativeCallback2.onCallback(jSONObject, z);
                }
            }
        };
    }

    public void executeSendBack(JSONObject jSONObject, boolean z) {
        Extension extension;
        if (this.f24048a != null) {
            if (RVKernelUtils.isDebug() && (extension = this.b) != null && jSONObject != null) {
                jSONObject.put(RVConstants.PKG_EXT_PREFIX, (Object) extension.getClass().getName());
            }
            this.f24048a.onCallback(jSONObject, z);
        }
    }

    public SendToNativeCallback getInnerBridgeResponse() {
        return this.f24048a;
    }

    public void sendBridgeResult(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        executeSendBack(jSONObject, false);
    }

    public void sendBridgeResultWithCallbackKept(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        executeSendBack(jSONObject, true);
    }

    public void sendError(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", (Object) str);
        jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) str);
        jSONObject.put("error", (Object) Integer.valueOf(i));
        executeSendBack(jSONObject, false);
    }

    public void sendNoRigHtToInvoke() {
        sendError(4, LangResourceUtil.getString(R.string.ariver_engine_api_forbidden_error));
    }

    public void sendNoRigHtToInvoke4NewJSAPIPermission() {
        sendError(4, "new jsapi permission deny");
    }

    public void sendNotFound() {
        sendError(1, "not implemented");
    }

    public void sendNotGrantPermission() {
        sendError(5, LangResourceUtil.getString(R.string.ariver_engine_api_authorization_error));
    }

    public void sendSilentDenyPermission() {
        sendError(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ta_send_slientdeny_permission", true) ? 2002 : 2001, "user does not allow authorization\n");
    }

    public void sendSuccess() {
        sendBridgeResult(new JSONObject());
    }

    public void sendTimeout() {
        sendError(9, b.r0);
        this.c = true;
    }

    public void sendUserNotGrantPermission() {
        sendError(2001, LangResourceUtil.getString(R.string.ariver_engine_api_user_not_grant));
    }

    public void setTargetExtension(Extension extension) {
        this.b = extension;
    }

    public void sendNoRigHtToInvoke(String str) {
        sendError(4, LangResourceUtil.getString(R.string.ariver_engine_api_forbidden_error), str);
    }

    public void sendBridgeResult(JSONObject jSONObject) {
        executeSendBack(jSONObject, false);
    }

    public void sendBridgeResultWithCallbackKept(JSONObject jSONObject) {
        executeSendBack(jSONObject, true);
    }

    public void sendError(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", (Object) str);
        jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) str);
        jSONObject.put("error", (Object) Integer.valueOf(i));
        jSONObject.put(SignatureFragment.SIGNATURE, (Object) str2);
        executeSendBack(jSONObject, false);
    }
}
