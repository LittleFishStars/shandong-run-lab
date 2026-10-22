package com.baidu.platform.core.route;

import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class m extends l {
    /* JADX WARN: Code duplicated, block: B:71:0x01d6  */
    private boolean a(String str, TransitRouteResult transitRouteResult) {
        JSONArray jSONArray;
        RouteNode routeNode;
        int i = 0;
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
            if (jSONObjectOptJSONObject == null) {
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("error");
            if (iOptInt != 0) {
                if (iOptInt == 1) {
                    transitRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                    return true;
                }
                if (iOptInt != 200) {
                    return false;
                }
                transitRouteResult.error = SearchResult.ERRORNO.NOT_SUPPORT_BUS_2CITY;
                return true;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("bus");
            if (jSONObjectOptJSONObject2 == null) {
                return false;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("taxi");
            if (jSONObjectOptJSONObject3 != null) {
                transitRouteResult.setTaxiInfo(b(jSONObjectOptJSONObject3));
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("option");
            if (jSONObjectOptJSONObject4 == null) {
                return false;
            }
            RouteNode routeNodeC = c(jSONObjectOptJSONObject4, "start");
            RouteNode routeNodeC2 = c(jSONObjectOptJSONObject4, "end");
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("routes");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) ((JSONObject) jSONArrayOptJSONArray.opt(i2)).optJSONArray("legs").opt(i);
                if (jSONObject2 == null) {
                    jSONArray = jSONArrayOptJSONArray;
                    routeNode = routeNodeC2;
                } else {
                    TransitRouteLine transitRouteLine = new TransitRouteLine();
                    transitRouteLine.setDistance(jSONObject2.optInt(SchoolActivitySuccessActivity.x));
                    transitRouteLine.setDuration(jSONObject2.optInt("duration"));
                    transitRouteLine.setStarting(routeNodeC);
                    transitRouteLine.setTerminal(routeNodeC2);
                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("steps");
                    if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                        jSONArray = jSONArrayOptJSONArray;
                        routeNode = routeNodeC2;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = i;
                        while (i3 < jSONArrayOptJSONArray2.length()) {
                            JSONArray jSONArrayOptJSONArray3 = jSONArrayOptJSONArray2.optJSONObject(i3).optJSONArray("step");
                            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i);
                                TransitRouteLine.TransitStep transitStep = new TransitRouteLine.TransitStep();
                                transitStep.setEntrace(RouteNode.location(CoordUtil.decodeLocation(jSONObjectOptJSONObject5.optString("start_location"))));
                                transitStep.setExit(RouteNode.location(CoordUtil.decodeLocation(jSONObjectOptJSONObject5.optString("end_location"))));
                                if (jSONObjectOptJSONObject5.optInt("type") == 5) {
                                    transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING);
                                } else {
                                    transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                                }
                                transitStep.setInstructions(d(jSONObjectOptJSONObject5.optString("instructions")));
                                transitStep.setDistance(jSONObjectOptJSONObject5.optInt(SchoolActivitySuccessActivity.x));
                                transitStep.setDuration(jSONObjectOptJSONObject5.optInt("duration"));
                                transitStep.setPathString(jSONObjectOptJSONObject5.optString("path"));
                                if (jSONObjectOptJSONObject5.has("vehicle")) {
                                    transitStep.setVehicleInfo(c(jSONObjectOptJSONObject5.optString("vehicle")));
                                    JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("vehicle");
                                    transitStep.getEntrance().setUid(jSONObjectOptJSONObject6.optString("start_uid"));
                                    transitStep.getEntrance().setTitle(jSONObjectOptJSONObject6.optString("start_name"));
                                    transitStep.getExit().setUid(jSONObjectOptJSONObject6.optString("end_uid"));
                                    transitStep.getExit().setTitle(jSONObjectOptJSONObject6.optString("end_name"));
                                    Integer numValueOf = Integer.valueOf(jSONObjectOptJSONObject6.optInt("type"));
                                    if (numValueOf == null || numValueOf.intValue() != 1) {
                                        transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                                    } else {
                                        transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.SUBWAY);
                                    }
                                }
                                arrayList2.add(transitStep);
                            }
                            i3++;
                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                            routeNodeC2 = routeNodeC2;
                            i = 0;
                        }
                        jSONArray = jSONArrayOptJSONArray;
                        routeNode = routeNodeC2;
                        transitRouteLine.setSteps(arrayList2);
                        arrayList.add(transitRouteLine);
                    }
                }
                i2++;
                jSONArrayOptJSONArray = jSONArray;
                routeNodeC2 = routeNode;
                i = 0;
            }
            transitRouteResult.setRoutelines(arrayList);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private RouteNode c(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null || "".equals(str)) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObjectOptJSONObject.optString(AliyunLogKey.KEY_WIDTH));
        routeNode.setUid(jSONObjectOptJSONObject.optString(UserConstants.URL_PARAMS.b));
        routeNode.setLocation(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString("pt")));
        return routeNode;
    }

    private String d(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (char c : str.toCharArray()) {
            if (c == '<') {
                z = true;
            } else if (c == '>') {
                z = false;
            } else if (!z) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void b(String str, TransitRouteResult transitRouteResult) {
        if (str == null || str.equals("")) {
            transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    transitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        transitRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        return;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        transitRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        return;
                    } else {
                        transitRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
            }
            if (a(str, transitRouteResult, false) || a(str, transitRouteResult)) {
                return;
            }
            transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } catch (Exception unused) {
            transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }

    private VehicleInfo c(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setZonePrice(jSONObject.optInt("zone_price"));
        vehicleInfo.setTotalPrice(jSONObject.optInt("total_price"));
        vehicleInfo.setTitle(jSONObject.optString("name"));
        vehicleInfo.setPassStationNum(jSONObject.optInt("stop_num"));
        vehicleInfo.setUid(jSONObject.optString(UserConstants.URL_PARAMS.b));
        vehicleInfo.setStartTime(jSONObject.optString(CropKey.RESULT_KEY_START_TIME));
        vehicleInfo.setEndTime(jSONObject.optString("end_time"));
        vehicleInfo.setHeadWay(jSONObject.optString("headway"));
        vehicleInfo.setDirectText(jSONObject.optString("direct_text"));
        return vehicleInfo;
    }

    private TaxiInfo b(JSONObject jSONObject) {
        float fOptDouble;
        float fOptDouble2;
        float fOptDouble3;
        if (jSONObject == null) {
            return null;
        }
        TaxiInfo taxiInfo = new TaxiInfo();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("detail");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i);
            if (jSONObject2 != null && jSONObject2.optString("desc").contains("白天")) {
                fOptDouble = (float) jSONObject2.optDouble("km_price");
                fOptDouble2 = (float) jSONObject2.optDouble("start_price");
                fOptDouble3 = (float) jSONObject2.optDouble("total_price");
                taxiInfo.setDesc(jSONObject.optString("remark"));
                taxiInfo.setDistance(jSONObject.optInt(SchoolActivitySuccessActivity.x));
                taxiInfo.setDuration(jSONObject.optInt("duration"));
                taxiInfo.setTotalPrice(fOptDouble3);
                taxiInfo.setStartPrice(fOptDouble2);
                taxiInfo.setPerKMPrice(fOptDouble);
                return taxiInfo;
            }
        }
        fOptDouble = 0.0f;
        fOptDouble2 = 0.0f;
        fOptDouble3 = 0.0f;
        taxiInfo.setDesc(jSONObject.optString("remark"));
        taxiInfo.setDistance(jSONObject.optInt(SchoolActivitySuccessActivity.x));
        taxiInfo.setDuration(jSONObject.optInt("duration"));
        taxiInfo.setTotalPrice(fOptDouble3);
        taxiInfo.setStartPrice(fOptDouble2);
        taxiInfo.setPerKMPrice(fOptDouble);
        return taxiInfo;
    }
}
