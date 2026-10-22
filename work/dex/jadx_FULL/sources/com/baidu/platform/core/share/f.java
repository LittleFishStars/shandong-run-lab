package com.baidu.platform.core.share;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f extends com.baidu.platform.base.a implements IShareUrlSearch {
    OnGetShareUrlResultListener g = null;

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        e eVar = new e();
        eVar.a(SearchType.LOCATION_SEARCH_SHARE);
        return a(new a(locationShareURLOption), this.g, eVar);
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        e eVar = new e();
        eVar.a(SearchType.POI_DETAIL_SHARE);
        return a(new b(poiDetailShareURLOption), this.g, eVar);
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        c cVar = new c();
        cVar.a(SearchType.ROUTE_PLAN_SHARE);
        return a(new d(routeShareURLOption), this.g, cVar);
    }

    @Override // com.baidu.platform.core.share.IShareUrlSearch
    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        this.c.lock();
        this.g = onGetShareUrlResultListener;
        this.c.unlock();
    }
}
