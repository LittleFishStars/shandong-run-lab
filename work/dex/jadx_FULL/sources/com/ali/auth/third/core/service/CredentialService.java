package com.ali.auth.third.core.service;

import com.ali.auth.third.core.model.AccountContract;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface CredentialService {
    Session getSession();

    boolean isSessionValid();

    ResultCode logout();

    void refreshWhenLogin(LoginReturnData loginReturnData);

    void refreshWhenOfflineLogin(AccountContract accountContract);
}
