package com.baidu.platform.core.busline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.busline.BusLineResult;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.mapapi.search.core.SearchResult;
import com.huachenjie.common.constants.UserConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.b {
    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        BusLineResult busLineResult = new BusLineResult();
        if (str == null || str.equals("")) {
            busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return busLineResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    busLineResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return busLineResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        busLineResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        busLineResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        busLineResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return busLineResult;
                }
            }
            if (!a(str, busLineResult, false) && !a(str, busLineResult)) {
                busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return busLineResult;
        } catch (Exception unused) {
            busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return busLineResult;
        }
    }

    public boolean a(String str, BusLineResult busLineResult) {
        JSONArray jSONArrayOptJSONArray;
        if (str != null && !"".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("bsl");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("content")) == null || jSONArrayOptJSONArray.length() <= 0) {
                    return false;
                }
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                try {
                    busLineResult.setStartTime(simpleDateFormat.parse(jSONObjectOptJSONObject3.optString("startTime")));
                    busLineResult.setEndTime(simpleDateFormat.parse(jSONObjectOptJSONObject3.optString("endTime")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                busLineResult.setBusLineName(jSONObjectOptJSONObject3.optString("name"));
                busLineResult.setMonthTicket(jSONObjectOptJSONObject3.optInt("isMonTicket") == 1);
                busLineResult.setUid(jSONObjectOptJSONObject3.optString(UserConstants.URL_PARAMS.b));
                busLineResult.setBasePrice(jSONObjectOptJSONObject3.optInt("ticketPrice") / 100.0f);
                busLineResult.setLineDirection(jSONObjectOptJSONObject3.optString("line_direction"));
                busLineResult.setMaxPrice(jSONObjectOptJSONObject3.optInt("maxPrice") / 100.0f);
                ArrayList arrayList = new ArrayList();
                List<List<LatLng>> listDecodeLocationList2D = CoordUtil.decodeLocationList2D(jSONObjectOptJSONObject3.optString("geo"));
                if (listDecodeLocationList2D != null) {
                    for (List<LatLng> list : listDecodeLocationList2D) {
                        BusLineResult.BusStep busStep = new BusLineResult.BusStep();
                        busStep.setWayPoints(list);
                        arrayList.add(busStep);
                    }
                }
                if (arrayList.size() > 0) {
                    busLineResult.setSteps(arrayList);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("stations");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i);
                        if (jSONObjectOptJSONObject4 != null) {
                            BusLineResult.BusStation busStation = new BusLineResult.BusStation();
                            busStation.setTitle(jSONObjectOptJSONObject4.optString("name"));
                            busStation.setLocation(CoordUtil.decodeLocation(jSONObjectOptJSONObject4.optString("geo")));
                            busStation.setUid(jSONObjectOptJSONObject4.optString(UserConstants.URL_PARAMS.b));
                            arrayList2.add(busStation);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        busLineResult.setStations(arrayList2);
                    }
                }
                busLineResult.error = SearchResult.ERRORNO.NO_ERROR;
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetBusLineSearchResultListener)) {
            return;
        }
        ((OnGetBusLineSearchResultListener) obj).onGetBusLineResult((BusLineResult) searchResult);
    }
}
