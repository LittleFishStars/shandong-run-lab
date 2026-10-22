package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UrlTypeDO implements Serializable {
    private static final long serialVersionUID = -8652687626633152540L;
    private String[] pattern;
    private String type;

    public String[] getPattern() {
        return this.pattern;
    }

    public String getType() {
        return this.type;
    }

    public void setPattern(String[] strArr) {
        this.pattern = strArr;
    }

    public void setType(String str) {
        this.type = str;
    }
}
