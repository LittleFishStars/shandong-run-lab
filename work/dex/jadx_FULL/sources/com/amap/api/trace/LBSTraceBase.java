package com.amap.api.trace;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener);

    void setLocationInterval(long j);

    void setTraceStatusInterval(int i);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}
