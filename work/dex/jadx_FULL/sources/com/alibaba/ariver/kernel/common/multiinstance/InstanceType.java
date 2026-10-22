package com.alibaba.ariver.kernel.common.multiinstance;

import com.alibaba.ariver.kernel.RVParams;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum InstanceType {
    ALIPAY(RVParams.ANTI_PHISHING),
    TAOBAO("tb");

    private String value;

    InstanceType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
