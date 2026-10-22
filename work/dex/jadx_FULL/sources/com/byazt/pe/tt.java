package com.byazt.pe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.omf.gt;
import com.byazt.sq.uj;
import com.byazt.yws.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1306, 13})
public class tt implements uj.c {
    public Context c;

    private boolean c(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    private Context getContext() {
        Context context = this.c;
        return context == null ? gt.getContext() : context;
    }

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (!c(uri) && (strArrSplit = uri.getPath().split(WVNativeCallbackUtil.SEPERATER)) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            com.byazt.yws.uj ujVarC = c(str2);
            if (ujVarC != null) {
                ujVarC.delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        return "t_db";
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        String[] strArrSplit;
        if (!c(uri) && (strArrSplit = uri.getPath().split(WVNativeCallbackUtil.SEPERATER)) != null && strArrSplit.length >= 5) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[4];
            com.byazt.yws.uj ujVarC = c(str);
            if (ujVarC != null) {
                if ("execSQL".equals(str2)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        ujVarC.c(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str2)) {
                    ujVarC.ve();
                } else if ("transactionSetSuccess".equals(str2)) {
                    ujVarC.uj();
                } else if ("transactionEnd".equals(str2)) {
                    ujVarC.n();
                }
            }
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
        this.c = context;
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) throws Exception {
        String[] strArrSplit;
        if (!c(uri) && (strArrSplit = uri.getPath().split(WVNativeCallbackUtil.SEPERATER)) != null && strArrSplit.length >= 4) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[3];
            com.byazt.yws.uj ujVarC = c(str);
            if (ujVarC != null) {
                ujVarC.insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (c(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split(WVNativeCallbackUtil.SEPERATER);
        if (strArrSplit == null || strArrSplit.length < 4) {
            return null;
        }
        String str3 = strArrSplit[2];
        String str4 = strArrSplit[3];
        com.byazt.yws.uj ujVarC = c(str3);
        if (ujVarC != null) {
            return ujVarC.query(str4, strArr, str, strArr2, null, null, str2);
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (!c(uri) && (strArrSplit = uri.getPath().split(WVNativeCallbackUtil.SEPERATER)) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            com.byazt.yws.uj ujVarC = c(str2);
            if (ujVarC != null) {
                ujVarC.update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }

    private com.byazt.yws.uj c(String str) {
        if ("ttopensdk.db".equals(str)) {
            return ve.c(getContext()).c();
        }
        if ("ttopensdk2.db".equals(str)) {
            return com.byazt.yws.c.c(getContext()).c();
        }
        return null;
    }
}
