package com.alibaba.triver.kit.api.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SubscribeResouceItemModel implements Serializable {
    public static final String ACCEPT = "accept";
    public static final String REJECT = "reject";
    public static final String TIME_ONCE = "0";
    private String authCount;
    private String desc;
    private String effectiveTimes;
    private String name;
    private String resourceKey;
    private String sendCount;
    private String status;

    public String getAuthCount() {
        return this.authCount;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getEffectiveTimes() {
        return this.effectiveTimes;
    }

    public String getName() {
        return this.name;
    }

    public String getResourceKey() {
        return this.resourceKey;
    }

    public String getSendCount() {
        return this.sendCount;
    }

    public String getStatus() {
        return this.status;
    }

    public void setAuthCount(String str) {
        this.authCount = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setEffectiveTimes(String str) {
        this.effectiveTimes = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setResourceKey(String str) {
        this.resourceKey = str;
    }

    public void setSendCount(String str) {
        this.sendCount = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
