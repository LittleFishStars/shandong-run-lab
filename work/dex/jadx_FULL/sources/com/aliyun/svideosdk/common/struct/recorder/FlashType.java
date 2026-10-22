package com.aliyun.svideosdk.common.struct.recorder;

import com.alibaba.baichuan.log.TLogConstant;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public enum FlashType {
    OFF(TLogConstant.TLOG_MODULE_OFF),
    ON("on"),
    AUTO("auto"),
    TORCH("torch");

    private String type;

    FlashType(String str) {
        this.type = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }
}
