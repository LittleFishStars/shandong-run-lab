package com.czhj.volley;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class ResponseDeliveryRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Request f29472a;
    private final Response b;
    private final Runnable c;

    public ResponseDeliveryRunnable(Request request, Response response, Runnable runnable) {
        this.f29472a = request;
        this.b = response;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f29472a.isCanceled()) {
            this.f29472a.finish("canceled-at-delivery");
            return;
        }
        if (this.b.isSuccess()) {
            this.f29472a.deliverResponse(this.b.result);
        } else {
            this.f29472a.deliverError(this.b.error);
        }
        if (this.b.intermediate) {
            this.f29472a.addMarker("intermediate-response");
        } else {
            this.f29472a.finish("done");
        }
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
