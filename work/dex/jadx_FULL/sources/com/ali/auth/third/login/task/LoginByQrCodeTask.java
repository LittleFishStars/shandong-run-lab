package com.ali.auth.third.login.task;

import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.ui.QRView;
import com.ali.auth.third.ui.context.CallbackContext;
import com.ali.auth.third.ui.context.a;
import com.kuaishou.weapon.p0.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginByQrCodeTask extends AbsAsyncTask<String, Void, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f23482a;
    private boolean b;

    public LoginByQrCodeTask(a aVar, boolean z) {
        this.f23482a = aVar;
        this.b = z;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void asyncExecute(String... strArr) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject;
        try {
            JSONObject jSONObjectOptJSONObject2 = new JSONObject(strArr[0]).optJSONObject("params");
            if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("qrCodeInfo")) != null) {
                RpcResponse<LoginReturnData> rpcResponseLoginByQRCode = LoginComponent.INSTANCE.loginByQRCode(jSONObjectOptJSONObject.optString(t.u), jSONObjectOptJSONObject.optLong("t"), this.b);
                if (rpcResponseLoginByQRCode == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", 10010);
                    jSONObject2.put("message", "");
                    this.f23482a.b(jSONObject2.toString());
                    return null;
                }
                try {
                    int i = rpcResponseLoginByQRCode.code;
                    SDKLogger.d("login", "get qrcode of " + jSONObjectOptJSONObject + " status " + i);
                    if (i == 3000) {
                        com.ali.auth.third.login.a.a.f23464a.refreshWhenLogin(rpcResponseLoginByQRCode.returnValue);
                        if (CallbackContext.loginCallback != null) {
                            ((LoginCallback) CallbackContext.loginCallback).onSuccess(com.ali.auth.third.login.a.a.f23464a.getSession());
                        }
                        if (this.f23482a.a() != null) {
                            this.f23482a.a().setResult(ResultCode.SUCCESS.code);
                            this.f23482a.a().finish();
                        } else {
                            LoginCallback loginCallback = QRView.mLoginCallback;
                            if (loginCallback != null) {
                                loginCallback.onSuccess(com.ali.auth.third.login.a.a.f23464a.getSession());
                                QRView.mLoginCallback = null;
                            }
                        }
                    } else {
                        if (i == 14030) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 4);
                            jSONObject.put("message", rpcResponseLoginByQRCode.message);
                        } else if (i == 14031) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 5);
                            jSONObject.put("message", rpcResponseLoginByQRCode.message);
                        } else if (i == 14042) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 6);
                            jSONObject.put("message", rpcResponseLoginByQRCode.message);
                        } else if (i == 13060) {
                            JSONObject jSONObject3 = new JSONObject();
                            LoginReturnData loginReturnData = rpcResponseLoginByQRCode.returnValue;
                            if (loginReturnData.extMap != null) {
                                jSONObject3.put("nativeIv", loginReturnData.extMap.get("nativeIv"));
                                jSONObject3.put(Constants.PARAM_IV_TOKEN, rpcResponseLoginByQRCode.returnValue.extMap.get("nativeIvToken"));
                                jSONObject3.put("scene", rpcResponseLoginByQRCode.returnValue.scene);
                                jSONObject3.put("login_token", rpcResponseLoginByQRCode.returnValue.token);
                            }
                            this.f23482a.a(13060, jSONObject3.toString());
                        } else if (i == 1) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 10010);
                            jSONObject.put("message", rpcResponseLoginByQRCode.message);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", i);
                            jSONObject.put("message", rpcResponseLoginByQRCode.message);
                        }
                        this.f23482a.b(jSONObject.toString());
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        Message messageCreateMessage = MessageUtils.createMessage(10010, th.getMessage());
        SDKLogger.log("login", messageCreateMessage, th);
        this.f23482a.a(messageCreateMessage.code, messageCreateMessage.message);
    }
}
