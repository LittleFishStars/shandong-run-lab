package com.kc.dw.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.kc.dw.core.domain.HttpResponse;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.t24;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.tls.OkHostnameVerifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static OkHttpClient f39418a;
    public static OkHttpClient b;
    public static Handler c;
    public static long d;
    public static long e;

    @Keep
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f39419a;
        public final x b;

        /* JADX INFO: renamed from: com.kc.dw.core.utils.z$a$a, reason: collision with other inner class name */
        @Keep
        public class C1050a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IOException f39420a;
            public final a b;

            public C1050a(a aVar, IOException iOException) {
                this.b = aVar;
                this.f39420a = iOException;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    this.b.b.onFailure(this.f39420a);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Keep
        public class b extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final HttpResponse f39421a;
            public final a b;

            public b(a aVar, HttpResponse httpResponse) {
                this.b = aVar;
                this.f39421a = httpResponse;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    this.b.b.onResponse(this.f39421a);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public a(boolean z, x xVar) {
            this.f39419a = z;
            this.b = xVar;
        }

        public void onFailure(Call call, IOException iOException) {
            if (Looper.myLooper() != Looper.getMainLooper() && this.f39419a) {
                z.c.post(new C1050a(this, iOException));
                return;
            }
            try {
                this.b.onFailure(iOException);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            String strMessage;
            HttpResponse<byte[]> httpResponse = new HttpResponse<>();
            try {
                if (!response.isSuccessful()) {
                    httpResponse.setSuccessful(false);
                    httpResponse.setErrorCode(response.code());
                    strMessage = response.message();
                } else {
                    if (response.body() != null) {
                        try {
                            byte[] bArrBytes = response.body().bytes();
                            httpResponse.setSuccessful(true);
                            httpResponse.setResponseBody(bArrBytes);
                        } catch (Throwable unused) {
                            httpResponse.setSuccessful(false);
                            httpResponse.setErrorCode(com.kc.dw.core.exception.b.g.intValue());
                            strMessage = "read response error";
                            httpResponse.setErrorDescription(strMessage);
                        }
                        response.close();
                        if (Looper.myLooper() == Looper.getMainLooper() && this.f39419a) {
                            z.c.post(new b(this, httpResponse));
                            return;
                        } else {
                            this.b.onResponse(httpResponse);
                            return;
                        }
                    }
                    httpResponse.setSuccessful(false);
                    httpResponse.setErrorCode(response.code());
                    strMessage = "bad file";
                }
                this.b.onResponse(httpResponse);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
            httpResponse.setErrorDescription(strMessage);
            response.close();
            if (Looper.myLooper() == Looper.getMainLooper()) {
            }
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f39422a;

        public b(x xVar) {
            this.f39422a = xVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39422a.onFailure(new IOException("get file error"));
        }
    }

    @Keep
    public class c implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f39423a;

        @Keep
        public class a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f39424a;

            public a(c cVar) {
                this.f39424a = cVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    k kVar = this.f39424a.f39423a;
                    if (kVar != null) {
                        kVar.fail();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Keep
        public class b extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Response f39425a;
            public final c b;

            public b(c cVar, Response response) {
                this.b = cVar;
                this.f39425a = response;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    if (this.f39425a.isSuccessful()) {
                        k kVar = this.b.f39423a;
                        if (kVar != null) {
                            kVar.success();
                        }
                    } else {
                        k kVar2 = this.b.f39423a;
                        if (kVar2 != null) {
                            kVar2.fail();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        k kVar3 = this.b.f39423a;
                        if (kVar3 != null) {
                            kVar3.fail();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public c(k kVar) {
            this.f39423a = kVar;
        }

        public void onFailure(Call call, IOException iOException) {
            SdkHandler.runOnMainThread(new a(this));
        }

        public void onResponse(Call call, Response response) throws IOException {
            SdkHandler.runOnMainThread(new b(this, response));
        }
    }

    @Keep
    public class d extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f39426a;

        public d(k kVar) {
            this.f39426a = kVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                k kVar = this.f39426a;
                if (kVar != null) {
                    kVar.fail();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Keep
    public class e implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean zVerify = OkHostnameVerifier.INSTANCE.verify(str, sSLSession);
            if (!zVerify) {
                LogUtil.e("SSL", "Hostname verification failed: " + str);
            }
            return zVerify;
        }
    }

    @Keep
    public class f implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean zVerify = OkHostnameVerifier.INSTANCE.verify(str, sSLSession);
            if (!zVerify) {
                LogUtil.e("SSL", "Hostname verification failed: " + str);
            }
            return zVerify;
        }
    }

    @Keep
    public class g implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f39427a;

        @Keep
        public class a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IOException f39428a;
            public final g b;

            public a(g gVar, IOException iOException) {
                this.b = gVar;
                this.f39428a = iOException;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.b.f39427a.onFailure(this.f39428a);
                Integer num = com.kc.dw.core.exception.b.f39252a;
            }
        }

        public g(y yVar) {
            this.f39427a = yVar;
        }

        public void onFailure(Call call, IOException iOException) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z.c.post(new a(this, iOException));
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            ResponseBody responseBodyBody = response.body();
            n0 n0Var = new n0(response.code(), response.isSuccessful());
            response.headers();
            if (responseBodyBody != null) {
                try {
                    n0Var.b = responseBodyBody.string();
                } catch (Throwable th) {
                    n0Var.b = "";
                    th.printStackTrace();
                }
            }
            try {
                try {
                    this.f39427a.a(n0Var);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                response.close();
            }
        }
    }

    @Keep
    public class h implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f39429a;

        @Keep
        public class a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IOException f39430a;
            public final h b;

            public a(h hVar, IOException iOException) {
                this.b = hVar;
                this.f39430a = iOException;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.b.f39429a.onFailure(this.f39430a);
                Integer num = com.kc.dw.core.exception.b.f39252a;
            }
        }

        public h(x xVar) {
            this.f39429a = xVar;
        }

        public void onFailure(Call call, IOException iOException) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z.c.post(new a(this, iOException));
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            String strMessage;
            HttpResponse<byte[]> httpResponse = new HttpResponse<>();
            try {
                try {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            byte[] bArrBytes = response.body().bytes();
                            httpResponse.setSuccessful(true);
                            httpResponse.setErrorCode(response.code());
                            httpResponse.setHeader(response.headers());
                            httpResponse.setResponseBody(bArrBytes);
                        } else {
                            httpResponse.setSuccessful(false);
                            httpResponse.setErrorCode(response.code());
                            strMessage = "bad file";
                        }
                        this.f39429a.onResponse(httpResponse);
                        return;
                    }
                    httpResponse.setSuccessful(false);
                    httpResponse.setErrorCode(response.code());
                    strMessage = response.message();
                    this.f39429a.onResponse(httpResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            } finally {
                response.close();
            }
            httpResponse.setErrorDescription(strMessage);
        }
    }

    @Keep
    public class i implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f39431a;

        @Keep
        public class a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IOException f39432a;
            public final i b;

            public a(i iVar, IOException iOException) {
                this.b = iVar;
                this.f39432a = iOException;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.b.f39431a.onFailure(this.f39432a);
            }
        }

        @Keep
        public class b extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final n0 f39433a;
            public final i b;

            public b(i iVar, n0 n0Var) {
                this.b = iVar;
                this.f39433a = n0Var;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    this.b.f39431a.a(this.f39433a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public i(y yVar) {
            this.f39431a = yVar;
        }

        public void onFailure(Call call, IOException iOException) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z.c.post(new a(this, iOException));
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            ResponseBody responseBodyBody = response.body();
            n0 n0Var = new n0(response.code(), response.isSuccessful());
            response.headers();
            if (responseBodyBody != null) {
                try {
                    n0Var.b = responseBodyBody.string();
                } catch (Throwable th) {
                    n0Var.b = "";
                    th.printStackTrace();
                }
            }
            response.close();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z.c.post(new b(this, n0Var));
                return;
            }
            try {
                this.f39431a.a(n0Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Keep
    public class j implements y<n0> {
        @Override // com.kc.dw.core.utils.y
        public /* bridge */ /* synthetic */ void a(n0 n0Var) throws IOException {
        }

        @Override // com.kc.dw.core.utils.y
        public void onFailure(IOException iOException) {
        }
    }

    @Keep
    public interface k {
        void fail();

        void success();
    }

    static {
        MediaType.parse("text/x-markdown; charset=utf-8");
        MediaType.parse("image/png");
        MediaType.parse("audio/mp3");
        MediaType.parse("video/mp4");
        MediaType.parse(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        MediaType.parse("application/json; charset=utf-8");
        c = new Handler(Looper.getMainLooper());
        d = System.currentTimeMillis();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f39418a = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).dns(new u("sdk.1rtb.net")).hostnameVerifier(new e()).build();
        e = System.currentTimeMillis();
    }

    public static OkHttpClient a() {
        b();
        return b;
    }

    public static void a(Context context, String str, com.kc.dw.core.utils.j jVar) {
        HashMap map = new HashMap();
        String strA = com.kc.dw.core.utils.c.a(context);
        map.put(com.google.common.net.b.c1, "");
        if (strA == null) {
            strA = "";
        }
        map.put("User-Agent", strA);
        try {
            Headers.Builder builder = new Headers.Builder();
            for (Map.Entry entry : map.entrySet()) {
                builder.add((String) entry.getKey(), (String) entry.getValue());
            }
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return;
            }
            Request requestBuild = new Request.Builder().headers(builder.build()).url(httpUrl.newBuilder().build()).get().build();
            if (b == null) {
                b();
            }
            LogUtil.d(t24.f44832a, "url[" + requestBuild.url().url().toString() + "]");
            b.newCall(requestBuild).enqueue(new a0(jVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, x xVar, boolean z) {
        try {
            Request requestBuild = new Request.Builder().url(str).build();
            if (b == null) {
                b();
            }
            b.newCall(requestBuild).enqueue(new a(z, xVar));
        } catch (Throwable th) {
            if (Looper.myLooper() == Looper.getMainLooper() || !z) {
                try {
                    xVar.onFailure(new IOException("get file error"));
                } catch (Exception unused) {
                    th.printStackTrace();
                }
            } else {
                c.post(new b(xVar));
            }
            th.printStackTrace();
        }
    }

    public static void a(String str, k kVar) {
        try {
            b.newCall(new Request.Builder().url(str).head().build()).enqueue(new c(kVar));
        } catch (Exception e2) {
            e2.printStackTrace();
            SdkHandler.runOnMainThread(new d(kVar));
        }
    }

    public static void a(String str, Integer num, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (num == null) {
            num = -1;
        }
        int iIntValue = num.intValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf = iIntValue == 0 ? "__ERROR_CODE__" : String.valueOf(iIntValue);
        if (TextUtils.isEmpty(str2)) {
            str2 = "__ERROR_MESSAGE__";
        }
        String string = TextUtils.replace(str, new String[]{"__ERROR_CODE__", "__ERROR_MESSAGE__", "__MS_EVENT_SEC__", "__MS_EVENT_MSEC__"}, new String[]{strValueOf, str2, String.valueOf(jCurrentTimeMillis / 1000), String.valueOf(jCurrentTimeMillis)}).toString();
        LogUtil.d(t24.f44832a, "错误上报： " + string);
        a(string, (Map<String, String>) null, new j());
    }

    public static void a(String str, Map<String, String> map, y<n0> yVar) {
        try {
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return;
            }
            Request requestBuild = new Request.Builder().url(httpUrl.newBuilder().build()).get().build();
            LogUtil.d(t24.f44832a, "url[" + requestBuild.url().url().toString() + "]");
            f39418a.newCall(requestBuild).enqueue(new i(yVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, y<n0> yVar) {
        try {
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return;
            }
            Request.Builder builderUrl = new Request.Builder().url(httpUrl.newBuilder().build());
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            builderUrl.post(builder.build());
            Request requestBuild = builderUrl.build();
            LogUtil.d(t24.f44832a, "url[" + requestBuild.url().url().toString() + "]");
            f39418a.newCall(requestBuild).enqueue(new g(yVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Request request, x xVar) {
        if (request == null) {
            return;
        }
        try {
            LogUtil.d(t24.f44832a, "url[" + request.url().url().toString() + "]");
            f39418a.newCall(request).enqueue(new h(xVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Request request, Callback callback) {
        if (b == null) {
            b();
        }
        b.newCall(request).enqueue(callback);
    }

    public static void b() {
        if (b != null) {
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        b = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).hostnameVerifier(new f()).build();
    }
}
