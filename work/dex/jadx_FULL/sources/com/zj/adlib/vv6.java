package com.zj.adlib;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class vv6 implements Producer<rm1<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f45462a = "PostprocessorProducer";

    @VisibleForTesting
    public static final String b = "Postprocessor";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlatformBitmapFactory f20330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<rm1<CloseableImage>> f20331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f20332a;

    public class b extends DelegatingConsumer<rm1<CloseableImage>, rm1<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProducerListener f45463a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Postprocessor f20333a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        public rm1<CloseableImage> f20334a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f20336a;

        @GuardedBy("PostprocessorConsumer.this")
        public boolean b;

        @GuardedBy("PostprocessorConsumer.this")
        public boolean c;

        @GuardedBy("PostprocessorConsumer.this")
        public boolean d;

        @GuardedBy("PostprocessorConsumer.this")
        public boolean e;

        public class a extends qq0 {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ vv6 f20337a;

            public a(vv6 vv6Var) {
                this.f20337a = vv6Var;
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void b() {
                b.this.q();
            }
        }

        /* JADX INFO: renamed from: com.zj.adlib.vv6$b$b, reason: collision with other inner class name */
        public class RunnableC1334b implements Runnable {
            public RunnableC1334b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                rm1 rm1Var;
                boolean z;
                synchronized (b.this) {
                    rm1Var = b.this.f20334a;
                    z = b.this.c;
                    b.this.f20334a = null;
                    b.this.d = false;
                }
                if (rm1.F(rm1Var)) {
                    try {
                        b.this.n(rm1Var, z);
                        rm1.p(rm1Var);
                    } catch (Throwable th) {
                        rm1.p(rm1Var);
                        throw th;
                    }
                }
                b.this.l();
            }
        }

        public b(Consumer<rm1<CloseableImage>> consumer, ProducerListener producerListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.f20334a = null;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f45463a = producerListener;
            this.f20336a = str;
            this.f20333a = postprocessor;
            producerContext.g(new a(vv6.this));
        }

        public final void l() {
            boolean zU;
            synchronized (this) {
                this.e = false;
                zU = u();
            }
            if (zU) {
                w();
            }
        }

        public final boolean m() {
            synchronized (this) {
                if (this.b) {
                    return false;
                }
                rm1<CloseableImage> rm1Var = this.f20334a;
                this.f20334a = null;
                this.b = true;
                rm1.p(rm1Var);
                return true;
            }
        }

        public final void n(rm1<CloseableImage> rm1Var, boolean z) {
            ax6.d(rm1.F(rm1Var));
            if (!v(rm1Var.s())) {
                s(rm1Var, z);
                return;
            }
            this.f45463a.g(this.f20336a, vv6.f45462a);
            try {
                try {
                    rm1<CloseableImage> rm1VarT = t(rm1Var.s());
                    ProducerListener producerListener = this.f45463a;
                    String str = this.f20336a;
                    producerListener.c(str, vv6.f45462a, o(producerListener, str, this.f20333a));
                    s(rm1VarT, z);
                    rm1.p(rm1VarT);
                } catch (Exception e) {
                    ProducerListener producerListener2 = this.f45463a;
                    String str2 = this.f20336a;
                    producerListener2.j(str2, vv6.f45462a, e, o(producerListener2, str2, this.f20333a));
                    r(e);
                    rm1.p(null);
                }
            } catch (Throwable th) {
                rm1.p(null);
                throw th;
            }
        }

        public final Map<String, String> o(ProducerListener producerListener, String str, Postprocessor postprocessor) {
            if (producerListener.h(str)) {
                return ImmutableMap.of(vv6.b, postprocessor.getName());
            }
            return null;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            q();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            r(th);
        }

        public final synchronized boolean p() {
            return this.b;
        }

        public final void q() {
            if (m()) {
                d().a();
            }
        }

        public final void r(Throwable th) {
            if (m()) {
                d().onFailure(th);
            }
        }

        public final void s(rm1<CloseableImage> rm1Var, boolean z) {
            if ((z || p()) && !(z && m())) {
                return;
            }
            d().c(rm1Var, z);
        }

        public final rm1<CloseableImage> t(CloseableImage closeableImage) {
            sm1 sm1Var = (sm1) closeableImage;
            rm1<Bitmap> rm1VarA = this.f20333a.a(sm1Var.k(), vv6.this.f20330a);
            try {
                return rm1.H(new sm1(rm1VarA, closeableImage.g(), sm1Var.q()));
            } finally {
                rm1.p(rm1VarA);
            }
        }

        public final synchronized boolean u() {
            if (this.b || !this.d || this.e || !rm1.F(this.f20334a)) {
                return false;
            }
            this.e = true;
            return true;
        }

        public final boolean v(CloseableImage closeableImage) {
            return closeableImage instanceof sm1;
        }

        public final void w() {
            vv6.this.f20332a.execute(new RunnableC1334b());
        }

        public final void x(@Nullable rm1<CloseableImage> rm1Var, boolean z) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                rm1<CloseableImage> rm1Var2 = this.f20334a;
                this.f20334a = rm1.l(rm1Var);
                this.c = z;
                this.d = true;
                boolean zU = u();
                rm1.p(rm1Var2);
                if (zU) {
                    w();
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(rm1<CloseableImage> rm1Var, boolean z) {
            if (rm1.F(rm1Var)) {
                x(rm1Var, z);
            } else if (z) {
                s(null, true);
            }
        }
    }

    public class c extends DelegatingConsumer<rm1<CloseableImage>, rm1<CloseableImage>> implements RepeatedPostprocessorRunner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        public rm1<CloseableImage> f45466a;

        @GuardedBy("RepeatedPostprocessorConsumer.this")
        public boolean b;

        public class a extends qq0 {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ vv6 f20339a;

            public a(vv6 vv6Var) {
                this.f20339a = vv6Var;
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void b() {
                if (c.this.f()) {
                    c.this.d().a();
                }
            }
        }

        public final boolean f() {
            synchronized (this) {
                if (this.b) {
                    return false;
                }
                rm1<CloseableImage> rm1Var = this.f45466a;
                this.f45466a = null;
                this.b = true;
                rm1.p(rm1Var);
                return true;
            }
        }

        public final void g(rm1<CloseableImage> rm1Var) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                rm1<CloseableImage> rm1Var2 = this.f45466a;
                this.f45466a = rm1.l(rm1Var);
                rm1.p(rm1Var2);
            }
        }

        public final void h() {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                rm1<CloseableImage> rm1VarL = rm1.l(this.f45466a);
                try {
                    d().c(rm1VarL, false);
                } finally {
                    rm1.p(rm1VarL);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            if (f()) {
                d().a();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            if (f()) {
                d().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            h();
        }

        public c(b bVar, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(bVar);
            this.b = false;
            this.f45466a = null;
            repeatedPostprocessor.c(this);
            producerContext.g(new a(vv6.this));
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(rm1<CloseableImage> rm1Var, boolean z) {
            if (z) {
                g(rm1Var);
                h();
            }
        }
    }

    public class d extends DelegatingConsumer<rm1<CloseableImage>, rm1<CloseableImage>> {
        public d(b bVar) {
            super(bVar);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(rm1<CloseableImage> rm1Var, boolean z) {
            if (z) {
                d().c(rm1Var, z);
            }
        }
    }

    public vv6(Producer<rm1<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.f20331a = (Producer) ax6.i(producer);
        this.f20330a = platformBitmapFactory;
        this.f20332a = (Executor) ax6.i(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener producerListenerC = producerContext.c();
        Postprocessor postprocessorH = producerContext.b().h();
        b bVar = new b(consumer, producerListenerC, producerContext.getId(), postprocessorH, producerContext);
        this.f20331a.a(postprocessorH instanceof RepeatedPostprocessor ? new c(bVar, (RepeatedPostprocessor) postprocessorH, producerContext) : new d(bVar), producerContext);
    }
}
