package com.alibaba.ariver.permission.openauth.model.result;

import androidx.annotation.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class AuthExecuteResultModel {
    private String appId;
    private String authCode;
    private byte[] data;
    private String errorCode;
    private String errorMsg;
    private Map<String, String> errorScopes;
    private Map<String, String> extInfo;
    private Boolean isSuccess;
    private String isvAppId;
    private String state;
    private List<String> successScopes;

    public String getAppId() {
        return this.appId;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Map<String, String> getErrorScopes() {
        return this.errorScopes;
    }

    public Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public String getIsvAppId() {
        return this.isvAppId;
    }

    public String getState() {
        return this.state;
    }

    public Boolean getSuccess() {
        return this.isSuccess;
    }

    public List<String> getSuccessScopes() {
        return this.successScopes;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setErrorScopes(Map<String, String> map) {
        this.errorScopes = map;
    }

    public void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public void setIsvAppId(String str) {
        this.isvAppId = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }

    public void setSuccessScopes(List<String> list) {
        this.successScopes = list;
    }
}
