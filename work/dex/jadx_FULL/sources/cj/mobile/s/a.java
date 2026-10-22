package cj.mobile.s;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cj.mobile.q.n;
import com.fl.saas.base.cache.DatabaseHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a extends SQLiteOpenHelper implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f22666a = {DatabaseHelper.COLUMN_ID, "url", "length", "mime"};

    public a(Context context) {
    }

    @Override // cj.mobile.s.c
    public n a(String str) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // cj.mobile.s.c
    public void a(String str, n nVar) {
    }

    public final n a(Cursor cursor) {
    }

    public final ContentValues a(n nVar) {
    }
}
