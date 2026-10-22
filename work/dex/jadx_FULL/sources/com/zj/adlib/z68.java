package com.zj.adlib;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class z68 extends pq0 {
    public z68(ImageRequest imageRequest, String str, ProducerListener producerListener, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        super(imageRequest, str, producerListener, obj, requestLevel, z, z2, priority);
    }

    public void s(boolean z) {
        pq0.j(p(z));
    }

    public void t(boolean z) {
        pq0.k(q(z));
    }

    public void u(Priority priority) {
        pq0.l(r(priority));
    }
}
