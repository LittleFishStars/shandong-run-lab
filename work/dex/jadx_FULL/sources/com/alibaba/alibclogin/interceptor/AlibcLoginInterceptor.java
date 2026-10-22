package com.alibaba.alibclogin.interceptor;

import android.os.Bundle;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.callback.AlibcLoginCallback;
import com.alibaba.alibcprotocol.container.AlibcContainerManager;
import com.alibaba.alibcprotocol.manager.AlibcInterceptCenter;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.BizPatternDO;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcLoginInterceptor implements AlibcInterceptCenter.IUrlInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23594a = "AlibcLoginInterceptor";

    @Override // com.alibaba.alibcprotocol.manager.AlibcInterceptCenter.IUrlInterceptor
    public boolean interceptor(RouteRequest routeRequest, Bundle bundle) {
        if (AlibcProtocolConstant.LOGIN_COUNT > 3) {
            AlibcLogger.i(f23594a, "频繁登录次数超过3次");
            return false;
        }
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        String rawUrl = routeRequest.getRawUrl();
        if (config != null) {
            for (BizPatternDO bizPatternDO : config.getBizPattern()) {
                String bizCode = bizPatternDO.getBizCode();
                if ("login".equals(bizCode)) {
                    if (AlibcUrlCheck.regularCheck(bizPatternDO.getPattern(), rawUrl)) {
                        ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).showLogin(new AlibcLoginCallback() { // from class: com.alibaba.alibclogin.interceptor.AlibcLoginInterceptor.1
                            @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                            public final void onFailure(int i, String str) {
                                AlibcLogger.e(AlibcLoginInterceptor.f23594a, "login fail: code = " + i + " ,msg = " + str);
                                AlibcProtocolConstant.LOGIN_COUNT = AlibcProtocolConstant.LOGIN_COUNT + 1;
                                AlibcContainerManager.goBack("h5", true);
                            }

                            @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                            public final void onSuccess(String str, String str2) {
                                AlibcLogger.i(AlibcLoginInterceptor.f23594a, "login success");
                                AlibcProtocolConstant.LOGIN_COUNT = 0;
                                AlibcContainerManager.reload("h5");
                            }
                        });
                        return true;
                    }
                } else if (AlibcProtocolConstant.LOGOUT.equals(bizCode) && AlibcUrlCheck.regularCheck(bizPatternDO.getPattern(), rawUrl)) {
                    ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).logout(new AlibcLoginCallback() { // from class: com.alibaba.alibclogin.interceptor.AlibcLoginInterceptor.2
                        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                        public final void onFailure(int i, String str) {
                            AlibcLogger.e(AlibcLoginInterceptor.f23594a, "登出失败: code = " + i + ", msg = " + str);
                        }

                        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                        public final void onSuccess(String str, String str2) {
                            ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).showLogin(new AlibcLoginCallback() { // from class: com.alibaba.alibclogin.interceptor.AlibcLoginInterceptor.2.1
                                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                                public final void onFailure(int i, String str3) {
                                    AlibcLogger.e(AlibcLoginInterceptor.f23594a, "切换账号失败: code = " + i + ", msg = " + str3);
                                }

                                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                                public final void onSuccess(String str3, String str4) {
                                    AlibcLogger.i(AlibcLoginInterceptor.f23594a, "成功切换账号，拉起登录页");
                                    AlibcContainerManager.reload("h5");
                                }
                            });
                        }
                    });
                    return true;
                }
            }
        }
        return false;
    }
}
