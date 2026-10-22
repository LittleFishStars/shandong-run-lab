package com.byazt.emg;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.bwm.x;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROE_OPENSDK_UNKNOWN_ERR, 54})
public final class ve {
    public static volatile ve tt;
    public final SparseArray<Map<String, c>> c;
    public volatile SQLiteStatement n;
    public final Executor uj;
    public final uj ve;

    private ve(Context context) {
        SparseArray<Map<String, c>> sparseArray = new SparseArray<>(2);
        this.c = sparseArray;
        this.uj = new com.byazt.jtc.uj(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new x("/VideoProxyDB"));
        this.ve = new uj(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public void delete(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, c> map = this.c.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.uj.execute(new Runnable() { // from class: com.byazt.emg.ve.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ve.this.ve.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void insert(final c cVar) {
        if (cVar != null) {
            Map<String, c> map = this.c.get(cVar.uj);
            if (map != null) {
                map.put(cVar.c, cVar);
            }
            this.uj.execute(new Runnable() { // from class: com.byazt.emg.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ve.this.n == null) {
                            ve veVar = ve.this;
                            veVar.n = veVar.ve.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            ve.this.n.clearBindings();
                        }
                        ve.this.n.bindString(1, cVar.c);
                        ve.this.n.bindString(2, cVar.tt);
                        ve.this.n.bindLong(3, cVar.ve);
                        ve.this.n.bindLong(4, cVar.uj);
                        ve.this.n.bindString(5, cVar.n);
                        ve.this.n.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public c query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, c> map = this.c.get(i);
        c cVar = map == null ? null : map.get(str);
        if (cVar != null) {
            return cVar;
        }
        try {
            Cursor cursorQuery = this.ve.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    int columnIndex = cursorQuery.getColumnIndex(CachedContentIndex.a.e);
                    String string = columnIndex != -1 ? cursorQuery.getString(columnIndex) : null;
                    int columnIndex2 = cursorQuery.getColumnIndex("mime");
                    String string2 = columnIndex2 != -1 ? cursorQuery.getString(columnIndex2) : null;
                    int columnIndex3 = cursorQuery.getColumnIndex("contentLength");
                    int i2 = columnIndex3 != -1 ? cursorQuery.getInt(columnIndex3) : -1;
                    int columnIndex4 = cursorQuery.getColumnIndex("extra");
                    cVar = new c(string, string2, i2, i, columnIndex4 != -1 ? cursorQuery.getString(columnIndex4) : null);
                }
                cursorQuery.close();
            }
            if (cVar != null && map != null) {
                map.put(str, cVar);
            }
            return cVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String tt(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static ve c(Context context) {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve(context);
                }
            }
        }
        return tt;
    }

    public void c(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, c> map = this.c.get(i);
        int i2 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.ve.getWritableDatabase().delete("video_http_header_t", "key IN(" + tt(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void c(final int i) {
        Map<String, c> map = this.c.get(i);
        if (map != null) {
            map.clear();
        }
        this.uj.execute(new Runnable() { // from class: com.byazt.emg.ve.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ve.this.ve.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
