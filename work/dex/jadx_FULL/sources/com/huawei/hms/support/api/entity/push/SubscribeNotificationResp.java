package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SubscribeNotificationResp implements IMessageEntity {

    @Packed
    private int retCode = -1;

    @Packed
    private String subscribeResults;

    public int getRetCode() {
        return this.retCode;
    }

    public String getSubscribeResults() {
        return this.subscribeResults;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }

    public void setSubscribeResults(String str) {
        this.subscribeResults = str;
    }
}
