package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class q implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventInternal f30464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f1967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SQLiteEventStore f1968a;

    public q(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        this.f1968a = sQLiteEventStore;
        this.f1967a = transportContext;
        this.f30464a = eventInternal;
    }

    public static SQLiteEventStore.Function a(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        return new q(sQLiteEventStore, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.j0(this.f1968a, this.f1967a, this.f30464a, (SQLiteDatabase) obj);
    }
}
