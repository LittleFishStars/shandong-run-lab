package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.v;
import com.zj.adlib.ai2;
import com.zj.adlib.c79;
import com.zj.adlib.d79;
import com.zj.adlib.hc9;
import com.zj.adlib.jb4;
import com.zj.adlib.lh9;
import com.zj.adlib.mh9;
import com.zj.adlib.mz9;
import com.zj.adlib.nz9;
import com.zj.adlib.op2;
import com.zj.adlib.q53;
import com.zj.adlib.r53;
import com.zj.adlib.rv7;
import com.zj.adlib.sv7;
import com.zj.adlib.un5;
import com.zj.adlib.vx1;
import com.zj.adlib.xv7;
import com.zj.adlib.xw6;
import com.zj.adlib.zh2;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends TransportRuntimeComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Provider<Executor> f30430a;
    public Provider<Context> b;
    public Provider c;
    public Provider d;
    public Provider e;
    public Provider<SQLiteEventStore> f;
    public Provider<SchedulerConfig> g;
    public Provider<WorkScheduler> h;
    public Provider<zh2> i;
    public Provider<lh9> j;
    public Provider<mz9> k;
    public Provider<h> l;

    public static final class b implements TransportRuntimeComponent.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f30431a;

        public b() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public TransportRuntimeComponent a() {
            xw6.a(this.f30431a, Context.class);
            return new d(this.f30431a);
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b b(Context context) {
            this.f30431a = (Context) xw6.b(context);
            return this;
        }
    }

    public static TransportRuntimeComponent.Builder j() {
        return new b();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    public EventStore g() {
        return (EventStore) this.f.get();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    public h h() {
        return (h) this.l.get();
    }

    public final void k(Context context) {
        this.f30430a = op2.b(e.a());
        Factory factoryA = jb4.a(context);
        this.b = factoryA;
        vx1 vx1VarA = vx1.a(factoryA, c79.a(), d79.a());
        this.c = vx1VarA;
        this.d = op2.b(un5.a(this.b, vx1VarA));
        this.e = xv7.a(this.b, q53.a(), r53.a());
        this.f = op2.b(v.a(c79.a(), d79.a(), com.google.android.datatransport.runtime.scheduling.persistence.b.a(), this.e));
        rv7 rv7VarB = rv7.b(c79.a());
        this.g = rv7VarB;
        sv7 sv7VarA = sv7.a(this.b, this.f, rv7VarB, d79.a());
        this.h = sv7VarA;
        Provider<Executor> provider = this.f30430a;
        Provider provider2 = this.d;
        Provider<SQLiteEventStore> provider3 = this.f;
        this.i = ai2.a(provider, provider2, sv7VarA, provider3, provider3);
        Provider<Context> provider4 = this.b;
        Provider provider5 = this.d;
        Provider<SQLiteEventStore> provider6 = this.f;
        this.j = mh9.a(provider4, provider5, provider6, this.h, this.f30430a, provider6, c79.a());
        Provider<Executor> provider7 = this.f30430a;
        Provider<SQLiteEventStore> provider8 = this.f;
        this.k = nz9.a(provider7, provider8, this.h, provider8);
        this.l = op2.b(hc9.a(c79.a(), d79.a(), this.i, this.j, this.k));
    }

    public d(Context context) {
        k(context);
    }
}
