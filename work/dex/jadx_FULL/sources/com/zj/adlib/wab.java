package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class wab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f45560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WebView f20401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f20404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f20405a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClient f20402a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20406a = "AMap.Geolocation.cbk";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption f20403a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f20407a = false;

    public class a implements ValueCallback<String> {
        public a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String f;

        public b(String str) {
            this.f = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            wab.this.f20401a.loadUrl(com.alibaba.ariver.remotedebug.b.k + wab.this.f20406a + "('" + this.f + "')");
        }
    }

    public class c implements AMapLocationListener {
        public c() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (wab.this.f20407a) {
                wab.this.i(wab.g(aMapLocation));
            }
        }
    }

    public wab(Context context, WebView webView) {
        this.f20401a = null;
        this.f20404a = null;
        this.f45560a = context.getApplicationContext();
        this.f20401a = webView;
        this.f20404a = new c();
    }

    public static String g(AMapLocation aMapLocation) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aMapLocation == null) {
                jSONObject.put("errorCode", -1);
                jSONObject.put(MyLocationStyle.ERROR_INFO, "unknownError");
            } else if (aMapLocation.getErrorCode() == 0) {
                jSONObject.put("errorCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", aMapLocation.getLongitude());
                jSONObject2.put("y", aMapLocation.getLatitude());
                jSONObject2.put("precision", aMapLocation.getAccuracy());
                jSONObject2.put("type", aMapLocation.getLocationType());
                jSONObject2.put(ze1.s, aMapLocation.getCountry());
                jSONObject2.put("province", aMapLocation.getProvince());
                jSONObject2.put("city", aMapLocation.getCity());
                jSONObject2.put("cityCode", aMapLocation.getCityCode());
                jSONObject2.put("district", aMapLocation.getDistrict());
                jSONObject2.put("adCode", aMapLocation.getAdCode());
                jSONObject2.put("street", aMapLocation.getStreet());
                jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                jSONObject2.put("floor", aMapLocation.getFloor());
                jSONObject2.put("address", aMapLocation.getAddress());
                jSONObject.put("result", jSONObject2);
            } else {
                jSONObject.put("errorCode", aMapLocation.getErrorCode());
                jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
                jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public final void c() {
        if (this.f20401a == null || this.f45560a == null || this.f20407a) {
            return;
        }
        try {
            this.f20401a.getSettings().setJavaScriptEnabled(true);
            this.f20401a.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.f20401a.getUrl())) {
                this.f20401a.reload();
            }
            if (this.f20402a == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f45560a);
                this.f20402a = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.f20404a);
            }
            this.f20407a = true;
        } catch (Throwable unused) {
        }
    }

    public final void e(String str) {
        boolean z;
        boolean z2;
        if (this.f20403a == null) {
            this.f20403a = new AMapLocationClientOption();
        }
        int iOptInt = 5;
        long jOptLong = 30000;
        boolean z3 = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jOptLong = jSONObject.optLong("to", 30000L);
            z = jSONObject.optInt("useGPS", 1) == 1;
            try {
                z2 = jSONObject.optInt("watch", 0) == 1;
                try {
                    iOptInt = jSONObject.optInt("interval", 5);
                    String strOptString = jSONObject.optString(RenderCallContext.TYPE_CALLBACK, null);
                    if (TextUtils.isEmpty(strOptString)) {
                        this.f20406a = "AMap.Geolocation.cbk";
                    } else {
                        this.f20406a = strOptString;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = false;
            }
        } catch (Throwable unused3) {
            z = false;
            z2 = false;
        }
        try {
            this.f20403a.setHttpTimeOut(jOptLong);
            if (z) {
                this.f20403a.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            } else {
                this.f20403a.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
            }
            AMapLocationClientOption aMapLocationClientOption = this.f20403a;
            if (z2) {
                z3 = false;
            }
            aMapLocationClientOption.setOnceLocation(z3);
            if (z2) {
                this.f20403a.setInterval(iOptInt * 1000);
            }
        } catch (Throwable unused4) {
        }
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.f20405a) {
            if (this.f20407a) {
                e(str);
                AMapLocationClient aMapLocationClient = this.f20402a;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.f20403a);
                    this.f20402a.stopLocation();
                    this.f20402a.startLocation();
                }
            }
        }
    }

    public final void h() {
        synchronized (this.f20405a) {
            this.f20407a = false;
            AMapLocationClient aMapLocationClient = this.f20402a;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.f20404a);
                this.f20402a.stopLocation();
                this.f20402a.onDestroy();
                this.f20402a = null;
            }
            this.f20403a = null;
        }
    }

    @SuppressLint({"NewApi"})
    public final void i(String str) {
        try {
            WebView webView = this.f20401a;
            if (webView != null) {
                webView.evaluateJavascript(com.alibaba.ariver.remotedebug.b.k + this.f20406a + "('" + str + "')", new a());
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.f20407a && (aMapLocationClient = this.f20402a) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
