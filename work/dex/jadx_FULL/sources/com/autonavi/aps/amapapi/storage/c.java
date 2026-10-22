package com.autonavi.aps.amapapi.storage;

import android.database.sqlite.SQLiteDatabase;
import com.amap.api.col.p0003l.gv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c implements gv {
    @Override // com.amap.api.col.p0003l.gv
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "SdCardDbCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.p0003l.gv
    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
    }

    @Override // com.amap.api.col.p0003l.gv
    public final String b() {
        return "alsn20170807.db";
    }

    @Override // com.amap.api.col.p0003l.gv
    public final int c() {
        return 1;
    }
}
