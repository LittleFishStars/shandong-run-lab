package com.alibaba.triver.permission;

import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.triver.kit.api.proxy.IUserInfoExtension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class AccountProxyImpl implements RVAccountService {
    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getNick(Node node) {
        IUserInfoExtension iUserInfoExtension = (IUserInfoExtension) ExtensionPoint.as(IUserInfoExtension.class).node(node).create();
        if (iUserInfoExtension != null) {
            return iUserInfoExtension.getNick();
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getUserAvatar(Node node) {
        IUserInfoExtension iUserInfoExtension = (IUserInfoExtension) ExtensionPoint.as(IUserInfoExtension.class).node(node).create();
        if (iUserInfoExtension != null) {
            return iUserInfoExtension.getUserAvatar();
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getUserId(Node node) {
        IUserInfoExtension iUserInfoExtension = (IUserInfoExtension) ExtensionPoint.as(IUserInfoExtension.class).node(node).create();
        if (iUserInfoExtension != null) {
            return iUserInfoExtension.getUserId();
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public boolean isLogin(Node node) {
        IUserInfoExtension iUserInfoExtension = (IUserInfoExtension) ExtensionPoint.as(IUserInfoExtension.class).node(node).create();
        if (iUserInfoExtension != null) {
            return iUserInfoExtension.isLogin();
        }
        return false;
    }
}
