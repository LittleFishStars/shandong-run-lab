package com.alibaba.ariver.app.api.mtop;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SendMtopParams implements Serializable {
    private static final long serialVersionUID = -33061885727159462L;
    public String accountSite;
    public String api;
    public Boolean forceLogin;
    public boolean ignoreAuth;
    public String method;
    public String mpHost;
    public boolean needAuth;
    public boolean needLogin;
    public String pageUrl;
    public boolean post;
    public String sessionOption;
    private String sourceAppId;
    private Bundle startParams;
    public long timer;
    public String ttid;
    public String userAgent;
    public String v;
    public String dataType = "originaljson";
    public int wuaFlag = -1;
    private Map<String, String> dataMap = new HashMap();
    private Map<String, String> parameterMap = new HashMap();
    private Map<String, String> headers = new HashMap();
    private Map<String, String> extraData = new HashMap();

    public SendMtopParams(String str, Bundle bundle) {
        this.sourceAppId = str;
        this.startParams = bundle;
    }

    public void addData(String str, String str2) {
        this.dataMap.put(str, str2);
    }

    public void addExtraDara(String str, String str2) {
        Map<String, String> map = this.extraData;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void addParameterMap(String str, String str2) {
        this.parameterMap.put(str, str2);
    }

    public String getAppId() {
        return this.sourceAppId;
    }

    public Map<String, String> getDataMap() {
        return this.dataMap;
    }

    public Map<String, String> getExtraDataMap() {
        return this.extraData;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, String> getParameterMap() {
        return this.parameterMap;
    }

    public Bundle getStartParams() {
        return this.startParams;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers.putAll(map);
    }
}
