package com.beizi.fusion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class y1 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile y1 f28050a;

    private y1(Context context) {
        super(context, "beizi_ad.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static y1 a(Context context) {
        if (f28050a == null) {
            synchronized (y1.class) {
                if (f28050a == null) {
                    f28050a = new y1(context.getApplicationContext());
                }
            }
        }
        return f28050a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            Cursor cursorQuery = null;
            try {
                cursorQuery = sQLiteDatabase.query("Sqlite_master", new String[]{"name"}, "type=?", new String[]{"table"}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    if (string != null && string.startsWith("T_")) {
                        jh.b("BeiZis", "before alter table ");
                        sQLiteDatabase.execSQL("alter table " + string + " add column space_id");
                    }
                }
                cursorQuery.close();
            } catch (Exception unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
    }
}
