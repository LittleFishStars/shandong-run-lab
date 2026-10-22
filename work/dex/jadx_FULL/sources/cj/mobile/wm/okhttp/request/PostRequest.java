package cj.mobile.wm.okhttp.request;

import cj.mobile.wm.okhttp.model.HttpMethod;
import cj.mobile.wm.okhttp.request.base.BodyRequest;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PostRequest<T> extends BodyRequest<T, PostRequest<T>> {
    public PostRequest(String str) {
        super(str);
    }

    @Override // cj.mobile.wm.okhttp.request.base.Request
    public Request generateRequest(RequestBody requestBody) {
        return generateRequestBuilder(requestBody).post(requestBody).url(this.url).tag(this.tag).build();
    }

    @Override // cj.mobile.wm.okhttp.request.base.Request
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
