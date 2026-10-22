package com.fl.saas.adx.base.manager.api;

import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdLoadEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface FailedLoader extends AdLoadEvent {
    boolean isFailedCallBack();

    void onAdFailed(FLError fLError);
}
