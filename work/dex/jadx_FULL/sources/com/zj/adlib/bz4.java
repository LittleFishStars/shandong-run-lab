package com.zj.adlib;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class bz4 extends LocalFetchProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f40867a = "LocalAssetFetchProducer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AssetManager f15661a;

    public bz4(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager, boolean z) {
        super(executor, pooledByteBufferFactory, z);
        this.f15661a = assetManager;
    }

    public static String c(ImageRequest imageRequest) {
        return imageRequest.o().getPath().substring(1);
    }

    public final int d(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            assetFileDescriptorOpenFd = this.f15661a.openFd(c(imageRequest));
            int length = (int) assetFileDescriptorOpenFd.getLength();
            try {
                assetFileDescriptorOpenFd.close();
            } catch (IOException unused) {
            }
            return length;
        } catch (IOException unused2) {
            if (assetFileDescriptorOpenFd == null) {
                return -1;
            }
            try {
                assetFileDescriptorOpenFd.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        } catch (Throwable th) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public q13 getEncodedImage(ImageRequest imageRequest) throws IOException {
        return getEncodedImage(this.f15661a.open(c(imageRequest), 2), d(imageRequest));
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return f40867a;
    }
}
