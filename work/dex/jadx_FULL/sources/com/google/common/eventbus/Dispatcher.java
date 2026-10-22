package com.google.common.eventbus;

import com.google.common.base.i;
import com.google.common.collect.v;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class Dispatcher {

    public static final class b extends Dispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32026a = new b();

        @Override // com.google.common.eventbus.Dispatcher
        public void a(Object obj, Iterator<com.google.common.eventbus.d> it) {
            i.E(obj);
            while (it.hasNext()) {
                it.next().e(obj);
            }
        }
    }

    public static final class c extends Dispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue<a> f32027a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.google.common.eventbus.d f32028a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Object f6241a;

            public a(Object obj, com.google.common.eventbus.d dVar) {
                this.f6241a = obj;
                this.f32028a = dVar;
            }
        }

        public c() {
            this.f32027a = v.f();
        }

        @Override // com.google.common.eventbus.Dispatcher
        public void a(Object obj, Iterator<com.google.common.eventbus.d> it) {
            i.E(obj);
            while (it.hasNext()) {
                this.f32027a.add(new a(obj, it.next()));
            }
            while (true) {
                a aVarPoll = this.f32027a.poll();
                if (aVarPoll == null) {
                    return;
                } else {
                    aVarPoll.f32028a.e(aVarPoll.f6241a);
                }
            }
        }
    }

    public static final class d extends Dispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadLocal<Queue<c>> f32029a;
        public final ThreadLocal<Boolean> b;

        public class a extends ThreadLocal<Queue<c>> {
            public a(d dVar) {
            }

            @Override // java.lang.ThreadLocal
            public Queue<c> initialValue() {
                return v.d();
            }
        }

        public class b extends ThreadLocal<Boolean> {
            public b(d dVar) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Boolean initialValue() {
                return Boolean.FALSE;
            }
        }

        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f32030a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Iterator<com.google.common.eventbus.d> f6242a;

            public c(Object obj, Iterator<com.google.common.eventbus.d> it) {
                this.f32030a = obj;
                this.f6242a = it;
            }
        }

        public d() {
            this.f32029a = new a(this);
            this.b = new b(this);
        }

        @Override // com.google.common.eventbus.Dispatcher
        public void a(Object obj, Iterator<com.google.common.eventbus.d> it) {
            i.E(obj);
            i.E(it);
            Queue<c> queue = this.f32029a.get();
            queue.offer(new c(obj, it));
            if (this.b.get().booleanValue()) {
                return;
            }
            this.b.set(Boolean.TRUE);
            while (true) {
                try {
                    c cVarPoll = queue.poll();
                    if (cVarPoll == null) {
                        this.b.remove();
                        this.f32029a.remove();
                        return;
                    } else {
                        while (cVarPoll.f6242a.hasNext()) {
                            ((com.google.common.eventbus.d) cVarPoll.f6242a.next()).e(cVarPoll.f32030a);
                        }
                    }
                } catch (Throwable th) {
                    this.b.remove();
                    this.f32029a.remove();
                    throw th;
                }
            }
        }
    }

    public static Dispatcher b() {
        return b.f32026a;
    }

    public static Dispatcher c() {
        return new c();
    }

    public static Dispatcher d() {
        return new d();
    }

    public abstract void a(Object obj, Iterator<com.google.common.eventbus.d> it);
}
