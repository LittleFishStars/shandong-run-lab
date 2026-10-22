package com.alibaba.alibclogin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.callback.InitResultCallback;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.trace.LoggerProxy;
import com.ali.auth.third.login.LoginConstants;
import com.ali.auth.third.login.LoginService;
import com.ali.auth.third.login.callback.LogoutCallback;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.callback.AlibcLoginCallback;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.baichuan.log.TLog;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.model.Environment;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcLogin implements IAlibcLoginProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23584a = "AlibcLogin";
    private static volatile AlibcLogin d;
    private boolean b;
    private LoginService c;

    public static /* synthetic */ void access$000(Context context, Map map) {
        if (AlibcCommonUtils.isOpenAnalysisTool() && AlibcCommonUtils.isApkDebug(context)) {
            HashMap map2 = new HashMap();
            map2.put("appkey", AlibcBaseTradeCommon.getAppKey());
            map2.put("sdkVersion", "5.0.2.5");
            map2.put("ttid", AlibcBaseTradeCommon.ttid);
            map2.put("utdid", AlibcBaseTradeCommon.getUtdid());
            map2.put("isLogin", getInstance().isLogin() ? "已登录" : "未登录");
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (!TextUtils.isEmpty(str)) {
                        map2.put(str, str2);
                    }
                }
            }
            List<String> suiteList = AlibcProtocolUtils.getSuiteList();
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = suiteList.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
            }
            map2.put("suiteList", sb.toString());
            try {
                Class.forName("com.alibaba.triver_base_tools.BaseTriverAnalyzerTools").getMethod("saveAppInfo", Context.class, HashMap.class, String.class).invoke(null, context, map2, "bc_info");
            } catch (Exception unused) {
                AlibcLogger.e(f23584a, "");
            }
        }
    }

    public static /* synthetic */ void access$100(String str, boolean z, String str2, String str3) {
        AlibcUserTracker.getInstance().trackAlarm(z, str, str2, str3, new JSONObject());
    }

    public static IAlibcLoginProxy getInstance() {
        IAlibcLoginProxy iAlibcLoginProxy = (IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class);
        if (iAlibcLoginProxy != null) {
            return iAlibcLoginProxy;
        }
        if (d == null) {
            synchronized (AlibcLogin.class) {
                if (d == null) {
                    d = new AlibcLogin();
                }
            }
        }
        return d;
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy
    public Map<String, Object> getUserInfo() {
        LoginService loginService = this.c;
        if (loginService == null || !this.b) {
            return null;
        }
        Session session = loginService.getSession();
        HashMap map = new HashMap(16);
        if (session != null) {
            map.put("userId", session.openId);
            map.put("nick", session.nick);
            map.put("topAccessToken", session.topAccessToken);
            map.put("topAuthCode", session.topAuthCode);
        }
        return map;
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy
    public synchronized void init(final AlibcLoginCallback alibcLoginCallback) {
        if (alibcLoginCallback == null) {
            return;
        }
        if (AlibcBaseTradeCommon.context == null) {
            alibcLoginCallback.onFailure(-1, AlibcProtocolConstant.CONTEXT_NULL_MSG);
            return;
        }
        if (this.b) {
            AlibcLogger.i(f23584a, "login sdk init complete");
            alibcLoginCallback.onSuccess("", "");
            return;
        }
        MemberSDK.setLoggerProxy(new LoggerProxy() { // from class: com.alibaba.alibclogin.AlibcLogin.1
            @Override // com.ali.auth.third.core.trace.LoggerProxy
            public final void d(String str, String str2) {
                TLog.logd(str, str2);
            }

            @Override // com.ali.auth.third.core.trace.LoggerProxy
            public final void e(String str, String str2, Throwable th) {
                TLog.loge(str, str2, th);
            }

            @Override // com.ali.auth.third.core.trace.LoggerProxy
            public final void i(String str, String str2) {
                TLog.logi(str, str2);
            }

            @Override // com.ali.auth.third.core.trace.LoggerProxy
            public final void w(String str, String str2) {
                TLog.logw(str, str2);
            }

            @Override // com.ali.auth.third.core.trace.LoggerProxy
            public final void d(String str, String str2, Throwable th) {
                TLog.logd(str, str2 + Log.getStackTraceString(th));
            }

            @Override // com.ali.auth.third.core.trace.LoggerProxy
            public final void e(String str, String str2) {
                TLog.loge(str, str2);
            }
        });
        Environment environment = AlibcBaseTradeCommon.getEnvironment();
        if (environment != null) {
            if (environment == Environment.TEST) {
                MemberSDK.setEnvironment(com.ali.auth.third.core.config.Environment.TEST);
            } else if (environment == Environment.PRE) {
                MemberSDK.setEnvironment(com.ali.auth.third.core.config.Environment.PRE);
            } else {
                MemberSDK.setEnvironment(com.ali.auth.third.core.config.Environment.ONLINE);
            }
        }
        ConfigManager.POSTFIX_OF_SECURITY_JPG_USER_SET = "baichuan";
        MemberSDK.init(AlibcBaseTradeCommon.context, new InitResultCallback() { // from class: com.alibaba.alibclogin.AlibcLogin.2
            @Override // com.ali.auth.third.core.callback.FailureCallback
            public final void onFailure(int i, String str) {
                alibcLoginCallback.onFailure(i, str);
                AlibcLogin.this.b = false;
            }

            @Override // com.ali.auth.third.core.callback.InitResultCallback
            public final void onSuccess() {
                AlibcLogin.this.b = true;
                AlibcLogin.this.c = (LoginService) MemberSDK.getService(LoginService.class);
                if (AlibcLogin.this.c == null) {
                    alibcLoginCallback.onFailure(401, AlibcProtocolConstant.LOGIN_SERVICE_NULL_MSG);
                    return;
                }
                AlibcLogger.i(AlibcLogin.f23584a, "login sdk init success");
                if (AlibcLogin.this.c.getSession() != null) {
                    AnalyticsMgr.updateUserAccount(AlibcLogin.this.c.getSession().nick, AlibcLogin.this.c.getSession().userid, AlibcLogin.this.c.getSession().openId);
                }
                alibcLoginCallback.onSuccess("", "");
            }
        });
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy
    public boolean isLogin() {
        LoginService loginService = this.c;
        if (loginService == null || !this.b) {
            return false;
        }
        return loginService.checkSessionValid();
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy
    public void logout(final AlibcLoginCallback alibcLoginCallback) {
        if (alibcLoginCallback == null) {
            return;
        }
        AlibcTradeCommon.AlibcTradeCommonResult alibcTradeCommonResultInit = AlibcTradeCommon.init(AlibcTradeCommon.sApplication, new JSONObject(), AlibcTradeCommon.sExtParams);
        if (alibcTradeCommonResultInit.result != 1) {
            getInstance().init(new AlibcLoginCallback() { // from class: com.alibaba.alibclogin.AlibcLogin.4
                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public final void onFailure(int i, String str) {
                    alibcLoginCallback.onFailure(i, str);
                }

                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public final void onSuccess(String str, String str2) {
                    if (AlibcLogin.this.c == null || !AlibcLogin.this.b) {
                        alibcLoginCallback.onFailure(401, AlibcProtocolConstant.LOGIN_SERVICE_NULL_MSG);
                    } else {
                        AlibcLogin.this.c.logout(new LogoutCallback() { // from class: com.alibaba.alibclogin.AlibcLogin.4.1
                            @Override // com.ali.auth.third.core.callback.FailureCallback
                            public final void onFailure(int i, String str3) {
                                alibcLoginCallback.onFailure(i, str3);
                            }

                            @Override // com.ali.auth.third.login.callback.LogoutCallback
                            public final void onSuccess() {
                                AlibcLogin.access$000(AlibcBaseTradeCommon.context, null);
                                alibcLoginCallback.onSuccess("", "");
                            }
                        });
                    }
                }
            });
            return;
        }
        AlibcLogger.d(f23584a, "logout失败: code = " + alibcTradeCommonResultInit.errCode + ", msg = " + alibcTradeCommonResultInit.errMsg);
        alibcLoginCallback.onFailure(alibcTradeCommonResultInit.errCode, alibcTradeCommonResultInit.errMsg);
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy
    public void showLogin(final AlibcLoginCallback alibcLoginCallback) {
        if (alibcLoginCallback == null) {
            return;
        }
        AlibcTradeCommon.AlibcTradeCommonResult alibcTradeCommonResultInit = AlibcTradeCommon.init(AlibcTradeCommon.sApplication, new JSONObject(), AlibcTradeCommon.sExtParams);
        if (alibcTradeCommonResultInit.result != 1) {
            getInstance().init(new AlibcLoginCallback() { // from class: com.alibaba.alibclogin.AlibcLogin.3
                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public final void onFailure(int i, String str) {
                    alibcLoginCallback.onFailure(i, str);
                }

                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public final void onSuccess(String str, String str2) {
                    if (AlibcLogin.this.c == null || !AlibcLogin.this.b) {
                        alibcLoginCallback.onFailure(401, AlibcProtocolConstant.LOGIN_SERVICE_NULL_MSG);
                    } else {
                        AlibcLogin.this.c.auth(new LoginCallback() { // from class: com.alibaba.alibclogin.AlibcLogin.3.1
                            @Override // com.ali.auth.third.core.callback.FailureCallback
                            public final void onFailure(int i, String str3) {
                                alibcLoginCallback.onFailure(i, str3);
                                AlibcLogin.access$100(UserTrackConstant.E_LOGIN, false, String.valueOf(i), str3);
                                AlibcLogin.access$000(AlibcBaseTradeCommon.context, null);
                            }

                            @Override // com.ali.auth.third.core.callback.LoginCallback
                            public final void onSuccess(Session session) {
                                UTAnalytics.getInstance().updateUserAccount(session.nick, session.userid, session.openId);
                                alibcLoginCallback.onSuccess(session.openId, session.nick);
                                HashMap map = new HashMap();
                                map.put(LoginConstants.PARAN_LOGIN_INFO, "openId=" + session.openId + ", nick=" + session.nick);
                                AlibcLogin.access$000(AlibcBaseTradeCommon.context, map);
                                AlibcLogin.access$100(UserTrackConstant.E_LOGIN, true, "0", "");
                            }
                        });
                    }
                }
            });
            return;
        }
        AlibcLogger.d(f23584a, "showLogin失败: code = " + alibcTradeCommonResultInit.errCode + ", msg = " + alibcTradeCommonResultInit.errMsg);
        alibcLoginCallback.onFailure(alibcTradeCommonResultInit.errCode, alibcTradeCommonResultInit.errMsg);
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy
    public void turnOffDebug() {
        MemberSDK.turnOffDebug();
    }

    @Override // com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy
    public void turnOnDebug() {
        MemberSDK.turnOnDebug();
    }
}
