package com.bwt.top.http;

import android.text.TextUtils;
import com.bwt.top.AdSdk;
import com.bwt.top.util.DeviceUtil;
import com.xwdz.http.EasyHttp;
import com.xwdz.http.core.Request;
import com.xwdz.http.kdsksdda.akdsd;
import com.zj.adlib.ehb;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class HttpManager {
    private static final int TIME_OUT = 5000;
    private static volatile HttpManager instance;
    private String TAG = "HttpManager";
    private HashMap<String, String> defaultHeader;

    public class a extends akdsd {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RequestCallback f1480a;

        public a(Request request, RequestCallback requestCallback) {
            this.f1480a = requestCallback;
        }

        public void c(ehb ehbVar, Throwable th) {
            super.c(ehbVar, th);
            HttpManager.this.onFail(this.f1480a, th);
        }

        public void e() {
        }

        public void f(String str) {
            HttpManager.this.onSuccess(this.f1480a, str);
        }
    }

    public class b extends akdsd {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RequestCallback f1481a;

        public b(Request request, RequestCallback requestCallback) {
            this.f1481a = requestCallback;
        }

        public void c(ehb ehbVar, Throwable th) {
            super.c(ehbVar, th);
            HttpManager.this.onFail(this.f1481a, th);
        }

        public void e() {
        }

        public void f(String str) {
            HttpManager.this.onSuccess(this.f1481a, str);
        }
    }

    private HttpManager() {
        EasyHttp.getConfig().setOpenRetry(false);
        HashMap<String, String> map = new HashMap<>();
        this.defaultHeader = map;
        map.put("os", "android");
        this.defaultHeader.put("version", "1.0.1");
    }

    public static HttpManager instance() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFail(RequestCallback requestCallback, Throwable th) {
        if (requestCallback == null) {
            return;
        }
        try {
            requestCallback.onFail(th);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(RequestCallback requestCallback, String str) {
        if (requestCallback == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            requestCallback.onSuccess(str);
        } catch (Throwable th) {
            onFail(requestCallback, th);
        }
    }

    private void send(int i, String str, HashMap<String, String> map, HashMap<String, String> map2, RequestCallback requestCallback) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (map2 == null) {
            map2 = new HashMap<>();
            map2.putAll(this.defaultHeader);
        }
        map2.put("User-Agent", DeviceUtil.getDefaultUAString(AdSdk.getInstance().getContext()));
        map2.put("mcid", DeviceUtil.getMcid(AdSdk.getInstance().getContext()));
        Request requestH = (i == 0 ? new Request.a().b(str).a() : new Request.a().b(str).d()).c(map).g(map2).e(5000).h();
        EasyHttp.sendRequest(requestH, new a(requestH, requestCallback));
    }

    public void get(String str, HashMap<String, String> map, RequestCallback requestCallback) {
        send(0, str, map, null, requestCallback);
    }

    public void get(String str, HashMap<String, String> map, HashMap<String, String> map2, RequestCallback requestCallback) {
        send(0, str, map, map2, requestCallback);
    }

    public void post(String str, HashMap<String, String> map, RequestCallback requestCallback) {
        send(1, str, map, null, requestCallback);
    }

    public void post(String str, HashMap<String, String> map, HashMap<String, String> map2, RequestCallback requestCallback) {
        send(1, str, map, map2, requestCallback);
    }

    public void postString(String str, String str2, HashMap<String, String> map, RequestCallback requestCallback) {
        if (map == null) {
            map = new HashMap<>();
            map.putAll(this.defaultHeader);
        }
        map.put("User-Agent", DeviceUtil.getDefaultUAString(AdSdk.getInstance().getContext()));
        map.put("mcid", DeviceUtil.getMcid(AdSdk.getInstance().getContext()));
        Request requestH = new Request.a().b(str).f(str2).g(map).e(5000).h();
        EasyHttp.sendRequest(requestH, new b(requestH, requestCallback));
    }
}
