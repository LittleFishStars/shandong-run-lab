package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.zj.adlib.bv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DeleteTokenReq implements IMessageEntity {

    @Packed
    private String appId;

    @Packed
    private String pkgName;

    @Packed
    private String projectId;

    @Packed
    private String scope;

    @Packed
    private String subjectId;

    @Packed
    private String token;

    @Packed
    private boolean isMultiSender = false;

    @Packed
    private int deleteType = 0;

    @Packed
    private boolean isFastApp = false;

    public String getAppId() {
        return this.appId;
    }

    public int getDeleteType() {
        return this.deleteType;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getScope() {
        return this.scope;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setDeleteType(int i) {
        this.deleteType = i;
    }

    public void setFastApp(boolean z) {
        this.isFastApp = z;
    }

    public void setMultiSender(boolean z) {
        this.isMultiSender = z;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setSubjectId(String str) {
        this.subjectId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(bv9.b);
        stringBuffer.append("pkgName: ");
        stringBuffer.append(this.pkgName);
        stringBuffer.append(",scope:");
        stringBuffer.append(this.scope);
        stringBuffer.append(",appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(",projectId:");
        stringBuffer.append(this.projectId);
        stringBuffer.append(",subjectId:");
        stringBuffer.append(this.subjectId);
        stringBuffer.append(",subjectId:");
        stringBuffer.append(this.subjectId);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
