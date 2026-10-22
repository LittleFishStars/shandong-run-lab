package com.getui.gtc.base.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractTable {
    private AbstractDb db;

    public abstract String createSql();

    public int delete(String str, String[] strArr) {
        return getWritableDatabase().delete(getTableName(), str, strArr);
    }

    public void execSql(String str) {
        getWritableDatabase().execSQL(str);
    }

    public final SQLiteDatabase getReadableDatabase() {
        AbstractDb abstractDb = this.db;
        if (abstractDb != null) {
            return abstractDb.getHelper().getReadableDatabase();
        }
        throw new RuntimeException("table " + getTableName() + " has not been added to a db");
    }

    public abstract String getTableName();

    public final SQLiteDatabase getWritableDatabase() {
        AbstractDb abstractDb = this.db;
        if (abstractDb != null) {
            return abstractDb.getHelper().getWritableDatabase();
        }
        throw new RuntimeException("table " + getTableName() + " has not been added to a db");
    }

    public void initCache() {
    }

    public long insert(ContentValues contentValues) {
        return getWritableDatabase().insert(getTableName(), null, contentValues);
    }

    public void onDowngradle(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public Cursor query(String str) {
        return getReadableDatabase().rawQuery(str, null);
    }

    public Cursor query(String[] strArr, String str, String[] strArr2) {
        return getReadableDatabase().query(getTableName(), strArr, str, strArr2, null, null, null);
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return getReadableDatabase().query(getTableName(), strArr, str, strArr2, str2, str3, str4);
    }

    public long replace(String str, ContentValues contentValues) {
        return getWritableDatabase().replace(getTableName(), str, contentValues);
    }

    public final void setDb(AbstractDb abstractDb) {
        this.db = abstractDb;
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        return getWritableDatabase().update(getTableName(), contentValues, str, strArr);
    }
}
