package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class j implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f30457a;

    public j(Map map) {
        this.f30457a = map;
    }

    public static SQLiteEventStore.Function a(Map map) {
        return new j(map);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.i0(this.f30457a, (Cursor) obj);
    }
}
