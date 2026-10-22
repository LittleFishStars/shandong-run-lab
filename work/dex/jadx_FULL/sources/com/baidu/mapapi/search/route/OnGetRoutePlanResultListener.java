package com.baidu.mapapi.search.route;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface OnGetRoutePlanResultListener {
    void onGetBikingRouteResult(BikingRouteResult bikingRouteResult);

    void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult);

    void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult);

    void onGetIntegralRouteResult(IntegralRouteResult integralRouteResult);

    void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult);

    void onGetTransitRouteResult(TransitRouteResult transitRouteResult);

    void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult);
}
