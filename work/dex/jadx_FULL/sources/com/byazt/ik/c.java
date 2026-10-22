package com.byazt.ik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2058, 20})
public class c extends SQLiteOpenHelper {
    public static String c = "c";

    public c(@Nullable Context context) {
        super(new com.byazt.nys.c(context), "mediation_behavior.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gromore_prime_rit_adn_perform (id INTEGER PRIMARY KEY AUTOINCREMENT, adn_name TEXT NOT NULL , prime_rit TEXT NOT NULL , adn_rit TEXT NOT NULL ,ad_action TEXT NOT NULL ,time_stamp LONG DEFAULT 0)");
    }

    private void tt(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gromore_prime_rit_adn_perform ;");
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
            com.byazt.eu.tt.c(c, "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
            if (i <= i2) {
                c(sQLiteDatabase);
                return;
            }
            tt(sQLiteDatabase);
            c(sQLiteDatabase);
            com.byazt.eu.tt.c(c, "onUpgrade...Reverse installation Database reset - create table.....");
        } catch (Throwable unused) {
        }
    }

    public void c(ContentValues contentValues) {
        if (contentValues != null) {
            String asString = contentValues.getAsString(MediationConstant.EXTRA_ADN_NAME);
            String asString2 = contentValues.getAsString(MediationConstant.KEY_GM_PRIME_RIT);
            String asString3 = contentValues.getAsString("adn_rit");
            String asString4 = contentValues.getAsString("ad_action");
            long jLongValue = contentValues.getAsLong("time_stamp").longValue();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(MediationConstant.EXTRA_ADN_NAME, asString);
            contentValues2.put(MediationConstant.KEY_GM_PRIME_RIT, asString2);
            contentValues2.put("adn_rit", asString3);
            contentValues2.put("ad_action", asString4);
            contentValues2.put("time_stamp", Long.valueOf(jLongValue));
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        writableDatabase.insert("gromore_prime_rit_adn_perform", null, contentValues2);
                        writableDatabase.close();
                    }
                } catch (IllegalStateException unused) {
                }
            }
        }
    }

    public void tt(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("gromore_prime_rit_adn_perform", str, strArr);
        writableDatabase.close();
    }

    public Cursor c(String str, String[] strArr) {
        return getReadableDatabase().query("gromore_prime_rit_adn_perform", null, str, strArr, null, null, null);
    }
}
