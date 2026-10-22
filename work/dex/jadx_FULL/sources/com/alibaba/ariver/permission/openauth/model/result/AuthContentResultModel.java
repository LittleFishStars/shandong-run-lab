package com.alibaba.ariver.permission.openauth.model.result;

import androidx.annotation.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class AuthContentResultModel {
    private List<AuthAgreementModel> agreements;
    private String appLogoLink;
    private String appName;
    private List<String> authText;
    private String errorCode;
    private String errorMsg;
    private Map<String, String> extInfo;
    private Boolean isSuccess;
    private Boolean isvAgent;
    private String isvAgentDesc;

    public List<AuthAgreementModel> getAgreements() {
        return this.agreements;
    }

    public String getAppLogoLink() {
        return this.appLogoLink;
    }

    public String getAppName() {
        return this.appName;
    }

    public List<String> getAuthText() {
        return this.authText;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public Boolean getIsvAgent() {
        return this.isvAgent;
    }

    public String getIsvAgentDesc() {
        return this.isvAgentDesc;
    }

    public Boolean getSuccess() {
        return this.isSuccess;
    }

    public void setAgreements(List<AuthAgreementModel> list) {
        this.agreements = list;
    }

    public void setAppLogoLink(String str) {
        this.appLogoLink = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAuthText(List<String> list) {
        this.authText = list;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public void setIsvAgent(Boolean bool) {
        this.isvAgent = bool;
    }

    public void setIsvAgentDesc(String str) {
        this.isvAgentDesc = str;
    }

    public void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }
}
