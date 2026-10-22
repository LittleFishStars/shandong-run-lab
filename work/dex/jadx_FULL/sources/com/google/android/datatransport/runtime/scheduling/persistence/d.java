package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class d implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransportContext f30451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SQLiteEventStore f1964a;

    public d(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f1964a = sQLiteEventStore;
        this.f30451a = transportContext;
    }

    public static SQLiteEventStore.Function a(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        return new d(sQLiteEventStore, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.W(this.f1964a, this.f30451a, (SQLiteDatabase) obj);
    }
}
