package com.byazt.ue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1265, 20})
public class c implements com.byazt.sq.uj.c {
    public com.byazt.xm.c c;

    public c(com.byazt.xm.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) {
        com.byazt.xm.c cVar = this.c;
        if (cVar != null) {
            return cVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        com.byazt.xm.c cVar = this.c;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        com.byazt.xm.c cVar = this.c;
        if (cVar != null) {
            return cVar.getType(uri);
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
        com.byazt.xm.c cVar = this.c;
        if (cVar != null) {
            cVar.c(context);
        }
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.byazt.xm.c cVar = this.c;
        if (cVar != null) {
            return cVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.byazt.xm.c cVar = this.c;
        if (cVar != null) {
            return cVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.byazt.xm.c cVar = this.c;
        if (cVar != null) {
            return cVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
