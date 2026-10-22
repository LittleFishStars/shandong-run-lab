package com.alibaba.alibcprotocol.param;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcShowParams implements Serializable {
    private static final long serialVersionUID = -5455634418996345812L;
    private String backUrl;
    private String clientType;
    private AlibcDegradeType degradeType;
    private String degradeUrl;
    private boolean newWindow = true;
    private OpenType openType;
    private String title;

    public String getBackUrl() {
        return this.backUrl;
    }

    public String getClientType() {
        return this.clientType;
    }

    public AlibcDegradeType getDegradeType() {
        return this.degradeType;
    }

    public String getDegradeUrl() {
        return this.degradeUrl;
    }

    public OpenType getOpenType() {
        return this.openType;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isNewWindow() {
        return this.newWindow;
    }

    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public void setDegradeType(AlibcDegradeType alibcDegradeType) {
        this.degradeType = alibcDegradeType;
    }

    public void setDegradeUrl(String str) {
        this.degradeUrl = str;
    }

    public void setNewWindow(boolean z) {
        this.newWindow = z;
    }

    public void setOpenType(OpenType openType) {
        this.openType = openType;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
