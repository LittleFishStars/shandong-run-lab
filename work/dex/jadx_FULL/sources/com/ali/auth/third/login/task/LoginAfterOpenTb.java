package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.UTConstants;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.ui.LoginActivity;
import com.ali.auth.third.ui.context.CallbackContext;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginAfterOpenTb extends AbsLoginByCodeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoginCallback f23478a;

    public LoginAfterOpenTb(Activity activity, LoginCallback loginCallback) {
        super(activity);
        this.f23478a = loginCallback;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED);
        HashMap map = new HashMap();
        map.put("code", "10010");
        map.put("message", c.f25231a);
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_TB_LOGIN_FAILURE, map);
        CommonUtils.onFailure(this.f23478a, ResultCode.create(10010, th.getMessage()));
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public void doWhenResultFail(int i, String str) {
        LoginCallback loginCallback = this.f23478a;
        if (loginCallback != null) {
            loginCallback.onFailure(i, str);
            HashMap map = new HashMap();
            map.put("code", i + "");
            if (!TextUtils.isEmpty(str)) {
                map.put("message", str);
            }
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_TB_LOGIN_FAILURE, map);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onFailure(i, str);
        }
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED);
        Activity activity = this.activity;
        if (activity == null || !(activity instanceof LoginActivity)) {
            return;
        }
        CallbackContext.activity = null;
        activity.finish();
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public void doWhenResultOk() {
        LoginCallback loginCallback = this.f23478a;
        if (loginCallback != null) {
            loginCallback.onSuccess(a.f23464a.getSession());
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_TB_LOGIN_SUCCESS, null);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onSuccess(a.f23464a.getSession());
        }
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
        Activity activity = this.activity;
        if (activity == null || !(activity instanceof LoginActivity)) {
            return;
        }
        CallbackContext.activity = null;
        activity.finish();
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public RpcResponse<LoginReturnData> login(String[] strArr) {
        return LoginComponent.INSTANCE.loginByCode(strArr[0]);
    }
}
