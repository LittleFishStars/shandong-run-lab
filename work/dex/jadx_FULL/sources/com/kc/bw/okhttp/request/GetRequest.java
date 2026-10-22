package com.kc.bw.okhttp.request;

import com.kc.bw.okhttp.model.HttpMethod;
import com.kc.bw.okhttp.request.base.NoBodyRequest;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GetRequest<T> extends NoBodyRequest<T, GetRequest<T>> {
    public GetRequest(String str) {
        super(str);
    }

    @Override // com.kc.bw.okhttp.request.base.Request
    public Request generateRequest(RequestBody requestBody) {
        return generateRequestBuilder(requestBody).get().url(this.url).tag(this.tag).build();
    }

    @Override // com.kc.bw.okhttp.request.base.Request
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}
