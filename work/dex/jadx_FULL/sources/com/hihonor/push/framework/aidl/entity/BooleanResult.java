package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BooleanResult implements IMessageEntity {

    @Packed
    private boolean status;

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }
}
