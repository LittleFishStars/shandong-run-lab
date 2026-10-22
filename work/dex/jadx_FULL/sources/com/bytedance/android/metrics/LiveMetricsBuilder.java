package com.bytedance.android.metrics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LiveMetricsBuilder {
    private long roomId = 0;
    private String anchorId = "";
    private String requestId = "";
    private EnterFromMerge enterFromMerge = EnterFromMerge.NO_VALUE;
    private EnterMethod enterMethod = EnterMethod.NO_VALUE;
    private ActionType actionType = ActionType.CLICK;
    private long duration = 0;

    public LiveMetricsBuilder actionType(ActionType actionType) {
        this.actionType = actionType;
        return this;
    }

    public LiveMetricsBuilder anchorId(String str) {
        this.anchorId = str;
        return this;
    }

    public Params build() {
        return new Params(this.roomId, this.anchorId, this.requestId, this.enterFromMerge, this.enterMethod, this.actionType, this.duration);
    }

    public LiveMetricsBuilder duration(long j) {
        this.duration = j;
        return this;
    }

    public LiveMetricsBuilder enterFromMerge(EnterFromMerge enterFromMerge) {
        this.enterFromMerge = enterFromMerge;
        return this;
    }

    public LiveMetricsBuilder enterMethod(EnterMethod enterMethod) {
        this.enterMethod = enterMethod;
        return this;
    }

    public LiveMetricsBuilder requestId(String str) {
        this.requestId = str;
        return this;
    }

    public LiveMetricsBuilder roomId(long j) {
        this.roomId = j;
        return this;
    }
}
