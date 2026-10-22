package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class c implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f1963a;

    public c(long j, TransportContext transportContext) {
        this.f30450a = j;
        this.f1963a = transportContext;
    }

    public static SQLiteEventStore.Function a(long j, TransportContext transportContext) {
        return new c(j, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.o0(this.f30450a, this.f1963a, (SQLiteDatabase) obj);
    }
}
