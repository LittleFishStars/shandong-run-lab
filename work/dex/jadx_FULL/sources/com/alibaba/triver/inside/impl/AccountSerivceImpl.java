package com.alibaba.triver.inside.impl;

import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.taobao.login4android.api.Login;
import com.taobao.tao.remotebusiness.login.IRemoteLogin;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import mtopsdk.mtop.intf.Mtop;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AccountSerivceImpl implements RVAccountService {
    public Mtop getMtop() {
        return Mtop.instance("INNER", ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getNick(Node node) {
        IRemoteLogin login = RemoteLogin.getLogin(getMtop());
        return (login == null || login.getLoginContext() == null) ? "" : login.getLoginContext().nickname;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getUserAvatar(Node node) {
        try {
            return Login.getHeadPicLink();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getUserId(Node node) {
        IRemoteLogin login = RemoteLogin.getLogin(getMtop());
        if (login == null || login.getLoginContext() == null) {
            return null;
        }
        return login.getLoginContext().userId;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public boolean isLogin(Node node) {
        return RemoteLogin.isSessionValid(getMtop(), (String) null);
    }
}
