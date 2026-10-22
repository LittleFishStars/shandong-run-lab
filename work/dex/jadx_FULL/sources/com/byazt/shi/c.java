package com.byazt.shi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.byazt.twu.sp;
import com.byazt.twu.uj;
import com.byazt.vb.a;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 991, 20})
public class c extends SQLiteOpenHelper {
    public final Context c;
    public a tt;

    public c(Context context, a aVar) {
        super(new com.byazt.nys.c(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.c = context;
        this.tt = aVar;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.byazt.twu.a.uj(this.tt.tt()));
        sQLiteDatabase.execSQL(uj.tt(this.tt.c()));
        sQLiteDatabase.execSQL(sp.uj(this.tt.uj()));
        sQLiteDatabase.execSQL(com.byazt.twu.c.tt(this.tt.n()));
        sQLiteDatabase.execSQL(com.byazt.pvs.a.tt());
    }

    private void tt(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListVe = ve(sQLiteDatabase);
        if (arrayListVe == null || arrayListVe.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListVe.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> ve(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            c(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i <= i2) {
                c(sQLiteDatabase);
            } else {
                tt(sQLiteDatabase);
                c(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}
