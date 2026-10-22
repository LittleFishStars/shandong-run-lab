package com.baidu.platform.core.route;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import com.baidu.mapapi.search.route.MassTransitRouteLine;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i extends com.baidu.platform.base.b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private MassTransitRouteLine.TransitStep b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MassTransitRouteLine.TransitStep transitStep = new MassTransitRouteLine.TransitStep();
        transitStep.setDistance((int) jSONObject.optDouble(SchoolActivitySuccessActivity.x));
        transitStep.setDuration((int) jSONObject.optDouble("duration"));
        transitStep.setInstructions(jSONObject.optString("instructions"));
        transitStep.setPathString(jSONObject.optString("path"));
        transitStep.setTrafficConditions(c(jSONObject.optJSONArray("traffic_condition")));
        transitStep.setTransType(jSONObject.optInt("trans_type", -1));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("start_location");
        if (jSONObjectOptJSONObject != null) {
            LatLng latLng = new LatLng(jSONObjectOptJSONObject.optDouble("lat"), jSONObjectOptJSONObject.optDouble("lng"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.baiduToGcj(latLng);
            }
            transitStep.setStartLocation(latLng);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("end_location");
        if (jSONObjectOptJSONObject2 != null) {
            LatLng latLng2 = new LatLng(jSONObjectOptJSONObject2.optDouble("lat"), jSONObjectOptJSONObject2.optDouble("lng"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.baiduToGcj(latLng2);
            }
            transitStep.setEndLocation(latLng2);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("vehicle_info");
        if (jSONObjectOptJSONObject3 != null) {
            int iOptInt = jSONObjectOptJSONObject3.optInt("type");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("detail");
            switch (iOptInt) {
                case 1:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_TRAIN);
                    if (jSONObjectOptJSONObject4 != null) {
                        TrainInfo trainInfo = new TrainInfo();
                        trainInfo.setName(jSONObjectOptJSONObject4.optString("name"));
                        trainInfo.setPrice(jSONObjectOptJSONObject4.optDouble("price"));
                        trainInfo.setBooking(jSONObjectOptJSONObject4.optString("booking"));
                        trainInfo.setDepartureStation(jSONObjectOptJSONObject4.optString("departure_station"));
                        trainInfo.setArriveStation(jSONObjectOptJSONObject4.optString("arrive_station"));
                        trainInfo.setDepartureTime(jSONObjectOptJSONObject4.optString("departure_time"));
                        trainInfo.setArriveTime(jSONObjectOptJSONObject4.optString("arrive_time"));
                        transitStep.setTrainInfo(trainInfo);
                    }
                    break;
                case 2:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_PLANE);
                    if (jSONObjectOptJSONObject4 != null) {
                        PlaneInfo planeInfo = new PlaneInfo();
                        planeInfo.setName(jSONObjectOptJSONObject4.optString("name"));
                        planeInfo.setPrice(jSONObjectOptJSONObject4.optDouble("price"));
                        planeInfo.setDiscount(jSONObjectOptJSONObject4.optDouble("discount"));
                        planeInfo.setAirlines(jSONObjectOptJSONObject4.optString("airlines"));
                        planeInfo.setBooking(jSONObjectOptJSONObject4.optString("booking"));
                        planeInfo.setDepartureStation(jSONObjectOptJSONObject4.optString("departure_station"));
                        planeInfo.setArriveStation(jSONObjectOptJSONObject4.optString("arrive_station"));
                        planeInfo.setDepartureTime(jSONObjectOptJSONObject4.optString("departure_time"));
                        planeInfo.setArriveTime(jSONObjectOptJSONObject4.optString("arrive_time"));
                        transitStep.setPlaneInfo(planeInfo);
                    }
                    break;
                case 3:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_BUS);
                    if (jSONObjectOptJSONObject4 != null) {
                        BusInfo busInfo = new BusInfo();
                        busInfo.setName(jSONObjectOptJSONObject4.optString("name"));
                        busInfo.setType(jSONObjectOptJSONObject4.optInt("type"));
                        busInfo.setStopNum(jSONObjectOptJSONObject4.optInt("stop_num"));
                        busInfo.setDepartureStation(jSONObjectOptJSONObject4.optString("on_station"));
                        busInfo.setArriveStation(jSONObjectOptJSONObject4.optString("off_station"));
                        busInfo.setDepartureTime(jSONObjectOptJSONObject4.optString("first_time"));
                        busInfo.setArriveTime(jSONObjectOptJSONObject4.optString("last_time"));
                        busInfo.setDirectText(jSONObjectOptJSONObject4.optString("direct_text"));
                        busInfo.setLineUid(jSONObjectOptJSONObject4.optString("line_id"));
                        JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("start_info");
                        if (jSONObjectOptJSONObject5 != null) {
                            busInfo.setStartUid(jSONObjectOptJSONObject5.optString("start_uid"));
                        }
                        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("end_info");
                        if (jSONObjectOptJSONObject6 != null) {
                            busInfo.setEndUid(jSONObjectOptJSONObject6.optString("end_uid"));
                        }
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("stop_info");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray.optJSONObject(i);
                                if (jSONObjectOptJSONObject7 != null) {
                                    RouteNode routeNode = new RouteNode();
                                    routeNode.setTitle(jSONObjectOptJSONObject7.optString("stop_name"));
                                    JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject7.optJSONObject("stop_location");
                                    if (jSONObjectOptJSONObject8 != null) {
                                        LatLng latLng3 = new LatLng(jSONObjectOptJSONObject8.optDouble("lat"), jSONObjectOptJSONObject8.optDouble("lng"));
                                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                            routeNode.setLocation(CoordTrans.baiduToGcj(latLng3));
                                        } else {
                                            routeNode.setLocation(latLng3);
                                        }
                                    }
                                    arrayList.add(routeNode);
                                }
                            }
                            busInfo.setPassStopInfoList(arrayList);
                        }
                        transitStep.setBusInfo(busInfo);
                    }
                    break;
                case 4:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_DRIVING);
                    break;
                case 5:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_WALK);
                    break;
                case 6:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_COACH);
                    if (jSONObjectOptJSONObject4 != null) {
                        CoachInfo coachInfo = new CoachInfo();
                        coachInfo.setName(jSONObjectOptJSONObject4.optString("name"));
                        coachInfo.setPrice(jSONObjectOptJSONObject4.optDouble("price"));
                        coachInfo.setBooking(jSONObjectOptJSONObject4.optString("booking"));
                        coachInfo.setProviderName(jSONObjectOptJSONObject4.optString("provider_name"));
                        coachInfo.setProviderUrl(jSONObjectOptJSONObject4.optString("provider_url"));
                        coachInfo.setDepartureStation(jSONObjectOptJSONObject4.optString("departure_station"));
                        coachInfo.setArriveStation(jSONObjectOptJSONObject4.optString("arrive_station"));
                        coachInfo.setDepartureTime(jSONObjectOptJSONObject4.optString("departure_time"));
                        coachInfo.setArriveTime(jSONObjectOptJSONObject4.optString("arrive_time"));
                        transitStep.setCoachInfo(coachInfo);
                    }
                    break;
            }
        }
        return transitStep;
    }

    private List<MassTransitRouteLine.TransitStep.TrafficCondition> c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                MassTransitRouteLine.TransitStep.TrafficCondition trafficCondition = new MassTransitRouteLine.TransitStep.TrafficCondition();
                trafficCondition.setTrafficStatus(jSONObjectOptJSONObject.optInt("status"));
                trafficCondition.setTrafficGeoCnt(jSONObjectOptJSONObject.optInt("geo_cnt"));
                arrayList.add(trafficCondition);
            }
        }
        return arrayList;
    }

    private List<List<MassTransitRouteLine.TransitStep>> d(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() < 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList2.add(b(jSONObjectOptJSONObject));
                    }
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        MassTransitRouteResult massTransitRouteResult = new MassTransitRouteResult();
        if (str == null || str.equals("")) {
            massTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return massTransitRouteResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    massTransitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return massTransitRouteResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        massTransitRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        massTransitRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        massTransitRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return massTransitRouteResult;
                }
            }
            if (!a(str, massTransitRouteResult, false) && !a(str, massTransitRouteResult)) {
                massTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return massTransitRouteResult;
        } catch (Exception unused) {
            massTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return massTransitRouteResult;
        }
    }

    public boolean a(String str, MassTransitRouteResult massTransitRouteResult) {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("status_sdk");
                if (iOptInt != 0) {
                    if (iOptInt == 1) {
                        massTransitRouteResult.error = SearchResult.ERRORNO.MASS_TRANSIT_SERVER_ERROR;
                        return true;
                    }
                    if (iOptInt == 2) {
                        massTransitRouteResult.error = SearchResult.ERRORNO.MASS_TRANSIT_OPTION_ERROR;
                        return true;
                    }
                    if (iOptInt != 1002) {
                        return false;
                    }
                    massTransitRouteResult.error = SearchResult.ERRORNO.MASS_TRANSIT_NO_POI_ERROR;
                    return true;
                }
                int iOptInt2 = jSONObject.optInt("type");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject == null) {
                    return false;
                }
                if (iOptInt2 == 1) {
                    massTransitRouteResult.setOrigin(a(iOptInt2, jSONObjectOptJSONObject.optJSONObject("origin_info")));
                    massTransitRouteResult.setDestination(a(iOptInt2, jSONObjectOptJSONObject.optJSONObject("destination_info")));
                    massTransitRouteResult.setSuggestAddrInfo(a(jSONObjectOptJSONObject));
                    massTransitRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                } else if (iOptInt2 == 2) {
                    TransitResultNode transitResultNodeA = a(iOptInt2, jSONObjectOptJSONObject.optJSONObject("origin"));
                    massTransitRouteResult.setOrigin(transitResultNodeA);
                    TransitResultNode transitResultNodeA2 = a(iOptInt2, jSONObjectOptJSONObject.optJSONObject("destination"));
                    massTransitRouteResult.setDestination(transitResultNodeA2);
                    massTransitRouteResult.setTotal(jSONObjectOptJSONObject.optInt("total"));
                    massTransitRouteResult.setTaxiInfo(b(jSONObjectOptJSONObject.optString("taxi")));
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("routes");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject2 != null) {
                            MassTransitRouteLine massTransitRouteLine = new MassTransitRouteLine();
                            massTransitRouteLine.setDistance(jSONObjectOptJSONObject2.optInt(SchoolActivitySuccessActivity.x));
                            massTransitRouteLine.setDuration(jSONObjectOptJSONObject2.optInt("duration"));
                            massTransitRouteLine.setArriveTime(jSONObjectOptJSONObject2.optString("arrive_time"));
                            massTransitRouteLine.setPrice(jSONObjectOptJSONObject2.optDouble("price"));
                            massTransitRouteLine.setPriceInfo(a(jSONObjectOptJSONObject2.optJSONArray("price_detail")));
                            if (transitResultNodeA != null) {
                                RouteNode routeNode = new RouteNode();
                                routeNode.setLocation(transitResultNodeA.getLocation());
                                massTransitRouteLine.setStarting(routeNode);
                            }
                            if (transitResultNodeA2 != null) {
                                RouteNode routeNode2 = new RouteNode();
                                routeNode2.setLocation(transitResultNodeA2.getLocation());
                                massTransitRouteLine.setTerminal(routeNode2);
                            }
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps");
                            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                                massTransitRouteLine.setNewSteps(d(jSONArrayOptJSONArray2));
                                arrayList.add(massTransitRouteLine);
                            }
                        }
                    }
                    massTransitRouteResult.setRoutelines(arrayList);
                    massTransitRouteResult.error = SearchResult.ERRORNO.NO_ERROR;
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private List<PriceInfo> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            PriceInfo priceInfo = new PriceInfo();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                priceInfo.setTicketType(jSONObjectOptJSONObject.optInt("ticket_type"));
                priceInfo.setTicketPrice(jSONObjectOptJSONObject.optDouble("ticket_price"));
            }
            arrayList.add(priceInfo);
        }
        return arrayList;
    }

    private TransitResultNode a(int i, JSONObject jSONObject) {
        int iOptInt;
        LatLng latLng = null;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(AliyunLogKey.KEY_WIDTH);
        String strOptString2 = jSONObject.optString("city_name");
        if (i == 1) {
            iOptInt = jSONObject.optInt("city_code");
        } else {
            iOptInt = jSONObject.optInt("city_id");
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(RequestParameters.SUBRESOURCE_LOCATION);
        if (jSONObjectOptJSONObject != null) {
            latLng = new LatLng(jSONObjectOptJSONObject.optDouble("lat"), jSONObjectOptJSONObject.optDouble("lng"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.baiduToGcj(latLng);
            }
        }
        return new TransitResultNode(iOptInt, strOptString2, latLng, strOptString);
    }

    private SuggestAddrInfo a(JSONObject jSONObject) {
        SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
        suggestAddrInfo.setSuggestStartNode(b(jSONObject.optJSONArray("origin_list")));
        suggestAddrInfo.setSuggestEndNode(b(jSONObject.optJSONArray("destination_list")));
        return suggestAddrInfo;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetMassTransitRouteResult((MassTransitRouteResult) searchResult);
    }

    private List<PoiInfo> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.address = jSONObject.optString("address");
                poiInfo.uid = jSONObject.optString(UserConstants.URL_PARAMS.b);
                poiInfo.name = jSONObject.optString("name");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(RequestParameters.SUBRESOURCE_LOCATION);
                if (jSONObjectOptJSONObject != null) {
                    poiInfo.location = new LatLng(jSONObjectOptJSONObject.optDouble("lat"), jSONObjectOptJSONObject.optDouble("lng"));
                    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                        poiInfo.location = CoordTrans.baiduToGcj(poiInfo.location);
                    }
                }
                arrayList.add(poiInfo);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private TaxiInfo b(String str) {
        JSONObject jSONObject;
        if (str == null || str.length() == 0 || "null".equals(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        TaxiInfo taxiInfo = new TaxiInfo();
        taxiInfo.setDesc(jSONObject.optString("remark"));
        taxiInfo.setDistance(jSONObject.optInt(SchoolActivitySuccessActivity.x));
        taxiInfo.setDuration(jSONObject.optInt("duration"));
        taxiInfo.setTotalPrice((float) jSONObject.optDouble("total_price"));
        taxiInfo.setStartPrice((float) jSONObject.optDouble("start_price"));
        taxiInfo.setPerKMPrice((float) jSONObject.optDouble("km_price"));
        return taxiInfo;
    }
}
