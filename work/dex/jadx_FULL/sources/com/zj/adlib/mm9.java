package com.zj.adlib;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mm9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43336a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f18257a = "ExoPlayerVersions";
    public static final int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f18258b = "feature";
    public static final int c = 1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f18259c = "instance_uid";
    public static final int d = 2;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f18260d = "version";
    public static final int e = 1000;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f18261e = "feature = ? AND instance_uid = ?";
    public static final String f = "PRIMARY KEY (feature, instance_uid)";
    public static final String g = "CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))";

    static {
        ab3.a("goog.exo.database");
    }

    public static String[] a(int i, String str) {
        return new String[]{Integer.toString(i), str};
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            if (!gj9.A1(sQLiteDatabase, f18257a)) {
                return -1;
            }
            Cursor cursorQuery = sQLiteDatabase.query(f18257a, new String[]{"version"}, f18261e, a(i, str), null, null, null);
            try {
                if (cursorQuery.getCount() == 0) {
                    cursorQuery.close();
                    return -1;
                }
                cursorQuery.moveToNext();
                int i2 = cursorQuery.getInt(0);
                cursorQuery.close();
                return i2;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
            throw new DatabaseIOException(e);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            if (gj9.A1(sQLiteDatabase, f18257a)) {
                sQLiteDatabase.delete(f18257a, f18261e, a(i, str));
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i, String str, int i2) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL(g);
            ContentValues contentValues = new ContentValues();
            contentValues.put(f18258b, Integer.valueOf(i));
            contentValues.put(f18259c, str);
            contentValues.put("version", Integer.valueOf(i2));
            sQLiteDatabase.replaceOrThrow(f18257a, null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
