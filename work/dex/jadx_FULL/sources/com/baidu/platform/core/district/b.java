package com.baidu.platform.core.district;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.huachenjie.common.constants.UserConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.b {
    boolean b = false;
    String c = null;

    private boolean b(String str, DistrictResult districtResult) {
        List<List<LatLng>> listDecodeLocationList2D;
        if (str != null && !str.equals("") && districtResult != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("content");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject.optInt("error") != 0) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (this.c != null) {
                    try {
                        listDecodeLocationList2D = CoordUtil.decodeLocationList2D(jSONObjectOptJSONObject2.optString("geo"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        listDecodeLocationList2D = null;
                    }
                } else {
                    listDecodeLocationList2D = null;
                }
                if (listDecodeLocationList2D != null) {
                    for (List<LatLng> list : listDecodeLocationList2D) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<LatLng> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(it.next());
                        }
                        arrayList.add(arrayList2);
                    }
                }
                if (arrayList.size() > 0) {
                    districtResult.setPolylines(arrayList);
                }
                districtResult.setCityName(this.c);
                districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                this.c = null;
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        DistrictResult districtResult = new DistrictResult();
        if (str == null || str.equals("")) {
            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return districtResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    districtResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return districtResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        districtResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        districtResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        districtResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return districtResult;
                }
            }
            if (!a(str, districtResult, false)) {
                if (this.b) {
                    b(str, districtResult);
                } else if (!a(str, districtResult)) {
                    districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            }
            return districtResult;
        } catch (Exception unused) {
            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return districtResult;
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    private boolean a(String str, DistrictResult districtResult) {
        JSONObject jSONObjectOptJSONObject;
        if (str != null && !"".equals(str) && districtResult != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("result");
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("city_result");
                if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject3 == null || jSONObjectOptJSONObject2.optInt("error") != 0 || (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("content")) == null) {
                    return false;
                }
                if (jSONObjectOptJSONObject.optJSONObject("sgeo") != null) {
                    districtResult.setCenterPt(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString("geo")));
                    districtResult.setCityCode(jSONObjectOptJSONObject.optInt("code"));
                    districtResult.setCityName(jSONObjectOptJSONObject.optString("cname"));
                    districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                }
                districtResult.setCityName(jSONObjectOptJSONObject.optString(UserConstants.URL_PARAMS.b));
                this.c = jSONObjectOptJSONObject.optString("cname");
                districtResult.setCenterPt(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString("geo")));
                districtResult.setCityCode(jSONObjectOptJSONObject.optInt("code"));
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetDistricSearchResultListener)) {
            return;
        }
        ((OnGetDistricSearchResultListener) obj).onGetDistrictResult((DistrictResult) searchResult);
    }
}
