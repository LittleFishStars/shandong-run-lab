package com.byazt.ue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.omf.gt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1265, 34})
public class a implements com.byazt.sq.uj.c {
    public static volatile a c;
    public static WeakReference<Context> tt;
    public static List<com.byazt.sq.uj.c> ve;

    static {
        List<com.byazt.sq.uj.c> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        ve = listSynchronizedList;
        listSynchronizedList.add(new ve());
        ve.add(new com.byazt.pe.tt());
        ve.add(new com.byazt.rr.c());
        ve.add(new c(new com.byazt.xm.c("csj")));
        Iterator<com.byazt.sq.uj.c> it = ve.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    private a() {
    }

    public static a c(Context context) {
        if (context != null) {
            tt = new WeakReference<>(context.getApplicationContext());
        }
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private Context getContext() {
        WeakReference<Context> weakReference = tt;
        return (weakReference == null || weakReference.get() == null) ? gt.getContext() : tt.get();
    }

    private boolean tt(Uri uri) {
        return true;
    }

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            com.byazt.sq.uj.c cVarC = c(uri);
            if (cVarC != null) {
                return cVarC.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        return "";
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        try {
            com.byazt.sq.uj.c cVarC = c(uri);
            if (cVarC != null) {
                return cVarC.getType(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
        Iterator<com.byazt.sq.uj.c> it = ve.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            com.byazt.sq.uj.c cVarC = c(uri);
            if (cVarC != null) {
                return cVarC.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            com.byazt.sq.uj.c cVarC = c(uri);
            if (cVarC != null) {
                return cVarC.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            com.byazt.sq.uj.c cVarC = c(uri);
            if (cVarC != null) {
                return cVarC.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private com.byazt.sq.uj.c c(Uri uri) {
        if (uri == null || !tt(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split(WVNativeCallbackUtil.SEPERATER);
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.sq.uj.c cVar : ve) {
            if (str.equals(cVar.getTableName())) {
                return cVar;
            }
        }
        return null;
    }
}
