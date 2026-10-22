package com.zj.adlib;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.database.DatabaseProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ff2 implements DatabaseProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteOpenHelper f41663a;

    public ff2(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f41663a = sQLiteOpenHelper;
    }

    @Override // com.google.android.exoplayer2.database.DatabaseProvider
    public SQLiteDatabase getReadableDatabase() {
        return this.f41663a.getReadableDatabase();
    }

    @Override // com.google.android.exoplayer2.database.DatabaseProvider
    public SQLiteDatabase getWritableDatabase() {
        return this.f41663a.getWritableDatabase();
    }
}
