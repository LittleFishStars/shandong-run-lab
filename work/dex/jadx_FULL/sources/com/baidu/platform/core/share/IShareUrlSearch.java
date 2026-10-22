package com.baidu.platform.core.share;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IShareUrlSearch {
    void destroy();

    boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption);

    boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption);

    boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption);

    void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener);
}
