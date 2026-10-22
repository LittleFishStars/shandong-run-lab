package com.alibaba.baichuan.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum LogLevel {
    ALL("ALL", 0),
    V("V", 0),
    D("D", 1),
    I("I", 2),
    W("W", 3),
    E("E", 4),
    F("F", 5),
    N("N", 6),
    L("L", 6);

    private int index;
    private String name;

    LogLevel(String str, int i) {
        this.name = str;
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public static String getName(int i) {
        for (LogLevel logLevel : values()) {
            if (logLevel.getIndex() == i) {
                return logLevel.name;
            }
        }
        return null;
    }
}
