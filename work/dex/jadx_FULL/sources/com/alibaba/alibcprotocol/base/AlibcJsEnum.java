package com.alibaba.alibcprotocol.base;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum AlibcJsEnum {
    SUCCESS(0, "BC_SUCCESS"),
    NO_METHOD(1, "BC_NO_HANDLER"),
    PARAM_ERR(2, "BC_PARAM_ERR"),
    UNKNOWN_ERR(3, "BC_UNKNOWN_ERR"),
    NO_PERMISSION(4, "BC_NO_PERMISSION"),
    TIMEOUT(5, "BC_TIMEOUT"),
    FAIL(6, "BC_FAILED"),
    CLOSED(7, "BC_CLOSED"),
    APP_NOT_INSTALL(8, "BC_APP_NOT_INSTALL");

    private int code;
    private String msg;

    AlibcJsEnum(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public static AlibcJsEnum valueOfCode(int i) {
        for (AlibcJsEnum alibcJsEnum : values()) {
            if (i == alibcJsEnum.code) {
                return alibcJsEnum;
            }
        }
        return null;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }
}
