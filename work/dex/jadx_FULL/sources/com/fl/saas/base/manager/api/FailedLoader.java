package com.fl.saas.base.manager.api;

import com.fl.saas.base.interfaces.AdLoadEvent;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface FailedLoader extends AdLoadEvent {
    boolean isFailedCallBack();

    void onAdFailed(YdError ydError);
}
