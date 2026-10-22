package com.alibaba.analytics.core.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.analytics.a.j;
import com.alibaba.android.arouter.utils.Consts;
import com.fl.saas.base.cache.DatabaseHelper;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private String V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f23766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, Boolean> f630a = new HashMap<>();
    private HashMap<Class<?>, List<Field>> b = new HashMap<>();
    private HashMap<Field, String> c = new HashMap<>();
    private HashMap<Class<?>, String> d = new HashMap<>();

    public a(Context context, String str) {
        this.f23766a = new d(context, str);
        this.V = str;
    }

    private void b(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + str + " (" + DatabaseHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,");
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                Class<?> type = arrayList.get(i).getType();
                sb.append(" ");
                sb.append(a(arrayList.get(i)));
                sb.append(" ");
                sb.append(a(type));
                sb.append(" ");
                sb.append(b(type));
            }
        }
        sb.append(" );");
        String string = sb.toString();
        j.d("DBMgr", "excute sql:", string);
        try {
            sQLiteDatabase.execSQL(string);
        } catch (Exception e) {
            j.w("DBMgr", "create db error", e);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m107a(b bVar) {
        if (bVar != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(bVar);
            insert(arrayList);
        }
    }

    public synchronized void clear(Class<? extends b> cls) {
        if (cls == null) {
            return;
        }
        clear(getTablename(cls));
    }

    public synchronized int count(Class<? extends b> cls) {
        d dVar;
        int i = 0;
        if (cls == null) {
            return 0;
        }
        String tablename = getTablename(cls);
        SQLiteDatabase sQLiteDatabaseA = a(cls, tablename);
        if (sQLiteDatabaseA != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT count(*) FROM " + tablename, null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.moveToFirst();
                    i = cursorRawQuery.getInt(0);
                }
                this.f23766a.closeCursor(cursorRawQuery);
                dVar = this.f23766a;
            } catch (Throwable th) {
                try {
                    if (j.isDebug()) {
                        j.e("DBMgr", th.toString());
                    }
                    this.f23766a.closeCursor(cursorRawQuery);
                    dVar = this.f23766a;
                } catch (Throwable th2) {
                    this.f23766a.closeCursor(cursorRawQuery);
                    this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
                    throw th2;
                }
            }
            dVar.closeWritableDatabase(sQLiteDatabaseA);
        } else {
            j.d("DBMgr", "[count] db is null. tableName", tablename);
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized int delete(List<? extends b> list) {
        d dVar;
        if (list != null) {
            if (list.size() != 0) {
                String tablename = getTablename(list.get(0).getClass());
                SQLiteDatabase sQLiteDatabaseA = a(list.get(0).getClass(), tablename);
                if (sQLiteDatabaseA == null) {
                    j.d("DBMgr", "[delete] db is null. tableName", tablename);
                    return 0;
                }
                try {
                    sQLiteDatabaseA.beginTransaction();
                    StringBuffer stringBuffer = new StringBuffer();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        if (arrayList.size() > 0) {
                            stringBuffer.append(" OR ");
                        }
                        stringBuffer.append("_id=?");
                        arrayList.add(String.valueOf(list.get(i)._id));
                        if (arrayList.size() == 20) {
                            String[] strArr = new String[arrayList.size()];
                            arrayList.toArray(strArr);
                            long jDelete = sQLiteDatabaseA.delete(tablename, stringBuffer.toString(), strArr);
                            if (jDelete == arrayList.size()) {
                                j.d("DBMgr", "delete success. DbName", this.V, "tableName", tablename, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(jDelete));
                            } else {
                                j.d("DBMgr", "delete fail. DbName", this.V, "tableName", tablename, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(jDelete));
                            }
                            stringBuffer.delete(0, stringBuffer.length());
                            arrayList.clear();
                        }
                    }
                    if (arrayList.size() > 0) {
                        String[] strArr2 = new String[arrayList.size()];
                        arrayList.toArray(strArr2);
                        long jDelete2 = sQLiteDatabaseA.delete(tablename, stringBuffer.toString(), strArr2);
                        if (jDelete2 == arrayList.size()) {
                            j.d("DBMgr", "delete success. DbName", this.V, "tableName", tablename, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(jDelete2));
                        } else {
                            j.d("DBMgr", "delete fail. DbName", this.V, "tableName", tablename, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(jDelete2));
                        }
                    }
                    try {
                        sQLiteDatabaseA.setTransactionSuccessful();
                    } catch (Throwable unused) {
                    }
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused2) {
                    }
                    dVar = this.f23766a;
                } catch (Throwable th) {
                    try {
                        j.w("DBMgr", "db delete error", th);
                        try {
                            sQLiteDatabaseA.setTransactionSuccessful();
                        } catch (Throwable unused3) {
                        }
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused4) {
                        }
                        dVar = this.f23766a;
                    } catch (Throwable th2) {
                        try {
                            sQLiteDatabaseA.setTransactionSuccessful();
                        } catch (Throwable unused5) {
                        }
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused6) {
                        }
                        this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
                        throw th2;
                    }
                }
                dVar.closeWritableDatabase(sQLiteDatabaseA);
                return list.size();
            }
        }
        return 0;
    }

    public synchronized List<? extends b> find(Class<? extends b> cls, String str, String str2, int i) {
        List<? extends b> arrayList;
        Object objValueOf;
        List<? extends b> list = Collections.EMPTY_LIST;
        if (cls == null) {
            return list;
        }
        String tablename = getTablename(cls);
        SQLiteDatabase sQLiteDatabaseA = a(cls, tablename);
        if (sQLiteDatabaseA == null) {
            j.d("DBMgr", "[find] db is null. tableName", tablename);
            return list;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(tablename);
        sb.append(TextUtils.isEmpty(str) ? "" : " WHERE " + str);
        sb.append(TextUtils.isEmpty(str2) ? "" : " ORDER BY " + str2);
        sb.append(i <= 0 ? "" : " LIMIT " + i);
        String string = sb.toString();
        j.d("DBMgr", "sql", string);
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabaseA.rawQuery(string, null);
            arrayList = new ArrayList<>();
            try {
                List<Field> listM106a = m106a((Class) cls);
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    b bVarNewInstance = cls.newInstance();
                    for (int i2 = 0; i2 < listM106a.size(); i2++) {
                        Field field = listM106a.get(i2);
                        Class<?> type = field.getType();
                        String strA = a(field);
                        int columnIndex = cursorRawQuery.getColumnIndex(strA);
                        if (columnIndex != -1) {
                            if (type == Long.class || type == Long.TYPE) {
                                objValueOf = Long.valueOf(cursorRawQuery.getLong(columnIndex));
                            } else if (type == Integer.class || type == Integer.TYPE) {
                                objValueOf = Integer.valueOf(cursorRawQuery.getInt(columnIndex));
                            } else {
                                objValueOf = (type == Double.TYPE || type == Double.class) ? Double.valueOf(cursorRawQuery.getDouble(columnIndex)) : cursorRawQuery.getString(columnIndex);
                            }
                            try {
                                field.set(bVarNewInstance, objValueOf);
                            } catch (Exception e) {
                                try {
                                    if ((e instanceof IllegalArgumentException) && (objValueOf instanceof String)) {
                                        field.set(bVarNewInstance, Boolean.valueOf((String) objValueOf));
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        } else {
                            j.w("DBMgr", "can not get field", strA);
                        }
                    }
                    arrayList.add(bVarNewInstance);
                }
                this.f23766a.closeCursor(cursorRawQuery);
                this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
            } catch (Throwable th) {
                th = th;
                list = arrayList;
                try {
                    j.w("DBMgr", "[get]", th);
                    this.f23766a.closeCursor(cursorRawQuery);
                    this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
                    arrayList = list;
                } catch (Throwable th2) {
                    this.f23766a.closeCursor(cursorRawQuery);
                    this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return arrayList;
    }

    public String getTablename(Class<?> cls) {
        if (cls == null) {
            j.e("DBMgr", "cls is null");
            return null;
        }
        if (this.d.containsKey(cls)) {
            return this.d.get(cls);
        }
        com.alibaba.analytics.core.b.a.c cVar = (com.alibaba.analytics.core.b.a.c) cls.getAnnotation(com.alibaba.analytics.core.b.a.c.class);
        String strReplace = (cVar == null || TextUtils.isEmpty(cVar.value())) ? cls.getName().replace(Consts.DOT, LoginConstants.UNDER_LINE) : cVar.value();
        this.d.put(cls, strReplace);
        return strReplace;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void insert(List<? extends b> list) {
        d dVar;
        if (list != null) {
            if (list.size() != 0) {
                String tablename = getTablename(list.get(0).getClass());
                SQLiteDatabase sQLiteDatabaseA = a(list.get(0).getClass(), tablename);
                if (sQLiteDatabaseA == null) {
                    j.w("DBMgr", "[insert]can not get available db. tableName", tablename);
                    return;
                }
                j.d("DBMgr", "entities.size", Integer.valueOf(list.size()));
                try {
                    List<Field> listM106a = m106a((Class) list.get(0).getClass());
                    ContentValues contentValues = new ContentValues();
                    sQLiteDatabaseA.beginTransaction();
                    for (int i = 0; i < list.size(); i++) {
                        b bVar = list.get(i);
                        for (int i2 = 0; i2 < listM106a.size(); i2++) {
                            Field field = listM106a.get(i2);
                            String strA = a(field);
                            try {
                                try {
                                    Object obj = field.get(bVar);
                                    if (obj != null) {
                                        contentValues.put(strA, obj + "");
                                    } else {
                                        contentValues.put(strA, "");
                                    }
                                } catch (Exception e) {
                                    j.w("DBMgr", "get field failed", e);
                                }
                            } catch (Exception unused) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception unused2) {
                                }
                                dVar = this.f23766a;
                                dVar.closeWritableDatabase(sQLiteDatabaseA);
                            }
                        }
                        long j = bVar._id;
                        if (j == -1) {
                            contentValues.remove(DatabaseHelper.COLUMN_ID);
                            long jInsert = sQLiteDatabaseA.insert(tablename, null, contentValues);
                            if (jInsert != -1) {
                                bVar._id = jInsert;
                            }
                        } else {
                            sQLiteDatabaseA.update(tablename, contentValues, "_id=?", new String[]{String.valueOf(j)});
                        }
                        contentValues.clear();
                    }
                    try {
                        sQLiteDatabaseA.setTransactionSuccessful();
                    } catch (Exception unused3) {
                    }
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Exception unused4) {
                    }
                    dVar = this.f23766a;
                } catch (Throwable unused5) {
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    dVar = this.f23766a;
                    dVar.closeWritableDatabase(sQLiteDatabaseA);
                }
                dVar.closeWritableDatabase(sQLiteDatabaseA);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void update(List<? extends b> list) {
        d dVar;
        if (list != null) {
            if (list.size() != 0) {
                String tablename = getTablename(list.get(0).getClass());
                SQLiteDatabase sQLiteDatabaseA = a(list.get(0).getClass(), tablename);
                if (sQLiteDatabaseA == null) {
                    j.d("DBMgr", "[update] db is null. tableName", tablename);
                    return;
                }
                try {
                    try {
                        try {
                            sQLiteDatabaseA.beginTransaction();
                            List<Field> listM106a = m106a((Class) list.get(0).getClass());
                            for (int i = 0; i < list.size(); i++) {
                                ContentValues contentValues = new ContentValues();
                                for (int i2 = 0; i2 < listM106a.size(); i2++) {
                                    Field field = listM106a.get(i2);
                                    try {
                                        field.setAccessible(true);
                                        contentValues.put(a(field), field.get(list.get(i)) + "");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                sQLiteDatabaseA.update(tablename, contentValues, "_id=?", new String[]{list.get(i)._id + ""});
                            }
                            try {
                                sQLiteDatabaseA.setTransactionSuccessful();
                            } catch (Exception unused) {
                            }
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Exception unused2) {
                            }
                            dVar = this.f23766a;
                        } catch (Throwable th) {
                            try {
                                sQLiteDatabaseA.setTransactionSuccessful();
                            } catch (Exception unused3) {
                            }
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Exception unused4) {
                            }
                            this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
                            throw th;
                        }
                    } catch (Exception unused5) {
                        sQLiteDatabaseA.setTransactionSuccessful();
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Exception unused6) {
                        }
                        dVar = this.f23766a;
                        dVar.closeWritableDatabase(sQLiteDatabaseA);
                    }
                } catch (Exception unused7) {
                    sQLiteDatabaseA.endTransaction();
                    dVar = this.f23766a;
                }
                dVar.closeWritableDatabase(sQLiteDatabaseA);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void updateLogPriority(List<? extends b> list) {
        d dVar;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    String tablename = getTablename(list.get(0).getClass());
                    SQLiteDatabase sQLiteDatabaseA = a(list.get(0).getClass(), tablename);
                    if (sQLiteDatabaseA == null) {
                        j.d("DBMgr", "[updateLogPriority] db is null. tableName", tablename);
                        return;
                    }
                    try {
                        try {
                            try {
                                sQLiteDatabaseA.beginTransaction();
                                List<Field> listM106a = m106a((Class) list.get(0).getClass());
                                for (int i = 0; i < list.size(); i++) {
                                    ContentValues contentValues = new ContentValues();
                                    for (int i2 = 0; i2 < listM106a.size(); i2++) {
                                        Field field = listM106a.get(i2);
                                        String strA = a(field);
                                        if (strA != null && strA.equalsIgnoreCase("priority")) {
                                            try {
                                                field.setAccessible(true);
                                                contentValues.put(strA, field.get(list.get(i)) + "");
                                                sQLiteDatabaseA.update(tablename, contentValues, "_id=?", new String[]{list.get(i)._id + ""});
                                                break;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                try {
                                    sQLiteDatabaseA.setTransactionSuccessful();
                                } catch (Exception unused) {
                                }
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception unused2) {
                                }
                                dVar = this.f23766a;
                            } catch (Exception unused3) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception unused4) {
                                }
                                dVar = this.f23766a;
                            }
                        } catch (Exception unused5) {
                            sQLiteDatabaseA.setTransactionSuccessful();
                            sQLiteDatabaseA.endTransaction();
                            dVar = this.f23766a;
                            dVar.closeWritableDatabase(sQLiteDatabaseA);
                        }
                        dVar.closeWritableDatabase(sQLiteDatabaseA);
                    } catch (Throwable th) {
                        try {
                            sQLiteDatabaseA.setTransactionSuccessful();
                        } catch (Exception unused6) {
                        }
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Exception unused7) {
                        }
                        this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int a(b bVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(bVar);
        return delete(arrayList);
    }

    public synchronized void clear(String str) {
        if (str == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f23766a.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete(str, null, null);
                this.f23766a.closeWritableDatabase(writableDatabase);
            }
        } catch (Exception e) {
            j.e("delete db data", e, new Object[0]);
        }
    }

    private SQLiteDatabase a(Class<? extends b> cls, String str) {
        SQLiteDatabase writableDatabase = this.f23766a.getWritableDatabase();
        Boolean bool = Boolean.TRUE;
        if (this.f630a.get(str) == null || !this.f630a.get(str).booleanValue()) {
            bool = Boolean.FALSE;
        }
        if (cls != null && !bool.booleanValue() && writableDatabase != null) {
            List<Field> listM106a = m106a((Class) cls);
            ArrayList<Field> arrayList = new ArrayList<>();
            String str2 = " SELECT * FROM " + str + " LIMIT 0";
            int i = 0;
            if (listM106a != null) {
                Cursor cursorRawQuery = null;
                try {
                    cursorRawQuery = writableDatabase.rawQuery(str2, null);
                } catch (Exception unused) {
                    j.d("DBMgr", "has not create table", str);
                }
                int i2 = cursorRawQuery != null ? 0 : 1;
                while (i < listM106a.size()) {
                    Field field = listM106a.get(i);
                    if (!DatabaseHelper.COLUMN_ID.equalsIgnoreCase(a(field)) && (i2 != 0 || (cursorRawQuery != null && cursorRawQuery.getColumnIndex(a(field)) == -1))) {
                        arrayList.add(field);
                    }
                    i++;
                }
                this.f23766a.closeCursor(cursorRawQuery);
                i = i2;
            }
            if (i != 0) {
                b(writableDatabase, str, arrayList);
            } else if (arrayList.size() > 0) {
                a(writableDatabase, str, arrayList);
            }
            this.f630a.put(str, Boolean.TRUE);
        }
        return writableDatabase;
    }

    private String b(Class cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "default 0" : "default \"\"";
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        String str2 = "ALTER TABLE " + str + " ADD COLUMN ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(str2);
            sb.append(a(arrayList.get(i)));
            sb.append(" ");
            sb.append(a(arrayList.get(i).getType()));
            String string = sb.toString();
            try {
                sQLiteDatabase.execSQL(string);
            } catch (Exception e) {
                j.w("DBMgr", "update db error...", e);
            }
            sb.delete(0, string.length());
            j.d("DBMgr", null, "excute sql:", string);
        }
    }

    private String a(Class<?> cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "INTEGER" : "TEXT";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private List<Field> m106a(Class cls) {
        if (this.b.containsKey(cls)) {
            return this.b.get(cls);
        }
        List<Field> listEmptyList = Collections.emptyList();
        if (cls != null) {
            listEmptyList = new ArrayList<>();
            for (Field field : cls.getDeclaredFields()) {
                if (field.getAnnotation(com.alibaba.analytics.core.b.a.b.class) == null && !field.isSynthetic()) {
                    field.setAccessible(true);
                    listEmptyList.add(field);
                }
            }
            if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
                listEmptyList.addAll(m106a(cls.getSuperclass()));
            }
            this.b.put(cls, listEmptyList);
        }
        return listEmptyList;
    }

    private String a(Field field) {
        String name;
        if (this.c.containsKey(field)) {
            return this.c.get(field);
        }
        com.alibaba.analytics.core.b.a.a aVar = (com.alibaba.analytics.core.b.a.a) field.getAnnotation(com.alibaba.analytics.core.b.a.a.class);
        if (aVar != null && !TextUtils.isEmpty(aVar.value())) {
            name = aVar.value();
        } else {
            name = field.getName();
        }
        this.c.put(field, name);
        return name;
    }

    public synchronized int delete(Class<? extends b> cls, String str, String[] strArr) {
        d dVar;
        int iDelete = 0;
        if (cls != null) {
            SQLiteDatabase sQLiteDatabaseA = a(cls, getTablename(cls));
            if (sQLiteDatabaseA == null) {
                return 0;
            }
            try {
                iDelete = sQLiteDatabaseA.delete(getTablename(cls), str, strArr);
                dVar = this.f23766a;
            } catch (Throwable th) {
                try {
                    j.w("DBMgr", th, new Object[0]);
                    dVar = this.f23766a;
                } catch (Throwable th2) {
                    this.f23766a.closeWritableDatabase(sQLiteDatabaseA);
                    throw th2;
                }
            }
            dVar.closeWritableDatabase(sQLiteDatabaseA);
        }
        return iDelete;
    }

    public double a() {
        File databasePath = com.alibaba.analytics.core.d.a().getContext().getDatabasePath("ut.db");
        return databasePath != null ? (databasePath.length() / 1024.0d) / 1024.0d : AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
