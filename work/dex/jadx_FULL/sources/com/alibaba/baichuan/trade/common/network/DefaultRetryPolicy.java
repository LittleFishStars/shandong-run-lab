package com.alibaba.baichuan.trade.common.network;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultRetryPolicy implements RetryPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24556a;
    private final int b;

    public DefaultRetryPolicy(int i) {
        this.b = i;
    }

    @Override // com.alibaba.baichuan.trade.common.network.RetryPolicy
    public int getCurrentRetryCount() {
        return this.f24556a;
    }

    @Override // com.alibaba.baichuan.trade.common.network.RetryPolicy
    public HttpResponse retry(String str, HttpRequest httpRequest, Exception exc) throws HttpException {
        int i = this.f24556a + 1;
        this.f24556a = i;
        if (i <= this.b) {
            return NetWorkUtils.get(httpRequest);
        }
        throw new HttpException(String.format("request of type[%s] retry exception: %s", str, exc.getMessage()));
    }
}
