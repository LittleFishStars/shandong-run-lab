package com.alibaba.ariver.remotedebug.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.core.state.RemoteDebugState;
import com.alibaba.ariver.remotedebug.view.c;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements NetworkUtil.NetworkListener, com.alibaba.ariver.remotedebug.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24383a = "AriverRemoteDebug:RemoteDebugController";
    private final com.alibaba.ariver.remotedebug.a.b b;
    private final String c;
    private final Context d;
    private final String e;
    private final com.alibaba.ariver.remotedebug.worker.b f;
    private boolean g;
    private c h;
    private App i;

    public interface a {
        void a();
    }

    public b(Context context, com.alibaba.ariver.remotedebug.worker.b bVar, App app, String str) {
        this.i = app;
        String appId = app.getAppId();
        this.c = appId;
        this.d = context;
        this.e = str;
        this.f = bVar;
        this.b = com.alibaba.ariver.remotedebug.a.c.a(1, appId, this);
        a(app);
    }

    private String f(String str) {
        RVRemoteDebugProxy rVRemoteDebugProxy = (RVRemoteDebugProxy) RVProxy.get(RVRemoteDebugProxy.class);
        if (RVKernelUtils.isDebug()) {
            String strA = com.alibaba.ariver.remotedebug.b.b.a(this.c, str);
            RVLogger.d(f24383a, "generateRemoteDebugUrl getRemoteDebugUrlForDebug: " + strA);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        String remoteDebugWebSocketUrl = rVRemoteDebugProxy.getRemoteDebugWebSocketUrl(this.c, str);
        if (TextUtils.isEmpty(remoteDebugWebSocketUrl)) {
            String str2 = String.format(com.alibaba.ariver.remotedebug.b.j, str, this.c);
            RVLogger.d(f24383a, "generateRemoteDebugUrl getWebSocketHostUrl: " + str2);
            return str2;
        }
        String str3 = remoteDebugWebSocketUrl + str;
        RVLogger.d(f24383a, "generateRemoteDebugUrl getWebSocketHostUrl from proxy " + str3);
        return str3;
    }

    private boolean g(String str) {
        if (str.startsWith(com.alibaba.ariver.remotedebug.core.a.f24382a)) {
            RVLogger.d(f24383a, "handleRemoteDebugMessage CMD_REMOTE_DISCONNECTED");
            this.h.a(RemoteDebugState.STATE_REMOTE_DISCONNECTED);
            return true;
        }
        if (str.startsWith(com.alibaba.ariver.remotedebug.core.a.c)) {
            RVLogger.d(f24383a, "handleRemoteDebugMessage CMD_HIT_BREAKPOINT");
            this.h.a(RemoteDebugState.STATE_HIT_BREAKPOINT);
            return true;
        }
        if (str.startsWith(com.alibaba.ariver.remotedebug.core.a.d)) {
            RVLogger.d(f24383a, "handleRemoteDebugMessage CMD_RELEASE_BREAKPOINT");
            this.h.a(RemoteDebugState.STATE_RELEASE_BREAKPOINT);
            return true;
        }
        if (str.startsWith(com.alibaba.ariver.remotedebug.core.a.f)) {
            RVLogger.d(f24383a, "handleRemoteDebugMessage CMD_RECV_RENDER_DEBUG");
            return h(str);
        }
        if (!str.startsWith(com.alibaba.ariver.remotedebug.core.a.g)) {
            return false;
        }
        RVLogger.d(f24383a, "handleRemoteDebugMessage CMD_DEBUG_JS");
        return i(str);
    }

    private boolean h(String str) {
        String strReplaceFirst = str.replaceFirst(com.alibaba.ariver.remotedebug.core.a.f, "");
        if (TextUtils.isEmpty(strReplaceFirst)) {
            RVLogger.d(f24383a, "handleRecvRenderDebug msgText is empty.");
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", (Object) strReplaceFirst);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        return this.f.c().a(jSONObject2, com.alibaba.ariver.remotedebug.b.c);
    }

    private boolean i(String str) {
        JSONObject object = JSONUtils.parseObject(str.replaceFirst(com.alibaba.ariver.remotedebug.core.a.g, ""));
        if (object == null || object.isEmpty()) {
            return false;
        }
        return this.f.c().b(object, com.alibaba.ariver.remotedebug.b.b);
    }

    @Override // com.alibaba.ariver.remotedebug.a.b.a
    public void c(String str) {
        RVLogger.d(f24383a, "onConnectSuccess");
        this.g = true;
        this.b.b(String.format(com.alibaba.ariver.remotedebug.core.a.e, this.e, "Android"));
        this.f.onAlipayJSBridgeReady();
        this.h.a(RemoteDebugState.STATE_CONNECTED);
    }

    @Override // com.alibaba.ariver.remotedebug.a.b.a
    public void d(String str) {
        RVLogger.d(f24383a, "onConnectClosed id:" + str);
        this.g = false;
    }

    @Override // com.alibaba.ariver.remotedebug.a.b.a
    public void e(String str) {
        RVLogger.d(f24383a, "recv message: " + str);
        if (TextUtils.isEmpty(str)) {
            RVLogger.d(f24383a, "recv message is empty！");
        } else if (g(str)) {
            RVLogger.d(f24383a, "recv message handleRemoteDebugMessage");
        } else {
            RVLogger.d(f24383a, "recv message handleMsgFromWorker");
            this.f.c().a(str);
        }
    }

    @Override // com.alibaba.ariver.kernel.common.network.NetworkUtil.NetworkListener
    public void onNetworkChanged(NetworkUtil.Network network, NetworkUtil.Network network2) {
        if (network2 == NetworkUtil.Network.NETWORK_NO_CONNECTION) {
            this.h.a(RemoteDebugState.STATE_NETWORK_UNAVAILABLE);
        }
    }

    public void b(String str) {
        RVLogger.d(f24383a, "sendMessageToRemoteWorker: " + str);
        this.b.b(str);
    }

    private void a(final App app) {
        final Activity activity = (Activity) app.getAppContext().getContext();
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.core.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.h = new c(app, new a() { // from class: com.alibaba.ariver.remotedebug.core.b.1.1
                    @Override // com.alibaba.ariver.remotedebug.core.b.a
                    public void a() {
                        b.this.a();
                    }
                });
                b.this.h.a(activity);
            }
        });
    }

    public boolean b() {
        RVLogger.d(f24383a, "isRemoteDebugConnected  " + this.g);
        return this.g;
    }

    public void a(String str, Bundle bundle) {
        String string = BundleUtils.getString(bundle, "channelId");
        if (TextUtils.isEmpty(string)) {
            RVLogger.d(f24383a, "registerWorker...channelId is null");
            return;
        }
        NetworkUtil.addListener(this.d, this);
        final String strF = f(string);
        final HashMap map = new HashMap();
        map.put("User-Agent", str);
        ExecutorUtils.execute(ExecutorType.NORMAL, new Runnable() { // from class: com.alibaba.ariver.remotedebug.core.b.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b.a(strF, map, null);
                } catch (Exception e) {
                    RVLogger.e(b.f24383a, "registerWorker connect error! ", e);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.remotedebug.a.b.a
    public void c() {
        RVLogger.d(f24383a, "onConnectFailed");
        this.g = false;
        this.h.a(RemoteDebugState.STATE_CONNECT_FAILED);
    }

    public void a(String str) {
        RVLogger.d(f24383a, "remoteLoadUrl: " + str);
        this.b.b(str);
    }

    public void a() {
        RVLogger.d(f24383a, "exitRemoteDebug.");
        b(com.alibaba.ariver.remotedebug.core.a.b);
        this.b.b(10001, "user_exit_debug");
        NetworkUtil.removeListener(this.d, this);
        this.i.exit();
    }

    @Override // com.alibaba.ariver.remotedebug.a.b.a
    public void a(String str, int i, String str2) {
        RVLogger.d(f24383a, "onConnectClosed id:" + str + " code: " + i + " errorMsg:" + str2);
        this.g = false;
        this.h.a(RemoteDebugState.STATE_CONNECT_FAILED);
    }

    @Override // com.alibaba.ariver.remotedebug.a.b.a
    public void a(byte[] bArr) {
        RVLogger.d(f24383a, "recv bytes[]");
        e(new String(bArr));
    }
}
