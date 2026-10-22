package com.alibaba.alibcprotocol.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcPluginCallback;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcPluginManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23610a = "AlibcPluginManager";
    private static final Map<String, a> b = new ConcurrentHashMap();
    private static final Map<String, AlibcApiPlugin> c = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f23612a;
        ClassLoader b;

        public a(String str, ClassLoader classLoader) {
            this.f23612a = str;
            this.b = classLoader;
        }
    }

    public static AlibcApiPlugin createPlugin(String str, Context context, WebView webView) {
        String str2;
        a aVar = b.get(str);
        if (aVar != null && (str2 = aVar.f23612a) != null) {
            try {
                ClassLoader classLoader = aVar.b;
                Class<?> cls = classLoader == null ? Class.forName(str2) : classLoader.loadClass(str2);
                if (cls != null && AlibcApiPlugin.class.isAssignableFrom(cls)) {
                    AlibcApiPlugin alibcApiPlugin = (AlibcApiPlugin) cls.newInstance();
                    Object obj = alibcApiPlugin.paramObj;
                    if (obj != null) {
                        alibcApiPlugin.initialize(context, webView, obj);
                    } else {
                        alibcApiPlugin.initialize(context, webView);
                    }
                    return alibcApiPlugin;
                }
            } catch (Exception e) {
                AlibcLogger.e(f23610a, "create plugin error: " + str + ". " + e.getMessage());
            }
            AlibcLogger.w(f23610a, "create plugin fail");
        }
        return null;
    }

    public static AlibcApiPlugin initPlugin(String str, Context context, WebView webView) {
        AlibcApiPlugin alibcApiPlugin = c.get(str);
        if (alibcApiPlugin != null) {
            Object obj = alibcApiPlugin.paramObj;
            if (obj != null) {
                alibcApiPlugin.initialize(context, webView, obj);
            } else {
                alibcApiPlugin.initialize(context, webView);
            }
        }
        return alibcApiPlugin;
    }

    public static void registerPlugin(String str, Class<? extends AlibcApiPlugin> cls) {
        registerPlugin(str, cls, true);
    }

    public static void registerPlugin(String str, Class<? extends AlibcApiPlugin> cls, boolean z) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        b.put(str, new a(cls.getName(), z ? cls.getClassLoader() : null));
    }

    public static void registerPlugin(final String str, final String str2, final AlibcPluginCallback alibcPluginCallback) {
        Map<String, AlibcApiPlugin> map = c;
        if (map.isEmpty() || map.get(str) == null) {
            ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.alibcprotocol.jsbridge.AlibcPluginManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Class<?> cls = Class.forName(str2);
                        if (AlibcApiPlugin.class.isAssignableFrom(cls)) {
                            AlibcPluginManager.c.put(str, (AlibcApiPlugin) cls.newInstance());
                            alibcPluginCallback.onRegisterSuccess();
                        }
                    } catch (Exception e) {
                        AlibcLogger.e(AlibcPluginManager.f23610a, "get class instance exception: " + e.getMessage());
                        alibcPluginCallback.onRegisterFail(AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE, "注册插件失败");
                    }
                }
            });
        }
    }
}
