package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BizPatternDO implements Serializable {
    private static final long serialVersionUID = 2356028581469132945L;
    private String bizCode;
    private String[] pattern;

    public String getBizCode() {
        return this.bizCode;
    }

    public String[] getPattern() {
        return this.pattern;
    }

    public void setBizCode(String str) {
        this.bizCode = str;
    }

    public void setPattern(String[] strArr) {
        this.pattern = strArr;
    }
}
