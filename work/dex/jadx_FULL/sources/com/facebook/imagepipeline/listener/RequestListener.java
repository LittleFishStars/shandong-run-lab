package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface RequestListener extends ProducerListener {
    void a(String str);

    void b(ImageRequest imageRequest, String str, boolean z);

    void e(ImageRequest imageRequest, String str, Throwable th, boolean z);

    void f(ImageRequest imageRequest, Object obj, String str, boolean z);
}
