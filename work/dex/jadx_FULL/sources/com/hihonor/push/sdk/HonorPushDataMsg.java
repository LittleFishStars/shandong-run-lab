package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class HonorPushDataMsg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32635a = 1;
    public int b = 0;
    public long c;
    public String d;

    public String getData() {
        return this.d;
    }

    public long getMsgId() {
        return this.c;
    }

    public int getType() {
        return this.b;
    }

    public int getVersion() {
        return this.f32635a;
    }

    public void setData(String str) {
        this.d = str;
    }

    public void setMsgId(long j) {
        this.c = j;
    }

    public void setType(int i) {
        this.b = i;
    }

    public void setVersion(int i) {
        this.f32635a = i;
    }
}
