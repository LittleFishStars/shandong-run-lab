package com.zj.adlib;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class lf7 implements RequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43055a = "RequestLoggingListener";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final Map<Pair<String, String>, Long> f17931a = new HashMap();

    @GuardedBy("this")
    public final Map<String, Long> b = new HashMap();

    public static long k(@Nullable Long l, long j) {
        if (l != null) {
            return j - l.longValue();
        }
        return -1L;
    }

    public static long l() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void a(String str) {
        if (ad3.R(2)) {
            Long lRemove = this.b.remove(str);
            long jL = l();
            ad3.f0(f43055a, "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(jL), str, Long.valueOf(k(lRemove, jL)));
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void b(ImageRequest imageRequest, String str, boolean z) {
        if (ad3.R(2)) {
            Long lRemove = this.b.remove(str);
            long jL = l();
            ad3.f0(f43055a, "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(jL), str, Long.valueOf(k(lRemove, jL)));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void c(String str, String str2, @Nullable Map<String, String> map) {
        if (ad3.R(2)) {
            Long lRemove = this.f17931a.remove(Pair.create(str, str2));
            long jL = l();
            ad3.i0(f43055a, "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(jL), str, str2, Long.valueOf(k(lRemove, jL)), map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void d(String str, String str2, String str3) {
        if (ad3.R(2)) {
            ad3.i0(f43055a, "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", Long.valueOf(l()), str, str2, str3, Long.valueOf(k(this.f17931a.get(Pair.create(str, str2)), l())));
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void e(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        if (ad3.R(5)) {
            Long lRemove = this.b.remove(str);
            long jL = l();
            ad3.q0(f43055a, "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(jL), str, Long.valueOf(k(lRemove, jL)), th.toString());
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void f(ImageRequest imageRequest, Object obj, String str, boolean z) {
        if (ad3.R(2)) {
            ad3.g0(f43055a, "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(l()), str, obj, Boolean.valueOf(z));
            this.b.put(str, Long.valueOf(l()));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void g(String str, String str2) {
        if (ad3.R(2)) {
            Pair<String, String> pairCreate = Pair.create(str, str2);
            long jL = l();
            this.f17931a.put(pairCreate, Long.valueOf(jL));
            ad3.f0(f43055a, "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(jL), str, str2);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean h(String str) {
        return ad3.R(2);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void i(String str, String str2, @Nullable Map<String, String> map) {
        if (ad3.R(2)) {
            Long lRemove = this.f17931a.remove(Pair.create(str, str2));
            long jL = l();
            ad3.i0(f43055a, "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(jL), str, str2, Long.valueOf(k(lRemove, jL)), map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void j(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        if (ad3.R(5)) {
            Long lRemove = this.f17931a.remove(Pair.create(str, str2));
            long jL = l();
            ad3.q0(f43055a, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(jL), str, str2, Long.valueOf(k(lRemove, jL)), map, th.toString());
        }
    }
}
