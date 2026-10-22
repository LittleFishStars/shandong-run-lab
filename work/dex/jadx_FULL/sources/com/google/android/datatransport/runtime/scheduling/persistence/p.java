package com.google.android.datatransport.runtime.scheduling.persistence;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class p implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f30463a = new p();

    public static SQLiteEventStore.Function a() {
        return f30463a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.H((Throwable) obj);
    }
}
