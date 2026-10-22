package com.zj.adlib;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class rz4 implements Producer<rm1<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f44568a = "VideoThumbnailProducer";

    @VisibleForTesting
    public static final String b = "createdThumbnail";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f19450a;

    public class a extends StatefulProducerRunnable<rm1<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f44569a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener producerListener, String str, String str2, ImageRequest imageRequest) {
            super(consumer, producerListener, str, str2);
            this.f44569a = imageRequest;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(rm1<CloseableImage> rm1Var) {
            rm1.p(rm1Var);
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
        public Map<String, String> getExtraMapOnSuccess(rm1<CloseableImage> rm1Var) {
            return ImmutableMap.of("createdThumbnail", String.valueOf(rm1Var != null));
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        public rm1<CloseableImage> getResult() throws Exception {
            Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f44569a.n().getPath(), rz4.d(this.f44569a));
            if (bitmapCreateVideoThumbnail == null) {
                return null;
            }
            return rm1.H(new sm1(bitmapCreateVideoThumbnail, gg8.b(), p84.f43926a, 0));
        }
    }

    public class b extends qq0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StatefulProducerRunnable f44570a;

        public b(StatefulProducerRunnable statefulProducerRunnable) {
            this.f44570a = statefulProducerRunnable;
        }

        @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void b() {
            this.f44570a.b();
        }
    }

    public rz4(Executor executor) {
        this.f19450a = executor;
    }

    public static int d(ImageRequest imageRequest) {
        return (imageRequest.j() > 96 || imageRequest.i() > 96) ? 1 : 3;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext) {
        a aVar = new a(consumer, producerContext.c(), f44568a, producerContext.getId(), producerContext.b());
        producerContext.g(new b(aVar));
        this.f19450a.execute(aVar);
    }
}
