package com.google.android.datatransport.runtime.scheduling.persistence;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class m implements SQLiteEventStore.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SchemaManager f30460a;

    public m(SchemaManager schemaManager) {
        this.f30460a = schemaManager;
    }

    public static SQLiteEventStore.Producer b(SchemaManager schemaManager) {
        return new m(schemaManager);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    public Object a() {
        return this.f30460a.getWritableDatabase();
    }
}
