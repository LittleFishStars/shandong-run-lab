package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IBusLineSearch {
    void a(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener);

    boolean a(BusLineSearchOption busLineSearchOption);

    void destroy();
}
