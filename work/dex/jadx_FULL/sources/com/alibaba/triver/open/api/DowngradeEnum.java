package com.alibaba.triver.open.api;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum DowngradeEnum {
    UC_CORE(0, "UC_CORE_DOWNLOAD_FAIL"),
    APP_INFO(1, "APP_INFO_DOWNLOAD_FAIL"),
    WORKER_EXCEPTION(2, "WORKER_EXCEPTION"),
    UNKNOWN(3, "UNKNOWN_FAIL");

    private int key;
    private String msg;

    DowngradeEnum(int i, String str) {
        this.key = i;
        this.msg = str;
    }

    public int getKey() {
        return this.key;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
