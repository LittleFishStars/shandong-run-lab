package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.zj.adlib.ax6;
import com.zj.adlib.q13;
import com.zj.adlib.qq0;
import com.zj.adlib.rm1;
import com.zj.adlib.sf7;
import com.zj.adlib.tm1;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f30031a = 0.6666667f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final int f1709a = 85;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1710a = "ResizeAndRotateProducer";

    @VisibleForTesting
    public static final int b = 8;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f1711b = "Original size";

    @VisibleForTesting
    public static final int c = 100;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f1712c = "Requested size";
    public static final String d = "Fraction";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PooledByteBufferFactory f1713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<q13> f1714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f1715a;

    public class a extends DelegatingConsumer<q13, q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JobScheduler f30032a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ProducerContext f1716a;
        public boolean b;

        /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.c$a$a, reason: collision with other inner class name */
        public class C0639a implements JobScheduler.JobRunnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ c f1718a;

            public C0639a(c cVar) {
                this.f1718a = cVar;
            }

            @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
            public void a(q13 q13Var, boolean z) throws Throwable {
                a.this.i(q13Var, z);
            }
        }

        public class b extends qq0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Consumer f30034a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ c f1720a;

            public b(c cVar, Consumer consumer) {
                this.f1720a = cVar;
                this.f30034a = consumer;
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void a() {
                if (a.this.f1716a.d()) {
                    a.this.f30032a.h();
                }
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void b() {
                a.this.f30032a.c();
                a.this.b = true;
                this.f30034a.a();
            }
        }

        public a(Consumer<q13> consumer, ProducerContext producerContext) {
            super(consumer);
            this.b = false;
            this.f1716a = producerContext;
            this.f30032a = new JobScheduler(c.this.f1715a, new C0639a(c.this), 100);
            producerContext.g(new b(c.this, consumer));
        }

        public final void i(q13 q13Var, boolean z) throws Throwable {
            this.f1716a.c().g(this.f1716a.getId(), c.f1710a);
            ImageRequest imageRequestB = this.f1716a.b();
            PooledByteBufferOutputStream pooledByteBufferOutputStreamD = c.this.f1713a.d();
            InputStream inputStream = null;
            Map<String, String> map = null;
            try {
                try {
                    int iJ = c.j(imageRequestB, q13Var);
                    Map<String, String> mapJ = j(q13Var, imageRequestB, iJ);
                    try {
                        InputStream inputStreamQ = q13Var.q();
                        JpegTranscoder.b(inputStreamQ, pooledByteBufferOutputStreamD, c.i(imageRequestB, q13Var), iJ, 85);
                        rm1 rm1VarH = rm1.H(pooledByteBufferOutputStreamD.g());
                        try {
                            q13 q13Var2 = new q13((rm1<PooledByteBuffer>) rm1VarH);
                            q13Var2.M(ImageFormat.JPEG);
                            try {
                                q13Var2.J();
                                this.f1716a.c().c(this.f1716a.getId(), c.f1710a, mapJ);
                                d().c(q13Var2, z);
                                q13.j(q13Var2);
                                rm1.p(rm1VarH);
                                tm1.b(inputStreamQ);
                                pooledByteBufferOutputStreamD.close();
                            } catch (Throwable th) {
                                q13.j(q13Var2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            rm1.p(rm1VarH);
                            throw th2;
                        }
                    } catch (Exception e) {
                        e = e;
                        map = mapJ;
                        try {
                            this.f1716a.c().j(this.f1716a.getId(), c.f1710a, e, map);
                            d().onFailure(e);
                            tm1.b(0);
                            pooledByteBufferOutputStreamD.close();
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream;
                            tm1.b(inputStream);
                            pooledByteBufferOutputStreamD.close();
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th4) {
                th = th4;
                tm1.b(inputStream);
                pooledByteBufferOutputStreamD.close();
                throw th;
            }
        }

        public final Map<String, String> j(q13 q13Var, ImageRequest imageRequest, int i) {
            String str;
            String str2;
            if (!this.f1716a.c().h(this.f1716a.getId())) {
                return null;
            }
            String str3 = q13Var.getWidth() + "x" + q13Var.getHeight();
            if (imageRequest.m() != null) {
                str = imageRequest.m().f44682a + "x" + imageRequest.m().b;
            } else {
                str = "Unspecified";
            }
            String str4 = str;
            if (i > 0) {
                str2 = i + "/8";
            } else {
                str2 = "";
            }
            return ImmutableMap.of(c.f1711b, str3, c.f1712c, str4, c.d, str2, JobScheduler.f30012a, String.valueOf(this.f30032a.f()));
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable q13 q13Var, boolean z) {
            if (this.b) {
                return;
            }
            if (q13Var == null) {
                if (z) {
                    d().c(null, true);
                    return;
                }
                return;
            }
            TriState triStateM = c.m(this.f1716a.b(), q13Var);
            if (z || triStateM != TriState.UNSET) {
                if (triStateM != TriState.YES) {
                    d().c(q13Var, z);
                } else if (this.f30032a.k(q13Var, z)) {
                    if (z || this.f1716a.d()) {
                        this.f30032a.h();
                    }
                }
            }
        }
    }

    public c(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<q13> producer) {
        this.f1715a = (Executor) ax6.i(executor);
        this.f1713a = (PooledByteBufferFactory) ax6.i(pooledByteBufferFactory);
        this.f1714a = (Producer) ax6.i(producer);
    }

    @VisibleForTesting
    public static float h(sf7 sf7Var, int i, int i2) {
        if (sf7Var == null) {
            return 1.0f;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(sf7Var.f44682a / f, sf7Var.b / f2);
        if (f * fMax > 2048.0f) {
            fMax = 2048.0f / f;
        }
        return f2 * fMax > 2048.0f ? 2048.0f / f2 : fMax;
    }

    public static int i(ImageRequest imageRequest, q13 q13Var) {
        if (!imageRequest.c()) {
            return 0;
        }
        int iR = q13Var.r();
        ax6.d(iR == 0 || iR == 90 || iR == 180 || iR == 270);
        return iR;
    }

    public static int j(ImageRequest imageRequest, q13 q13Var) {
        sf7 sf7VarM = imageRequest.m();
        if (sf7VarM == null) {
            return 8;
        }
        int i = i(imageRequest, q13Var);
        boolean z = i == 90 || i == 270;
        int iK = k(h(sf7VarM, z ? q13Var.getHeight() : q13Var.getWidth(), z ? q13Var.getWidth() : q13Var.getHeight()));
        if (iK > 8) {
            return 8;
        }
        if (iK < 1) {
            return 1;
        }
        return iK;
    }

    @VisibleForTesting
    public static int k(float f) {
        return (int) ((f * 8.0f) + 0.6666667f);
    }

    public static boolean l(int i) {
        return i < 8;
    }

    public static TriState m(ImageRequest imageRequest, q13 q13Var) {
        if (q13Var == null || q13Var.p() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (q13Var.p() != ImageFormat.JPEG) {
            return TriState.NO;
        }
        return TriState.valueOf(i(imageRequest, q13Var) != 0 || l(j(imageRequest, q13Var)));
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        this.f1714a.a(new a(consumer, producerContext), producerContext);
    }
}
