package com.getui.gtc.base.http;

import android.net.Network;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Request {
    private RequestBody body;
    private Interceptor cryptInterceptor;
    private Map<String, String> headers;
    private int logFlags;
    private String method;
    private Network network;
    private String tag;
    private URL url;

    public static class Builder {
        RequestBody body;
        Interceptor cryptInterceptor;
        Map<String, String> headers;
        int logFlags;
        String method;
        Network network;
        String tag;
        URL url;

        public Builder() {
            this.method = "GET";
            this.headers = new HashMap();
            this.tag = "";
            this.logFlags = -1;
        }

        public Builder(Request request) {
            this.url = request.url;
            this.method = request.method;
            this.network = request.network;
            this.body = request.body;
            this.headers = request.headers;
            this.tag = request.tag;
            this.logFlags = request.logFlags;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public Builder body(RequestBody requestBody) {
            this.body = requestBody;
            return this;
        }

        @Deprecated
        public Builder body(byte[] bArr) {
            if (bArr == null) {
                return this;
            }
            this.body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), bArr);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder cryptInterceptor(Interceptor interceptor) {
            this.cryptInterceptor = interceptor;
            return this;
        }

        public Builder headers(Map<String, String> map) {
            this.headers.clear();
            this.headers.putAll(map);
            return this;
        }

        public Builder logFlags(int i) {
            this.logFlags = i;
            return this;
        }

        public Builder method(String str) {
            this.method = str;
            return this;
        }

        public Builder network(Network network) {
            this.network = network;
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.remove(str);
            return this;
        }

        public Builder tag(String str) {
            this.tag = str;
            return this;
        }

        public Builder url(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            try {
                return url(new URL(str));
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public Builder url(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            this.url = url;
            return this;
        }
    }

    private Request() {
    }

    private Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.network = builder.network;
        HashMap map = new HashMap();
        this.headers = map;
        map.putAll(builder.headers);
        this.body = builder.body;
        this.cryptInterceptor = builder.cryptInterceptor;
        this.tag = builder.tag;
        this.logFlags = builder.logFlags;
    }

    public RequestBody body() {
        return this.body;
    }

    public Interceptor cryptInterceptor() {
        return this.cryptInterceptor;
    }

    public String header(String str) {
        return this.headers.get(str);
    }

    public Map<String, String> headers() {
        return this.headers;
    }

    public int logFlags() {
        return this.logFlags;
    }

    public String method() {
        return this.method;
    }

    public Network network() {
        return this.network;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public String tag() {
        return this.tag;
    }

    public URL url() {
        return this.url;
    }
}
