package com.huawei.hms.api;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ProtocolNegotiate {
    private static final int MAX_VERSION = 2;
    private static ProtocolNegotiate instance = new ProtocolNegotiate();
    private int version = 1;

    public static ProtocolNegotiate getInstance() {
        return instance;
    }

    public int getVersion() {
        return this.version;
    }

    public int negotiate(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            this.version = 1;
            return 1;
        }
        if (list.contains(2)) {
            this.version = 2;
        } else {
            this.version = list.get(list.size() - 1).intValue();
        }
        return this.version;
    }
}
