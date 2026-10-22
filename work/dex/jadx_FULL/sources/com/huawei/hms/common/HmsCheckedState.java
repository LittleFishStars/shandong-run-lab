package com.huawei.hms.common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37469a;

    HmsCheckedState(int i) {
        this.f37469a = i;
    }

    public int getState() {
        return this.f37469a;
    }
}
