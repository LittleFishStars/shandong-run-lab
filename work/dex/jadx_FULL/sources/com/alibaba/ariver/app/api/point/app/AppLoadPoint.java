package com.alibaba.ariver.app.api.point.app;

import android.os.Bundle;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface AppLoadPoint extends Extension {

    public interface LoadResultCallback {
        void onResult(AppLoadResult appLoadResult);
    }

    @ThreadType(transSyncThreadNames = {RVScheduleType.BIZ_SPECIFIC, RVScheduleType.BIZ_SPECIFIC_SCHEDULED, RVScheduleType.URGENT, RVScheduleType.URGENT_DISPLAY}, value = ExecutorType.URGENT_DISPLAY)
    void loadApp(String str, Bundle bundle, Bundle bundle2, LoadResultCallback loadResultCallback);
}
