package com.alibaba.triver.kit.api.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SubscribeDomainItemModel implements Serializable {
    private String accessToken;
    private String appLogo;
    private String appName;
    private String authPermission;
    private String authTitle;
    private String domainKey;
    private String domainName;
    private boolean keepSelection;
    private List<SubscribeResouceItemModel> resourceItems;
    private boolean showKeepSelection;
    private String status;
    private String tipLabel;
    private String validTime;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAppLogo() {
        return this.appLogo;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAuthPermission() {
        return this.authPermission;
    }

    public String getAuthTitle() {
        return this.authTitle;
    }

    public String getDomainKey() {
        return this.domainKey;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public List<SubscribeResouceItemModel> getResourceItems() {
        return this.resourceItems;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTipLabel() {
        return this.tipLabel;
    }

    public String getValidTime() {
        return this.validTime;
    }

    public boolean isKeepSelection() {
        return this.keepSelection;
    }

    public boolean isShowKeepSelection() {
        return this.showKeepSelection;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAppLogo(String str) {
        this.appLogo = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAuthPermission(String str) {
        this.authPermission = str;
    }

    public void setAuthTitle(String str) {
        this.authTitle = str;
    }

    public void setDomainKey(String str) {
        this.domainKey = str;
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    public void setKeepSelection(boolean z) {
        this.keepSelection = z;
    }

    public void setResourceItems(List<SubscribeResouceItemModel> list) {
        this.resourceItems = list;
    }

    public void setShowKeepSelection(boolean z) {
        this.showKeepSelection = z;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTipLabel(String str) {
        this.tipLabel = str;
    }

    public void setValidTime(String str) {
        this.validTime = str;
    }
}
