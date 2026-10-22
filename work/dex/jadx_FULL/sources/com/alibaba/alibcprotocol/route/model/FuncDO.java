package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FuncDO implements Serializable {
    private static final long serialVersionUID = -1529277667431407780L;
    private String appId;
    private String appType;
    private String baseUrl;
    private String code;
    private List<PluginDO> dynamicPlugins;
    private String type;
    private String version;

    public String getAppId() {
        return this.appId;
    }

    public String getAppType() {
        return this.appType;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getCode() {
        return this.code;
    }

    public List<PluginDO> getDynamicPlugins() {
        return this.dynamicPlugins;
    }

    public String getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDynamicPlugins(List<PluginDO> list) {
        this.dynamicPlugins = list;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
