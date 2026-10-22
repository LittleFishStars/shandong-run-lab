package com.alibaba.alibcprotocol.route.model;

import androidx.core.util.ObjectsCompat;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PluginDO implements Serializable {
    private static final long serialVersionUID = -163253913193111196L;
    private String appId;
    private String version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ObjectsCompat.equals(this.appId, ((PluginDO) obj).appId);
    }

    public String getAppId() {
        return this.appId;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.appId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
