package com.ali.auth.third.login.task;

import android.app.Activity;
import android.webkit.WebView;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.ui.context.CallbackContext;
import com.ali.auth.third.ui.support.WebViewActivitySupport;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RefreshPageAfterOpenTb extends AbsLoginByCodeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f23491a;

    public RefreshPageAfterOpenTb(Activity activity, WebView webView) {
        super(activity);
        this.f23491a = webView;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        CommonUtils.toastSystemException();
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public void doWhenResultFail(int i, String str) {
        CommonUtils.toastSystemException();
        if (CallbackContext.loginCallback != null) {
            ((LoginCallback) CallbackContext.loginCallback).onFailure(i, str);
        }
        LoginCallback loginCallback = CallbackContext.mGlobalLoginCallback;
        if (loginCallback != null) {
            loginCallback.onFailure(i, str);
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public void doWhenResultOk() {
        if (this.f23491a != null) {
            WebViewActivitySupport.getInstance().safeReload(this.f23491a);
        }
        if (CallbackContext.loginCallback != null) {
            ((LoginCallback) CallbackContext.loginCallback).onSuccess(a.f23464a.getSession());
        }
        LoginCallback loginCallback = CallbackContext.mGlobalLoginCallback;
        if (loginCallback != null) {
            loginCallback.onSuccess(a.f23464a.getSession());
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public RpcResponse<LoginReturnData> login(String[] strArr) {
        return LoginComponent.INSTANCE.loginByCode(strArr[0]);
    }
}
