package com.alibaba.alibclogin;

import com.alibaba.alibcprotocol.base.AlibcJsEnum;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.callback.AlibcLoginCallback;
import com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcJsCallback;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcLoginPlugin extends AlibcApiPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23591a = "AlibcLoginPlugin";

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public boolean execute(String str, String str2, final AlibcJsCallback alibcJsCallback) {
        if (!AlibcSdkManager.getInstance().supportComponent("login_sdk")) {
            HashMap map = new HashMap(16);
            AlibcJsEnum alibcJsEnum = AlibcJsEnum.FAIL;
            alibcJsEnum.setCode(AlibcProtocolConstant.LOGIN_NOT_SUPPORT_CODE);
            alibcJsEnum.setMsg(AlibcProtocolConstant.LOGIN_NOT_SUPPORT_MSG);
            alibcJsCallback.fail(buildResult(alibcJsEnum, map));
            return false;
        }
        if ("isLogin".equals(str)) {
            boolean zIsLogin = ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).isLogin();
            HashMap map2 = new HashMap(16);
            map2.put("isLogin", Boolean.valueOf(zIsLogin));
            alibcJsCallback.success(buildResult(AlibcJsEnum.SUCCESS, map2));
            return true;
        }
        if (!"login".equals(str)) {
            if (!AlibcProtocolConstant.LOGOUT.equals(str)) {
                return true;
            }
            ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).logout(new AlibcLoginCallback() { // from class: com.alibaba.alibclogin.AlibcLoginPlugin.2
                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public final void onFailure(int i, String str3) {
                    AlibcLogger.e(AlibcLoginPlugin.f23591a, "logout fail: code = " + i + ", msg = " + str3);
                    HashMap map3 = new HashMap(16);
                    AlibcJsEnum alibcJsEnum2 = AlibcJsEnum.FAIL;
                    alibcJsEnum2.setCode(i);
                    alibcJsEnum2.setMsg(str3);
                    alibcJsCallback.fail(AlibcLoginPlugin.this.buildResult(alibcJsEnum2, map3));
                }

                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public final void onSuccess(String str3, String str4) {
                    alibcJsCallback.success();
                }
            });
            return true;
        }
        if (((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).isLogin()) {
            alibcJsCallback.success(((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).getUserInfo());
            return true;
        }
        ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).showLogin(new AlibcLoginCallback() { // from class: com.alibaba.alibclogin.AlibcLoginPlugin.1
            @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
            public final void onFailure(int i, String str3) {
                AlibcLogger.e(AlibcLoginPlugin.f23591a, "login fail: code = " + i + ", msg = " + str3);
                HashMap map3 = new HashMap(16);
                AlibcJsEnum alibcJsEnum2 = AlibcJsEnum.FAIL;
                alibcJsEnum2.setCode(i);
                alibcJsEnum2.setMsg(str3);
                alibcJsCallback.fail(AlibcLoginPlugin.this.buildResult(alibcJsEnum2, map3));
            }

            @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
            public final void onSuccess(String str3, String str4) {
                alibcJsCallback.success(((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).getUserInfo());
            }
        });
        return true;
    }

    @Override // com.alibaba.alibcprotocol.jsbridge.AlibcApiPlugin
    public String getPluginTag() {
        return "AliBCLogin";
    }
}
