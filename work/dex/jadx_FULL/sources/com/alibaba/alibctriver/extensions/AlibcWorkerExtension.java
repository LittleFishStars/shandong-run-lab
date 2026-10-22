package com.alibaba.alibctriver.extensions;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.triver.point.WorkerPreloadPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcWorkerExtension implements WorkerPreloadPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23678a = "AlibcWorkerExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.triver.point.WorkerPreloadPoint
    public void onWorkerPreloaded(App app, Worker worker) {
        boolean zIsWorkerReady = worker.isWorkerReady();
        AlibcLogger.i(f23678a, "worker status: " + zIsWorkerReady);
    }
}
