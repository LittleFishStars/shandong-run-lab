package com.alibaba.alibcprotocol.container;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcPluginCallback;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcContainerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23607a = "AlibcContainerManager";
    private static final Map<String, AlibcBaseContainer> b = new ConcurrentHashMap();

    public static void closeContainer(String str, AlibcTradeContext alibcTradeContext) {
        AlibcBaseContainer alibcBaseContainer = b.get(str);
        if (alibcBaseContainer != null) {
            alibcBaseContainer.closeContainer();
        }
    }

    public static void goBack(String str, boolean z) {
        AlibcBaseContainer alibcBaseContainer = b.get(str);
        if (alibcBaseContainer != null) {
            alibcBaseContainer.goBack(z);
        }
    }

    public static void loadUrl(String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AlibcBaseContainer alibcBaseContainer = b.get(str);
        String str4 = f23607a;
        AlibcLogger.i(str4, "create container instance cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (alibcBaseContainer == null) {
            AlibcLogger.e(str4, "get container instance fail");
            return;
        }
        if ((!"miniapp".equals(str) || !AlibcSdkManager.getInstance().supportComponent("triver_sdk")) && (!"h5".equals(str) || !AlibcSdkManager.getInstance().supportComponent("webview_sdk"))) {
            AlibcLogger.e(str4, "component of " + str + " is not support");
            return;
        }
        alibcBaseContainer.runTask((RouteRequest) null, str2, str3);
        HashMap map = new HashMap();
        map.put("type", str);
        map.put("url", str2);
        AlibcLogger.flowLog("baichuan", "OPEN@APP_INNER_SUCCESS", "BC_API_CALL", "应用内加载", map);
    }

    public static void registerContainer(String str, final String str2, AlibcTradeContext alibcTradeContext, AlibcContainerCallback alibcContainerCallback) {
        Map<String, AlibcBaseContainer> map = b;
        if (map.isEmpty() || map.get(str) == null) {
            try {
                Class<?> cls = Class.forName(str2);
                if (AlibcBaseContainer.class.isAssignableFrom(cls)) {
                    if (str2.equals(AlibcProtocolConstant.TRIVER_CONTAINER)) {
                        AlibcSdkManager.getInstance().registerSDK("triver_sdk", str2);
                    }
                    if (str2.equals(AlibcProtocolConstant.WEBVIEW_CONTAINER)) {
                        AlibcSdkManager.getInstance().registerSDK("webview_sdk", str2);
                    }
                    AlibcLogger.i(f23607a, "container component exist: " + str2);
                    AlibcBaseContainer alibcBaseContainer = (AlibcBaseContainer) cls.newInstance();
                    alibcBaseContainer.initContainer(alibcTradeContext, new AlibcPluginCallback() { // from class: com.alibaba.alibcprotocol.container.AlibcContainerManager.1
                        @Override // com.alibaba.alibcprotocol.jsbridge.callback.AlibcPluginCallback
                        public final void onRegisterFail(int i, String str3) {
                            AlibcLogger.e(AlibcContainerManager.f23607a, "container register fail: code = " + i + ", msg = " + str3);
                        }

                        @Override // com.alibaba.alibcprotocol.jsbridge.callback.AlibcPluginCallback
                        public final void onRegisterSuccess() {
                            AlibcLogger.i(AlibcContainerManager.f23607a, "container register success: " + str2);
                        }
                    }, alibcContainerCallback);
                    map.put(str, alibcBaseContainer);
                }
            } catch (Exception e) {
                AlibcLogger.e(f23607a, "load container instance error: " + e.getMessage());
                if (str2.equals(AlibcProtocolConstant.TRIVER_CONTAINER)) {
                    AlibcSdkManager.getInstance().unRegisterSdk("triver_sdk");
                    AlibcLogger.saveLog("baichuan", "TRIVER_INIT_FAIL", "TRIVER_SDK_INIT", "triver sdk init fail", new HashMap(), "error");
                }
                if (str2.equals(AlibcProtocolConstant.WEBVIEW_CONTAINER)) {
                    AlibcSdkManager.getInstance().unRegisterSdk("webview_sdk");
                    AlibcLogger.saveLog("baichuan", "WEBVIEW_INIT_FAIL", "WEBVIEW_SDK_INIT", "webview sdk init fail", new HashMap(), "error");
                }
            }
        }
    }

    public static void reload(String str) {
        AlibcBaseContainer alibcBaseContainer = b.get(str);
        if (alibcBaseContainer != null) {
            alibcBaseContainer.reload();
        }
    }

    public static void loadUrl(RouteRequest routeRequest, String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AlibcBaseContainer alibcBaseContainer = b.get(str);
        String str4 = f23607a;
        AlibcLogger.i(str4, "create container instance cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (alibcBaseContainer != null) {
            if (("miniapp".equals(str) && AlibcSdkManager.getInstance().supportComponent("triver_sdk")) || ("h5".equals(str) && AlibcSdkManager.getInstance().supportComponent("webview_sdk"))) {
                alibcBaseContainer.runTask(routeRequest, str2, str3);
                HashMap map = new HashMap();
                map.put("type", str);
                map.put("url", str2);
                AlibcLogger.flowLog("baichuan", "OPEN@APP_INNER_SUCCESS", "BC_API_CALL", "应用内加载", map);
                return;
            }
            AlibcLogger.e(str4, "component of " + str + " is not support");
            return;
        }
        AlibcLogger.e(str4, "get container instance fail");
    }

    public static void loadUrl(String str, String str2, String str3, String str4, Context context) {
        AlibcBaseContainer alibcBaseContainer;
        if (AlibcProtocolConstant.THIRD_WEBVIEW.equals(str4)) {
            if (TextUtils.isEmpty(str) || (alibcBaseContainer = b.get(str)) == null) {
                return;
            }
            alibcBaseContainer.runTask(str2, str4, context);
            HashMap map = new HashMap();
            map.put("type", str);
            map.put("url", str2);
            AlibcLogger.flowLog("baichuan", "OPEN@APP_INNER_SUCCESS", "BC_API_CALL", "应用内加载", map);
            return;
        }
        loadUrl(str, str2, str3);
    }

    public static void loadUrl(String str, String str2, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        AlibcBaseContainer alibcBaseContainer;
        if (TextUtils.isEmpty(str) || (alibcBaseContainer = b.get(str)) == null) {
            return;
        }
        alibcBaseContainer.runTask(str2, alibcComponentReRenderCallback);
        HashMap map = new HashMap();
        map.put("type", str);
        map.put("url", str2);
        AlibcLogger.flowLog("baichuan", "OPEN@APP_INNER_SUCCESS", "BC_API_CALL", "应用内加载", map);
    }
}
