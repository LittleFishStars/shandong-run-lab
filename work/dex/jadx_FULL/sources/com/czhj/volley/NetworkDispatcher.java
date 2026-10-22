package com.czhj.volley;

import android.net.TrafficStats;
import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NetworkDispatcher implements Comparable, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Network f29467a;
    private final ResponseDelivery b;
    private final Request c;
    private volatile boolean d = false;

    public NetworkDispatcher(Network network, Request request, ResponseDelivery responseDelivery) {
        this.c = request;
        this.f29467a = network;
        this.b = responseDelivery;
    }

    private void a(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    private void a(Request<?> request, VolleyError volleyError) {
        this.b.postError(request, request.parseNetworkError(volleyError));
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return (obj == null && hashCode() == obj.hashCode()) ? 0 : 1;
    }

    public void processRequest(Request<?> request) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.finish("network-discard-cancelled");
                request.notifyListenerResponseNotUsable();
                return;
            }
            a(request);
            NetworkResponse networkResponsePerformRequest = this.f29467a.performRequest(request);
            request.addMarker("network-http-complete");
            if (networkResponsePerformRequest.notModified && request.hasHadResponseDelivered()) {
                request.finish("not-modified");
                request.notifyListenerResponseNotUsable();
                return;
            }
            Response<?> networkResponse = request.parseNetworkResponse(networkResponsePerformRequest);
            request.addMarker("network-parse-complete");
            request.markDelivered();
            this.b.postResponse(request, networkResponse);
            request.notifyListenerResponseReceived(networkResponse);
        } catch (VolleyError e) {
            e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            a(request, e);
            request.notifyListenerResponseNotUsable();
        } catch (Throwable th) {
            VolleyLog.e(th, "Unhandled exception %s", th.toString());
            VolleyError volleyError = new VolleyError(th);
            volleyError.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.b.postError(request, volleyError);
            request.notifyListenerResponseNotUsable();
        }
    }

    public void quit() {
        this.d = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        processRequest(this.c);
    }
}
