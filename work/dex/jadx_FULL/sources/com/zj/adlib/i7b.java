package com.zj.adlib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.col.p0003l.gv;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i7b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Class<? extends gv>, gv> f42297a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SQLiteDatabase f17163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gv f17164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k7b f17165a;

    public i7b(Context context, gv gvVar) {
        try {
            this.f17165a = new k7b(context.getApplicationContext(), gvVar.b(), gvVar.c(), gvVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f17164a = gvVar;
    }

    public static ContentValues a(Object obj, com.amap.api.col.p0003l.gx gxVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : m(obj.getClass(), gxVar.b())) {
            field.setAccessible(true);
            i(obj, field, contentValues);
        }
        return contentValues;
    }

    public static synchronized gv c(Class<? extends gv> cls) throws IllegalAccessException, InstantiationException {
        if (f42297a.get(cls) == null) {
            f42297a.put(cls, cls.newInstance());
        }
        return f42297a.get(cls);
    }

    public static <T> T d(Cursor cursor, Class<T> cls, com.amap.api.col.p0003l.gx gxVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Field[] fieldArrM = m(cls, gxVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T tNewInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : fieldArrM) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(com.amap.api.col.p0003l.gy.class);
            if (annotation != null) {
                com.amap.api.col.p0003l.gy gyVar = (com.amap.api.col.p0003l.gy) annotation;
                int iB = gyVar.b();
                int columnIndex = cursor.getColumnIndex(gyVar.a());
                switch (iB) {
                    case 1:
                        field.set(tNewInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(tNewInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(tNewInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(tNewInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(tNewInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(tNewInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(tNewInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return tNewInstance;
    }

    public static <T> String e(com.amap.api.col.p0003l.gx gxVar) {
        if (gxVar == null) {
            return null;
        }
        return gxVar.a();
    }

    public static <T> void f(SQLiteDatabase sQLiteDatabase, T t) {
        com.amap.api.col.p0003l.gx gxVarO = o(t.getClass());
        String strE = e(gxVarO);
        if (TextUtils.isEmpty(strE) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(strE, null, a(t, gxVarO));
    }

    public static void i(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(com.amap.api.col.p0003l.gy.class);
        if (annotation == null) {
        }
        com.amap.api.col.p0003l.gy gyVar = (com.amap.api.col.p0003l.gy) annotation;
        try {
            switch (gyVar.b()) {
                case 1:
                    contentValues.put(gyVar.a(), Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(gyVar.a(), Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(gyVar.a(), Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(gyVar.a(), Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(gyVar.a(), Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(gyVar.a(), (String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(gyVar.a(), (byte[]) field.get(obj));
                    break;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Field[] m(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    public static <T> com.amap.api.col.p0003l.gx o(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(com.amap.api.col.p0003l.gx.class);
        if (annotation != null) {
            return (com.amap.api.col.p0003l.gx) annotation;
        }
        return null;
    }

    public final SQLiteDatabase b() {
        try {
            if (this.f17163a == null) {
                this.f17163a = this.f17165a.getReadableDatabase();
            }
        } catch (Throwable th) {
            v6b.b(th, "dbs", "grd");
        }
        return this.f17163a;
    }

    public final <T> void g(T t) {
        q(t);
    }

    public final void h(Object obj, String str) {
        synchronized (this.f17164a) {
            List listP = p(str, obj.getClass());
            if (listP == null || listP.size() == 0) {
                g(obj);
            } else {
                r(str, obj);
            }
        }
    }

    public final <T> void j(String str, Class<T> cls) {
        synchronized (this.f17164a) {
            String strE = e(o(cls));
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            SQLiteDatabase sQLiteDatabaseN = n();
            this.f17163a = sQLiteDatabaseN;
            if (sQLiteDatabaseN == null) {
                return;
            }
            try {
                sQLiteDatabaseN.delete(strE, str, null);
                SQLiteDatabase sQLiteDatabase = this.f17163a;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    this.f17163a = null;
                }
            } catch (Throwable th) {
                try {
                    v6b.b(th, "dbs", "dld");
                    SQLiteDatabase sQLiteDatabase2 = this.f17163a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.f17163a;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.f17163a = null;
                    }
                    throw th2;
                }
            }
        }
    }

    public final <T> void k(String str, Object obj) {
        synchronized (this.f17164a) {
            if (obj == null) {
                return;
            }
            com.amap.api.col.p0003l.gx gxVarO = o(obj.getClass());
            String strE = e(gxVarO);
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            ContentValues contentValuesA = a(obj, gxVarO);
            SQLiteDatabase sQLiteDatabaseN = n();
            this.f17163a = sQLiteDatabaseN;
            if (sQLiteDatabaseN == null) {
                return;
            }
            try {
                sQLiteDatabaseN.update(strE, contentValuesA, str, null);
                SQLiteDatabase sQLiteDatabase = this.f17163a;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    this.f17163a = null;
                }
            } catch (Throwable th) {
                try {
                    v6b.b(th, "dbs", "udd");
                    SQLiteDatabase sQLiteDatabase2 = this.f17163a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.f17163a;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.f17163a = null;
                    }
                    throw th2;
                }
            }
        }
    }

    public final <T> void l(List<T> list) {
        String str;
        String str2;
        synchronized (this.f17164a) {
            if (list.size() == 0) {
                return;
            }
            SQLiteDatabase sQLiteDatabaseN = n();
            this.f17163a = sQLiteDatabaseN;
            if (sQLiteDatabaseN == null) {
                return;
            }
            try {
                sQLiteDatabaseN.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    f(this.f17163a, it.next());
                }
                this.f17163a.setTransactionSuccessful();
                try {
                    if (this.f17163a.inTransaction()) {
                        this.f17163a.endTransaction();
                    }
                } catch (Throwable th) {
                    v6b.b(th, "dbs", "ild");
                }
                try {
                    this.f17163a.close();
                    this.f17163a = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = "dbs";
                    str2 = "ild";
                    v6b.b(th, str, str2);
                }
            } catch (Throwable th3) {
                try {
                    v6b.b(th3, "dbs", "ild");
                    try {
                        if (this.f17163a.inTransaction()) {
                            this.f17163a.endTransaction();
                        }
                    } catch (Throwable th4) {
                        v6b.b(th4, "dbs", "ild");
                    }
                    try {
                        this.f17163a.close();
                        this.f17163a = null;
                    } catch (Throwable th5) {
                        th = th5;
                        str = "dbs";
                        str2 = "ild";
                        v6b.b(th, str, str2);
                    }
                } catch (Throwable th6) {
                    try {
                        if (!this.f17163a.inTransaction()) {
                            this.f17163a.close();
                            this.f17163a = null;
                            throw th6;
                        }
                        this.f17163a.endTransaction();
                        try {
                            this.f17163a.close();
                            this.f17163a = null;
                            throw th6;
                        } catch (Throwable th7) {
                            v6b.b(th7, "dbs", "ild");
                            throw th6;
                        }
                    } catch (Throwable th8) {
                        v6b.b(th8, "dbs", "ild");
                    }
                }
            }
        }
    }

    public final SQLiteDatabase n() {
        try {
            SQLiteDatabase sQLiteDatabase = this.f17163a;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.f17163a;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.f17163a = this.f17165a.getWritableDatabase();
            }
        } catch (Throwable th) {
            v6b.b(th, "dbs", "gwd");
        }
        return this.f17163a;
    }

    public final <T> List<T> p(String str, Class<T> cls) {
        return s(str, cls);
    }

    public final <T> void q(T t) {
        synchronized (this.f17164a) {
            SQLiteDatabase sQLiteDatabaseN = n();
            this.f17163a = sQLiteDatabaseN;
            if (sQLiteDatabaseN == null) {
                return;
            }
            try {
                f(sQLiteDatabaseN, t);
                SQLiteDatabase sQLiteDatabase = this.f17163a;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    this.f17163a = null;
                }
            } catch (Throwable th) {
                try {
                    v6b.b(th, "dbs", "itd");
                    SQLiteDatabase sQLiteDatabase2 = this.f17163a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.f17163a;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.f17163a = null;
                    }
                    throw th2;
                }
            }
        }
    }

    public final <T> void r(String str, Object obj) {
        k(str, obj);
    }

    /* JADX WARN: Code duplicated, block: B:104:? A[Catch: all -> 0x00dc, SYNTHETIC, TryCatch #7 {, blocks: (B:4:0x0003, B:6:0x0014, B:7:0x001a, B:9:0x001e, B:28:0x005e, B:27:0x0057, B:21:0x0045, B:62:0x00b6, B:44:0x0089, B:37:0x0073, B:55:0x009f, B:76:0x00d9, B:75:0x00d2, B:69:0x00c0, B:77:0x00da, B:70:0x00c7, B:72:0x00cb, B:34:0x006e, B:18:0x0040, B:22:0x004c, B:24:0x0050, B:50:0x0091, B:52:0x009a, B:66:0x00bb), top: B:96:0x0003, inners: #1, #2, #4, #5, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0050 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #5 {all -> 0x0056, blocks: (B:22:0x004c, B:24:0x0050), top: B:92:0x004c, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb A[Catch: all -> 0x00d1, TRY_LEAVE, TryCatch #1 {all -> 0x00d1, blocks: (B:70:0x00c7, B:72:0x00cb), top: B:84:0x00c7, outer: #7 }] */
    public final <T> List<T> s(String str, Class<T> cls) {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabase;
        String str2;
        String str3;
        SQLiteDatabase sQLiteDatabase2;
        synchronized (this.f17164a) {
            ArrayList arrayList = new ArrayList();
            com.amap.api.col.p0003l.gx gxVarO = o(cls);
            String strE = e(gxVarO);
            if (this.f17163a == null) {
                this.f17163a = b();
            }
            if (this.f17163a == null || TextUtils.isEmpty(strE) || str == null) {
                return arrayList;
            }
            try {
                cursorQuery = this.f17163a.query(strE, null, str, null, null, null, null);
                try {
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(d(cursorQuery, cls, gxVarO));
                        }
                        try {
                            cursorQuery.close();
                        } catch (Throwable th) {
                            v6b.b(th, "dbs", "sld");
                        }
                        try {
                            SQLiteDatabase sQLiteDatabase3 = this.f17163a;
                            if (sQLiteDatabase3 != null) {
                                sQLiteDatabase3.close();
                                this.f17163a = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = "dbs";
                            str3 = "sld";
                            v6b.b(th, str2, str3);
                        }
                        return arrayList;
                    }
                    this.f17163a.close();
                    this.f17163a = null;
                    if (cursorQuery == null) {
                        sQLiteDatabase2 = this.f17163a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                            this.f17163a = null;
                        }
                        return arrayList;
                    }
                    try {
                        cursorQuery.close();
                    } catch (Throwable th3) {
                        v6b.b(th3, "dbs", "sld");
                    }
                    try {
                        sQLiteDatabase2 = this.f17163a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                            this.f17163a = null;
                        }
                    } catch (Throwable th4) {
                        v6b.b(th4, "dbs", "sld");
                    }
                    return arrayList;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        v6b.b(th, "dbs", "sld");
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable th6) {
                                v6b.b(th6, "dbs", "sld");
                            }
                        }
                        try {
                            SQLiteDatabase sQLiteDatabase4 = this.f17163a;
                            if (sQLiteDatabase4 != null) {
                                sQLiteDatabase4.close();
                                this.f17163a = null;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            str2 = "dbs";
                            str3 = "sld";
                            v6b.b(th, str2, str3);
                        }
                    } catch (Throwable th8) {
                        if (cursorQuery == null) {
                            sQLiteDatabase = this.f17163a;
                            if (sQLiteDatabase != null) {
                                throw th8;
                            }
                            sQLiteDatabase.close();
                            this.f17163a = null;
                            throw th8;
                        }
                        try {
                            cursorQuery.close();
                        } catch (Throwable th9) {
                            v6b.b(th9, "dbs", "sld");
                        }
                        try {
                            sQLiteDatabase = this.f17163a;
                            if (sQLiteDatabase != null) {
                                throw th8;
                            }
                            sQLiteDatabase.close();
                            this.f17163a = null;
                            throw th8;
                        } catch (Throwable th10) {
                            v6b.b(th10, "dbs", "sld");
                            throw th8;
                        }
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                cursorQuery = null;
            }
            throw th;
        }
    }
}
