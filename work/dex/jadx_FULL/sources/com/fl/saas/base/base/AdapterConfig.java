package com.fl.saas.base.base;

import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.common.saas.bean.AdSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AdapterConfig<T extends AdapterAPI> {
    T initAdapterConfig(T t);

    void requestAd(AdSource adSource);
}
