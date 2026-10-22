package com.alibaba.appmonitor.event;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements com.alibaba.appmonitor.pool.b {
    public String aH;
    public String aI;
    public String aJ;
    public String aK;
    public int eventId;
    public Map<String, String> w;

    @Override // com.alibaba.appmonitor.pool.b
    public void clean() {
        this.aH = null;
        this.eventId = 0;
        this.aI = null;
        this.aJ = null;
        this.aK = null;
        Map<String, String> map = this.w;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        if (this.w == null) {
            this.w = new HashMap();
        }
    }
}
