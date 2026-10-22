package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import com.zj.adlib.ax6;
import com.zj.adlib.pq0;
import com.zj.adlib.qq0;
import com.zj.adlib.x68;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer<T> f30021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public final Map<K, MultiplexProducer<K, T>.b> f1689a = new HashMap();

    @VisibleForTesting
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("Multiplexer.this")
        public float f30022a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("Multiplexer.this")
        @Nullable
        public MultiplexProducer<K, T>.b.C0637b f1690a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("Multiplexer.this")
        @Nullable
        public pq0 f1692a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("Multiplexer.this")
        @Nullable
        public T f1693a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final K f1694a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> f1695a = x68.a();

        public class a extends qq0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Pair f30023a;

            public a(Pair pair) {
                this.f30023a = pair;
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void a() {
                pq0.j(b.this.r());
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void b() {
                boolean zRemove;
                List list;
                pq0 pq0Var;
                List listT;
                List listR;
                synchronized (b.this) {
                    zRemove = b.this.f1695a.remove(this.f30023a);
                    list = null;
                    if (!zRemove) {
                        pq0Var = null;
                        listT = null;
                    } else if (b.this.f1695a.isEmpty()) {
                        pq0Var = b.this.f1692a;
                        listT = null;
                    } else {
                        List listS = b.this.s();
                        listT = b.this.t();
                        listR = b.this.r();
                        pq0Var = null;
                        list = listS;
                    }
                    listR = listT;
                }
                pq0.k(list);
                pq0.l(listT);
                pq0.j(listR);
                if (pq0Var != null) {
                    pq0Var.m();
                }
                if (zRemove) {
                    ((Consumer) this.f30023a.first).a();
                }
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void c() {
                pq0.k(b.this.s());
            }

            @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void d() {
                pq0.l(b.this.t());
            }
        }

        /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.MultiplexProducer$b$b, reason: collision with other inner class name */
        public class C0637b extends BaseConsumer<T> {
            public C0637b() {
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
                b.this.m(this);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable th) {
                b.this.n(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float f) {
                b.this.p(this, f);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(T t, boolean z) {
                b.this.o(this, t, z);
            }
        }

        public b(K k) {
            this.f1694a = k;
        }

        public final void g(Pair<Consumer<T>, ProducerContext> pair, ProducerContext producerContext) {
            producerContext.g(new a(pair));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean h(Consumer<T> consumer, ProducerContext producerContext) {
            Pair<Consumer<T>, ProducerContext> pairCreate = Pair.create(consumer, producerContext);
            synchronized (this) {
                if (MultiplexProducer.this.g(this.f1694a) != this) {
                    return false;
                }
                this.f1695a.add(pairCreate);
                List<ProducerContextCallbacks> listS = s();
                List<ProducerContextCallbacks> listT = t();
                List<ProducerContextCallbacks> listR = r();
                Closeable closeableCloneOrNull = this.f1693a;
                float f = this.f30022a;
                pq0.k(listS);
                pq0.l(listT);
                pq0.j(listR);
                synchronized (pairCreate) {
                    synchronized (this) {
                        if (closeableCloneOrNull != this.f1693a) {
                            closeableCloneOrNull = null;
                        } else if (closeableCloneOrNull != null) {
                            closeableCloneOrNull = MultiplexProducer.this.cloneOrNull(closeableCloneOrNull);
                        }
                    }
                    if (closeableCloneOrNull != null) {
                        if (f > 0.0f) {
                            consumer.b(f);
                        }
                        consumer.c(closeableCloneOrNull, false);
                        i(closeableCloneOrNull);
                    }
                }
                g(pairCreate, producerContext);
                return true;
            }
        }

        public final void i(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public final synchronized boolean j() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.f1695a.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) it.next().second).d()) {
                    return true;
                }
            }
            return false;
        }

        public final synchronized boolean k() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.f1695a.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) it.next().second).a()) {
                    return false;
                }
            }
            return true;
        }

        public final synchronized Priority l() {
            Priority higherPriority;
            higherPriority = Priority.LOW;
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.f1695a.iterator();
            while (it.hasNext()) {
                higherPriority = Priority.getHigherPriority(higherPriority, ((ProducerContext) it.next().second).e());
            }
            return higherPriority;
        }

        public void m(MultiplexProducer<K, T>.b.C0637b c0637b) {
            synchronized (this) {
                if (this.f1690a != c0637b) {
                    return;
                }
                this.f1690a = null;
                this.f1692a = null;
                i(this.f1693a);
                this.f1693a = null;
                q();
            }
        }

        public void n(MultiplexProducer<K, T>.b.C0637b c0637b, Throwable th) {
            synchronized (this) {
                if (this.f1690a != c0637b) {
                    return;
                }
                this.f1695a.clear();
                MultiplexProducer.this.h(this.f1694a, this);
                i(this.f1693a);
                this.f1693a = null;
                for (Pair<Consumer<T>, ProducerContext> pair : this.f1695a) {
                    synchronized (pair) {
                        ((Consumer) pair.first).onFailure(th);
                    }
                }
            }
        }

        public void o(MultiplexProducer<K, T>.b.C0637b c0637b, T t, boolean z) {
            synchronized (this) {
                if (this.f1690a != c0637b) {
                    return;
                }
                i(this.f1693a);
                this.f1693a = null;
                if (z) {
                    this.f1695a.clear();
                    MultiplexProducer.this.h(this.f1694a, this);
                } else {
                    this.f1693a = (T) MultiplexProducer.this.cloneOrNull(t);
                }
                for (Pair<Consumer<T>, ProducerContext> pair : this.f1695a) {
                    synchronized (pair) {
                        ((Consumer) pair.first).c(t, z);
                    }
                }
            }
        }

        public void p(MultiplexProducer<K, T>.b.C0637b c0637b, float f) {
            synchronized (this) {
                if (this.f1690a != c0637b) {
                    return;
                }
                this.f30022a = f;
                for (Pair<Consumer<T>, ProducerContext> pair : this.f1695a) {
                    synchronized (pair) {
                        ((Consumer) pair.first).b(f);
                    }
                }
            }
        }

        public final void q() {
            synchronized (this) {
                boolean z = true;
                ax6.d(this.f1692a == null);
                if (this.f1690a != null) {
                    z = false;
                }
                ax6.d(z);
                if (this.f1695a.isEmpty()) {
                    MultiplexProducer.this.h(this.f1694a, this);
                    return;
                }
                ProducerContext producerContext = (ProducerContext) this.f1695a.iterator().next().second;
                this.f1692a = new pq0(producerContext.b(), producerContext.getId(), producerContext.c(), producerContext.f(), producerContext.h(), k(), j(), l());
                MultiplexProducer<K, T>.b.C0637b c0637b = new C0637b();
                this.f1690a = c0637b;
                MultiplexProducer.this.f30021a.a(c0637b, this.f1692a);
            }
        }

        @Nullable
        public final synchronized List<ProducerContextCallbacks> r() {
            pq0 pq0Var = this.f1692a;
            if (pq0Var == null) {
                return null;
            }
            return pq0Var.p(j());
        }

        @Nullable
        public final synchronized List<ProducerContextCallbacks> s() {
            pq0 pq0Var = this.f1692a;
            if (pq0Var == null) {
                return null;
            }
            return pq0Var.q(k());
        }

        @Nullable
        public final synchronized List<ProducerContextCallbacks> t() {
            pq0 pq0Var = this.f1692a;
            if (pq0Var == null) {
                return null;
            }
            return pq0Var.r(l());
        }
    }

    public MultiplexProducer(Producer<T> producer) {
        this.f30021a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<T> consumer, ProducerContext producerContext) {
        MultiplexProducer<K, T>.b bVarG;
        boolean z;
        K key = getKey(producerContext);
        do {
            synchronized (this) {
                bVarG = g(key);
                if (bVarG == null) {
                    bVarG = f(key);
                    z = true;
                } else {
                    z = false;
                }
            }
        } while (!bVarG.h(consumer, producerContext));
        if (z) {
            bVarG.q();
        }
    }

    public abstract T cloneOrNull(T t);

    public final synchronized MultiplexProducer<K, T>.b f(K k) {
        MultiplexProducer<K, T>.b bVar;
        bVar = new b(k);
        this.f1689a.put(k, bVar);
        return bVar;
    }

    public final synchronized MultiplexProducer<K, T>.b g(K k) {
        return this.f1689a.get(k);
    }

    public abstract K getKey(ProducerContext producerContext);

    public final synchronized void h(K k, MultiplexProducer<K, T>.b bVar) {
        if (this.f1689a.get(k) == bVar) {
            this.f1689a.remove(k);
        }
    }
}
