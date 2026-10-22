package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.b {
    private static final String b = "b";
    private String c;

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        GeoCodeResult geoCodeResult = new GeoCodeResult();
        if (str == null || str.equals("")) {
            geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return geoCodeResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("SDK_InnerError")) {
                if (!a(str, geoCodeResult, false) && !a(str, geoCodeResult)) {
                    geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return geoCodeResult;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
            if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                geoCodeResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                return geoCodeResult;
            }
            if (!jSONObjectOptJSONObject.has("httpStateError")) {
                geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return geoCodeResult;
            }
            String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
            strOptString.hashCode();
            if (strOptString.equals("NETWORK_ERROR")) {
                geoCodeResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
            } else if (strOptString.equals("REQUEST_ERROR")) {
                geoCodeResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
                geoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
            return geoCodeResult;
        } catch (JSONException e) {
            Log.e(b, "JSONException caught", e);
            geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return geoCodeResult;
        }
    }

    public void b(String str) {
        this.c = str;
    }

    private boolean a(String str, GeoCodeResult geoCodeResult) {
        if (TextUtils.isEmpty(str) || geoCodeResult == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("status");
            if (iOptInt != 0) {
                if (iOptInt == 1) {
                    geoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                } else if (iOptInt != 2) {
                    geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                } else {
                    geoCodeResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                }
                return false;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
            if (jSONObjectOptJSONObject == null) {
                geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            geoCodeResult.setLocation(a(jSONObjectOptJSONObject.optJSONObject(RequestParameters.SUBRESOURCE_LOCATION)));
            geoCodeResult.setAddress(this.c);
            geoCodeResult.setPrecise(jSONObjectOptJSONObject.optInt("precise"));
            geoCodeResult.setConfidence(jSONObjectOptJSONObject.optInt("confidence"));
            geoCodeResult.setLevel(jSONObjectOptJSONObject.optString(com.alibaba.ariver.permission.b.b));
            geoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
            return true;
        } catch (JSONException e) {
            geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            Log.e(b, "Parse GeoCodeResult catch JSONException", e);
            return true;
        }
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double dOptDouble = jSONObject.optDouble("lat");
        double dOptDouble2 = jSONObject.optDouble("lng");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return CoordTrans.baiduToGcj(new LatLng(dOptDouble, dOptDouble2));
        }
        return new LatLng(dOptDouble, dOptDouble2);
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetGeoCoderResultListener)) {
            return;
        }
        ((OnGetGeoCoderResultListener) obj).onGetGeoCodeResult((GeoCodeResult) searchResult);
    }
}
