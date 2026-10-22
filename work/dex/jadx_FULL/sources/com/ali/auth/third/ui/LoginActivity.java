package com.ali.auth.third.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.LoginConstants;
import com.ali.auth.third.login.task.LoginBySsoTokenTask;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.context.CallbackContext;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginActivity extends Activity {
    public static final String TAG = "login.LoginActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LinearLayout f23499a;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SDKLogger.e(LoginActivity.TAG, "click to destroy");
            LoginActivity.this.finish();
            LoginStatus.resetLoginFlag();
        }
    }

    public void auth() {
        int intExtra = getIntent().getIntExtra(LoginConstants.PARAN_LOGIN_TYPE, 0);
        try {
            if (intExtra == 4) {
                String stringExtra = getIntent().getStringExtra("params");
                LoginComponent.INSTANCE.goQrCodeLogin(this, !TextUtils.isEmpty(stringExtra) ? JSONUtils.toMap(new JSONObject(stringExtra)) : null);
            } else {
                if (intExtra != 5) {
                    LoginComponent.INSTANCE.showLogin(this);
                    return;
                }
                String stringExtra2 = getIntent().getStringExtra("token");
                LoginBySsoTokenTask loginBySsoTokenTask = new LoginBySsoTokenTask(this, (LoginCallback) CallbackContext.loginCallback);
                Executor executor = ExecutorServiceImpl.mExecutor;
                if (executor == null) {
                    executor = AsyncTask.THREAD_POOL_EXECUTOR;
                }
                loginBySsoTokenTask.executeOnExecutor(executor, stringExtra2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        SDKLogger.d(TAG, "onActivityResult requestCode = " + i + " resultCode=" + i2);
        if (!KernelContext.checkServiceValid()) {
            finish();
            return;
        }
        this.f23499a.setClickable(true);
        this.f23499a.setLongClickable(true);
        super.onActivityResult(i, i2, intent);
        if (CallbackContext.activity == null) {
            CallbackContext.setActivity(this);
        }
        CallbackContext.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f23499a = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.f23499a);
        if (KernelContext.context == null) {
            KernelContext.context = getApplicationContext();
        }
        this.f23499a.setOnClickListener(new a());
        this.f23499a.setClickable(false);
        this.f23499a.setLongClickable(false);
        if (KernelContext.checkServiceValid()) {
            CallbackContext.setActivity(this);
            SDKLogger.e(TAG, "before mtop call showLogin");
            auth();
        } else {
            SDKLogger.d(TAG, "static field null");
            LoginStatus.resetLoginFlag();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        LoginStatus.resetLoginFlag();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (KernelContext.checkServiceValid()) {
            return;
        }
        finish();
    }
}
