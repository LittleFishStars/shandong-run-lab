package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class t {
    private static t E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40140a = "k";
    public static final String b = "p";
    public static final String c = "v";
    public static final String d = "l";
    public static final String e = "i";
    public static final String f = "a";
    public static final String g = "s";
    public static final String h = "n";
    public static final String i = "u";
    public static final String j = "c";
    public static final String k = "r";
    public static final String l = "b";
    public static final String m = "m";
    public static final String n = "el";
    public static final String o = "ail";
    public static final String p = "aps";
    public static final String q = "dp";
    public static final String r = "pcn";
    public static final String s = "pst";
    public static final String t = "d";
    public static final String u = "at";
    public static final String v = "dm";
    public static final String w = "rm";
    public static final String x = "pc";
    public static final String y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;
    private int z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    public class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bg.p, (SQLiteDatabase.CursorFactory) null, t.this.z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i >= 3 || i2 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    private t(Context context) {
        this.D = context.getApplicationContext();
        this.B = new a(context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    public int c(int i2) {
        Cursor cursorQuery;
        int i3 = 0;
        try {
            cursorQuery = this.C.query(bg.q, new String[]{"n"}, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                    }
                    return i3;
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return i3;
    }

    public boolean d(int i2) {
        Cursor cursorQuery;
        boolean z = false;
        try {
            cursorQuery = this.C.query(bg.q, new String[]{"s"}, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst() && cursorQuery.getInt(cursorQuery.getColumnIndex("s")) == 1) {
                        z = true;
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                    }
                    return z;
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return z;
    }

    public static synchronized t a(Context context) {
        if (E == null) {
            E = new t(context);
        }
        return E;
    }

    public boolean b(int i2) {
        Cursor cursorQuery;
        boolean z = false;
        try {
            cursorQuery = this.C.query(bg.q, new String[]{"p"}, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        z = true;
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                    }
                    return z;
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return z;
    }

    public long a(s sVar) {
        long jInsert = 0;
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.b));
        contentValues.put(p, Integer.valueOf(sVar.p));
        contentValues.put("p", sVar.c);
        contentValues.put("a", sVar.e);
        contentValues.put(d, sVar.h);
        contentValues.put("v", sVar.d);
        contentValues.put(q, sVar.n);
        contentValues.put("a", sVar.e);
        contentValues.put(r, sVar.o);
        contentValues.put(s, Long.valueOf(sVar.s));
        contentValues.put(w, Integer.valueOf(sVar.w));
        contentValues.put(u, Integer.valueOf(sVar.q));
        contentValues.put(x, Integer.valueOf(sVar.x));
        contentValues.put(y, Integer.valueOf(sVar.y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.j)) {
            contentValues.put("dm", sVar.j);
        }
        try {
            if (b(sVar.f40139a)) {
                jInsert = this.C.update(bg.q, contentValues, "k=" + sVar.f40139a, null);
            } else {
                contentValues.put("k", Integer.valueOf(sVar.f40139a));
                jInsert = this.C.insert(bg.q, null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return jInsert;
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dl.a(sVar.e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r rVarA = r.a();
            for (s sVar2 : arrayList) {
                if (rVarA != null) {
                    rVarA.a(sVar2.e);
                }
                this.C.delete(bg.q, "k=" + sVar2.f40139a, null);
                List<Integer> list = r.b;
                if (list != null && !list.contains(Integer.valueOf(sVar2.f40139a))) {
                    dl.c(this.D.getFilesDir().getCanonicalPath() + bg.j + sVar2.f40139a);
                }
                if (rVarA.b() != null && rVarA.b().get(sVar2.c) != null) {
                    dl.c(this.D.getFileStreamPath(sVar2.c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bg.q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.C.update(bg.q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(x, Integer.valueOf(i3));
            this.C.update(bg.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public List<s> a() {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = this.C.query(bg.q, null, null, null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        s sVar = new s();
                        sVar.f40139a = cursorQuery.getInt(cursorQuery.getColumnIndex("k"));
                        sVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                        sVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                        sVar.h = cursorQuery.getString(cursorQuery.getColumnIndex(d));
                        sVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                        sVar.s = cursorQuery.getLong(cursorQuery.getColumnIndex(s));
                        sVar.t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                        sVar.w = cursorQuery.getInt(cursorQuery.getColumnIndex(w));
                        sVar.x = cursorQuery.getInt(cursorQuery.getColumnIndex(x));
                        boolean z = true;
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex(y)) != 1) {
                            z = false;
                        }
                        sVar.y = z;
                        arrayList.add(sVar);
                    } catch (Throwable unused) {
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                        }
                        return arrayList;
                    }
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return arrayList;
    }

    public void b(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i3));
            this.C.update(bg.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        s sVar;
        Cursor cursor = null;
        sVar = null;
        s sVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z = true;
            Cursor cursorQuery = this.C.query(bg.q, null, "p=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f40139a = cursorQuery.getInt(cursorQuery.getColumnIndex("k"));
                            sVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                            sVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                            sVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                            sVar.h = cursorQuery.getString(cursorQuery.getColumnIndex(d));
                            sVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                            sVar.n = cursorQuery.getString(cursorQuery.getColumnIndex(q));
                            sVar.p = cursorQuery.getInt(cursorQuery.getColumnIndex(p));
                            sVar.o = cursorQuery.getString(cursorQuery.getColumnIndex(r));
                            sVar.q = cursorQuery.getInt(cursorQuery.getColumnIndex(u));
                            sVar.s = cursorQuery.getLong(cursorQuery.getColumnIndex(s));
                            sVar.t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                            sVar.w = cursorQuery.getInt(cursorQuery.getColumnIndex(w));
                            sVar.j = cursorQuery.getString(cursorQuery.getColumnIndex("dm"));
                            sVar.x = cursorQuery.getInt(cursorQuery.getColumnIndex(x));
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = cursorQuery;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return sVar2;
            }
            cursorQuery.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public s a(int i2) {
        s sVar;
        Cursor cursor = null;
        sVar = null;
        s sVar2 = null;
        try {
            Cursor cursorQuery = this.C.query(bg.q, null, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f40139a = i2;
                            sVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                            sVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                            sVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                            sVar.h = cursorQuery.getString(cursorQuery.getColumnIndex(d));
                            sVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                            sVar.n = cursorQuery.getString(cursorQuery.getColumnIndex(q));
                            sVar.p = cursorQuery.getInt(cursorQuery.getColumnIndex(p));
                            sVar.o = cursorQuery.getString(cursorQuery.getColumnIndex(r));
                            sVar.q = cursorQuery.getInt(cursorQuery.getColumnIndex(u));
                            sVar.s = cursorQuery.getLong(cursorQuery.getColumnIndex(s));
                            sVar.t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                            sVar.w = cursorQuery.getInt(cursorQuery.getColumnIndex(w));
                            sVar.j = cursorQuery.getString(cursorQuery.getColumnIndex("dm"));
                            sVar.x = cursorQuery.getInt(cursorQuery.getColumnIndex(x));
                            boolean z = true;
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = cursorQuery;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return sVar2;
            }
            cursorQuery.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bg.q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i3));
            return this.C.update(bg.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
