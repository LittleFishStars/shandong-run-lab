package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class CodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37638a;
    private String b;

    public CodeResult() {
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.f37638a;
    }

    public void setReason(String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.f37638a = i;
    }

    public CodeResult(int i) {
        this.f37638a = i;
    }

    public CodeResult(int i, String str) {
        this.f37638a = i;
        this.b = str;
    }
}
