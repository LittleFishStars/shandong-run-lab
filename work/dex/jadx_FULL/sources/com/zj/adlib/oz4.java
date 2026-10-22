package com.zj.adlib;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class oz4 extends LocalFetchProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f43859a = "LocalResourceFetchProducer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources f18744a;

    public oz4(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Resources resources, boolean z) {
        super(executor, pooledByteBufferFactory, z);
        this.f18744a = resources;
    }

    public static int d(ImageRequest imageRequest) {
        return Integer.parseInt(imageRequest.o().getPath().substring(1));
    }

    public final int c(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = null;
        try {
            assetFileDescriptorOpenRawResourceFd = this.f18744a.openRawResourceFd(d(imageRequest));
            int length = (int) assetFileDescriptorOpenRawResourceFd.getLength();
            try {
                assetFileDescriptorOpenRawResourceFd.close();
            } catch (IOException unused) {
            }
            return length;
        } catch (Resources.NotFoundException unused2) {
            if (assetFileDescriptorOpenRawResourceFd == null) {
                return -1;
            }
            try {
                assetFileDescriptorOpenRawResourceFd.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        } catch (Throwable th) {
            if (assetFileDescriptorOpenRawResourceFd != null) {
                try {
                    assetFileDescriptorOpenRawResourceFd.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public q13 getEncodedImage(ImageRequest imageRequest) throws IOException {
        return getEncodedImage(this.f18744a.openRawResource(d(imageRequest)), c(imageRequest));
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return f43859a;
    }
}
