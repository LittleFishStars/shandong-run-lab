package com.ali.auth.third.login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.auth.third.core.WebViewProxy;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.CommonCallback;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.callback.NQrCodeLoginCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.cookies.CookieManagerWrapper;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.model.SystemMessageConstants;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.callback.LogoutCallback;
import com.ali.auth.third.login.task.AutoLoginTask;
import com.ali.auth.third.login.task.LoginByReTokenTask;
import com.ali.auth.third.login.task.LogoutTask;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.LoginActivity;
import com.ali.auth.third.ui.context.CallbackContext;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginServiceImpl implements LoginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Pattern[] f23454a;
    private transient Pattern[] b;

    public class a implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginCallback f23455a;
        final /* synthetic */ Activity b;

        public a(LoginCallback loginCallback, Activity activity) {
            this.f23455a = loginCallback;
            this.b = activity;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            LoginServiceImpl.this.a(this.b, this.f23455a);
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            LoginCallback loginCallback = this.f23455a;
            if (loginCallback != null) {
                loginCallback.onSuccess(LoginServiceImpl.this.getSession());
            }
        }
    }

    public class b implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginCallback f23456a;
        final /* synthetic */ Map b;

        public b(LoginCallback loginCallback, Map map) {
            this.f23456a = loginCallback;
            this.b = map;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            LoginServiceImpl.this.a((Map<String, String>) this.b, this.f23456a);
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            LoginCallback loginCallback = this.f23456a;
            if (loginCallback != null) {
                loginCallback.onSuccess(LoginServiceImpl.this.getSession());
            }
        }
    }

    public class c implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginCallback f23457a;

        public c(LoginCallback loginCallback) {
            this.f23457a = loginCallback;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            SDKLogger.d("login", "auth auto login success");
            LoginCallback loginCallback = this.f23457a;
            if (loginCallback != null) {
                loginCallback.onFailure(i, str);
            }
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            SDKLogger.d("login", "auth auto login success");
            LoginCallback loginCallback = this.f23457a;
            if (loginCallback != null) {
                loginCallback.onSuccess(LoginServiceImpl.this.getSession());
            }
            LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
            if (loginCallback2 != null) {
                loginCallback2.onSuccess(LoginServiceImpl.this.getSession());
            }
            CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
        }
    }

    public class d implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginCallback f23458a;

        public d(LoginCallback loginCallback) {
            this.f23458a = loginCallback;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            SDKLogger.d("login", "auth auto login failed");
            LoginCallback loginCallback = this.f23458a;
            if (loginCallback != null) {
                loginCallback.onFailure(i, str);
            }
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            SDKLogger.d("login", "auth auto login success");
            LoginCallback loginCallback = this.f23458a;
            if (loginCallback != null) {
                loginCallback.onSuccess(LoginServiceImpl.this.getSession());
            }
            LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
            if (loginCallback2 != null) {
                loginCallback2.onSuccess(LoginServiceImpl.this.getSession());
            }
            CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
        }
    }

    public class e extends AsyncTask<Object, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CommonCallback f23459a;

        public e(LoginServiceImpl loginServiceImpl, CommonCallback commonCallback) {
            this.f23459a = commonCallback;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            this.f23459a.onSuccess();
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            CookieManagerWrapper.INSTANCE.refreshCookie();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, LoginCallback loginCallback) {
        SDKLogger.d("login", "auth goLogin");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        if (activity != null) {
            intent.setClass(activity, LoginActivity.class);
            activity.startActivity(intent);
        } else {
            intent.setClass(KernelContext.getApplicationContext(), LoginActivity.class);
            intent.setFlags(268435456);
            KernelContext.getApplicationContext().startActivity(intent);
        }
    }

    private void a(String str, LoginCallback loginCallback) {
        SDKLogger.d("login", "goSsoTokenLogin start");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), LoginActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(LoginConstants.PARAN_LOGIN_TYPE, 5);
        intent.putExtra("token", str);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, String> map, LoginCallback loginCallback) {
        SDKLogger.d("login", "goQrCodeLogin start");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), LoginActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(LoginConstants.PARAN_LOGIN_TYPE, 4);
        intent.putExtra("params", map == null ? "" : JSONUtils.toJsonObject(map).toString());
        KernelContext.getApplicationContext().startActivity(intent);
    }

    private boolean a(LoginCallback loginCallback) {
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.d("login", "auth static field is null");
            if (loginCallback != null) {
                loginCallback.onFailure(SystemMessageConstants.NPE_ERROR, "NullPointException");
            }
            return false;
        }
        try {
            HashMap map = new HashMap();
            map.put("withNoActivity", "true");
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("auth".toUpperCase(), map);
        } catch (Exception unused) {
        }
        if (!LoginStatus.compareAndSetLogining(false, true)) {
            if (System.currentTimeMillis() - LoginStatus.getLastLoginTime() >= 60000) {
                LoginStatus.resetLoginFlag();
            }
            SDKLogger.e("login", "auth sdk is Logining, return");
            return false;
        }
        if (CommonUtils.isNetworkAvailable()) {
            return true;
        }
        SDKLogger.d("login", "auth network not available");
        loginCallback.onFailure(SystemMessageConstants.NET_WORK_ERROR, ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message"));
        LoginStatus.resetLoginFlag();
        return false;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void auth(Activity activity, LoginCallback loginCallback) {
        SDKLogger.d("login", "auth start");
        if (!a(loginCallback)) {
            SDKLogger.d("login", "AutnEnvriment invalid");
            return;
        }
        if (System.currentTimeMillis() - Constants.mBusyControl >= 10000) {
            autoLogin(new a(loginCallback, activity));
            return;
        }
        LoginStatus.resetLoginFlag();
        if (loginCallback != null) {
            ResultCode resultCode = ResultCode.BUSY_CONTROL;
            loginCallback.onFailure(resultCode.code, resultCode.message);
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public void auth(LoginCallback loginCallback) {
        auth(null, loginCallback);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void autoLogin(a.a.a.a.a.a aVar, LoginCallback loginCallback) {
        if (loginCallback == null) {
            SDKLogger.e("login", "callback is null");
            return;
        }
        if (aVar == null || TextUtils.isEmpty(aVar.f21190a) || TextUtils.isEmpty(aVar.b)) {
            loginCallback.onFailure(-1, "param invalid");
        } else if (!a(loginCallback)) {
            loginCallback.onFailure(-2, "service is null");
        } else {
            SDKLogger.d("login", "auth auto login");
            new AutoLoginTask(null, new d(loginCallback)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aVar.b, aVar.f21190a);
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public void autoLogin(LoginCallback loginCallback) {
        CredentialManager credentialManager = CredentialManager.INSTANCE;
        if (TextUtils.isEmpty(credentialManager.getInternalSession().autoLoginToken) || credentialManager.getInternalSession().user == null || TextUtils.isEmpty(credentialManager.getInternalSession().user.userId)) {
            if (loginCallback != null) {
                loginCallback.onFailure(-1, "auto login token is empty");
            }
        } else {
            SDKLogger.d("login", "auth auto login");
            LoginByReTokenTask loginByReTokenTask = new LoginByReTokenTask(null, new c(loginCallback));
            Executor executor = ExecutorServiceImpl.mExecutor;
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            loginByReTokenTask.executeOnExecutor(executor, new String[0]);
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public boolean checkSessionValid() {
        return com.ali.auth.third.login.a.a.f23464a.isSessionValid();
    }

    @Override // com.ali.auth.third.login.LoginService
    public void clear() {
        CallbackContext.loginCallback = null;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void createQrCodeAndLogin(Map<String, String> map, NQrCodeLoginCallback nQrCodeLoginCallback) {
        QRComponent.start(Integer.parseInt(map.get("width")), Integer.parseInt(map.get("height")), nQrCodeLoginCallback);
    }

    @Override // com.ali.auth.third.login.LoginService
    public Session getSession() {
        return com.ali.auth.third.login.a.a.f23464a.getSession();
    }

    @Override // com.ali.auth.third.login.LoginService
    public boolean isLoginUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f23454a == null && !TextUtils.isEmpty(ConfigManager.LOGIN_URLS)) {
            String[] strArrSplit = ConfigManager.LOGIN_URLS.split("[,]");
            Pattern[] patternArr = new Pattern[strArrSplit.length];
            this.f23454a = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.f23454a[i] = Pattern.compile(strArrSplit[i]);
            }
        }
        for (Pattern pattern : this.f23454a) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.auth.third.login.LoginService
    public boolean isLogoutUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.b == null && !TextUtils.isEmpty(ConfigManager.LOGOUT_URLS)) {
            String[] strArrSplit = ConfigManager.LOGOUT_URLS.split("[,]");
            Pattern[] patternArr = new Pattern[strArrSplit.length];
            this.b = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.b[i] = Pattern.compile(strArrSplit[i]);
            }
        }
        for (Pattern pattern : this.b) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void loginBySsoToken(String str, LoginCallback loginCallback) {
        if (!TextUtils.isEmpty(str)) {
            a(str, loginCallback);
        } else if (loginCallback != null) {
            loginCallback.onFailure(-1, "sso token is empty");
        }
    }

    @Override // com.ali.auth.third.login.LoginService
    public void logout(Activity activity, LogoutCallback logoutCallback) {
        Constants.mBusyControl = 0L;
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(AlibcProtocolConstant.LOGOUT.toUpperCase(), null);
        LogoutTask logoutTask = new LogoutTask(activity, logoutCallback);
        Executor executor = ExecutorServiceImpl.mExecutor;
        if (executor == null) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        logoutTask.executeOnExecutor(executor, new Void[0]);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void logout(LogoutCallback logoutCallback) {
        try {
            HashMap map = new HashMap();
            map.put("withNoActivity", "true");
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(AlibcProtocolConstant.LOGOUT.toUpperCase(), map);
        } catch (Exception unused) {
        }
        logout(null, logoutCallback);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void refreshCookie(CommonCallback commonCallback) {
        e eVar = new e(this, commonCallback);
        Executor executor = ExecutorServiceImpl.mExecutor;
        if (executor == null) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        eVar.executeOnExecutor(executor, new Object[0]);
    }

    @Override // com.ali.auth.third.login.LoginService
    public void setLoginCallback(LoginCallback loginCallback) {
        CallbackContext.mGlobalLoginCallback = loginCallback;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void setWebViewProxy(WebViewProxy webViewProxy) {
        KernelContext.mWebViewProxy = webViewProxy;
    }

    @Override // com.ali.auth.third.login.LoginService
    public void showQrCodeLogin(Map<String, String> map, LoginCallback loginCallback) {
        if (a(loginCallback)) {
            autoLogin(new b(loginCallback, map));
        }
    }
}
