package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.core.geocode.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AsyncHttpClient f26777a = new AsyncHttpClient();
    private Handler b = new Handler(Looper.getMainLooper());
    protected final Lock c = new ReentrantLock();
    private boolean d = true;
    private DistrictResult e = null;
    private SearchType f;

    /* JADX INFO: renamed from: com.baidu.platform.base.a$a, reason: collision with other inner class name */
    public class C0286a extends HttpClient.ProtoResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.platform.base.b f26778a;
        final /* synthetic */ Object b;

        public C0286a(com.baidu.platform.base.b bVar, Object obj) {
            this.f26778a = bVar;
            this.b = obj;
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onFailed(HttpClient.HttpStateError httpStateError) {
            a.this.a(httpStateError, this.f26778a, this.b);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001f  */
        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onSuccess(String str) {
            String str2;
            if (a.this.b(str)) {
                str2 = str;
            } else {
                String strC = this.f26778a instanceof d ? a.this.c(str) : "";
                if (TextUtils.isEmpty(strC)) {
                    str2 = str;
                } else {
                    str2 = strC;
                }
            }
            a aVar = a.this;
            aVar.a(str2, this.f26778a, this.b, aVar.f26777a, this);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.platform.base.b f26779a;
        final /* synthetic */ SearchResult b;
        final /* synthetic */ Object c;

        public b(com.baidu.platform.base.b bVar, SearchResult searchResult, Object obj) {
            this.f26779a = bVar;
            this.b = searchResult;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f26779a != null) {
                a.this.c.lock();
                try {
                    this.f26779a.a(this.b, this.c);
                } finally {
                    a.this.c.unlock();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        byte[] urlNeedInfo = {102, 97, 105, 108, 100};
        try {
            urlNeedInfo = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), Base64.decode(str.getBytes(), 0));
        } catch (Exception unused) {
            Log.e("BaseSearch", "transform result failed");
        }
        return new String(urlNeedInfo).trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        int iPermissionCheck;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") && !jSONObject.has("status_sp")) {
                return true;
            }
            int i = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
            if ((i != 105 && i != 106) || (iPermissionCheck = PermissionCheck.permissionCheck()) == 0) {
                return true;
            }
            Log.e("BaseSearch", "permissionCheck result is: " + iPermissionCheck);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public boolean a(c cVar, Object obj, com.baidu.platform.base.b bVar) {
        if (bVar == null) {
            Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
            return false;
        }
        SearchType searchTypeA = bVar.a();
        this.f = searchTypeA;
        String strB = cVar.b(searchTypeA);
        if (strB == null) {
            Log.e("BaseSearch", "The sendurl is: " + strB);
            a(bVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, bVar);
            return false;
        }
        if (this.f == SearchType.INTEGRAL_ROUTE && !PermissionUtils.getInstance().isIntegralRoutePlanAuthorized()) {
            Log.e("BaseSearch", "isIntegralRoutePlanAuthorized is false");
            a(bVar.a("{SDK_InnerError:{NO_ADVANCED_PERMISSION:IntegralRoutePlanAuthorized}}"), obj, bVar);
            return false;
        }
        this.f26777a.get(strB, new C0286a(bVar, obj));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.baidu.platform.base.b bVar, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        SearchResult searchResultA = bVar.a(str);
        searchResultA.status = a(str);
        if (a(bVar, searchResultA)) {
            a(asyncHttpClient, protoResultCallback, searchResultA);
            return;
        }
        if (bVar instanceof com.baidu.platform.core.district.b) {
            DistrictResult districtResult = this.e;
            if (districtResult != null) {
                DistrictResult districtResult2 = (DistrictResult) searchResultA;
                districtResult2.setCityCode(districtResult.getCityCode());
                districtResult2.setCenterPt(this.e.getCenterPt());
            }
            a(searchResultA, obj, bVar);
            this.d = true;
            this.e = null;
            ((com.baidu.platform.core.district.b) bVar).a(false);
            return;
        }
        a(searchResultA, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, com.baidu.platform.base.b bVar, Object obj) {
        a(bVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, bVar);
    }

    private void a(SearchResult searchResult, Object obj, com.baidu.platform.base.b bVar) {
        this.b.post(new b(bVar, searchResult, obj));
    }

    private boolean a(com.baidu.platform.base.b bVar, SearchResult searchResult) {
        if (!(bVar instanceof com.baidu.platform.core.district.b)) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) searchResult;
        if (SearchResult.ERRORNO.RESULT_NOT_FOUND != districtResult.error || districtResult.getCityName() == null || !this.d) {
            return false;
        }
        this.d = false;
        this.e = districtResult;
        ((com.baidu.platform.core.district.b) bVar).a(true);
        return true;
    }

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new com.baidu.platform.core.district.c(((DistrictResult) searchResult).getCityName()).b(this.f), protoResultCallback);
    }

    private int a(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    return jSONObject.getInt("status");
                }
                if (jSONObject.has("status_sp")) {
                    return jSONObject.getInt("status_sp");
                }
                if (!jSONObject.has("result") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("result")) == null) {
                    return 10204;
                }
                return jSONObjectOptJSONObject.optInt("error");
            } catch (JSONException unused) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return 10204;
    }
}
