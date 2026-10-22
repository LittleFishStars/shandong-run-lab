package com.ali.auth.third.login.task;

import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.UTConstants;
import com.ali.auth.third.ui.LoginWebViewActivity;
import com.ali.auth.third.ui.context.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginByUsernameTask extends AbsAsyncTask<String, Void, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f23487a;

    public LoginByUsernameTask(a aVar) {
        this.f23487a = aVar;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void asyncExecute(String... strArr) throws Throwable {
        JSONObject jSONObject;
        a aVar;
        if (!CommonUtils.isNetworkAvailable()) {
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.code = -1;
            rpcResponse.message = ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("code", rpcResponse.code);
                jSONObject2.put("message", rpcResponse.message);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f23487a.b(jSONObject2.toString());
            return null;
        }
        RpcResponse<LoginReturnData> rpcResponseLoginByUserName = LoginComponent.INSTANCE.loginByUserName(strArr[0]);
        if (rpcResponseLoginByUserName == null) {
            this.f23487a.a("");
            return null;
        }
        try {
            int i = rpcResponseLoginByUserName.code;
            if (i == 3000) {
                com.ali.auth.third.login.a.a.f23464a.refreshWhenLogin(rpcResponseLoginByUserName.returnValue);
                this.f23487a.a().setResult(ResultCode.SUCCESS.code);
                this.f23487a.a().finish();
            } else {
                if (i == 13010) {
                    jSONObject = new JSONObject();
                    jSONObject.put("code", rpcResponseLoginByUserName.code);
                    jSONObject.put("message", rpcResponseLoginByUserName.message);
                    JSONObject jSONObject3 = new JSONObject();
                    LoginReturnData loginReturnData = rpcResponseLoginByUserName.returnValue;
                    if (loginReturnData != null) {
                        jSONObject3.put("checkCodeId", loginReturnData.checkCodeId);
                        jSONObject3.put("checkCodeUrl", rpcResponseLoginByUserName.returnValue.checkCodeUrl);
                    }
                    jSONObject.put("data", jSONObject3);
                    aVar = this.f23487a;
                } else if (i == 13011) {
                    jSONObject = new JSONObject();
                    jSONObject.put("code", rpcResponseLoginByUserName.code);
                    jSONObject.put("message", rpcResponseLoginByUserName.message);
                    JSONObject jSONObject4 = new JSONObject();
                    LoginReturnData loginReturnData2 = rpcResponseLoginByUserName.returnValue;
                    if (loginReturnData2 != null) {
                        jSONObject4.put("checkCodeId", loginReturnData2.checkCodeId);
                        jSONObject4.put("checkCodeUrl", rpcResponseLoginByUserName.returnValue.checkCodeUrl);
                    }
                    jSONObject.put("data", jSONObject4);
                    aVar = this.f23487a;
                } else if (i == 13059) {
                    jSONObject = new JSONObject();
                    jSONObject.put("code", rpcResponseLoginByUserName.code);
                    jSONObject.put("message", rpcResponseLoginByUserName.message);
                    JSONObject jSONObject5 = new JSONObject();
                    LoginReturnData loginReturnData3 = rpcResponseLoginByUserName.returnValue;
                    if (loginReturnData3 != null) {
                        jSONObject5.put("doubleCheckUrl", loginReturnData3.h5Url);
                    }
                    jSONObject.put("data", jSONObject5);
                    aVar = this.f23487a;
                } else if (i == 13060) {
                    jSONObject = new JSONObject();
                    jSONObject.put("code", rpcResponseLoginByUserName.code);
                    jSONObject.put("message", rpcResponseLoginByUserName.message);
                    JSONObject jSONObject6 = new JSONObject();
                    LoginReturnData loginReturnData4 = rpcResponseLoginByUserName.returnValue;
                    if (loginReturnData4 != null) {
                        jSONObject6.put("doubleCheckUrl", loginReturnData4.h5Url);
                    }
                    jSONObject.put("data", jSONObject6);
                    if (rpcResponseLoginByUserName.returnValue != null) {
                        LoginWebViewActivity.token = rpcResponseLoginByUserName.returnValue.token;
                        LoginWebViewActivity.scene = rpcResponseLoginByUserName.returnValue.scene;
                    }
                    aVar = this.f23487a;
                } else {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("code", rpcResponseLoginByUserName.code);
                    jSONObject7.put("message", rpcResponseLoginByUserName.message);
                    this.f23487a.b(jSONObject7.toString());
                    HashMap map = new HashMap();
                    map.put("code", rpcResponseLoginByUserName.code + "");
                    if (!TextUtils.isEmpty(rpcResponseLoginByUserName.message)) {
                        map.put("message", rpcResponseLoginByUserName.message);
                    }
                    ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_FAILURE, map);
                }
                aVar.b(jSONObject.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        Message messageCreateMessage = MessageUtils.createMessage(10010, th.getMessage());
        if (th instanceof RpcException) {
            messageCreateMessage = new Message();
            RpcException rpcException = (RpcException) th;
            messageCreateMessage.code = rpcException.getCode();
            messageCreateMessage.message = rpcException.getMsg();
        }
        SDKLogger.d("login", messageCreateMessage.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", messageCreateMessage.code);
            jSONObject.put("message", messageCreateMessage.message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f23487a.b(jSONObject.toString());
    }
}
