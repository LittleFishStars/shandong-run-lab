package com.fl.saas.adx.base.inner;

import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.InnerNativeView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerViewLoaderEvent<T extends InnerNativeView> {
    void onAdFailed(FLError fLError);

    void onLoaded(T t);
}
