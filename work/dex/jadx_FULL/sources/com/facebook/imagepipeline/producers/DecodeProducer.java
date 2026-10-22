package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.request.ImageRequest;
import com.zj.adlib.ar2;
import com.zj.adlib.ax6;
import com.zj.adlib.l17;
import com.zj.adlib.p84;
import com.zj.adlib.q13;
import com.zj.adlib.qq0;
import com.zj.adlib.rm1;
import com.zj.adlib.sm1;
import com.zj.adlib.th9;
import com.zj.adlib.x64;
import com.zj.adlib.z64;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DecodeProducer implements Producer<rm1<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30006a = "DecodeProducer";
    public static final String b = "bitmapSize";
    public static final String c = "hasGoodQuality";
    public static final String d = "imageType";
    public static final String e = "isFinal";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProgressiveJpegConfig f1659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteArrayPool f1660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<q13> f1661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z64 f1662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f1663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1664a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f1665b;

    public abstract class ProgressiveDecoder extends DelegatingConsumer<q13, rm1<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final JobScheduler f1666a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ProducerContext f1667a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ProducerListener f1668a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final x64 f1669a;

        @GuardedBy("this")
        public boolean b;

        public class a implements JobScheduler.JobRunnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DecodeProducer f1670a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ProducerContext f1671a;

            public a(DecodeProducer decodeProducer, ProducerContext producerContext) {
                this.f1670a = decodeProducer;
                this.f1671a = producerContext;
            }

            @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
            public void a(q13 q13Var, boolean z) {
                if (q13Var != null) {
                    if (DecodeProducer.this.f1664a) {
                        ImageRequest imageRequestB = this.f1671a.b();
                        if (DecodeProducer.this.f1665b || !th9.i(imageRequestB.o())) {
                            q13Var.S(ar2.b(imageRequestB, q13Var));
                        }
                    }
                    ProgressiveDecoder.this.h(q13Var, z);
                }
            }
        }

        public class b extends qq0 {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DecodeProducer f1672a;

            public b(DecodeProducer decodeProducer) {
                this.f1672a = decodeProducer;
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void a() {
                if (ProgressiveDecoder.this.f1667a.d()) {
                    ProgressiveDecoder.this.f1666a.h();
                }
            }
        }

        public ProgressiveDecoder(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext) {
            super(consumer);
            this.f1667a = producerContext;
            this.f1668a = producerContext.c();
            x64 x64VarD = producerContext.b().d();
            this.f1669a = x64VarD;
            this.b = false;
            this.f1666a = new JobScheduler(DecodeProducer.this.f1663a, new a(DecodeProducer.this, producerContext), x64VarD.f20608a);
            producerContext.g(new b(DecodeProducer.this));
        }

        public abstract int getIntermediateImageEndOffset(q13 q13Var);

        public abstract QualityInfo getQualityInfo();

        public final void h(q13 q13Var, boolean z) {
            if (m() || !q13.H(q13Var)) {
                return;
            }
            try {
                long jF = this.f1666a.f();
                int iV = z ? q13Var.v() : getIntermediateImageEndOffset(q13Var);
                QualityInfo qualityInfo = z ? p84.f43926a : getQualityInfo();
                this.f1668a.g(this.f1667a.getId(), DecodeProducer.f30006a);
                try {
                    CloseableImage closeableImageC = DecodeProducer.this.f1662a.c(q13Var, iV, qualityInfo, this.f1669a);
                    this.f1668a.c(this.f1667a.getId(), DecodeProducer.f30006a, i(closeableImageC, jF, qualityInfo, z));
                    l(closeableImageC, z);
                    q13.j(q13Var);
                } catch (Exception e) {
                    this.f1668a.j(this.f1667a.getId(), DecodeProducer.f30006a, e, i(null, jF, qualityInfo, z));
                    k(e);
                    q13.j(q13Var);
                }
            } catch (Throwable th) {
                q13.j(q13Var);
                throw th;
            }
        }

        public final Map<String, String> i(@Nullable CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z) {
            if (!this.f1668a.h(this.f1667a.getId())) {
                return null;
            }
            String strValueOf = String.valueOf(j);
            String strValueOf2 = String.valueOf(qualityInfo.a());
            String strValueOf3 = String.valueOf(z);
            String strValueOf4 = String.valueOf(this.f1667a.b().e());
            if (!(closeableImage instanceof sm1)) {
                return ImmutableMap.of(JobScheduler.f30012a, strValueOf, DecodeProducer.c, strValueOf2, DecodeProducer.e, strValueOf3, DecodeProducer.d, strValueOf4);
            }
            Bitmap bitmapK = ((sm1) closeableImage).k();
            return ImmutableMap.of(DecodeProducer.b, bitmapK.getWidth() + "x" + bitmapK.getHeight(), JobScheduler.f30012a, strValueOf, DecodeProducer.c, strValueOf2, DecodeProducer.e, strValueOf3, DecodeProducer.d, strValueOf4);
        }

        public final void j() {
            n(true);
            d().a();
        }

        public final void k(Throwable th) {
            n(true);
            d().onFailure(th);
        }

        public final void l(CloseableImage closeableImage, boolean z) {
            rm1<CloseableImage> rm1VarH = rm1.H(closeableImage);
            try {
                n(z);
                d().c(rm1VarH, z);
            } finally {
                rm1.p(rm1VarH);
            }
        }

        public final synchronized boolean m() {
            return this.b;
        }

        public final void n(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.b) {
                        this.b = true;
                        this.f1666a.c();
                    }
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            j();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            k(th);
        }

        public boolean updateDecodeJob(q13 q13Var, boolean z) {
            return this.f1666a.k(q13Var, z);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(q13 q13Var, boolean z) {
            if (z && !q13.H(q13Var)) {
                k(new NullPointerException("Encoded image is not valid."));
            } else if (updateDecodeJob(q13Var, z)) {
                if (z || this.f1667a.d()) {
                    this.f1666a.h();
                }
            }
        }
    }

    public class a extends ProgressiveDecoder {
        public a(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(q13 q13Var) {
            return q13Var.v();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            return p84.d(0, false, false);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(q13 q13Var, boolean z) {
            if (!z) {
                return false;
            }
            return super.updateDecodeJob(q13Var, z);
        }
    }

    public class b extends ProgressiveDecoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30010a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ProgressiveJpegConfig f1673a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final l17 f1674a;

        public b(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext, l17 l17Var, ProgressiveJpegConfig progressiveJpegConfig) {
            super(consumer, producerContext);
            this.f1674a = (l17) ax6.i(l17Var);
            this.f1673a = (ProgressiveJpegConfig) ax6.i(progressiveJpegConfig);
            this.f30010a = 0;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(q13 q13Var) {
            return this.f1674a.c();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            return this.f1673a.b(this.f1674a.d());
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(q13 q13Var, boolean z) {
            boolean zUpdateDecodeJob = super.updateDecodeJob(q13Var, z);
            if (!z && q13.H(q13Var)) {
                if (!this.f1674a.g(q13Var)) {
                    return false;
                }
                int iD = this.f1674a.d();
                int i = this.f30010a;
                if (iD > i && iD >= this.f1673a.a(i)) {
                    this.f30010a = iD;
                }
                return false;
            }
            return zUpdateDecodeJob;
        }
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, z64 z64Var, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, Producer<q13> producer) {
        this.f1660a = (ByteArrayPool) ax6.i(byteArrayPool);
        this.f1663a = (Executor) ax6.i(executor);
        this.f1662a = (z64) ax6.i(z64Var);
        this.f1659a = (ProgressiveJpegConfig) ax6.i(progressiveJpegConfig);
        this.f1664a = z;
        this.f1665b = z2;
        this.f1661a = (Producer) ax6.i(producer);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext) {
        this.f1661a.a(!th9.i(producerContext.b().o()) ? new a(consumer, producerContext) : new b(consumer, producerContext, new l17(this.f1660a), this.f1659a), producerContext);
    }
}
