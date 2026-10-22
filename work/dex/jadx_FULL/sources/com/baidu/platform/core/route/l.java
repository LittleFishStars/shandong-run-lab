package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.SearchType;
import com.huachenjie.common.constants.UserConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class l extends com.baidu.platform.base.b {
    SuggestAddrInfo b = null;
    protected boolean c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26800a;

        static {
            int[] iArr = new int[SearchType.values().length];
            f26800a = iArr;
            try {
                iArr[SearchType.TRANSIT_ROUTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26800a[SearchType.DRIVE_ROUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26800a[SearchType.WALK_ROUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean b(String str) {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.optInt("type") != 23 || jSONObjectOptJSONObject.optInt("error") != 0) {
                    return false;
                }
                SuggestAddrInfo suggestAddrInfoA = a(jSONObject);
                this.b = suggestAddrInfoA;
                return suggestAddrInfoA != null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        SearchResult searchResult;
        SearchType searchTypeA = a();
        if (b(str)) {
            this.c = true;
        } else {
            this.c = false;
        }
        int i = a.f26800a[searchTypeA.ordinal()];
        if (i == 1) {
            TransitRouteResult transitRouteResult = new TransitRouteResult();
            if (this.c) {
                transitRouteResult.setSuggestAddrInfo(this.b);
                transitRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                searchResult = transitRouteResult;
            } else {
                ((m) this).b(str, transitRouteResult);
                searchResult = transitRouteResult;
            }
        } else if (i == 2) {
            DrivingRouteResult drivingRouteResult = new DrivingRouteResult();
            if (this.c) {
                drivingRouteResult.setSuggestAddrInfo(this.b);
                drivingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                searchResult = drivingRouteResult;
            } else {
                ((c) this).a(str, drivingRouteResult);
                searchResult = drivingRouteResult;
            }
        } else {
            if (i != 3) {
                return null;
            }
            WalkingRouteResult walkingRouteResult = new WalkingRouteResult();
            if (this.c) {
                walkingRouteResult.setSuggestAddrInfo(this.b);
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                searchResult = walkingRouteResult;
            } else {
                ((o) this).b(str, walkingRouteResult);
                searchResult = walkingRouteResult;
            }
        }
        return searchResult;
    }

    private List<List<CityInfo>> b(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            List<CityInfo> listA = a((JSONArray) jSONArrayOptJSONArray.opt(i));
            if (listA != null) {
                arrayList.add(listA);
            }
        }
        return arrayList;
    }

    private SuggestAddrInfo a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("traffic_pois")) == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("option");
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("content");
        if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject3 != null) {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("start_city");
            String strOptString = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString("cname") : null;
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("end_city");
            String strOptString2 = (jSONArrayOptJSONArray == null || (jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(0)) == null) ? null : jSONObject2.optString("cname");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("city_list");
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("prio_flag");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray3 != null) {
                int length = jSONArrayOptJSONArray2.length();
                boolean[] zArr = new boolean[length];
                boolean[] zArr2 = new boolean[length];
                for (int i = 0; i < length; i++) {
                    int i2 = Integer.parseInt(jSONArrayOptJSONArray2.optString(i));
                    int i3 = Integer.parseInt(jSONArrayOptJSONArray3.optString(i));
                    boolean z = true;
                    zArr[i] = i2 == 1;
                    if (i3 != 1) {
                        z = false;
                    }
                    zArr2[i] = z;
                }
                SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
                for (int i4 = 0; i4 < length; i4++) {
                    if (!zArr2[i4]) {
                        if (zArr[i4]) {
                            if (i4 == 0) {
                                suggestAddrInfo.setSuggestStartCity(a(jSONObjectOptJSONObject3.optJSONArray("start")));
                            } else if (i4 == length - 1 && i4 > 0) {
                                suggestAddrInfo.setSuggestEndCity(a(jSONObjectOptJSONObject3.optJSONArray("end")));
                            } else {
                                suggestAddrInfo.setSuggestWpCity(b(jSONObjectOptJSONObject3, "multi_waypoints"));
                            }
                        } else if (i4 == 0) {
                            suggestAddrInfo.setSuggestStartNode(a(jSONObjectOptJSONObject3.optJSONArray("start"), strOptString));
                        } else if (i4 == length - 1 && i4 > 0) {
                            suggestAddrInfo.setSuggestEndNode(a(jSONObjectOptJSONObject3.optJSONArray("end"), strOptString2));
                        } else {
                            suggestAddrInfo.setSuggestWpNode(a(jSONObjectOptJSONObject3, "multi_waypoints"));
                        }
                    }
                }
                return suggestAddrInfo;
            }
        }
        return null;
    }

    private List<CityInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject.optInt("num");
                cityInfo.city = jSONObject.optString("name");
                arrayList.add(cityInfo);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    private List<PoiInfo> a(JSONArray jSONArray, String str) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.address = jSONObject.optString("addr");
                poiInfo.uid = jSONObject.optString(UserConstants.URL_PARAMS.b);
                poiInfo.name = jSONObject.optString("name");
                poiInfo.location = CoordUtil.decodeLocation(jSONObject.optString("geo"));
                poiInfo.city = str;
                arrayList.add(poiInfo);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private List<List<PoiInfo>> a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            List<PoiInfo> listA = a(((JSONObject) jSONArrayOptJSONArray.opt(i)).optJSONArray("way_ponits"), "");
            if (listA != null) {
                arrayList.add(listA);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        OnGetRoutePlanResultListener onGetRoutePlanResultListener = (OnGetRoutePlanResultListener) obj;
        int i = a.f26800a[a().ordinal()];
        if (i == 1) {
            onGetRoutePlanResultListener.onGetTransitRouteResult((TransitRouteResult) searchResult);
        } else if (i == 2) {
            onGetRoutePlanResultListener.onGetDrivingRouteResult((DrivingRouteResult) searchResult);
        } else {
            if (i != 3) {
                return;
            }
            onGetRoutePlanResultListener.onGetWalkingRouteResult((WalkingRouteResult) searchResult);
        }
    }
}
