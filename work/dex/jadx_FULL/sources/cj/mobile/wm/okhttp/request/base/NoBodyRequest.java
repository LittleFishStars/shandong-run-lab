package cj.mobile.wm.okhttp.request.base;

import cj.mobile.wm.okhttp.request.base.NoBodyRequest;
import cj.mobile.wm.okhttp.utils.HttpUtils;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class NoBodyRequest<T, R extends NoBodyRequest> extends Request<T, R> {
    public static final long serialVersionUID = 1200621102761691196L;

    public NoBodyRequest(String str) {
        super(str);
    }

    @Override // cj.mobile.wm.okhttp.request.base.Request
    public RequestBody generateRequestBody() {
        return null;
    }

    public okhttp3.Request.Builder generateRequestBuilder(RequestBody requestBody) {
        this.url = HttpUtils.createUrlFromParams(this.baseUrl, this.params.urlParamsMap);
        return HttpUtils.appendHeaders(new okhttp3.Request.Builder(), this.headers);
    }
}
