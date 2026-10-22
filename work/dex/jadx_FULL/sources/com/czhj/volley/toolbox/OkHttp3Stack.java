package com.czhj.volley.toolbox;

import android.text.TextUtils;
import com.aliyun.tea.logging.DefaultLogger;
import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Header;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class OkHttp3Stack extends BaseHttpStack {
    public static final String NETWORK_TIMEOUT = "NETWORK_TIMEOUT";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Interceptor f29499a = new Interceptor() { // from class: com.czhj.volley.toolbox.OkHttp3Stack.1
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            int iConnectTimeoutMillis = chain.connectTimeoutMillis();
            int timeoutMillis = chain.readTimeoutMillis();
            int iWriteTimeoutMillis = chain.writeTimeoutMillis();
            try {
                String strHeader = request.header(OkHttp3Stack.NETWORK_TIMEOUT);
                if (!TextUtils.isEmpty(strHeader)) {
                    iConnectTimeoutMillis = Integer.valueOf(strHeader).intValue();
                    timeoutMillis = iConnectTimeoutMillis;
                    iWriteTimeoutMillis = timeoutMillis;
                }
            } catch (Throwable unused) {
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return chain.withConnectTimeout(iConnectTimeoutMillis, timeUnit).withReadTimeout(timeoutMillis, timeUnit).withWriteTimeout(iWriteTimeoutMillis, timeUnit).proceed(request);
        }
    };
    private final SSLSocketFactory b;
    private final OkHttpClient.Builder c;
    private final OkHttpClient d;

    public OkHttp3Stack() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.c = builder;
        builder.connectionPool(new ConnectionPool());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(5000L, timeUnit);
        builder.readTimeout(5000L, timeUnit);
        builder.writeTimeout(5000L, timeUnit);
        builder.addInterceptor(this.f29499a);
        this.b = null;
        this.d = builder.build();
    }

    public OkHttp3Stack(SSLSocketFactory sSLSocketFactory) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.c = builder;
        builder.connectionPool(new ConnectionPool());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(5000L, timeUnit);
        builder.readTimeout(5000L, timeUnit);
        builder.writeTimeout(5000L, timeUnit);
        builder.addInterceptor(this.f29499a);
        this.b = sSLSocketFactory;
        this.d = builder.build();
    }

    private List<Header> a(Headers headers) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            String strValue = headers.value(i);
            if (strName != null) {
                arrayList.add(new Header(strName, strValue));
            }
        }
        return arrayList;
    }

    private static RequestBody a(com.czhj.volley.Request request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body == null) {
            return null;
        }
        return RequestBody.create(MediaType.parse(request.getBodyContentType()), body);
    }

    private static void a(Request.Builder builder, com.czhj.volley.Request<?> request) throws AuthFailureError {
        RequestBody requestBodyCreate;
        String str;
        switch (request.getMethod()) {
            case -1:
                byte[] body = request.getBody();
                if (body != null) {
                    requestBodyCreate = RequestBody.create(MediaType.parse(request.getBodyContentType()), body);
                    builder.post(requestBodyCreate);
                    return;
                }
                return;
            case 0:
                builder.get();
                return;
            case 1:
                requestBodyCreate = a(request);
                builder.post(requestBodyCreate);
                return;
            case 2:
                builder.put(a(request));
                return;
            case 3:
                builder.delete(a(request));
                return;
            case 4:
                builder.head();
                return;
            case 5:
                str = "OPTIONS";
                builder.method(str, (RequestBody) null);
                return;
            case 6:
                str = DefaultLogger.TRACE;
                builder.method(str, (RequestBody) null);
                return;
            case 7:
                builder.patch(a(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // com.czhj.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(com.czhj.volley.Request<?> request, Map<String, String> map) throws AuthFailureError, IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(request.getUrl());
        Map<String, String> headers = request.getHeaders();
        builder.addHeader(NETWORK_TIMEOUT, request.getRetryPolicy().getCurrentTimeout() + "");
        for (String str : headers.keySet()) {
            String str2 = headers.get(str);
            if (TextUtils.isEmpty(str2)) {
                builder.removeHeader(str);
            } else {
                builder.addHeader(str, str2);
            }
        }
        for (String str3 : map.keySet()) {
            String str4 = map.get(str3);
            if (TextUtils.isEmpty(str4)) {
                builder.removeHeader(str3);
            } else {
                builder.addHeader(str3, str4);
            }
        }
        a(builder, request);
        Response responseExecute = this.d.newCall(builder.build()).execute();
        int iCode = responseExecute.code();
        ResponseBody responseBodyBody = responseExecute.body();
        return new HttpResponse(iCode, a(responseExecute.headers()), responseBodyBody == null ? 0 : (int) responseBodyBody.contentLength(), responseBodyBody == null ? null : responseBodyBody.byteStream());
    }
}
