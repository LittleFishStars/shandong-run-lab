package com.byazt.nq;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1006, 54})
public class ve {
    public static int c = 20;
    public static volatile ve tt;
    public volatile ConcurrentHashMap<String, com.byazt.ku.ve> n;
    public final Object ve = new Object();
    public final LruCache<String, c> uj = new LruCache<String, c>(c) { // from class: com.byazt.nq.ve.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, c cVar) {
            return 1;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f28846a = new AtomicBoolean(false);

    private ve() {
    }

    public static ve c() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    private void ve(String str) {
        if (!TextUtils.isEmpty(str) && this.uj.size() > 0) {
            synchronized (this.ve) {
                this.uj.remove(str);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00dd A[DONT_GENERATE] */
    public List<c> tt() {
        boolean z = this.f28846a.get();
        this.f28846a.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "ugen_template", null, null, null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        int columnIndex2 = cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                        int columnIndex3 = cursorQuery.getColumnIndex("url");
                        int columnIndex4 = cursorQuery.getColumnIndex("data");
                        int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                        if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                            int columnIndex6 = cursorQuery.getColumnIndex("rit");
                            String string = columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null;
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            String string4 = cursorQuery.getString(columnIndex3);
                            c cVarC = new c().c(string2).tt(string3).ve(string4).uj(cursorQuery.getString(columnIndex4)).n(string).c(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                            arrayList.add(cVarC);
                            synchronized (this.ve) {
                                this.uj.put(string2, cVarC);
                            }
                            if (!z) {
                                if (this.n == null) {
                                    this.n = new ConcurrentHashMap<>();
                                }
                                if (string2 != null && !this.n.contains(string2)) {
                                    this.n.put(string2, new com.byazt.ku.ve(string, string2, string3));
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                try {
                    m.ve("UGTmplDbHelper", "getUgenTemplate error", th);
                } finally {
                    cursorQuery.close();
                }
            }
        } else if (cursorQuery != null) {
        }
        return arrayList;
    }

    public static String ve() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)").toString();
    }

    public c c(String str, String str2) {
        c cVar;
        c cVarC;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.ve) {
            cVar = this.uj.get(str);
        }
        if (cVar != null) {
            if (TextUtils.equals(str2, cVar.tt())) {
                return cVar;
            }
            ve(str2);
            return null;
        }
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                do {
                    int columnIndex = cursorQuery.getColumnIndex("id");
                    int columnIndex2 = cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                    int columnIndex3 = cursorQuery.getColumnIndex("url");
                    int columnIndex4 = cursorQuery.getColumnIndex("data");
                    int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = cursorQuery.getColumnIndex("rit");
                        String string = cursorQuery.getString(columnIndex);
                        String string2 = cursorQuery.getString(columnIndex2);
                        cVarC = new c().c(string).tt(string2).uj(cursorQuery.getString(columnIndex4)).ve(cursorQuery.getString(columnIndex3)).n(columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null).c(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                        synchronized (this.ve) {
                            this.uj.put(string, cVarC);
                        }
                    }
                    cursorQuery.close();
                    return null;
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return cVarC;
            }
        } catch (Throwable th) {
            try {
                m.ve("UGTmplDbHelper", "getGgenTemplate error", th);
            } finally {
                cursorQuery.close();
            }
        }
        return null;
    }

    public void tt(String str) {
        com.byazt.ku.ve veVar;
        try {
            if (this.n == null || this.n.isEmpty() || (veVar = this.n.get(str)) == null) {
                return;
            }
            String strC = veVar.c();
            if (!TextUtils.isEmpty(strC)) {
                com.byazt.by.tt.c().delete(strC, str, true);
            }
            this.n.remove(str);
        } catch (Throwable unused) {
        }
    }

    public void c(c cVar, boolean z) {
        if (cVar == null || TextUtils.isEmpty(cVar.c())) {
            return;
        }
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "ugen_template", null, "id=?", new String[]{cVar.c()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        String string = null;
        if (z2) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", cVar.c());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, cVar.tt());
        contentValues.put("url", cVar.ve());
        contentValues.put("data", cVar.n());
        contentValues.put("rit", cVar.a());
        contentValues.put("update_time", cVar.uj());
        if (z2) {
            com.byazt.pe.c.update(gt.getContext(), "ugen_template", contentValues, "id=?", new String[]{cVar.c()});
        } else {
            com.byazt.pe.c.insert(gt.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.ve) {
            this.uj.put(cVar.c(), cVar);
        }
        if (z) {
            return;
        }
        try {
            if (this.n == null) {
                this.n = new ConcurrentHashMap<>();
            }
            com.byazt.ku.ve veVar = new com.byazt.ku.ve(cVar.a(), cVar.c(), cVar.tt());
            this.n.put(cVar.c(), veVar);
            if (string != null) {
                com.byazt.by.tt.c().delete(string, veVar.tt(), true);
            }
            com.byazt.by.tt.c().update(cVar.a(), veVar, true);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00cb A[DONT_GENERATE] */
    public Set<c> c(String str) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        if (columnIndex != -1) {
                            String string = cursorQuery.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.ve) {
                                    cVar = this.uj.get(string);
                                }
                                if (cVar != null) {
                                    hashSet.add(cVar);
                                } else {
                                    c cVar2 = new c();
                                    int columnIndex2 = cursorQuery.getColumnIndex("data");
                                    if (columnIndex2 != -1) {
                                        String string2 = cursorQuery.getString(columnIndex2);
                                        if (!TextUtils.isEmpty(string2)) {
                                            cVar2.uj(string2);
                                            cVar2.c(string);
                                            cVar2.n(str);
                                            int columnIndex3 = cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
                                            int columnIndex4 = cursorQuery.getColumnIndex("url");
                                            int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                                            if (columnIndex3 != -1) {
                                                cVar2.tt(cursorQuery.getString(columnIndex3));
                                            }
                                            if (columnIndex4 != -1) {
                                                cVar2.ve(cursorQuery.getString(columnIndex4));
                                            }
                                            if (columnIndex5 != -1) {
                                                cVar2.c(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                                            }
                                            hashSet.add(cVar2);
                                            synchronized (this.ve) {
                                                this.uj.put(string, cVar2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
                try {
                    m.ve("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
                } finally {
                    cursorQuery.close();
                }
            }
        } else if (cursorQuery != null) {
        }
        return hashSet;
    }

    public void c(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                ve(strArr[i]);
                com.byazt.pe.c.delete(gt.getContext(), "ugen_template", "id=?", new String[]{strArr[i]});
                tt(strArr[i]);
            }
        }
    }
}
