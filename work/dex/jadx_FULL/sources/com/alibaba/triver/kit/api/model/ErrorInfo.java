package com.alibaba.triver.kit.api.model;

import com.alipay.sdk.m.c0.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ErrorInfo {
    public buttonActionType buttonAction;
    public String buttonText;
    public String buttonType;
    public String buttonUrl;
    public String errorCode;
    public String errorLogo;
    public String errorMsg;
    public String errorTitle;
    public String guideTip;
    public String guideTipUrl;
    public String subTitle;

    public enum buttonActionType {
        refresh(d.x),
        back("back"),
        update("update");

        String mAction;

        buttonActionType(String str) {
            this.mAction = str;
        }

        public String getAction() {
            return this.mAction;
        }
    }

    public ErrorInfo() {
    }

    public ErrorInfo(String str, String str2, String str3, String str4, String str5) {
        this.errorTitle = str;
        this.subTitle = str2;
        this.errorCode = str3;
        this.errorMsg = str4;
        this.errorLogo = str5;
    }
}
