package com.alibaba.triver.appinfo.storage;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24646a = "PluginInfoCenter";
    private static LruCache<String, PluginInfoDao> b = new LruCache<>(10);
    private static Map<String, Set<String>> c = new HashMap();
    private static d d;

    private d() {
    }

    public static synchronized d a() {
        if (d == null) {
            d = new d();
        }
        return d;
    }

    @WorkerThread
    public synchronized void b(String str, String str2) {
        b.remove(str);
        try {
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                triverDBProxy.execSQL("DELETE FROM cached_plugin_info WHERE pluginId='" + str + "' AND version='" + str2 + "'");
            }
        } catch (Exception e) {
            RVLogger.e(f24646a, "deleteByIdAndVersion error", e);
        }
    }

    @WorkerThread
    public synchronized boolean c(String str, String str2) {
        Set<String> set = c.get(str);
        if (set != null && set.contains(str2)) {
            return true;
        }
        TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
        if (triverDBProxy.isReady()) {
            Set<String> setQueryPluginSubscriptionSQL = triverDBProxy.queryPluginSubscriptionSQL("SELECT * FROM cached_plugin_subscription WHERE pluginId='" + str + "'");
            if (setQueryPluginSubscriptionSQL != null && !setQueryPluginSubscriptionSQL.isEmpty()) {
                c.put(str, setQueryPluginSubscriptionSQL);
                return setQueryPluginSubscriptionSQL.contains(str2);
            }
        }
        return false;
    }

    @WorkerThread
    public synchronized boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Set<String> set = c.get(str);
        if (set != null) {
            if (TextUtils.isEmpty(str2)) {
                c.remove(str);
            } else {
                set.remove(str2);
            }
        }
        if (!((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).isReady()) {
            return false;
        }
        String str3 = "DELETE FROM cached_plugin_subscription WHERE pluginId='" + str + "'";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + " And appId='" + str2 + "'";
        }
        return ((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).execSQL(str3);
    }

    @WorkerThread
    public synchronized void e(String str, String str2) {
        Set<String> hashSet = c.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(str2);
        c.put(str, hashSet);
        if (((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).isReady()) {
            ((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).execSQL("REPLACE INTO cached_plugin_subscription(pluginId, appId, lastRequestTimeStamp, extra) VALUES('" + str + "', '" + str2 + "'," + System.currentTimeMillis() + ",'')");
        }
    }

    @WorkerThread
    public synchronized PluginInfoDao a(String str, String str2) {
        try {
            boolean z = (TextUtils.isEmpty(str2) || "*".equals(str2)) ? false : true;
            PluginInfoDao pluginInfoDao = b.get(str);
            if (pluginInfoDao != null && (!z || str2.equals(pluginInfoDao.version))) {
                RVLogger.d(f24646a, str + " hit RAMCache");
                return pluginInfoDao;
            }
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                List<PluginInfoDao> listQueryPluginSQL = triverDBProxy.queryPluginSQL(z ? "SELECT * FROM cached_plugin_info WHERE pluginId='" + str + "' AND version='" + str2 + "' ORDER BY id DESC" : "SELECT * FROM cached_plugin_info WHERE pluginId='" + str + "' ORDER BY id DESC");
                if (listQueryPluginSQL != null) {
                    if (listQueryPluginSQL.size() == 1) {
                        pluginInfoDao = listQueryPluginSQL.get(0);
                    } else {
                        pluginInfoDao = null;
                        for (PluginInfoDao pluginInfoDao2 : listQueryPluginSQL) {
                            if (pluginInfoDao == null || RVResourceUtils.compareVersion(pluginInfoDao2.version, pluginInfoDao.version) > 0) {
                                pluginInfoDao = pluginInfoDao2;
                            }
                        }
                    }
                }
                if (pluginInfoDao != null) {
                    b.put(str, pluginInfoDao);
                    if (z && !str2.equals(pluginInfoDao.version)) {
                        RVLogger.d(f24646a, str + " don't hit DBCache, version is different!");
                        return null;
                    }
                    RVLogger.d(f24646a, str + " hit DBCache");
                    return pluginInfoDao;
                }
            }
            return null;
        } catch (Exception e) {
            RVLogger.e(f24646a, "selectInfoById error", e);
        }
    }

    @WorkerThread
    public synchronized void b() {
        try {
            LruCache<String, PluginInfoDao> lruCache = b;
            if (lruCache != null) {
                lruCache.evictAll();
            }
            Map<String, Set<String>> map = c;
            if (map != null) {
                map.clear();
            }
            try {
                TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
                if (triverDBProxy.isReady()) {
                    triverDBProxy.execSQL("DELETE FROM cached_plugin_info");
                    triverDBProxy.execSQL("DELETE FROM cached_plugin_subscription");
                }
            } catch (Exception e) {
                RVLogger.e(f24646a, "deleteById error", e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b(PluginInfoDao pluginInfoDao) {
        if (b.get(pluginInfoDao.pluginId) != null) {
            b.put(pluginInfoDao.pluginId, pluginInfoDao);
        }
        String str = "'" + JSON.toJSONString(pluginInfoDao.pluginInfo) + "'";
        String str2 = pluginInfoDao.version;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = pluginInfoDao.type;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = pluginInfoDao.extra;
        ((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).execSQL("REPLACE INTO cached_plugin_info(pluginId, lastUsedTimeStamp, lastRequestTimeStamp, version, pluginInfo, type, extra) VALUES('" + pluginInfoDao.pluginId + "', " + pluginInfoDao.lastUsedTimeStamp + ", " + pluginInfoDao.lastRequestTimeStamp + ", '" + str2 + "', " + str + ", '" + str3 + "', '" + (str4 != null ? str4 : "") + "')");
    }

    @WorkerThread
    public synchronized void a(String str) {
        b.remove(str);
        try {
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                triverDBProxy.execSQL("DELETE FROM cached_plugin_info WHERE pluginId='" + str + "'");
            }
        } catch (Exception e) {
            RVLogger.e(f24646a, "deleteById error", e);
        }
    }

    @WorkerThread
    public synchronized void a(PluginInfoDao pluginInfoDao) {
        try {
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                List<PluginInfoDao> listQueryPluginSQL = triverDBProxy.queryPluginSQL("SELECT * FROM cached_plugin_info WHERE pluginId='" + pluginInfoDao.pluginId + "'");
                if (listQueryPluginSQL.size() >= 3) {
                    PluginInfoDao pluginInfoDao2 = null;
                    for (PluginInfoDao pluginInfoDao3 : listQueryPluginSQL) {
                        if (pluginInfoDao2 == null || RVResourceUtils.compareVersion(pluginInfoDao2.version, pluginInfoDao3.version) > 0) {
                            pluginInfoDao2 = pluginInfoDao3;
                        }
                    }
                }
                b(pluginInfoDao);
            }
        } catch (Exception e) {
            RVLogger.e(f24646a, "insertOrUpdateInfo error", e);
        }
    }

    @WorkerThread
    public synchronized void a(long j, List<String> list) {
        try {
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                StringBuilder sb = new StringBuilder();
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append("'");
                        sb.append(it.next());
                        sb.append("'");
                        if (it.hasNext()) {
                            sb.append(",");
                        }
                    }
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                triverDBProxy.execSQL("DELETE FROM cached_plugin_info WHERE lastRequestTimeStamp < " + jCurrentTimeMillis + " AND pluginId NOT IN (" + sb.toString() + ")");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DELETE FROM cached_plugin_subscription WHERE lastRequestTimeStamp < ");
                sb2.append(jCurrentTimeMillis);
                triverDBProxy.execSQL(sb2.toString());
            }
        } catch (Exception e) {
            RVLogger.e(f24646a, "clearUnusedExcept error", e);
        }
    }
}
