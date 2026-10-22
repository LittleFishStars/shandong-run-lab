package com.ali.auth.third.mtop.rpc;

import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.util.ReflectionUtils;
import com.ali.auth.third.login.LoginServiceImpl;
import com.taobao.tao.remotebusiness.login.IRemoteLogin;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.onLoginListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MtopRemoteLoginImpl implements IRemoteLogin {

    public class a implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ onLoginListener f23494a;

        public a(MtopRemoteLoginImpl mtopRemoteLoginImpl, onLoginListener onloginlistener) {
            this.f23494a = onloginlistener;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            onLoginListener onloginlistener = this.f23494a;
            if (onloginlistener != null) {
                if (i == 10003) {
                    onloginlistener.onLoginCancel();
                } else {
                    onloginlistener.onLoginFail();
                }
            }
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            onLoginListener onloginlistener = this.f23494a;
            if (onloginlistener != null) {
                onloginlistener.onLoginSuccess();
            }
        }
    }

    public LoginContext getLoginContext() {
        LoginContext loginContext = new LoginContext();
        try {
            loginContext.nickname = KernelContext.credentialService.getSession().nick;
        } catch (Exception unused) {
        }
        return loginContext;
    }

    public boolean isLogining() {
        try {
            Object objInvoke = ReflectionUtils.invoke("com.ali.auth.third.login.util.LoginStatus", "isLogining", null, Class.forName("com.ali.auth.third.login.util.LoginStatus").newInstance(), null);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (ClassNotFoundException | Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isSessionValid() {
        return KernelContext.credentialService.isSessionValid();
    }

    public void login(onLoginListener onloginlistener, boolean z) {
        try {
            ReflectionUtils.invoke("com.ali.auth.third.login.LoginServiceImpl", "auth", new String[]{"com.ali.auth.third.core.callback.LoginCallback"}, LoginServiceImpl.class.newInstance(), new Object[]{new a(this, onloginlistener)});
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
