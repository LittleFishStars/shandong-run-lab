package com.baidu.mapapi.search.share;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.platform.core.share.IShareUrlSearch;
import com.baidu.platform.core.share.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ShareUrlSearch extends b {
    private boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IShareUrlSearch f26574a = new f();

    private boolean a(String str) {
        return true;
    }

    public static ShareUrlSearch newInstance() {
        BMapManager.init();
        return new ShareUrlSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f26574a.destroy();
        BMapManager.destroy();
    }

    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        IShareUrlSearch iShareUrlSearch = this.f26574a;
        if (iShareUrlSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (locationShareURLOption == null || locationShareURLOption.mLocation == null || locationShareURLOption.mName == null || locationShareURLOption.mSnippet == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or name or snippet  can not be null");
        }
        return iShareUrlSearch.requestLocationShareUrl(locationShareURLOption);
    }

    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        IShareUrlSearch iShareUrlSearch = this.f26574a;
        if (iShareUrlSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (poiDetailShareURLOption == null || poiDetailShareURLOption.mUid == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
        }
        return iShareUrlSearch.requestPoiDetailShareUrl(poiDetailShareURLOption);
    }

    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        if (this.f26574a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (routeShareURLOption == null) {
            throw new IllegalArgumentException("BDMapSDKException: option is null");
        }
        if (routeShareURLOption.getmMode().ordinal() < 0) {
            return false;
        }
        PlanNode planNode = routeShareURLOption.mFrom;
        if (planNode == null || routeShareURLOption.mTo == null) {
            throw new IllegalArgumentException("BDMapSDKException: start or end point can not be null");
        }
        if (routeShareURLOption.mMode == RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE) {
            if ((planNode.getLocation() == null || routeShareURLOption.mTo.getLocation() == null) && routeShareURLOption.mCityCode < 0) {
                throw new IllegalArgumentException("BDMapSDKException: city code can not be null if don't set start or end point");
            }
        } else {
            if (planNode.getLocation() == null && !a(routeShareURLOption.mFrom.getCity())) {
                throw new IllegalArgumentException("BDMapSDKException: start cityCode must be set if not set start location");
            }
            if (routeShareURLOption.mTo.getLocation() == null && !a(routeShareURLOption.mTo.getCity())) {
                throw new IllegalArgumentException("BDMapSDKException: end cityCode must be set if not set end location");
            }
        }
        return this.f26574a.requestRouteShareUrl(routeShareURLOption);
    }

    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        IShareUrlSearch iShareUrlSearch = this.f26574a;
        if (iShareUrlSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (onGetShareUrlResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iShareUrlSearch.setOnGetShareUrlResultListener(onGetShareUrlResultListener);
    }
}
