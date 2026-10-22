package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RouteConfigDO implements Serializable {
    private static final long serialVersionUID = -280186636987281321L;
    private List<ActionDO> action;
    private int[] index;
    private String match;

    public List<ActionDO> getAction() {
        return this.action;
    }

    public int[] getIndex() {
        return this.index;
    }

    public String getMatch() {
        return this.match;
    }

    public void setAction(List<ActionDO> list) {
        this.action = list;
    }

    public void setIndex(int[] iArr) {
        this.index = iArr;
    }

    public void setMatch(String str) {
        this.match = str;
    }
}
