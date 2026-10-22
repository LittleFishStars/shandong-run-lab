package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParamDO implements Serializable {
    private static final long serialVersionUID = 6227617631258752248L;
    private String clientPage;
    private String clientType;
    private boolean force;
    private String targetPath;

    public String getClientPage() {
        return this.clientPage;
    }

    public String getClientType() {
        return this.clientType;
    }

    public boolean getForce() {
        return this.force;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public void setClientPage(String str) {
        this.clientPage = str;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public void setForce(boolean z) {
        this.force = z;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }
}
