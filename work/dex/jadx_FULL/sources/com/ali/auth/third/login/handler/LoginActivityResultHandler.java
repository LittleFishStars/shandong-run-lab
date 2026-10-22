package com.ali.auth.third.login.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.model.SystemMessageConstants;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.RequestCode;
import com.ali.auth.third.login.UTConstants;
import com.ali.auth.third.login.task.LoginAfterOpenTb;
import com.ali.auth.third.login.task.LoginByIVTokenTask;
import com.ali.auth.third.login.task.RefreshPageAfterOpenTb;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.LoginActivity;
import com.ali.auth.third.ui.context.CallbackContext;
import com.ali.auth.third.ui.support.BaseActivityResultHandler;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginActivityResultHandler extends BaseActivityResultHandler {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f23465a;
        final /* synthetic */ LoginCallback b;

        public a(WeakReference weakReference, LoginCallback loginCallback) {
            this.f23465a = weakReference;
            this.b = loginCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Activity> weakReference = this.f23465a;
            CallbackContext.activity = weakReference;
            LoginActivityResultHandler.this.a(weakReference.get(), UTConstants.E_IV_LOGIN_FAILURE, this.b, SystemMessageConstants.H5_LOGIN_FAILURE);
            CallbackContext.activity = null;
        }
    }

    public class b implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f23466a;
        final /* synthetic */ LoginCallback b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                WeakReference<Activity> weakReference = bVar.f23466a;
                CallbackContext.activity = weakReference;
                LoginActivityResultHandler.this.a(weakReference.get(), UTConstants.E_IV_LOGIN_FAILURE, b.this.b, SystemMessageConstants.H5_LOGIN_FAILURE);
                CallbackContext.activity = null;
            }
        }

        /* JADX INFO: renamed from: com.ali.auth.third.login.handler.LoginActivityResultHandler$b$b, reason: collision with other inner class name */
        public class RunnableC0121b implements Runnable {
            public RunnableC0121b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                WeakReference<Activity> weakReference = bVar.f23466a;
                CallbackContext.activity = weakReference;
                LoginActivityResultHandler.this.a(weakReference.get(), UTConstants.E_H5_LOGIN_SUCCESS, b.this.b);
                CallbackContext.activity = null;
            }
        }

        public b(WeakReference weakReference, LoginCallback loginCallback) {
            this.f23466a = weakReference;
            this.b = loginCallback;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            KernelContext.executorService.postUITask(new a());
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            KernelContext.executorService.postUITask(new RunnableC0121b());
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f23469a;
        final /* synthetic */ LoginCallback b;

        public c(WeakReference weakReference, LoginCallback loginCallback) {
            this.f23469a = weakReference;
            this.b = loginCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Activity> weakReference = this.f23469a;
            CallbackContext.activity = weakReference;
            LoginActivityResultHandler.this.a(weakReference.get(), UTConstants.E_H5_OPERATION_BIND_FAILURE, this.b, 10003);
            CallbackContext.activity = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, LoginCallback loginCallback) {
        SDKLogger.d("login", "onLoginSuccess ");
        if (loginCallback != null) {
            loginCallback.onSuccess(com.ali.auth.third.login.a.a.f23464a.getSession());
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_SUCCESS, null);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onSuccess(com.ali.auth.third.login.a.a.f23464a.getSession());
        }
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
        if (activity == null || !(activity instanceof LoginActivity)) {
            return;
        }
        CallbackContext.activity = null;
        activity.finish();
        CallbackContext.loginCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, LoginCallback loginCallback, int i) {
        HashMap map;
        UserTrackerService userTrackerService;
        String str2;
        UserTrackerService userTrackerService2;
        String str3;
        SDKLogger.d("login", "onLoginFailure ");
        if (loginCallback != null) {
            Message messageCreateMessage = MessageUtils.createMessage(i, new Object[0]);
            loginCallback.onFailure(messageCreateMessage.code, messageCreateMessage.message);
            if (!UTConstants.E_IV_LOGIN_FAILURE.equals(str)) {
                if (i == 10003) {
                    userTrackerService2 = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                    str3 = UTConstants.E_H5_LOGIN_CANCEL;
                } else if (i == 10004) {
                    userTrackerService2 = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                    str3 = UTConstants.E_TB_LOGIN_CANCEL;
                } else {
                    if (i == 10005) {
                        map = new HashMap();
                        int i2 = messageCreateMessage.code;
                        String str4 = messageCreateMessage.message;
                        map.put("code", i2 + "");
                        if (!TextUtils.isEmpty(str4)) {
                            map.put("message", str4);
                        }
                        userTrackerService = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                        str2 = UTConstants.E_TB_LOGIN_FAILURE;
                    } else {
                        map = new HashMap();
                        int i3 = messageCreateMessage.code;
                        String str5 = messageCreateMessage.message;
                        map.put("code", i3 + "");
                        if (!TextUtils.isEmpty(str5)) {
                            map.put("message", str5);
                        }
                        userTrackerService = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                        str2 = UTConstants.E_H5_LOGIN_FAILURE;
                    }
                    userTrackerService.send(str2, map);
                }
                userTrackerService2.send(str3, null);
            }
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            Message messageCreateMessage2 = MessageUtils.createMessage(i, new Object[0]);
            CallbackContext.mGlobalLoginCallback.onFailure(messageCreateMessage2.code, messageCreateMessage2.message);
        }
        CommonUtils.sendBroadcast((i == 10003 || i == 10004) ? LoginAction.NOTIFY_LOGIN_CANCEL : LoginAction.NOTIFY_LOGIN_FAILED);
        if (activity == null || !(activity instanceof LoginActivity)) {
            return;
        }
        CallbackContext.activity = null;
        activity.finish();
        CallbackContext.loginCallback = null;
    }

    private void a(Intent intent, LoginCallback loginCallback) {
        SDKLogger.d("login", "handleCheck");
        WeakReference<Activity> weakReference = CallbackContext.activity;
        if (weakReference == null || weakReference.get() == null || intent == null) {
            KernelContext.executorService.postUITask(new c(weakReference, loginCallback));
            return;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("token"))) {
            KernelContext.executorService.postUITask(new a(weakReference, loginCallback));
            return;
        }
        LoginByIVTokenTask loginByIVTokenTask = new LoginByIVTokenTask(weakReference.get(), new b(weakReference, loginCallback));
        Executor executor = ExecutorServiceImpl.mExecutor;
        if (executor == null) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        loginByIVTokenTask.executeOnExecutor(executor, intent.getStringExtra("token"), intent.getStringExtra("scene"), intent.getStringExtra(Constants.QUERY_STRING));
    }

    @Override // com.ali.auth.third.ui.support.BaseActivityResultHandler
    public void onCallbackContext(int i, int i2, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView) {
        String str;
        String str2;
        String str3;
        int i3;
        StringBuilder sb = new StringBuilder();
        sb.append("onCallbackContext requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        sb.append(intent == null ? "" : intent.getStringExtra("result"));
        SDKLogger.d("login", sb.toString());
        LoginStatus.resetLoginFlag();
        LoginCallback loginCallback = (LoginCallback) CallbackContext.loginCallback;
        if (i == RequestCode.OPEN_H5_LOGIN && loginCallback != null) {
            if (i2 == ResultCode.SUCCESS.code) {
                str2 = "E_H5_LOGIN_SUCCESS";
                a(activity, str2, loginCallback);
                return;
            } else {
                if (i2 == ResultCode.IGNORE.code) {
                    return;
                }
                if (i2 != ResultCode.CHECK.code) {
                    str = "E_H5_CANCEL_FAILURE";
                    a(activity, str, loginCallback, 10003);
                    return;
                }
                a(intent, loginCallback);
            }
        }
        if (i == RequestCode.OPEN_TAOBAO && loginCallback != null) {
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("AUTH_TAOBAO", null);
            if (i2 == -1 && intent != null) {
                LoginAfterOpenTb loginAfterOpenTb = new LoginAfterOpenTb(CallbackContext.activity.get(), loginCallback);
                Executor executor = ExecutorServiceImpl.mExecutor;
                if (executor == null) {
                    executor = AsyncTask.THREAD_POOL_EXECUTOR;
                }
                loginAfterOpenTb.executeOnExecutor(executor, intent.getStringExtra("result"));
                return;
            }
            if (i2 == 0) {
                str3 = "E_TB_LOGIN_CANCEL";
                i3 = 10004;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("result from taobao : ");
                sb2.append(intent != null ? intent.getStringExtra("result") : "");
                SDKLogger.d("login", sb2.toString());
                str3 = "E_TB_LOGIN_FAILURE";
                i3 = 10005;
            }
            a(activity, str3, loginCallback, i3);
            return;
        }
        if (i == RequestCode.OPEN_QR_LOGIN && loginCallback != null) {
            if (i2 == ResultCode.SUCCESS.code) {
                str2 = "E_QR_LOGIN_SUCCESS";
                a(activity, str2, loginCallback);
                return;
            } else {
                str = "E_QR_CANCEL_FAILURE";
                a(activity, str, loginCallback, 10003);
                return;
            }
        }
        if (i == RequestCode.OPEN_QR_LOGIN_CONFIRM && loginCallback != null) {
            if (i2 == ResultCode.SUCCESS.code) {
                str2 = "E_QR_LOGIN_CONFIRM_SUCCESS";
                a(activity, str2, loginCallback);
                return;
            } else {
                str = "E_QR_LOGIN_CONFIRM_CANCEL";
                a(activity, str, loginCallback, 10003);
                return;
            }
        }
        if (i != RequestCode.OPEN_DOUBLE_CHECK) {
            if (i == RequestCode.OPEN_H5_UNBIND) {
                if (i2 == ResultCode.SUCCESS.code) {
                    a(activity, "E_H5_UNBIND_SUCCESS", loginCallback);
                } else {
                    a(activity, "E_H5_UNBIND_FAILURE", loginCallback, 10003);
                }
                CallbackContext.loginCallback = null;
                return;
            }
            return;
        }
        a(intent, loginCallback);
    }

    @Override // com.ali.auth.third.ui.support.BaseActivityResultHandler
    public void onTaeSDKActivity(int i, int i2, Intent intent, BaseWebViewActivity baseWebViewActivity, Map<Class<?>, Object> map, WebView webView) {
        ResultCode resultCodeCreate;
        StringBuilder sb = new StringBuilder();
        sb.append("onTaeSDKActivity requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        sb.append(intent == null ? "" : intent.getStringExtra("result"));
        SDKLogger.d("login", sb.toString());
        LoginCallback loginCallback = (LoginCallback) CallbackContext.loginCallback;
        LoginStatus.resetLoginFlag();
        if (i == RequestCode.OPEN_H5_LOGIN) {
            if (i2 == ResultCode.SUCCESS.code) {
                webView.reload();
                return;
            }
            resultCodeCreate = ResultCode.create(10003, new Object[0]);
        } else {
            if (i != RequestCode.OPEN_TAOBAO) {
                if (i == RequestCode.OPEN_H5_UNBIND) {
                    if (i2 == ResultCode.SUCCESS.code) {
                        a(baseWebViewActivity, "E_H5_UNBIND_SUCCESS", loginCallback);
                    } else {
                        a(baseWebViewActivity, "E_H5_UNBIND_FAILURE", loginCallback, 10003);
                    }
                    CallbackContext.loginCallback = null;
                    return;
                }
                return;
            }
            if (i2 == -1 && intent != null) {
                RefreshPageAfterOpenTb refreshPageAfterOpenTb = new RefreshPageAfterOpenTb(baseWebViewActivity, webView);
                Executor executor = ExecutorServiceImpl.mExecutor;
                if (executor == null) {
                    executor = AsyncTask.THREAD_POOL_EXECUTOR;
                }
                refreshPageAfterOpenTb.executeOnExecutor(executor, intent.getStringExtra("result"));
                return;
            }
            if (i2 != 0) {
                SDKLogger.e("login", "taobao return " + i2);
                LoginComponent.INSTANCE.showH5Login(baseWebViewActivity);
                return;
            }
            resultCodeCreate = ResultCode.create(10003, new Object[0]);
        }
        baseWebViewActivity.setResult(resultCodeCreate);
    }
}
