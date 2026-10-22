package com.alibaba.ariver.resource.api.snapshot;

import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SnapshotSaveExtension implements PushWindowPoint, PagePausePoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24436a = "AriverRes:SnapshotSaveExtension";

    private void a(final Page page) {
        ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.resource.api.snapshot.SnapshotSaveExtension.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RVSnapshotUtils.handleSnapshotEvent(page);
                } catch (Throwable th) {
                    RVLogger.w(SnapshotSaveExtension.f24436a, "handleSnapshotEvent exception!", th);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.point.app.PushWindowPoint
    public boolean handlePushWindow(Page page, String str, Bundle bundle, Bundle bundle2) {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
    }
}
