package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ListenerSet;
import com.zj.adlib.sb0;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ListenerSet<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31157a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f5265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerWrapper f5266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IterationFinishedEvent<T> f5267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<Runnable> f5268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArraySet<a<T>> f5269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5270a;
    public final ArrayDeque<Runnable> b;

    public interface Event<T> {
        void invoke(T t);
    }

    public interface IterationFinishedEvent<T> {
        void a(T t, com.google.android.exoplayer2.util.a aVar);
    }

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.google.android.exoplayer2.util.a.b f31158a = new com.google.android.exoplayer2.util.a.b();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final T f5271a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5272a;
        public boolean b;

        public a(T t) {
            this.f5271a = t;
        }

        public void a(int i, Event<T> event) {
            if (this.b) {
                return;
            }
            if (i != -1) {
                this.f31158a.a(i);
            }
            this.f5272a = true;
            event.invoke(this.f5271a);
        }

        public void b(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (this.b || !this.f5272a) {
                return;
            }
            com.google.android.exoplayer2.util.a aVarE = this.f31158a.e();
            this.f31158a = new com.google.android.exoplayer2.util.a.b();
            this.f5272a = false;
            iterationFinishedEvent.a(this.f5271a, aVarE);
        }

        public void c(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.b = true;
            if (this.f5272a) {
                iterationFinishedEvent.a(this.f5271a, this.f31158a.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            return this.f5271a.equals(((a) obj).f5271a);
        }

        public int hashCode() {
            return this.f5271a.hashCode();
        }
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent);
    }

    public static /* synthetic */ void i(CopyOnWriteArraySet copyOnWriteArraySet, int i, Event event) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, event);
        }
    }

    public void c(T t) {
        if (this.f5270a) {
            return;
        }
        sb0.g(t);
        this.f5269a.add(new a<>(t));
    }

    public void d() {
        this.f5269a.clear();
    }

    @CheckResult
    public ListenerSet<T> e(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        return new ListenerSet<>(this.f5269a, looper, clock, iterationFinishedEvent);
    }

    @CheckResult
    public ListenerSet<T> f(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent) {
        return e(looper, this.f5265a, iterationFinishedEvent);
    }

    public void g() {
        if (this.b.isEmpty()) {
            return;
        }
        if (!this.f5266a.hasMessages(0)) {
            HandlerWrapper handlerWrapper = this.f5266a;
            handlerWrapper.c(handlerWrapper.a(0));
        }
        boolean z = !this.f5268a.isEmpty();
        this.f5268a.addAll(this.b);
        this.b.clear();
        if (z) {
            return;
        }
        while (!this.f5268a.isEmpty()) {
            this.f5268a.peekFirst().run();
            this.f5268a.removeFirst();
        }
    }

    public final boolean h(Message message) {
        Iterator<a<T>> it = this.f5269a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f5267a);
            if (this.f5266a.hasMessages(0)) {
                return true;
            }
        }
        return true;
    }

    public void j(final int i, final Event<T> event) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f5269a);
        this.b.add(new Runnable() { // from class: com.zj.adlib.ry4
            @Override // java.lang.Runnable
            public final void run() {
                ListenerSet.i(copyOnWriteArraySet, i, event);
            }
        });
    }

    public void k() {
        Iterator<a<T>> it = this.f5269a.iterator();
        while (it.hasNext()) {
            it.next().c(this.f5267a);
        }
        this.f5269a.clear();
        this.f5270a = true;
    }

    public void l(T t) {
        for (a<T> aVar : this.f5269a) {
            if (aVar.f5271a.equals(t)) {
                aVar.c(this.f5267a);
                this.f5269a.remove(aVar);
            }
        }
    }

    public void m(int i, Event<T> event) {
        j(i, event);
        g();
    }

    public int n() {
        return this.f5269a.size();
    }

    public ListenerSet(CopyOnWriteArraySet<a<T>> copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this.f5265a = clock;
        this.f5269a = copyOnWriteArraySet;
        this.f5267a = iterationFinishedEvent;
        this.f5268a = new ArrayDeque<>();
        this.b = new ArrayDeque<>();
        this.f5266a = clock.a(looper, new Handler.Callback() { // from class: com.zj.adlib.py4
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f44085a.h(message);
            }
        });
    }
}
