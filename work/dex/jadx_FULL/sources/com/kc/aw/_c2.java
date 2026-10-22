package com.kc.aw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fl.saas.base.cache.DatabaseHelper;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c2 extends SQLiteOpenHelper implements _mo {
    public static final String[] _a = {DatabaseHelper.COLUMN_ID, "url", "length", "mime"};

    public _c2(Context context) {
        super(context, "aw_video_cache.db", (SQLiteDatabase.CursorFactory) null, 1);
        _hp._a(context);
    }

    @Override // com.kc.aw._mo
    public final _mn _a(String str) throws Throwable {
        str.getClass();
        Cursor cursor = null;
        _mnVar = null;
        _mn _mnVar = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("SourceInfo", _a, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        _mnVar = new _mn(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("length")), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("url")), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime")));
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
            return _mnVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.kc.aw._mo
    public final void _a(String str, _mn _mnVar) {
        for (int i = 0; i < 2; i++) {
            new Object[]{str, _mnVar}[i].getClass();
        }
        boolean z = _a(str) != null;
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", _mnVar._a);
        contentValues.put("length", Long.valueOf(_mnVar._b));
        contentValues.put("mime", _mnVar._c);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValues, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValues);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
