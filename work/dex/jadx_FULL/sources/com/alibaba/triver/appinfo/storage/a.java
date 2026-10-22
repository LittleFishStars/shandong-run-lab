package com.alibaba.triver.appinfo.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24643a = "app_info_center";
    private static final int b = 1;

    public a(@Nullable Context context) {
        super(context, f24643a, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TriverDBProxy.CREATE_APP_INFO_TABLE_SQL);
        sQLiteDatabase.execSQL(TriverDBProxy.CREATE_PLUGIN_INFO_TABLE_SQL);
        sQLiteDatabase.execSQL(TriverDBProxy.CREATE_PLUGIN_SUBSCRIPTION_TABLE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
