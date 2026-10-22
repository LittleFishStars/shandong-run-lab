package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PageDO implements Serializable {
    private static final long serialVersionUID = -8776012536904661470L;
    private SuiteMiscDO misc;
    private String sign;
    private List<SuiteDO> suites;

    public SuiteMiscDO getMisc() {
        return this.misc;
    }

    public String getSign() {
        return this.sign;
    }

    public List<SuiteDO> getSuites() {
        return this.suites;
    }

    public void setMisc(SuiteMiscDO suiteMiscDO) {
        this.misc = suiteMiscDO;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSuites(List<SuiteDO> list) {
        this.suites = list;
    }
}
