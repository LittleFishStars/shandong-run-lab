package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SuiteDO implements Serializable {
    private static final long serialVersionUID = 5108584967714955214L;
    private String appId;
    private String baseUrl;
    private String code;
    private List<FuncDO> funcs;
    private String type;
    private String version;

    public String getAppId() {
        return this.appId;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getCode() {
        return this.code;
    }

    public List<FuncDO> getFuncs() {
        return this.funcs;
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

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setFuncs(List<FuncDO> list) {
        this.funcs = list;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
