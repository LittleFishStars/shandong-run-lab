package com.getui.gtc.base.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CallServerInterceptor implements Interceptor {
    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpURLConnection httpURLConnectionConnection = chain.connection();
        if (httpURLConnectionConnection.getDoOutput() && request.body() != null) {
            OutputStream outputStream = httpURLConnectionConnection.getOutputStream();
            request.body().writeTo(outputStream);
            Util.closeQuietly(outputStream);
        }
        int responseCode = httpURLConnectionConnection.getResponseCode();
        Map<String, List<String>> headerFields = httpURLConnectionConnection.getHeaderFields();
        MediaType mediaType = MediaType.parse("text/json; charset=utf-8");
        if (httpURLConnectionConnection.getContentType() != null) {
            mediaType = MediaType.parse(httpURLConnectionConnection.getContentType());
        }
        return new Response.Builder().code(responseCode).headers(headerFields).message(httpURLConnectionConnection.getResponseMessage()).body(ResponseBody.create(mediaType, httpURLConnectionConnection.getContentLength(), responseCode == 200 ? httpURLConnectionConnection.getInputStream() : httpURLConnectionConnection.getErrorStream())).request(request).build();
    }
}
