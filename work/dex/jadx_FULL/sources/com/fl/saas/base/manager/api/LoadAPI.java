package com.fl.saas.base.manager.api;

import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.common.saas.bean.AdPlace;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface LoadAPI {
    void preload(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback);

    void request(String str);
}
