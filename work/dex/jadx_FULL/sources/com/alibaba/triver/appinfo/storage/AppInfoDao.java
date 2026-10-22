package com.alibaba.triver.appinfo.storage;

import com.alibaba.ariver.resource.api.models.AppModel;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppInfoDao implements Serializable {
    public String appId;
    public AppModel appInfo;
    public String extra;
    public long lastRequestTimeStamp;
    public long lastUsedTimeStamp;
    public String type;
    public String version;
}
