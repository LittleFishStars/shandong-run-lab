package com.kc.bw.common.nativepot;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMPermission {
    public String description;
    public String permissionValue;
    public String title;

    public String getDescription() {
        return this.description;
    }

    public String getPermissionValue() {
        return this.permissionValue;
    }

    public String getTitle() {
        return this.title;
    }

    public WMPermission setDescription(String str) {
        this.description = str;
        return this;
    }

    public WMPermission setPermissionValue(String str) {
        this.permissionValue = str;
        return this;
    }

    public WMPermission setTitle(String str) {
        this.title = str;
        return this;
    }
}
