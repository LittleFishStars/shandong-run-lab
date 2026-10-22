package com.getui.gtc.base.http;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Response implements Closeable {
    final ResponseBody body;
    final int code;
    final Map<String, List<String>> headers;
    final String message;
    final Request request;

    public static class Builder {
        ResponseBody body;
        int code;
        Map<String, List<String>> headers;
        String message;
        Request request;

        public Builder() {
            this.code = -1;
            this.headers = new HashMap();
        }

        public Builder(Response response) {
            this.code = -1;
            this.request = response.request;
            this.code = response.code;
            this.message = response.message;
            this.headers = new HashMap(response.headers);
            this.body = response.body;
        }

        public Builder addHeader(String str, String str2) {
            List<String> arrayList = this.headers.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(str2);
            this.headers.put(str, arrayList);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.code >= 0) {
                if (this.message != null) {
                    return new Response(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.code);
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder headers(Map<String, List<String>> map) {
            this.headers = new HashMap(map);
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.remove(str);
            return this;
        }

        public Builder request(Request request) {
            this.request = request;
            return this;
        }

        public Builder setHeader(String str, String str2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            this.headers.put(str, arrayList);
            return this;
        }
    }

    public Response(Builder builder) {
        this.request = builder.request;
        this.code = builder.code;
        this.message = builder.message;
        this.headers = new HashMap(builder.headers);
        this.body = builder.body;
    }

    public ResponseBody body() {
        return this.body;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public int code() {
        return this.code;
    }

    @Deprecated
    public byte[] getBody() {
        try {
            return this.body.bytes();
        } catch (IOException unused) {
            return null;
        }
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public String header(String str) {
        List<String> list = this.headers.get(str);
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("; ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public Map<String, List<String>> headers() {
        return this.headers;
    }

    public String message() {
        return this.message;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Request request() {
        return this.request;
    }
}
