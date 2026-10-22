package com.baidu.platform.core.sug;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huachenjie.common.constants.UserConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.b {
    private static final String b = "b";

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        SuggestionResult suggestionResult = new SuggestionResult();
        if (str == null || str.isEmpty()) {
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return suggestionResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return suggestionResult;
            }
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    suggestionResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return suggestionResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    strOptString.hashCode();
                    if (strOptString.equals("NETWORK_ERROR")) {
                        suggestionResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        suggestionResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        suggestionResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return suggestionResult;
                }
            }
            if (!a(str, suggestionResult, false)) {
                a(str, suggestionResult);
            }
            return suggestionResult;
        } catch (JSONException e) {
            Log.e(b, "Parse suggestion search result error", e);
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return suggestionResult;
        }
    }

    private boolean a(String str, SuggestionResult suggestionResult) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            int iOptInt = jSONObject.optInt("status");
            if (iOptInt == 0) {
                return a(jSONObject, suggestionResult);
            }
            if (iOptInt == 1) {
                suggestionResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            } else if (iOptInt != 2) {
                suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            } else {
                suggestionResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
            }
            return false;
        } catch (JSONException e) {
            Log.e(b, "Parse sug search error", e);
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, SuggestionResult suggestionResult) {
        if (jSONObject != null && jSONObject.length() != 0) {
            suggestionResult.error = SearchResult.ERRORNO.NO_ERROR;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                ArrayList<SuggestionResult.SuggestionInfo> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i);
                    if (jSONObject2 != null && jSONObject2.length() != 0) {
                        SuggestionResult.SuggestionInfo suggestionInfo = new SuggestionResult.SuggestionInfo();
                        suggestionInfo.setKey(jSONObject2.optString("name"));
                        suggestionInfo.setAdCode(jSONObject2.optInt("adcode"));
                        suggestionInfo.setCity(jSONObject2.optString("city"));
                        suggestionInfo.setDistrict(jSONObject2.optString("district"));
                        suggestionInfo.setUid(jSONObject2.optString(UserConstants.URL_PARAMS.b));
                        suggestionInfo.setTag(jSONObject2.optString("tag"));
                        suggestionInfo.setAddress(jSONObject2.optString("address"));
                        suggestionInfo.setPt(a(jSONObject2.optJSONObject(RequestParameters.SUBRESOURCE_LOCATION)));
                        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("children");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
                            suggestionInfo.setPoiChildrenInfoList(a(jSONArrayOptJSONArray2));
                        }
                        arrayList.add(suggestionInfo);
                    }
                }
                suggestionResult.setSuggestionInfo(arrayList);
                return true;
            }
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
        return false;
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

    private List<PoiChildrenInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                poiChildrenInfo.setUid(jSONObjectOptJSONObject.optString(UserConstants.URL_PARAMS.b));
                poiChildrenInfo.setName(jSONObjectOptJSONObject.optString("name"));
                poiChildrenInfo.setShowName(jSONObjectOptJSONObject.optString("show_name"));
                poiChildrenInfo.setTag(jSONObjectOptJSONObject.optString("tag"));
                poiChildrenInfo.setAddress(jSONObjectOptJSONObject.optString("address"));
                arrayList.add(poiChildrenInfo);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetSuggestionResultListener)) {
            return;
        }
        ((OnGetSuggestionResultListener) obj).onGetSuggestionResult((SuggestionResult) searchResult);
    }
}
