package com.gyf.immersionbar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public enum NavigationBarType {
    CLASSIC(0),
    GESTURES(1),
    GESTURES_THREE_STAGE(2),
    DOUBLE(3),
    UNKNOWN(-1);

    private final int type;

    NavigationBarType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
