package com.baidu.platform.core.route;

import androidx.camera.video.AudioStats;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
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
public class c extends l {
    private boolean b(String str, DrivingRouteResult drivingRouteResult) {
        boolean z = false;
        if (str == null || "".equals(str)) {
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
                if (iOptInt != 4) {
                    return false;
                }
                drivingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                return true;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("cars");
            if (jSONObjectOptJSONObject2 == null) {
                return false;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("option");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("content");
            if (jSONObjectOptJSONObject3 == null || jSONObjectOptJSONObject4 == null) {
                return false;
            }
            RouteNode routeNodeB = b(jSONObjectOptJSONObject3.optJSONObject("start"));
            ArrayList arrayList = new ArrayList();
            RouteNode routeNodeA = a(jSONObjectOptJSONObject3.optJSONArray("end"), arrayList);
            List<DrivingRouteLine.DrivingStep> listA = a(jSONObjectOptJSONObject4.optJSONArray("steps"), jSONObjectOptJSONObject4.optJSONArray("stepts"));
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("routes");
            if (jSONArrayOptJSONArray == null) {
                return false;
            }
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                DrivingRouteLine drivingRouteLine = new DrivingRouteLine();
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject5 != null) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject5.optJSONArray("legs");
                    if (jSONArrayOptJSONArray2 == null) {
                        return z;
                    }
                    int length = jSONArrayOptJSONArray2.length();
                    ArrayList arrayList3 = new ArrayList();
                    int iOptInt2 = 0;
                    int i2 = 0;
                    int iOptInt3 = 0;
                    while (i2 < length) {
                        int i3 = length;
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        JSONArray jSONArray = jSONArrayOptJSONArray2;
                        if (jSONObjectOptJSONObject6 != null) {
                            iOptInt2 += jSONObjectOptJSONObject6.optInt(SchoolActivitySuccessActivity.x);
                            iOptInt3 += jSONObjectOptJSONObject6.optInt("duration");
                            List<DrivingRouteLine.DrivingStep> listB = b(jSONObjectOptJSONObject6.optJSONArray("stepis"), listA);
                            if (listB != null) {
                                arrayList3.addAll(listB);
                            }
                        }
                        i2++;
                        length = i3;
                        jSONArrayOptJSONArray2 = jSONArray;
                    }
                    drivingRouteLine.setStarting(routeNodeB);
                    drivingRouteLine.setTerminal(routeNodeA);
                    if (arrayList.size() == 0) {
                        drivingRouteLine.setWayPoints(null);
                    } else {
                        drivingRouteLine.setWayPoints(arrayList);
                    }
                    drivingRouteLine.setDistance(iOptInt2);
                    drivingRouteLine.setDuration(iOptInt3);
                    drivingRouteLine.setCongestionDistance(jSONObjectOptJSONObject5.optInt("congestion_length"));
                    drivingRouteLine.setLightNum(jSONObjectOptJSONObject5.optInt("light_num"));
                    drivingRouteLine.setToll(jSONObjectOptJSONObject5.optInt("toll"));
                    if (arrayList3.size() == 0) {
                        drivingRouteLine.setSteps(null);
                    } else {
                        drivingRouteLine.setSteps(arrayList3);
                    }
                    arrayList2.add(drivingRouteLine);
                }
                i++;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                jSONObjectOptJSONObject4 = jSONObjectOptJSONObject4;
                z = false;
            }
            drivingRouteResult.setRouteLines(arrayList2);
            drivingRouteResult.setTaxiInfos(c(jSONObjectOptJSONObject4.optString("taxis")));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<TaxiInfo> c(String str) {
        if (str != null && str.length() > 0) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        TaxiInfo taxiInfo = new TaxiInfo();
                        String strOptString = jSONObject.optString("total_price");
                        if (strOptString == null || strOptString.equals("")) {
                            taxiInfo.setTotalPrice(0.0f);
                        } else {
                            taxiInfo.setTotalPrice(Float.parseFloat(strOptString));
                        }
                        arrayList.add(taxiInfo);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                if (Logger.debugEnable()) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void a(String str, DrivingRouteResult drivingRouteResult) {
        if (str == null || str.equals("")) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    drivingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        return;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        return;
                    } else {
                        drivingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
            }
            if (a(str, drivingRouteResult, false) || b(str, drivingRouteResult)) {
                return;
            }
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } catch (Exception unused) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }

    private int[] c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("end");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("status");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        int length2 = jSONArrayOptJSONArray2.length();
        int i = 0;
        while (i < length) {
            int iOptInt = jSONArrayOptJSONArray.optInt(i);
            int iOptInt2 = i < length2 ? jSONArrayOptJSONArray2.optInt(i) : 0;
            for (int i2 = 0; i2 < iOptInt; i2++) {
                arrayList.add(Integer.valueOf(iOptInt2));
            }
            i++;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr;
    }

    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    RouteNode routeNodeB = b(jSONObjectOptJSONObject);
                    if (i == length - 1) {
                        return routeNodeB;
                    }
                    list.add(routeNodeB);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:0x002d  */
    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    /* JADX WARN: Code duplicated, block: B:27:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    /* JADX WARN: Code duplicated, block: B:30:0x0098  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:37:0x0111  */
    /* JADX WARN: Code duplicated, block: B:38:0x013a  */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0081, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x0098, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00bd, please report this as an issue */
    private List<DrivingRouteLine.DrivingStep> a(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        int length2;
        boolean z;
        ArrayList arrayList;
        int i;
        int i2;
        JSONObject jSONObjectOptJSONObject;
        DrivingRouteLine.DrivingStep drivingStep;
        String strOptString;
        String strOptString2;
        List<LatLng> listB;
        int distance;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        if (jSONArray2 != null) {
            length2 = jSONArray2.length();
            if (length2 > 0) {
                z = true;
            }
            arrayList = new ArrayList();
            i2 = 0;
            for (i = 0; i < length; i++) {
                jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject == null) {
                    drivingStep = new DrivingRouteLine.DrivingStep();
                    drivingStep.setDistance(jSONObjectOptJSONObject.optInt(SchoolActivitySuccessActivity.x));
                    drivingStep.setDirection(jSONObjectOptJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION) * 30);
                    strOptString = jSONObjectOptJSONObject.optString("instructions");
                    if (strOptString != null && strOptString.length() >= 4) {
                        strOptString = strOptString.replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
                    }
                    drivingStep.setInstructions(strOptString);
                    strOptString2 = jSONObjectOptJSONObject.optString("start_instructions");
                    if (strOptString2 == null) {
                        distance = drivingStep.getDistance();
                        if (distance < 1000) {
                            strOptString2 = " - " + distance + "米";
                        } else {
                            strOptString2 = " - " + (((double) distance) / 1000.0d) + "公里";
                        }
                        if (i2 <= arrayList.size()) {
                            strOptString2 = ((DrivingRouteLine.DrivingStep) arrayList.get(i2 - 1)).getExitInstructions() + strOptString2;
                        }
                    } else {
                        length2 = length2;
                    }
                    drivingStep.setEntranceInstructions(strOptString2);
                    drivingStep.setExitInstructions(jSONObjectOptJSONObject.optString("end_instructions"));
                    drivingStep.setNumTurns(jSONObjectOptJSONObject.optInt("turn"));
                    drivingStep.setRoadLevel(jSONObjectOptJSONObject.optInt("road_level"));
                    drivingStep.setRoadName(jSONObjectOptJSONObject.optString("road_name"));
                    listB = b(jSONObjectOptJSONObject.optJSONArray("spath"));
                    drivingStep.setPathList(listB);
                    if (listB != null) {
                        RouteNode routeNode = new RouteNode();
                        routeNode.setLocation(listB.get(0));
                        drivingStep.setEntrance(routeNode);
                        RouteNode routeNode2 = new RouteNode();
                        routeNode2.setLocation(listB.get(listB.size() - 1));
                        drivingStep.setExit(routeNode2);
                    }
                    length2 = length2;
                    if (z && i < length2) {
                        drivingStep.setTrafficList(c(jSONArray2.optJSONObject(i)));
                    }
                    i2++;
                    arrayList.add(drivingStep);
                }
            }
            return arrayList;
        }
        length2 = 0;
        z = false;
        arrayList = new ArrayList();
        i2 = 0;
        while (i < length) {
            jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                drivingStep = new DrivingRouteLine.DrivingStep();
                drivingStep.setDistance(jSONObjectOptJSONObject.optInt(SchoolActivitySuccessActivity.x));
                drivingStep.setDirection(jSONObjectOptJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION) * 30);
                strOptString = jSONObjectOptJSONObject.optString("instructions");
                if (strOptString != null) {
                    strOptString = strOptString.replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
                }
                drivingStep.setInstructions(strOptString);
                strOptString2 = jSONObjectOptJSONObject.optString("start_instructions");
                if (strOptString2 == null) {
                    distance = drivingStep.getDistance();
                    if (distance < 1000) {
                        strOptString2 = " - " + distance + "米";
                    } else {
                        strOptString2 = " - " + (((double) distance) / 1000.0d) + "公里";
                    }
                    if (i2 <= arrayList.size()) {
                        strOptString2 = ((DrivingRouteLine.DrivingStep) arrayList.get(i2 - 1)).getExitInstructions() + strOptString2;
                    }
                } else {
                    length2 = length2;
                }
                drivingStep.setEntranceInstructions(strOptString2);
                drivingStep.setExitInstructions(jSONObjectOptJSONObject.optString("end_instructions"));
                drivingStep.setNumTurns(jSONObjectOptJSONObject.optInt("turn"));
                drivingStep.setRoadLevel(jSONObjectOptJSONObject.optInt("road_level"));
                drivingStep.setRoadName(jSONObjectOptJSONObject.optString("road_name"));
                listB = b(jSONObjectOptJSONObject.optJSONArray("spath"));
                drivingStep.setPathList(listB);
                if (listB != null) {
                    RouteNode routeNode3 = new RouteNode();
                    routeNode3.setLocation(listB.get(0));
                    drivingStep.setEntrance(routeNode3);
                    RouteNode routeNode4 = new RouteNode();
                    routeNode4.setLocation(listB.get(listB.size() - 1));
                    drivingStep.setExit(routeNode4);
                }
                length2 = length2;
                if (z) {
                    drivingStep.setTrafficList(c(jSONArray2.optJSONObject(i)));
                }
                i2++;
                arrayList.add(drivingStep);
            }
        }
        return arrayList;
    }

    private RouteNode b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObject.optString(AliyunLogKey.KEY_WIDTH));
        routeNode.setUid(jSONObject.optString(UserConstants.URL_PARAMS.b));
        GeoPoint geoPoint = new GeoPoint(0, 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("spt");
        if (jSONArrayOptJSONArray != null) {
            geoPoint.setLongitudeE6(jSONArrayOptJSONArray.optInt(0));
            geoPoint.setLatitudeE6(jSONArrayOptJSONArray.optInt(1));
        }
        routeNode.setLocation(CoordUtil.mc2ll(geoPoint));
        return routeNode;
    }

    private List<LatLng> b(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) < 6) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        double dOptInt = AudioStats.AUDIO_AMPLITUDE_NONE;
        double dOptInt2 = 0.0d;
        for (int i = 5; i < length; i++) {
            if (i % 2 != 0) {
                dOptInt2 += (double) jSONArray.optInt(i);
            } else {
                dOptInt += (double) jSONArray.optInt(i);
                arrayList.add(CoordUtil.mc2ll(new GeoPoint(dOptInt, dOptInt2)));
            }
        }
        return arrayList;
    }

    private List<DrivingRouteLine.DrivingStep> b(JSONArray jSONArray, List<DrivingRouteLine.DrivingStep> list) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0 || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("n");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("s");
                for (int i2 = 0; i2 < iOptInt; i2++) {
                    int i3 = iOptInt2 + i2;
                    if (i3 < list.size()) {
                        arrayList.add(list.get(i3));
                    }
                }
            }
        }
        return arrayList;
    }
}
