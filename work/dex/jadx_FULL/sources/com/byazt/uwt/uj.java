package com.byazt.uwt;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.m.y.l;
import com.byazt.bog.a;
import com.byazt.uk.sl;
import com.byazt.uq.i;
import com.byazt.uq.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.zj.adlib.u15;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 15})
public class uj {
    public static final sl c = sl.c();

    private boolean tt(String str, Plugin plugin, StringBuilder sb) {
        if (i.sp() || i.rh()) {
            sb.append("removeEntry skip 1;");
            return false;
        }
        if (!((u.c().x(plugin.mPkgName, plugin.getVersion()) & 1) != 0)) {
            sb.append("removeEntry skip 2;");
            return false;
        }
        boolean zTt = com.byazt.th.uj.tt(Zeus.getAppApplication());
        boolean zA = u.c().a(plugin.mPkgName, plugin.getVersion());
        if (!zTt || !zA) {
            sb.append("removeEntry skip 4 ");
            sb.append(zTt);
            sb.append(" ");
            sb.append(zA);
            sb.append(l.b);
            return false;
        }
        if (u.c().sp(plugin.mPkgName, plugin.getVersion())) {
            sb.append("removeEntry skip 3;");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zC = com.byazt.mx.tt.c(str, true, false, plugin.mPkgName, plugin.getVersion(), 2);
        sb.append("removeEntry cost:");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb.append(l.b);
        u.c().ve(plugin.mPkgName, plugin.getVersion(), true);
        return zC;
    }

    public boolean c(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        if (!plugin.isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
            return false;
        }
        if (plugin.isLoading()) {
            return false;
        }
        if (plugin.isLoaded()) {
            return true;
        }
        synchronized (plugin) {
            if (plugin.isLoaded()) {
                return true;
            }
            plugin.setLifeCycle(4);
            sl slVar = c;
            slVar.c(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.byazt.blh.tt ttVarC = com.byazt.blh.tt.c(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            c(com.byazt.gvs.tt.x, com.byazt.gvs.tt.c.d, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean zC = plugin.isIsDexPlugin() ? com.byazt.cda.tt.c(plugin, sb) : c(str, plugin, sb);
            if ((plugin instanceof c) && plugin.isIsDexPlugin()) {
                ((c) plugin).c();
            }
            ttVarC.c("loadPluginInternal:".concat(String.valueOf(zC)));
            if (zC) {
                plugin.setLifeCycle(3);
                c(com.byazt.gvs.tt.i, com.byazt.gvs.tt.c.eo, plugin.mPkgName, plugin.getVersion(), ttVarC.c(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                slVar.c(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                plugin.setLifeCycle(2);
                sb.append("plugin:");
                sb.append(plugin.mPkgName);
                sb.append(" versionCode:");
                sb.append(plugin.getVersion());
                sb.append("load failed;");
                c(com.byazt.gvs.tt.i, com.byazt.gvs.tt.c.zb, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                slVar.c(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }

    private boolean c(final String str, final Plugin plugin, final StringBuilder sb) {
        boolean zTt;
        final PackageInfo[] packageInfoArr;
        try {
            if (plugin == null) {
                sb.append("loadPluginInternal, plugin == null;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadPluginInternal, !plugin.isInstalled();");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!");
                return false;
            }
            final String strTt = com.byazt.th.ve.tt(plugin.mPkgName, plugin.getVersion());
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoaderfind Apk: sourceApk:" + strTt + " ; pkgName:" + plugin.mPkgName + " ; " + plugin.getVersion());
            if (!new File(strTt).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!");
                return false;
            }
            zTt = tt(strTt, plugin, sb);
            try {
                final File file = new File(com.byazt.th.ve.uj(plugin.mPkgName, plugin.getVersion()));
                final File fileC = c(plugin.mPkgName, plugin.getVersion(), strTt);
                boolean z = true;
                PackageInfo[] packageInfoArr2 = new PackageInfo[1];
                if (i.rh()) {
                    packageInfoArr = packageInfoArr2;
                    z = true;
                    com.byazt.ao.c.c(true, new com.byazt.ao.c.InterfaceC0347c() { // from class: com.byazt.uwt.uj.1
                        @Override // com.byazt.ao.c.InterfaceC0347c
                        public void c() throws Exception {
                            uj.this.c(plugin, strTt, file, fileC, sb);
                        }
                    }, new com.byazt.ao.c.InterfaceC0347c() { // from class: com.byazt.uwt.uj.2
                        @Override // com.byazt.ao.c.InterfaceC0347c
                        public void c() throws Throwable {
                            packageInfoArr[0] = uj.this.c(str, plugin, sb, strTt, file);
                        }
                    });
                } else {
                    packageInfoArr = packageInfoArr2;
                    c(plugin, strTt, file, fileC, sb);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader before makeResources");
                    packageInfoArr[0] = c(str, plugin, sb, strTt, file);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader after makeResources");
                }
                c(plugin, sb, packageInfoArr[0]);
                return z;
            } catch (Throwable th) {
                th = th;
                String stackTraceString = Log.getStackTraceString(th);
                GlobalParam.getInstance().getReporter().c("zeus_stage_error", "loadPluginInternal stack:".concat(String.valueOf(stackTraceString)));
                GlobalParam.getInstance().getReporter().c("zeus_stage_error", "loadLog:" + sb.toString());
                sb.append("loadPluginInternal ");
                sb.append(th.getMessage());
                sb.append(l.b);
                sb.append(stackTraceString);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", th);
                if (zTt) {
                    u.c().c(str, plugin.getVersion(), TrackLoadSettingsAtom.TYPE);
                    if (u.c().tt(str, plugin.getVersion(), TrackLoadSettingsAtom.TYPE) > 3) {
                        Zeus.unInstallPlugin(str);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            zTt = false;
        }
    }

    private void c(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (!TextUtils.isEmpty(activityInfo.processName) && activityInfo.processName.contains(u15.f19942b)) {
                    activityInfo.processName = activityInfo.processName.split(u15.f19942b)[1];
                } else {
                    activityInfo.processName = "main";
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.processName) && serviceInfo.processName.contains(u15.f19942b)) {
                    serviceInfo.processName = serviceInfo.processName.split(u15.f19942b)[1];
                } else {
                    serviceInfo.processName = "main";
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                if (!TextUtils.isEmpty(activityInfo2.processName) && activityInfo2.processName.contains(u15.f19942b)) {
                    activityInfo2.processName = activityInfo2.processName.split(u15.f19942b)[1];
                } else {
                    activityInfo2.processName = "main";
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(u15.f19942b)) {
                    providerInfo.processName = providerInfo.processName.split(u15.f19942b)[1];
                } else {
                    providerInfo.processName = "main";
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap<String, ProviderInfo> map = plugin.pluginProvider;
        if (map != null && map.size() > 0) {
            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb.append(l.b);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication = zeusApplication;
            zeusApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis2);
        sb.append(l.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo c(String str, final Plugin plugin, StringBuilder sb, String str2, File file) throws PackageManager.NameNotFoundException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, 143);
        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
        ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField = applicationInfo;
        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.byazt.uwt.uj.3
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
        sb.append("makeResources cost:");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb.append(l.b);
        return packageArchiveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Plugin plugin, String str, File file, File file2, StringBuilder sb) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        c(plugin, str, file, file2);
        sb.append("classLoader cost:");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb.append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.byazt.th.n.c(new Runnable() { // from class: com.byazt.uwt.uj.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PluginClassLoader pluginClassLoader = plugin.mClassLoader;
                        pluginClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(pluginClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                c(plugin, str2);
            }
        } catch (ClassNotFoundException unused) {
        } finally {
            sb.append("actStubV1 cost:");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis2);
            sb.append(l.b);
        }
    }

    private void c(Plugin plugin, String str, File file, File file2) throws Exception {
        if (c()) {
            plugin.mClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            synchronized (plugin.getInitializeLock()) {
                c(plugin.mClassLoader, str);
            }
            return;
        }
        plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
    }

    private File c(String str, int i, String str2) {
        File file = new File(com.byazt.th.ve.ve(str, i));
        if (i.a()) {
            if (!com.byazt.xe.tt.c(file + File.separator + com.byazt.xe.tt.c(str2))) {
                file = null;
            }
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void c(Plugin plugin, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject2.getString(next));
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("forceMappings");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                int iOptInt = jSONObject2.optInt("minApi", 0);
                int iOptInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= iOptInt2 && apiVersionCode >= iOptInt && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        map.put(next2, jSONObjectOptJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            String str4 = plugin.mPkgName;
            StringBuilder sb = new StringBuilder();
            sb.append((str3 == null || !str3.contains(Consts.DOT)) ? plugin.mPkgName + Consts.DOT : "");
            sb.append((String) map.get(str2));
            ComponentManager.registerActivity(str4, sb.toString(), str2);
        }
    }

    public static void c(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.blh.ve.c(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.blh.ve.c(str2));
            jSONObject.putOpt("version_code", com.byazt.blh.ve.c(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.byazt.blh.ve.tt(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.blh.ve.c(str3));
        } catch (JSONException e) {
            a.c(e);
        }
        com.byazt.gvs.tt.c().c(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static boolean c() {
        return i.rh();
    }

    public static boolean c(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                a.c(th);
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return false;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        return true;
    }

    public static PluginClassLoader c(Plugin plugin, String str, StringBuilder sb) {
        try {
            File file = new File(com.byazt.th.ve.ve(str, plugin.getVersion()));
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("makeDexPluginClassLoader dalvikCacheDir: " + file.getAbsolutePath());
            long jCurrentTimeMillis = System.currentTimeMillis();
            plugin.mClassLoader = new PluginClassLoader("", file, "", null);
            sb.append("makeDexPluginClassLoader cost:");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb.append(" ;");
            return plugin.mClassLoader;
        } catch (Throwable th) {
            sb.append("makeDexPluginClassLoader fail:  " + th.getMessage());
            return null;
        }
    }
}
