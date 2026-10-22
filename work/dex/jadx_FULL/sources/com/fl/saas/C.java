package com.fl.saas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fl.saas.base.cache.DatabaseHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class C extends SQLiteOpenHelper implements X0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f30039a = {DatabaseHelper.COLUMN_ID, "url", "length", "mime"};

    public C(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        AbstractC1442w0.a(context);
    }

    private ContentValues a(W0 w0) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", w0.f30095a);
        contentValues.put("length", Long.valueOf(w0.b));
        contentValues.put("mime", w0.c);
        return contentValues;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        AbstractC1442w0.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    private W0 a(Cursor cursor) {
        return new W0(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.fl.saas.X0
    public W0 a(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        AbstractC1442w0.a(str);
        W0 w0A = null;
        try {
            cursorQuery = getReadableDatabase().query("SourceInfo", f30039a, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        w0A = a(cursorQuery);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return w0A;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // com.fl.saas.X0
    public void a(String str, W0 w0) {
        AbstractC1442w0.a(str, w0);
        boolean z = a(str) != null;
        ContentValues contentValuesA = a(w0);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }
}
