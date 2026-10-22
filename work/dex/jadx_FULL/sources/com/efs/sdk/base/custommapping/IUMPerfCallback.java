package com.efs.sdk.base.custommapping;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IUMPerfCallback {

    public enum PerfType {
        PERF_TYPE_START(1),
        PERF_TYPE_POWER(2);

        int mType;

        PerfType(int i) {
            this.mType = i;
        }

        public final int getType() {
            return this.mType;
        }
    }

    void onCallback(PerfType perfType);
}
