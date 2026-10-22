package com.alibaba.ariver.resource.api.proxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVAppInfoManager extends Proxiable {
    @Nullable
    @WorkerThread
    String findUrlMappedAppId(String str);

    @WorkerThread
    AppInfoModel getAppInfoModel(@NonNull AppInfoQuery appInfoQuery);

    @WorkerThread
    AppModel getAppModel(@NonNull AppInfoQuery appInfoQuery);

    @WorkerThread
    long getLastUpdateTime(String str);

    @WorkerThread
    void refreshUpdateTime(String str, long j);

    void saveAppModelList(@NonNull List<AppModel> list);
}
