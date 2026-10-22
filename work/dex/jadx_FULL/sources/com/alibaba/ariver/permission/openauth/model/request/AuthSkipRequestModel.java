package com.alibaba.ariver.permission.openauth.model.request;

import androidx.annotation.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class AuthSkipRequestModel {
    private Map<String, String> appExtInfo;
    private String appId;
    private AuthRequestContextModel authRequestContext;
    private String currentPageUrl;
    private Map<String, String> extInfo;
    private String fromSystem;
    private String isvAppId;
    private List<String> scopeNicks;
    private String state;

    public AuthSkipRequestModel(AuthSkipRequestModel authSkipRequestModel) {
        if (authSkipRequestModel == null) {
            return;
        }
        this.fromSystem = authSkipRequestModel.fromSystem;
        this.authRequestContext = authSkipRequestModel.authRequestContext;
        this.appId = authSkipRequestModel.appId;
        this.scopeNicks = authSkipRequestModel.scopeNicks;
        this.state = authSkipRequestModel.state;
        this.currentPageUrl = authSkipRequestModel.currentPageUrl;
        this.isvAppId = authSkipRequestModel.isvAppId;
        this.extInfo = authSkipRequestModel.extInfo;
        this.appExtInfo = authSkipRequestModel.appExtInfo;
    }

    public Map<String, String> getAppExtInfo() {
        return this.appExtInfo;
    }

    public String getAppId() {
        return this.appId;
    }

    public AuthRequestContextModel getAuthRequestContext() {
        return this.authRequestContext;
    }

    public String getCurrentPageUrl() {
        return this.currentPageUrl;
    }

    public Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public String getFromSystem() {
        return this.fromSystem;
    }

    public String getIsvAppId() {
        return this.isvAppId;
    }

    public List<String> getScopeNicks() {
        return this.scopeNicks;
    }

    public String getState() {
        return this.state;
    }

    public void setAppExtInfo(Map<String, String> map) {
        this.appExtInfo = map;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAuthRequestContext(AuthRequestContextModel authRequestContextModel) {
        this.authRequestContext = authRequestContextModel;
    }

    public void setCurrentPageUrl(String str) {
        this.currentPageUrl = str;
    }

    public void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public void setFromSystem(String str) {
        this.fromSystem = str;
    }

    public void setIsvAppId(String str) {
        this.isvAppId = str;
    }

    public void setScopeNicks(List<String> list) {
        this.scopeNicks = list;
    }

    public void setState(String str) {
        this.state = str;
    }

    public AuthSkipRequestModel() {
    }
}
