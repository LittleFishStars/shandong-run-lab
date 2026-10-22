package com.alibaba.ariver.kernel.common.utils;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVPhaseRecorder extends Proxiable {
    void end();

    void start();

    void startPhase(RVTracePhase rVTracePhase);

    void stopPhase(RVTracePhase rVTracePhase);
}
