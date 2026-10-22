package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Remote
@Deprecated
public interface IUserInfoExtension extends Extension {
    String getNick();

    String getSid();

    String getUserAvatar();

    String getUserId();

    boolean isLogin();
}
