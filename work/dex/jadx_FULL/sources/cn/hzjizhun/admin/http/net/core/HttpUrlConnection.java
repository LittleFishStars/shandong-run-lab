package cn.hzjizhun.admin.http.net.core;

import android.webkit.URLUtil;
import cn.hzjizhun.admin.http.net.EasyHttpConfig;
import cn.hzjizhun.admin.http.net.EasyHttpUtil;
import cn.hzjizhun.admin.http.net.callback.InterceptRequest;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpUrlConnection {

    public static class kdsksdda {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f22735a;

        static {
            int[] iArr = new int[Request.Method.values().length];
            f22735a = iArr;
            try {
                iArr[Request.Method.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22735a[Request.Method.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static void addHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static HttpURLConnection execute(Request request, EasyHttpConfig easyHttpConfig) throws Throwable {
        if (!URLUtil.isNetworkUrl(request.url)) {
            throw new Throwable("the url :" + request.url + " is not valid.");
        }
        Iterator<InterceptRequest> it = easyHttpConfig.getInterceptRequests().iterator();
        while (it.hasNext()) {
            request = it.next().onInterceptRequest(request);
        }
        int i = kdsksdda.f22735a[request.method.ordinal()];
        if (i == 1) {
            return get(request, easyHttpConfig);
        }
        if (i == 2) {
            return post(request, easyHttpConfig);
        }
        throw new Throwable("please use request method! ");
    }

    private static HttpURLConnection get(Request request, EasyHttpConfig easyHttpConfig) throws Throwable {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.url + EasyHttpUtil.appendHttpParams(request.params, true)).openConnection();
            httpURLConnection.setRequestMethod(request.method.name());
            httpURLConnection.setConnectTimeout(easyHttpConfig.getConnectTimeoutMillis());
            httpURLConnection.setReadTimeout(easyHttpConfig.getReadTimeoutMillis());
            addHeader(httpURLConnection, request.headers);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Throwable th) {
            throw new Throwable(th);
        }
    }

    private static HttpURLConnection post(Request request, EasyHttpConfig easyHttpConfig) throws Throwable {
        OutputStream outputStream = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.url).openConnection();
            httpURLConnection.setRequestMethod(request.method.name());
            httpURLConnection.setConnectTimeout(easyHttpConfig.getConnectTimeoutMillis());
            httpURLConnection.setReadTimeout(easyHttpConfig.getReadTimeoutMillis());
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            addHeader(httpURLConnection, request.headers);
            outputStream = httpURLConnection.getOutputStream();
            String postString = EasyHttpUtil.formatPostString(request.postString);
            if (postString != null) {
                outputStream.write(postString.getBytes());
                EasyHttpUtil.Logger.i("post", "request.postString");
            } else {
                outputStream.write(EasyHttpUtil.formatPostParams(request.params).getBytes());
                EasyHttpUtil.Logger.i("post", "request.params");
            }
            httpURLConnection.connect();
            if (outputStream == null) {
                return httpURLConnection;
            }
            try {
                outputStream.flush();
                outputStream.close();
                return httpURLConnection;
            } catch (Throwable th) {
                throw new Throwable(th);
            }
        } catch (Throwable th2) {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (Throwable th3) {
                    throw new Throwable(th3);
                }
            }
            throw th2;
        }
    }
}
