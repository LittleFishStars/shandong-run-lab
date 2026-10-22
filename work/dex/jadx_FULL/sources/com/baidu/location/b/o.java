package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class o {
    private static long j = 12000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f26375a;
    private Context b;
    private WebView c;
    private LocationClient d;
    private a e;
    private List<b> f;
    private boolean g;
    private long h;
    private BDLocation i;
    private f k;
    private boolean l;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private String a(BDLocation bDLocation) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", bDLocation.getLatitude());
                jSONObject.put("longitude", bDLocation.getLongitude());
                jSONObject.put("radius", bDLocation.getRadius());
                jSONObject.put("errorcode", 1);
                if (bDLocation.hasAltitude()) {
                    jSONObject.put("altitude", bDLocation.getAltitude());
                }
                if (bDLocation.hasSpeed()) {
                    jSONObject.put("speed", bDLocation.getSpeed() / 3.6f);
                }
                if (bDLocation.getLocType() == 61) {
                    jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, bDLocation.getDirection());
                }
                if (bDLocation.getBuildingName() != null) {
                    jSONObject.put("buildingname", bDLocation.getBuildingName());
                }
                if (bDLocation.getBuildingID() != null) {
                    jSONObject.put("buildingid", bDLocation.getBuildingID());
                }
                if (bDLocation.getFloor() != null) {
                    jSONObject.put("floor", bDLocation.getFloor());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        private void a(String str) {
            if (o.this.l) {
                o.this.e.removeCallbacks(o.this.k);
                o.this.l = false;
            }
            if (o.this.f == null || o.this.f.size() <= 0) {
                return;
            }
            Iterator it = o.this.f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        o.this.c.loadUrl(com.alibaba.ariver.remotedebug.b.k + bVar.b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception unused) {
                    return;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:38:0x0120  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.location.b.o$1] */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object[] objArr;
            String string = 0;
            string = 0;
            switch (message.what) {
                case 1:
                    b bVar = (b) message.obj;
                    if (o.this.f != null) {
                        o.this.f.add(bVar);
                    }
                    if (o.this.d != null) {
                        if (o.this.d.requestLocation() != 0) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - o.this.h;
                            if (o.this.i == null || jCurrentTimeMillis > 10000) {
                                objArr = true;
                            } else {
                                Message messageObtainMessage = o.this.e.obtainMessage(2);
                                messageObtainMessage.obj = o.this.i;
                                messageObtainMessage.sendToTarget();
                                objArr = false;
                            }
                        } else {
                            objArr = true;
                        }
                        if (objArr == true) {
                            if (o.this.l) {
                                o.this.e.removeCallbacks(o.this.k);
                                o.this.l = false;
                            }
                            if (o.this.k == null) {
                                o oVar = o.this;
                                oVar.k = new f();
                            }
                            o.this.e.postDelayed(o.this.k, o.j);
                            o.this.l = true;
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    a(a((BDLocation) message.obj));
                    return;
                case 3:
                    if (o.this.f == null) {
                        o.this.f = new ArrayList();
                    } else {
                        o.this.f.clear();
                    }
                    o.this.d.registerLocationListener(o.this.f26375a);
                    return;
                case 4:
                    if (o.this.f != null) {
                        o.this.f.clear();
                        o.this.f = null;
                    }
                    o.this.d.unRegisterLocationListener(o.this.f26375a);
                    o.this.h = 0L;
                    o.this.i = null;
                    if (o.this.k != null && o.this.l) {
                        o.this.e.removeCallbacks(o.this.k);
                    }
                    o.this.l = false;
                    o.this.c.removeJavascriptInterface("BaiduLocAssistant");
                    return;
                case 5:
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorcode", 0);
                        string = jSONObject.toString();
                        break;
                    } catch (Exception unused) {
                    }
                    if (string == 0) {
                        return;
                    }
                    break;
                case 6:
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errorcode", 2);
                        string = jSONObject2.toString();
                        break;
                    } catch (Exception unused2) {
                    }
                    if (string == 0) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            a(string);
        }
    }

    public class b {
        private String b;
        private String c;
        private long d;

        public b(String str) {
            this.b = null;
            this.c = null;
            this.d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.b = jSONObject.getString("action");
                }
                if (jSONObject.has(RenderCallContext.TYPE_CALLBACK)) {
                    this.c = jSONObject.getString(RenderCallContext.TYPE_CALLBACK);
                }
                if (jSONObject.has(com.alipay.sdk.m.o.b.r0)) {
                    long j = jSONObject.getLong(com.alipay.sdk.m.o.b.r0);
                    if (j >= 1000) {
                        long unused = o.j = j;
                    }
                }
                this.d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.b = null;
                this.c = null;
            }
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final o f26378a = new o();
    }

    public class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !o.this.g) {
                return;
            }
            b bVar = o.this.new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || o.this.e == null) {
                return;
            }
            Message messageObtainMessage = o.this.e.obtainMessage(1);
            messageObtainMessage.obj = bVar;
            messageObtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message messageObtainMessage;
            String str;
            if (!o.this.g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType == 61 || locType == 161 || locType == 66) {
                if (coorType != null) {
                    if (coorType.equals("gcj02")) {
                        bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                    } else {
                        if (coorType.equals("bd09")) {
                            str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                        } else if (coorType.equals("bd09ll")) {
                            str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                        }
                        bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                    }
                }
                o.this.h = System.currentTimeMillis();
                o.this.i = new BDLocation(bDLocation2);
                messageObtainMessage = o.this.e.obtainMessage(2);
                messageObtainMessage.obj = bDLocation2;
            } else {
                messageObtainMessage = o.this.e.obtainMessage(5);
            }
            messageObtainMessage.sendToTarget();
        }
    }

    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.l = false;
            o.this.e.obtainMessage(6).sendToTarget();
        }
    }

    private o() {
        this.b = null;
        this.d = null;
        this.f26375a = new e();
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public static o a() {
        return c.f26378a;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.g && Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            this.b = context;
            this.c = webView;
            this.d = locationClient;
            a aVar = new a(Looper.getMainLooper());
            this.e = aVar;
            aVar.obtainMessage(3).sendToTarget();
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSavePassword(false);
            this.c.removeJavascriptInterface("searchBoxJavaBridge_");
            this.c.removeJavascriptInterface("accessibility");
            this.c.removeJavascriptInterface("accessibilityTraversal");
            a(this.c);
            this.g = true;
        }
    }

    public void b() {
        if (this.g) {
            this.e.obtainMessage(4).sendToTarget();
            this.g = false;
        }
    }
}
