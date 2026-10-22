package com.baidu.platform.core.share;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.ShareUrlResult;
import com.baidu.platform.base.SearchType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e extends com.baidu.platform.base.b {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26801a;

        static {
            int[] iArr = new int[SearchType.values().length];
            f26801a = iArr;
            try {
                iArr[SearchType.POI_DETAIL_SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26801a[SearchType.LOCATION_SEARCH_SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        ShareUrlResult shareUrlResult = new ShareUrlResult();
        if (str == null || str.equals("")) {
            shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return shareUrlResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    shareUrlResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return shareUrlResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        shareUrlResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        shareUrlResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        shareUrlResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return shareUrlResult;
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.optString("state").equals("success")) {
                    shareUrlResult.setUrl(jSONObject2.optString("url"));
                    shareUrlResult.setType(a().ordinal());
                    shareUrlResult.error = SearchResult.ERRORNO.NO_ERROR;
                } else {
                    shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return shareUrlResult;
        } catch (Exception unused) {
            shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return shareUrlResult;
        }
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetShareUrlResultListener)) {
            return;
        }
        OnGetShareUrlResultListener onGetShareUrlResultListener = (OnGetShareUrlResultListener) obj;
        int i = a.f26801a[a().ordinal()];
        if (i == 1) {
            onGetShareUrlResultListener.onGetPoiDetailShareUrlResult((ShareUrlResult) searchResult);
        } else {
            if (i != 2) {
                return;
            }
            onGetShareUrlResultListener.onGetLocationShareUrlResult((ShareUrlResult) searchResult);
        }
    }
}
