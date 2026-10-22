package com.alibaba.alibcprotocol;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum BCErrorEnum {
    CODE_IN_SUITE_LAUNCH("CODE_IN_SUITE_LAUNCH", 1),
    PAGE_INTERCEPTOR_LAUNCH("PLUGIN_LOAD_ERROR_LAUNCH", 253),
    DETAIL_CPS_LAUNCH("DETAIL_CPS_LAUNCH", 64);

    private String key;
    private int value;

    BCErrorEnum(String str, int i) {
        this.key = str;
        this.value = i;
    }

    public static String getBinary(int i) {
        return Integer.toBinaryString(i);
    }

    public final String getKey() {
        return this.key;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setValue(int i) {
        this.value = i;
    }
}
