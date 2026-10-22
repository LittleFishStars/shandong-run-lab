package com.alibaba.ariver.app.api.ui.tabbar.model;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TabBarItemColorModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JSONField
    private String f23830a;

    @JSONField
    private String b;

    public String getActiveIcon() {
        return this.b;
    }

    public String getIcon() {
        return this.f23830a;
    }

    public void setActiveIcon(String str) {
        this.b = str;
    }

    public void setIcon(String str) {
        this.f23830a = str;
    }
}
