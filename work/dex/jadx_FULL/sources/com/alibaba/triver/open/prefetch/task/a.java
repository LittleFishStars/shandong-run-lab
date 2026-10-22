package com.alibaba.triver.open.prefetch.task;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.open.api.NetworkOptions;
import com.alibaba.triver.open.prefetch.PrefectchCallback;
import com.alibaba.triver.open.prefetch.context.HttpPrefetchContext;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends c<HttpPrefetchContext> {
    private static final String c = "HttpPrefetchTask";

    public a(HttpPrefetchContext httpPrefetchContext, PrefectchCallback prefectchCallback) {
        super(httpPrefetchContext, prefectchCallback);
    }

    @Override // com.alibaba.triver.open.prefetch.task.c
    public void a(String str, Object... objArr) {
        RVTransportService rVTransportService = (RVTransportService) RVProxy.get(RVTransportService.class);
        if (rVTransportService != null) {
            T t = this.f25075a;
            String str2 = ((HttpPrefetchContext) t).params.url;
            Map<String, String> map = ((HttpPrefetchContext) t).params.header;
            String str3 = ((HttpPrefetchContext) t).params.requestType;
            JSONObject jSONObject = ((HttpPrefetchContext) t).params.apiParams;
            try {
                RVHttpRequest.Builder builderTimeout = RVHttpRequest.newBuilder().timeout(((HttpPrefetchContext) t).params.timeout);
                if ("POST".equalsIgnoreCase(str3)) {
                    builderTimeout.url(str2).method("POST");
                    if (jSONObject != null) {
                        builderTimeout.requestData(jSONObject.toJSONString().getBytes());
                        if (map != null) {
                            try {
                                if (TextUtils.equals("application/x-www-form-urlencoded", map.get("Content-Type"))) {
                                    builderTimeout.requestData(com.alibaba.triver.open.api.b.a(jSONObject).getBytes());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else {
                    builderTimeout.method("GET");
                    Uri.Builder builderBuildUpon = Uri.parse(str2).buildUpon();
                    if (jSONObject != null) {
                        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                            builderBuildUpon.appendQueryParameter(entry.getKey(), (String) entry.getValue());
                        }
                    }
                    builderTimeout.url(builderBuildUpon.build().toString());
                }
                if (map != null) {
                    builderTimeout.headers(map);
                }
                RVHttpRequest rVHttpRequestBuild = builderTimeout.build();
                RVHttpResponse rVHttpResponseHttpRequest = rVTransportService.httpRequest(rVHttpRequestBuild);
                if (rVHttpResponseHttpRequest != null) {
                    com.alibaba.triver.open.prefetch.a.a(rVHttpRequestBuild, rVHttpResponseHttpRequest);
                    this.b.onPreload(PrefectchCallback.PrefetchCallbackType.TYPE_HIT, com.alibaba.triver.open.api.b.a(rVHttpResponseHttpRequest.getStatusCode(), rVHttpResponseHttpRequest.getResStream(), map, NetworkOptions.Type.text));
                }
            } catch (Exception e) {
                RVLogger.e(c, "execute PrefetchTask error, type=" + ((HttpPrefetchContext) this.f25075a).type, e);
            }
        }
    }

    @Override // com.alibaba.triver.open.prefetch.task.c
    public boolean b(String str, Object... objArr) {
        T t = this.f25075a;
        return (t == 0 || ((HttpPrefetchContext) t).params == null || TextUtils.isEmpty(((HttpPrefetchContext) t).params.url)) ? false : true;
    }
}
