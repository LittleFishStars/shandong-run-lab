package com.baidu.mshield.rp.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.mshield.ac.F;
import com.zj.adlib.c49;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f26713a;
    public C0279a b;
    public SQLiteDatabase c;
    public Context d;

    /* JADX INFO: renamed from: com.baidu.mshield.rp.c.a$a, reason: collision with other inner class name */
    public class C0279a extends SQLiteOpenHelper {
        public C0279a(a aVar, Context context) {
            super(context, "msre.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public a(Context context) {
        this.d = context;
        this.b = new C0279a(this, context);
        com.baidu.mshield.sharedpreferences.a.a(context);
        d();
    }

    public static synchronized a a(Context context) {
        if (f26713a == null) {
            f26713a = new a(context);
        }
        return f26713a;
    }

    public boolean b(String str) {
        boolean z = true;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.c.query("c", null, "b=?", new String[]{str}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    z = false;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                try {
                    com.baidu.mshield.utility.a.a(th);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th3) {
                            com.baidu.mshield.utility.a.a(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return z;
    }

    public List<com.baidu.mshield.rp.d.a> c() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.c.query("r", null, "i=5", null, null, null, "d desc", "100");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                        aVar.f26714a = cursorQuery.getInt(cursorQuery.getColumnIndex("a"));
                        aVar.b = cursorQuery.getString(cursorQuery.getColumnIndex("b"));
                        aVar.c = cursorQuery.getInt(cursorQuery.getColumnIndex("c"));
                        aVar.e = cursorQuery.getLong(cursorQuery.getColumnIndex("d"));
                        aVar.f = cursorQuery.getInt(cursorQuery.getColumnIndex(y6b.f));
                        aVar.g = cursorQuery.getInt(cursorQuery.getColumnIndex("e"));
                        aVar.h = cursorQuery.getInt(cursorQuery.getColumnIndex("f"));
                        aVar.i = cursorQuery.getInt(cursorQuery.getColumnIndex("i"));
                        aVar.j = cursorQuery.getString(cursorQuery.getColumnIndex("j"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(y6b.g));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception e) {
                            com.baidu.mshield.utility.a.a(e);
                        }
                        aVar.d = string;
                        arrayList.add(aVar);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return arrayList;
    }

    public final void d() {
        try {
            this.c = this.b.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public long a(com.baidu.mshield.rp.d.a aVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", aVar.b);
            contentValues.put("c", Integer.valueOf(aVar.c));
            contentValues.put("d", Long.valueOf(aVar.e));
            contentValues.put("e", Integer.valueOf(aVar.g));
            contentValues.put(y6b.f, Integer.valueOf(aVar.f));
            contentValues.put("f", Integer.valueOf(aVar.h));
            contentValues.put("i", Integer.valueOf(aVar.i));
            contentValues.put("j", aVar.j);
            String strEncodeToString = aVar.d;
            try {
                strEncodeToString = Base64.encodeToString(F.getInstance().ae(strEncodeToString.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
            } catch (Exception e) {
                com.baidu.mshield.utility.a.a(e);
            }
            contentValues.put(y6b.g, strEncodeToString);
            try {
                return this.c.insert("r", null, contentValues);
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                return -1L;
            }
        } catch (Throwable th2) {
            com.baidu.mshield.utility.a.a(th2);
            return -1L;
        }
    }

    public List<com.baidu.mshield.rp.d.a> b(int i) {
        String str;
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.d);
            int iF = aVarA.F() * 3600000;
            if (i == 2) {
                str = "(d <= (" + jCurrentTimeMillis + c49.f40900a + "e*3600000) or e=0 )";
            } else {
                str = "(d <= (" + jCurrentTimeMillis + c49.f40900a + "e*3600000) or e=0 ) and (" + y6b.f + "!=2 or d<=" + (jCurrentTimeMillis - ((long) iF)) + ")";
            }
            String str2 = str;
            try {
                try {
                    if (i == 2) {
                        cursorQuery = this.c.query("r", null, str2, null, null, null, "d desc", Integer.toString(100));
                    } else {
                        cursorQuery = this.c.query("r", null, str2, null, null, null, "d desc", Integer.toString(aVarA.h()));
                    }
                    cursor = cursorQuery;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                                aVar.f26714a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                                aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                                aVar.f = cursor.getInt(cursor.getColumnIndex(y6b.f));
                                aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                                aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                                aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                                aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                                String string = cursor.getString(cursor.getColumnIndex(y6b.g));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e) {
                                    com.baidu.mshield.utility.a.a(e);
                                }
                                aVar.d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } catch (Throwable th2) {
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                            throw th2;
                                        } catch (Throwable th3) {
                                            com.baidu.mshield.utility.a.a(th3);
                                            throw th2;
                                        }
                                    }
                                    throw th2;
                                    return arrayList;
                                }
                            }
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th4) {
                    com.baidu.mshield.utility.a.a(th4);
                }
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
            }
        } catch (Throwable th6) {
            com.baidu.mshield.utility.a.a(th6);
        }
        return arrayList;
    }

    public long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.c.insert("c", null, contentValues);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1L;
        }
    }

    public int a(int i) {
        try {
            return this.c.delete("r", "a=?", new String[]{i + ""});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }

    public int a(List<Integer> list) {
        int iA = -1;
        try {
            this.c.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iA = a(it.next().intValue());
                if (iA <= 0) {
                    com.baidu.mshield.rp.f.a.f26717a = System.currentTimeMillis();
                }
            }
            this.c.setTransactionSuccessful();
            try {
                this.c.endTransaction();
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                com.baidu.mshield.rp.f.a.f26717a = System.currentTimeMillis();
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                com.baidu.mshield.rp.f.a.f26717a = System.currentTimeMillis();
            } finally {
                try {
                    this.c.endTransaction();
                } catch (Throwable th3) {
                    com.baidu.mshield.utility.a.a(th3);
                    com.baidu.mshield.rp.f.a.f26717a = System.currentTimeMillis();
                }
            }
        }
        return iA;
    }

    public List<com.baidu.mshield.rp.d.a> a(boolean z, int i) {
        String str;
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z) {
                str = "(d < (" + jCurrentTimeMillis + c49.f40900a + "f*3600000) and f!= 0)";
            } else {
                str = "d<=" + (jCurrentTimeMillis - 259200000);
            }
            String str2 = str;
            try {
                try {
                    if (i == 2) {
                        cursorQuery = this.c.query("r", null, str2, null, null, null, "d desc", "100");
                    } else {
                        int iH = com.baidu.mshield.sharedpreferences.a.a(this.d).h();
                        com.baidu.mshield.b.c.a.b("sj-trigger report 3g limit" + Integer.toString(iH));
                        cursorQuery = this.c.query("r", null, str2, null, null, null, "d desc", Integer.toString(iH));
                    }
                    cursor = cursorQuery;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                                aVar.f26714a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                                aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                                aVar.f = cursor.getInt(cursor.getColumnIndex(y6b.f));
                                aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                                aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                                aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                                aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                                String string = cursor.getString(cursor.getColumnIndex(y6b.g));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e) {
                                    com.baidu.mshield.utility.a.a(e);
                                }
                                aVar.d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } catch (Throwable th2) {
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                            throw th2;
                                        } catch (Throwable th3) {
                                            com.baidu.mshield.utility.a.a(th3);
                                            throw th2;
                                        }
                                    }
                                    throw th2;
                                    return arrayList;
                                }
                            }
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                }
            } catch (Throwable th5) {
                com.baidu.mshield.utility.a.a(th5);
            }
        } catch (Throwable th6) {
            com.baidu.mshield.utility.a.a(th6);
        }
        return arrayList;
    }

    public int b() {
        Cursor cursorQuery = null;
        int count = 0;
        try {
            try {
                cursorQuery = this.c.query("r", null, null, null, null, null, null, null);
                if (cursorQuery != null) {
                    count = cursorQuery.getCount();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return count;
    }

    public int a() {
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.c.delete("r", "(d <= ? or (d < (" + jCurrentTimeMillis + c49.f40900a + "f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(jCurrentTimeMillis - ((long) (aVarA.I() * 86400000)))});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }
}
