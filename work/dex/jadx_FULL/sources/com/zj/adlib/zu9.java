package com.zj.adlib;

import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class zu9 implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46346a = 80;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f21111a = "WebpTranscodeProducer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PooledByteBufferFactory f21112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<q13> f21113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f21114a;

    public class a extends StatefulProducerRunnable<q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q13 f46347a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener producerListener, String str, String str2, q13 q13Var) {
            super(consumer, producerListener, str, str2);
            this.f46347a = q13Var;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void onCancellation() {
            q13.j(this.f46347a);
            super.onCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void onFailure(Exception exc) {
            q13.j(this.f46347a);
            super.onFailure(exc);
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(q13 q13Var) {
            q13.j(q13Var);
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        public q13 getResult() throws Exception {
            PooledByteBufferOutputStream pooledByteBufferOutputStreamD = zu9.this.f21112a.d();
            try {
                zu9.g(this.f46347a, pooledByteBufferOutputStreamD);
                rm1 rm1VarH = rm1.H(pooledByteBufferOutputStreamD.g());
                try {
                    q13 q13Var = new q13((rm1<PooledByteBuffer>) rm1VarH);
                    q13Var.k(this.f46347a);
                    rm1.p(rm1VarH);
                    pooledByteBufferOutputStreamD.close();
                    return q13Var;
                } catch (Throwable th) {
                    rm1.p(rm1VarH);
                    throw th;
                }
            } catch (Throwable th2) {
                pooledByteBufferOutputStreamD.close();
                throw th2;
            }
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void onSuccess(q13 q13Var) {
            q13.j(this.f46347a);
            super.onSuccess(q13Var);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46348a;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            f46348a = iArr;
            try {
                iArr[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46348a[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46348a[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46348a[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46348a[ImageFormat.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class c extends DelegatingConsumer<q13, q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TriState f46349a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ProducerContext f21116a;

        public c(Consumer<q13> consumer, ProducerContext producerContext) {
            super(consumer);
            this.f21116a = producerContext;
            this.f46349a = TriState.UNSET;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable q13 q13Var, boolean z) {
            if (this.f46349a == TriState.UNSET && q13Var != null) {
                this.f46349a = zu9.h(q13Var);
            }
            TriState triState = this.f46349a;
            if (triState == TriState.NO) {
                d().c(q13Var, z);
                return;
            }
            if (z) {
                if (triState != TriState.YES || q13Var == null) {
                    d().c(q13Var, z);
                } else {
                    zu9.this.i(q13Var, d(), this.f21116a);
                }
            }
        }
    }

    public zu9(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<q13> producer) {
        this.f21114a = (Executor) ax6.i(executor);
        this.f21112a = (PooledByteBufferFactory) ax6.i(pooledByteBufferFactory);
        this.f21113a = (Producer) ax6.i(producer);
    }

    public static void g(q13 q13Var, PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Exception {
        InputStream inputStreamQ = q13Var.q();
        int i = b.f46348a[c74.e(inputStreamQ).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalArgumentException("Wrong image format");
                    }
                }
            }
            av9.a().b(inputStreamQ, pooledByteBufferOutputStream);
            return;
        }
        av9.a().a(inputStreamQ, pooledByteBufferOutputStream, 80);
    }

    public static TriState h(q13 q13Var) {
        ax6.i(q13Var);
        ImageFormat imageFormatE = c74.e(q13Var.q());
        int i = b.f46348a[imageFormatE.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return TriState.valueOf(!av9.a().c(imageFormatE));
        }
        return i != 5 ? TriState.NO : TriState.UNSET;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        this.f21113a.a(new c(consumer, producerContext), producerContext);
    }

    public final void i(q13 q13Var, Consumer<q13> consumer, ProducerContext producerContext) {
        ax6.i(q13Var);
        this.f21114a.execute(new a(consumer, producerContext.c(), f21111a, producerContext.getId(), q13.h(q13Var)));
    }
}
