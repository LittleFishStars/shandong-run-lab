package com.alibaba.alibclinkpartner.smartlink.data;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SafeConfig implements Serializable {
    private long validtime;
    private List<String> whiteList;

    public long getValidtime() {
        return this.validtime;
    }

    public List<String> getWhiteList() {
        return this.whiteList;
    }

    public void setValidtime(long j) {
        this.validtime = j;
    }

    public void setWhiteList(List<String> list) {
        this.whiteList = list;
    }
}
