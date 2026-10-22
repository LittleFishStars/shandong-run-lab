package com.zj.adlib;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45092a = 1;
    public static final int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f20008b = "ExoPlayerCacheFileMetadata";
    public static final int c = 1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f20009c = "name";
    public static final int d = 2;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f20010d = "length";
    public static final String f = "name = ?";
    public static final String g = "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DatabaseProvider f20011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20012a;
    public static final String e = "last_touch_timestamp";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f20007a = {"name", "length", e};

    public u91(DatabaseProvider databaseProvider) {
        this.f20011a = databaseProvider;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public static String d(String str) {
        return f20008b + str;
    }

    @WorkerThread
    public static void delete(DatabaseProvider databaseProvider, long j) throws DatabaseIOException {
        String hexString = Long.toHexString(j);
        try {
            String strD = d(hexString);
            SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                mm9.c(writableDatabase, 2, hexString);
                a(writableDatabase, strD);
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public Map<String, t91> b() throws DatabaseIOException {
        try {
            Cursor cursorC = c();
            try {
                HashMap map = new HashMap(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    map.put((String) sb0.g(cursorC.getString(0)), new t91(cursorC.getLong(1), cursorC.getLong(2)));
                }
                cursorC.close();
                return map;
            } catch (Throwable th) {
                if (cursorC != null) {
                    try {
                        cursorC.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public final Cursor c() {
        sb0.g(this.f20012a);
        return this.f20011a.getReadableDatabase().query(this.f20012a, f20007a, null, null, null, null, null);
    }

    @WorkerThread
    public void e(long j) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j);
            this.f20012a = d(hexString);
            if (mm9.b(this.f20011a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f20011a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    mm9.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f20012a);
                    writableDatabase.execSQL("CREATE TABLE " + this.f20012a + " " + g);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public void f(String str) throws DatabaseIOException {
        sb0.g(this.f20012a);
        try {
            this.f20011a.getWritableDatabase().delete(this.f20012a, f, new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public void g(Set<String> set) throws DatabaseIOException {
        sb0.g(this.f20012a);
        try {
            SQLiteDatabase writableDatabase = this.f20011a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f20012a, f, new String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public void h(String str, long j, long j2) throws DatabaseIOException {
        sb0.g(this.f20012a);
        try {
            SQLiteDatabase writableDatabase = this.f20011a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put(e, Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.f20012a, null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
