package com.getui.gtc.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.db.AbstractTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class d extends AbstractTable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30352a;
    public String b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public long j;
    public long k;
    public long l;
    public long m;
    public final Set<String> n = new HashSet();

    private String a(int i) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = getReadableDatabase().query("r", new String[]{"a", "b"}, "a=?", new String[]{String.valueOf(i)}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(1);
                cursorQuery.close();
                return string;
            }
            if (cursorQuery == null) {
                return "";
            }
        } catch (Throwable th) {
            try {
                com.getui.gtc.i.c.a.b(th);
                if (cursorQuery == null) {
                    return "";
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return "";
    }

    public final JSONObject a() {
        try {
            String strA = a(18);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return new JSONObject(new String(SecureCryptTools.getInstance().decrypt(Base64.decode(strA, 0))));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return null;
        }
    }

    public final void a(String str) {
        if (a(10, str)) {
            this.f = str;
        }
    }

    public final void a(Collection<String> collection) {
        if (collection.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.n);
        arrayList.addAll(collection);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        if (a(8, sb.toString())) {
            this.n.addAll(collection);
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    a(18, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(jSONObject.toString().getBytes()), 0));
                    return;
                }
            } catch (Throwable th) {
                com.getui.gtc.i.c.a.c(th);
                return;
            }
        }
        a(18, "");
    }

    public final boolean a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("a", Integer.valueOf(i));
        contentValues.put("b", Long.valueOf(j));
        return replace(null, contentValues) != -1;
    }

    public final boolean a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("a", Integer.valueOf(i));
        contentValues.put("b", str);
        return replace(null, contentValues) != -1;
    }

    public final JSONObject b() {
        try {
            String strA = a(17);
            if (!TextUtils.isEmpty(strA)) {
                return new JSONObject(new String(SecureCryptTools.getInstance().decrypt(Base64.decode(strA, 0))));
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
        return new JSONObject();
    }

    public final void b(String str) {
        try {
            if (a(11, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(str.getBytes()), 0))) {
                this.g = str;
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    public final void b(JSONObject jSONObject) {
        try {
            a(17, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(jSONObject.toString().getBytes()), 0));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    public final void c(String str) {
        try {
            if (a(12, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(str.getBytes()), 0))) {
                this.h = str;
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String createSql() {
        return "CREATE TABLE IF NOT EXISTS r (a TEXT PRIMARY KEY, b TEXT)";
    }

    public final void d(String str) {
        if (a(7, str)) {
            this.f30352a = str;
        }
    }

    public final void e(String str) {
        if (a(20, str)) {
            this.b = str;
        }
    }

    public final void f(String str) {
        if (TextUtils.isEmpty(str) || !this.n.contains(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.n);
        arrayList.remove(str);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        if (a(8, sb.toString())) {
            this.n.remove(str);
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String getTableName() {
        return "r";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void initCache() {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("r", new String[]{"a", "b"}, null, null, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        switch (cursorQuery.getInt(0)) {
                            case 4:
                                this.d = cursorQuery.getString(1);
                                break;
                            case 6:
                                this.c = cursorQuery.getLong(1);
                                break;
                            case 7:
                                this.f30352a = cursorQuery.getString(1);
                                break;
                            case 8:
                                String string = cursorQuery.getString(1);
                                if (!TextUtils.isEmpty(string)) {
                                    this.n.addAll(Arrays.asList(string.split(",")));
                                }
                                break;
                            case 9:
                                this.e = cursorQuery.getString(1);
                                break;
                            case 10:
                                this.f = cursorQuery.getString(1);
                                break;
                            case 11:
                                try {
                                    String string2 = cursorQuery.getString(1);
                                    if (!TextUtils.isEmpty(string2)) {
                                        this.g = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(string2, 0)));
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    com.getui.gtc.i.c.a.c(th);
                                }
                                break;
                            case 12:
                                try {
                                    String string3 = cursorQuery.getString(1);
                                    if (!TextUtils.isEmpty(string3)) {
                                        this.h = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(string3, 0)));
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.getui.gtc.i.c.a.c(th);
                                }
                                break;
                            case 13:
                                try {
                                    String string4 = cursorQuery.getString(1);
                                    if (!TextUtils.isEmpty(string4)) {
                                        this.i = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(string4, 0)));
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    com.getui.gtc.i.c.a.c(th);
                                }
                                break;
                            case 14:
                                this.j = cursorQuery.getLong(1);
                                break;
                            case 15:
                                this.k = cursorQuery.getLong(1);
                                break;
                            case 16:
                                this.l = cursorQuery.getLong(1);
                                break;
                            case 19:
                                this.m = cursorQuery.getLong(1);
                                this.l = cursorQuery.getLong(1);
                                break;
                            case 20:
                                this.b = cursorQuery.getString(1);
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                com.getui.gtc.i.c.a.b(e);
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
