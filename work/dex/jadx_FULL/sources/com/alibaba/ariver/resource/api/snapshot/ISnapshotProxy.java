package com.alibaba.ariver.resource.api.snapshot;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ISnapshotProxy extends Proxiable {
    String getSnapshotExtDir(App app);

    boolean isSnapshotEnable(App app);

    boolean isSnapshotFileExist(App app);

    void snapshotHit(App app);
}
