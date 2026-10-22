package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActionDO implements Serializable {
    private static final long serialVersionUID = 3096996262485786435L;
    private String openType;
    private ParamDO param;

    public String getOpenType() {
        return this.openType;
    }

    public ParamDO getParam() {
        return this.param;
    }

    public void setOpenType(String str) {
        this.openType = str;
    }

    public void setParam(ParamDO paramDO) {
        this.param = paramDO;
    }
}
