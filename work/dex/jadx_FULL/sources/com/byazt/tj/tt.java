package com.byazt.tj;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.mg.da;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 762, 13})
public class tt extends c<com.byazt.bk.c> {
    public tt() {
        super("duplicatelog");
    }

    public boolean c(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                Cursor cursorQuery = sQLiteDatabase.query(this.tt, null, "path=?", new String[]{str}, null, null, null);
                count = cursorQuery.getCount();
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                    e = e;
                    da.tt(e);
                }
            } catch (Exception e2) {
                e = e2;
                count = 0;
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.tj.c
    public void insert(SQLiteDatabase sQLiteDatabase, com.byazt.bk.c cVar) {
        if (cVar == null || c(sQLiteDatabase, cVar.c)) {
            return;
        }
        super.insert(sQLiteDatabase, cVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.tt + " where _id in (select _id from " + this.tt + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            da.tt(e);
        }
    }

    @Override // com.byazt.tj.c
    public HashMap<String, String> c() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    @Override // com.byazt.tj.c
    public ContentValues c(com.byazt.bk.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", cVar.c);
        contentValues.put("insert_time", Long.valueOf(cVar.tt));
        return contentValues;
    }
}
