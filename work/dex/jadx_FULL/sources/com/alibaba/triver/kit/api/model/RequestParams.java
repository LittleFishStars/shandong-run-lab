package com.alibaba.triver.kit.api.model;

import android.os.Bundle;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class RequestParams implements Serializable {
    public String api;
    private String appId;
    public Map<String, String> headers;
    public List<String> ignoreParams;
    public boolean needLogin = false;
    private Bundle startParams;
    public String version;

    public RequestParams(String str, Bundle bundle) {
        this.appId = str;
        this.startParams = bundle;
    }

    public String getAppId() {
        return this.appId;
    }

    public Bundle getStartParams() {
        return this.startParams;
    }

    public abstract Map<String, Object> toMap();
}
