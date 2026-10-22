package cn.hzjizhun.admin.http;

import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.http.net.EasyHttp;
import cn.hzjizhun.admin.http.net.callback.StringEasyCallbackImpl;
import cn.hzjizhun.admin.http.net.core.EasyCall;
import cn.hzjizhun.admin.http.net.core.Request;
import cn.hzjizhun.admin.util.DeviceUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpManager {
    private static final int TIME_OUT = 5000;
    private static volatile HttpManager instance;
    private String TAG = "HttpManager";
    private HashMap<String, String> defaultHeader;

    public class a extends StringEasyCallbackImpl {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RequestCallback f299a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Request f300a;

        public a(Request request, RequestCallback requestCallback) {
            this.f300a = request;
            this.f299a = requestCallback;
        }

        @Override // cn.hzjizhun.admin.http.net.callback.StringEasyCallbackImpl
        public void onCompleted() {
        }

        @Override // cn.hzjizhun.admin.http.net.callback.StringEasyCallbackImpl, cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
        public void onFailure(EasyCall easyCall, Throwable th) {
            super.onFailure(easyCall, th);
            HttpManager.this.onFail(this.f299a, th);
        }

        @Override // cn.hzjizhun.admin.http.net.callback.StringEasyCallbackImpl
        public void onSuccessful(String str) {
            HttpManager.this.onSuccess(this.f299a, str);
        }
    }

    public class b extends StringEasyCallbackImpl {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RequestCallback f301a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Request f302a;

        public b(Request request, RequestCallback requestCallback) {
            this.f302a = request;
            this.f301a = requestCallback;
        }

        @Override // cn.hzjizhun.admin.http.net.callback.StringEasyCallbackImpl
        public void onCompleted() {
        }

        @Override // cn.hzjizhun.admin.http.net.callback.StringEasyCallbackImpl, cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
        public void onFailure(EasyCall easyCall, Throwable th) {
            super.onFailure(easyCall, th);
            HttpManager.this.onFail(this.f301a, th);
        }

        @Override // cn.hzjizhun.admin.http.net.callback.StringEasyCallbackImpl
        public void onSuccessful(String str) {
            HttpManager.this.onSuccess(this.f301a, str);
        }
    }

    private HttpManager() {
        EasyHttp.getConfig().setOpenRetry(false);
        HashMap<String, String> map = new HashMap<>();
        this.defaultHeader = map;
        map.put("os", "android");
        this.defaultHeader.put("version", "2.5.0");
    }

    private static String getReplaceTs(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            return str.replaceAll("__TS__", (jCurrentTimeMillis / 1000) + "").replaceAll("__TMS__", jCurrentTimeMillis + "");
        } catch (Throwable unused) {
            return "";
        }
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
        Request requestBuild;
        if (map == null) {
            map = new HashMap<>();
        }
        if (map2 == null) {
            map2 = new HashMap<>();
            map2.putAll(this.defaultHeader);
        }
        map2.put("User-Agent", DeviceUtil.getDefaultUAString(JZAdSdk.getInstance().getContext()));
        map2.put("mcid", DeviceUtil.getMcid(JZAdSdk.getInstance().getContext()));
        if (i == 0) {
            requestBuild = new Request.Builder().url(getReplaceTs(str)).get().addParams(map).addHeaders(map2).setConnectTimeoutMillis(5000).build();
        } else {
            requestBuild = new Request.Builder().url(str).post().addParams(map).addHeaders(map2).setConnectTimeoutMillis(5000).build();
        }
        EasyHttp.sendRequest(requestBuild, new a(requestBuild, requestCallback));
    }

    public void get(String str, HashMap<String, String> map, RequestCallback requestCallback) {
        send(0, str, map, null, requestCallback);
    }

    public void post(String str, HashMap<String, String> map, RequestCallback requestCallback) {
        send(1, str, map, null, requestCallback);
    }

    public void postString(String str, String str2, HashMap<String, String> map, RequestCallback requestCallback) {
        if (map == null) {
            map = new HashMap<>();
            map.putAll(this.defaultHeader);
        }
        map.put("User-Agent", DeviceUtil.getDefaultUAString(JZAdSdk.getInstance().getContext()));
        map.put("mcid", DeviceUtil.getMcid(JZAdSdk.getInstance().getContext()));
        Request requestBuild = new Request.Builder().url(str).post(str2).addHeaders(map).setConnectTimeoutMillis(5000).build();
        EasyHttp.sendRequest(requestBuild, new b(requestBuild, requestCallback));
    }

    public void get(String str, HashMap<String, String> map, HashMap<String, String> map2, RequestCallback requestCallback) {
        send(0, str, map, map2, requestCallback);
    }

    public void post(String str, HashMap<String, String> map, HashMap<String, String> map2, RequestCallback requestCallback) {
        send(1, str, map, map2, requestCallback);
    }
}
