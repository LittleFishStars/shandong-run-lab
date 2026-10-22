package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import javax.inject.Named;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Module
public abstract class EventStoreModule {
    @Provides
    @Named("SQLITE_DB_NAME")
    public static String a() {
        return SchemaManager.f;
    }

    @Provides
    @Named("SCHEMA_VERSION")
    public static int c() {
        return SchemaManager.L;
    }

    @Provides
    public static EventStoreConfig d() {
        return EventStoreConfig.f1953a;
    }

    @Binds
    public abstract EventStore b(SQLiteEventStore sQLiteEventStore);

    @Binds
    public abstract SynchronizationGuard e(SQLiteEventStore sQLiteEventStore);
}
