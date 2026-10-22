package com.byazt.non;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.nr.m;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, UserConstants.MODIFY_PHONE_ERROR_CODE.c, 20})
public class c extends ve {
    public c(Context context) {
        super(context, "ttopensdk2.db", 4);
    }

    @Override // com.byazt.non.ve
    public void c(SQLiteDatabase sQLiteDatabase, Context context) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sdk_launch (id INTEGER PRIMARY KEY AUTOINCREMENT,dev1 INTEGER,dev2 INTEGER,dev3 INTEGER,dev4 INTEGER,dev5 INTEGER,dev6 INTEGER,dev7 INTEGER,dev8 INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS union_meta_cache (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,uuid TEXT,create_time TEXT,meta_data TEXT,save_version TEXT,expire_time TEXT,slot_type TEXT,is_using INTEGER,priority TEXT,ad_index INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS meta_req_record_v1 (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,appid TEXT,slot_type TEXT,create_time TEXT,status TEXT,cache_type TEXT,event_type TEXT,request_count INTEGER,response_count INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS dpl_status_record (id INTEGER PRIMARY KEY AUTOINCREMENT,create_time TEXT,status TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS union_tmax_record (id INTEGER PRIMARY KEY AUTOINCREMENT,load_id TEXT UNIQUE,ad_slot_type INTEGER,ad_slot_id TEXT,loaded_duration INTEGER DEFAULT 0,cached_duration INTEGER DEFAULT 0,shown_duration INTEGER DEFAULT 0,is_shown INTEGER DEFAULT 0,record_time INTEGER DEFAULT 0)");
    }

    @Override // com.byazt.non.ve, android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            c(sQLiteDatabase, this.c);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    @Override // com.byazt.non.ve, android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.byazt.non.ve, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            c(sQLiteDatabase, this.c);
        } catch (Exception unused) {
        }
    }
}
