package com.ali.auth.third.login.task;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.task.TaskWithDialog;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.RequestCode;
import com.ali.auth.third.ui.LoginWebViewActivity;
import com.ali.auth.third.ui.context.CallbackContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AbsLoginByCodeTask extends TaskWithDialog<String, Void, Void> {

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsLoginByCodeTask.this.doWhenResultFail(7, "");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsLoginByCodeTask.this.doWhenResultOk();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RpcResponse f23472a;

        public c(RpcResponse rpcResponse) {
            this.f23472a = rpcResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsLoginByCodeTask absLoginByCodeTask = AbsLoginByCodeTask.this;
            RpcResponse rpcResponse = this.f23472a;
            absLoginByCodeTask.doWhenResultFail(rpcResponse.code, rpcResponse.message);
        }
    }

    public AbsLoginByCodeTask(Activity activity) {
        super(activity);
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public Void asyncExecute(String... strArr) {
        RpcResponse<LoginReturnData> rpcResponseLogin = login(strArr);
        if (rpcResponseLogin == null) {
            KernelContext.executorService.postUITask(new a());
            return null;
        }
        int i = rpcResponseLogin.code;
        SDKLogger.d("AbsLoginByCodeTask", "asyncExecute code = " + i);
        try {
            if (i == 3000) {
                LoginReturnData loginReturnData = rpcResponseLogin.returnValue;
                if (loginReturnData != null) {
                    com.ali.auth.third.login.a.a.f23464a.refreshWhenLogin(loginReturnData);
                }
                KernelContext.executorService.postUITask(new b());
            } else if (i == 13060) {
                String str = rpcResponseLogin.returnValue.h5Url;
                SDKLogger.d("AbsLoginByCodeTask", "asyncExecute doubleCheckUrl = " + str);
                if (!TextUtils.isEmpty(str)) {
                    Activity activity = this.activity;
                    CallbackContext.setActivity(activity);
                    Intent intent = new Intent(activity, (Class<?>) LoginWebViewActivity.class);
                    intent.putExtra("url", str);
                    intent.putExtra("token", rpcResponseLogin.returnValue.token);
                    intent.putExtra("scene", rpcResponseLogin.returnValue.scene);
                    LoginReturnData loginReturnData2 = rpcResponseLogin.returnValue;
                    LoginWebViewActivity.token = loginReturnData2.token;
                    LoginWebViewActivity.scene = loginReturnData2.scene;
                    this.activity.startActivityForResult(intent, RequestCode.OPEN_DOUBLE_CHECK);
                }
            } else {
                KernelContext.executorService.postUITask(new c(rpcResponseLogin));
            }
        } catch (Exception e) {
            doWhenException(e);
            e.printStackTrace();
        }
        return null;
    }

    public abstract void doWhenResultFail(int i, String str);

    public abstract void doWhenResultOk();

    public abstract RpcResponse<LoginReturnData> login(String[] strArr);
}
