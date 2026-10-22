package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    public static final Logger c = Logger.getLogger(AggregateFuture.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public ImmutableCollection<? extends ListenableFuture<? extends InputT>> f32325a;
    public final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f6498c;

    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public class a implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ListenableFuture f6499a;

        public a(ListenableFuture listenableFuture, int i) {
            this.f6499a = listenableFuture;
            this.K = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f6499a.isCancelled()) {
                    AggregateFuture.this.f32325a = null;
                    AggregateFuture.this.cancel(false);
                } else {
                    AggregateFuture.this.M(this.K, this.f6499a);
                }
            } finally {
                AggregateFuture.this.N(null);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableCollection f32327a;

        public b(ImmutableCollection immutableCollection) {
            this.f32327a = immutableCollection;
        }

        @Override // java.lang.Runnable
        public void run() {
            AggregateFuture.this.N(this.f32327a);
        }
    }

    public AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
        super(immutableCollection.size());
        this.f32325a = (ImmutableCollection) com.google.common.base.i.E(immutableCollection);
        this.b = z;
        this.f6498c = z2;
    }

    public static boolean K(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public static void R(Throwable th) {
        c.log(Level.SEVERE, th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    @Override // com.google.common.util.concurrent.AggregateFutureState
    public final void D(Set<Throwable> set) {
        com.google.common.base.i.E(set);
        if (isCancelled()) {
            return;
        }
        Throwable thTryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
        Objects.requireNonNull(thTryInternalFastPathGetFailure);
        K(set, thTryInternalFastPathGetFailure);
    }

    public abstract void L(int i, @ParametricNullness InputT inputt);

    /* JADX WARN: Multi-variable type inference failed */
    public final void M(int i, Future<? extends InputT> future) {
        try {
            L(i, f.h(future));
        } catch (ExecutionException e) {
            P(e.getCause());
        } catch (Throwable th) {
            P(th);
        }
    }

    public final void N(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        int iF = F();
        com.google.common.base.i.h0(iF >= 0, "Less than 0 remaining futures");
        if (iF == 0) {
            S(immutableCollection);
        }
    }

    public abstract void O();

    public final void P(Throwable th) {
        com.google.common.base.i.E(th);
        if (this.b && !setException(th) && K(G(), th)) {
            R(th);
        } else if (th instanceof Error) {
            R(th);
        }
    }

    public final void Q() {
        Objects.requireNonNull(this.f32325a);
        if (this.f32325a.isEmpty()) {
            O();
            return;
        }
        if (!this.b) {
            b bVar = new b(this.f6498c ? this.f32325a : null);
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.f32325a.iterator();
            while (it.hasNext()) {
                it.next().addListener(bVar, j.c());
            }
            return;
        }
        UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.f32325a.iterator();
        int i = 0;
        while (it2.hasNext()) {
            ListenableFuture<? extends InputT> next = it2.next();
            next.addListener(new a(next, i), j.c());
            i++;
        }
    }

    public final void S(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        if (immutableCollection != null) {
            UnmodifiableIterator<? extends Future<? extends InputT>> it = immutableCollection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Future<? extends InputT> next = it.next();
                if (!next.isCancelled()) {
                    M(i, next);
                }
                i++;
            }
        }
        E();
        O();
        T(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    @ForOverride
    @OverridingMethodsMustInvokeSuper
    public void T(ReleaseResourcesReason releaseResourcesReason) {
        com.google.common.base.i.E(releaseResourcesReason);
        this.f32325a = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.f32325a;
        T(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean zWasInterrupted = wasInterrupted();
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                it.next().cancel(zWasInterrupted);
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public final String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.f32325a;
        if (immutableCollection == null) {
            return super.pendingToString();
        }
        String strValueOf = String.valueOf(immutableCollection);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
        sb.append("futures=");
        sb.append(strValueOf);
        return sb.toString();
    }
}
