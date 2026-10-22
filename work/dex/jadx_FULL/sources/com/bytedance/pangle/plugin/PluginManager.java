package com.bytedance.pangle.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.byazt.th.n;
import com.byazt.th.ve;
import com.byazt.uk.i;
import com.byazt.uk.sl;
import com.byazt.uq.u;
import com.byazt.uwt.c;
import com.byazt.uwt.tt;
import com.byazt.uwt.uj;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class PluginManager {
    public static final String TAG = "PluginManager";
    public static volatile PluginManager sInstance;
    public volatile boolean hasInstallFromDownloadDir;
    public volatile boolean mIsParsePluginConfig;
    public volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    public final uj pluginLoader = new uj();

    private PluginManager() {
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(ve.tt(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager();
                }
            }
        }
        return sInstance;
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        ArrayList arrayList = new ArrayList();
        try {
            try {
                Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
                if (bundle != null) {
                    for (String str : bundle.keySet()) {
                        String str2 = i.n;
                        if (str2.startsWith("PANGLE_")) {
                            if (str.startsWith(str2) || str.startsWith("ZEUS_PLUGIN_")) {
                                arrayList.add(bundle.getString(str));
                            }
                        } else if (str.startsWith(str2)) {
                            arrayList.add(bundle.getString(str));
                        }
                    }
                }
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Plugin plugins = parsePlugins((String) it.next());
                    if (plugins != null) {
                        concurrentHashMap.put(plugins.mPkgName, plugins);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugins.mPkgName);
                    }
                }
                Map<String, JSONObject> mapN = sl.c().n();
                if (mapN != null && mapN.size() > 0) {
                    for (Map.Entry<String, JSONObject> entry : mapN.entrySet()) {
                        String key = entry.getKey();
                        JSONObject value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null) {
                            Plugin plugins2 = parsePlugins(value);
                            concurrentHashMap.put(plugins2.mPkgName, plugins2);
                            ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager getPluginsJson. find " + plugins2.mPkgName);
                        }
                    }
                }
                this.mPlugins.putAll(concurrentHashMap);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
                this.mIsParsePluginConfig = true;
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e);
                this.mIsParsePluginConfig = true;
            }
        } catch (Throwable th) {
            this.mIsParsePluginConfig = true;
            throw th;
        }
    }

    private Plugin parsePlugins(String str) {
        if (str == null) {
            return null;
        }
        try {
            return parsePlugins(new JSONObject(str));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str.trim(), e);
            return null;
        }
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            n.tt(new tt(str, file));
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
        } else {
            ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    public Plugin getPlugin(String str, boolean z) {
        if (!Zeus.hasInit() && com.byazt.uq.tt.c()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public Plugin getPluginOnly(String str) {
        return this.mPlugins.get(str);
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.byazt.th.uj.tt(Zeus.getAppApplication())) {
            n.tt(new com.byazt.uwt.n());
        }
        this.hasInstallFromDownloadDir = true;
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public boolean loadPlugin(String str) {
        GlobalParam.getInstance().getReporter().c("zeus_stage_common", "start load plugin:".concat(String.valueOf(str)));
        return this.pluginLoader.c(str);
    }

    public void registerPlugin(String str) {
        Plugin plugins;
        if (str == null || (plugins = parsePlugins(str)) == null) {
            return;
        }
        this.mPlugins.put(plugins.mPkgName, plugins);
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new tt(str, file).c();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            u.c().sp(str);
        }
    }

    private Plugin parsePlugins(JSONObject jSONObject) throws JSONException {
        Plugin plugin;
        if (jSONObject.has("isDexPlugin") && jSONObject.optInt("isDexPlugin") == 1) {
            plugin = new c(jSONObject);
        } else {
            plugin = new Plugin(jSONObject);
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugin.mPkgName);
        return plugin;
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }
}
