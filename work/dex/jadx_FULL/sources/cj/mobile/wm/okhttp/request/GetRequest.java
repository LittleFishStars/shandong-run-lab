package cj.mobile.wm.okhttp.request;

import cj.mobile.wm.okhttp.model.HttpMethod;
import cj.mobile.wm.okhttp.request.base.NoBodyRequest;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetRequest<T> extends NoBodyRequest<T, GetRequest<T>> {
    public GetRequest(String str) {
        super(str);
    }

    @Override // cj.mobile.wm.okhttp.request.base.Request
    public Request generateRequest(RequestBody requestBody) {
        return generateRequestBuilder(requestBody).get().url(this.url).tag(this.tag).build();
    }

    @Override // cj.mobile.wm.okhttp.request.base.Request
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}
