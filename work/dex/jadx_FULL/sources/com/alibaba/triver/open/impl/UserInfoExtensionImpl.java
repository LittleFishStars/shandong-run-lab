package com.alibaba.triver.open.impl;

import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.login.LoginService;
import com.alibaba.triver.kit.api.proxy.IUserInfoExtension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UserInfoExtensionImpl implements IUserInfoExtension {
    @Override // com.alibaba.triver.kit.api.proxy.IUserInfoExtension
    public String getNick() {
        LoginService loginService = (LoginService) MemberSDK.getService(LoginService.class);
        if (loginService == null) {
            return "";
        }
        Session session = loginService.getSession();
        if (session != null) {
            return session.nick;
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IUserInfoExtension
    public String getSid() {
        LoginService loginService = (LoginService) MemberSDK.getService(LoginService.class);
        if (loginService == null) {
            return "";
        }
        Session session = loginService.getSession();
        if (session != null) {
            return session.openSid;
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IUserInfoExtension
    public String getUserAvatar() {
        LoginService loginService = (LoginService) MemberSDK.getService(LoginService.class);
        if (loginService == null) {
            return "";
        }
        Session session = loginService.getSession();
        if (session != null) {
            return session.avatarUrl;
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IUserInfoExtension
    public String getUserId() {
        Session session;
        LoginService loginService = (LoginService) MemberSDK.getService(LoginService.class);
        if (loginService == null || (session = loginService.getSession()) == null) {
            return null;
        }
        return session.openId;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IUserInfoExtension
    public boolean isLogin() {
        LoginService loginService = (LoginService) MemberSDK.getService(LoginService.class);
        if (loginService != null) {
            return loginService.checkSessionValid();
        }
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
