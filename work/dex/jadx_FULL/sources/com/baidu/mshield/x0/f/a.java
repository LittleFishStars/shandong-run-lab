package com.baidu.mshield.x0.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f26745a;
    public C0282a d;
    public SQLiteDatabase e;
    public String b = "msvolcano.db";
    public int c = 1;
    public String f = "msal";
    public String g = "CREATE TABLE IF NOT EXISTS " + this.f + "(a TEXT PRIMARY KEY ON CONFLICT ABORT,b INTEGER,c TEXT)";

    /* JADX INFO: renamed from: com.baidu.mshield.x0.f.a$a, reason: collision with other inner class name */
    public class C0282a extends SQLiteOpenHelper {
        public C0282a(Context context) {
            super(context, a.this.b, (SQLiteDatabase.CursorFactory) null, a.this.c);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.g);
            } catch (Throwable th) {
                d.a(th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public a(Context context) {
        try {
            context.getApplicationContext();
            C0282a c0282a = new C0282a(context.getApplicationContext());
            this.d = c0282a;
            this.e = c0282a.getWritableDatabase();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a a(Context context) {
        if (f26745a == null) {
            f26745a = new a(context);
        }
        return f26745a;
    }

    public final boolean b(String str) {
        SQLiteDatabase sQLiteDatabase = this.e;
        boolean z = false;
        if (sQLiteDatabase == null) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query(this.f, null, "a=?", new String[]{str}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                z = true;
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
            }
        } catch (Throwable th) {
            try {
                d.a(th);
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        return z;
    }

    public int a(com.baidu.mshield.x0.d.a aVar) {
        int iInsert = 0;
        if (aVar != null && this.e != null) {
            try {
                String strB = d.b(aVar.f26734a);
                if (TextUtils.isEmpty(strB)) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("a", strB);
                contentValues.put("b", Integer.valueOf(aVar.b));
                contentValues.put("c", Long.valueOf(aVar.c));
                if (b(strB)) {
                    iInsert = this.e.update(this.f, contentValues, "a= ?", new String[]{strB});
                } else {
                    iInsert = (int) this.e.insert(this.f, null, contentValues);
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return iInsert;
    }

    public com.baidu.mshield.x0.d.a a(String str) {
        Cursor cursor;
        Throwable th;
        com.baidu.mshield.x0.d.a aVar;
        com.baidu.mshield.x0.d.a aVar2;
        Cursor cursorQuery;
        com.baidu.mshield.x0.d.a aVar3 = null;
        if (this.e == null) {
            return null;
        }
        try {
            try {
                String strB = d.b(str);
                if (TextUtils.isEmpty(strB)) {
                    return null;
                }
                cursorQuery = this.e.query(this.f, null, "a=?", new String[]{strB}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            while (cursorQuery.moveToNext()) {
                                aVar2 = new com.baidu.mshield.x0.d.a();
                                try {
                                    aVar2.f26734a = d.a(cursorQuery.getString(cursorQuery.getColumnIndex("a")));
                                    aVar2.b = cursorQuery.getInt(cursorQuery.getColumnIndex("b"));
                                    aVar2.c = Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("c")));
                                    aVar3 = aVar2;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        cursor = cursorQuery;
                        aVar = aVar3;
                        th = th3;
                        Cursor cursor2 = cursor;
                        aVar2 = aVar;
                        cursorQuery = cursor2;
                    }
                }
                if (cursorQuery == null || cursorQuery.isClosed()) {
                    return aVar3;
                }
                cursorQuery.close();
                return aVar3;
            } catch (Throwable th4) {
                cursor = null;
                th = th4;
                aVar = null;
            }
            d.a(th);
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return aVar2;
            }
            aVar3 = aVar2;
            cursorQuery.close();
            return aVar3;
        } catch (Throwable th5) {
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            throw th5;
        }
        Cursor cursor3 = cursor;
        aVar2 = aVar;
        cursorQuery = cursor3;
    }

    public List<com.baidu.mshield.x0.d.a> a() {
        Cursor cursorQuery = null;
        if (this.e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = this.e.query(this.f, null, null, null, null, null, "b DESC");
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                while (cursorQuery.moveToNext()) {
                    com.baidu.mshield.x0.d.a aVar = new com.baidu.mshield.x0.d.a();
                    aVar.f26734a = d.a(cursorQuery.getString(cursorQuery.getColumnIndex("a")));
                    aVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("b"));
                    aVar.c = Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("c")));
                    arrayList.add(aVar);
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
            }
        } catch (Throwable th) {
            try {
                d.a(th);
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        return arrayList;
    }
}
