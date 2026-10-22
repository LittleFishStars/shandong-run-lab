package com.alibaba.ariver.permission.openauth.model.request;

import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class JsApiInvokeRequestModel {
    private String appId;
    private String bizContent;
    private Map<String, String> extParams;
    private String method;

    public String getAppId() {
        return this.appId;
    }

    public String getBizContent() {
        return this.bizContent;
    }

    public Map<String, String> getExtParams() {
        return this.extParams;
    }

    public String getMethod() {
        return this.method;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBizContent(String str) {
        this.bizContent = str;
    }

    public void setExtParams(Map<String, String> map) {
        this.extParams = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }
}
