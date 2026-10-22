package com.alibaba.triver.appinfo.core;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AcceleratorConfig implements Serializable {
    public List<ConfigItem> important;
    public long maxSyncTime = 86400000;
    public long maxAsyncTime = 3600000;

    public static class ConfigItem implements Serializable {
        public String appId;
        public boolean expired = true;
        public String strategy;
        public long timeStamp;
    }

    public ConfigItem getImportantConfig(String str) {
        List<ConfigItem> list;
        if (TextUtils.isEmpty(str) || (list = this.important) == null) {
            return null;
        }
        for (ConfigItem configItem : list) {
            if (configItem != null && str.equals(configItem.appId)) {
                return configItem;
            }
        }
        return null;
    }

    public long getMaxAsyncTime() {
        return this.maxAsyncTime;
    }

    public long getMaxSyncTime() {
        return this.maxSyncTime;
    }
}
