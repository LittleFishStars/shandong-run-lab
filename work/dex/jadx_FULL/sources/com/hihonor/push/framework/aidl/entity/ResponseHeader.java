package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ResponseHeader implements IMessageEntity {

    @Packed
    public int statusCode;

    @Packed
    public String statusMessage;

    public ResponseHeader() {
        this.statusCode = -1;
    }

    public ResponseHeader(int i, String str) {
        this.statusCode = i;
        this.statusMessage = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }
}
