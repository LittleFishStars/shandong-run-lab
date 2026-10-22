package com.byazt.yb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.byazt.sq.uj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 894, 13})
public class tt implements uj.c {
    public static volatile tt c;
    public c tt = new c();

    private tt() {
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) {
        return this.tt.delete(uri, str, strArr);
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        return "";
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        return this.tt.getType(uri);
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.tt.insert(uri, contentValues);
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.tt.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.tt.update(uri, contentValues, str, strArr);
    }
}
