package com.efs.sdk.net;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class OkHttpInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f29900a = g.c();

    public static class a extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResponseBody f29901a;
        private final BufferedSource b;

        public a(ResponseBody responseBody, InputStream inputStream) {
            this.f29901a = responseBody;
            this.b = Okio.buffer(Okio.source(inputStream));
        }

        public final long contentLength() {
            return this.f29901a.contentLength();
        }

        public final MediaType contentType() {
            return this.f29901a.contentType();
        }

        public final BufferedSource source() {
            return this.b;
        }
    }

    public static class b implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29902a;
        private final Request b;
        private h c;

        public b(String str, Request request, h hVar) {
            this.f29902a = str;
            this.b = request;
            this.c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.c
        public final String a() {
            return this.f29902a;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String b() {
            return this.b.url().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String c() {
            return this.b.method();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        @Nullable
        public final byte[] d() {
            OutputStream inflaterOutputStream;
            RequestBody requestBodyBody = this.b.body();
            if (requestBodyBody == null) {
                return null;
            }
            h hVar = this.c;
            String strHeader = this.b.header("Content-Encoding");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if ("gzip".equals(strHeader)) {
                inflaterOutputStream = e.a(byteArrayOutputStream);
            } else {
                inflaterOutputStream = "deflate".equals(strHeader) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
            }
            com.efs.sdk.net.a.a.a aVar = new com.efs.sdk.net.a.a.a(inflaterOutputStream);
            hVar.c = aVar;
            hVar.b = byteArrayOutputStream;
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(aVar));
            try {
                requestBodyBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                h hVar2 = this.c;
                hVar2.b();
                return hVar2.b.toByteArray();
            } catch (Throwable th) {
                bufferedSinkBuffer.close();
                throw th;
            }
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.b.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i) {
            return this.b.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i) {
            return this.b.headers().value(i);
        }
    }

    public static class c implements f.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29903a;
        private final Request b;
        private final Response c;

        @Nullable
        private final Connection d;

        public c(String str, Request request, Response response, @Nullable Connection connection) {
            this.f29903a = str;
            this.b = request;
            this.c = response;
            this.d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final String a() {
            return this.f29903a;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final int b() {
            return this.c.code();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.c.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i) {
            return this.c.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i) {
            return this.c.headers().value(i);
        }
    }

    public Response intercept(Interceptor.Chain chain) {
        String str;
        boolean z;
        h hVar;
        h hVar2;
        boolean zEnableTracer;
        String strB;
        MediaType mediaTypeContentType;
        InputStream inputStreamByteStream;
        Request request = chain.request();
        try {
            Log.d("NetTrace-Interceptor", "begin intercept");
            zEnableTracer = NetManager.getNetConfigManager() != null ? NetManager.getNetConfigManager().enableTracer() : false;
            if (zEnableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                if (request != null) {
                    Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
                } else {
                    Log.d("NetTrace-Interceptor", "intercept request is null~");
                }
                strB = this.f29900a.b();
                try {
                    Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(strB)));
                    com.efs.sdk.net.a.a.a().a(strB).c = request.url().toString();
                    hVar2 = new h(this.f29900a, strB);
                    try {
                        this.f29900a.a(new b(strB, request, hVar2));
                    } catch (Throwable th) {
                        boolean z2 = zEnableTracer;
                        hVar = hVar2;
                        th = th;
                        str = strB;
                        z = z2;
                        th.printStackTrace();
                        hVar2 = hVar;
                        zEnableTracer = z;
                        strB = str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = strB;
                    z = zEnableTracer;
                    hVar = null;
                }
            } else {
                Log.d("NetTrace-Interceptor", "net enable is false~");
                hVar2 = null;
                strB = null;
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            z = false;
            hVar = null;
        }
        Response responseProceed = chain.proceed(request);
        if (!zEnableTracer) {
            try {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    return responseProceed;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return responseProceed;
            }
        }
        if (hVar2 != null && hVar2.a()) {
            hVar2.b();
            f fVar = hVar2.f29913a;
            hVar2.b.size();
            fVar.a();
        }
        Connection connection = chain.connection();
        if (connection == null) {
            throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
        }
        this.f29900a.a(new c(strB, request, responseProceed, connection));
        ResponseBody responseBodyBody = responseProceed.body();
        if (responseBodyBody != null) {
            mediaTypeContentType = responseBodyBody.contentType();
            inputStreamByteStream = responseBodyBody.byteStream();
        } else {
            mediaTypeContentType = null;
            inputStreamByteStream = null;
        }
        f fVar2 = this.f29900a;
        String string = mediaTypeContentType != null ? mediaTypeContentType.toString() : null;
        String strHeader = responseProceed.header("Content-Encoding");
        new com.efs.sdk.net.a.a.c(this.f29900a, strB);
        InputStream inputStreamA = fVar2.a(strB, string, strHeader, inputStreamByteStream);
        return inputStreamA != null ? responseProceed.newBuilder().body(new a(responseBodyBody, inputStreamA)).build() : responseProceed;
    }
}
