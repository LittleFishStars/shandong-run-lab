package com.fl.saas.base.inner;

import com.fl.saas.base.inner.InnerNativeView;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerViewLoaderEvent<T extends InnerNativeView> {
    void onAdFailed(YdError ydError);

    void onLoaded(T t);
}
