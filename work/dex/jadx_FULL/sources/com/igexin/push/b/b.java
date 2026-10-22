package com.igexin.push.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37878a = "DownDBHelper";
    private static final String b = "pushsdk.db";
    private static final int c = 7;
    private static final String d = "create table if not exists config (id integer primary key,value text)";
    private static final String e = "create table if not exists runtime (id integer primary key,value text)";
    private static final String f = "create table if not exists ral (id integer primary key,data text,type integer,time integer,send_times integer)";
    private static final String g = "create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer,expect_redisplay_time integer, redisplay_freq integer,redisplay_duration integer ,redisplay_num integer,notify_status integer ) ";
    private static final String h = "create table if not exists bidata (id integer primary key,data text,type integer,time integer)";
    private static final String i = "drop table if exists config";
    private static final String j = "drop table if exists runtime";
    private static final String k = "drop table if exists ral";
    private static final String l = "drop table if exists ca";
    private static final String m = "drop table if exists bi";
    private static final String n = "drop table if exists message";
    private static final String o = "drop table if exists st";
    private static final String p = "drop table if exists bidata";
    private SQLiteDatabase q;

    public b(Context context) {
        super(context, "pushsdk.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.q = null;
    }

    private b(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.q = null;
    }

    private Cursor a(String str, String[] strArr) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.q = readableDatabase;
        try {
            return readableDatabase.rawQuery(str, strArr);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    private static String a(String[] strArr, String[] strArr2, int i2) {
        StringBuilder sb = new StringBuilder(" ");
        if (strArr.length == 1) {
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(strArr[0]);
                sb.append(" = '");
                sb.append(strArr2[i3]);
                sb.append("'");
                if (i3 < i2 - 1) {
                    sb.append(" or ");
                }
            }
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(strArr[i4]);
                sb.append(" = '");
                sb.append(strArr2[i4]);
                sb.append("'");
                if (i4 < i2 - 1) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString();
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (Exception unused) {
                com.igexin.c.a.c.a.a(f37878a, "closecurrentDatabase fail");
            }
        }
    }

    private void a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        try {
            writableDatabase.replace(str, str2, contentValues);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private boolean a(String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            this.q.execSQL(str);
            this.q.setTransactionSuccessful();
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        } finally {
            b(this.q);
        }
    }

    private static String b(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final int a(String str, String str2) {
        int iDelete;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        int i2 = 0;
        try {
            try {
                iDelete = this.q.delete(str, str2, null);
                try {
                    com.igexin.c.a.c.a.a("DownDBHelper|del " + iDelete + " msg", new Object[0]);
                    this.q.setTransactionSuccessful();
                    b(this.q);
                } catch (Exception e2) {
                    e = e2;
                    i2 = iDelete;
                    com.igexin.c.a.c.a.a(e);
                    b(this.q);
                    iDelete = i2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            return iDelete;
        } catch (Throwable th) {
            b(this.q);
            throw th;
        }
    }

    public final long a(String str, ContentValues contentValues) {
        long jInsert;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                jInsert = this.q.insert(str, null, contentValues);
                try {
                    this.q.setTransactionSuccessful();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jInsert = -1;
            }
            return jInsert;
        } finally {
            b(this.q);
        }
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.q = readableDatabase;
            return readableDatabase.query(str, strArr, str2, null, null, null, null);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    public final Cursor a(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        Cursor cursorQuery;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.q = readableDatabase;
        readableDatabase.beginTransaction();
        try {
            try {
                if (strArr == null) {
                    cursorQuery = this.q.query(str, strArr3, null, null, null, null, str2);
                } else if (strArr.length != 1) {
                    cursorQuery = this.q.query(str, strArr3, a(strArr, strArr2, strArr.length), null, null, null, str2);
                } else if (strArr2.length == 1) {
                    cursorQuery = this.q.query(str, strArr3, strArr[0] + "= ?", strArr2, null, null, str2);
                } else {
                    cursorQuery = this.q.query(str, strArr3, a(strArr, strArr2, strArr2.length), null, null, null, str2);
                }
                try {
                    this.q.setTransactionSuccessful();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                b(this.q);
                throw th;
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        }
        b(this.q);
        return cursorQuery;
    }

    public final void a(String str, ContentValues contentValues, String[] strArr, String[] strArr2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                this.q.update(str, contentValues, strArr[0] + "='" + strArr2[0] + "'", null);
                this.q.setTransactionSuccessful();
            } catch (Exception unused) {
                com.igexin.c.a.c.a.a(f37878a, str + "_Update Error!");
            }
        } finally {
            b(this.q);
        }
    }

    public final void a(String str, String[] strArr, String[] strArr2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                if (strArr2.length == 1) {
                    com.igexin.c.a.c.a.a("DownDBHelper|del " + str + " cnt = " + this.q.delete(str, strArr[0] + " = ?", strArr2), new Object[0]);
                } else {
                    this.q.execSQL(b(str, a(strArr, strArr2, strArr2.length)));
                }
                this.q.setTransactionSuccessful();
            } catch (Exception unused) {
                com.igexin.c.a.c.a.a(f37878a, str + "_Delete Error!");
            }
        } finally {
            b(this.q);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(d);
            sQLiteDatabase.execSQL(e);
            sQLiteDatabase.execSQL(g);
            sQLiteDatabase.execSQL(f);
            sQLiteDatabase.execSQL(h);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } finally {
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws Throwable {
        onUpgrade(sQLiteDatabase, i3, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws Throwable {
        f.a().b = true;
        f.d(sQLiteDatabase);
        byte[] bArrA = f.a(sQLiteDatabase, 1);
        if (bArrA != null) {
            try {
                String str = new String(bArrA);
                e.z = str.equals("null") ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f.f38011a + "|db version changed, save session = " + e.z, new Object[0]);
        }
        byte[] bArrA2 = f.a(sQLiteDatabase, 20);
        if (bArrA2 != null) {
            String str2 = new String(bArrA2);
            if (str2.equals("null")) {
                str2 = null;
            }
            e.B = str2;
            e.A = str2;
            com.igexin.c.a.c.a.a(f.f38011a + "|db version changed, save cid = " + str2, new Object[0]);
        }
        String strB = f.b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(strB)) {
            if (strB.equals("null")) {
                strB = null;
            }
            e.L = strB;
        }
        String str3 = e.L;
        String strB2 = f.b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(strB2)) {
            if (strB2.equals("null")) {
                strB2 = null;
            }
            e.H = strB2;
        }
        String strB3 = f.b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(strB3)) {
            if (strB3.equals("null")) {
                strB3 = null;
            }
            e.I = strB3;
        }
        String strB4 = f.b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(strB4)) {
            if (strB4.equals("null")) {
                strB4 = null;
            }
            e.K = strB4;
        }
        String strB5 = f.b(sQLiteDatabase, 51);
        if (!TextUtils.isEmpty(strB5) && strB5.length() != 13) {
            e.C = strB5.equals("null") ? null : strB5;
        }
        com.igexin.push.core.e.c.a().d(sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL(i);
        } catch (Exception e3) {
            com.igexin.c.a.c.a.a(e3);
        }
        try {
            sQLiteDatabase.execSQL(j);
        } catch (Exception e4) {
            com.igexin.c.a.c.a.a(e4);
        }
        try {
            sQLiteDatabase.execSQL(n);
        } catch (Exception e5) {
            com.igexin.c.a.c.a.a(e5);
        }
        try {
            sQLiteDatabase.execSQL(k);
        } catch (Exception e6) {
            com.igexin.c.a.c.a.a(e6);
        }
        try {
            sQLiteDatabase.execSQL(l);
        } catch (Exception e7) {
            com.igexin.c.a.c.a.a(e7);
        }
        try {
            sQLiteDatabase.execSQL(m);
        } catch (Exception e8) {
            com.igexin.c.a.c.a.a(e8);
        }
        try {
            sQLiteDatabase.execSQL(o);
        } catch (Exception e9) {
            com.igexin.c.a.c.a.a(e9);
        }
        try {
            sQLiteDatabase.execSQL(p);
        } catch (Exception e10) {
            com.igexin.c.a.c.a.a(e10);
        }
        onCreate(sQLiteDatabase);
    }
}
