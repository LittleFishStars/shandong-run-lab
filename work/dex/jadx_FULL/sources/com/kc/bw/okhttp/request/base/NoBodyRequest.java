package com.kc.bw.okhttp.request.base;

import com.kc.bw.okhttp.request.base.NoBodyRequest;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class NoBodyRequest<T, R extends NoBodyRequest> extends Request<T, R> {
    public static final long serialVersionUID = 1200621102761691196L;

    public NoBodyRequest(String str) {
        super(str);
    }

    @Override // com.kc.bw.okhttp.request.base.Request
    public RequestBody generateRequestBody() {
        return null;
    }

    public okhttp3.Request.Builder generateRequestBuilder(RequestBody requestBody) {
        this.url = HttpUtils.createUrlFromParams(this.baseUrl, this.params.urlParamsMap);
        return HttpUtils.appendHeaders(new okhttp3.Request.Builder(), this.headers);
    }
}
