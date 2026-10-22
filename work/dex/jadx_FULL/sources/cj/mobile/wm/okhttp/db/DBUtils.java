package cj.mobile.wm.okhttp.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DBUtils {
    public static boolean isFieldExists(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z = false;
        if (str == null || sQLiteDatabase == null || str2 == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(dexc.dexa("TFMFDU!+!GSPN!") + str + dexc.dexa("!MJNJU!1"), null);
            if (cursorRawQuery != null && cursorRawQuery.getColumnIndex(str2) != -1) {
                z = true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return z;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
    }

    public static boolean isNeedUpgradeTable(SQLiteDatabase sQLiteDatabase, TableEntity tableEntity) {
        if (!isTableExists(sQLiteDatabase, tableEntity.tableName)) {
            return true;
        }
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(dexc.dexa("tfmfdu!+!gspn!") + tableEntity.tableName, null);
        if (cursorRawQuery == null) {
            return false;
        }
        try {
            int columnCount = tableEntity.getColumnCount();
            if (columnCount != cursorRawQuery.getColumnCount()) {
                return true;
            }
            for (int i = 0; i < columnCount; i++) {
                if (tableEntity.getColumnIndex(cursorRawQuery.getColumnName(i)) == -1) {
                    return true;
                }
            }
            return false;
        } finally {
            cursorRawQuery.close();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    public static boolean isTableExists(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        if (str == null || sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(dexc.dexa("TFMFDU!DPVOU)+*!GSPN!trmjuf`nbtufs!XIFSF!uzqf!>!@!BOE!obnf!>!@"), new String[]{dexc.dexa("ubcmf"), str});
            if (!cursorRawQuery.moveToFirst()) {
                cursorRawQuery.close();
                return false;
            }
            i = cursorRawQuery.getInt(0);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                i = 0;
                if (cursorRawQuery != null) {
                }
                if (i > 0) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th2;
            }
        }
        cursorRawQuery.close();
        if (i > 0) {
            return true;
        }
        return false;
    }
}
