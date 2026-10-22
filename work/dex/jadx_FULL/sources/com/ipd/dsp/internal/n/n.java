package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class n<A, B> {
    public static final int b = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.d0.j<b<A>, B> f38434a;

    public class a extends com.ipd.dsp.internal.d0.j<b<A>, B> {
        public a(long j) {
            super(j);
        }

        @Override // com.ipd.dsp.internal.d0.j
        public void a(@NonNull b<A> bVar, @Nullable B b) {
            bVar.a();
        }
    }

    public n() {
        this(250L);
    }

    @Nullable
    public B a(A a2, int i, int i2) {
        b<A> bVarA = b.a(a2, i, i2);
        B b2 = this.f38434a.b(bVarA);
        bVarA.a();
        return b2;
    }

    public n(long j) {
        this.f38434a = new a(j);
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f38434a.b(b.a(a2, i, i2), b2);
    }

    @VisibleForTesting
    public static final class b<A> {
        public static final Queue<b<?>> d = com.ipd.dsp.internal.d0.o.a(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38435a;
        public int b;
        public A c;

        public static <A> b<A> a(A a2, int i, int i2) {
            b<A> bVar;
            Queue<b<?>> queue = d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a2, i, i2);
            return bVar;
        }

        public final void b(A a2, int i, int i2) {
            this.c = a2;
            this.b = i;
            this.f38435a = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.b == bVar.b && this.f38435a == bVar.f38435a && this.c.equals(bVar.c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f38435a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public void a() {
            Queue<b<?>> queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public void a() {
        this.f38434a.a();
    }
}
