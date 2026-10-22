package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class iz4 extends LocalFetchProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f42472a = "LocalFileFetchProducer";

    public iz4(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, boolean z) {
        super(executor, pooledByteBufferFactory, z);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public q13 getEncodedImage(ImageRequest imageRequest) throws IOException {
        return getEncodedImage(new FileInputStream(imageRequest.n().toString()), (int) imageRequest.n().length());
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return f42472a;
    }
}
