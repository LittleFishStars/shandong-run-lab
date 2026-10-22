package com.byazt.ue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1265, 54})
public class ve implements com.byazt.sq.uj.c {
    public com.byazt.ti.uj c = new com.byazt.ti.uj();

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) {
        return this.c.delete(uri, str, strArr);
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        return this.c.c();
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        return this.c.getType(uri);
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.c.insert(uri, contentValues);
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.c.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.c.update(uri, contentValues, str, strArr);
    }
}
