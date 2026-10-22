package cn.hzjizhun.admin.http.net.core;

import cn.hzjizhun.admin.http.net.EasyHttpUtil;
import com.acse.ottn.p3;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Request implements Serializable, Cloneable {
    private static final long serialVersionUID = -6446819668525759443L;
    public HashMap<String, String> headers;
    private Builder mBuilder;
    public Method method;
    public HashMap<String, String> params;
    public String postString;
    public Object tag;
    public String url;

    public static class Builder {
        int connectTimeoutMillis;
        Method method;
        String postString;
        int readTimeoutMills;
        Object tag;
        String url;
        HashMap<String, String> header = new HashMap<>();
        HashMap<String, String> params = new HashMap<>();

        public Builder addHeader(String str, String str2) {
            this.header.put(str, str2);
            return this;
        }

        public Builder addHeaders(HashMap<String, String> map) {
            this.header.putAll(map);
            return this;
        }

        public Builder addParam(String str, String str2) {
            this.params.put(str, str2);
            return this;
        }

        public Builder addParams(HashMap<String, String> map) {
            this.params.putAll(map);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder get() {
            this.method = Method.GET;
            return this;
        }

        public Builder method(Method method) {
            this.method = method;
            return this;
        }

        public Builder post() {
            this.method = Method.POST;
            return this;
        }

        public Builder setConnectTimeoutMillis(int i) {
            this.connectTimeoutMillis = i;
            return this;
        }

        public Builder setReadTimeoutMills(int i) {
            this.readTimeoutMills = i;
            return this;
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            get();
            return this;
        }

        public Builder post(String str) {
            this.postString = str;
            this.method = Method.POST;
            return this;
        }
    }

    public enum Method {
        GET(p3.f),
        POST("post");

        String name;

        Method(String str) {
            this.name = str;
        }
    }

    public Request(Builder builder) {
        this.mBuilder = builder;
        this.url = builder.url;
        this.method = builder.method;
        this.tag = builder.tag;
        this.params = builder.params;
        this.headers = builder.header;
        this.postString = builder.postString;
    }

    public Request newRequest() {
        return new Request(this.mBuilder);
    }

    public String toString() {
        if (this.method != Method.POST) {
            return "url='" + this.url + "', params=" + EasyHttpUtil.formatPostParams(this.params) + ", headers=" + EasyHttpUtil.formatPostParams(this.headers);
        }
        String str = this.postString;
        if (str == null || str.length() <= 0) {
            return "url='" + this.url + "', params=" + EasyHttpUtil.formatPostParams(this.params) + ", headers=" + EasyHttpUtil.formatPostParams(this.headers);
        }
        return "url='" + this.url + "', params=" + EasyHttpUtil.formatPostParams(this.params) + ", postString=" + EasyHttpUtil.formatPostString(this.postString) + ", headers=" + EasyHttpUtil.formatPostParams(this.headers);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Request m80clone() {
        try {
            return (Request) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return newRequest();
        }
    }
}
