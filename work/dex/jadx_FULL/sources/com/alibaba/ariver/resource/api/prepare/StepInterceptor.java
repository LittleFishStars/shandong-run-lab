package com.alibaba.ariver.resource.api.prepare;

import com.alibaba.ariver.resource.api.models.AppModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface StepInterceptor {
    boolean after(PrepareStep prepareStep, PrepareController prepareController);

    boolean before(PrepareStep prepareStep, PrepareController prepareController);

    void init(PrepareContext prepareContext, PrepareCallback prepareCallback);

    boolean onError(PrepareException prepareException, PrepareController prepareController);

    void onGetAppInfo(AppModel appModel);
}
