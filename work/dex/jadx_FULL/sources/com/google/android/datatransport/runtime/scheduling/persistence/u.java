package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class u implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransportContext f30468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SQLiteEventStore f1969a;

    public u(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f1969a = sQLiteEventStore;
        this.f30468a = transportContext;
    }

    public static SQLiteEventStore.Function a(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        return new u(sQLiteEventStore, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.M(this.f1969a, this.f30468a, (SQLiteDatabase) obj);
    }
}
