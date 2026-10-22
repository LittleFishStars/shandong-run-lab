package com.fl.saas.base.manager.api;

import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.common.saas.bean.AdPlace;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ManagerAPI<T extends BaseBuilder<?>> extends ManagerInfoAPI {
    void preload(T t, AdPlace adPlace, PreloadDoneCallback preloadDoneCallback);

    void request(T t);
}
