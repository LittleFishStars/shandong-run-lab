package com.czhj.sdk.common.network;

import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Request;
import com.czhj.volley.toolbox.BaseHttpStack;
import com.czhj.volley.toolbox.HttpResponse;
import com.czhj.volley.toolbox.HurlStack;
import com.czhj.volley.toolbox.OkHttp3Stack;
import com.czhj.volley.toolbox.Volley;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class RequestQueueHttpStack extends BaseHttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BaseHttpStack f29417a;

    private RequestQueueHttpStack() {
        if (Volley.isEnableOkhttp3()) {
            try {
                this.f29417a = new OkHttp3Stack();
            } catch (Throwable unused) {
            }
        }
        if (this.f29417a == null) {
            this.f29417a = new HurlStack();
        }
    }

    public RequestQueueHttpStack(SSLSocketFactory sSLSocketFactory) {
        if (Volley.isEnableOkhttp3()) {
            try {
                this.f29417a = new OkHttp3Stack(sSLSocketFactory);
            } catch (Throwable unused) {
            }
        }
        if (this.f29417a == null) {
            this.f29417a = new HurlStack(null, sSLSocketFactory);
        }
    }

    @Override // com.czhj.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws AuthFailureError, IOException {
        if (map == null || map.isEmpty()) {
            map = new TreeMap<>();
        }
        map.put(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
        return this.f29417a.executeRequest(request, map);
    }
}
