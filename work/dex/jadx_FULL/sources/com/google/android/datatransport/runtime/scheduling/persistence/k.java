package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class k implements SQLiteEventStore.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f30458a;

    public k(SQLiteDatabase sQLiteDatabase) {
        this.f30458a = sQLiteDatabase;
    }

    public static SQLiteEventStore.Producer b(SQLiteDatabase sQLiteDatabase) {
        return new k(sQLiteDatabase);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    public Object a() {
        return SQLiteEventStore.E(this.f30458a);
    }
}
