package com.zj.adlib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amap.api.col.p0003l.gv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class k7b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f42757a = true;
    public static boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gv f17600a;

    public k7b(Context context, String str, int i, gv gvVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f17600a = gvVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f17600a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f17600a.a(sQLiteDatabase, i);
    }
}
