package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ProducerContext {
    boolean a();

    ImageRequest b();

    ProducerListener c();

    boolean d();

    Priority e();

    Object f();

    void g(ProducerContextCallbacks producerContextCallbacks);

    String getId();

    ImageRequest.RequestLevel h();
}
