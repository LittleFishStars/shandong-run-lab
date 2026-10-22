package com.alibaba.triver.appinfo.storage;

import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TriverDBProxy extends Proxiable {
    public static final String CREATE_APP_INFO_TABLE_SQL = "CREATE TABLE IF NOT EXISTS cached_app_info2(appId TEXT PRIMARY KEY,appInfo TEXT,lastUsedTimeStamp INTEGER,lastRequestTimeStamp INTEGER,version TEXT, type TEXT, extra TEXT)";
    public static final String CREATE_PLUGIN_INFO_TABLE_SQL = "CREATE TABLE IF NOT EXISTS cached_plugin_info(id INTEGER PRIMARY KEY AUTOINCREMENT,pluginId TEXT,pluginInfo TEXT,lastUsedTimeStamp INTEGER,lastRequestTimeStamp INTEGER,version TEXT, type TEXT, extra TEXT)";
    public static final String CREATE_PLUGIN_SUBSCRIPTION_TABLE_SQL = "CREATE TABLE IF NOT EXISTS cached_plugin_subscription(id INTEGER PRIMARY KEY AUTOINCREMENT,pluginId TEXT,appId TEXT,lastRequestTimeStamp INTEGER,extra TEXT)";
    public static final String DELETE_OLD_TABLE_SQL = "DROP TABLE IF EXISTS cached_app_info";

    boolean execSQL(String str);

    boolean insertOrUpdate(AppInfoDao appInfoDao);

    boolean isReady();

    List<PluginInfoDao> queryPluginSQL(String str);

    Set<String> queryPluginSubscriptionSQL(String str);

    Map<String, AppInfoDao> querySQL(String str);
}
