package com.getui.gtc.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0645a f30271a;

    /* JADX INFO: renamed from: com.getui.gtc.b.a$a, reason: collision with other inner class name */
    public static class C0645a extends SQLiteOpenHelper {
        public C0645a(Context context) {
            super(context, "gtc.db", (SQLiteDatabase.CursorFactory) null, 5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0083  */
    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    public static String a(Context context) throws Throwable {
        SQLiteDatabase readableDatabase;
        Cursor cursorQuery;
        byte[] blob;
        Cursor cursor = null;
        if (!context.getDatabasePath("gtc.db").exists()) {
            return null;
        }
        if (f30271a == null) {
            f30271a = new C0645a(context);
        }
        try {
            readableDatabase = f30271a.getReadableDatabase();
            try {
                cursorQuery = readableDatabase.query("i", new String[]{"b"}, "a=?", new String[]{"100"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.moveToNext() && (blob = cursorQuery.getBlob(0)) != null) {
                                String str = new String(com.getui.gtc.i.a.b.a(blob, com.getui.gtc.i.a.a.a(context.getPackageName())));
                                cursorQuery.close();
                                readableDatabase.close();
                                return str;
                            }
                        } catch (Exception e) {
                            e = e;
                            com.getui.gtc.i.c.a.b(e);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (readableDatabase != null) {
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            readableDatabase = null;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            readableDatabase = null;
        }
        readableDatabase.close();
        return null;
    }
}
