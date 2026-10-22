package com.getui.gtc.dyc;

import android.content.ContentValues;
import android.database.Cursor;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.db.AbstractDb;
import com.getui.gtc.base.db.AbstractTable;
import com.getui.gtc.base.db.DbManager;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class c {

    public static class a extends AbstractDb {
        @Override // com.getui.gtc.base.db.AbstractDb
        public String getDbName() {
            return "cg.db";
        }

        @Override // com.getui.gtc.base.db.AbstractDb
        public int getVersion() {
            return 1;
        }
    }

    /* JADX INFO: renamed from: com.getui.gtc.dyc.c$c, reason: collision with other inner class name */
    public static class C0656c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f30339a = new c();
    }

    public static class d extends AbstractTable {
        @Override // com.getui.gtc.base.db.AbstractTable
        public String createSql() {
            return "CREATE TABLE IF NOT EXISTS sct (v TEXT PRIMARY KEY, c TEXT)";
        }

        @Override // com.getui.gtc.base.db.AbstractTable
        public String getTableName() {
            return "sct";
        }
    }

    private c() {
        try {
            DbManager.init(GtcProvider.context(), a.class, d.class);
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
        }
    }

    public static c a() {
        return C0656c.f30339a;
    }

    public h a(String str) {
        Cursor cursorQuery = ((d) DbManager.getTable(a.class, d.class)).query(new String[]{"c"}, "v=?", new String[]{str});
        h hVarE = null;
        if (cursorQuery == null) {
            return null;
        }
        if (cursorQuery.moveToNext()) {
            try {
                hVarE = h.e(cursorQuery.getString(cursorQuery.getColumnIndex("c")));
            } catch (Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
            }
        }
        cursorQuery.close();
        return hVarE;
    }

    public boolean a(String str, h hVar) {
        try {
            String strG = hVar.g();
            ContentValues contentValues = new ContentValues();
            contentValues.put("v", str);
            contentValues.put("c", strG);
            return ((d) DbManager.getTable(a.class, d.class)).replace(null, contentValues) != -1;
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
            return false;
        }
    }

    public HashMap<String, h> c() {
        Cursor cursorQuery = ((d) DbManager.getTable(a.class, d.class)).query(new String[]{"v", "c"}, null, null);
        if (cursorQuery == null) {
            return null;
        }
        HashMap<String, h> map = new HashMap<>();
        while (cursorQuery.moveToNext()) {
            try {
                map.put(cursorQuery.getString(cursorQuery.getColumnIndex("v")), h.e(cursorQuery.getString(cursorQuery.getColumnIndex("c"))));
            } catch (Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
            }
        }
        cursorQuery.close();
        return map;
    }
}
