package com.baidu.platform.core.building;

import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.building.BuildingResult;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.b {
    private static final String b = "a";

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        BuildingResult buildingResult = new BuildingResult();
        if (str == null || str.isEmpty()) {
            buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return buildingResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return buildingResult;
            }
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    buildingResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return buildingResult;
                }
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    strOptString.hashCode();
                    if (strOptString.equals("NETWORK_ERROR")) {
                        buildingResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        buildingResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        buildingResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return buildingResult;
                }
            }
            if (!a(str, buildingResult, true)) {
                a(str, buildingResult);
            }
            return buildingResult;
        } catch (JSONException e) {
            Log.e(b, "ParseBuidingResult: ", e);
            buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return buildingResult;
        }
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj instanceof OnGetBuildingSearchResultListener) {
            ((OnGetBuildingSearchResultListener) obj).onGetBuildingResult((BuildingResult) searchResult);
        }
    }

    private boolean a(String str, BuildingResult buildingResult) {
        int i = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            int iOptInt = jSONObject.optInt("status");
            if (iOptInt == 0) {
                if ("in".equals(jSONObject.optString("relation"))) {
                    i = 1;
                } else {
                    buildingResult.setDistance(jSONObject.optDouble(SchoolActivitySuccessActivity.x, AudioStats.AUDIO_AMPLITUDE_NONE));
                }
                buildingResult.setRelation(i);
                return a(jSONObject, buildingResult);
            }
            if (iOptInt == 1) {
                buildingResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            } else if (iOptInt != 2) {
                buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            } else {
                buildingResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
            }
            return false;
        } catch (JSONException e) {
            Log.e(b, "ParseBuidingResult error: ", e);
            buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, BuildingResult buildingResult) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buildinginfo");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i);
            if (jSONObject2 != null) {
                BuildingInfo buildingInfo = new BuildingInfo();
                float fOptLong = jSONObject2.optLong("height");
                buildingInfo.setLabel(jSONObject2.optString("label").equals("main") ? 1 : 0);
                buildingInfo.setStructID(jSONObject2.optString("struct_id"));
                buildingInfo.setHeight(fOptLong);
                buildingInfo.setAccuracy(jSONObject2.optInt("accuracy"));
                buildingInfo.setGeom(jSONObject2.optString("geom"));
                buildingInfo.setCenter(a(jSONObject2));
                arrayList.add(buildingInfo);
            }
        }
        buildingResult.setBuildingList(arrayList);
        return true;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("center");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String[] strArrSplit = strOptString.split(",");
        if (strArrSplit.length != 2) {
            return null;
        }
        return new LatLng(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
    }
}
