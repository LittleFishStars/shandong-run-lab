package com.fl.saas.s2s.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fl.saas.s2s.videocache.Preconditions;
import com.fl.saas.s2s.videocache.SourceInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_URL = "url";
    private static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final String TABLE = "SourceInfo";
    private static final String COLUMN_MIME = "mime";
    private static final String[] ALL_COLUMNS = {"_id", "url", "length", COLUMN_MIME};

    public DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        Preconditions.checkNotNull(context);
    }

    private ContentValues convert(SourceInfo sourceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.url);
        contentValues.put("length", Long.valueOf(sourceInfo.length));
        contentValues.put(COLUMN_MIME, sourceInfo.mime);
        return contentValues;
    }

    private SourceInfo convert(Cursor cursor) {
        return new SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MIME)));
    }

    @Override // com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Preconditions.checkNotNull(str);
        SourceInfo sourceInfoConvert = null;
        try {
            cursorQuery = getReadableDatabase().query(TABLE, ALL_COLUMNS, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        sourceInfoConvert = convert(cursorQuery);
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
            return sourceInfoConvert;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Preconditions.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(CREATE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
        Preconditions.checkAllNotNull(str, sourceInfo);
        boolean z = get(str) != null;
        ContentValues contentValuesConvert = convert(sourceInfo);
        if (z) {
            getWritableDatabase().update(TABLE, contentValuesConvert, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(TABLE, null, contentValuesConvert);
        }
    }

    @Override // com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorage
    public void release() {
        close();
    }
}
