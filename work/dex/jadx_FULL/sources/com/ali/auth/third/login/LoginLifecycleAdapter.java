package com.ali.auth.third.login;

import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.service.CredentialService;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.login.handler.LoginActivityResultHandler;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.support.ActivityResultHandler;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginLifecycleAdapter {
    public static final String TAG = "Member.LoginLifecycleAdapter";

    public static void init() {
        SDKLogger.d(TAG, "LoginLifecycle init ");
        a.c = (RpcService) KernelContext.getService(RpcService.class, null);
        a.f23464a = (CredentialService) KernelContext.getService(CredentialService.class, null);
        a.d = (ExecutorService) KernelContext.getService(ExecutorService.class, null);
        a.b = (StorageService) KernelContext.getService(StorageService.class, null);
        LoginActivityResultHandler loginActivityResultHandler = new LoginActivityResultHandler();
        KernelContext.registerService(new Class[]{ActivityResultHandler.class}, loginActivityResultHandler, Collections.singletonMap(ActivityResultHandler.REQUEST_CODE_KEY, String.valueOf(RequestCode.OPEN_H5_LOGIN)));
        KernelContext.registerService(new Class[]{ActivityResultHandler.class}, loginActivityResultHandler, Collections.singletonMap(ActivityResultHandler.REQUEST_CODE_KEY, String.valueOf(RequestCode.OPEN_TAOBAO)));
        KernelContext.registerService(new Class[]{ActivityResultHandler.class}, loginActivityResultHandler, Collections.singletonMap(ActivityResultHandler.REQUEST_CODE_KEY, String.valueOf(RequestCode.OPEN_DOUBLE_CHECK)));
        KernelContext.registerService(new Class[]{ActivityResultHandler.class}, loginActivityResultHandler, Collections.singletonMap(ActivityResultHandler.REQUEST_CODE_KEY, String.valueOf(RequestCode.OPEN_QR_LOGIN)));
        KernelContext.registerService(new Class[]{ActivityResultHandler.class}, loginActivityResultHandler, Collections.singletonMap(ActivityResultHandler.REQUEST_CODE_KEY, String.valueOf(RequestCode.OPEN_QR_LOGIN_CONFIRM)));
        Map mapSingletonMap = Collections.singletonMap(Constants.ISV_SCOPE_FLAG, "true");
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        KernelContext.registerService(new Class[]{LoginService.class}, loginServiceImpl, mapSingletonMap);
        LoginStatus.init(KernelContext.getApplicationContext());
        if (loginServiceImpl.checkSessionValid()) {
            return;
        }
        loginServiceImpl.autoLogin(null);
    }
}
