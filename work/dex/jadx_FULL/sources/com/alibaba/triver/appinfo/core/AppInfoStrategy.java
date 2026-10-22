package com.alibaba.triver.appinfo.core;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum AppInfoStrategy {
    ASYNC_LOAD("asyncLoad"),
    SYNC_LOAD("syncLoad"),
    NONE("localLoad");

    private String name;

    AppInfoStrategy(String str) {
        this.name = str;
    }

    public static AppInfoStrategy getStrategy(String str) {
        return "syncLoad".equals(str) ? SYNC_LOAD : ASYNC_LOAD;
    }

    public String getName() {
        return this.name;
    }
}
