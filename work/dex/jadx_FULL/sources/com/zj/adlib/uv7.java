package com.zj.adlib;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class uv7 implements SchemaManager.Migration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uv7 f45236a = new uv7();

    public static SchemaManager.Migration b() {
        return f45236a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    public void a(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.c(sQLiteDatabase);
    }
}
