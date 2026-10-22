package com.baidu.platform.core.route;

import androidx.camera.video.AudioStats;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.IndoorRouteLine;
import com.baidu.mapapi.search.route.IntegralRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g extends com.baidu.platform.base.b {
    private RouteNode b(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        return a(jSONArray.optJSONObject(length - 1));
    }

    private List<WalkingRouteLine.WalkingStep> c(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                WalkingRouteLine.WalkingStep walkingStep = new WalkingRouteLine.WalkingStep();
                walkingStep.setDirection(jSONObjectOptJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                walkingStep.setDistance(jSONObjectOptJSONObject.optInt(SchoolActivitySuccessActivity.x));
                walkingStep.setDuration(jSONObjectOptJSONObject.optInt("duration"));
                walkingStep.setEntrance(RouteNode.location(a(jSONObjectOptJSONObject, "sstart_location")));
                walkingStep.setExit(RouteNode.location(a(jSONObjectOptJSONObject, "send_location")));
                String strOptString = jSONObjectOptJSONObject.optString("instructions");
                if (strOptString.length() >= 4) {
                    strOptString = strOptString.replaceAll("</?[a-z]>", "");
                }
                walkingStep.setInstructions(strOptString);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("spath");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = (jSONArrayOptJSONArray.length() - 5) >> 1;
                    int iOptInt = 0;
                    int iOptInt2 = 0;
                    for (int i2 = 0; i2 < length2; i2++) {
                        int i3 = i2 << 1;
                        iOptInt2 += jSONArrayOptJSONArray.optInt(i3 + 6);
                        iOptInt += jSONArrayOptJSONArray.optInt(i3 + 5);
                        arrayList2.add(CoordUtil.mc2ll(new GeoPoint(iOptInt2, iOptInt)));
                    }
                    walkingStep.setWayPoints(arrayList2);
                }
                arrayList.add(walkingStep);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        IntegralRouteResult integralRouteResult = new IntegralRouteResult();
        if (str == null || str.equals("")) {
            integralRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return integralRouteResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    integralRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return integralRouteResult;
                }
                if (jSONObjectOptJSONObject.has("NO_ADVANCED_PERMISSION")) {
                    integralRouteResult.error = SearchResult.ERRORNO.NO_ADVANCED_PERMISSION;
                    return integralRouteResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        integralRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        integralRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        integralRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return integralRouteResult;
                }
            }
            if (!a(str, integralRouteResult)) {
                integralRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return integralRouteResult;
        } catch (Exception unused) {
            integralRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return integralRouteResult;
        }
    }

    private LatLng b(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(0, 0);
        geoPoint.setLatitudeE6((int) jSONArrayOptJSONArray.optDouble(1));
        geoPoint.setLongitudeE6((int) jSONArrayOptJSONArray.optDouble(0));
        return CoordUtil.mc2ll(geoPoint);
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj instanceof OnGetRoutePlanResultListener) {
            ((OnGetRoutePlanResultListener) obj).onGetIntegralRouteResult((IntegralRouteResult) searchResult);
        }
    }

    private boolean a(String str, IntegralRouteResult integralRouteResult) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray2;
        JSONArray jSONArrayOptJSONArray3;
        JSONArray jSONArray;
        RouteNode routeNode;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (integralRouteResult == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("result")) == null) {
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("error");
            if (iOptInt != 0) {
                if (iOptInt != 4) {
                    return false;
                }
                integralRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                return true;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("walk_plan");
            if (jSONObjectOptJSONObject3 == null) {
                return false;
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("routes");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("option");
            JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject3.optJSONArray("indoor_navis");
            if (jSONObjectOptJSONObject4 == null || (jSONArrayOptJSONArray4 == null && jSONArrayOptJSONArray5 == null)) {
                return false;
            }
            if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 1 && jSONArrayOptJSONArray4 != null) {
                integralRouteResult.error = SearchResult.ERRORNO.INTEGRAL_ROUTE_NOT_SUPPORT_MULTIPLE_INDOOR;
                return true;
            }
            if (jSONArrayOptJSONArray4 != null) {
                RouteNode routeNodeA = a(jSONObjectOptJSONObject4.optJSONObject("start"));
                RouteNode routeNodeB = b(jSONObjectOptJSONObject4.optJSONArray("end"));
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(0);
                if (jSONObjectOptJSONObject5 != null && (jSONArrayOptJSONArray3 = jSONObjectOptJSONObject5.optJSONArray("legs")) != null && jSONArrayOptJSONArray3.length() > 0) {
                    int i = 0;
                    while (i < jSONArrayOptJSONArray3.length()) {
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i);
                        if (jSONObjectOptJSONObject6 == null) {
                            jSONArray = jSONArrayOptJSONArray3;
                            routeNode = routeNodeB;
                        } else {
                            WalkingRouteLine walkingRouteLine = new WalkingRouteLine();
                            walkingRouteLine.setStarting(routeNodeA);
                            walkingRouteLine.setTerminal(routeNodeB);
                            walkingRouteLine.setDistance(jSONObjectOptJSONObject6.optInt(SchoolActivitySuccessActivity.x));
                            walkingRouteLine.setDuration(jSONObjectOptJSONObject6.optInt("duration"));
                            walkingRouteLine.setSteps(c(jSONObjectOptJSONObject6.optJSONArray("steps")));
                            JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject6.optJSONObject("leg_linked");
                            if (jSONObjectOptJSONObject7 != null) {
                                com.baidu.mapapi.search.core.a aVar = new com.baidu.mapapi.search.core.a();
                                jSONArray = jSONArrayOptJSONArray3;
                                routeNode = routeNodeB;
                                aVar.a(jSONObjectOptJSONObject7.optInt("next", -1));
                                aVar.b(jSONObjectOptJSONObject7.optInt("priv", -1));
                                if (aVar.a() != -1 || aVar.b() != -1) {
                                    walkingRouteLine.setLegLinked(aVar);
                                }
                            } else {
                                jSONArray = jSONArrayOptJSONArray3;
                                routeNode = routeNodeB;
                            }
                            arrayList.add(walkingRouteLine);
                        }
                        i++;
                        jSONArrayOptJSONArray3 = jSONArray;
                        routeNodeB = routeNode;
                    }
                }
                integralRouteResult.setRouteLines(arrayList);
            }
            if (jSONArrayOptJSONArray5 == null) {
                return true;
            }
            ArrayList arrayList2 = new ArrayList();
            JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray5.optJSONObject(0);
            if (jSONObjectOptJSONObject8 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject8.optJSONArray("routes")) != null && (jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(0)) != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("legs")) != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    IndoorRouteLine indoorRouteLine = new IndoorRouteLine();
                    JSONObject jSONObjectOptJSONObject9 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject9 != null) {
                        indoorRouteLine.setDistance(jSONObjectOptJSONObject9.optInt(SchoolActivitySuccessActivity.x));
                        indoorRouteLine.setDuration(jSONObjectOptJSONObject9.optInt("duration"));
                        indoorRouteLine.setStarting(RouteNode.location(b(jSONObjectOptJSONObject9, "sstart_location")));
                        indoorRouteLine.setTerminal(RouteNode.location(b(jSONObjectOptJSONObject9, "send_location")));
                        indoorRouteLine.setSteps(a(jSONObjectOptJSONObject9.optJSONArray("steps")));
                        arrayList2.add(indoorRouteLine);
                    }
                }
            }
            if (arrayList2.size() <= 0) {
                return true;
            }
            integralRouteResult.setIndoorRouteLines(arrayList2);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<IndoorRouteLine.IndoorRouteStep> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            IndoorRouteLine.IndoorRouteStep indoorRouteStep = new IndoorRouteLine.IndoorRouteStep();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                indoorRouteStep.setDistance(jSONObjectOptJSONObject.optInt(SchoolActivitySuccessActivity.x));
                indoorRouteStep.setDuration(jSONObjectOptJSONObject.optInt("duration"));
                indoorRouteStep.setBuildingId(jSONObjectOptJSONObject.optString("buildingid"));
                indoorRouteStep.setFloorId(jSONObjectOptJSONObject.optString("floorid"));
                indoorRouteStep.setEntrace(RouteNode.location(b(jSONObjectOptJSONObject, "sstart_location")));
                indoorRouteStep.setExit(RouteNode.location(b(jSONObjectOptJSONObject, "send_location")));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("spath");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    int length = (jSONArrayOptJSONArray.length() - 5) >> 1;
                    double dOptDouble = AudioStats.AUDIO_AMPLITUDE_NONE;
                    int i3 = i;
                    double d = 0.0d;
                    while (i3 < length) {
                        int i4 = i3 << 1;
                        double dOptDouble2 = d + jSONArrayOptJSONArray.optDouble(i4 + 6);
                        dOptDouble += jSONArrayOptJSONArray.optDouble(i4 + 5);
                        GeoPoint geoPoint = new GeoPoint(i, i);
                        geoPoint.setLatitudeE6((int) dOptDouble2);
                        geoPoint.setLongitudeE6((int) dOptDouble);
                        LatLng latLngMc2ll = CoordUtil.mc2ll(geoPoint);
                        arrayList2.add(Double.valueOf(latLngMc2ll.latitude));
                        arrayList2.add(Double.valueOf(latLngMc2ll.longitude));
                        i3++;
                        d = dOptDouble2;
                        i = 0;
                    }
                    indoorRouteStep.setPath(arrayList2);
                    indoorRouteStep.setInstructions(jSONObjectOptJSONObject.optString("instructions"));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("pois");
                    if (jSONArrayOptJSONArray2 != null) {
                        ArrayList arrayList3 = new ArrayList();
                        for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i5);
                            if (jSONObjectOptJSONObject2 != null) {
                                IndoorRouteLine.IndoorRouteStep.IndoorStepNode indoorStepNode = new IndoorRouteLine.IndoorRouteStep.IndoorStepNode();
                                indoorStepNode.setDetail(jSONObjectOptJSONObject2.optString("detail"));
                                indoorStepNode.setName(jSONObjectOptJSONObject2.optString("name"));
                                indoorStepNode.setType(jSONObjectOptJSONObject2.optInt("type"));
                                indoorStepNode.setLocation(b(jSONObjectOptJSONObject2, RequestParameters.SUBRESOURCE_LOCATION));
                                arrayList3.add(indoorStepNode);
                            }
                        }
                        indoorRouteStep.setStepNodes(arrayList3);
                    }
                    arrayList.add(indoorRouteStep);
                }
            }
            i2++;
            i = 0;
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    private RouteNode a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObject.optString(AliyunLogKey.KEY_WIDTH));
        routeNode.setUid(jSONObject.optString(UserConstants.URL_PARAMS.b));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("spt");
        if (jSONArrayOptJSONArray != null) {
            routeNode.setLocation(CoordUtil.mc2ll(new GeoPoint(jSONArrayOptJSONArray.optInt(1), jSONArrayOptJSONArray.optInt(0))));
        }
        return routeNode;
    }

    private LatLng a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        return a(new LatLng(jSONArrayOptJSONArray.optDouble(1) / 100000.0d, jSONArrayOptJSONArray.optDouble(0) / 100000.0d));
    }

    private LatLng a(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? latLng : CoordTrans.gcjToBaidu(latLng);
    }
}
