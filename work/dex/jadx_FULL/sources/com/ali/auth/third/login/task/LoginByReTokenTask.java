package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
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
import com.ali.auth.third.login.util.LoginStatus;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginByReTokenTask extends AbsLoginByCodeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoginCallback f23483a;

    public LoginByReTokenTask(Activity activity, LoginCallback loginCallback) {
        super(activity);
        this.f23483a = loginCallback;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        LoginStatus.resetLoginFlag();
        HashMap map = new HashMap();
        map.put("code", "10010");
        map.put("message", c.f25231a);
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_AUTO_LOGIN_FAILURE, map);
        CommonUtils.onFailure(this.f23483a, ResultCode.create(10010, th.getMessage()));
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public void doWhenResultFail(int i, String str) {
        if (this.f23483a != null) {
            HashMap map = new HashMap();
            map.put("code", i + "");
            if (!TextUtils.isEmpty(str)) {
                map.put("message", str);
            }
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_AUTO_LOGIN_FAILURE, map);
            LoginCallback loginCallback = this.f23483a;
            if (loginCallback != null) {
                loginCallback.onFailure(i, str);
            }
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public void doWhenResultOk() {
        LoginStatus.resetLoginFlag();
        if (this.f23483a != null) {
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_AUTO_LOGIN_SUCCESS, null);
            this.f23483a.onSuccess(a.f23464a.getSession());
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public RpcResponse<LoginReturnData> login(String[] strArr) {
        LoginComponent loginComponent = LoginComponent.INSTANCE;
        return LoginComponent.loginByRefreshToken();
    }
}
