package cn.hzjizhun.admin.base;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Scroller;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.base.utils.CrashRecorder;
import com.alipay.sdk.m.y.l;
import com.zj.adlib.aqb;
import com.zj.adlib.erb;
import com.zj.adlib.gha;
import com.zj.adlib.hrb;
import com.zj.adlib.mib;
import com.zj.adlib.ngb;
import com.zj.adlib.pwb;
import com.zj.adlib.rxb;
import com.zj.adlib.tzb;
import com.zj.adlib.vob;
import com.zj.adlib.wtb;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b0 extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f22697a;
    public String b;
    public String c;
    public String d;
    public String e;
    public wtb f;
    public vob g;
    public aqb h;
    public String i;
    public HashMap j;
    public String k;
    public final Scroller l;
    public int m;
    public boolean n;
    public final float o;
    public String p;
    public final HashMap q;
    public final pwb r;

    public b0(Context context) {
        super(context);
        this.f22697a = new HashMap();
        this.n = true;
        this.q = new HashMap();
        this.r = new pwb(this, Looper.getMainLooper());
        WebView.setWebContentsDebuggingEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(false);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setSupportZoom(false);
        settings.setDatabaseEnabled(false);
        settings.setBuiltInZoomControls(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWebChromeClient(new rxb());
        setWebViewClient(new tzb(this));
        try {
            int i = getResources().getDisplayMetrics().widthPixels;
            int i2 = getResources().getDisplayMetrics().heightPixels;
            setMeasuredDimension(i, i2);
            measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
            layout(0, 0, i, i2);
        } catch (Throwable unused) {
        }
        this.l = new Scroller(context, new BounceInterpolator());
        this.o = getResources().getDisplayMetrics().density;
    }

    public static void a(b0 b0Var) {
        b0Var.getClass();
        try {
            if (b0Var.n) {
                b0Var.m = b0Var.h.c;
                b0Var.n = false;
                if (!TextUtils.isEmpty(b0Var.c)) {
                    b0Var.a(b0Var.c);
                }
                aqb aqbVar = b0Var.h;
                if (aqbVar != null) {
                    b0Var.r.sendEmptyMessageDelayed(1, aqbVar.b + 1000);
                    return;
                }
                vob vobVar = b0Var.g;
                if (vobVar == null) {
                    return;
                }
                b0Var.r.sendEmptyMessageDelayed(2, vobVar.c);
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(b0 b0Var) {
        b0Var.getClass();
        try {
            vob vobVar = b0Var.g;
            float f = vobVar.f45407a;
            float f2 = b0Var.o;
            float f3 = f * f2;
            float f4 = vobVar.b * f2;
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            long j = jUptimeMillis2 + 100;
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.setAxisValue(5, RcSdk.j());
            pointerCoords.setAxisValue(4, RcSdk.i());
            pointerCoords.setAxisValue(0, f3);
            pointerCoords.setAxisValue(1, f4);
            MotionEvent.PointerCoords[] pointerCoordsArr = {pointerCoords};
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, j, 0, f3, f4, 0);
            motionEventObtain.addBatch(j, pointerCoordsArr, 0);
            b0Var.dispatchTouchEvent(motionEventObtain);
            long j2 = jUptimeMillis2 + 1100;
            MotionEvent motionEventObtain2 = MotionEvent.obtain(1000 + jUptimeMillis, j2, 1, f3, f4, 0);
            motionEventObtain.addBatch(j2, pointerCoordsArr, 0);
            b0Var.dispatchTouchEvent(motionEventObtain2);
            b0Var.n = true;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse getEmptyWebResourceResponse() {
        return new WebResourceResponse("image/png", "utf-8", new ByteArrayInputStream("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAMAAAACAQMAAACnuvRZAAAAA1BMVEUAAACnej3aAAAAAXRSTlMAQObYZgAAAApJREFUCNdjAAIAAAQAASDSLW8AAAAASUVORK5CYII=".getBytes()));
    }

    @Override // android.webkit.WebView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.l;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.l.getCurrX(), this.l.getCurrY());
            invalidate();
        }
    }

    public void setClickBean(vob vobVar) {
        this.g = vobVar;
    }

    public void setJs(String str) {
        this.c = str;
    }

    public void setScrollBean(aqb aqbVar) {
        this.h = aqbVar;
        this.m = aqbVar.c;
    }

    public void setTag(String str) {
        this.b = str;
    }

    public void setTaskBean(wtb wtbVar) {
        this.f = wtbVar;
        this.j = wtbVar.f20552b;
        this.i = wtb.i;
        this.k = wtbVar.f20557e;
    }

    public static WebResourceResponse a(b0 b0Var, WebResourceRequest webResourceRequest) {
        b0Var.getClass();
        try {
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            String string = webResourceRequest.getUrl().toString();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true);
            CookieManager cookieManager = CookieManager.getInstance();
            String cookie = cookieManager.getCookie(string);
            for (String str : requestHeaders.keySet()) {
                httpURLConnection.setRequestProperty(str, requestHeaders.get(str));
            }
            if (!TextUtils.isEmpty(cookie)) {
                httpURLConnection.setRequestProperty(com.google.common.net.b.p, cookie.replaceAll(b0Var.getContext().getPackageName(), ""));
            }
            httpURLConnection.setRequestProperty(com.google.common.net.b.c1, b0Var.e);
            if (!TextUtils.isEmpty(b0Var.k)) {
                httpURLConnection.setRequestProperty("Referer", b0Var.k);
            }
            if (!TextUtils.isEmpty(b0Var.i)) {
                httpURLConnection.setRequestProperty("User-Agent", b0Var.i);
            }
            HashMap map = b0Var.j;
            if (map != null) {
                try {
                    for (String str2 : map.keySet()) {
                        httpURLConnection.setRequestProperty(str2, (String) b0Var.j.get(str2));
                    }
                } catch (Throwable unused) {
                }
            }
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            while (responseCode >= 300 && responseCode < 400) {
                String headerField = httpURLConnection.getHeaderField("Location");
                if (hrb.c(headerField)) {
                    return b0Var.getEmptyWebResourceResponse();
                }
                httpURLConnection.disconnect();
                httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
                if (!TextUtils.isEmpty(cookie)) {
                    httpURLConnection.setRequestProperty(com.google.common.net.b.p, cookie.replaceAll(b0Var.getContext().getPackageName(), ""));
                }
                httpURLConnection.setRequestProperty(com.google.common.net.b.c1, b0Var.e);
                if (!TextUtils.isEmpty(b0Var.k)) {
                    httpURLConnection.setRequestProperty("Referer", b0Var.k);
                }
                if (!TextUtils.isEmpty(b0Var.i)) {
                    httpURLConnection.setRequestProperty("User-Agent", b0Var.i);
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
            }
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            HashMap map2 = new HashMap();
            for (String str3 : headerFields.keySet()) {
                Iterator<String> it = headerFields.get(str3).iterator();
                while (it.hasNext()) {
                    map2.put(str3, it.next());
                }
            }
            List<String> list = headerFields.get("set-cookie");
            if (list != null && list.size() > 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4)) {
                        cookieManager.setCookie(string, str4.replaceAll(b0Var.getContext().getPackageName(), ""));
                    }
                }
            }
            String lowerCase = headerFields.get("Content-Type").get(0).toLowerCase();
            if (lowerCase.contains("utf-8")) {
                lowerCase = lowerCase.replaceAll("(?i)charset=utf-8", "");
            }
            if (lowerCase.contains("utf8")) {
                lowerCase = lowerCase.replaceAll("(?i)charset=utf8", "");
            }
            if (lowerCase.contains(l.b)) {
                lowerCase = lowerCase.replaceAll(l.b, "").trim();
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(lowerCase, "UTF-8", httpURLConnection.getInputStream());
            webResourceResponse.setResponseHeaders(map2);
            return webResourceResponse;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final void b() {
        ArrayList arrayList;
        try {
            this.q.clear();
            wtb wtbVar = this.f;
            if (wtbVar != null && (arrayList = wtbVar.f20568k) != null && !arrayList.isEmpty()) {
                for (erb erbVar : this.f.f20568k) {
                    this.q.put(Integer.valueOf(erbVar.f41514a), erbVar.f16398a);
                }
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.i)) {
            getSettings().setUserAgentString(this.i);
        }
        String str = this.d;
        this.p = str;
        a(str, this.f22697a);
    }

    public final void a(String str, String str2) {
        this.e = str2;
        this.d = str;
        this.f22697a.put(com.google.common.net.b.c1, str2);
        if (!TextUtils.isEmpty(this.k)) {
            this.f22697a.put("Referer", this.k);
        }
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        this.f22697a.put("User-Agent", this.i);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            evaluateJavascript(com.alibaba.ariver.remotedebug.b.k + str, null);
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        try {
            HashMap map = new HashMap();
            map.put("__TS__", System.currentTimeMillis() + "");
            map.put("__PAGE_ACTION__", "0");
            a(42, map);
        } catch (Throwable unused) {
        }
    }

    public final void a(int i, HashMap map) {
        try {
            List<String> list = (List) this.q.get(Integer.valueOf(i));
            if (list == null || list.isEmpty()) {
                return;
            }
            for (String strReplaceAll : list) {
                try {
                    for (String str : map.keySet()) {
                        strReplaceAll = strReplaceAll.replaceAll(str, (String) map.get(str));
                    }
                    mib.e(strReplaceAll, this.f, new ngb(new gha(), strReplaceAll));
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public final void a(String str, HashMap map) {
        try {
            CrashRecorder.getInstance().loadWebPage(this.b, str);
            if (map == null) {
                loadUrl(str);
            } else {
                loadUrl(str, map);
            }
        } catch (Throwable unused) {
        }
    }
}
