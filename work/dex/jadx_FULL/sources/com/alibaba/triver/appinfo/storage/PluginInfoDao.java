package com.alibaba.triver.appinfo.storage;

import com.alibaba.ariver.resource.api.models.PluginModel;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PluginInfoDao implements Serializable {
    public String extra;
    public long id;
    public long lastRequestTimeStamp;
    public long lastUsedTimeStamp;
    public String pluginId;
    public PluginModel pluginInfo;
    public String type;
    public String version;
}
