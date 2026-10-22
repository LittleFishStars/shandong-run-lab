package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SearchType f26780a;

    public abstract SearchResult a(String str);

    public abstract void a(SearchResult searchResult, Object obj);

    public void a(SearchType searchType) {
        this.f26780a = searchType;
    }

    public SearchType a() {
        return this.f26780a;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0066 A[Catch: JSONException -> 0x0072, TryCatch #0 {JSONException -> 0x0072, blocks: (B:4:0x0003, B:7:0x000b, B:9:0x0012, B:30:0x0044, B:31:0x0047, B:33:0x004f, B:32:0x004a, B:34:0x0052, B:35:0x0057, B:36:0x005c, B:37:0x0061, B:38:0x0066, B:10:0x0019, B:42:0x006d), top: B:47:0x0003 }] */
    public boolean a(String str, SearchResult searchResult, boolean z) {
        int iOptInt;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (z) {
                        iOptInt = jSONObject.optInt("status");
                    } else {
                        iOptInt = jSONObject.optInt("status_sp");
                    }
                    if (iOptInt == 0) {
                        return false;
                    }
                    if (iOptInt == 2) {
                        searchResult.error = SearchResult.ERRORNO.NO_ADVANCED_PERMISSION;
                    } else if (iOptInt == 200 || iOptInt == 230) {
                        searchResult.error = SearchResult.ERRORNO.KEY_ERROR;
                    } else if (iOptInt == 10 || iOptInt == 11) {
                        searchResult.error = SearchResult.ERRORNO.PARAMER_ERROR;
                    } else if (iOptInt == 40) {
                        searchResult.error = SearchResult.ERRORNO.INVALID_DISTRICT_ID;
                    } else if (iOptInt == 41 || iOptInt == 44) {
                        searchResult.error = SearchResult.ERRORNO.NO_DATA_FOR_LATLNG;
                    } else if (iOptInt != 45) {
                        switch (iOptInt) {
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                                searchResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                                break;
                            default:
                                searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                break;
                        }
                    } else {
                        searchResult.error = SearchResult.ERRORNO.NO_ADVANCED_PERMISSION;
                    }
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return true;
            }
        }
        searchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return true;
    }
}
