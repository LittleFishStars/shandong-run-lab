package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v implements Factory<SQLiteEventStore> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Clock> f30469a;
    public final Provider<Clock> b;
    public final Provider<EventStoreConfig> c;
    public final Provider<SchemaManager> d;

    public v(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4) {
        this.f30469a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static v a(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4) {
        return new v(provider, provider2, provider3, provider4);
    }

    public static SQLiteEventStore c(Clock clock, Clock clock2, Object obj, Object obj2) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SQLiteEventStore get() {
        return c((Clock) this.f30469a.get(), (Clock) this.b.get(), this.c.get(), this.d.get());
    }
}
