package com.ali.auth.third.login.bridge;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.LoginConstants;
import com.ali.auth.third.login.task.BindByUsernameTask;
import com.ali.auth.third.login.task.LoginByQrCodeTask;
import com.ali.auth.third.login.task.LoginByUsernameTask;
import com.ali.auth.third.login.task.QrLoginConfirmTask;
import com.ali.auth.third.ui.webview.BridgeMethod;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginBridge {
    @BridgeMethod
    public void auth(com.ali.auth.third.ui.context.a aVar, String str) {
        LoginByUsernameTask loginByUsernameTask = new LoginByUsernameTask(aVar);
        Executor executor = ExecutorServiceImpl.mExecutor;
        if (executor == null) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        loginByUsernameTask.executeOnExecutor(executor, str);
    }

    @BridgeMethod
    public void bindByUsername(com.ali.auth.third.ui.context.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = JSONUtils.optString(jSONObjectOptJSONObject, LoginConstants.PARAN_LOGIN_INFO);
                BindByUsernameTask bindByUsernameTask = new BindByUsernameTask(aVar);
                Executor executor = ExecutorServiceImpl.mExecutor;
                if (executor == null) {
                    executor = AsyncTask.THREAD_POOL_EXECUTOR;
                }
                bindByUsernameTask.executeOnExecutor(executor, strOptString);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @BridgeMethod
    public void loginByQrCode(com.ali.auth.third.ui.context.a aVar, String str) {
        new LoginByQrCodeTask(aVar, false).execute(str);
    }

    @BridgeMethod
    public void loginByUsername(com.ali.auth.third.ui.context.a aVar, String str) {
        LoginByUsernameTask loginByUsernameTask = new LoginByUsernameTask(aVar);
        Executor executor = ExecutorServiceImpl.mExecutor;
        if (executor == null) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        loginByUsernameTask.executeOnExecutor(executor, str);
    }

    @BridgeMethod
    public void qrLoginConfirm(com.ali.auth.third.ui.context.a aVar, String str) {
        new QrLoginConfirmTask(aVar).execute(str);
    }

    @BridgeMethod
    public void unbindByUsername(com.ali.auth.third.ui.context.a aVar, String str) {
    }
}
