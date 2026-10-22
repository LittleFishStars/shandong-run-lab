package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.UTConstants;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginByIVTokenTask extends AbsAsyncTask<String, Void, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoginCallback f23479a;
    private Activity b;
    protected boolean c = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f23480a;
        final /* synthetic */ String b;

        public a(int i, String str) {
            this.f23480a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap map = new HashMap();
            map.put("code", this.f23480a + "");
            if (!TextUtils.isEmpty(this.b)) {
                map.put("message", this.b);
            }
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_FAILURE, map);
            if (LoginByIVTokenTask.this.f23479a != null) {
                LoginByIVTokenTask.this.f23479a.onFailure(this.f23480a, this.b);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LoginByIVTokenTask.this.f23479a != null) {
                LoginByIVTokenTask.this.f23479a.onSuccess(KernelContext.credentialService.getSession());
            }
            CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
            LoginByIVTokenTask loginByIVTokenTask = LoginByIVTokenTask.this;
            if (loginByIVTokenTask.c) {
                loginByIVTokenTask.b.finish();
            }
        }
    }

    public LoginByIVTokenTask(Activity activity, LoginCallback loginCallback) {
        this.b = activity;
        this.f23479a = loginCallback;
    }

    public LoginByIVTokenTask(Activity activity, LoginCallback loginCallback, boolean z) {
        this.b = activity;
        this.f23479a = loginCallback;
    }

    private void a() {
        KernelContext.executorService.postUITask(new b());
    }

    private void a(int i, String str) {
        KernelContext.executorService.postUITask(new a(i, str));
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void asyncExecute(String... strArr) {
        LoginReturnData loginReturnData;
        if (!CommonUtils.isNetworkAvailable()) {
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.code = -1;
            String string = ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message");
            rpcResponse.message = string;
            a(rpcResponse.code, string);
            return null;
        }
        RpcResponse<LoginReturnData> rpcResponseLoginByIVToken = LoginComponent.INSTANCE.loginByIVToken(strArr[0], strArr[1], strArr[2]);
        if (rpcResponseLoginByIVToken == null || (loginReturnData = rpcResponseLoginByIVToken.returnValue) == null) {
            ResultCode resultCode = ResultCode.SYSTEM_EXCEPTION;
            a(resultCode.code, resultCode.message);
            return null;
        }
        int i = rpcResponseLoginByIVToken.code;
        if (i == 3000) {
            KernelContext.credentialService.refreshWhenLogin(loginReturnData);
            a();
        } else {
            a(i, rpcResponseLoginByIVToken.message);
        }
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        Message messageCreateMessage = MessageUtils.createMessage(10010, th.getMessage());
        SDKLogger.log("login", messageCreateMessage, th);
        HashMap map = new HashMap();
        map.put("code", "10010");
        map.put("message", c.f25231a);
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_FAILURE, map);
        a(messageCreateMessage.code, messageCreateMessage.message);
    }
}
