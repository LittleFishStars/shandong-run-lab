package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class PushTokenResult implements IMessageEntity {

    @Packed
    private String pushToken = "";

    public String getPushToken() {
        return this.pushToken;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }
}
