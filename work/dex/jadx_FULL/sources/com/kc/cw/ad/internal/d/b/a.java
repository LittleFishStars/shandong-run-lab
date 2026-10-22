package com.kc.cw.ad.internal.d.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fl.saas.base.cache.DatabaseHelper;
import com.kc.cw.ad.internal.d.n;
import com.kc.cw.ad.internal.d.s;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class a extends SQLiteOpenHelper implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f38959a = {DatabaseHelper.COLUMN_ID, "url", "length", "mime"};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        n.a(context);
    }

    private ContentValues a(s sVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sVar.f38975a);
        contentValues.put("length", Long.valueOf(sVar.b));
        contentValues.put("mime", sVar.c);
        return contentValues;
    }

    private s a(Cursor cursor) {
        return new s(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kc.cw.ad.internal.d.b.c
    public s a(String str) throws Throwable {
        n.a(str);
        Cursor cursor = null;
        sVarA = null;
        s sVarA = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("SourceInfo", f38959a, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        sVarA = a(cursorQuery);
                    }
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return sVarA;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.kc.cw.ad.internal.d.b.c
    public void a(String str, s sVar) {
        n.a(str, sVar);
        boolean z = a(str) != null;
        ContentValues contentValuesA = a(sVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        n.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
