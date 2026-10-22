package com.alibaba.alibclogin.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23599a = "LoginBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        List<ILoginListener> listenerList = AlibcLoginNotifyManager.getListenerList();
        if (LoginAction.NOTIFY_LOGIN_SUCCESS.name().equals(action)) {
            AlibcLogger.i(f23599a, "login success");
            Map<String, Object> userInfo = ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).getUserInfo();
            if (userInfo != null) {
                String strValueOf = String.valueOf(userInfo.get("userId"));
                String strValueOf2 = String.valueOf(userInfo.get("nick"));
                String strValueOf3 = String.valueOf(userInfo.get("topAccessToken"));
                if (listenerList != null) {
                    Iterator<ILoginListener> it = listenerList.iterator();
                    while (it.hasNext()) {
                        it.next().onLoginSuccess(strValueOf, strValueOf2, strValueOf3);
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (LoginAction.NOTIFY_LOGIN_FAILED.name().equals(action)) {
            AlibcLogger.i(f23599a, "login failed");
            return;
        }
        if (LoginAction.NOTIFY_LOGIN_CANCEL.name().equals(action)) {
            AlibcLogger.i(f23599a, "login canceled");
            return;
        }
        if (LoginAction.NOTIFY_LOGOUT.name().equals(action)) {
            AlibcLogger.i(f23599a, "execute logout");
            if (listenerList != null) {
                Iterator<ILoginListener> it2 = listenerList.iterator();
                while (it2.hasNext()) {
                    it2.next().onLogout();
                }
            }
        }
    }
}
