package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ProfileReq implements IMessageEntity {

    @Packed
    private int operation;

    @Packed
    private String pkgName;

    @Packed
    private String profileId;

    @Packed
    private String subjectId;

    @Packed
    private int type;

    public int getOperation() {
        return this.operation;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public int getType() {
        return this.type;
    }

    public void setOperation(int i) {
        this.operation = i;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setSubjectId(String str) {
        this.subjectId = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return getClass().getName() + "{ pkgName: " + this.pkgName + ",subjectId: " + this.subjectId + ",operation: " + this.operation + " type: " + this.type + "}";
    }
}
