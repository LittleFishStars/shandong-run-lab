package com.baidu.platform.base;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import com.zj.adlib.bv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26781a = true;
    private boolean b = true;
    protected com.baidu.platform.util.a c = new com.baidu.platform.util.a();

    public abstract String a(com.baidu.platform.domain.b bVar);

    public void a(boolean z) {
        this.b = z;
    }

    public void b(boolean z) {
        this.f26781a = z;
    }

    private String a(SearchType searchType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SearchType.REVERSE_GEO_CODER == searchType ? a(str) : str;
    }

    public String b(SearchType searchType) {
        String strA = a(com.baidu.platform.domain.c.a());
        String authToken = HttpClient.getAuthToken();
        if (authToken == null) {
            Log.e("SearchRequest", "toUrlString get authtoken failed");
            int iPermissionCheck = PermissionCheck.permissionCheck();
            if (iPermissionCheck != 0) {
                Log.e("SearchRequest", "try permissionCheck result is: " + iPermissionCheck);
                return null;
            }
            authToken = HttpClient.getAuthToken();
        }
        if (this.f26781a) {
            this.c.a("token", authToken);
        }
        String strA2 = this.c.a();
        if (a(searchType)) {
            strA2 = a(searchType, strA2);
        }
        String str = strA2 + HttpClient.getPhoneInfo();
        if (this.b) {
            str = str + "&sign=" + AppMD5.getSignMD5String(str);
        }
        return strA + "?" + str;
    }

    private String a(String str) {
        String strSubstring = str.substring(str.indexOf("location=") + 9, str.indexOf("&", str.indexOf("location=")));
        if (TextUtils.isEmpty(strSubstring)) {
            return str;
        }
        byte[] urlNeedInfo = {0};
        try {
            urlNeedInfo = AlgorithmUtil.setUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), strSubstring.getBytes());
        } catch (Exception e) {
            Log.e("BaseSearch", "get location failed", e);
        }
        return str.replace(strSubstring, Base64.encodeToString(urlNeedInfo, 0).trim());
    }

    public final String a(PlanNode planNode) {
        if (planNode == null) {
            return null;
        }
        String str = new String(bv9.b);
        LatLng location = planNode.getLocation();
        if (location != null) {
            String str2 = str + "\"type\":1,";
            Point pointLl2point = CoordUtil.ll2point(location);
            if (!TextUtils.isEmpty(planNode.getPoiId())) {
                str2 = str2 + "\"uid\":\"" + planNode.getPoiId() + "\",";
            }
            if (!TextUtils.isEmpty(planNode.getBid()) && !TextUtils.isEmpty(planNode.getFloor())) {
                str2 = (str2 + "\"building\":\"" + planNode.getBid() + "\",") + "\"floor\":\"" + planNode.getFloor() + "\",";
            }
            if (!TextUtils.isEmpty(planNode.getCityCode())) {
                str2 = str2 + "\"city\":\"" + planNode.getCityCode() + "\",";
            }
            return str2 + "\"xy\":\"" + pointLl2point.x + "," + pointLl2point.y + "\"}";
        }
        if (planNode.getName() == null) {
            return str;
        }
        String str3 = str + "\"type\":2,";
        if (!TextUtils.isEmpty(planNode.getPoiId())) {
            str3 = str3 + "\"uid\":\"" + planNode.getPoiId() + "\",";
        }
        return str3 + "\"keyword\":\"" + planNode.getName() + "\"}";
    }

    private boolean a(SearchType searchType) {
        return SearchType.REVERSE_GEO_CODER == searchType;
    }
}
