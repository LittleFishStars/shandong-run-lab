package com.alibaba.triver.open.impl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum TSErrorEnum {
    APP_START_ERROR_LAUNCH("APP_START_ERROR_LAUNCH", 4),
    PLUGIN_LOAD_ERROR_LAUNCH("PLUGIN_LOAD_ERROR_LAUNCH", 8),
    JS_EXECUTE_ERROR_LAUNCH("JS_EXECUTE_ERROR_LAUNCH", 16),
    LIVE_CPS_LAUNCH("LIVE_CPS_LAUNCH", 32);

    private String key;
    private int value;

    TSErrorEnum(String str, int i) {
        this.key = str;
        this.value = i;
    }

    public static String getBinary(int i) {
        return Integer.toBinaryString(i);
    }

    public String getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(int i) {
        this.value = i;
    }
}
