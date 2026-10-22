package android.taobao.windvane.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.d.b;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVPluginManager {
    public static final String KEY_METHOD = "method";
    public static final String KEY_NAME = "name";
    private static final String SEPARATOR = "::";
    private static final String TAG = "WVPluginManager";
    private static j monitorService;
    private static final Map<String, WVApiPlugin> objPlugins = new ConcurrentHashMap();
    private static final Map<String, WVPluginInfo> plugins = new ConcurrentHashMap();
    private static final Map<b, Map<String, WVPluginInfo>> localPlugins = new ConcurrentHashMap();
    private static final Map<String, String> aliasPlugins = new ConcurrentHashMap();
    private static IJsBridgeService jsBridgeService = null;

    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:65:0x010c  */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x010c, please report this as an issue */
    public static WVApiPlugin createPlugin(String str, Context context, b bVar) {
        WVPluginInfo wVPluginInfo;
        Class<? extends WVApiPlugin> bridgeClass;
        String className;
        Map<String, WVPluginInfo> concurrentHashMap = new ConcurrentHashMap<>();
        if (bVar != null) {
            concurrentHashMap = localPlugins.get(bVar);
        }
        Map<String, WVApiPlugin> map = objPlugins;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            if (jsBridgeService == null) {
                initJsBridgeService();
            }
            IJsBridgeService iJsBridgeService = jsBridgeService;
            if (iJsBridgeService == null || (bridgeClass = iJsBridgeService.getBridgeClass(str)) == null) {
                wVPluginInfo = null;
            } else {
                registerPlugin(str, bridgeClass, true);
                wVPluginInfo = plugins.get(str);
                if (wVPluginInfo == null || wVPluginInfo.getClassName() == null) {
                    return null;
                }
                wVPluginInfo.getClassName();
            }
        } else {
            wVPluginInfo = concurrentHashMap.get(str);
            if (wVPluginInfo == null) {
                TaoLog.i(TAG, "无局部API，尝试从全局API获取");
            } else {
                TaoLog.i(TAG, "使用局部API");
            }
        }
        if (wVPluginInfo == null) {
            wVPluginInfo = plugins.get(str);
            if (wVPluginInfo != null) {
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.w(TAG, "create plugin failed, plugin not register or empty, " + str);
            }
            return null;
        }
        className = wVPluginInfo.getClassName();
        if (TextUtils.isEmpty(className)) {
            wVPluginInfo = plugins.get(str);
            if (wVPluginInfo != null || wVPluginInfo.getClassName() == null) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.w(TAG, "create plugin failed, plugin not register or empty, " + str);
                }
                return null;
            }
            className = wVPluginInfo.getClassName();
        }
        try {
            ClassLoader classLoader = wVPluginInfo.getClassLoader();
            Class<?> cls = classLoader == null ? Class.forName(className) : classLoader.loadClass(className);
            if (cls != null && WVApiPlugin.class.isAssignableFrom(cls)) {
                WVApiPlugin wVApiPlugin = (WVApiPlugin) cls.newInstance();
                if (wVPluginInfo.paramObj != null) {
                    wVApiPlugin.initialize(context, bVar, wVPluginInfo.paramObj, str);
                } else {
                    if (!(bVar instanceof b)) {
                        throw new RuntimeException("can not deal webview for its parent is not IWVWebView");
                    }
                    wVApiPlugin.initialize(context, bVar, null, str);
                }
                return wVApiPlugin;
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "create plugin error: " + str + ". " + e.getMessage());
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.w(TAG, "create plugin failed: " + str);
        }
        return null;
    }

    public static Map<String, String> getOriginalPlugin(String str, String str2) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TaoLog.w(TAG, "getOriginalPlugin failed, alias is empty.");
            return null;
        }
        String str3 = aliasPlugins.get(str + SEPARATOR + str2);
        if (TextUtils.isEmpty(str3) || (iIndexOf = str3.indexOf(SEPARATOR)) <= 0) {
            return null;
        }
        String strSubstring = str3.substring(0, iIndexOf);
        String strSubstring2 = str3.substring(iIndexOf + 2);
        HashMap map = new HashMap();
        map.put("name", strSubstring);
        map.put("method", strSubstring2);
        return map;
    }

    public static WVPluginInfo getPluginInfo(String str) {
        Map<String, WVPluginInfo> map = plugins;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    private static void initJsBridgeService() {
        registerWVJsBridgeService(new IJsBridgeService() { // from class: android.taobao.windvane.jsbridge.WVPluginManager.1
            @Override // android.taobao.windvane.jsbridge.IJsBridgeService
            public Class<? extends WVApiPlugin> getBridgeClass(String str) {
                ServiceInfo serviceInfo;
                if (GlobalConfig.context != null && !TextUtils.isEmpty(str)) {
                    Intent intent = new Intent(str);
                    intent.setPackage(GlobalConfig.context.getPackageName());
                    List<ResolveInfo> listQueryIntentServices = GlobalConfig.context.getPackageManager().queryIntentServices(intent, 4);
                    if (listQueryIntentServices != null && listQueryIntentServices.size() > 0 && (serviceInfo = listQueryIntentServices.get(0).serviceInfo) != null && serviceInfo.name != null) {
                        try {
                            return ((IJsBridgeService) GlobalConfig.context.getClassLoader().loadClass(serviceInfo.name).newInstance()).getBridgeClass(str);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                return null;
            }
        });
    }

    public static void registerAlias(String str, String str2, String str3, String str4) {
        if (!plugins.containsKey(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TaoLog.w(TAG, "registerAlias quit, this is no original plugin or alias is invalid.");
            return;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        aliasPlugins.put(str + SEPARATOR + str2, str3 + SEPARATOR + str4);
    }

    public static void registerLocalPlugin(b bVar, String str, Class<? extends WVApiPlugin> cls) {
        if (bVar == null) {
            registerPlugin(str, cls);
            return;
        }
        Map<b, Map<String, WVPluginInfo>> map = localPlugins;
        Map<String, WVPluginInfo> concurrentHashMap = map.get(bVar);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            map.put(bVar, concurrentHashMap);
        }
        registerPlugin(str, cls, true, concurrentHashMap);
        TaoLog.i(TAG, "注册到局部API，使用范围=[" + bVar.getClass().getSimpleName() + "],API=[" + str + SEPARATOR + cls.getSimpleName() + "]");
    }

    public static void registerPlugin(String str, Class<? extends WVApiPlugin> cls) {
        registerPlugin(str, cls, true);
    }

    public static void registerPluginwithParam(String str, Class<? extends WVApiPlugin> cls, Object... objArr) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        WVPluginInfo wVPluginInfo = new WVPluginInfo(cls.getName(), cls.getClassLoader());
        if (objArr != null) {
            wVPluginInfo.setParamObj(objArr);
        }
        plugins.put(str, wVPluginInfo);
        if (monitorService == null) {
            monitorService = (j) m.a().b(j.class);
        }
        j jVar = monitorService;
        if (jVar == null || jVar.g() == null) {
            return;
        }
        monitorService.g().c("HY_REGISTERPLUGIN", "HY_REGISTERPLUGIN", str + SEPARATOR + cls.getName(), "");
    }

    public static void registerWVJsBridgeService(IJsBridgeService iJsBridgeService) {
        jsBridgeService = iJsBridgeService;
    }

    public static void unregisterAlias(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TaoLog.w(TAG, "unregisterAlias quit, alias is invalid.");
            return;
        }
        aliasPlugins.remove(str + SEPARATOR + str2);
    }

    public static void unregisterLocalPlugins(b bVar) {
        Map<b, Map<String, WVPluginInfo>> map = localPlugins;
        if (map.get(bVar) == null) {
            return;
        }
        map.remove(bVar);
    }

    public static void unregisterPlugin(String str) {
        Map<String, WVPluginInfo> map = plugins;
        if (map.containsKey(str)) {
            map.remove(str);
            return;
        }
        Map<String, WVApiPlugin> map2 = objPlugins;
        if (map2.containsKey(str)) {
            map2.remove(str);
        }
    }

    public static class WVPluginInfo {
        private ClassLoader classLoader;
        private String className;
        private Object paramObj;

        public WVPluginInfo(String str) {
            this.className = str;
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public String getClassName() {
            return this.className;
        }

        public Object getParamObj() {
            return this.paramObj;
        }

        public void setClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        public void setClassName(String str) {
            this.className = str;
        }

        public void setParamObj(Object obj) {
            this.paramObj = obj;
        }

        public WVPluginInfo(String str, ClassLoader classLoader) {
            this.className = str;
            this.classLoader = classLoader;
        }
    }

    public static String getPluginInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, WVPluginInfo> entry : plugins.entrySet()) {
            sb.append(entry.getKey());
            sb.append(c49.f40900a);
            sb.append(entry.getValue().className);
            sb.append(",");
        }
        return sb.toString();
    }

    private static void registerPlugin(String str, Class<? extends WVApiPlugin> cls, boolean z, Map<String, WVPluginInfo> map) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        map.put(str, new WVPluginInfo(cls.getName(), z ? cls.getClassLoader() : null));
        j jVar = (j) m.a().b(j.class);
        if (jVar == null || jVar.g() == null) {
            return;
        }
        jVar.g().c("HY_REGISTERPLUGIN", "HY_REGISTERPLUGIN", str + SEPARATOR + cls.getName(), "");
    }

    public static void registerPlugin(String str, Class<? extends WVApiPlugin> cls, boolean z) {
        registerPlugin(str, cls, z, plugins);
    }

    @Deprecated
    public static void registerPlugin(String str, String str2) {
        registerPlugin(str, str2, (ClassLoader) null);
    }

    public static void registerPlugin(String str, Object obj) {
        try {
            if (obj instanceof WVApiPlugin) {
                objPlugins.put(str, (WVApiPlugin) obj);
            }
        } catch (Throwable th) {
            if (TaoLog.getLogStatus()) {
                TaoLog.e(TAG, "registerPlugin by Object error : " + th.getMessage());
            }
        }
    }

    @Deprecated
    public static void registerPlugin(String str, String str2, ClassLoader classLoader) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        plugins.put(str, new WVPluginInfo(str2, classLoader));
        if (monitorService == null) {
            monitorService = (j) m.a().b(j.class);
        }
        j jVar = monitorService;
        if (jVar == null || jVar.g() == null) {
            return;
        }
        monitorService.g().c("HY_REGISTERPLUGIN", "HY_REGISTERPLUGIN", str + SEPARATOR + str2, "");
    }

    public static void registerPlugin(String str, String str2, ClassLoader classLoader, Object... objArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        WVPluginInfo wVPluginInfo = new WVPluginInfo(str2, classLoader);
        wVPluginInfo.setParamObj(objArr);
        plugins.put(str, wVPluginInfo);
        if (monitorService == null) {
            monitorService = (j) m.a().b(j.class);
        }
        j jVar = monitorService;
        if (jVar == null || jVar.g() == null) {
            return;
        }
        monitorService.g().c("HY_REGISTERPLUGIN", "HY_REGISTERPLUGIN", str + SEPARATOR + str2, "");
    }
}
