package com.byazt.yb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.byazt.sq.uj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 894, 54})
public class ve implements uj.c {
    public com.byazt.ik.c c;

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) {
        com.byazt.ik.c cVar = this.c;
        if (cVar == null) {
            return 0;
        }
        cVar.tt(str, strArr);
        return 1;
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        return "gromore_prime_rit_adn_perform";
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
        if (com.byazt.bp.tt.getContext() != null) {
            this.c = new com.byazt.ik.c(com.byazt.bp.tt.getContext());
        }
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.byazt.ik.c cVar = this.c;
        if (cVar == null) {
            return null;
        }
        cVar.c(contentValues);
        return uri;
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, @Nullable String str, @Nullable String[] strArr2, String str2) {
        com.byazt.ik.c cVar = this.c;
        if (cVar != null) {
            return cVar.c(str, strArr2);
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
