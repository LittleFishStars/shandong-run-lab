package com.kwad.components.offline.api.adInnerEc.login;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class InnerEcLoginResponse implements Serializable {
    private static final long serialVersionUID = 5382742918171282206L;
    protected String accessToken;
    protected String code;
    protected String command;
    protected int errorCode;
    protected String errorMsg;
    protected boolean hasLoggedIn;
    protected boolean newUser;
    protected String state;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getCode() {
        return this.code;
    }

    public String getCommand() {
        return this.command;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getState() {
        return this.state;
    }

    public boolean isHasLoggedIn() {
        return this.hasLoggedIn;
    }

    public boolean isNewUser() {
        return this.newUser;
    }

    public boolean isSuccess() {
        return 1 == getErrorCode();
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setHasLoggedIn(boolean z) {
        this.hasLoggedIn = z;
    }

    public void setNewUser(boolean z) {
        this.newUser = z;
    }

    public void setState(String str) {
        this.state = str;
    }
}
