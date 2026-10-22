package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fl.saas.base.cache.DatabaseHelper;
import com.kwad.sdk.core.videocache.n;
import com.kwad.sdk.utils.az;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class a extends SQLiteOpenHelper implements c {
    private static final String[] baH = {DatabaseHelper.COLUMN_ID, "url", "length", "mime"};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        az.checkNotNull(context);
    }

    private static n h(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        az.d(str, nVar);
        boolean z = fG(str) != null;
        ContentValues contentValuesA = a(nVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n fG(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        az.hY(str);
        n nVarH = null;
        try {
            cursorQuery = getReadableDatabase().query("SourceInfo", baH, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        nVarH = h(cursorQuery);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            return nVarH;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        az.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    private static ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.url);
        contentValues.put("length", Long.valueOf(nVar.baB));
        contentValues.put("mime", nVar.baC);
        return contentValues;
    }
}
