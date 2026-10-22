package com.alibaba.ariver.kernel.common.service;

import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVAccountService extends Proxiable {
    String getNick(Node node);

    String getUserAvatar(Node node);

    String getUserId(Node node);

    boolean isLogin(Node node);
}
