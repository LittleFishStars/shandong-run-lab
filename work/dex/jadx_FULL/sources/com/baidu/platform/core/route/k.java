package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k extends com.baidu.platform.base.a implements IRoutePlanSearch {
    private OnGetRoutePlanResultListener g = null;

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        a aVar = new a();
        aVar.a(SearchType.BIKE_ROUTE);
        return a(new b(bikingRoutePlanOption), this.g, aVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        c cVar = new c();
        cVar.a(SearchType.DRIVE_ROUTE);
        return a(new d(drivingRoutePlanOption), this.g, cVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        i iVar = new i();
        iVar.a(SearchType.MASS_TRANSIT_ROUTE);
        return a(new j(massTransitRoutePlanOption), this.g, iVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        this.c.lock();
        this.g = onGetRoutePlanResultListener;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        m mVar = new m();
        mVar.a(SearchType.TRANSIT_ROUTE);
        return a(new n(transitRoutePlanOption), this.g, mVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        e eVar = new e();
        eVar.a(SearchType.INDOOR_ROUTE);
        return a(new f(indoorRoutePlanOption), this.g, eVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean walkingIntegralSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        g gVar = new g();
        gVar.a(SearchType.INTEGRAL_ROUTE);
        return a(new h(walkingRoutePlanOption), this.g, gVar);
    }

    @Override // com.baidu.platform.core.route.IRoutePlanSearch
    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        o oVar = new o();
        oVar.a(SearchType.WALK_ROUTE);
        return a(new p(walkingRoutePlanOption), this.g, oVar);
    }
}
