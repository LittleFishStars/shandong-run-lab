package com.zj.adlib;

import android.net.Uri;
import android.util.Base64;
import com.alipay.sdk.m.y.l;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class u62 extends LocalFetchProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45068a = "DataFetchProducer";

    public u62(PooledByteBufferFactory pooledByteBufferFactory, boolean z) {
        super(ia1.a(), pooledByteBufferFactory, z);
    }

    @VisibleForTesting
    public static byte[] c(String str) {
        ax6.d(str.substring(0, 5).equals("data:"));
        int iIndexOf = str.indexOf(44);
        String strSubstring = str.substring(iIndexOf + 1, str.length());
        return d(str.substring(0, iIndexOf)) ? Base64.decode(strSubstring, 0) : Uri.decode(strSubstring).getBytes();
    }

    @VisibleForTesting
    public static boolean d(String str) {
        if (!str.contains(l.b)) {
            return false;
        }
        String[] strArrSplit = str.split(l.b);
        return strArrSplit[strArrSplit.length - 1].equals("base64");
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public q13 getEncodedImage(ImageRequest imageRequest) throws IOException {
        byte[] bArrC = c(imageRequest.o().toString());
        return getByteBufferBackedEncodedImage(new ByteArrayInputStream(bArrC), bArrC.length);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return f45068a;
    }
}
