package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SuiteMiscDO implements Serializable {
    private String logEnable;
    private String logLevel;
    private String logUrl;
    private int maxHistroy;

    public String getLogEnable() {
        return this.logEnable;
    }

    public String getLogLevel() {
        return this.logLevel;
    }

    public String getLogUrl() {
        return this.logUrl;
    }

    public int getMaxHistroy() {
        return this.maxHistroy;
    }

    public void setLogEnable(String str) {
        this.logEnable = str;
    }

    public void setLogLevel(String str) {
        this.logLevel = str;
    }

    public void setLogUrl(String str) {
        this.logUrl = str;
    }

    public void setMaxHistroy(int i) {
        this.maxHistroy = i;
    }
}
