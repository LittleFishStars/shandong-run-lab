package com.alibaba.triver.open.prefetch.context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpPrefetchContext extends PrefetchContext implements Serializable {
    public HttpParams params;

    public static class HttpParams implements Serializable {
        public JSONObject apiParams;
        public Map<String, String> header;
        public String url;
        public String requestType = "GET";
        public String charset = "UTF-8";
        public int timeout = 3000;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("url=");
            sb.append(this.url);
            sb.append("requestType=");
            sb.append(this.requestType);
            sb.append("charset=");
            sb.append(this.charset);
            sb.append("timeout=");
            sb.append(this.timeout);
            sb.append("header=");
            Map<String, String> map = this.header;
            sb.append(map == null ? "{}" : JSON.toJSONString(map));
            sb.append("apiParams=");
            JSONObject jSONObject = this.apiParams;
            sb.append(jSONObject != null ? JSON.toJSONString(jSONObject) : "{}");
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", params=");
        HttpParams httpParams = this.params;
        sb.append(httpParams == null ? "{}" : httpParams.toString());
        return sb.toString();
    }
}
