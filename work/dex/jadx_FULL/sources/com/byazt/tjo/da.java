package com.byazt.tjo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 72})
public class da implements com.byazt.sq.uj.c {
    public com.byazt.sq.uj.c c;
    public com.byazt.sq.uj.c tt = com.byazt.yb.tt.c();

    public da(com.byazt.sq.uj.c cVar) {
        this.c = cVar;
    }

    private boolean c(Uri uri) {
        if (uri == null) {
            return false;
        }
        String[] strArrSplit = uri.getPath().split(WVNativeCallbackUtil.SEPERATER);
        if (strArrSplit.length < 2) {
            return false;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("gromore");
    }

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) {
        return c(uri) ? this.tt.delete(uri, str, strArr) : this.c.delete(uri, str, strArr);
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        return "";
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        return (c(uri) ? this.tt : this.c).getType(uri);
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
        com.byazt.sq.uj.c cVar = this.c;
        if (cVar != null) {
            cVar.injectContext(context);
        }
        com.byazt.sq.uj.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.injectContext(context);
        }
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) {
        return c(uri) ? this.tt.insert(uri, contentValues) : this.c.insert(uri, contentValues);
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return c(uri) ? this.tt.query(uri, strArr, str, strArr2, str2) : this.c.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return c(uri) ? this.tt.update(uri, contentValues, str, strArr) : this.c.update(uri, contentValues, str, strArr);
    }
}
