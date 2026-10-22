package com.alibaba.triver.inside.impl;

import android.database.Cursor;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.triver.appinfo.storage.AppInfoDao;
import com.alibaba.triver.appinfo.storage.PluginInfoDao;
import com.alibaba.triver.appinfo.storage.TriverDBProxy;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefDBProxy implements TriverDBProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24981a = "AriverTriver:AppInfoCenter";
    private com.alibaba.triver.appinfo.storage.a b = new com.alibaba.triver.appinfo.storage.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());

    @Override // com.alibaba.triver.appinfo.storage.TriverDBProxy
    public synchronized boolean execSQL(String str) {
        if (this.b.getWritableDatabase() != null) {
            try {
                try {
                    this.b.getWritableDatabase().execSQL(str);
                    this.b.close();
                    return true;
                } catch (Exception e) {
                    RVLogger.e("Triver:AppInfoCenter", "DefDBProxy execSQL error", e);
                    this.b.close();
                    return false;
                }
            } catch (Throwable th) {
                this.b.close();
                throw th;
            }
        }
        return false;
    }

    @Override // com.alibaba.triver.appinfo.storage.TriverDBProxy
    public synchronized boolean insertOrUpdate(AppInfoDao appInfoDao) {
        String jSONString;
        String str;
        String str2;
        String str3;
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        jSONString = JSON.toJSONString(appInfoDao.appInfo);
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            if (securityGuardManager != null && (dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp()) != null) {
                jSONString = dynamicDataEncryptComp.dynamicEncryptDDp(jSONString);
            }
        } catch (Exception e) {
            RVLogger.e("CacheUtils", "put security cache exception", e);
        }
        str = appInfoDao.version;
        if (str == null) {
            str = "";
        }
        str2 = appInfoDao.type;
        if (str2 == null) {
            str2 = "";
        }
        str3 = appInfoDao.extra;
        if (str3 == null) {
            str3 = "";
        }
        return execSQL("REPLACE INTO cached_app_info2(appId, lastUsedTimeStamp, lastRequestTimeStamp, version, appInfo, type, extra) VALUES('" + appInfoDao.appId + "', " + appInfoDao.lastUsedTimeStamp + ", " + appInfoDao.lastRequestTimeStamp + ", '" + str + "', '" + jSONString + "', '" + str2 + "', '" + str3 + "')");
    }

    @Override // com.alibaba.triver.appinfo.storage.TriverDBProxy
    public synchronized boolean isReady() {
        return this.b.getWritableDatabase() != null;
    }

    @Override // com.alibaba.triver.appinfo.storage.TriverDBProxy
    public synchronized List<PluginInfoDao> queryPluginSQL(String str) {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        if (this.b.getReadableDatabase() != null) {
            try {
                cursorRawQuery = this.b.getReadableDatabase().rawQuery(str, null);
                try {
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (cursorRawQuery.moveToNext()) {
                            PluginInfoDao pluginInfoDao = new PluginInfoDao();
                            cursorRawQuery.move(0);
                            pluginInfoDao.id = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("id"));
                            pluginInfoDao.pluginId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("pluginId"));
                            pluginInfoDao.lastUsedTimeStamp = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("lastUsedTimeStamp"));
                            pluginInfoDao.lastRequestTimeStamp = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("lastRequestTimeStamp"));
                            pluginInfoDao.version = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("version"));
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("pluginInfo"));
                            if (!TextUtils.isEmpty(string)) {
                                pluginInfoDao.pluginInfo = (PluginModel) JSON.parseObject(string, PluginModel.class);
                            }
                            pluginInfoDao.type = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("type"));
                            pluginInfoDao.extra = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("extra"));
                            arrayList.add(pluginInfoDao);
                        }
                        if (!cursorRawQuery.isClosed()) {
                            cursorRawQuery.close();
                        }
                        this.b.close();
                        return arrayList;
                    } catch (Exception e) {
                        e = e;
                        RVLogger.e(f24981a, "DefDBProxy querySQL error", e);
                        if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                            cursorRawQuery.close();
                        }
                        this.b.close();
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    this.b.close();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                this.b.close();
                throw th;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    @Override // com.alibaba.triver.appinfo.storage.TriverDBProxy
    public synchronized Set<String> queryPluginSubscriptionSQL(String str) {
        Cursor cursorRawQuery;
        ?? r1 = 0;
        try {
            if (this.b.getReadableDatabase() != null) {
                try {
                    cursorRawQuery = this.b.getReadableDatabase().rawQuery(str, null);
                    try {
                        HashSet hashSet = new HashSet();
                        while (cursorRawQuery.moveToNext()) {
                            cursorRawQuery.move(0);
                            hashSet.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("appId")));
                        }
                        if (!cursorRawQuery.isClosed()) {
                            cursorRawQuery.close();
                        }
                        this.b.close();
                        return hashSet;
                    } catch (Exception e) {
                        e = e;
                        RVLogger.e(f24981a, "DefDBProxy querySQL error", e);
                        if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                            cursorRawQuery.close();
                        }
                        this.b.close();
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursorRawQuery = null;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0 && !r1.isClosed()) {
                        r1.close();
                    }
                    this.b.close();
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r1 = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    @Override // com.alibaba.triver.appinfo.storage.TriverDBProxy
    public synchronized Map<String, AppInfoDao> querySQL(String str) {
        Cursor cursorRawQuery;
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        ?? r1 = 0;
        try {
            if (this.b.getReadableDatabase() != null) {
                try {
                    cursorRawQuery = this.b.getReadableDatabase().rawQuery(str, null);
                    try {
                        HashMap map = new HashMap();
                        while (cursorRawQuery.moveToNext()) {
                            AppInfoDao appInfoDao = new AppInfoDao();
                            cursorRawQuery.move(0);
                            appInfoDao.appId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("appId"));
                            appInfoDao.lastUsedTimeStamp = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("lastUsedTimeStamp"));
                            appInfoDao.lastRequestTimeStamp = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("lastRequestTimeStamp"));
                            appInfoDao.version = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("version"));
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("appInfo"));
                            if (!TextUtils.isEmpty(string)) {
                                try {
                                    SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                                    if (securityGuardManager != null && (dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp()) != null) {
                                        string = dynamicDataEncryptComp.dynamicDecryptDDp(string);
                                    }
                                } catch (Exception e) {
                                    RVLogger.e("CacheUtils", "put security cache exception", e);
                                }
                                appInfoDao.appInfo = (AppModel) JSON.parseObject(string, AppModel.class);
                            }
                            appInfoDao.type = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("type"));
                            appInfoDao.extra = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("extra"));
                            map.put(appInfoDao.appId, appInfoDao);
                        }
                        if (!cursorRawQuery.isClosed()) {
                            cursorRawQuery.close();
                        }
                        this.b.close();
                        return map;
                    } catch (Exception e2) {
                        e = e2;
                        RVLogger.e(f24981a, "DefDBProxy querySQL error", e);
                        if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                            cursorRawQuery.close();
                        }
                        this.b.close();
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursorRawQuery = null;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0 && !r1.isClosed()) {
                        r1.close();
                    }
                    this.b.close();
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r1 = str;
        }
    }
}
