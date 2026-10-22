package com.alibaba.ariver.app.api.ui.tabbar.model;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TabBarColorModel {
    public static final long DEFAULT_BACKGROUND_COLOR = -460551;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JSONField
    private Integer f23829a;

    @JSONField
    private Integer b;

    @JSONField
    private long c = DEFAULT_BACKGROUND_COLOR;

    public long getBackgroundColor() {
        return this.c;
    }

    public Integer getSelectedColor() {
        return this.b;
    }

    public Integer getTextColor() {
        return this.f23829a;
    }

    public void setBackgroundColor(long j) {
        this.c = j;
    }

    public void setSelectedColor(Integer num) {
        this.b = num;
    }

    public void setTextColor(Integer num) {
        this.f23829a = num;
    }

    public String toString() {
        return "TabBarColorModel{textColor=" + this.f23829a + ", selectedColor=" + this.b + ", backgroundColor=" + this.c + '}';
    }
}
