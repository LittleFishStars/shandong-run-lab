package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class h implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransportContext f30455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SQLiteEventStore f1965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f1966a;

    public h(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f1965a = sQLiteEventStore;
        this.f1966a = list;
        this.f30455a = transportContext;
    }

    public static SQLiteEventStore.Function a(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        return new h(sQLiteEventStore, list, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.b0(this.f1965a, this.f1966a, this.f30455a, (Cursor) obj);
    }
}
