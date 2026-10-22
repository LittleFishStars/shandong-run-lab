package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Keep;
import com.byazt.bdw.c;
import com.byazt.th.uj;
import com.byazt.uk.sl;
import com.byazt.uk.t;
import com.byazt.uk.tt;
import com.byazt.uk.u;
import com.byazt.uk.ve;
import com.byazt.uk.yp;
import com.byazt.xe.n;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class Zeus {
    public static Application sApplication;
    public static volatile Function sMainService;
    public static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    public static final Object wait = new Object();

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        Resources resources;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || (resources = plugin.mResources) == null) {
            return;
        }
        new c().c(resources.getAssets(), str2, false);
    }

    public static void addPackageDexManager(String str, JSONObject jSONObject) {
        Map<String, JSONObject> mapN = sl.c().n();
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        mapN.put(str, jSONObject);
    }

    public static void addPluginEventCallback(u uVar) {
        sl.c().c(uVar);
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            tt.c();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.byazt.th.c.c(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return com.byazt.th.tt.c();
    }

    public static int getHostAbiBit() {
        return com.byazt.th.tt.tt();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static Function getMainService() {
        return sMainService;
    }

    public static int getMaxInstallVer(String str) {
        if (uj.tt(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static boolean hasInit() {
        return sl.c().tt();
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.byazt.mq.c.c(application);
    }

    public static void init(Application application) {
        GlobalParam.getInstance().getReporter().c("zeus_stage_common", "start init");
        sl.c().c(application);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.byazt.p001if.c.tt().ve();
    }

    public static void installFromDownloadDir() {
        if (uj.tt(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static void registerPluginInstallListener(yp ypVar) {
        try {
            ve veVarC = com.byazt.quv.tt.c();
            if (veVarC != null) {
                veVarC.c(ypVar.hashCode(), new com.byazt.er.tt(ypVar));
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e);
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        sl.c().c(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(u uVar) {
        sl.c().tt(uVar);
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static void setDecodeCallback(t tVar) {
        sl.c().c(tVar);
    }

    public static void setMainService(Function function) {
        if (sMainService != null || function == null) {
            return;
        }
        sMainService = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 0);
        function.apply(sparseArray);
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        GlobalParam.getInstance().getReporter().c("zeus_stage_plugin_install", "start");
        ve veVarC = com.byazt.quv.tt.c();
        if (veVarC == null) {
            return false;
        }
        try {
            return veVarC.c(str, str2);
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
            return false;
        }
    }

    public static void triggerBgDexOpt() {
        n.c();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        sl.c().tt(zeusPluginStateListener);
    }

    public static boolean waitInit(int i) {
        if (sl.c().tt()) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!sl.c().tt()) {
                try {
                    if (i == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return sl.c().tt();
    }

    public void unregisterPluginInstallListener(yp ypVar) {
        try {
            ve veVarC = com.byazt.quv.tt.c();
            if (veVarC != null) {
                veVarC.c(ypVar.hashCode());
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e);
        }
    }

    public static Plugin getPlugin(String str, boolean z) {
        return PluginManager.getInstance().getPlugin(str, z);
    }

    public static void unInstallPlugin(String str, int i) {
        Plugin plugin = getPlugin(str);
        if (plugin != null) {
            if (i > 0) {
                plugin.unInstall(i);
            } else {
                com.byazt.uq.u.c().sp(str);
            }
        }
    }

    public static boolean isPluginInstalled(String str, boolean z) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str, false);
        return plugin != null && plugin.isInstalled();
    }
}
