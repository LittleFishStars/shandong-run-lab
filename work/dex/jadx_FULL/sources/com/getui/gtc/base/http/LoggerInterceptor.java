package com.getui.gtc.base.http;

import com.getui.gtc.base.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LoggerInterceptor implements Interceptor {
    public static final int BASIC = 1;
    public static final int BODY = 4;
    static final int FLAG_UNSET = -1;
    public static final int HEADER = 2;
    private final int flags;
    private final Logger logger;

    public LoggerInterceptor(Logger logger) {
        this(logger, 5);
    }

    public LoggerInterceptor(Logger logger, int i) {
        this.logger = logger;
        this.flags = i;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Map<String, List<String>> mapHeaders;
        Map<String, String> mapHeaders2;
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        int iLogFlags = request.logFlags();
        if (iLogFlags == -1) {
            iLogFlags = this.flags;
        }
        StringBuilder sb = new StringBuilder();
        int i = iLogFlags & 1;
        if (i == 1) {
            sb.append(request.method() + " " + request.url().toString() + " " + request.tag() + "\n");
        }
        int i2 = iLogFlags & 2;
        if (i2 == 2 && (mapHeaders2 = request.headers()) != null && mapHeaders2.size() > 0) {
            for (Map.Entry<String, String> entry : mapHeaders2.entrySet()) {
                sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
        int i3 = iLogFlags & 4;
        if (i3 == 4 && request.body() != null && request.body().contentType().charset() != null) {
            if (request.body().contentLength() > 2147483647L) {
                sb.append("request body content length: " + request.body().contentLength() + "\n");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                request.body().writeTo(byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sb.append(new String(byteArray, request.body().contentType().charset()) + "\n");
                builderNewBuilder.body(RequestBody.create(request.body().contentType(), byteArray));
            }
        }
        this.logger.d(sb.toString());
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        Response.Builder builderNewBuilder2 = responseProceed.newBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (i == 1) {
            sb2.append(responseProceed.code() + " " + responseProceed.message() + " " + request.url().toString() + " " + request.tag() + "\n");
        }
        if (i2 == 2 && (mapHeaders = responseProceed.headers()) != null && mapHeaders.size() > 0) {
            for (Map.Entry<String, List<String>> entry2 : mapHeaders.entrySet()) {
                if (entry2.getValue() != null && entry2.getValue().size() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    for (int i4 = 0; i4 < entry2.getValue().size(); i4++) {
                        sb3.append(entry2.getValue().get(i4));
                        if (i4 < entry2.getValue().size() - 1) {
                            sb3.append("; ");
                        }
                    }
                    sb2.append(entry2.getKey() + ": " + sb3.toString() + "\n");
                }
            }
        }
        if (i3 == 4 && responseProceed.body() != null && responseProceed.body().contentType().charset() != null) {
            if (responseProceed.body().contentLength() > 2147483647L) {
                sb2.append("response body content length: " + responseProceed.body().contentLength() + "\n");
            } else {
                byte[] bArrBytes = responseProceed.body().bytes();
                sb2.append(new String(bArrBytes, responseProceed.body().charset()) + "\n");
                builderNewBuilder2.body(ResponseBody.create(responseProceed.body().contentType(), bArrBytes));
            }
        }
        this.logger.d(sb2.toString());
        return builderNewBuilder2.build();
    }
}
