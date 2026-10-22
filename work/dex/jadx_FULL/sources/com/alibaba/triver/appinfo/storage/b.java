package com.alibaba.triver.appinfo.storage;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.triver.appinfo.core.AcceleratorConfig;
import com.alibaba.triver.kit.api.utils.SPUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24644a = "AppInfoCenter";
    private static LruCache<String, AppInfoDao> b = new LruCache<>(10);
    private static b d;
    private AcceleratorConfig c;

    private b() {
    }

    public static synchronized b a() {
        if (d == null) {
            d = new b();
        }
        return d;
    }

    @WorkerThread
    public synchronized Map<String, AppInfoDao> b() {
        try {
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                return triverDBProxy.querySQL("SELECT * FROM cached_app_info2");
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "selectAll error", e);
        }
        return null;
    }

    @WorkerThread
    public synchronized AcceleratorConfig c() {
        AcceleratorConfig acceleratorConfig = this.c;
        if (acceleratorConfig != null) {
            return acceleratorConfig;
        }
        try {
            String string = SPUtils.readString("accelerator_config", null);
            if (!TextUtils.isEmpty(string)) {
                return (AcceleratorConfig) JSON.parseObject(string, AcceleratorConfig.class);
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "getConfig errorr", e);
        }
        return null;
    }

    @WorkerThread
    public synchronized AppInfoDao a(String str, String str2) {
        String str3;
        try {
            boolean z = (TextUtils.isEmpty(str2) || "*".equals(str2)) ? false : true;
            AppInfoDao appInfoDao = b.get(str);
            if (appInfoDao != null && (!z || str2.equals(appInfoDao.version))) {
                if (!com.alibaba.triver.appinfo.a.a.b()) {
                    appInfoDao = (AppInfoDao) JSON.parseObject(JSON.toJSONString(appInfoDao), AppInfoDao.class);
                }
                return appInfoDao;
            }
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                if (z) {
                    str3 = "SELECT * FROM cached_app_info2 WHERE appId='" + str + "' AND version='" + str2 + "'";
                } else {
                    str3 = "SELECT * FROM cached_app_info2 WHERE appId='" + str + "'";
                }
                Map<String, AppInfoDao> mapQuerySQL = triverDBProxy.querySQL(str3);
                if (mapQuerySQL != null) {
                    appInfoDao = mapQuerySQL.get(str);
                }
                if (appInfoDao != null) {
                    b.put(str, appInfoDao);
                    if (z && !str2.equals(appInfoDao.version)) {
                        RVLogger.d("AppInfoCenter", str + " don't hit DBCache, version is different!");
                        return null;
                    }
                    return appInfoDao;
                }
            }
            return null;
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "selectInfoById error", e);
        }
    }

    @WorkerThread
    public synchronized void b(List<String> list) {
        try {
            LruCache<String, AppInfoDao> lruCache = b;
            if (lruCache != null) {
                lruCache.evictAll();
            }
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
                triverDBProxy.execSQL("DELETE FROM cached_app_info2 WHERE appId NOT IN (" + sb.toString() + ")");
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "clearUnusedExcept error", e);
        }
    }

    private void b(AppInfoDao appInfoDao) {
        if (b.get(appInfoDao.appId) != null) {
            b.put(appInfoDao.appId, appInfoDao);
        }
        ((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).insertOrUpdate(appInfoDao);
    }

    @WorkerThread
    public synchronized void a(Set<String> set) {
        try {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "deleteByIds error", e);
        }
    }

    @WorkerThread
    public synchronized void a(String str) {
        b.remove(str);
        try {
            TriverDBProxy triverDBProxy = (TriverDBProxy) RVProxy.get(TriverDBProxy.class);
            if (triverDBProxy.isReady()) {
                triverDBProxy.execSQL("DELETE FROM cached_app_info2 WHERE appId='" + str + "'");
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "deleteById error", e);
        }
    }

    @WorkerThread
    public synchronized void a(AppInfoDao appInfoDao) {
        try {
            if (((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).isReady()) {
                b(appInfoDao);
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "insertOrUpdateInfo error", e);
        }
    }

    @WorkerThread
    public synchronized void a(List<AppInfoDao> list) {
        try {
            if (((TriverDBProxy) RVProxy.get(TriverDBProxy.class)).isReady()) {
                Iterator<AppInfoDao> it = list.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "insertOrUpdateInfos error", e);
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
                triverDBProxy.execSQL("DELETE FROM cached_app_info2 WHERE lastRequestTimeStamp < " + (System.currentTimeMillis() - j) + " AND appId NOT IN (" + sb.toString() + ")");
            }
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "clearUnusedExcept error", e);
        }
    }

    @WorkerThread
    public synchronized void a(AcceleratorConfig acceleratorConfig) {
        this.c = acceleratorConfig;
        try {
            SPUtils.writeString("accelerator_config", JSON.toJSONString(acceleratorConfig));
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "saveConfig error", e);
        }
    }
}
