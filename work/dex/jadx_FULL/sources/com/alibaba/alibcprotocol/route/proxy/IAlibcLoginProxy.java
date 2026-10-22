package com.alibaba.alibcprotocol.route.proxy;

import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.callback.AlibcLoginCallback;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@a(a = AlibcProtocolConstant.LOGIN_CLASS_NAME)
public interface IAlibcLoginProxy extends IProxy {
    Map<String, Object> getUserInfo();

    void init(AlibcLoginCallback alibcLoginCallback);

    boolean isLogin();

    void logout(AlibcLoginCallback alibcLoginCallback);

    void showLogin(AlibcLoginCallback alibcLoginCallback);

    void turnOffDebug();

    void turnOnDebug();
}
