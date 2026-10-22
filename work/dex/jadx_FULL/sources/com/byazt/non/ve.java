package com.byazt.non;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.huachenjie.common.constants.UserConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, UserConstants.MODIFY_PHONE_ERROR_CODE.c, 54})
public abstract class ve extends SQLiteOpenHelper {
    public final Context c;
    public final String tt;

    public ve(Context context, String str, int i) {
        super(new com.byazt.nys.c(context), str, (SQLiteDatabase.CursorFactory) null, i);
        this.tt = "CSJSQLiteOpenHelper";
        this.c = context;
    }

    private ArrayList<String> tt(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!TextUtils.equals(string, "android_metadata") && !TextUtils.equals(string, "sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListTt = tt(sQLiteDatabase);
        if (arrayListTt == null || arrayListTt.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListTt.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void c(SQLiteDatabase sQLiteDatabase, Context context) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            c(sQLiteDatabase, this.c);
        } catch (Throwable th) {
            m.uj("CSJSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            c(sQLiteDatabase);
            c(sQLiteDatabase, this.c);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            try {
                c(sQLiteDatabase);
            } catch (Throwable th) {
                m.uj("CSJSQLiteOpenHelper", th.getMessage());
                return;
            }
        }
        c(sQLiteDatabase, this.c);
        c(sQLiteDatabase, i, i2);
    }
}
