package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.busline.IBusLineSearch;
import com.baidu.platform.core.busline.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BusLineSearch extends b {
    private boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IBusLineSearch f26508a = new c();

    public static BusLineSearch newInstance() {
        BMapManager.init();
        return new BusLineSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f26508a.destroy();
        BMapManager.destroy();
    }

    public boolean searchBusLine(BusLineSearchOption busLineSearchOption) {
        IBusLineSearch iBusLineSearch = this.f26508a;
        if (iBusLineSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (busLineSearchOption == null || busLineSearchOption.mCity == null || busLineSearchOption.mUid == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or city or uid can not be null");
        }
        return iBusLineSearch.a(busLineSearchOption);
    }

    public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        IBusLineSearch iBusLineSearch = this.f26508a;
        if (iBusLineSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (onGetBusLineSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iBusLineSearch.a(onGetBusLineSearchResultListener);
    }
}
