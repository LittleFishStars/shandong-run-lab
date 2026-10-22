package com.alibaba.ariver.resource.api.appinfo;

import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface UpdateAppCallback {
    void onError(UpdateAppException updateAppException);

    void onSuccess(List<AppModel> list);
}
