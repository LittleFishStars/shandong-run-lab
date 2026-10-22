package com.kc.bw.okhttp.request;

import com.kc.bw.okhttp.model.HttpMethod;
import com.kc.bw.okhttp.request.base.BodyRequest;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PostRequest<T> extends BodyRequest<T, PostRequest<T>> {
    public PostRequest(String str) {
        super(str);
    }

    @Override // com.kc.bw.okhttp.request.base.Request
    public Request generateRequest(RequestBody requestBody) {
        return generateRequestBuilder(requestBody).post(requestBody).url(this.url).tag(this.tag).build();
    }

    @Override // com.kc.bw.okhttp.request.base.Request
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
