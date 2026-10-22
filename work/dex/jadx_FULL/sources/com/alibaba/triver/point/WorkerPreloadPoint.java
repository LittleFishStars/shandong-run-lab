package com.alibaba.triver.point;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface WorkerPreloadPoint extends Extension {
    void onWorkerPreloaded(App app, Worker worker);
}
