package com.beizi.fusion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class la implements ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f27508a;
    private final String b = g();
    private final List c;
    private final Map d;
    private final a e;

    public class a extends SQLiteOpenHelper {
        private a(Context context) {
            super(context, la.this.b, la.this.f(), la.this.e());
            om.a("IBaseDbHelper", "数据库版本 " + la.this.e() + " 名称 " + la.this.b);
        }

        private void a(SQLiteDatabase sQLiteDatabase, Map map) {
            if (map == null || map.isEmpty()) {
                return;
            }
            om.a("IBaseDbHelper", "建表..." + map.size());
            for (Map.Entry entry : map.entrySet()) {
                try {
                    sb sbVar = (sb) ((Class) entry.getKey()).newInstance();
                    if (sbVar.getColumns() != null) {
                        la.this.a(sQLiteDatabase, (String) entry.getValue(), sbVar.getColumns());
                    }
                } catch (IllegalAccessException | InstantiationException e) {
                    om.a(e);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            om.a("IBaseDbHelper", "数据库创建...");
            a(sQLiteDatabase, la.this.d);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            om.a("IBaseDbHelper", "数据库更新... old " + i + " new " + i2);
            if (i < i2) {
                a(sQLiteDatabase, la.this.d);
            }
            la.this.a(sQLiteDatabase, i, i2);
        }
    }

    public la(Context context) {
        Context applicationContext = context.getApplicationContext();
        List listA = a();
        this.c = listA;
        this.d = a(listA);
        a aVar = new a(applicationContext);
        this.e = aVar;
        try {
            this.f27508a = aVar.getWritableDatabase();
        } catch (SQLException unused) {
        }
    }

    private Map a(List list) {
        om.a("IBaseDbHelper", "创建数据库映射..." + list.size());
        if (list.isEmpty()) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            map.put(cls, b(cls));
        }
        return map;
    }

    private boolean c(sb sbVar) {
        return (sbVar == null || sbVar.getContentValuesStruct() == null || sbVar.getContentValuesStruct().size() <= 0) ? false : true;
    }

    private String g() {
        StringBuilder sb = new StringBuilder();
        String strC = c();
        if (!TextUtils.isEmpty(strC) && strC.lastIndexOf(Consts.DOT) > 0) {
            strC = strC.substring(strC.lastIndexOf(Consts.DOT) + 1);
        }
        sb.append("scope_");
        sb.append(strC);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(".db");
        return sb.toString();
    }

    public abstract List a();

    public String b(Class cls) {
        return String.format("t_%s_%s", c(), cls.getSimpleName());
    }

    public abstract String c();

    public void d() {
        SQLiteDatabase sQLiteDatabase = this.f27508a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.endTransaction();
        }
    }

    public int e() {
        return 4;
    }

    public String e(String str) {
        return String.format(" %s %s ? ", str, " < ");
    }

    public SQLiteDatabase.CursorFactory f() {
        return null;
    }

    public void h() {
        SQLiteDatabase sQLiteDatabase = this.f27508a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    private boolean b(sb sbVar) {
        if (sbVar != null) {
            return a(sbVar.getClass());
        }
        return false;
    }

    public synchronized int c(Class cls) {
        return a(cls, (String) null, (String[]) null, (String) null);
    }

    public String c(String str) {
        return String.format("%s BETWEEN ? AND ? ", str);
    }

    public String d(String str) {
        return String.format(" %s %s ? ", str, " = ");
    }

    public void b() {
        SQLiteDatabase sQLiteDatabase = this.f27508a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
        }
    }

    public synchronized int b(Class cls, long[] jArr) {
        if (jArr != null) {
            if (jArr.length > 0) {
                String[] strArr = new String[jArr.length];
                for (int i = 0; i < jArr.length; i++) {
                    strArr[i] = String.valueOf(jArr[i]);
                }
                return a(cls, a("id", jArr.length), strArr);
            }
        }
        return -1;
    }

    private boolean a(Class cls) {
        List list;
        return (this.f27508a == null || (list = this.c) == null || !list.contains(cls)) ? false : true;
    }

    @Override // com.beizi.fusion.ja
    public synchronized long a(sb sbVar) {
        SQLiteDatabase sQLiteDatabase;
        if (b(sbVar) && c(sbVar) && (sQLiteDatabase = this.f27508a) != null) {
            return sQLiteDatabase.insert((String) this.d.get(sbVar.getClass()), null, sbVar.getContentValuesStruct());
        }
        return -1L;
    }

    public int a(Class cls, String[] strArr, String[] strArr2, List list) {
        if (!a(cls) || list == null || list.isEmpty() || this.f27508a == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < strArr.length; i++) {
            contentValues.put(strArr[i], strArr2[i]);
        }
        String str = "id IN (" + TextUtils.join(",", Collections.nCopies(list.size(), "?")) + ")";
        String[] strArr3 = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr3[i2] = String.valueOf(list.get(i2));
        }
        return this.f27508a.update((String) this.d.get(cls), contentValues, str, strArr3);
    }

    public String b(String str) {
        return str + " desc";
    }

    public synchronized int a(Class cls, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        if (!a(cls) || (sQLiteDatabase = this.f27508a) == null) {
            return -1;
        }
        return sQLiteDatabase.delete((String) this.d.get(cls), str, strArr);
    }

    @Override // com.beizi.fusion.ja
    public int a(Class cls, String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        if (!a(cls) || (sQLiteDatabase = this.f27508a) == null) {
            return -1;
        }
        return sQLiteDatabase.delete((String) this.d.get(cls), e(str), new String[]{str2});
    }

    @Override // com.beizi.fusion.ja
    public synchronized int a(Class cls, long j) {
        return a(cls, d("id"), new String[]{String.valueOf(j)});
    }

    public synchronized int a(Class cls, long[] jArr) {
        if (jArr == null) {
            return -1;
        }
        if (jArr.length >= 2) {
            Arrays.sort(jArr);
            return a(cls, c("id"), new String[]{String.valueOf(jArr[0]), String.valueOf(jArr[jArr.length - 1])});
        }
        return b(cls, jArr);
    }

    public synchronized long[] a(Class cls, int i) {
        if (a(cls) && this.f27508a != null) {
            try {
                Cursor cursorQuery = this.f27508a.query((String) this.d.get(cls), new String[]{"id"}, null, null, null, null, null, String.valueOf(i));
                if (cursorQuery != null) {
                    try {
                        long[] jArr = new long[cursorQuery.getCount()];
                        int i2 = 0;
                        while (cursorQuery.moveToNext()) {
                            int i3 = i2 + 1;
                            jArr[i2] = cursorQuery.getLong(0);
                            i2 = i3;
                        }
                        cursorQuery.close();
                        return jArr;
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLException unused) {
            }
        }
        return null;
    }

    public synchronized int a(Class cls, String str, String[] strArr, String str2) {
        if (a(cls) && this.f27508a != null) {
            try {
                Cursor cursorQuery = this.f27508a.query((String) this.d.get(cls), new String[]{"id"}, str, strArr, null, null, str2, null);
                if (cursorQuery != null) {
                    try {
                        int count = cursorQuery.getCount();
                        cursorQuery.close();
                        return count;
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLException unused) {
            }
        }
        return 0;
    }

    @Override // com.beizi.fusion.ja
    public synchronized List a(Class cls, String str) {
        return a(cls, null, null, null, str, -1);
    }

    public synchronized List a(Class cls, String str, String[] strArr, String str2, int i) {
        return a(cls, null, str, strArr, str2, i);
    }

    public synchronized List a(Class cls, String[] strArr, String str, String[] strArr2, String str2, int i) {
        return a(cls, strArr, str, strArr2, null, str2, null, i);
    }

    public synchronized List a(Class cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, int i) {
        if (a(cls) && this.f27508a != null) {
            try {
                Cursor cursorQuery = this.f27508a.query((String) this.d.get(cls), strArr, str, strArr2, str2, str4, str3, i > 0 ? String.valueOf(i) : null);
                if (cursorQuery != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            try {
                                sb sbVar = (sb) cls.newInstance();
                                sbVar.parseFromDb(cursorQuery);
                                arrayList.add(sbVar);
                            } catch (IllegalAccessException | InstantiationException e) {
                                om.a(e);
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th) {
                        try {
                            cursorQuery.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.ja
    public String a(String str) {
        return str + " asc";
    }

    public String a(String str, int i) {
        StringBuilder sb = new StringBuilder(str + " IN ");
        sb.append("(");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("?");
            if (i2 < i - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        om.b("IBaseDbHelper", "各自处理 " + i + " " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        if (a(sQLiteDatabase, str)) {
            om.a("IBaseDbHelper", "表 " + str + " 已存在, 不再创建");
            return;
        }
        if (sQLiteDatabase == null || strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            om.a("IBaseDbHelper", "表 " + str + " 创建中...");
            sQLiteDatabase.beginTransaction();
            StringBuilder sb = new StringBuilder();
            sb.append("create table ");
            sb.append(str);
            sb.append("(");
            sb.append("id");
            sb.append(" integer primary key autoincrement, ");
            for (String str2 : strArr) {
                sb.append(" ");
                sb.append(str2);
                sb.append(" nvarchar, ");
            }
            sb.setCharAt(sb.lastIndexOf(","), ')');
            sQLiteDatabase.execSQL(sb.toString());
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            try {
                om.a(th);
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z = false;
        if (sQLiteDatabase != null) {
            Cursor cursorQuery = null;
            try {
                if (sQLiteDatabase.isOpen() && !TextUtils.isEmpty(str)) {
                    cursorQuery = sQLiteDatabase.query("sqlite_master", new String[]{"name"}, "type = ? and name = ?", new String[]{"table", str}, null, null, null);
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        z = true;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return z;
                }
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
        return false;
    }
}
