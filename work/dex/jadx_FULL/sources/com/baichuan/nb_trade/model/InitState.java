package com.baichuan.nb_trade.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InitState {
    public static final int FAILURE = 3;
    public static final int INITIALIZED = 2;
    public static final int INITIALIZING = 1;
    public static final int NOT_INITIALIZED = 0;
    public int state = 0;

    public boolean isInitialing() {
        return this.state == 1;
    }

    public boolean isInitialized() {
        return this.state == 2;
    }

    public void setState(int i) {
        this.state = i;
    }
}
