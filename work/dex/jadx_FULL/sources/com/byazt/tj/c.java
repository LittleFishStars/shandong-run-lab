package com.byazt.tj;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.mg.da;
import com.byazt.nr.m;
import com.fl.saas.base.cache.DatabaseHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 762, 20})
public abstract class c<T> {
    public final String c = DatabaseHelper.COLUMN_ID;
    public final String tt;

    public c(String str) {
        this.tt = str;
    }

    public abstract ContentValues c(T t);

    public abstract HashMap<String, String> c();

    public void c(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.tt);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapC = c();
            if (mapC != null) {
                for (String str : mapC.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(mapC.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.tt, null, c(t));
        } catch (Exception e) {
            da.tt(e);
        }
    }
}
