package com.alibaba.ariver.permission.openauth.model.result;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class AuthSkipResultModel {
    private AuthContentResultModel authContentResult;
    private AuthExecuteResultModel authExecuteResult;
    private Boolean canSkipAuth;
    private byte[] data;
    private String errorCode;
    private String errorMsg;
    private H5AuthParamsModel h5AuthParams;
    private Boolean isSuccess;
    private String showType;

    public AuthContentResultModel getAuthContentResult() {
        return this.authContentResult;
    }

    public AuthExecuteResultModel getAuthExecuteResult() {
        return this.authExecuteResult;
    }

    public Boolean getCanSkipAuth() {
        return this.canSkipAuth;
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

    public H5AuthParamsModel getH5AuthParams() {
        return this.h5AuthParams;
    }

    public String getShowType() {
        return this.showType;
    }

    public Boolean getSuccess() {
        return this.isSuccess;
    }

    public void setAuthContentResult(AuthContentResultModel authContentResultModel) {
        this.authContentResult = authContentResultModel;
    }

    public void setAuthExecuteResult(AuthExecuteResultModel authExecuteResultModel) {
        this.authExecuteResult = authExecuteResultModel;
    }

    public void setCanSkipAuth(Boolean bool) {
        this.canSkipAuth = bool;
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

    public void setH5AuthParams(H5AuthParamsModel h5AuthParamsModel) {
        this.h5AuthParams = h5AuthParamsModel;
    }

    public void setShowType(String str) {
        this.showType = str;
    }

    public void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }
}
