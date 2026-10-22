package com.acse.ottn.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PlunInstallModel {
    private String appName;
    private boolean isInstallPlun;
    private boolean isNewApk;
    private String packageName;
    private String version;

    public String getAppName() {
        return this.appName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isInstallApk() {
        return this.isInstallPlun;
    }

    public boolean isNewApk() {
        return this.isNewApk;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setInstallApk(boolean z) {
        this.isInstallPlun = z;
    }

    public void setNewApk(boolean z) {
        this.isNewApk = z;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
