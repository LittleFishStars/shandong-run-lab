package com.baidu.platform.core.poi;

import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.platform.base.b {
    private static final String b = "c";
    private boolean c = false;

    public void a(boolean z) {
        this.c = z;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        SearchResult poiDetailSearchResult = this.c ? new PoiDetailSearchResult() : new PoiDetailResult();
        if (str == null || str.isEmpty()) {
            poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiDetailSearchResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiDetailSearchResult;
            }
            if (!jSONObject.has("SDK_InnerError")) {
                if (!a(str, poiDetailSearchResult)) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return poiDetailSearchResult;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() == 0) {
                poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiDetailSearchResult;
            }
            if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                poiDetailSearchResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                return poiDetailSearchResult;
            }
            if (jSONObjectOptJSONObject.has("httpStateError")) {
                String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                strOptString.hashCode();
                if (strOptString.equals("NETWORK_ERROR")) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                } else if (strOptString.equals("REQUEST_ERROR")) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                } else {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                }
            }
            return poiDetailSearchResult;
        } catch (JSONException e) {
            Log.e(b, "Parse detail search result failed", e);
            poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiDetailSearchResult;
        }
    }

    private boolean a(String str, SearchResult searchResult) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0 || jSONObject.optInt("status") != 0 || (jSONArrayOptJSONArray = jSONObject.optJSONArray("result")) == null || jSONArrayOptJSONArray.length() == 0) {
                return false;
            }
            if (this.c) {
                return a(jSONArrayOptJSONArray, (PoiDetailSearchResult) searchResult);
            }
            return a(jSONArrayOptJSONArray, (PoiDetailResult) searchResult);
        } catch (JSONException e) {
            Log.e(b, "Parse detail search result error", e);
            return false;
        }
    }

    private boolean a(JSONArray jSONArray, PoiDetailSearchResult poiDetailSearchResult) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null && jSONObject.length() != 0) {
                PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
                poiDetailInfo.setName(jSONObject.optString("name"));
                poiDetailInfo.setLocation(a(jSONObject.optJSONObject(RequestParameters.SUBRESOURCE_LOCATION)));
                poiDetailInfo.setAddress(jSONObject.optString("address"));
                poiDetailInfo.setAdCode(jSONObject.optInt("adcode"));
                poiDetailInfo.setProvince(jSONObject.optString("province"));
                poiDetailInfo.setCity(jSONObject.optString("city"));
                poiDetailInfo.setArea(jSONObject.optString("area"));
                poiDetailInfo.setTelephone(jSONObject.optString("telephone"));
                poiDetailInfo.setUid(jSONObject.optString(UserConstants.URL_PARAMS.b));
                poiDetailInfo.setStreetId(jSONObject.optString("setStreetId"));
                poiDetailInfo.setDetail(jSONObject.optString("detail"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("detail_info");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                    poiDetailInfo.setDistance(jSONObjectOptJSONObject.optInt(SchoolActivitySuccessActivity.x, 0));
                    poiDetailInfo.setType(jSONObjectOptJSONObject.optString("type"));
                    poiDetailInfo.setTag(jSONObjectOptJSONObject.optString("tag"));
                    poiDetailInfo.setDetailUrl(jSONObjectOptJSONObject.optString("detail_url"));
                    poiDetailInfo.setPrice(jSONObjectOptJSONObject.optDouble("price", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setShopHours(jSONObjectOptJSONObject.optString("shop_hours"));
                    poiDetailInfo.setOverallRating(jSONObjectOptJSONObject.optDouble("overall_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setTasteRating(jSONObjectOptJSONObject.optDouble("taste_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setServiceRating(jSONObjectOptJSONObject.optDouble("service_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setEnvironmentRating(jSONObjectOptJSONObject.optDouble("environment_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setFacilityRating(jSONObjectOptJSONObject.optDouble("facility_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setHygieneRating(jSONObjectOptJSONObject.optDouble("hygiene_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setTechnologyRating(jSONObjectOptJSONObject.optDouble("technology_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
                    poiDetailInfo.setImageNum(jSONObjectOptJSONObject.optInt("image_num"));
                    poiDetailInfo.setGrouponNum(jSONObjectOptJSONObject.optInt("groupon_num", 0));
                    poiDetailInfo.setCommentNum(jSONObjectOptJSONObject.optInt("comment_num", 0));
                    poiDetailInfo.setDiscountNum(jSONObjectOptJSONObject.optInt("discount_num", 0));
                    poiDetailInfo.setFavoriteNum(jSONObjectOptJSONObject.optInt("favorite_num", 0));
                    poiDetailInfo.setCheckinNum(jSONObjectOptJSONObject.optInt("checkin_num", 0));
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("photos");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            if (!TextUtils.isEmpty(jSONArrayOptJSONArray.optString(i2))) {
                                arrayList2.add(jSONArrayOptJSONArray.optString(i2));
                            }
                        }
                        poiDetailInfo.setPhotos(arrayList2);
                    }
                }
                arrayList.add(poiDetailInfo);
            }
        }
        poiDetailSearchResult.setPoiDetailInfoList(arrayList);
        poiDetailSearchResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private boolean a(JSONArray jSONArray, PoiDetailResult poiDetailResult) {
        JSONObject jSONObject = (JSONObject) jSONArray.opt(0);
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        poiDetailResult.setName(jSONObject.optString("name"));
        poiDetailResult.setLocation(a(jSONObject.optJSONObject(RequestParameters.SUBRESOURCE_LOCATION)));
        poiDetailResult.setAddress(jSONObject.optString("address"));
        poiDetailResult.setTelephone(jSONObject.optString("telephone"));
        poiDetailResult.setUid(jSONObject.optString(UserConstants.URL_PARAMS.b));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("detail_info");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
            poiDetailResult.setTag(jSONObjectOptJSONObject.optString("tag"));
            poiDetailResult.setDetailUrl(jSONObjectOptJSONObject.optString("detail_url"));
            poiDetailResult.setType(jSONObjectOptJSONObject.optString("type"));
            poiDetailResult.setPrice(jSONObjectOptJSONObject.optDouble("price", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setOverallRating(jSONObjectOptJSONObject.optDouble("overall_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setTasteRating(jSONObjectOptJSONObject.optDouble("taste_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setServiceRating(jSONObjectOptJSONObject.optDouble("service_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setEnvironmentRating(jSONObjectOptJSONObject.optDouble("environment_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setFacilityRating(jSONObjectOptJSONObject.optDouble("facility_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setHygieneRating(jSONObjectOptJSONObject.optDouble("hygiene_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setTechnologyRating(jSONObjectOptJSONObject.optDouble("technology_rating", AudioStats.AUDIO_AMPLITUDE_NONE));
            poiDetailResult.setImageNum(jSONObjectOptJSONObject.optInt("image_num"));
            poiDetailResult.setGrouponNum(jSONObjectOptJSONObject.optInt("groupon_num", 0));
            poiDetailResult.setCommentNum(jSONObjectOptJSONObject.optInt("comment_num", 0));
            poiDetailResult.setDiscountNum(jSONObjectOptJSONObject.optInt("discount_num", 0));
            poiDetailResult.setFavoriteNum(jSONObjectOptJSONObject.optInt("favorite_num", 0));
            poiDetailResult.setCheckinNum(jSONObjectOptJSONObject.optInt("checkin_num", 0));
            poiDetailResult.setShopHours(jSONObjectOptJSONObject.optString("shop_hours"));
        }
        poiDetailResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
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
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        if (this.c) {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailSearchResult) searchResult);
        } else {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailResult) searchResult);
        }
    }
}
